package com.tagnumelite.complexcolonists.addon.complexcolonists.jobs;

import com.tagnumelite.complexcolonists.addon.complexcolonists.AddonComplexColonists;
import com.tagnumelite.complexcolonists.addon.complexcolonists.ai.EntityAITrader;

import com.minecolonies.api.colony.ICitizenData;
import com.minecolonies.coremod.colony.jobs.AbstractJob;

import net.minecraft.resources.ResourceLocation;

// Trader trades with villagers
public class JobTrader extends AbstractJob<EntityAITrader, JobTrader> {
    /**
     * Initialize citizen data.
     *
     * @param entity the citizen data.
     */
    public JobTrader(ICitizenData entity) {
        super(entity);
    }

    @Override
    public ResourceLocation getModel() {
        return AddonComplexColonists.TRADER_ID;
    }

    @Override
    public EntityAITrader generateAI() {
        return new EntityAITrader(this);
    }
}
