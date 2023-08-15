package net.pererillo.coalings.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pererillo.coalings.client.model.CoalingModel;
import net.pererillo.coalings.client.renderer.CoalingRenderer;
import net.pererillo.coalings.CoalingsMod;
import net.pererillo.coalings.EntityInit;
@Mod.EventBusSubscriber(modid = CoalingsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.COALING.get(), CoalingRenderer::new);
    }
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CoalingModel.LAYER_LOCATION,CoalingModel::createBodyLayer);
    }
}
