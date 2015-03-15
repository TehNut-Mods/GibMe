package gibme;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.living.LivingEvent;

import java.util.Random;

public class EventHandler {

    @SubscribeEvent
    public void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
        Random random = new Random();

        if (event.entity instanceof EntityPlayer && !((EntityPlayer) event.entity).getEntityWorld().isRemote) {
            if (random.nextInt(10000) > ConfigHandler.chanceToGib) {
                ItemStack stack = Utils.stringToItemStack(ConfigHandler.gibMeThese[random.nextInt(ConfigHandler.gibMeThese.length)]);

                ((EntityPlayer) event.entity).inventory.addItemStackToInventory(stack);
                ((EntityPlayer) event.entity).addChatComponentMessage(new ChatComponentText("༼ つ ◕_◕ ༽つ " + stack.getDisplayName() + " ༼ つ ◕_◕ ༽つ"));
            }
        }
    }
}
