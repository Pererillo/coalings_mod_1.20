package net.pererillo.coalings.events;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pererillo.coalings.CoalingsMod;
import net.pererillo.coalings.EntityInit;
import net.pererillo.coalings.entity.Coaling;

@Mod.EventBusSubscriber(modid = CoalingsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvent {
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.COALING.get(), Coaling.createAttributes().build());
    }
    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(EntityInit.COALING.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                Coaling::canSpawn,
                SpawnPlacementRegisterEvent.Operation.OR
        );
    }

}
