package harvestry.items.classes;

import harvestry.Harvestry;

public class BaseGrindStone extends BaseItem {

    public BaseGrindStone(int id, int maxDamage) {
        super(id);
        this.setMaxStackSize(1);
        this.setCreativeTab(Harvestry.tabHarvestry);
        this.setMaxDamage(maxDamage - 1);
    }
}