package harvestry.items.classes;

import harvestry.Harvestry;
import harvestry.items.enums.EnumBaseItem;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaseItem extends Item {

    EnumBaseItem currentItem;

    /**
     * Creates an Item Instance.
     * 
     * @param id
     *            The Item ID
     */
    public BaseItem(int id) {
        super(id - 256);
        this.setCreativeTab(Harvestry.tabHarvestry);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        currentItem = EnumBaseItem.valueOf(getUnlocalizedName2());
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Gets an icon index based on an item's damage value
     */
    public Icon getIconFromDamage(int meta) {
        return currentItem.getIcon();
    }

    @Override
    /**
     * Returns the unlocalized name of this item. This version accepts an
     * ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack item) {
        return currentItem.unlocalized;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int itemID, CreativeTabs creativeTabs,
            @SuppressWarnings("rawtypes") List list) {
        for (int currentMeta = 0; currentMeta < EnumBaseItem.values().length; ++currentMeta){
            list.add(new ItemStack(itemID, 1, currentMeta));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRergister) {
        EnumBaseItem.registerIcons(iconRergister);
    }

    public String getUnlocalizedName2() {
        return this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1);
    }
}