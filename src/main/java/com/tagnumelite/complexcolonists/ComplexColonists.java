package com.tagnumelite.complexcolonists;

import com.mojang.logging.LogUtils;
import com.tagnumelite.complexcolonists.core.CCBlockEntities;
import com.tagnumelite.complexcolonists.core.init.CCInteractionValidatorInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ComplexColonists.MOD_ID)
public class ComplexColonists {
    public static final  String       MOD_ID = "complexcolonists";
    public static final Logger LOGGER           = LogUtils.getLogger();

    private static       ModContainer modContainer;
    private static       boolean      hasSentMessage;

    public ComplexColonists() {
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        IEventBus         modEventBus       = FMLJavaModLoadingContext.get().getModEventBus();

        //modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
        //modLoadingContext.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC);

        modEventBus.addListener(this::setup);
        //modEventBus.addListener(this::setupClient);
        //modEventBus.addListener(this::loadComplete);

        CCBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        //CCBlocks.BLOCKS.register(modEventBus);
        //CCBuildings.BUILDINGS.register(modEventBus);
        //CCJobs.JOBS.register(modEventBus);
        //CCJobs.JOBS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        CCInteractionValidatorInit.init();


        //PROXY.init();
    }

    //private void loadComplete(Event event) {}

    //private void setupClient(Event event) {}

    private void setup(final FMLCommonSetupEvent event) {
        //StructureLoadingUtils.addOriginMod(MOD_ID);
    }

}
