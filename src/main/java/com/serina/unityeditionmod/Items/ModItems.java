package com.serina.unityeditionmod.Items;

import com.serina.unityeditionmod.Config.SerinasWorldUnityEdition;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS=DeferredRegister.createItems(SerinasWorldUnityEdition.MODID);

    public static final DeferredItem<Item> SALT= ITEMS.registerSimpleItem("salt");


    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}
}
