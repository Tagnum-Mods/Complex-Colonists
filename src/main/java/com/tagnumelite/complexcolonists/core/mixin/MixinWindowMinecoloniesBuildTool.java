package com.tagnumelite.complexcolonists.core.mixin;

/*
@Mixin(value = WindowExtendedBuildTool.class, remap = false)
public abstract class MixinWindowMinecoloniesBuildTool extends AbstractBlueprintManipulationWindow {


    /**
     * Overwrite the hasMatchingBlock function because the base function crashes when it tries getBuildingBlock from a
     * null BuildingEntry.
     *
     * @author TagnumElite
     * @reason The base method crashes because it tries to get a Block from a null BuildingEntry.
     */
/*
    @Overwrite
    @Override
    public boolean hasMatchingBlock(@NotNull Inventory inventory, String hut) {
        final String                        name             = hut.equals("citizen") ? "home" : hut;
        final IForgeRegistry<BuildingEntry> buildingRegistry = IBuildingRegistry.getInstance();

        Predicate<ItemStack> predicate = (itemStack) -> {
            final Item    item            = itemStack.getItem();
            final boolean isBlockItem     = item instanceof BlockItem;
            final boolean isHut           = StructureName.HUTS.contains(hut);
            boolean       isBuildingBlock = false;

            if (isBlockItem && isHut) {
                ResourceLocation        itemRegistryName = item.getRegistryName();
                final String            namespace        = (itemRegistryName != null) ? itemRegistryName.getNamespace() : Constants.MOD_ID;
                final ResourceLocation  registryName     = new ResourceLocation(namespace, name);
                @Nullable BuildingEntry buildingEntry    = buildingRegistry.getValue(registryName);

                if (buildingEntry != null) {
                    isBuildingBlock = ((BlockItem) itemStack.getItem()).getBlock() == buildingEntry.getBuildingBlock();
                }
            }

            return isBlockItem && isHut && isBuildingBlock;
        };

        return InventoryUtils.hasItemInProvider(inventory.player, predicate);
    }
}
 */