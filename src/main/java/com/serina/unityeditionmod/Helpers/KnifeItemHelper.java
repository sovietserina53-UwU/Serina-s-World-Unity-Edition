package com.serina.unityeditionmod.Helpers;

import com.serina.unityeditionmod.Items.ModItems;
import com.serina.unityeditionmod.Items.Types.ToolsAndWeapons.KnifeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class KnifeItemHelper {

    //List of items that get sharp.
    public record SharpenItems(Item input, Item output){}
    public static List<SharpenItems> SharpenItemsList()
    {
            return List.of
            (
                    new SharpenItems(Items.STICK, ModItems.SHARP_STICK.get()),
                    new SharpenItems(ModItems.PEBBLE.get(), ModItems.SHARP_PEBBLE.get())

            );
    }


    //List of the block you click, the block it turns into, the items it may drop and the amount
    public record outputRecord(Block blockinput, Block blockoutput, Item item, Integer amount){}
    public static List<outputRecord> outputRecordList()
    {
        return List.of
                (
                        new outputRecord(Blocks.HAY_BLOCK,Blocks.AIR,Items.WHEAT,9),
                        new outputRecord(Blocks.COBBLESTONE,Blocks.AIR,ModItems.PEBBLE.get(),4)

                );}
}
