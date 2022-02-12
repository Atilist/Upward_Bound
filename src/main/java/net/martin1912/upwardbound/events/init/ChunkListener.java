package net.martin1912.upwardbound.events.init;

import net.martin1912.upwardbound.structures.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.BlockBase;
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
            int x1 = event.x;
            int y1 = 127;
            int z1 = event.z;
            new BiomesDistributor().generate(event.level, event.random, x1, y1, z1);
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
            int randomX = event.x + event.random.nextInt(16);
            int randomY = event.random.nextInt(20) + 20;
            int randomZ = event.z + event.random.nextInt(16);
            if (event.random.nextInt(20) == 0 && event.level.getTileId(randomX, randomY, randomZ) == BlockBase.STONE.id) {
                event.level.setTile(randomX, randomY, randomZ, BlockListener.skyOres.id);
            }

            //PipesStressTest.generate(event.level, event.random, x, 0, z);
        }
    }
}
