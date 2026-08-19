package com.serina.unityeditionmod.Events;

import com.serina.unityeditionmod.Config.SerinasWorldUnityEdition;
import com.serina.unityeditionmod.Items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
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

@EventBusSubscriber(modid=SerinasWorldUnityEdition.MODID)

public class ServerEvents {

    @SubscribeEvent
    public static void BlockDestroyingEvent(BreakBlockEvent event)
    {
        Level level=(Level) event.getLevel();
        BlockPos pos=event.getPos();
        BlockState state=event.getState();
        if(!level.isClientSide())
        {
            if(state.is(Blocks.SULFUR)){
                Block.popResource(level,pos,new ItemStack(ModItems.SALT.get()));}
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

        if(!level.isClientSide())
        {
            if(itemStack.is(Items.STICK)&&state.is(Blocks.STONE)&&random>=0.5)
            {itemStack.shrink(1);player.addItem(new ItemStack(ModItems.SHARP_STICK.get()));}
        }
    }


}
