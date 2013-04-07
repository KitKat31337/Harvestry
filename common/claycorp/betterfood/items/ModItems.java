package claycorp.betterfood.items;

import claycorp.betterfood.utils.Config;
import claycorp.betterfood.utils.Registry;
import net.minecraft.item.Item;

public class ModItems {
    public static Item flour;
    
    public static void init() {
        
        flour = new Flour(Config.flourID - 256)
            .setUnlocalizedName(Registry.flour);
                
    }
}