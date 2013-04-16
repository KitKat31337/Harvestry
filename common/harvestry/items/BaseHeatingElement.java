package harvestry.items;

import harvestry.Harvestry;

public class BaseHeatingElement extends BaseItem {

    public BaseHeatingElement(int id, int maxDamage) {
        super(id);
        this.setMaxStackSize(1);
        this.setCreativeTab(Harvestry.tabHarvestry);
        this.setMaxDamage(maxDamage - 1);
    }
}