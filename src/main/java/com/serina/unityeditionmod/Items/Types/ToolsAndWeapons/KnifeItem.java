package com.serina.unityeditionmod.Items.Types.ToolsAndWeapons;

import com.serina.unityeditionmod.Blocks.ModBlocks;
import com.serina.unityeditionmod.Config.SerinasWorldUnityEdition;
import com.serina.unityeditionmod.Events.ServerEvents;
import com.serina.unityeditionmod.Helpers.KnifeItemHelper;
import com.serina.unityeditionmod.Items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Map;

import static com.serina.unityeditionmod.Helpers.KnifeItemHelper.outputRecordList;

public class KnifeItem extends Item{

    public KnifeItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        for(KnifeItemHelper.SharpenItems sharpenItems:KnifeItemHelper.SharpenItemsList())
        {
            if(player.getMainHandItem().is(sharpenItems.input()))
            {
                player.getMainHandItem().shrink(1);
                player.getOffhandItem().hurtAndBreak(1,player,InteractionHand.MAIN_HAND);
                player.addItem(new ItemStack(sharpenItems.output()));
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level level=context.getLevel();
        BlockPos pos=context.getClickedPos();
        BlockState state=level.getBlockState(pos);
        ItemStack stack=context.getItemInHand();
        Player player=context.getPlayer();
        if(!level.isClientSide())
        {
            for(KnifeItemHelper.outputRecord outputRecord:outputRecordList())
            {
                if(state.is(outputRecord.blockinput()))
                {
                    level.setBlock(pos,outputRecord.blockoutput().defaultBlockState(),Block.UPDATE_ALL);
                    Block.popResource(level,pos,new ItemStack(outputRecord.item(),outputRecord.amount()));
                    stack.hurtAndBreak(1,player, InteractionHand.MAIN_HAND);
                    break;
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
}

