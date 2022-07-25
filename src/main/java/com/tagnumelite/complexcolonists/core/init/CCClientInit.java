package com.tagnumelite.complexcolonists.core.init;

import com.tagnumelite.complexcolonists.ComplexColonists;
import com.tagnumelite.complexcolonists.core.CCBlockEntities;
import com.tagnumelite.complexcolonists.core.CCBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.minecolonies.api.blocks.ModBlocks;
import com.minecolonies.coremod.client.render.EmptyTileEntitySpecialRenderer;

import java.util.Arrays;

@Mod.EventBusSubscriber(modid = ComplexColonists.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CCClientInit {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void doClientStuff(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(CCBlockEntities.BUILDING.get(), EmptyTileEntitySpecialRenderer::new);



        Arrays.stream(CCBlocks.getHuts())
              .forEach(hut -> ItemBlockRenderTypes.setRenderLayer(hut, renderType -> renderType.equals(
                      RenderType.cutout()) || renderType.equals(RenderType.solid())));
    }
}
