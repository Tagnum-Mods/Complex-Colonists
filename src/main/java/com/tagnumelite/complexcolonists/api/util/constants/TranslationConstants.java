package com.tagnumelite.complexcolonists.api.util.constants;

import com.tagnumelite.complexcolonists.ComplexColonists;

public final class TranslationConstants {
    public static final String CREATIVE_TAB_GENERAL = CTAB("general");
    public static final String CREATIVE_TAB_DECORATIONS = CTAB("decorations");
    public static final String CREATIVE_TAB_UNLOADED = CTAB("unloaded");

    public static final String WORKER_MISSING_MOD = GUI("worker.missing_mod");
    public static final String UPDATE_AVAILABLE   = GUI("update_available");

    public static String GUI(String name) {
        return "gui." + ComplexColonists.MOD_ID + "." + name;
    }

    private static String CTAB(String tab) {
        return "tab." + ComplexColonists.MOD_ID + "." + tab;
    }
}
