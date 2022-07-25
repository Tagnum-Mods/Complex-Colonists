package com.tagnumelite.complexcolonists.core.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.BlockItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.minecolonies.api.colony.buildings.registry.BuildingEntry;
import com.minecolonies.api.colony.buildings.registry.IBuildingRegistry;
import com.minecolonies.api.util.InventoryUtils;
import com.minecolonies.coremod.client.gui.WindowMinecoloniesBuildTool;
import com.ldtteam.structurize.client.gui.WindowBuildTool;
import com.ldtteam.structurize.management.StructureName;

@Mixin(value = WindowMinecoloniesBuildTool.class, remap = false)
public abstract class MixinWindowMinecoloniesBuildTool extends WindowBuildTool {
    public MixinWindowMinecoloniesBuildTool(@Nullable BlockPos pos, String folder, int rotation, int groundstyle) {
        super(pos, folder, rotation, groundstyle);
    }

    /**
     * Overwrite the hasMatchingBlock function because the base function crashes when it tries getBuildingBlock from a
     * null BuildingEntry.
     *
     * @author TagnumElite
     * @reason The base method crashes because it tries to get a Block from a null BuildingEntry.
     */
    @Overwrite
    @Override
    public boolean hasMatchingBlock(@NotNull Inventory inventory, String hut) {
        final String name = hut.equals("citizen") ? "home" : hut;
        return InventoryUtils.hasItemInProvider(inventory.player, item -> {
            BuildingEntry buildingReg = IBuildingRegistry.getInstance()
                                                         .getValue(new ResourceLocation(
                                                                 item.getItem().getRegistryName().getNamespace(),
                                                                 name));
            return item.getItem() instanceof BlockItem && StructureName.HUTS.contains(
                    hut) && buildingReg != null && ((BlockItem) item.getItem()).getBlock() == buildingReg.getBuildingBlock();
        });
    }
}
