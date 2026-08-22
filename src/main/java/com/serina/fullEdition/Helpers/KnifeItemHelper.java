package com.serina.fullEdition.Helpers;

import com.serina.fullEdition.Blocks.ModBlocks;
import com.serina.fullEdition.Items.ModItems;
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
                        new outputRecord(Blocks.COBBLESTONE,Blocks.AIR,ModItems.PEBBLE.get(),4),
                        new outputRecord(Blocks.MELON,Blocks.AIR,Items.MELON_SLICE,7),
                        new outputRecord(ModBlocks.SUGAR_CANE_BLOCK.get(),Blocks.AIR,Items.SUGAR_CANE,9)


                );}
}
