package gibme;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Utils {

    public static ItemStack stringToItemStack(String entry) {
        String[] split = entry.split(":");

        Item item = Item.itemRegistry.getObject(new ResourceLocation(split[0], split[1]));
        int meta = Integer.parseInt(split[2]);
        int amount = Integer.parseInt(split[3]);

        return new ItemStack(item, amount, meta);
    }
}
