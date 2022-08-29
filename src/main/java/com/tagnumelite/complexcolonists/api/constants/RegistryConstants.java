package com.tagnumelite.complexcolonists.api.constants;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

import com.minecolonies.api.colony.interactionhandling.registry.InteractionResponseHandlerEntry;
import com.minecolonies.api.util.constant.Constants;

public class RegistryConstants {
    public static final ResourceLocation BUILDINGS = new ResourceLocation(Constants.MOD_ID, "buildings");
    public static final ResourceLocation JOBS           = new ResourceLocation(Constants.MOD_ID, "jobs");
    public static final ResourceLocation                                CRAFTING_TYPES                = new ResourceLocation(Constants.MOD_ID, "craftingtypes");
    public static final ResourceLocation INTERACTION_RESPONSE_HANDLERS = new ResourceLocation(Constants.MOD_ID, "interactionresponsehandlers");
}
