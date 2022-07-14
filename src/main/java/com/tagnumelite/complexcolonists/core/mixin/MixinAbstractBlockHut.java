package com.tagnumelite.complexcolonists.core.mixin;

import com.tagnumelite.complexcolonists.ComplexColonists;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import com.minecolonies.api.blocks.AbstractBlockHut;
import com.minecolonies.api.blocks.AbstractBlockMinecolonies;
import com.minecolonies.api.colony.IColony;
import com.minecolonies.api.colony.IColonyManager;
import com.minecolonies.api.colony.IColonyView;
import com.minecolonies.api.colony.buildings.IBuilding;
import com.minecolonies.api.colony.buildings.registry.BuildingEntry;
import com.minecolonies.api.colony.buildings.views.IBuildingView;
import com.minecolonies.api.colony.permissions.Action;
import com.minecolonies.api.tileentities.TileEntityColonyBuilding;
import com.ldtteam.structurize.util.LanguageHandler;

import java.util.Map;

@Mixin(AbstractBlockHut.class)
public abstract class MixinAbstractBlockHut<B extends AbstractBlockMinecolonies<B>>
        extends AbstractBlockMinecolonies<B> {
    @Shadow
    public abstract BuildingEntry getBuildingEntry();

    public MixinAbstractBlockHut(Properties properties) {
        super(properties);
    }

    /**
     * @author TagnumElite
     * @reason Testing
     */
    @Overwrite
    @Override
    public void setPlacedBy(
            @NotNull Level worldIn, @NotNull BlockPos pos, @NotNull BlockState state, LivingEntity placer,
            @NotNull ItemStack stack
    ) {
        super.setPlacedBy(worldIn, pos, state, placer, stack);

        /*
        Only work on server side
        */
        if (worldIn.isClientSide) {
            return;
        }

        // TODO: This is only for testing purposes
        final BlockEntity tileEntity = worldIn.getBlockEntity(pos);
        ComplexColonists.LOGGER.debug("Block Hut Placed: {} ({})", tileEntity,
                                      tileEntity instanceof TileEntityColonyBuilding);
        if (tileEntity instanceof @NotNull final TileEntityColonyBuilding hut) {
            if (hut.getBuildingName() != getBuildingEntry().getRegistryName()) {
                hut.registryName = getBuildingEntry().getRegistryName();
            }
            @Nullable final IColony colony = IColonyManager.getInstance()
                                                           .getColonyByPosFromWorld(worldIn, hut.getPosition());
            ComplexColonists.LOGGER.debug("Is there a colony: {}", colony);
            if (colony != null) {
                colony.getBuildingManager().addNewBuilding(hut, worldIn);
                colony.getProgressManager().progressBuildingPlacement(this);
            }
        }
    }

    /**
     * @author TagnumElite
     * @reason Testing
     */
    @Overwrite
    @NotNull
    @Override
    public InteractionResult use(
            @NotNull BlockState state, Level worldIn, @NotNull BlockPos pos, @NotNull Player player,
            @NotNull InteractionHand hand, @NotNull BlockHitResult ray
    ) {
       /*
        If the world is client, open the gui of the building
         */
        if (worldIn.isClientSide) {
            final IColonyManager          colonyManager = IColonyManager.getInstance();
            final IBuilding               building      = colonyManager.getBuilding(worldIn, pos);
            @Nullable final IBuildingView buildingView  = colonyManager.getBuildingView(worldIn.dimension(), pos);
            IColony colony = colonyManager.getColonyByPosFromDim(worldIn.dimension(), pos);
            @Nullable IColonyView             colonyView = colonyManager.getClosestColonyView(worldIn, pos);
            @NotNull Map<BlockPos, IBuilding> buildings  = colony.getBuildingManager().getBuildings();
            ComplexColonists.LOGGER.debug("[HUT]: Building {}:{}; Colony: {}:{}", building, buildingView, colony,
                                          colonyView);
            ComplexColonists.LOGGER.debug("[BUILDINGS]: Colony: {}; Buildings: {}", colony.getName(), buildings);

            if (buildingView == null) {
                LanguageHandler.sendPlayerMessage(player, "com.minecolonies.coremod.gui.nobuilding");
                return InteractionResult.FAIL;
            }

            if (buildingView.getColony() == null) {
                LanguageHandler.sendPlayerMessage(player, "com.minecolonies.coremod.gui.nocolony");
                return InteractionResult.FAIL;
            }

            if (!buildingView.getColony().getPermissions().hasPermission(player, Action.ACCESS_HUTS)) {
                LanguageHandler.sendPlayerMessage(player, "com.minecolonies.coremod.permission.no");
                return InteractionResult.FAIL;
            }

            buildingView.openGui(player.isShiftKeyDown());
        }
        return InteractionResult.SUCCESS;
    }
}
