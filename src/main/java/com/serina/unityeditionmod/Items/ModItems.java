package com.serina.unityeditionmod.Items;

import com.serina.unityeditionmod.Config.SerinasWorldUnityEdition;
import com.serina.unityeditionmod.Items.Types.ToolsAndWeapons.KnifeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS=DeferredRegister.createItems(SerinasWorldUnityEdition.MODID);

    public static final DeferredItem<Item> SALT= ITEMS.registerSimpleItem("salt");
    public static final DeferredItem<Item> PEBBLE= ITEMS.registerItem("pebble",properties -> new Item(properties));


    public static final DeferredItem<Item> SHARP_PEBBLE= ITEMS.registerItem("sharp_pebble",properties -> new Item(properties));

    public static final DeferredItem<Item> RUDIMENTARY_BLADE= ITEMS.registerItem("rudimentary_blade",properties -> new KnifeItem(properties.sword(ToolMaterial.STONE,4.0f,1.5f).durability(50)));
    public static final DeferredItem<Item> SHARP_STICK= ITEMS.registerItem("sharp_stick",properties->new KnifeItem(properties.sword(ToolMaterial.WOOD,2.0f,1.2f).durability(5)));

    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}
}
