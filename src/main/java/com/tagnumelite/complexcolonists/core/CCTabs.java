package com.tagnumelite.complexcolonists.core;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import static com.tagnumelite.complexcolonists.api.util.CCUtils.modRl;

/**
 *
 */
public final class CCTabs {
    /**
     *
     */
    public static final CreativeModeTab GENERAL = CreativeModeTab.builder()
                                                                 .title(Component.translatable(
                                                                         "modtab.complexcolonists"))
                                                                 .icon(() -> new ItemStack(Items.DIAMOND))
                                                                 .withBackgroundLocation(
                                                                         modRl("textures/gui/container/tab_complexcolonists_bg.png"))
                                                                 .build();

    /**
     *
     */
    public static final CreativeModeTab DECORATIONS = CreativeModeTab.builder()
                                                                     .title(Component.translatable(
                                                                             "tab.complexcolonists.decorations"))
                                                                     .icon(() -> new ItemStack(Items.EMERALD))
                                                                     .build();

    /**
     *
     */
    public static final CreativeModeTab UNLOADED = CreativeModeTab.builder()
                                                                  .title(Component.translatable(
                                                                          "tab.complexcolonists.unloaded"))
                                                                  .icon(() -> new ItemStack(Items.BARRIER, 99))
                                                                  .build();
}
