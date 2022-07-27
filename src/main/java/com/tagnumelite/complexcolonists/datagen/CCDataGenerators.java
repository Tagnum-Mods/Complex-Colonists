package com.tagnumelite.complexcolonists.datagen;

import com.tagnumelite.complexcolonists.ComplexColonists;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = ComplexColonists.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class CCDataGenerators {
    private CCDataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator      generator          = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if (event.includeClient()) {
            generator.addProvider(new CCLanguageProvider(generator, "en_us"));
        }
    }
}
