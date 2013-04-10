package claycorp.betterfood.items;

import net.minecraft.item.Item;
import claycorp.betterfood.utils.Archive;
import claycorp.betterfood.utils.Config;

public class ModItems {
    public static Item itemCakePanFull;
    public static Item itemCakePan;
    public static Item itemModBucket;
    public static Item itemCakeBatter;
    public static Item itemBreadpanwithDough;
    public static Item foodPeanuts;
    public static Item foodScrambledEggs;
    public static Item itemflour;
    public static Item itemChocolateChips;
    public static Item itemCookieSheet;
    public static Item itemDough;
    public static Item itemPiePan;
    public static Item itemPumpkinMash;
    public static Item itemBreadPan;
    public static Item itemPoisonousPeanut;

    public static void init() {

        itemflour = new ItemMod(Config.itemflourID - 256)
            .setUnlocalizedName(Archive.itemflour);

        itemBreadPan = new ItemMod(Config.itemBreadPanID - 256)
            .setUnlocalizedName(Archive.itemBreadPan);

        itemChocolateChips = new ItemMod(Config.itemChocolateChipsID - 256)
            .setUnlocalizedName(Archive.itemChocolateChips);

        itemCookieSheet = new ItemMod(Config.itemCookieSheetID - 256)
            .setUnlocalizedName(Archive.itemCookieSheet);

        itemDough = new ItemMod(Config.itemDoughID - 256)
            .setUnlocalizedName(Archive.itemDough);

        itemPiePan = new ItemMod(Config.itemPiePanID - 256)
            .setUnlocalizedName(Archive.itemPiePan)
            .setMaxStackSize(16);

        itemPumpkinMash = new ItemMod(Config.itemPumpkinMashID - 256)
            .setUnlocalizedName(Archive.itemPumpkinMash);

        foodPeanuts = new Peanuts(Config.foodPeanutsID - 256, 1, 1)
            .setUnlocalizedName(Archive.foodPeanuts);
        
        foodScrambledEggs = new Peanuts(Config.foodScrambledEggsID - 256, 1, 1)
        .setUnlocalizedName(Archive.foodScrambledEggs);

        itemBreadpanwithDough = new ItemMod(Config.itemBreadpanwithDoughID - 256)
            .setUnlocalizedName(Archive.itemBreadpanwithDough)
            .setMaxStackSize(16);

        itemCakeBatter = new ItemMod(Config.itemCakeBatterID - 256)
            .setUnlocalizedName(Archive.itemCakeBatter);

        itemModBucket = new ItemMod(Config.itemModBucketID - 256)
            .setUnlocalizedName(Archive.itemModBucket)
            .setMaxStackSize(16);

        itemCakePan = new ItemMod(Config.itemCakePanID - 256)
            .setUnlocalizedName(Archive.itemCakePan)
            .setMaxStackSize(16);

        itemCakePanFull = new ItemMod(Config.itemCakePanFullID - 256)
            .setUnlocalizedName(Archive.itemCakePanFull)
            .setMaxStackSize(16);
    }
}