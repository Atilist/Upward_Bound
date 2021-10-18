package net.martin1912.upwardbound.structures;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.ItemListener;
import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;

import java.util.Random;

public class SkyLootDungeon extends Structure {
    @Override
    public boolean generate(Level level, Random rand, int x, int y, int z) {
        if (y > 5) {
            //Bottom and top plate
            int xoffset;
            int yoffset = 0;
            for (int k = 0; k < 2; k++) {
                xoffset = 0;
                for (int i = 0; i < 31; i++) {
                    int zoffset = 0;
                    for (int j = 0; j < 31; j++) {
                        level.setTileWithMetadata(x + xoffset - 15, y + yoffset, z + zoffset - 15, BlockListener.unbreakableDungeonBlocks.id, 0);
                        zoffset++;
                    }
                    xoffset++;
                }
                yoffset = 4;
            }

            //Inside cleaner (places air)
            xoffset = 0;
            for (int i = 0; i < 29; i++) {
                int zoffset = 0;
                for (int j = 0; j < 29; j++) {
                    yoffset = 1;
                    for (int k = 0; k < 3; k++) {
                        level.setTileWithMetadata(x + xoffset - 14, y + yoffset, z + zoffset - 14, 0, 0);
                        yoffset++;
                    }
                    zoffset++;
                }
                xoffset++;
            }

            //Inner walls (x length)
            int inverter = 1;
            for (int j = 0; j < 2; j++) {
                xoffset = 0;
                for (int i = 0; i < 11; i++) {
                    yoffset = 1;
                    for (int k = 0; k < 3; k++) {
                        level.setTileWithMetadata(x + xoffset - 5, y + yoffset, z + 5 * inverter, BlockListener.unbreakableDungeonBlocks.id, 1);
                        yoffset++;
                    }
                    xoffset++;
                }
                inverter -= 2;
            }

            //Inner walls (z length)
            inverter = 1;
            for (int j = 0; j < 2; j++) {
                int zoffset = 0;
                for (int i = 0; i < 9; i++) {
                    yoffset = 1;
                    for (int k = 0; k < 3; k++) {
                        level.setTileWithMetadata(x + 5 * inverter, y + yoffset, z - 4 + zoffset, BlockListener.unbreakableDungeonBlocks.id, 1);
                        yoffset++;
                    }
                    zoffset++;
                }
                inverter -= 2;
            }

            //Doors
            inverter = 1;
            for (int i = 0; i < 2; i++) {
                yoffset = 1;
                for (int j = 0; j < 3; j++) {
                    level.setTileWithMetadata(x + 5 * inverter, y + yoffset, z - 1, BlockListener.unbreakableDungeonBlocks.id, 3);
                    level.setTileWithMetadata(x + 5 * inverter, y + yoffset, z, BlockListener.unbreakableDungeonBlocks.id, 3);
                    level.setTileWithMetadata(x + 5 * inverter, y + yoffset, z + 1, BlockListener.unbreakableDungeonBlocks.id, 3);
                    yoffset++;
                }
                level.setTileWithMetadata(x + 5, y + 2, z, BlockListener.unbreakableDungeonBlocks.id, 2);
                level.setTileWithMetadata(x - 5, y + 2, z, BlockListener.unbreakableDungeonBlocks.id, 2);
                inverter -= 2;
            }

            //Chest lock, core, and switches
            level.setTileWithMetadata(x, y + 1, z, BlockListener.unbreakableDungeonBlocks.id, 6);
            level.setTileWithMetadata(x, y + 1, z + 1, BlockListener.unbreakableDungeonBlocks.id, 4);
            level.setTileWithMetadata(x, y + 1, z - 1, BlockListener.unbreakableDungeonBlocks.id, 4);
            level.setTileWithMetadata(x + 1, y + 1, z, BlockListener.unbreakableDungeonBlocks.id, 4);
            level.setTileWithMetadata(x - 1, y + 1, z, BlockListener.unbreakableDungeonBlocks.id, 4);

            //Chest lock walls
            yoffset = 2;
            for (int i = 0; i < 2; i++) {
                level.setTileWithMetadata(x, y + yoffset, z + 1, BlockListener.unbreakableDungeonBlocks.id, 3);
                level.setTileWithMetadata(x, y + yoffset, z - 1, BlockListener.unbreakableDungeonBlocks.id, 3);
                level.setTileWithMetadata(x + 1, y + yoffset, z, BlockListener.unbreakableDungeonBlocks.id, 3);
                level.setTileWithMetadata(x - 1, y + yoffset, z, BlockListener.unbreakableDungeonBlocks.id, 3);
                yoffset++;
            }

            //Outer wall (x length)
            inverter = 1;
            for (int j = 0; j < 2; j++) {
                xoffset = 0;
                for (int i = 0; i < 31; i++) {
                    yoffset = 1;
                    for (int k = 0; k < 3; k++) {
                        level.setTileWithMetadata(x + xoffset - 15, y + yoffset, z + 15 * inverter, BlockListener.unbreakableDungeonBlocks.id, 1);
                        yoffset++;
                    }
                    xoffset++;
                }
                inverter -= 2;
            }

            //Outer wall (z length)
            inverter = 1;
            for (int j = 0; j < 2; j++) {
                int zoffset = 0;
                for (int i = 0; i < 29; i++) {
                    yoffset = 1;
                    for (int k = 0; k < 3; k++) {
                        level.setTileWithMetadata(x + 15 * inverter, y + yoffset, z - 14 + zoffset, BlockListener.unbreakableDungeonBlocks.id, 1);
                        yoffset++;
                    }
                    zoffset++;
                }
                inverter -= 2;
            }

            //Outer entrances (air holes)
            inverter = 1;
            for (int i = 0; i < 2; i++) {
                yoffset = 1;
                for (int j = 0; j < 3; j++) {
                    level.setTileWithMetadata(x + 15 * inverter, y + yoffset, z - 1, 0, 0);
                    level.setTileWithMetadata(x + 15 * inverter, y + yoffset, z, 0, 0);
                    level.setTileWithMetadata(x + 15 * inverter, y + yoffset, z + 1, 0, 0);
                    yoffset++;
                }
                inverter -= 2;
            }

            //Key and pedestal placer
            level.setTileWithMetadata(x, y + 2, z + 10, BlockListener.dungeonBlocks.id, 2);
            level.setTileWithMetadata(x, y + 2, z - 10, BlockListener.dungeonBlocks.id, 3);

            level.setTileWithMetadata(x, y + 1, z + 10, BlockListener.unbreakableDungeonBlocks.id, 1);
            level.setTileWithMetadata(x, y + 1, z - 10, BlockListener.unbreakableDungeonBlocks.id, 1);

            //Chest placer and inventory filler
            level.setTile(x, y + 2, z, BlockBase.CHEST.id);
            TileEntityChest var0 = (TileEntityChest) level.getTileEntity(x, y + 2, z);
            for (int i = 0; i < 27; i++) {
                ItemInstance var1 = this.getRandomChestItem(rand);
                if (var0 != null) {
                    var0.setInventoryItem(rand.nextInt(var0.getInventorySize()), var1);
                }
            }

            level.setTile(x + 10, y + 1, z + 10, BlockBase.MOB_SPAWNER.id);
            TileEntityMobSpawner yeet0 = (TileEntityMobSpawner) level.getTileEntity(x + 10, y + 1, z + 10);
            yeet0.setEntityId(this.getRandomEntity(rand));

            level.setTile(x + 10, y + 1, z - 10, BlockBase.MOB_SPAWNER.id);
            TileEntityMobSpawner yeet1 = (TileEntityMobSpawner) level.getTileEntity(x + 10, y + 1, z - 10);
            yeet1.setEntityId(this.getRandomEntity(rand));

            level.setTile(x - 10, y + 1, z + 10, BlockBase.MOB_SPAWNER.id);
            TileEntityMobSpawner yeet2 = (TileEntityMobSpawner) level.getTileEntity(x - 10, y + 1, z + 10);
            yeet2.setEntityId(this.getRandomEntity(rand));

            level.setTile(x - 10, y + 1, z - 10, BlockBase.MOB_SPAWNER.id);
            TileEntityMobSpawner yeet3 = (TileEntityMobSpawner) level.getTileEntity(x - 10, y + 1, z - 10);
            yeet3.setEntityId(this.getRandomEntity(rand));

            return true;
        }
        else {
            return false;
        }
    }

    //Random Items List
    private ItemInstance getRandomChestItem(Random random) {
        int var2 = random.nextInt(10);
        if (var2 == 0 && random.nextInt(100) == 0) {
            return new ItemInstance(net.martin1912.BetaExtras.Block.BlockListener.thiccFlesh);
        } else if (var2 == 1) {
            return new ItemInstance(ItemBase.ironIngot, random.nextInt(4) + 1);
        } else if (var2 == 2) {
            return new ItemInstance(ItemBase.goldIngot);
        } else if (var2 == 3) {
            return new ItemInstance(net.martin1912.BetaExtras.Item.ItemListener.alphium, random.nextInt(4) + 1);
        } else if (var2 == 4 && random.nextInt(25) == 0) {
            return new ItemInstance(ItemBase.diamond);
        } else if (var2 == 5) {
            return new ItemInstance(ItemBase.string, random.nextInt(4) + 1);
        } else if (var2 == 6) {
            return new ItemInstance(ItemBase.coal);
        } else if (var2 == 7 && random.nextInt(10) == 0) {
            return new ItemInstance(net.martin1912.BetaExtras.Item.ItemListener.thiccBricc);
        } else if (var2 == 8 && random.nextInt(2) == 0) {
            return new ItemInstance(ItemBase.redstoneDust, random.nextInt(4) + 1);
        } else if (var2 == 9) {
                return new ItemInstance(ItemListener.coldEnergiumite, random.nextInt(4) + 1);
        } else {
            return null;
        }
    }

    //Random Mobs List
    private String getRandomEntity(Random random) {
        int var0 = random.nextInt(4);
        if (var0 == 0) {
            return "Skeleton";
        } else if (var0 == 1) {
            return "Zombie";
        } else if (var0 == 2) {
            return "Zombie";
        } else {
            return "Spider";
        }
    }
}
