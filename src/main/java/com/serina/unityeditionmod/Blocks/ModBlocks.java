package com.serina.unityeditionmod.Blocks;

import com.mojang.serialization.MapCodec;
import com.serina.unityeditionmod.Config.SerinasWorldUnityEdition;
import com.serina.unityeditionmod.Items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS= DeferredRegister.createBlocks(SerinasWorldUnityEdition.MODID);

    public static final DeferredBlock<Block> SALT_BLOCK=registerBlock("salt_block", properties -> new FallingBlock(properties.sound(SoundType.SAND)) {
        @Override
        protected MapCodec<? extends FallingBlock> codec() {
            return null;
        }

        @Override
        public int getDustColor(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
            return 0;
        }
    });




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> block)
    {
        DeferredBlock<T> Ret=BLOCKS.registerBlock(name,block);
        registerBlockItem(name,Ret);
        return Ret;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ModItems.ITEMS.registerItem(name,properties -> new BlockItem(block.get(),properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus){BLOCKS.register(eventBus);}
}
