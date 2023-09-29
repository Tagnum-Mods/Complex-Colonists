package com.tagnumelite.complexcolonists.addon.complexcolonists.buildings;

import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

import com.minecolonies.api.colony.IColony;
import com.minecolonies.coremod.colony.buildings.AbstractBuilding;

public class BuildingTrader extends AbstractBuilding {
    /**
     * Constructor for a AbstractBuilding.
     *
     * @param colony Colony the building belongs to.
     * @param pos    Location of the building (it's Hut Block).
     */
    public BuildingTrader(@NotNull IColony colony, BlockPos pos) {
        super(colony, pos);
    }

    @Override
    public String getSchematicName() {
        return null; // TODO: THIS
    }
}
