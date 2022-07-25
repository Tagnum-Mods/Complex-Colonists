package com.tagnumelite.complexcolonists.core.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.minecolonies.api.colony.buildings.registry.BuildingEntry;
import com.minecolonies.api.colony.buildings.registry.IBuildingRegistry;
import com.minecolonies.api.util.InventoryUtils;
import com.minecolonies.api.util.constant.Constants;
import com.minecolonies.coremod.client.gui.WindowMinecoloniesBuildTool;
import com.ldtteam.structurize.client.gui.WindowBuildTool;
import com.ldtteam.structurize.management.StructureName;

import java.util.function.Predicate;

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
        final String                        name             = hut.equals("citizen") ? "home" : hut;
        final IForgeRegistry<BuildingEntry> buildingRegistry = IBuildingRegistry.getInstance();

        Predicate<ItemStack> predicate = (itemStack) -> {
            final Item             item         = itemStack.getItem();
            final boolean isBlockItem = item instanceof BlockItem;
            final boolean isHut       = StructureName.HUTS.contains(hut);
            boolean isBuildingBlock = false;
            
            if (isBlockItem && isHut) {
                final String           namespace    = (item.getRegistryName() != null) ? item.getRegistryName()
                                                                                             .getNamespace() : Constants.MOD_ID;
                final ResourceLocation registryName = new ResourceLocation(namespace, name);

                @Nullable BuildingEntry buildingEntry = buildingRegistry.getValue(registryName);

                if (buildingEntry != null) isBuildingBlock = ((BlockItem) itemStack.getItem()).getBlock() == buildingEntry.getBuildingBlock();
            }

            return isBlockItem && isHut && isBuildingBlock;
        };

        return InventoryUtils.hasItemInProvider(inventory.player, predicate);
    }
}
