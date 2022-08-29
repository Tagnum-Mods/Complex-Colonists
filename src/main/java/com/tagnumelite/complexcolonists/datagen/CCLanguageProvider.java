package com.tagnumelite.complexcolonists.datagen;

import com.tagnumelite.complexcolonists.ComplexColonists;
import com.tagnumelite.complexcolonists.api.util.constants.TranslationConstants;
import com.tagnumelite.complexcolonists.core.CCHuts;
import com.tagnumelite.complexcolonists.core.CCTabs;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.data.LanguageProvider;


public class CCLanguageProvider extends LanguageProvider {
    public CCLanguageProvider(DataGenerator generator, String locale) {
        super(generator, ComplexColonists.MOD_ID, locale);
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
        addCreativeTab(CCTabs.GENERAL, "Complex Colonists");
        addCreativeTab(CCTabs.DECORATIONS, "Complex Colonists: Decorations");
        addCreativeTab(CCTabs.UNLOADED, "Complex Colonists: Missing Mods");
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

    protected void addCreativeTab(CreativeModeTab tab, String value) {
        add(tab.getDisplayName().getString(), value);
    }
}
