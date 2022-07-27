package com.tagnumelite.complexcolonists.api.buildings;

import com.tagnumelite.complexcolonists.api.blockentity.CCBlockEntityColonyBuilding;
import com.tagnumelite.complexcolonists.api.blocks.AbstractCCBlockHut;
import com.tagnumelite.complexcolonists.core.CCBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

import com.minecolonies.api.blocks.AbstractBlockHut;
import com.minecolonies.api.colony.IColony;
import com.minecolonies.api.tileentities.AbstractTileEntityColonyBuilding;
import com.minecolonies.api.tileentities.TileEntityColonyBuilding;
import com.minecolonies.api.util.Log;
import com.minecolonies.api.util.WorldUtil;
import com.minecolonies.coremod.colony.buildings.AbstractBuilding;

public abstract class AbstractCCBuilding extends AbstractBuilding {
    /**
     * Constructor for a AbstractBuilding.
     *
     * @param colony Colony the building belongs to.
     * @param pos    Location of the building (it's Hut Block).
     */
    protected AbstractCCBuilding(@NotNull IColony colony, BlockPos pos) {
        super(colony, pos);
    }

    @Override
    public AbstractTileEntityColonyBuilding getTileEntity() {
            if (tileEntity != null && tileEntity.isRemoved())
            {
                tileEntity = null;
            }

            if ((tileEntity == null)
                    && colony != null
                    && colony.getWorld() != null
                    && getPosition() != null
                    && WorldUtil.isBlockLoaded(colony.getWorld(), getPosition())
                    && !(colony.getWorld().getBlockState(getPosition()).getBlock() instanceof AirBlock)
                    && colony.getWorld().getBlockState(this.getPosition()).getBlock() instanceof AbstractCCBlockHut)
            {
                final BlockEntity te = colony.getWorld().getBlockEntity(getPosition());
                if (te instanceof CCBlockEntityColonyBuilding)
                {
                    tileEntity = (CCBlockEntityColonyBuilding) te;
                    if (tileEntity.getBuilding() == null)
                    {
                        tileEntity.setColony(colony);
                        tileEntity.setBuilding(this);
                    }
                }
                else
                {
                    Log.getLogger().error("Somehow the wrong TileEntity is at the location where the building should be!", new Exception());
                    Log.getLogger().error("Trying to restore order!");

                    final AbstractTileEntityColonyBuilding tileEntityColonyBuilding = new CCBlockEntityColonyBuilding(
                            CCBlockEntities.BUILDING.get(), getPosition(), colony.getWorld().getBlockState(this.getPosition()));
                    colony.getWorld().setBlockEntity(tileEntityColonyBuilding);
                    this.tileEntity = tileEntityColonyBuilding;
                }
            }

            return tileEntity;
    }
}
