package claycorp.betterfood.items;

import claycorp.betterfood.utils.Config;
import claycorp.betterfood.utils.Registry;
import net.minecraft.item.Item;

public class ModItems {
    public static Item flour;
    public static Item ChocolateChips;
    public static Item CookieSheet;
    public static Item Dough;
    public static Item PiePan;
    public static Item PumpkinMash;
    public static Item BreadPan;
    
    
    public static void init() {
        
        flour = new Flour(Config.flourID - 256)
            .setUnlocalizedName(Registry.flour);
        
        BreadPan = new BreadPan(Config.BreadPanID - 256)
        .setUnlocalizedName(Registry.BreadPan);
        
        ChocolateChips = new ChocolateChips(Config.ChocolateChipsID - 256)
        .setUnlocalizedName(Registry.ChocolateChips);
        
        CookieSheet = new CookieSheet(Config.CookieSheetID - 256)
        .setUnlocalizedName(Registry.CookieSheet);
        
        Dough = new Dough(Config.DoughID - 256)
        .setUnlocalizedName(Registry.Dough);
        
        PiePan = new PiePan(Config.PiePanID - 256)
        .setUnlocalizedName(Registry.PiePan);
        
        PumpkinMash = new PumpkinMash(Config.PumpkinMashID - 256)
        .setUnlocalizedName(Registry.PumpkinMash);
                
    }
}