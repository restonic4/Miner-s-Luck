package me.restonic4.minersluck.quilt;

import me.restonic4.minersluck.Miner_sLuck;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class Miner_sLuckQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        Miner_sLuck.init();
    }
}