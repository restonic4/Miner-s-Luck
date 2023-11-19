package me.restonic4.minersluck.fabric;

import me.restonic4.minersluck.Miner_sLuck;
import net.fabricmc.api.ModInitializer;

public class Miner_sLuckFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Miner_sLuck.init();
    }
}