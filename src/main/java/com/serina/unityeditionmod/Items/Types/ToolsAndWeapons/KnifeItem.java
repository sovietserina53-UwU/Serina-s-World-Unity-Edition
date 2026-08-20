package com.serina.unityeditionmod.Items.Types.ToolsAndWeapons;

import com.serina.unityeditionmod.Blocks.ModBlocks;
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

public class KnifeItem extends Item{

    public KnifeItem(Properties properties) {
        super(properties);
    }


    public record outputRecord(Block blockinput,Block blockoutput,Item item, Integer amount){}

    List<outputRecord> outputRecordList=List.of
            (
                    new outputRecord(Blocks.HAY_BLOCK,Blocks.AIR,Items.WHEAT,9),
                    new outputRecord(Blocks.COBBLESTONE,Blocks.AIR,ModItems.PEBBLE.get(),4)

            );



    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level level=context.getLevel();
        BlockPos pos=context.getClickedPos();
        BlockState state=level.getBlockState(pos);
        ItemStack stack=context.getItemInHand();
        Player player=context.getPlayer();
        if(!level.isClientSide())
        {
            for(outputRecord outputRecord:outputRecordList)
            {
                if(state.is(outputRecord.blockinput))
                {
                    level.setBlock(pos,outputRecord.blockoutput.defaultBlockState(),Block.UPDATE_ALL);
                    Block.popResource(level,pos,new ItemStack(outputRecord.item,outputRecord.amount));
                    stack.hurtAndBreak(1,player, InteractionHand.MAIN_HAND);
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
}

