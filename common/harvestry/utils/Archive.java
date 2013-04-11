package harvestry.utils;

public class Archive {

    // ************************************Mod*************************************
    public static final String id = "harvestry";
    public static final String modName = "Harvestry";
    public static final String ver = "0.1.5";
    public static final String channel = id;

    // ********************************Locations***********************************
    public static final String texture = id + ":";
    public static final String lang = "/mods/" + id + "/lang/";
    public static final String proxy = id + ".sided.proxy.";
    public static final String clientProxy = proxy + "ClientProxy";
    public static final String serverProxy = proxy + "CommonProxy";
    public static final String capes = "https://github.com/Claycorp/Harvestry/blob/master/capes.txt";

    // ************************************Items***********************************
    public static final String itemFlour = "itemFlour";
    public static final String itemPumpkinMash = "itemPumpkinMash";
    public static final String itemBreadPan = "itemBreadPan";
    public static final String itemChocolateChips = "itemChocolateChips";
    public static final String itemCookieSheet = "itemCookieSheet";
    public static final String itemDough = "itemDough";
    public static final String itemPiePan = "itemPiePan";
    public static final String foodPeanuts = "foodPeanuts";
    public static final String foodScrambledEggs = "foodScrambledEggs";
    public static final String itemBreadpanwithDough = "itemBreadpanwithDough";
    public static final String itemCakeBatter = "itemCakeBatter";
    public static final String itemCakePan = "itemCakePan";
    public static final String itemModBucket = "itemModBucket";
    public static final String itemCakePanFull = "itemCakePanFull";
    public static final String itemAluminumFoil = "itemAluminumFoil";
    public static final String itemAluminumSheet = "itemAluminumSheet";
    public static final String itemRawAluminum = "itemRawAluminum";
    public static final String itemGrindStone = "itemGrindStone";
    public static final String itemGrindStones = "itemGrindStones";
    public static final String itemRawPotato = "itemRawPotato";
    public static final String itemCookieDough = "itemCookieDough";
    public static final String itemChocolateChipCookieDough = "itemChocolateChipCookieDough";
    public static final String itemPumpkinPieFilling = "itemPumpkinPieFilling";
    public static final String itemPieCrust = "itemPieCrust";

    // ********************************Blocks*************************************
    public static final String oreAluminum = "oreAluminum";
    public static final String blockGrinder = "blockGrinder";

    // ****************************Tile Entity Stuff***************************
    public static final String inventory   = "inventory";
    public static final String grinderUnloc = id + ".grinder";
    
    // *******************************NBT Stuff****************************
    public static final String NBT_TE_Direction = "direction";
    public static final String NBT_TE_State = "state";
    public static final String NBT_TE_Custom_Name = "name";
    public static final String NBT_TE_Owner = "owner";

    // *********************************Languages***********************************
    public static final String tabHarvestry = "tabHarvestry";
    public static String[] langFiles = {
            // US Local
            lang + "en_US.xml",
            // ES Local
            lang + "es_ES.xml" };

}