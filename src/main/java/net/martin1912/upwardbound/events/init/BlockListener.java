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
    public static TemplateBlockBase energiumiteBlocks;
    public static TemplateBlockBase dungeonBlocks;
    public static TemplateBlockBase unbreakableDungeonBlocks;
    public static TemplateBlockBase skyDirt;
    public static TemplateBlockBase skyFarmland;
    public static TemplatePlant beanCrop;
    public static TemplateBlockBase processedAlphium;
    public static TemplateBlockBase skyGrass;
    public static TemplateBlockBase skyLogs;
    public static TemplateBlockBase skyLeaves;
    public static TemplateBlockBase coldPlants;

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
        skyLeaves = new SkyLeaves(Identifier.of(MOD_ID, "sky_leaves"), Material.WOOD).setHardness(1.5F).setTranslationKey(MOD_ID, "sky_leaves");
        coldPlants = new ColdPlants(Identifier.of(MOD_ID, "cold_plants"), Material.PLANT).setHardness(0.0F).setTranslationKey(MOD_ID, "cold_plants");
    }
}
