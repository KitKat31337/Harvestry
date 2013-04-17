package harvestry.items.classes;

import harvestry.Harvestry;
import harvestry.items.enums.EnumBaseFood;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaseFood extends ItemFood {
    
    public BaseFood(int id) {
        super(id - 256, EnumBaseFood.foodChocolateChipCookie.heal, EnumBaseFood.foodChocolateChipCookie.sturation, true);
        this.setCreativeTab(Harvestry.tabHarvestry);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    /**
     * Registers the Icon for the Food Item
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        
    }
    
    public String getUnlocalizedName2() {
        return this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1);
    }
}