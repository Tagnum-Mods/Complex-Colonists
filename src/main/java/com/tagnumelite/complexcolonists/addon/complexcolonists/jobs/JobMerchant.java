package com.tagnumelite.complexcolonists.addon.complexcolonists.jobs;

import com.tagnumelite.complexcolonists.addon.complexcolonists.AddonComplexColonists;
import com.tagnumelite.complexcolonists.addon.complexcolonists.ai.EntityAIMerchant;
import net.minecraft.resources.ResourceLocation;

import com.minecolonies.api.colony.ICitizenData;
import com.minecolonies.coremod.colony.jobs.AbstractJob;

// Merchant trades with other merchants
public class JobMerchant extends AbstractJob<EntityAIMerchant, JobMerchant> {

    /**
     * Initialize citizen data.
     *
     * @param entity the citizen data.
     */
    public JobMerchant(ICitizenData entity) {
        super(entity);
    }

    @Override
    public ResourceLocation getModel() {
        return AddonComplexColonists.MERCHANT_ID;
    }

    @Override
    public EntityAIMerchant generateAI() {
        return new EntityAIMerchant(this);
    }
}
