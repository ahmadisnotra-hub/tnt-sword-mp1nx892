package com.dostmod.tnt_sword;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(TNTSwordMod.MOD_ID)
public class TNTSwordMod {
    public static final String MOD_ID = "tnt_sword";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TNTSwordMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
