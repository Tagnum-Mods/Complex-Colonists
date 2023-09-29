package com.tagnumelite.complexcolonists.core;

import com.tagnumelite.complexcolonists.ComplexColonists;
import com.tagnumelite.complexcolonists.addon.complexcolonists.AddonComplexColonists;
import com.tagnumelite.complexcolonists.addon.complexcolonists.jobs.JobMerchant;
import com.tagnumelite.complexcolonists.api.constants.RegistryConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import com.minecolonies.api.colony.jobs.registry.JobEntry;
import com.minecolonies.coremod.colony.jobs.views.DefaultJobView;
 
public final class CCJobs {
    public static final DeferredRegister<JobEntry> JOBS = DeferredRegister.create(RegistryConstants.JOBS,
                                                                                  ComplexColonists.MOD_ID);

    // Complex Colonists
    public static final RegistryObject<JobEntry> CC_MERCHANT = JOBS.register(AddonComplexColonists.MERCHANT,
                                                                             () -> new JobEntry.Builder()
                                                                                     .setJobProducer(JobMerchant::new)
                                                                                     .setJobViewProducer(() -> DefaultJobView::new)
                                                                                     .setRegistryName(AddonComplexColonists.MERCHANT_ID)
                                                                                     .createJobEntry());
    public static final RegistryObject<JobEntry> CC_TRADER = JOBS.register(AddonComplexColonists.TRADER,
                                                                             () -> new JobEntry.Builder()
                                                                                     .setJobProducer(JobMerchant::new)
                                                                                     .setJobViewProducer(() -> DefaultJobView::new)
                                                                                     .setRegistryName(AddonComplexColonists.TRADER_ID)
                                                                                     .createJobEntry());

    public static ResourceLocation[] getJobs() {
        return new ResourceLocation[] {
                AddonComplexColonists.MERCHANT_ID,
                AddonComplexColonists.TRADER_ID
        };
    }
}
