package com.tagnumelite.complexcolonists.addon.complexcolonists.blocks;

import com.tagnumelite.complexcolonists.core.CCBuildings;

import com.minecolonies.api.blocks.AbstractBlockHut;
import com.minecolonies.api.colony.buildings.registry.BuildingEntry;

public class BlockHutMerchant extends AbstractBlockHut<BlockHutMerchant> {

    @Override
    public String getHutName() {
        return "blockhutmerchant";
    }

    @Override
    public BuildingEntry getBuildingEntry() {
        return CCBuildings.CC_MERCHANT.get();
    }
}
