package harvestry.items.enums;

import harvestry.utils.Archive;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public enum EnumUseAble {

    // Grind Stones, TODO Update with the right Damages, and add the Items to
    // registry and stuff
    gStone(Archive.itemFlour, Archive.texture + Archive.itemFlour, 18),
    gObsidian(Archive.itemPumpkinMash, Archive.texture + Archive.itemPumpkinMash, 64),

    // Heating Elements, TODO Update with the right Damages, and add the Items
    // to registry and stuff
    heWood(Archive.itemChocolateChips, Archive.texture + Archive.itemChocolateChips, 10),
    heAluminum(Archive.itemDough, Archive.texture + Archive.itemDough, 26),
    heIron(Archive.itemCakeBatter, Archive.texture + Archive.itemCakeBatter, 42),
    heComposite(Archive.itemChocolateChipCookieDough, Archive.texture
            + Archive.itemChocolateChipCookieDough, 93);

    public final String unlocalized;
    public final String texture;
    public final int duration;

    private Icon icon;

    private EnumUseAble(String unlocalized, String texture, int duration) {
        this.unlocalized = unlocalized;
        this.texture = texture;
        this.duration = duration;
    }

    public Icon getIcon() {
        return icon;
    }

    public static void registerIcons(IconRegister register) {
        for (EnumUseAble item : EnumUseAble.values()){
            item.icon = register.registerIcon(item.texture);
        }
    }
}