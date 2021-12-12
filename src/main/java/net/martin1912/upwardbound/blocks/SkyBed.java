package net.martin1912.upwardbound.blocks;

import net.martin1912.upwardbound.events.init.ItemListener;
import net.martin1912.upwardbound.travelagent.SkyBedTravelAgent;
import net.minecraft.class_467;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import net.minecraft.util.SleepStatus;
import net.minecraft.util.Vec3i;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.level.dimension.DimensionHelper;
import net.modificationstation.stationapi.api.level.dimension.VanillaDimensions;
import net.modificationstation.stationapi.api.registry.DimensionRegistry;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBed;

import java.util.Random;


@HasMetaNamedBlockItem
public class SkyBed extends TemplateBed {

    public SkyBed(Identifier identifier) {
        super(identifier);
        setSounds(WOOD.sounds);
    }

    @Override
    public SkyBed setHardness(float Hardness) {
        return (SkyBed) super.setHardness(Hardness);
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta) {
            case 0:
                switch (side) {
                    case 0:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedUnderside;
                    case 1:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedTopBody;
                    case 2:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedBack;
                    case 3:
                    case 4:
                    case 5:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedSideBody;
                }
            case 1:
                switch (side) {
                    case 0:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedUnderside;
                    case 1:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedTopBody;
                    case 2:
                    case 3:
                    case 4:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedSideBody;
                    case 5:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedBack;
                }
            case 2:
                switch (side) {
                    case 0:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedUnderside;
                    case 1:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedTopBody;
                    case 2:
                    case 3:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedBack;
                    case 4:
                    case 5:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedSideBody;
                }
            case 3:
                switch (side) {
                    case 0:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedUnderside;
                    case 1:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedTopBody;
                    case 2:
                    case 3:
                    case 5:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedSideBody;
                    case 4:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedBack;

                }
            case 4:
            case 5:
            case 7:
            case 6:
                return net.martin1912.upwardbound.events.init.TextureListener.BedWrong;
            case 8:
                switch (side) {
                    case 0:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedUnderside;
                    case 1:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedTopHead;
                    case 2:
                    case 4:
                    case 5:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedSideHead;
                    case 3:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedFront;
                }
            case 9:
                switch (side) {
                    case 0:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedUnderside;
                    case 1:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedTopHead;
                    case 2:
                    case 3:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedSideHead;
                    case 4:
                    case 5:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedFront;
                }
            case 10:
                switch (side) {
                    case 0:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedUnderside;
                    case 1:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedTopHead;
                    case 2:
                    case 3:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedFront;
                    case 4:
                    case 5:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedSideHead;
                }
            case 11:
                switch (side) {
                    case 0:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedUnderside;
                    case 1:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedTopHead;
                    case 2:
                    case 3:
                    case 4:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedSideHead;
                    case 5:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedFront;

                }
            case 12:
                switch (side) {
                    case 0:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedUnderside;
                    case 1:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedTopHead;
                    case 2:
                    case 4:
                    case 5:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedSideHead;
                    case 3:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedFront;
                }
            case 13:
                switch (side) {
                    case 0:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedUnderside;
                    case 1:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedTopHead;
                    case 2:
                    case 3:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedSideHead;
                    case 4:
                    case 5:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedFront;
                }
            case 14:
                switch (side) {
                    case 0:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedUnderside;
                    case 1:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedTopHead;
                    case 2:
                    case 3:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedFront;
                    case 4:
                    case 5:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedSideHead;
                }
            case 15:
                switch (side) {
                    case 0:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedUnderside;
                    case 1:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedTopHead;
                    case 2:
                    case 3:
                    case 4:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedSideHead;
                    case 5:
                        return net.martin1912.upwardbound.events.init.TextureListener.BedFront;

                }
            default:
                return super.getTextureForSide(side, meta);
        }
    }

    @Override
    public boolean canUse(Level level, int x, int y, int z, PlayerBase player) {
        if (!level.isClient) {
            int var6 = level.getTileMeta(x, y, z);
            if (!isFoot(var6)) {
                int var7 = orientationOnly(var6);
                x += SPAWN_OFFSETS[var7][0];
                z += SPAWN_OFFSETS[var7][1];
                if (level.getTileId(x, y, z) != this.id) {
                    return true;
                }

                var6 = level.getTileMeta(x, y, z);
            }

            if (!level.dimension.canPlayerSleep()) {
                level.setTile(x, y, z, 0);
                int var13 = orientationOnly(var6);
                x += SPAWN_OFFSETS[var13][0];
                z += SPAWN_OFFSETS[var13][1];
                level.createExplosion(null, (float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F, 5.0F, true);
            } else {
                if (isOccupied(var6)) {
                    PlayerBase var14 = null;

                    for (Object o : level.players) {
                        PlayerBase var9 = (PlayerBase) o;
                        if (var9.isSleeping()) {
                            Vec3i var10 = var9.bedPosition;
                            if (var10.x == x && var10.y == y && var10.z == z) {
                                var14 = var9;
                            }
                        }
                    }

                    if (var14 != null) {
                        player.sendMessage("tile.bed.occupied");
                        return true;
                    }

                    setOccupied(level, x, y, z, false);
                }

                SleepStatus var15 = player.trySleep(x, y, z);
                if (var15 == SleepStatus.OK) {
                    player.wakeUp(true, true, true);
                    DimensionHelper.switchDimension(player, VanillaDimensions.SKYLANDS, 1.0, TravelBoi , "Ascending to the Skylands", "Waking up from the Skylands");
                } else {
                    if (var15 == SleepStatus.DAY_TIME) {
                        if (player.dimensionId == DimensionRegistry.INSTANCE.getSerialID(VanillaDimensions.SKYLANDS).orElseThrow(RuntimeException::new)) {
                            player.wakeUp(true, true, true);
                            DimensionHelper.switchDimension(player, VanillaDimensions.SKYLANDS, 1.0, TravelBoi , "Ascending to the Skylands", "Waking up from the Skylands");
                        } else {
                            player.sendMessage("tile.bed.noSleep");
                        }
                    }

                }
            }
        }
        return true;
    }

    private final class_467 TravelBoi = new SkyBedTravelAgent();

    @Override
    public int getDropId(int meta, Random rand) {
        return isFoot(meta) ? 0 : ItemListener.skyBedItem.id;
    }
}
