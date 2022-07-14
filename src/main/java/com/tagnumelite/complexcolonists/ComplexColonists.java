package com.tagnumelite.complexcolonists;

import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;
import com.mojang.logging.LogUtils;
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
    public static final String        MOD_ID = "complexcolonists";
    public static final  Logger LOGGER   = LogUtils.getLogger();
    //public static final  IProxy PROXY    = DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    private static       ModContainer MOD_CONTAINER;
    private static       boolean      hasSentMessage;

    public ComplexColonists() {
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus         modEventBus       = FMLJavaModLoadingContext.get().getModEventBus();
        MOD_CONTAINER = modLoadingContext.getActiveContainer();

        //modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
        //modLoadingContext.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::setupClient);
        modEventBus.addListener(this::loadComplete);

        //CCBlocks.BLOCKS.register(modEventBus);
        //CCContainers.CONTAINERS.register(modEventBus);
        //CCItems.ITEMS.register(modEventBus);
        //CCTileEntities.TILES.register(modEventBus);
        //CCJobs.JOBS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        //PROXY.init();
    }

    private void setup(final FMLCommonSetupEvent event) {
        StructureLoadingUtils.addOriginMod(MOD_ID);
    }

}