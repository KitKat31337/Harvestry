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
    public static Item itemflour;
    public static Item itemChocolateChips;
    public static Item itemCookieSheet;
    public static Item itemDough;
    public static Item itemPiePan;
    public static Item itemPumpkinMash;
    public static Item itemBreadPan;
    public static Item itemPoisonousPeanut;

    public static void init() {

        itemflour = new ItemMod(Config.itemflourID - 256).setUnlocalizedName(Archive.itemflour)
                .setMaxStackSize(64).setNoRepair();

        itemBreadPan = new ItemMod(Config.itemBreadPanID - 256)
                .setUnlocalizedName(Archive.itemBreadPan).setMaxStackSize(16).setNoRepair();

        itemChocolateChips = new ItemMod(Config.itemChocolateChipsID - 256)
                .setUnlocalizedName(Archive.itemChocolateChips).setMaxStackSize(64).setNoRepair();

        itemCookieSheet = new ItemMod(Config.itemCookieSheetID - 256)
                .setUnlocalizedName(Archive.itemCookieSheet).setMaxStackSize(64).setNoRepair();

        itemDough = new ItemMod(Config.itemDoughID - 256).setUnlocalizedName(Archive.itemDough)
                .setMaxStackSize(64).setNoRepair();

        itemPiePan = new ItemMod(Config.itemPiePanID - 256).setUnlocalizedName(Archive.itemPiePan)
                .setMaxStackSize(16).setNoRepair();

        itemPumpkinMash = new ItemMod(Config.itemPumpkinMashID - 256)
                .setUnlocalizedName(Archive.itemPumpkinMash).setMaxStackSize(64).setNoRepair();

        foodPeanuts = new Peanuts(Config.foodPeanutsID - 256, 1, 1)
                .setUnlocalizedName(Archive.foodPeanuts);

        itemBreadpanwithDough = new ItemMod(Config.itemBreadpanwithDoughID - 256)
                .setUnlocalizedName(Archive.itemBreadpanwithDough).setMaxStackSize(16)
                .setNoRepair();

        itemCakeBatter = new ItemMod(Config.itemCakeBatterID - 256)
                .setUnlocalizedName(Archive.itemCakeBatter).setMaxStackSize(64).setNoRepair();

        itemModBucket = new ItemMod(Config.itemModBucketID - 256)
                .setUnlocalizedName(Archive.itemModBucket).setMaxStackSize(16).setNoRepair();

        itemCakePan = new ItemMod(Config.itemCakePanID - 256)
                .setUnlocalizedName(Archive.itemCakePan).setMaxStackSize(16).setNoRepair();

        itemCakePanFull = new ItemMod(Config.itemCakePanFullID - 256)
                .setUnlocalizedName(Archive.itemCakePanFull).setMaxStackSize(16).setNoRepair();

    }
}