package net.pererillo.coalings.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pererillo.coalings.CoalingsMod;
import net.pererillo.coalings.EntityInit;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CoalingsMod.MOD_ID);

    public static final RegistryObject<SpawnEggItem> COALING_SPAWN_EGG = ITEMS.register("coaling_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.COALING,0x212121,0x525252, new Item.Properties()));

}
