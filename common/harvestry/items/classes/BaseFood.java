package harvestry.items.classes;

import harvestry.Harvestry;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaseFood extends ItemFood {

    public BaseFood(int id){
        BaseFood(id - 256, getHealAmount(), getSaturationModifier(), true);
    }
    
    private BaseFood(int id, int healAmount, float saturationModifier) {
        super(id - 256, healAmount, saturationModifier, true);
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