package com.tagnumelite.complexcolonists.core;

import com.tagnumelite.complexcolonists.ComplexColonists;
import com.tagnumelite.complexcolonists.api.blockentity.CCBlockEntityColonyBuilding;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CCBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(
            ForgeRegistries.BLOCK_ENTITIES, ComplexColonists.MOD_ID);

    public static final RegistryObject<BlockEntityType<? extends CCBlockEntityColonyBuilding>> BUILDING = BLOCK_ENTITIES.register(
            "colonybuilding",
            () -> BlockEntityType.Builder.of(CCBlockEntityColonyBuilding::new, CCBlocks.getHuts()).build(null));
}
