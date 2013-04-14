package harvestry.blocks;

import harvestry.Harvestry;
import harvestry.blocks.te.BaseTE;
import harvestry.blocks.te.GrinderTE;
import harvestry.blocks.te.OvenTE;
import harvestry.utils.Archive;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaseContainer extends BlockContainer {

    /**
     * Is the random generator used by all Containers to drop the inventory
     * contents in
     * random directions.
     */
    private Random rand = new Random();

    /**
     * Used to decide witch {@link TileEntity} to use.
     */
    private int tileID;

    /**
     * Creates a new Block instance capable of containing a {@link TileEntity}.
     * 
     * @param id
     *            The Block ID.
     * @param tileID
     *            The {@link TileEntity} for it to create.
     *            0 is {@link GrinderTE}.
     *            1 is {@link OvenTE}.
     */
    public BaseContainer(int id, int tileID) {
        super(id, Material.ground);
        setCreativeTab(Harvestry.tabHarvestry);
        this.tileID = tileID;
    }

    /**
     * Creates a new Block instance capable of containing a {@link TileEntity}.
     * 
     * @param id
     *            The Block ID.
     * @param material
     *            The Material of the Block.
     * @param tileID
     *            The {@link TileEntity} for it to create.
     *            0 is {@link GrinderTE}.
     *            1 is {@link OvenTE}.
     */
    public BaseContainer(int id, Material material, int tileID) {
        super(id, material);
        setCreativeTab(Harvestry.tabHarvestry);
        this.tileID = tileID;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        switch (tileID) {
            case Archive.grinderGUID:
                return new GrinderTE();
            case Archive.ovenGUID:
                return new OvenTE();
            default:
                return null;
        }
    }

    /**
     * Sets the direction of the block when placed
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving,
            ItemStack itemStack) {
        
        int direction = 0;
        int facing = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

        if (facing == 0){
            direction = ForgeDirection.NORTH.ordinal();
        }else if (facing == 1){
            direction = ForgeDirection.EAST.ordinal();
        }else if (facing == 2){
            direction = ForgeDirection.SOUTH.ordinal();
        }else if (facing == 3){
            direction = ForgeDirection.WEST.ordinal();
        }

        world.setBlockMetadataWithNotify(x, y, z, direction, 3);

        if (itemStack.hasDisplayName()){
            ((BaseTE) world.getBlockTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
        }

        ((BaseTE) world.getBlockTileEntity(x, y, z)).setOwner(entityLiving.getEntityName());
        ((BaseTE) world.getBlockTileEntity(x, y, z)).setOrientation(direction);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int wut,
            float clickX, float clickY, float clockZ) {
        if (!player.isSneaking() && !world.isRemote){
            switch (tileID) {
                case Archive.grinderGUID:
                    GrinderTE grinder = (GrinderTE) world.getBlockTileEntity(x, y, z);
                    if (grinder != null){
                        player.openGui(Harvestry.instance, Archive.grinderGUID, world, x, y, z);
                        return true;
                    }
                case Archive.ovenGUID:
                    OvenTE oven = (OvenTE) world.getBlockTileEntity(x, y, z);
                    if (oven != null){
                        player.openGui(Harvestry.instance, Archive.ovenGUID, world, x, y, z);
                        return true;
                    }
                default:
                    return false;
            }
        }
        return false;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int id, int meta) {

        dropInventory(world, x, y, z);
        super.breakBlock(world, x, y, z, id, meta);
    }

    /**
     * Drops the Inventory that is contained in the {@link TileEntity}.
     * 
     * @param world
     *            The world in witch to drop the Items in.
     * @param x
     *            The x location
     * @param y
     *            The y location.
     * @param z
     *            The z location.
     */
    private void dropInventory(World world, int x, int y, int z) {

        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

        if (!(tileEntity instanceof IInventory))
            return;

        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++){

            ItemStack itemStack = inventory.getStackInSlot(i);

            if (itemStack != null && itemStack.stackSize > 0){
                float dX = rand.nextFloat() * 0.8F + 0.1F;
                float dY = rand.nextFloat() * 0.8F + 0.1F;
                float dZ = rand.nextFloat() * 0.8F + 0.1F;

                EntityItem entityItem = new EntityItem(world, x + dX, y + dY, z + dZ,
                        new ItemStack(itemStack.itemID, itemStack.stackSize,
                                itemStack.getItemDamage()));

                if (itemStack.hasTagCompound()){
                    entityItem.getEntityItem().setTagCompound(
                            (NBTTagCompound) itemStack.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                itemStack.stackSize = 0;
            }
        }
    }

    /**
     * Registers the Icon for the Block
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Archive.texture + this.getUnlocalizedName2());
    }
}