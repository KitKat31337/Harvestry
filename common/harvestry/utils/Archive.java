package harvestry.utils;

public class Archive {

    /*
     * ******************************************************
     * Mod Stuff
     * ******************************************************
     */
    public static final String id = "harvestry";
    public static final String modName = "Harvestry";
    public static final String ver = "@VERSION@";
    public static final String channel = id;
    public static final String depend = "required-after:Forge@[7.7.1.650,)";
    public static final String tabHarvestry = "tabHarvestry";

    /*
     * ******************************************************
     * Locations
     * ******************************************************
     */
    public static final String texture = id + ":";
    public static final String lang = "/mods/" + id + "/lang/";
    public static final String proxy = id + ".sided.proxy.";
    public static final String clientProxy = proxy + "ClientProxy";
    public static final String serverProxy = proxy + "CommonProxy";
    public static final String capes = "https://raw.github.com/Claycorp/Harvestry/master/capes.txt";
    public static final String gui = "/mods/" + id + "/textures/guis/";

    /*
     * ******************************************************
     * Items
     * ******************************************************
     */
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

    /*
     * ******************************************************
     * Blocks
     * ******************************************************
     */
    public static final String oreAluminum = "oreAluminum";
    public static final String blockGrinder = "blockGrinder";
    public static final String blockOven = "blockOven";

    /*
     * ******************************************************
     * Tile Entity Stuff
     * ******************************************************
     */
    public static final String container = "container.";
    public static final String inventory = container + "inventory";
    // Grinder
    public static final String grinderUnloc = container + "grinder";
    public static final String grinderGUI = gui + "guiGrindstone.png";
    public static final int grinderGUID = 0;
    // Oven
    public static final String ovenUnloc = container + "oven";
    public static final String ovenGUI = gui + "guiOven.png";
    public static final int ovenGUID = 1;

    /*
     * ******************************************************
     * NBT Stuff
     * ******************************************************
     */
    public static final String NBT_TE_Direction = "direction";
    public static final String NBT_TE_State = "state";
    public static final String NBT_TE_Custom_Name = "name";
    public static final String NBT_TE_Owner = "owner";

    /*
     * ******************************************************
     * Languages
     * ******************************************************
     */
    public static String[] langFiles = {
            // US Language
            lang + "en_US.xml",
            // ES Language
            lang + "es_ES.xml" };

}