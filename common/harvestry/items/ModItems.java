package harvestry.items;

import harvestry.utils.Archive;
import harvestry.utils.Config;
import harvestry.utils.handlers.Handler;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ModItems {
    public static Item itemUncookedCake;
    public static Item itemCakePan;
    public static Item itemBowl;
    public static Item itemCakeBatter;
    public static Item itemUncookedBread;
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
    public static Item itemPureAluminum;
    public static Item itemGrindStone;
    public static Item itemGrindStones;
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
    public static Item itemSugarCookie;
    public static Item itemCookie;
    public static Item itemChocolateChipCookie;
    public static Item itemSugarCookieDough;
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

        itemUncookedBread = new BaseItem(Config.itemUncookedBreadID).setUnlocalizedName(
                Archive.itemUncookedBread).setMaxStackSize(16);

        itemCakeBatter = new BaseItem(Config.itemCakeBatterID)
                .setUnlocalizedName(Archive.itemCakeBatter);

        itemBowl = new BaseItem(Config.itemBowlID).setUnlocalizedName(
                Archive.itemBowl).setMaxStackSize(16);

        itemCakePan = new BaseItem(Config.itemCakePanID).setUnlocalizedName(Archive.itemCakePan)
                .setMaxStackSize(16);

        itemUncookedCake = new BaseItem(Config.itemUncookedCakeID).setUnlocalizedName(
                Archive.itemUncookedCake).setMaxStackSize(16);

        itemAluminumFoil = new BaseItem(Config.itemAluminumFoilID)
                .setUnlocalizedName(Archive.itemAluminumFoil);

        itemAluminumSheet = new BaseItem(Config.itemAluminumSheetID)
                .setUnlocalizedName(Archive.itemAluminumSheet);

        itemPureAluminum = new BaseItem(Config.itemPureAluminumID)
                .setUnlocalizedName(Archive.itemPureAluminum);

        itemGrindStone = new BaseItem(Config.itemGrindStoneID)
                .setUnlocalizedName(Archive.itemGrindStone);

        itemGrindStones = new BaseItem(Config.itemGrindStonesID, false, 8).setUnlocalizedName(
                Archive.itemGrindStones).setNoRepair();

        itemUncookedPotato = new BaseItem(Config.itemUncookedPotatoID)
                .setUnlocalizedName(Archive.itemUncookedPotato);

        itemCookieDough = new BaseItem(Config.itemCookieDoughID)
                .setUnlocalizedName(Archive.itemCookieDough);

        itemChocolateChipCookieDough = new BaseItem(Config.itemChocolateChipCookieDoughID)
                .setUnlocalizedName(Archive.itemChocolateChipCookieDough);

        itemPumpkinPieFilling = new BaseItem(Config.itemPumpkinPieFillingID)
                .setUnlocalizedName(Archive.itemPumpkinPieFilling);

        itemPieCrust = new BaseItem(Config.itemPieCrustID).setUnlocalizedName(Archive.itemPieCrust)
                .setMaxStackSize(16);
        
        itemChocolatePaste = new BaseItem(Config.itemChocolatePasteID)
            .setUnlocalizedName(Archive.itemChocolatePaste)
                .setMaxStackSize(16);
        
        itemUncookedPumpkinPie = new BaseItem(Config.itemUncookedPumpkinPieID)
            .setUnlocalizedName(Archive.itemUncookedPumpkinPie)
                .setMaxStackSize(16);

        itemUncookedSugarCookies = new BaseItem(Config.itemUncookedSugarCookiesID)
            .setUnlocalizedName(Archive.itemUncookedSugarCookies)
                .setMaxStackSize(16);
        
        itemUncookedChocolateChipCookies = new BaseItem(Config.itemUncookedChocolateChipCookiesID)
            .setUnlocalizedName(Archive.itemUncookedChocolateChipCookies)
                .setMaxStackSize(16);
        
        itemUncookedCookies = new BaseItem(Config.itemUncookedCookiesID)
            .setUnlocalizedName(Archive.itemUncookedCookies)
                .setMaxStackSize(16);
        
        itemCookie = new BaseItem(Config.itemCookieID)
            .setUnlocalizedName(Archive.itemCookie);
        
        itemSugarCookie = new BaseItem(Config.itemSugarCookieID)
                .setUnlocalizedName(Archive.itemSugarCookie);
        
        itemSugarCookieDough = new BaseItem(Config.itemSugarCookieDoughID)
            .setUnlocalizedName(Archive.itemSugarCookieDough);
    }
}