package claycorp.betterfood.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import claycorp.betterfood.BetterFood;
import claycorp.betterfood.utils.Archive;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMod extends Item {

    private boolean hasContainer = false;
    private boolean leaveCrafting = true;

    /**
     * Creates an Item Instance
     * 
     * @param id
     *            The Item ID
     */
    public ItemMod(int id) {
        super(id);
        this.setCreativeTab(BetterFood.tabBetterFood);
    }

    /**
     * Creates an Item Instance
     * 
     * @param id
     *            The Item ID
     * @param containerItem
     *            The Container Item (The Item to return after crafting)
     * @param leave
     *            Weather the Item leaves the Crafting Grid.
     * @param maxDamage
     *            The Maximum amount of uses
     */
    public ItemMod(int id, Item containerItem, boolean leave, int maxDamage) {
        super(id);
        this.setCreativeTab(BetterFood.tabBetterFood);
        this.setContainerItem(containerItem);
        hasContainer = true;
        leave = leaveCrafting;
        setMaxDamage(maxDamage);
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