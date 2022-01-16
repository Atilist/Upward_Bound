package net.martin1912.upwardbound.events.init;

import net.martin1912.upwardbound.blocks.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.template.block.TemplateBed;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;
import net.modificationstation.stationapi.api.template.block.TemplatePlant;
import net.modificationstation.stationapi.api.util.Null;

public class BlockListener {

    public static TemplateBed skyBed;
    public static TemplatePlant beanCrop;
    public static TemplateBlockBase energiumiteBlocks,
                                    dungeonBlocks,
                                    unbreakableDungeonBlocks,
                                    skyDirt,
                                    skyFarmland,
                                    processedAlphium,
                                    skyGrass,
                                    skyLogs,
                                    skyLeaves,
                                    coldPlants,
                                    lushPlants,
                                    goldPlants,
                                    skyShroom,
                                    stoneGrass,
                                    thinBalloonShroom,
                                    mediumSkyShroom,
                                    desertPlants,
                                    poolPlants,
                                    itemPipes;

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();


    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {

        System.out.println(MOD_ID);

        skyBed = new SkyBed(Identifier.of(MOD_ID, "sky_bed")).setTranslationKey(MOD_ID, "sky_bed");
        energiumiteBlocks = new EnergiumiteBlocks(Identifier.of(MOD_ID, "energiumite_blocks"), Material.GLASS).setHardness(1.5F).setTranslationKey(MOD_ID, "energiumite_blocks");
        dungeonBlocks = new DungeonBlocks(Identifier.of(MOD_ID, "dungeon_blocks"), Material.STONE).setHardness(1.5F).setTranslationKey(MOD_ID, "dungeon_blocks");
        unbreakableDungeonBlocks = new UnbreakableDungeonBlocks(Identifier.of(MOD_ID, "unbreakable_dungeon_blocks"), Material.STONE).setHardness(-1.0F).setBlastResistance(-1.0F).setTranslationKey(MOD_ID, "unbreakable_dungeon_blocks");
        skyDirt = new SkyDirt(Identifier.of(MOD_ID, "sky_dirt"), Material.DIRT).setHardness(0.5F).setTranslationKey(MOD_ID, "sky_dirt");
        skyFarmland = new SkyFarmland(Identifier.of(MOD_ID, "sky_farmland"), Material.DIRT).setHardness(0.5F).setTranslationKey(MOD_ID, "sky_farmland");
        beanCrop = new BeanCrop(Identifier.of(MOD_ID, "bean_crop")).setTranslationKey(MOD_ID, "bean_crop");
        processedAlphium = new ProcessedAlphium(Identifier.of(MOD_ID, "processed_alphium"), Material.STONE).setHardness(1.5F).setTranslationKey(MOD_ID, "processed_alphium");
        skyGrass = new SkyGrass(Identifier.of(MOD_ID, "sky_grass"), Material.DIRT).setHardness(0.5F).setTranslationKey(MOD_ID, "sky_grass");
        skyLogs = new SkyLogs(Identifier.of(MOD_ID, "sky_logs"), Material.WOOD).setHardness(1.5F).setTranslationKey(MOD_ID, "sky_logs");
        skyLeaves = new SkyLeaves(Identifier.of(MOD_ID, "sky_leaves"), Material.LEAVES).setHardness(0.5F).setTranslationKey(MOD_ID, "sky_leaves");
        coldPlants = new ColdPlants(Identifier.of(MOD_ID, "cold_plants"), Material.PLANT).setHardness(0.0F).setTranslationKey(MOD_ID, "cold_plants");
        lushPlants = new LushPlants(Identifier.of(MOD_ID, "lush_plants"), Material.PLANT).setHardness(0.0F).setTranslationKey(MOD_ID, "lush_plants");
        goldPlants = new GoldPlants(Identifier.of(MOD_ID, "gold_plants"), Material.PLANT).setHardness(0.0F).setTranslationKey(MOD_ID, "gold_plants");
        skyShroom = new SkyShroom(Identifier.of(MOD_ID, "sky_shroom"), Material.WOOD).setHardness(0.5F).setTranslationKey(MOD_ID, "sky_shroom");
        stoneGrass = new StoneGrass(Identifier.of(MOD_ID, "stone_grass"), Material.STONE).setHardness(1.5F).setTranslationKey(MOD_ID, "stone_grass");
        thinBalloonShroom = new ThinBalloonShroom(Identifier.of(MOD_ID, "thin_balloon_shroom"), Material.PLANT).setHardness(0.25F).setTranslationKey(MOD_ID, "thin_balloon_shroom");
        mediumSkyShroom = new MediumSkyShroom(Identifier.of(MOD_ID, "medium_sky_shroom"), Material.PLANT).setHardness(0.5F).setTranslationKey(MOD_ID, "medium_sky_shroom");
        desertPlants = new DesertPlants(Identifier.of(MOD_ID, "desert_plants"), Material.PLANT).setHardness(0.5F).setTranslationKey(MOD_ID, "desert_plants");
        poolPlants = new PoolPlants(Identifier.of(MOD_ID, "pool_plants"), Material.WOOD).setHardness(0.5F).setTranslationKey(MOD_ID, "pool_plants");
        itemPipes = new ItemPipes(Identifier.of(MOD_ID, "item_pipes"), Material.STONE).setHardness(0.5F).setTranslationKey(MOD_ID, "item_pipes");
    }
}
