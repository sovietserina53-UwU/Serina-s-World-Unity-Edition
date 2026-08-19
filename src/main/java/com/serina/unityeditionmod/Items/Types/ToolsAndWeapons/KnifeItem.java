package com.serina.unityeditionmod.Items.Types.ToolsAndWeapons;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class KnifeItem extends Item{

    public KnifeItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level level=context.getLevel();
        BlockPos pos=context.getClickedPos();
        BlockState state=level.getBlockState(pos);
        if(!level.isClientSide())
        {
            if(state.is(Blocks.HAY_BLOCK)){level.setBlock(pos,Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);Block.popResource(level,pos,new ItemStack(Items.WHEAT,9));}
        }
        return InteractionResult.SUCCESS;
    }
}

