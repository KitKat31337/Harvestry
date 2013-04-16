package harvestry.items;

import harvestry.utils.Archive;
import harvestry.utils.Config;
import harvestry.utils.handlers.Handler;

import java.util.logging.Level;

import net.minecraft.item.Item;

public class ModItems {

    // Items
    public static Item itemGrindStones;
    public static Item itemUncookedCake;
    public static Item itemCakePan;
    public static Item itemBowl;
    public static Item itemCakeBatter;
    public static Item itemUncookedBread;
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
    public static Item itemPureAluminum;
    public static Item itemUncookedPotato;
    public static Item itemCookieDough;
    public static Item itemChocolateChipCookieDough;
    public static Item itemPumpkinPieFilling;
    public static Item itemPieCrust;
    public static Item itemChocolatePaste;
    public static Item itemUncookedPumpkinPie;
    public static Item itemUncookedSugarCookies;
    public static Item itemUncookedChocolateChipCookies;
    public static Item itemUncookedCookies;
    public static Item itemSugarCookieDough;

    // Food
    public static Item foodPeanuts;
    public static Item foodScrambledEggs;
    public static Item foodSugarCookie;
    public static Item foodCookie;
    public static Item foodChocolateChipCookie;

    // Grindstones
    public static Item gStone;
    public static Item gObsidian;

    // Heating Elements
    public static Item heWood;
    public static Item heAluminum;
    public static Item heIron;
    public static Item heComposite;

    /**
     * Creates all the Item Objects in the Mod.
     */
    public static void init() {
        Handler.log(Level.INFO, "Loading Items");

        initFood();

        initUncooked();

        initEmpty();

        initAlu();

        initGrinds();

        initHeatingE();

        initCrafting();
    }

    private static void initCrafting() {

        itemFlour = new BaseItem(Config.itemflourID).setUnlocalizedName(Archive.itemFlour);

        itemChocolateChips = new BaseItem(Config.itemChocolateChipsID)
                .setUnlocalizedName(Archive.itemChocolateChips);

        itemDough = new BaseItem(Config.itemDoughID).setUnlocalizedName(Archive.itemDough);

        itemPumpkinMash = new BaseItem(Config.itemPumpkinMashID)
                .setUnlocalizedName(Archive.itemPumpkinMash);

        itemCakeBatter = new BaseItem(Config.itemCakeBatterID)
                .setUnlocalizedName(Archive.itemCakeBatter);

        itemGrindStones = new BaseItem(Config.itemGrindStonesID, false, 8).setUnlocalizedName(
                Archive.itemGrindStones).setNoRepair();

        itemCookieDough = new BaseItem(Config.itemCookieDoughID)
                .setUnlocalizedName(Archive.itemCookieDough);

        itemChocolateChipCookieDough = new BaseItem(Config.itemChocolateChipCookieDoughID)
                .setUnlocalizedName(Archive.itemChocolateChipCookieDough);

        itemPumpkinPieFilling = new BaseItem(Config.itemPumpkinPieFillingID)
                .setUnlocalizedName(Archive.itemPumpkinPieFilling);

        itemPieCrust = new BaseItem(Config.itemPieCrustID).setUnlocalizedName(Archive.itemPieCrust)
                .setMaxStackSize(16);

        itemChocolatePaste = new BaseItem(Config.itemChocolatePasteID).setUnlocalizedName(
                Archive.itemChocolatePaste).setMaxStackSize(16);
    }

    private static void initHeatingE() {
        // TODO Put REAL VALUES
        heWood = new BaseHeatingElement(Config.itemGrindStoneID, 10)
                .setUnlocalizedName(Archive.itemGrindStone);

        heAluminum = new BaseHeatingElement(Config.itemGrindStoneID, 26)
                .setUnlocalizedName(Archive.itemGrindStone);
        
        heIron = new BaseHeatingElement(Config.itemGrindStoneID, 42)
                .setUnlocalizedName(Archive.itemGrindStone);
        
        heComposite = new BaseHeatingElement(Config.itemGrindStoneID, 93)
                .setUnlocalizedName(Archive.itemGrindStone);
    }

    private static void initAlu() {
        // TODO Auto-generated method stub
        itemAluminumFoil = new BaseItem(Config.itemAluminumFoilID)
                .setUnlocalizedName(Archive.itemAluminumFoil);

        itemAluminumSheet = new BaseItem(Config.itemAluminumSheetID)
                .setUnlocalizedName(Archive.itemAluminumSheet);

        itemPureAluminum = new BaseItem(Config.itemPureAluminumID)
                .setUnlocalizedName(Archive.itemPureAluminum);
    }

    private static void initGrinds() {
        // TODO Put REAL VALUES
        gStone = new BaseHeatingElement(Config.itemGrindStoneID, 18)
                .setUnlocalizedName(Archive.itemGrindStone);

        gObsidian = new BaseHeatingElement(Config.itemGrindStoneID, 64)
                .setUnlocalizedName(Archive.itemGrindStone);
    }

    private static void initEmpty() {
        itemBreadPan = new BaseItem(Config.itemBreadPanID).setUnlocalizedName(Archive.itemBreadPan);

        itemBowl = new BaseItem(Config.itemBowlID).setUnlocalizedName(Archive.itemBowl)
                .setMaxStackSize(16);

        itemCakePan = new BaseItem(Config.itemCakePanID).setUnlocalizedName(Archive.itemCakePan)
                .setMaxStackSize(16);

        itemCookieSheet = new BaseItem(Config.itemCookieSheetID)
                .setUnlocalizedName(Archive.itemCookieSheet);

        itemPiePan = new BaseItem(Config.itemPiePanID).setUnlocalizedName(Archive.itemPiePan)
                .setMaxStackSize(16);
    }

    private static void initUncooked() {

        itemUncookedPotato = new BaseItem(Config.itemUncookedPotatoID)
                .setUnlocalizedName(Archive.itemUncookedPotato);

        itemUncookedPumpkinPie = new BaseItem(Config.itemUncookedPumpkinPieID).setUnlocalizedName(
                Archive.itemUncookedPumpkinPie).setMaxStackSize(16);

        itemUncookedSugarCookies = new BaseItem(Config.itemUncookedSugarCookiesID)
                .setUnlocalizedName(Archive.itemUncookedSugarCookies).setMaxStackSize(16);

        itemUncookedChocolateChipCookies = new BaseItem(Config.itemUncookedChocolateChipCookiesID)
                .setUnlocalizedName(Archive.itemUncookedChocolateChipCookies).setMaxStackSize(16);

        itemUncookedCookies = new BaseItem(Config.itemUncookedCookiesID).setUnlocalizedName(
                Archive.itemUncookedCookies).setMaxStackSize(16);

        itemSugarCookieDough = new BaseItem(Config.itemSugarCookieDoughID)
                .setUnlocalizedName(Archive.itemSugarCookieDough);

        itemUncookedCake = new BaseItem(Config.itemUncookedCakeID).setUnlocalizedName(
                Archive.itemUncookedCake).setMaxStackSize(16);

        itemUncookedBread = new BaseItem(Config.itemUncookedBreadID).setUnlocalizedName(
                Archive.itemUncookedBread).setMaxStackSize(16);
    }

    private static void initFood() {

        foodPeanuts = new BaseFood(Config.foodPeanutsID, 1, 1)
                .setUnlocalizedName(Archive.foodPeanuts);

        foodScrambledEggs = new BaseFood(Config.foodScrambledEggsID, 1, 1)
                .setUnlocalizedName(Archive.foodScrambledEggs);

        foodChocolateChipCookie = new BaseItem(Config.foodChocolateChipCookieID)
                .setUnlocalizedName(Archive.foodChocolateChipCookie);

        foodCookie = new BaseItem(Config.foodCookieID).setUnlocalizedName(Archive.foodCookie);

        foodSugarCookie = new BaseItem(Config.foodSugarCookieID)
                .setUnlocalizedName(Archive.foodSugarCookie);

    }
}