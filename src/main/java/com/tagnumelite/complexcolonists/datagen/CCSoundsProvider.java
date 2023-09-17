package com.tagnumelite.complexcolonists.datagen;

import com.tagnumelite.complexcolonists.ComplexColonists;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class CCSoundsProvider extends SoundDefinitionsProvider {
    public CCSoundsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), ComplexColonists.MOD_ID, existingFileHelper);
    }

    @Override
    public void registerSounds() {

    }
}
