package com.tagnumelite.complexcolonists.api.colony.jobs;

import com.tagnumelite.complexcolonists.api.entity.ai.EntityAIModMissing;
import net.minecraftforge.fml.ModList;

import com.minecolonies.api.colony.ICitizenData;
import com.minecolonies.coremod.colony.jobs.AbstractJob;
import com.minecolonies.coremod.entity.ai.basic.AbstractAISkeleton;

public abstract class AModdedJob<AI extends AbstractAISkeleton<J>, J extends AModdedJob<AI, J>>
        extends AbstractJob<AI, J> {
    private final String modId;

    /**
     * Initialize citizen data.
     *
     * @param entity the citizen data.
     */
    public AModdedJob(ICitizenData entity, String modId) {
        super(entity);
        this.modId = modId;
    }

    @Override
    public AI generateAI() {
        if (ModList.get().isLoaded(modId)) {
            return generateModdedAI();
        }
        return (AI) new EntityAIModMissing<>(this, modId);
    }

    protected abstract AI generateModdedAI();
}
