package net.martin1912.upwardbound.events.init;

import net.martin1912.upwardbound.structures.DirtReplacer;
import net.martin1912.upwardbound.structures.SkyLootDungeon;
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
        if (event.biome != Biome.SKY && event.biome != Biome.NETHER) {
            int randomChance = event.random.nextInt(16);
            if (randomChance == 0) {
                int x = event.x + event.random.nextInt(16);
                int y = event.random.nextInt(32) + 16;
                int z = event.z + event.random.nextInt(16);
                new SkyLootDungeon().generate(event.level, event.random, x, y, z);
            }
        }
        if (event.biome == Biome.SKY) {
            int x = event.x;
            int y = 127;
            int z = event.z;
            new DirtReplacer().generate(event.level, event.random, x, y, z);
        }
    }
}
