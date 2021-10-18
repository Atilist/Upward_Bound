package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.BlockListener;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class UnbreakableDungeonBlocks extends TemplateBlockBase {

    public UnbreakableDungeonBlocks(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public UnbreakableDungeonBlocks setHardness(float Hardness) {
        return (UnbreakableDungeonBlocks) super.setHardness(Hardness);
    }

    @Override
    public UnbreakableDungeonBlocks setBlastResistance(float resistance) {
        return (UnbreakableDungeonBlocks) super.setBlastResistance(resistance);
    }

    @Override
    public int droppedMeta(int i) {
        return i;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                return TextureListener.FloorBlock;
            case 1:
                return TextureListener.WallBlock;
            case 2:
                return TextureListener.KeyHole;
            case 3:
                return TextureListener.DoorBlock;
            case 4:
                return TextureListener.InactiveSwitch;
            case 5:
                return TextureListener.ActiveSwitch;
            case 6:
                return TextureListener.InactiveCore;
            case 7:
                return TextureListener.ActiveCore;
            default:
                return super.getTextureForSide(side, meta);
        }
    }

    @Override
    public boolean canUse(Level level, int x, int y, int z, PlayerBase player) {
        int metacheck = level.getTileMeta(x, y, z);
        if (metacheck == 4) {
            level.placeBlockWithMetaData(x, y, z, BlockListener.unbreakableDungeonBlocks.id, 5);
            return true;
        }
        else if (metacheck == 7) {
            level.placeBlockWithMetaData(x + 1, y, z, 0, 0);
            level.placeBlockWithMetaData(x - 1, y, z, 0, 0);
            level.placeBlockWithMetaData(x, y, z + 1, 0, 0);
            level.placeBlockWithMetaData(x, y, z - 1, 0, 0);

            //Bottom and top plate
            int xoffset;
            int yoffset = -1;
            for (int k = 0; k < 2; k++) {
                xoffset = 0;
                for (int i = 0; i < 31; i++) {
                    int zoffset = 0;
                    for (int j = 0; j < 31; j++) {
                        level.setTileWithMetadata(x + xoffset - 15, y + yoffset, z + zoffset - 15, BlockListener.dungeonBlocks.id, 0);
                        zoffset++;
                    }
                    xoffset++;
                }
                yoffset = 3;
            }

            //Outer wall (x length)
            int inverter = 1;
            for (int j = 0; j < 2; j++) {
                xoffset = 0;
                for (int i = 0; i < 31; i++) {
                    yoffset = 1;
                    for(int k = 0; k < 3; k++) {
                        level.setTileWithMetadata(x + xoffset - 15, y + yoffset - 1, z + 15 * inverter, BlockListener.dungeonBlocks.id, 1);
                        yoffset++;
                    }
                    xoffset++;
                }
                inverter-=2;
            }

            //Outer wall (z length)
            inverter = 1;
            for (int j = 0; j < 2; j++) {
                int zoffset = 0;
                for (int i = 0; i < 29; i++) {
                    yoffset = 1;
                    for(int k = 0; k < 3; k++) {
                        level.setTileWithMetadata(x + 15 * inverter, y + yoffset - 1, z - 14 + zoffset, BlockListener.dungeonBlocks.id, 1);
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
                    level.setTileWithMetadata(x + 15 * inverter, y + yoffset - 1, z - 1, 0, 0);
                    level.setTileWithMetadata(x + 15 * inverter, y + yoffset - 1, z, 0, 0);
                    level.setTileWithMetadata(x + 15 * inverter, y + yoffset - 1, z + 1, 0, 0);
                    yoffset++;
                }
                inverter -= 2;
            }

            level.setTileWithMetadata(x, y, z, 0, 0);

            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int id) {
        int metacheck = level.getTileMeta(x, y, z);
        int activationcheck1 = level.getTileMeta(x + 1, y, z);
        int activationcheck2 = level.getTileMeta(x - 1, y, z);
        int activationcheck3 = level.getTileMeta(x, y, z + 1);
        int activationcheck4 = level.getTileMeta(x, y, z - 1);
        if (metacheck == 6 && activationcheck1 == 5 && activationcheck2 == 5 && activationcheck3 == 5 && activationcheck4 == 5) {
            level.placeBlockWithMetaData(x, y, z, BlockListener.unbreakableDungeonBlocks.id, 7);
            int yoffset = 1;
            for (int i = 0; i < 2; i++) {
                level.placeBlockWithMetaData(x, y + yoffset, z + 1, 0, 0);
                level.placeBlockWithMetaData(x, y + yoffset, z - 1, 0, 0);
                level.placeBlockWithMetaData(x + 1, y + yoffset, z, 0, 0);
                level.placeBlockWithMetaData(x - 1, y + yoffset, z, 0, 0);
                yoffset++;
            }

            level.placeBlockWithMetaData(x + 10, y, z + 10, 0, 0);
            level.placeBlockWithMetaData(x + 10, y, z - 10, 0, 0);
            level.placeBlockWithMetaData(x - 10, y, z + 10, 0, 0);
            level.placeBlockWithMetaData(x - 10, y, z - 10, 0, 0);

            level.placeBlockWithMetaData(x, y, z + 10, 0, 0);
            level.placeBlockWithMetaData(x, y, z - 10, 0, 0);

            //Inner walls (x length)
            int inverter = 1;
            for (int j = 0; j < 2; j++) {
                int xoffset = 0;
                for (int i = 0; i < 11; i++) {
                    yoffset = 1;
                    for(int k = 0; k < 3; k++) {
                        level.setTileWithMetadata(x + xoffset - 5, y + yoffset - 1, z + 5 * inverter, 0, 0);
                        yoffset++;
                    }
                    xoffset++;
                }
                inverter-=2;
            }

            //Inner walls (z length)
            inverter = 1;
            for (int j = 0; j < 2; j++) {
                int zoffset = 0;
                for (int i = 0; i < 9; i++) {
                    yoffset = 1;
                    for(int k = 0; k < 3; k++) {
                        level.setTileWithMetadata(x + 5 * inverter, y + yoffset - 1, z - 4 + zoffset, 0, 1);
                        yoffset++;
                    }
                    zoffset++;
                }
                inverter -= 2;
            }

            inverter = 1;
            for (int i = 0; i < 2; i++) {
                yoffset = 0;
                for (int j = 0; j < 3; j++) {
                    level.placeBlockWithMetaData(x + 5 * inverter, y + yoffset, z + 1, 0, 0);
                    level.placeBlockWithMetaData(x + 5 * inverter, y + yoffset, z, 0, 0);
                    level.placeBlockWithMetaData(x + 5 * inverter, y + yoffset, z - 1, 0, 0);
                    yoffset++;
                }
                inverter -= 2;
            }
        }
    }
}
