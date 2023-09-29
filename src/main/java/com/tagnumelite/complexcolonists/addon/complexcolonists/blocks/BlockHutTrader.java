package com.tagnumelite.complexcolonists.addon.complexcolonists.blocks;

import com.tagnumelite.complexcolonists.core.CCBuildings;

import com.minecolonies.api.blocks.AbstractBlockHut;
import com.minecolonies.api.colony.buildings.registry.BuildingEntry;

public class BlockHutTrader extends AbstractBlockHut<BlockHutTrader> {

    @Override
    public String getHutName() {
        return "blockhuttrader";
    }

    @Override
    public BuildingEntry getBuildingEntry() {
        return CCBuildings.CC_TRADER.get();
    }
}
