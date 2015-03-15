package gibme;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Utils {

    public static ItemStack stringToItemStack(String entry) {

        String[] split = entry.split(":");

        if (split[0].equals("item")) {
            Item item = GameRegistry.findItem(split[1], split[2]);
            int meta = Integer.parseInt(split[3]);
            int amount = Integer.parseInt(split[4]);

            return new ItemStack(item, amount, meta);
        } else if (split[0].equals("block")) {
            Block block = GameRegistry.findBlock(split[1], split[2]);
            int meta = Integer.parseInt(split[3]);
            int amount = Integer.parseInt(split[4]);

            return new ItemStack(block, amount, meta);
        }

        return new ItemStack(Items.stick);
    }
}
