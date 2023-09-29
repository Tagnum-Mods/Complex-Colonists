package com.tagnumelite.complexcolonists.core;

import com.minecolonies.api.client.render.modeltype.IModelType;

import com.minecolonies.api.client.render.modeltype.SimpleModelType;
import com.minecolonies.api.client.render.modeltype.registry.IModelTypeRegistry;

import com.minecolonies.coremod.client.model.FemaleSettlerModel;
import com.minecolonies.coremod.client.model.MaleSettlerModel;

import com.minecolonies.coremod.event.ClientRegistryHandler;

import com.tagnumelite.complexcolonists.addon.complexcolonists.AddonComplexColonists;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CCModelTypes {
    public static IModelType MERCHANT;
    public static IModelType TRADER;

    // This is called in RenderBipedCitizen
    public static void init(final EntityRendererProvider.Context context) {
        IModelTypeRegistry reg = IModelTypeRegistry.getInstance();

        // TODO: Custom models
        MERCHANT = new SimpleModelType(AddonComplexColonists.MERCHANT_ID, 3, new MaleSettlerModel(context.bakeLayer(
                ClientRegistryHandler.MALE_SETTLER)), new FemaleSettlerModel(context.bakeLayer(ClientRegistryHandler.FEMALE_SETTLER)));
        reg.register(MERCHANT);

        TRADER = new SimpleModelType(AddonComplexColonists.TRADER_ID, 3, new MaleSettlerModel(context.bakeLayer(ClientRegistryHandler.MALE_SETTLER)), new FemaleSettlerModel(context.bakeLayer(ClientRegistryHandler.FEMALE_SETTLER)));
        reg.register(TRADER);
    }
}
