package harvestry.items;

import harvestry.utils.Archive;
import harvestry.utils.Config;
import harvestry.utils.handlers.Handler;

import java.util.logging.Level;

import net.minecraft.item.Item;

public class ModItems {
    public static Item itemCakePanFull;
    public static Item itemCakePan;
    public static Item itemModBucket;
    public static Item itemCakeBatter;
    public static Item itemBreadpanwithDough;
    public static Item foodPeanuts;
    public static Item foodScrambledEggs;
    public static Item itemFlour;
    public static Item itemChocolateChips;
    public static Item itemCookieSheet;
    public static Item itemDough;
    public static Item itemPiePan;
    public static Item itemPumpkinMash;
    public static Item itemBreadPan;
    public static Item itemPoisonousPeanut;
    public static Item itemAluminumFoil;
    public static Item itemAluminumSheet;
    public static Item itemRawAluminum;
    public static Item itemGrindStone;
    public static Item itemGrindStones;
    public static Item itemRawPotato;
    public static Item itemCookieDough;
    public static Item itemChocolateChipCookieDough;
    public static Item itemPumpkinPieFilling;
    public static Item itemPieCrust;

    /**
     * Creates all the Item Objects in the Mod.
     */
    public static void init() {
        Handler.log(Level.INFO, "Loading Items");

        itemFlour = new BaseItem(Config.itemflourID).setUnlocalizedName(Archive.itemFlour);

        itemBreadPan = new BaseItem(Config.itemBreadPanID).setUnlocalizedName(Archive.itemBreadPan);

        itemChocolateChips = new BaseItem(Config.itemChocolateChipsID)
                .setUnlocalizedName(Archive.itemChocolateChips);

        itemCookieSheet = new BaseItem(Config.itemCookieSheetID)
                .setUnlocalizedName(Archive.itemCookieSheet);

        itemDough = new BaseItem(Config.itemDoughID).setUnlocalizedName(Archive.itemDough);

        itemPiePan = new BaseItem(Config.itemPiePanID).setUnlocalizedName(Archive.itemPiePan)
                .setMaxStackSize(16);

        itemPumpkinMash = new BaseItem(Config.itemPumpkinMashID)
                .setUnlocalizedName(Archive.itemPumpkinMash);

        foodPeanuts = new BaseFood(Config.foodPeanutsID, 1, 1)
                .setUnlocalizedName(Archive.foodPeanuts);

        foodScrambledEggs = new BaseFood(Config.foodScrambledEggsID, 1, 1)
                .setUnlocalizedName(Archive.foodScrambledEggs);

        itemBreadpanwithDough = new BaseItem(Config.itemBreadpanwithDoughID).setUnlocalizedName(
                Archive.itemBreadpanwithDough).setMaxStackSize(16);

        itemCakeBatter = new BaseItem(Config.itemCakeBatterID)
                .setUnlocalizedName(Archive.itemCakeBatter);

        itemModBucket = new BaseItem(Config.itemModBucketID).setUnlocalizedName(
                Archive.itemModBucket).setMaxStackSize(16);

        itemCakePan = new BaseItem(Config.itemCakePanID).setUnlocalizedName(Archive.itemCakePan)
                .setMaxStackSize(16);

        itemCakePanFull = new BaseItem(Config.itemCakePanFullID).setUnlocalizedName(
                Archive.itemCakePanFull).setMaxStackSize(16);

        itemAluminumFoil = new BaseItem(Config.itemAluminumFoilID)
                .setUnlocalizedName(Archive.itemAluminumFoil);

        itemAluminumSheet = new BaseItem(Config.itemAluminumSheetID)
                .setUnlocalizedName(Archive.itemAluminumSheet);

        itemRawAluminum = new BaseItem(Config.itemRawAluminumID)
                .setUnlocalizedName(Archive.itemRawAluminum);

        itemGrindStone = new BaseItem(Config.itemGrindStoneID)
                .setUnlocalizedName(Archive.itemGrindStone);

        itemGrindStones = new BaseItem(Config.itemGrindStonesID, false, 8).setUnlocalizedName(
                Archive.itemGrindStones).setNoRepair();

        itemRawPotato = new BaseItem(Config.itemRawPotatoID)
                .setUnlocalizedName(Archive.itemRawPotato);

        itemCookieDough = new BaseItem(Config.itemCookieDoughID)
                .setUnlocalizedName(Archive.itemCookieDough);

        itemChocolateChipCookieDough = new BaseItem(Config.itemChocolateChipCookieDoughID)
                .setUnlocalizedName(Archive.itemChocolateChipCookieDough);

        itemPumpkinPieFilling = new BaseItem(Config.itemPumpkinPieFillingID)
                .setUnlocalizedName(Archive.itemPumpkinPieFilling);

        itemPieCrust = new BaseItem(Config.itemPieCrustID).setUnlocalizedName(Archive.itemPieCrust);

    }
}