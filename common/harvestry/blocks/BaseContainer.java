package harvestry.blocks;

import harvestry.Harvestry;
import harvestry.blocks.te.GrinderTE;
import harvestry.utils.Archive;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaseContainer extends BlockContainer {

    private int tileID;

    /**
     * Creates a new Block instance capable of containing a Tile Entity
     * 
     * @param id
     *            The Block ID.
     * @param tileID
     *            The Tile Entity for it to create.
     *            0 is {@link GrinderTE}
     */
    protected BaseContainer(int id, int tileID) {
        super(id, Material.ground);
        setCreativeTab(Harvestry.tabHarvestry);
        this.tileID = tileID;
    }

    /**
     * Creates a new Block instance capable of containing a Tile Entity
     * 
     * @param id
     *            The Block ID.
     * @param material
     *            The Material of the Block.
     * @param tileID
     *            The Tile Entity for it to create.
     *            0 is {@link GrinderTE}
     */
    protected BaseContainer(int id, Material material, int tileID) {
        super(id, material);
        this.tileID = tileID;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        switch (tileID) {
            case 0:
                return new GrinderTE();
            default:
                return null;
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving living,
            ItemStack stack) {
        // gets side facing player
        int meta = BlockPistonBase.determineOrientation(world, x, y, z, living);

        // reverse direction
        meta = ForgeDirection.getOrientation(meta).getOpposite().ordinal();

        if (meta == 1){
            meta = 0;
        }

        world.setBlockMetadataWithNotify(x, y, z, meta, 3);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int wut,
            float clickX, float clickY, float clockZ) {
        if (!player.isSneaking() || !world.isRemote){
            switch (tileID) {
                case 0:
                    GrinderTE grinder = (GrinderTE) world.getBlockTileEntity(x, y, z);
                    if (grinder != null){
                        player.openGui(Harvestry.instance, Archive.grinderGUID, world, x, y, z);
                        return true;
                    }
                default:
                    return false;
            }
        }
        return true;
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