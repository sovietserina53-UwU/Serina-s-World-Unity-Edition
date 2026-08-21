package com.serina.fullEdition.Events;

import com.serina.fullEdition.Config.SerinasWorldFullEdition;
import com.serina.fullEdition.Helpers.KnifeItemHelper;
import com.serina.fullEdition.Items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.block.BreakBlockEvent;

@EventBusSubscriber(modid= SerinasWorldFullEdition.MODID)

public class ServerEvents {


    @SubscribeEvent
    public static void BlockDestroyingEvent(BreakBlockEvent event)
    {
        Level level=(Level) event.getLevel();
        BlockPos pos=event.getPos();
        BlockState state=event.getState();

    }

    @SubscribeEvent
    public static void RightClickItem(PlayerInteractEvent.RightClickItem event)
    {
        Player player=event.getEntity();

        if(event.getHand()!=InteractionHand.MAIN_HAND)return;
        if(player.getOffhandItem().is(Items.FLINT)||player.getOffhandItem().is(ModItems.SHARP_PEBBLE))
            for(KnifeItemHelper.SharpenItems sharpenItemss:KnifeItemHelper.SharpenItemsList())
            {
                if(player.getMainHandItem().is(sharpenItemss.input()))
                {
                    player.getMainHandItem().shrink(1);
                    player.getOffhandItem().shrink(1);
                    player.addItem(new ItemStack(sharpenItemss.output()));

                }
            }
    }

    @SubscribeEvent
    public static void Useon(PlayerInteractEvent.RightClickBlock event)
    {
        RandomSource randomSource=event.getLevel().getRandom();
        float random=randomSource.nextFloat();
        ItemStack itemStack=event.getItemStack();
        Level level=(Level) event.getLevel();
        BlockPos pos=event.getPos();
        BlockState state=event.getLevel().getBlockState(pos);
        Player player=event.getEntity();

    }


}
