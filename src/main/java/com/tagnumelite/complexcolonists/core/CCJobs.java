package com.tagnumelite.complexcolonists.core;

import com.tagnumelite.complexcolonists.ComplexColonists;
import com.tagnumelite.complexcolonists.api.constants.RegistryConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import com.minecolonies.api.colony.jobs.registry.JobEntry;
import com.minecolonies.coremod.colony.jobs.views.DefaultJobView;

public final class CCJobs {
    public static final DeferredRegister<JobEntry> JOBS = DeferredRegister.create(RegistryConstants.JOBS,
                                                                                  ComplexColonists.MOD_ID);

    public static ResourceLocation[] getJobs() {
        return new ResourceLocation[] {
        };
    }
}
