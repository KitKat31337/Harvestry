package harvestry.items;

import harvestry.utils.Archive;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public enum EnumItem {

    // Items
    itemFlour(Archive.itemFlour, Archive.texture + Archive.itemFlour),
    itemPumpkinMash(Archive.itemPumpkinMash, Archive.texture + Archive.itemPumpkinMash);
    
    public final String unlocalized;
    public final String texture;
    
    private Icon icon;
    
    private EnumItem(String unlocalized, String texture)
    {
        this.unlocalized = unlocalized;
        this.texture = texture;
    }
    
    public Icon getIcon()
    {
        return icon;
    }
    
    public static void registerIcons(IconRegister register)
    {
        for (EnumItem item : EnumItem.values())
            item.icon = register.registerIcon(item.texture);
    }
    
}
