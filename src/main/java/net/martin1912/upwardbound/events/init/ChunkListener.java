package net.martin1912.upwardbound.events.init;

import net.martin1912.upwardbound.structures.*;
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
            } else if (randomChance == 1) {
                int x = event.x + event.random.nextInt(16);
                int y = event.random.nextInt(8) + 16;
                int z = event.z + event.random.nextInt(16);
                AmidiaCluster.generate(event.level, event.random, x, y, z);
            }
            if (event.random.nextInt(20) == 0) {
                event.level.setTile(event.x + event.random.nextInt(16), event.random.nextInt(20) + 20, event.z + event.random.nextInt(16), BlockListener.skyOres.id);
            }
            int x = event.x;
            int y = 127;
            int z = event.z;
            new BiomesDistributor().generate(event.level, event.random, x, y, z);
            //PipesStressTest.generate(event.level, event.random, x, 0, z);
        }
    }
}
