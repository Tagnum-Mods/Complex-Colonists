package com.tagnumelite.complexcolonists.core;

import com.tagnumelite.complexcolonists.ComplexColonists;
import com.tagnumelite.complexcolonists.api.constants.RegistryConstants;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import com.minecolonies.api.colony.buildings.registry.BuildingEntry;

public final class CCBuildings {
    public static final DeferredRegister<BuildingEntry> BUILDINGS = DeferredRegister.create(
            RegistryConstants.BUILDINGS,
            ComplexColonists.MOD_ID);

}
