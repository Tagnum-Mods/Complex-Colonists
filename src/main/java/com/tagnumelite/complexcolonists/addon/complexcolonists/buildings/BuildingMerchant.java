package com.tagnumelite.complexcolonists.addon.complexcolonists.buildings;

import com.tagnumelite.complexcolonists.addon.complexcolonists.AddonComplexColonists;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

import com.minecolonies.api.colony.IColony;
import com.minecolonies.coremod.colony.buildings.AbstractBuilding;

public class BuildingMerchant extends AbstractBuilding {
    /**
     * Constructor for a AbstractBuilding.
     *
     * @param colony Colony the building belongs to.
     * @param pos    Location of the building (it's Hut Block).
     */
    public BuildingMerchant(@NotNull IColony colony, BlockPos pos) {
        super(colony, pos);
    }

    @Override
    public String getSchematicName() {
        return AddonComplexColonists.MERCHANT;
    }
}
