package claycorp.betterfood.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import claycorp.betterfood.BetterFood;
import claycorp.betterfood.utils.Archive;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMod extends Item {

    private boolean container;

    public ItemMod(int id) {
        super(id);
        this.setCreativeTab(BetterFood.tabBetterFood);
    }

    public ItemMod(int id, Item container, boolean getContainer) {
        super(id);
        this.setCreativeTab(BetterFood.tabBetterFood);
        this.setContainerItem(container);
    }

    @Override
    public ItemStack getContainerItemStack(ItemStack itemStack) {
        if (container){
            
            itemStack.setItemDamage(itemStack.getItemDamage() + 1);

            return itemStack;
        }
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister) {

        iconIndex = iconRegister.registerIcon(Archive.texture
                + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}