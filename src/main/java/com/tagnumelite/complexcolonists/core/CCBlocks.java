package com.tagnumelite.complexcolonists.core;

import com.tagnumelite.complexcolonists.ComplexColonists;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public final class CCBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                                                                                 ComplexColonists.MOD_ID);

    public static RegistryObject<Block> registerBlock(String name, Supplier<? extends Block> supplier) {
        return BLOCKS.register(name, supplier);
    }

    public static RegistryObject<Block> register(String name, Supplier<? extends Block> supplier, CreativeModeTab tab) {
        return register(name, supplier, new Item.Properties().tab(tab));
    }

    public static RegistryObject<Block> register(
            String name, Supplier<? extends Block> supplier, Item.Properties itemProperties
    ) {
        RegistryObject<Block> block = registerBlock(name, supplier);
        CCItems.ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));
        return block;
    }
}
