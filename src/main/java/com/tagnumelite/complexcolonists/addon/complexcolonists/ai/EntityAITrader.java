package com.tagnumelite.complexcolonists.addon.complexcolonists.ai;

import com.tagnumelite.complexcolonists.addon.complexcolonists.buildings.BuildingTrader;
import com.tagnumelite.complexcolonists.addon.complexcolonists.jobs.JobTrader;
import org.jetbrains.annotations.NotNull;

import com.minecolonies.coremod.entity.ai.citizen.trainingcamps.AbstractEntityAITraining;

public class EntityAITrader extends AbstractEntityAITraining<JobTrader, BuildingTrader> {
    /**
     * Creates the abstract part of the AI.inte Always use this constructor!
     *
     * @param job the job to fulfill
     */
    public EntityAITrader(@NotNull JobTrader job) {
        super(job);
    }

    @Override
    protected boolean isSetup() {
        return false;
    }

    @Override
    public Class<BuildingTrader> getExpectedBuildingClass() {
        return BuildingTrader.class;
    }
}
