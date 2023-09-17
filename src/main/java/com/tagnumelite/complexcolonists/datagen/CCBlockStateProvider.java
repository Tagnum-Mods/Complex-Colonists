package com.tagnumelite.complexcolonists.datagen;

import com.tagnumelite.complexcolonists.ComplexColonists;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CCBlockStateProvider extends BlockStateProvider {
    public CCBlockStateProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), ComplexColonists.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }
}
