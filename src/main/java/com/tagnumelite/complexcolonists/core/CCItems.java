package com.tagnumelite.complexcolonists.core;

import com.tagnumelite.complexcolonists.ComplexColonists;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CCItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                                                                               ComplexColonists.MOD_ID);

    public static Item.Properties GET_PROPS(CreativeModeTab tab) {
        return new Item.Properties(); // .tab(tab)
    }


}
