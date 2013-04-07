package claycorp.betterfood.items;

import claycorp.betterfood.utils.Registry;
import net.minecraft.item.Item;

public class ModItems {
    public static Item flour;
    
    public static void init() {
        
        flour = new ItemFlour(500)
            .setUnlocalizedName(Registry.flour);
                
    }

}
