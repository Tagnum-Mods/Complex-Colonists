package com.tagnumelite.complexcolonists.datagen;

import com.tagnumelite.complexcolonists.ComplexColonists;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CCItemModelProvider extends ItemModelProvider {
    public CCItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), ComplexColonists.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
