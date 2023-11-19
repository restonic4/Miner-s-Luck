package me.restonic4.minersluck.forge;

import dev.architectury.platform.forge.EventBuses;
import me.restonic4.minersluck.Miner_sLuck;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Miner_sLuck.MOD_ID)
public class Miner_sLuckForge {
    public Miner_sLuckForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Miner_sLuck.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Miner_sLuck.init();
    }
}