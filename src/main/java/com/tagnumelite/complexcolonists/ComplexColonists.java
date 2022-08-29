package com.tagnumelite.complexcolonists;

import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;
import com.mojang.logging.LogUtils;
import com.tagnumelite.complexcolonists.core.CCBlockEntities;
import com.tagnumelite.complexcolonists.core.init.CCInteractionValidatorInit;
import net.minecraft.Util;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLConfig;
import net.minecraftforge.forgespi.language.IModInfo;
import org.apache.maven.artifact.versioning.ComparableVersion;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import com.ldtteam.structurize.management.StructureName;
import com.ldtteam.structurize.util.StructureLoadingUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Mod(ComplexColonists.MOD_ID)
public class ComplexColonists {
    private static       ModContainer modContainer;
    private static       boolean      hasSentMessage;

    public ComplexColonists() {
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        IEventBus         modEventBus       = FMLJavaModLoadingContext.get().getModEventBus();

        //modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
        //modLoadingContext.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::setupClient);
        modEventBus.addListener(this::loadComplete);

        CCBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        CCBlocks.BLOCKS.register(modEventBus);
        CCBuildings.BUILDINGS.register(modEventBus);
        //CCJobs.JOBS.register(modEventBus);
        CCJobs.JOBS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        CCInteractionValidatorInit.init();

        //PROXY.init();
    }

    private void setup(final FMLCommonSetupEvent event) {
        StructureLoadingUtils.addOriginMod(MOD_ID);
    }

}
