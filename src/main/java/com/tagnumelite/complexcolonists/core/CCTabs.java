package com.tagnumelite.complexcolonists.core;

import com.tagnumelite.complexcolonists.ComplexColonists;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.tagnumelite.complexcolonists.api.util.CCUtils.modRl;
import static com.tagnumelite.complexcolonists.api.util.constants.TranslationConstants.*;

/**
 *
 */
public final class CCTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
                                                                                         ComplexColonists.MOD_ID);

    /**
     *
     */
    public static final RegistryObject<CreativeModeTab> GENERAL = TABS.register("general", () -> CreativeModeTab.builder()
                                                                 .title(Component.translatable(
                                                                         CREATIVE_TAB_GENERAL))
                                                                 .icon(() -> new ItemStack(Items.DIAMOND))
                                                                 .withBackgroundLocation(
                                                                         modRl("textures/gui/container/tab_complexcolonists_bg.png"))
            .displayItems((config, output) -> {
                CCItems.ITEMS.getEntries().forEach(i -> output.accept(i.get()));
            }).build());

    /**
     *
     */
    public static final RegistryObject<CreativeModeTab> DECORATIONS = TABS.register("decorations", () -> CreativeModeTab.builder()
                                                                     .title(Component.translatable(
                                                                             CREATIVE_TAB_DECORATIONS))
                                                                     .icon(() -> new ItemStack(Items.EMERALD))
                                                                     .build());

    /**
     *
     */
    public static final RegistryObject<CreativeModeTab> UNLOADED = TABS.register("unloaded", () -> CreativeModeTab.builder()
                                                                  .title(Component.translatable(
                                                                          CREATIVE_TAB_UNLOADED))
                                                                  .icon(() -> new ItemStack(Items.BARRIER, 99))
                                                                  .build());
}
