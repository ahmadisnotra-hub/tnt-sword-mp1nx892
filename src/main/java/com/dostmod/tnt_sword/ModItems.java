package com.dostmod.tnt_sword;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TNTSwordMod.MOD_ID);

    public static final RegistryObject<Item> TNT_SWORD = ITEMS.register("tnt_sword",
            () -> new TNTSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
