package com.tagnumelite.complexcolonists.core.mixin;

import com.minecolonies.api.client.render.modeltype.CitizenModel;
import com.minecolonies.api.entity.citizen.AbstractEntityCitizen;
import com.minecolonies.coremod.client.render.RenderBipedCitizen;

import com.tagnumelite.complexcolonists.ComplexColonists;
import com.tagnumelite.complexcolonists.core.CCModelTypes;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RenderBipedCitizen.class, remap=false)
public abstract class MixinRenderBipedCitizen extends MobRenderer<AbstractEntityCitizen, CitizenModel<AbstractEntityCitizen>> {
    public MixinRenderBipedCitizen(
            EntityRendererProvider.Context pContext, CitizenModel<AbstractEntityCitizen> pModel, float pShadowRadius
    ) {
        super(pContext, pModel, pShadowRadius);
    }

    @Inject(method="<init>", at=@At("RETURN"))
    private void onConstructed(EntityRendererProvider.Context context, CallbackInfo ci) {
        ComplexColonists.LOGGER.info("[RenderBipedCitizen::Mixin]: Init CCModelTypes!");
        CCModelTypes.init(context);
    }
}
