package com.tagnumelite.complexcolonists.api.blocks;

import com.tagnumelite.complexcolonists.api.blockentity.CCBlockEntityColonyBuilding;
import com.tagnumelite.complexcolonists.core.CCBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.minecolonies.api.blocks.AbstractBlockHut;

public abstract class AbstractCCBlockHut<T extends AbstractBlockHut<T>> extends AbstractBlockHut<T> {
    @Override
    public String getHutName() {
        return "blockhut" + getRegistryName().getPath();
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        final CCBlockEntityColonyBuilding building = CCBlockEntities.BUILDING.get().create(blockPos, blockState);
        assert building != null; // TODO: Inspect this
        building.registryName = this.getBuildingEntry().getRegistryName();
        return building;
    }
}
