package net.martin1912.upwardbound.events.init;

import net.martin1912.BetaExtras.level.gen.structure.SwampTree;
import net.martin1912.upwardbound.structures.EnergiumiteCrystal;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.level.biome.Biome;
import net.modificationstation.stationapi.api.event.level.gen.LevelGenEvent;

public class ChunkListener {

    @EventListener
    public void populate(LevelGenEvent.ChunkDecoration event) {

        if (event.biome == Biome.SKY) {
            int randomChance = event.random.nextInt(16);
            if (randomChance == 0) {
                int x = event.x + event.random.nextInt(16);
                int y = event.random.nextInt(64) + 32;
                int z = event.z + event.random.nextInt(16);
                new EnergiumiteCrystal().generate(event.level, event.random, x, y, z);
            }
        }
    }
}
