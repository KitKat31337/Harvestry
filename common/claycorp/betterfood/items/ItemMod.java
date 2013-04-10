package claycorp.betterfood.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import claycorp.betterfood.BetterFood;
import claycorp.betterfood.utils.Archive;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMod extends Item {

    private static boolean hasContainer = false;
    private static boolean leaveCrafting = true;

    /**
     * Creates an Item Instance.
     * 
     * @param id
     *            The Item ID
     */
    public ItemMod(int id) {
        super(id - 256);
        this.setCreativeTab(BetterFood.tabBetterFood);
    }

    /**
     * Creates an Item Instance and Sets the container Item to Itself.
     * 
     * @param id
     *            The Item ID
     * @param leave
     *            Weather the Item leaves the Crafting Grid.
     * @param maxDamage
     *            The Maximum amount of uses
     */
    public ItemMod(int id, boolean leave, int maxDamage) {
        super(id - 256);
        this.setMaxStackSize(1);
        this.setCreativeTab(BetterFood.tabBetterFood);
        this.setContainerItem(this);
        hasContainer = true;
        leaveCrafting = leave;
        setMaxDamage(maxDamage - 1);
    }

    @Override
    public ItemStack getContainerItemStack(ItemStack itemStack) {
        if (hasContainer){

            itemStack.setItemDamage(itemStack.getItemDamage() + 1);

            return itemStack;
        }
        return null;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack) {
        return leaveCrafting;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister) {

        iconIndex = iconRegister.registerIcon(Archive.texture
                + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}