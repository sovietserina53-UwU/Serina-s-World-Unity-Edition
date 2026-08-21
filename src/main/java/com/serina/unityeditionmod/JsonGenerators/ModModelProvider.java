package com.serina.unityeditionmod.JsonGenerators;

import com.serina.unityeditionmod.Blocks.ModBlocks;
import com.serina.unityeditionmod.Config.SerinasWorldUnityEdition;
import com.serina.unityeditionmod.Items.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, SerinasWorldUnityEdition.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
       // itemModels.generateFlatItem(ModBlocks.SALT_BLOCK.asItem(),ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.SALT.get(),ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.SHARP_PEBBLE.get(),ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.PEBBLE.get(),ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.SHARP_STICK.get(),ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RUDIMENTARY_BLADE.get(),ModelTemplates.FLAT_ITEM);

        blockModels.createTrivialCube(ModBlocks.SALT_BLOCK.get());
    }
}
