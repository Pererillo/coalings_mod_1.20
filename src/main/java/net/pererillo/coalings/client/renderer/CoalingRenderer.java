package net.pererillo.coalings.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.pererillo.coalings.client.model.CoalingModel;
import net.pererillo.coalings.CoalingsMod;
import net.pererillo.coalings.entity.Coaling;

public class CoalingRenderer extends MobRenderer<Coaling, CoalingModel<Coaling>> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(CoalingsMod.MOD_ID, "textures/entity/coaling_texture.png");
    public CoalingRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new CoalingModel<>(ctx.bakeLayer(CoalingModel.LAYER_LOCATION)), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(Coaling entity) {
        return TEXTURE;
    }
}
