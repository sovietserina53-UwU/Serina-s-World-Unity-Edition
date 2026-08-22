package com.serina.fullEdition.JsonGenerators;

import com.serina.fullEdition.Config.SerinasWorldFullEdition;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber (modid = SerinasWorldFullEdition.MODID)
public class EventGenerator {

    @SubscribeEvent
    public static void gatherEvent(GatherDataEvent.Client event)
    {
        DataGenerator dataGenerator=event.getGenerator();
        PackOutput packOutput=dataGenerator.getPackOutput();
        var lookUpProvider=event.getLookupProvider();

        dataGenerator.addProvider(true, new ModModelProvider(packOutput));
        dataGenerator.addProvider(true, new ModBlockTagProvider(packOutput, lookUpProvider));
        dataGenerator.addProvider(true,new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)),lookUpProvider));
        dataGenerator.addProvider(true,new ModRecipeProvider.runner(packOutput,lookUpProvider));
    }

}
