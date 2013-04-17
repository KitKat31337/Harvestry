package harvestry.items.classes;

import harvestry.Harvestry;
import net.minecraft.item.ItemStack;

public class BaseHeatingElement extends BaseItem {

    private static boolean hasContainer = false;
    private static boolean leaveCrafting = true;

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
    public BaseHeatingElement(int id, boolean leave, int maxDamage) {
        super(id - 256);
        this.setMaxStackSize(1);
        this.setCreativeTab(Harvestry.tabHarvestry);
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
}