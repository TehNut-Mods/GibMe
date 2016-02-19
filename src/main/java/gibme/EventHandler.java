package gibme;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class EventHandler {

    @SubscribeEvent
    public void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
        Random random = new Random();

        if (event.entity instanceof EntityPlayer && !(event.entity instanceof FakePlayer) && !event.entity.getEntityWorld().isRemote) {
            if (event.entity.worldObj.getTotalWorldTime() % (ConfigHandler.attemptCooldown * 20) == 0) {
                if (random.nextDouble() <= ConfigHandler.chanceToGib) {
                    ItemStack stack = Utils.stringToItemStack(ConfigHandler.gibMeThese[random.nextInt(ConfigHandler.gibMeThese.length)]);

                    ((EntityPlayer) event.entity).inventory.addItemStackToInventory(stack);
                    ((EntityPlayer) event.entity).addChatComponentMessage(new ChatComponentText(String.format("༼ つ ◕_◕ ༽つ %s ༼ つ ◕_◕ ༽つ", stack.getDisplayName())));
                }
            }
        }
    }
}
