package harvestry.items.classes;

import harvestry.Harvestry;
import harvestry.items.enums.EnumBaseFood;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaseFood extends ItemFood {

    private static EnumBaseFood[] currentItems = EnumBaseFood.values();
    private static int currentMeta;
    
    public BaseFood(int id) {
        super(id - 256, currentItems[getMeta()].heal, currentItems[getMeta()].saturation, true);
        this.setCreativeTab(Harvestry.tabHarvestry);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setUnlocalizedName(currentItems[getMeta()].unlocalized);
    }
    
    private static void setMeta(int meta) {
        currentMeta = meta;
    }
    
    private static int getMeta() {
        return currentMeta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Gets an icon index based on an item's damage value
     */
    public Icon getIconFromDamage(int meta) {
        setMeta(meta);
        return currentItems[meta].getIcon();
    }

    /**
     * Registers the Icon for the Food Item
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        EnumBaseFood.registerIcons(iconRegister);
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int itemID, CreativeTabs creativeTabs,
            @SuppressWarnings("rawtypes") List list) {
        for (int currentMeta = 0; currentMeta < EnumBaseFood.values().length; ++currentMeta){
            list.add(new ItemStack(itemID, 1, currentMeta));
        }
    }
}