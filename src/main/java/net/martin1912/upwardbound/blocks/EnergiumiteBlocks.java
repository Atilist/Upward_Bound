package net.martin1912.upwardbound.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.martin1912.upwardbound.events.init.TextureListener;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

@HasMetaNamedBlockItem
public class EnergiumiteBlocks extends TemplateBlockBase {

    public EnergiumiteBlocks(Identifier identifier, Material material) {
        super(identifier, material);
        setSounds(GLASS.sounds);
    }

    @Override
    public EnergiumiteBlocks setHardness(float Hardness) {
        return (EnergiumiteBlocks) super.setHardness(Hardness);
    }

    @Override
    public int droppedMeta(int i) {
        return i;
    }

    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                return TextureListener.InnerEnergiumite;
            case 1:
                return TextureListener.OuterEnergiumite;
                /*
                case 2:
                return TextureListener.SkyWindow;
            case 3:
                switch (side) {
                    case 0:
                    case 1:
                    return TextureListener.SkyWindow;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        return TextureListener.SkyTruss;
                }
            case 4:
                return TextureListener.SkyBridge;
            case 5:
                return TextureListener.ColdInnerEnergiumite;
            case 6:
                return TextureListener.ColdOuterEnergiumite;

                 */
            default:
                return super.getTextureForSide(side, meta);}
    }

    @Override
    public boolean canUse(Level level, int x, int y, int z, PlayerBase player) {
        int selfCheck = level.getTileMeta(x, y, z);
        if (selfCheck == 4) {
            int aroundCheck0 = level.getTileId(x + 1, y, z);
            int aroundCheck1 = level.getTileMeta(x + 1, y, z);
            int aroundCheck2 = level.getTileId(x - 1, y, z);
            int aroundCheck3 = level.getTileMeta(x - 1, y, z);
            int aroundCheck4 = level.getTileId(x, y, z + 1);
            int aroundCheck5 = level.getTileMeta(x, y, z + 1);
            int aroundCheck6 = level.getTileId(x, y, z - 1);
            int aroundCheck7 = level.getTileMeta(x, y, z - 1);
            if (aroundCheck0 == net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id && aroundCheck1 == 4) {
                level.placeBlockWithMetaData(x, y, z, 0, 0);
                level.placeBlockWithMetaData(x + 1, y, z, 0, 0);
                for (int yes = 2; yes < 52; yes+=5) {
                    level.placeBlockWithMetaData(x + yes, y - 1, z - 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x + yes, y - 1, z,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x + yes, y - 1, z + 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x + 1 + yes, y - 1, z - 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x + 1 + yes, y - 1, z,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x + 1 + yes, y - 1, z + 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);

                    level.placeBlockWithMetaData(x + 2 + yes, y - 1, z - 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x + 2 + yes, y - 3, z,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 1);
                    level.placeBlockWithMetaData(x + 2 + yes, y - 2, z,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 1);
                    level.placeBlockWithMetaData(x + 2 + yes, y - 1, z,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 1);
                    level.placeBlockWithMetaData(x + 2 + yes, y - 1, z + 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);

                    level.placeBlockWithMetaData(x + 3 + yes, y - 1, z - 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x + 3 + yes, y - 1, z,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x + 3 + yes, y - 1, z + 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x + 4 + yes, y - 1, z - 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x + 4 + yes, y - 1, z,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x + 4 + yes, y - 1, z + 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                }
                return true;
            }
            else if (aroundCheck2 ==net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id && aroundCheck3 == 4) {
                level.placeBlockWithMetaData(x, y, z, 0, 0);
                level.placeBlockWithMetaData(x - 1, y, z, 0, 0);
                for (int yes = 2; yes < 52; yes+=5) {
                    level.placeBlockWithMetaData(x - yes, y - 1, z - 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x - yes, y - 1, z,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x - yes, y - 1, z + 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x - 1 - yes, y - 1, z - 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x - 1 - yes, y - 1, z,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x - 1 - yes, y - 1, z + 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);

                    level.placeBlockWithMetaData(x - 2 - yes, y - 1, z - 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x - 2 - yes, y - 3, z,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 1);
                    level.placeBlockWithMetaData(x - 2 - yes, y - 2, z,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 1);
                    level.placeBlockWithMetaData(x - 2 - yes, y - 1, z,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 1);
                    level.placeBlockWithMetaData(x - 2 - yes, y - 1, z + 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);

                    level.placeBlockWithMetaData(x - 3 - yes, y - 1, z - 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x - 3 - yes, y - 1, z,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x - 3 - yes, y - 1, z + 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x - 4 - yes, y - 1, z - 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x - 4 - yes, y - 1, z,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x - 4 - yes, y - 1, z + 1,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                }
                return true;
            }
            else if (aroundCheck4 ==net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id && aroundCheck5 == 4) {
                level.placeBlockWithMetaData(x, y, z, 0, 0);
                level.placeBlockWithMetaData(x, y, z + 1, 0, 0);
                for (int yes = 2; yes < 52; yes+=5) {
                    level.placeBlockWithMetaData(x - 1, y - 1, z + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x, y - 1, z + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x + 1, y - 1, z + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x - 1, y - 1, z + 1 + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x, y - 1, z + 1 + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x + 1, y - 1, z + 1 + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);

                    level.placeBlockWithMetaData(x - 1, y - 1, z + 2 + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x, y - 3, z + 2 + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 1);
                    level.placeBlockWithMetaData(x, y - 2, z + 2 + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 1);
                    level.placeBlockWithMetaData(x, y - 1, z + 2 + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 1);
                    level.placeBlockWithMetaData(x + 1, y - 1, z + 2 + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);

                    level.placeBlockWithMetaData(x - 1, y - 1, z + 3 + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x, y - 1, z + 3 + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x + 1, y - 1, z + 3 + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x - 1, y - 1, z + 4 + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x, y - 1, z + 4 + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x + 1, y - 1, z + 4 + yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                }
                return true;
            }
            else if (aroundCheck6 ==net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id && aroundCheck7 == 4) {
                level.placeBlockWithMetaData(x, y, z, 0, 0);
                level.placeBlockWithMetaData(x, y, z - 1, 0, 0);
                for (int yes = 2; yes < 52; yes+=5) {
                    level.placeBlockWithMetaData(x - 1, y - 1, z - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x, y - 1, z - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x + 1, y - 1, z - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x - 1, y - 1, z - 1 - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x, y - 1, z - 1 - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x + 1, y - 1, z - 1 - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);

                    level.placeBlockWithMetaData(x - 1, y - 1, z - 2 - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x, y - 3, z - 2 - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 1);
                    level.placeBlockWithMetaData(x, y - 2, z - 2 - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 1);
                    level.placeBlockWithMetaData(x, y - 1, z - 2 - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 1);
                    level.placeBlockWithMetaData(x + 1, y - 1, z - 2 - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);

                    level.placeBlockWithMetaData(x - 1, y - 1, z - 3 - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x, y - 1, z - 3 - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x + 1, y - 1, z - 3 - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x - 1, y - 1, z - 4 - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                    level.placeBlockWithMetaData(x, y - 1, z - 4 - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 2);
                    level.placeBlockWithMetaData(x + 1, y - 1, z - 4 - yes,net.martin1912.upwardbound.events.init.BlockListener.energiumiteBlocks.id, 3);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Environment(EnvType.CLIENT)
    public int getRenderPass() {
        return 1;
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }
}
