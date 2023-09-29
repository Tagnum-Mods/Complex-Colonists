package com.tagnumelite.complexcolonists.core;

import com.tagnumelite.complexcolonists.ComplexColonists;
import com.tagnumelite.complexcolonists.addon.complexcolonists.AddonComplexColonists;
import com.tagnumelite.complexcolonists.addon.complexcolonists.buildings.BuildingMerchant;
import com.tagnumelite.complexcolonists.addon.complexcolonists.buildings.BuildingTrader;
import com.tagnumelite.complexcolonists.api.constants.RegistryConstants;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import com.minecolonies.api.colony.buildings.registry.BuildingEntry;
import com.minecolonies.coremod.colony.buildings.views.EmptyView;

public final class CCBuildings {
    public static final DeferredRegister<BuildingEntry> BUILDINGS = DeferredRegister.create(
            RegistryConstants.BUILDINGS,
            ComplexColonists.MOD_ID);

    // ComplexColonists
    public static final RegistryObject<BuildingEntry> CC_MERCHANT = BUILDINGS.register(AddonComplexColonists.MERCHANT, () -> new BuildingEntry.Builder()
            .setBuildingBlock(CCHuts.MERCHANT)
            .setBuildingProducer(BuildingMerchant::new)
            .setBuildingViewProducer(() -> EmptyView::new)
            .setRegistryName(AddonComplexColonists.MERCHANT_ID)
            .createBuildingEntry());
    public static final RegistryObject<BuildingEntry> CC_TRADER = BUILDINGS.register(AddonComplexColonists.TRADER, () -> new BuildingEntry.Builder()
            .setBuildingBlock(CCHuts.TRADER)
            .setBuildingProducer(BuildingTrader::new)
            .setBuildingViewProducer(() -> EmptyView::new)
            .setRegistryName(AddonComplexColonists.TRADER_ID)
            .createBuildingEntry());
}
