package com.serina.fullEdition.Config;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import static com.serina.fullEdition.Blocks.ModBlocks.BLOCKS;
import static com.serina.fullEdition.Items.ModItems.ITEMS;


@Mod(SerinasWorldFullEdition.MODID)
public class SerinasWorldFullEdition {

    public static final String MODID = "serinasworldfulledition";

    public static final Logger LOGGER = LogUtils.getLogger();

    public SerinasWorldFullEdition(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }


    private void commonSetup(FMLCommonSetupEvent event)
    {}




    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts

    }
}
