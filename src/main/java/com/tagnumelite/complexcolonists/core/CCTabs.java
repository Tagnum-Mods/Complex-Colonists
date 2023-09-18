package com.tagnumelite.complexcolonists.core;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import static com.tagnumelite.complexcolonists.api.util.CCUtils.modRl;
import static com.tagnumelite.complexcolonists.api.util.constants.TranslationConstants.*;

/**
 *
 */
public final class CCTabs {
    /**
     *
     */
    public static final CreativeModeTab GENERAL = CreativeModeTab.builder()
                                                                 .title(Component.translatable(
                                                                         CREATIVE_TAB_GENERAL))
                                                                 .icon(() -> new ItemStack(Items.DIAMOND))
                                                                 .withBackgroundLocation(
                                                                         modRl("textures/gui/container/tab_complexcolonists_bg.png"))
            .displayItems((config, output) -> {
                CCItems.ITEMS.getEntries().forEach(i -> output.accept(i.get()));
            }).build();

    /**
     *
     */
    public static final CreativeModeTab DECORATIONS = CreativeModeTab.builder()
                                                                     .title(Component.translatable(
                                                                             CREATIVE_TAB_DECORATIONS))
                                                                     .icon(() -> new ItemStack(Items.EMERALD))
                                                                     .build();

    /**
     *
     */
    public static final CreativeModeTab UNLOADED = CreativeModeTab.builder()
                                                                  .title(Component.translatable(
                                                                          CREATIVE_TAB_UNLOADED))
                                                                  .icon(() -> new ItemStack(Items.BARRIER, 99))
                                                                  .build();
}
