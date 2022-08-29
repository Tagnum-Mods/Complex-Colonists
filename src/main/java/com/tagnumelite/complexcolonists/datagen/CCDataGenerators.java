package com.tagnumelite.complexcolonists.datagen;

import com.tagnumelite.complexcolonists.ComplexColonists;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ComplexColonists.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class CCDataGenerators {
    private CCDataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator      generator          = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new CCBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(event.includeClient(), new CCItemModelProvider(generator, existingFileHelper));
        generator.addProvider(event.includeClient(), new CCSoundsProvider(generator, existingFileHelper));

        generator.addProvider(event.includeClient(), new CCLanguageProvider(generator, "en_us"));
    }
}
