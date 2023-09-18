package com.tagnumelite.complexcolonists.datagen;

import com.tagnumelite.complexcolonists.ComplexColonists;
import com.tagnumelite.complexcolonists.api.util.constants.TranslationConstants;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.LanguageProvider;

import static com.tagnumelite.complexcolonists.api.util.constants.TranslationConstants.*;


public class CCLanguageProvider extends LanguageProvider {

    public CCLanguageProvider(DataGenerator generator, String locale) {
        super(generator.getPackOutput(), ComplexColonists.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        addGeneral();
        addBlocks();
        addItems();
        addJobs();
        addBuildings();
        addGUIs();
    }

    protected void addGeneral() {
        add(CREATIVE_TAB_GENERAL, "Complex Colonists");
        add(CREATIVE_TAB_DECORATIONS, "Complex Colonists: Decorations");
        add(CREATIVE_TAB_UNLOADED, "Complex Colonists: Missing Mods");
    }

    private void addBlocks() {
    }

    private void addItems() {
    }

    private void addJobs() {
    }

    private void addBuildings() {
    }

    private void addJob(ResourceLocation job, String name) {
        add("com." + job.getNamespace() + ".job." + job.getPath(), name);
    }

    protected void addGUIs() {
        add(TranslationConstants.WORKER_MISSING_MOD, "This worker is missing the required mod (%1$s) to be activated");
        add(TranslationConstants.UPDATE_AVAILABLE, "There is an update for Complex Colonists. %s -> %s");
    }
}
