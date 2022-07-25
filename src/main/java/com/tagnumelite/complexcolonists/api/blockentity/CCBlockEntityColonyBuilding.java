package com.tagnumelite.complexcolonists.api.blockentity;

import com.tagnumelite.complexcolonists.core.CCBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import com.minecolonies.api.tileentities.TileEntityColonyBuilding;

public class CCBlockEntityColonyBuilding extends TileEntityColonyBuilding {
    public CCBlockEntityColonyBuilding(BlockPos pos, BlockState state) {
        this(CCBlockEntities.BUILDING.get(), pos, state);
    }

    public CCBlockEntityColonyBuilding(BlockEntityType<? extends CCBlockEntityColonyBuilding> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
