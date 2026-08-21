package com.serina.unityeditionmod.Events;

import com.serina.unityeditionmod.Config.SerinasWorldUnityEdition;
import com.serina.unityeditionmod.Helpers.KnifeItemHelper;
import com.serina.unityeditionmod.Items.ModItems;
import com.serina.unityeditionmod.Items.Types.ToolsAndWeapons.KnifeItem;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.block.BreakBlockEvent;

import java.awt.event.ItemEvent;
import java.util.List;

@EventBusSubscriber(modid=SerinasWorldUnityEdition.MODID)

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
