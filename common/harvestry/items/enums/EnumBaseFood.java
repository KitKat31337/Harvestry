package harvestry.items.enums;

import harvestry.utils.Archive;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public enum EnumBaseFood {

    // Food Items
    foodPeanuts(Archive.foodPeanuts, Archive.texture + Archive.foodPeanuts, 1, 1),
    foodScrambledEggs(Archive.foodScrambledEggs, Archive.texture + Archive.foodScrambledEggs, 1, 1),
    foodChocolateChipCookie(Archive.foodChocolateChipCookie, Archive.texture
            + Archive.foodChocolateChipCookie, 1, 1),
    foodCookie(Archive.foodCookie, Archive.texture + Archive.foodCookie, 1, 1),
    foodSugarCookie(Archive.foodSugarCookie, Archive.texture + Archive.foodSugarCookie, 1, 1);

    public final String unlocalized;
    public final String texture;
    public final int heal;
    public final float saturation;

    private Icon icon;

    private EnumBaseFood(String unlocalized, String texture, int heal, float sturation) {
        this.unlocalized = unlocalized;
        this.texture = texture;
        this.heal = heal;
        this.saturation = sturation;
    }

    public Icon getIcon() {
        return icon;
    }
    
    public static void registerIcons(IconRegister register) {
        for (EnumBaseFood item : EnumBaseFood.values()){
            item.icon = register.registerIcon(item.texture);
        }
    }
}