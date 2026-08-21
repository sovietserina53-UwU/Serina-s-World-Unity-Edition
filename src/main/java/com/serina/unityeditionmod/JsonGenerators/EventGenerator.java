package com.serina.unityeditionmod.JsonGenerators;

import com.serina.unityeditionmod.Config.SerinasWorldUnityEdition;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber (modid = SerinasWorldUnityEdition.MODID)
public class EventGenerator {

    @SubscribeEvent
    public static void gatherEvent(GatherDataEvent.Client event)
    {
        DataGenerator dataGenerator=event.getGenerator();
        PackOutput packOutput=dataGenerator.getPackOutput();
        dataGenerator.addProvider(true, new ModModelProvider(packOutput));
    }

}
