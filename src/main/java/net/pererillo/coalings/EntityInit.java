package net.pererillo.coalings;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pererillo.coalings.entity.Coaling;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CoalingsMod.MOD_ID);
    public static final RegistryObject<EntityType<Coaling>> COALING = ENTITIES.register("coaling",
            ()-> EntityType.Builder.<Coaling>of(Coaling::new, MobCategory.MONSTER)
                    .sized(0.6f,0.4f)
                    .build(new ResourceLocation(CoalingsMod.MOD_ID,"coaling").toString())

    );
}
