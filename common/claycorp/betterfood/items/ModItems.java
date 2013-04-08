package claycorp.betterfood.items;

import claycorp.betterfood.utils.Config;
import claycorp.betterfood.utils.Archive;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

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
        
        itemflour = new Flour(Config.itemflourID - 256)
        .setUnlocalizedName(Archive.itemflour);
        
        itemBreadPan = new BreadPan(Config.itemBreadPanID - 256)
        .setUnlocalizedName(Archive.itemBreadPan);
        
        itemChocolateChips = new ChocolateChips(Config.itemChocolateChipsID - 256)
        .setUnlocalizedName(Archive.itemChocolateChips);
        
        itemCookieSheet = new CookieSheet(Config.itemCookieSheetID - 256)
        .setUnlocalizedName(Archive.itemCookieSheet);
        
        itemDough = new Dough(Config.itemDoughID - 256)
        .setUnlocalizedName(Archive.itemDough);
        
        itemPiePan = new PiePan(Config.itemPiePanID - 256)
        .setUnlocalizedName(Archive.itemPiePan);
        
        itemPumpkinMash = new PumpkinMash(Config.itemPumpkinMashID - 256)
        .setUnlocalizedName(Archive.itemPumpkinMash);
        
        foodPeanuts = new Peanuts(Config.foodPeanutsID - 256, 1, 1)
        .setUnlocalizedName(Archive.foodPeanuts);
                
        itemBreadpanwithDough = new BreadpanwithDough(Config.itemBreadpanwithDoughID - 256)
        .setUnlocalizedName(Archive.itemBreadpanwithDough);   
        
        itemCakeBatter = new CakeBatter(Config.itemCakeBatterID - 256)
        .setUnlocalizedName(Archive.itemCakeBatter);
        
        itemModBucket = new ModBucket(Config.itemModBucketID - 256)
        .setUnlocalizedName(Archive.itemModBucket);
        
        itemCakePan = new CakePan(Config.itemCakePanID - 256)
        .setUnlocalizedName(Archive.itemCakePan);
        
        itemCakePanFull = new CakePanFull(Config.itemCakePanFullID - 256)
        .setUnlocalizedName(Archive.itemCakePanFull);
        
        
        
    }
}