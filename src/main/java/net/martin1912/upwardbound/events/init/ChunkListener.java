package net.martin1912.upwardbound.events.init;

import net.martin1912.upwardbound.structures.BiomesDistributor;
import net.martin1912.upwardbound.structures.SkyLootDungeon;
import net.martin1912.upwardbound.structures.EnergiumiteCrystal;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.level.biome.Biome;
import net.minecraft.level.dimension.Overworld;
import net.modificationstation.stationapi.api.event.level.gen.LevelGenEvent;

public class ChunkListener {

    @EventListener
    public void populate(LevelGenEvent.ChunkDecoration event) {
        if (event.level.dimension instanceof Overworld) {
            int randomChance = event.random.nextInt(16);
            if (randomChance == 0) {
                int x = event.x + event.random.nextInt(16);
                int y = event.random.nextInt(32) + 16;
                int z = event.z + event.random.nextInt(16);
                new SkyLootDungeon().generate(event.level, event.random, x, y, z);
            }
        }
        if (event.biome == Biome.SKY) {
            int randomChance = event.random.nextInt(16);
            if (randomChance == 0) {
                int x = event.x + event.random.nextInt(16);
                int y = event.random.nextInt(64) + 32;
                int z = event.z + event.random.nextInt(16);
                new EnergiumiteCrystal().generate(event.level, event.random, x, y, z);
            }
            int x = event.x;
            int y = 127;
            int z = event.z;
            new BiomesDistributor().generate(event.level, event.random, x, y, z);
        }
    }
}
