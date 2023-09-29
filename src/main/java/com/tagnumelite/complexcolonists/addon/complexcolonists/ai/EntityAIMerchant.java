package com.tagnumelite.complexcolonists.addon.complexcolonists.ai;

import com.tagnumelite.complexcolonists.addon.complexcolonists.buildings.BuildingMerchant;
import com.tagnumelite.complexcolonists.addon.complexcolonists.jobs.JobMerchant;
import org.jetbrains.annotations.NotNull;

import com.minecolonies.coremod.entity.ai.citizen.trainingcamps.AbstractEntityAITraining;

public class EntityAIMerchant extends AbstractEntityAITraining<JobMerchant, BuildingMerchant> {
    /**
     * Creates the abstract part of the AI.inte Always use this constructor!
     *
     * @param job the job to fulfill
     */
    public EntityAIMerchant(@NotNull JobMerchant job) {
        super(job);
    }

    @Override
    protected boolean isSetup() {
        return false;
    }

    @Override
    public Class<BuildingMerchant> getExpectedBuildingClass() {
        return BuildingMerchant.class;
    }
}
