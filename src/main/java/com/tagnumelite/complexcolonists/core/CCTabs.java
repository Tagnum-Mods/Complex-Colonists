package com.tagnumelite.complexcolonists.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import static com.tagnumelite.complexcolonists.ComplexColonists.MOD_ID;
import static com.tagnumelite.complexcolonists.api.util.CCUtils.modRl;

public final class CCTabs {
    /**
     *
     */
    public static final CreativeModeTab GENERAL = new CreativeModeTab(MOD_ID) {
        @NotNull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.DIAMOND);
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }
    };

    /**
     *
     */
    public static final CreativeModeTab DECORATIONS = new CreativeModeTab(MOD_ID + "decorations") {
        @NotNull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.EMERALD);
        }
    };
}
