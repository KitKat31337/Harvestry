package harvestry.items.enums;

import harvestry.utils.Archive;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public enum EnumNonStack {
    // Items (Stack up to 16), TODO Update with the right Items
    itemFlour(Archive.itemFlour, Archive.texture + Archive.itemFlour),
    itemPumpkinMash(Archive.itemPumpkinMash, Archive.texture + Archive.itemPumpkinMash),
    itemChocolateChips(Archive.itemChocolateChips, Archive.texture + Archive.itemChocolateChips),
    itemDough(Archive.itemDough, Archive.texture + Archive.itemDough),
    itemCakeBatter(Archive.itemCakeBatter, Archive.texture + Archive.itemCakeBatter),
    itemChocolateChipCookieDough(Archive.itemChocolateChipCookieDough, Archive.texture
            + Archive.itemChocolateChipCookieDough),
    itemPumpkinPieFilling(Archive.itemPumpkinPieFilling, Archive.texture
            + Archive.itemPumpkinPieFilling),
    itemCookieDough(Archive.itemCookieDough, Archive.texture + Archive.itemCookieDough);

    public final String unlocalized;
    public final String texture;

    private Icon icon;

    private EnumNonStack(String unlocalized, String texture) {
        this.unlocalized = unlocalized;
        this.texture = texture;
    }

    public Icon getIcon() {
        return icon;
    }

    public static void registerIcons(IconRegister register) {
        for (EnumNonStack item : EnumNonStack.values()){
            item.icon = register.registerIcon(item.texture);
        }
    }
}