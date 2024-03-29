package com.tagnumelite.complexcolonists.api.util;

import com.tagnumelite.complexcolonists.ComplexColonists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public final class CCUtils {
    public static ResourceLocation modRl(String path) {
        return new ResourceLocation(ComplexColonists.MOD_ID, path);
    }

    public static ResourceLocation modRlTextures(String path) {
        return modRl("textures/" + path);
    }

    public static ResourceLocation modRlGuiTextures(String path) {
        return modRlTextures("gui/" + path);
    }

    public static ResourceLocation rlBlock(String block) {
        return modRl("block/" + block);
    }

    public static String forgeTag(String path) {
        return "forge:" + path;
    }

    public static String ingotsTag(String ingot) {
        return forgeTag("ingots/" + ingot);
    }

    public static String nuggetsTag(String nugget) {
        return forgeTag("nuggets/" + nugget);
    }

    public static String storageTag(String nugget) {
        return forgeTag("storage_blocks/" + nugget);
    }

    public static String dustsTag(String dust) {
        return forgeTag("dusts/" + dust);
    }

    public static String getItemKey(Item item, String path) {
        final ResourceLocation regName = ForgeRegistries.ITEMS.getKey(item);
        return "item." + (regName != null ? regName.getNamespace() + '.' : "") + regName.getPath() + '.' + path;
    }
}
