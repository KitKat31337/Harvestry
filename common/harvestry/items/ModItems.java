package harvestry.items;

import harvestry.items.classes.BaseFood;
import harvestry.items.classes.BaseItem;
import harvestry.utils.Config;
import harvestry.utils.handlers.Handler;

import java.util.logging.Level;

import net.minecraft.item.Item;

public final class ModItems {
    
    public static Item mainItem;
    public static Item foodItem;
    public static Item nsItem;

    /**
     * Creates all the Item Objects in the Mod.
     */
    public static void init() {
        Handler.log(Level.INFO, "Loading Items");

        mainItem = new BaseItem(Config.mainItemID);
        
        foodItem = new BaseFood(Config.mainItemID);
        
        nsItem = new BaseItem(Config.mainItemID);

        /*
         * initFood();
         * initUncooked();
         * initEmpty();
         * initAlu();
         * initGrinds();
         * initHeatingE();
         * initCrafting();
         */
    }

    /*
     * private static void initCrafting() {
     * //itemFlour = new
     * BaseItem(Config.itemflourID).setUnlocalizedName(Archive.itemFlour);
     * // itemChocolateChips = new BaseItem(Config.itemChocolateChipsID)
     * // .setUnlocalizedName(Archive.itemChocolateChips);
     * // itemDough = new
     * BaseItem(Config.itemDoughID).setUnlocalizedName(Archive.itemDough);
     * // itemPumpkinMash = new BaseItem(Config.itemPumpkinMashID)
     * // .setUnlocalizedName(Archive.itemPumpkinMash);
     * // itemCakeBatter = new BaseItem(Config.itemCakeBatterID)
     * // .setUnlocalizedName(Archive.itemCakeBatter);
     * itemGrindStones = new BaseItem(Config.itemGrindStonesID, false,
     * 8).setUnlocalizedName(
     * Archive.itemGrindStones).setNoRepair();
     * // itemCookieDough = new BaseItem(Config.itemCookieDoughID)
     * // .setUnlocalizedName(Archive.itemCookieDough);
     * // itemChocolateChipCookieDough = new
     * BaseItem(Config.itemChocolateChipCookieDoughID)
     * // .setUnlocalizedName(Archive.itemChocolateChipCookieDough);
     * // itemPumpkinPieFilling = new BaseItem(Config.itemPumpkinPieFillingID)
     * // .setUnlocalizedName(Archive.itemPumpkinPieFilling);
     * itemPieCrust = new
     * BaseItem(Config.itemPieCrustID).setUnlocalizedName(Archive.itemPieCrust)
     * .setMaxStackSize(16);
     * itemChocolatePaste = new
     * BaseItem(Config.itemChocolatePasteID).setUnlocalizedName(
     * Archive.itemChocolatePaste).setMaxStackSize(16);
     * }
     * private static void initHeatingE() {
     * // TODO Put REAL VALUES
     * heWood = new BaseHeatingElement(Config.itemGrindStoneID, 10)
     * .setUnlocalizedName(Archive.itemGrindStone);
     * heAluminum = new BaseHeatingElement(Config.itemGrindStoneID, 26)
     * .setUnlocalizedName(Archive.itemGrindStone);
     * heIron = new BaseHeatingElement(Config.itemGrindStoneID, 42)
     * .setUnlocalizedName(Archive.itemGrindStone);
     * heComposite = new BaseHeatingElement(Config.itemGrindStoneID, 93)
     * .setUnlocalizedName(Archive.itemGrindStone);
     * }
     * private static void initAlu() {
     * // TODO Auto-generated method stub
     * itemAluminumFoil = new BaseItem(Config.itemAluminumFoilID)
     * .setUnlocalizedName(Archive.itemAluminumFoil);
     * itemAluminumSheet = new BaseItem(Config.itemAluminumSheetID)
     * .setUnlocalizedName(Archive.itemAluminumSheet);
     * itemPureAluminum = new BaseItem(Config.itemPureAluminumID)
     * .setUnlocalizedName(Archive.itemPureAluminum);
     * }
     * private static void initGrinds() {
     * // TODO Put REAL VALUES
     * gStone = new BaseHeatingElement(Config.itemGrindStoneID, 18)
     * .setUnlocalizedName(Archive.itemGrindStone);
     * gObsidian = new BaseHeatingElement(Config.itemGrindStoneID, 64)
     * .setUnlocalizedName(Archive.itemGrindStone);
     * }
     * private static void initEmpty() {
     * itemBreadPan = new
     * BaseItem(Config.itemBreadPanID).setUnlocalizedName(Archive.itemBreadPan)
     * .setMaxStackSize(16);;
     * itemBowl = new
     * BaseItem(Config.itemBowlID).setUnlocalizedName(Archive.itemBowl)
     * .setMaxStackSize(16);
     * itemCakePan = new
     * BaseItem(Config.itemCakePanID).setUnlocalizedName(Archive.itemCakePan)
     * .setMaxStackSize(16);
     * itemCookieSheet = new BaseItem(Config.itemCookieSheetID)
     * .setUnlocalizedName(Archive.itemCookieSheet);
     * itemPiePan = new
     * BaseItem(Config.itemPiePanID).setUnlocalizedName(Archive.itemPiePan)
     * .setMaxStackSize(16);
     * }
     * private static void initUncooked() {
     * itemUncookedPotato = new BaseItem(Config.itemUncookedPotatoID)
     * .setUnlocalizedName(Archive.itemUncookedPotato);
     * itemUncookedPumpkinPie = new
     * BaseItem(Config.itemUncookedPumpkinPieID).setUnlocalizedName(
     * Archive.itemUncookedPumpkinPie).setMaxStackSize(16);
     * itemUncookedSugarCookies = new
     * BaseItem(Config.itemUncookedSugarCookiesID)
     * .setUnlocalizedName(Archive.itemUncookedSugarCookies).setMaxStackSize(16);
     * itemUncookedChocolateChipCookies = new
     * BaseItem(Config.itemUncookedChocolateChipCookiesID)
     * .setUnlocalizedName(Archive.itemUncookedChocolateChipCookies).setMaxStackSize
     * (16);
     * itemUncookedCookies = new
     * BaseItem(Config.itemUncookedCookiesID).setUnlocalizedName(
     * Archive.itemUncookedCookies).setMaxStackSize(16);
     * itemSugarCookieDough = new BaseItem(Config.itemSugarCookieDoughID)
     * .setUnlocalizedName(Archive.itemSugarCookieDough);
     * itemUncookedCake = new
     * BaseItem(Config.itemUncookedCakeID).setUnlocalizedName(
     * Archive.itemUncookedCake).setMaxStackSize(16);
     * itemUncookedBread = new
     * BaseItem(Config.itemUncookedBreadID).setUnlocalizedName(
     * Archive.itemUncookedBread).setMaxStackSize(16);
     * }
     * private static void initFood() {
     * foodPeanuts = new BaseFood(Config.foodPeanutsID, 1, 1)
     * .setUnlocalizedName(Archive.foodPeanuts);
     * foodScrambledEggs = new BaseFood(Config.foodScrambledEggsID, 1, 1)
     * .setUnlocalizedName(Archive.foodScrambledEggs);
     * foodChocolateChipCookie = new BaseItem(Config.foodChocolateChipCookieID)
     * .setUnlocalizedName(Archive.foodChocolateChipCookie);
     * foodCookie = new
     * BaseItem(Config.foodCookieID).setUnlocalizedName(Archive.foodCookie);
     * foodSugarCookie = new BaseItem(Config.foodSugarCookieID)
     * .setUnlocalizedName(Archive.foodSugarCookie);
     * }
     */
}