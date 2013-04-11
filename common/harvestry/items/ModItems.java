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

    public static void init() {
        Handler.log(Level.INFO, "Loading Items");

        itemFlour = new ItemMod(Config.itemflourID).setUnlocalizedName(Archive.itemFlour);

        itemBreadPan = new ItemMod(Config.itemBreadPanID).setUnlocalizedName(Archive.itemBreadPan);

        itemChocolateChips = new ItemMod(Config.itemChocolateChipsID)
                .setUnlocalizedName(Archive.itemChocolateChips);

        itemCookieSheet = new ItemMod(Config.itemCookieSheetID)
                .setUnlocalizedName(Archive.itemCookieSheet);

        itemDough = new ItemMod(Config.itemDoughID).setUnlocalizedName(Archive.itemDough);

        itemPiePan = new ItemMod(Config.itemPiePanID).setUnlocalizedName(Archive.itemPiePan)
                .setMaxStackSize(16);

        itemPumpkinMash = new ItemMod(Config.itemPumpkinMashID)
                .setUnlocalizedName(Archive.itemPumpkinMash);

        foodPeanuts = new FoodMod(Config.foodPeanutsID, 1, 1)
                .setUnlocalizedName(Archive.foodPeanuts);

        foodScrambledEggs = new FoodMod(Config.foodScrambledEggsID, 1, 1)
                .setUnlocalizedName(Archive.foodScrambledEggs);

        itemBreadpanwithDough = new ItemMod(Config.itemBreadpanwithDoughID).setUnlocalizedName(
                Archive.itemBreadpanwithDough).setMaxStackSize(16);

        itemCakeBatter = new ItemMod(Config.itemCakeBatterID)
                .setUnlocalizedName(Archive.itemCakeBatter);

        itemModBucket = new ItemMod(Config.itemModBucketID).setUnlocalizedName(
                Archive.itemModBucket).setMaxStackSize(16);

        itemCakePan = new ItemMod(Config.itemCakePanID).setUnlocalizedName(Archive.itemCakePan)
                .setMaxStackSize(16);

        itemCakePanFull = new ItemMod(Config.itemCakePanFullID).setUnlocalizedName(
                Archive.itemCakePanFull).setMaxStackSize(16);

        itemAluminumFoil = new ItemMod(Config.itemAluminumFoilID)
                .setUnlocalizedName(Archive.itemAluminumFoil);

        itemAluminumSheet = new ItemMod(Config.itemAluminumSheetID)
                .setUnlocalizedName(Archive.itemAluminumSheet);

        itemRawAluminum = new ItemMod(Config.itemRawAluminumID)
                .setUnlocalizedName(Archive.itemRawAluminum);

        itemGrindStone = new ItemMod(Config.itemGrindStoneID)
                .setUnlocalizedName(Archive.itemGrindStone);

        itemGrindStones = new ItemMod(Config.itemGrindStonesID, false, 8).setUnlocalizedName(
                Archive.itemGrindStones).setNoRepair();

        itemRawPotato = new ItemMod(Config.itemRawPotatoID)
                .setUnlocalizedName(Archive.itemRawPotato);

        itemCookieDough = new ItemMod(Config.itemCookieDoughID)
                .setUnlocalizedName(Archive.itemCookieDough);

        itemChocolateChipCookieDough = new ItemMod(Config.itemChocolateChipCookieDoughID)
                .setUnlocalizedName(Archive.itemChocolateChipCookieDough);

        itemPumpkinPieFilling = new ItemMod(Config.itemPumpkinPieFillingID)
                .setUnlocalizedName(Archive.itemPumpkinPieFilling);

        itemPieCrust = new ItemMod(Config.itemPieCrustID).setUnlocalizedName(Archive.itemPieCrust);

    }
}