package net.martin1912.upwardbound.events.init;

import net.martin1912.upwardbound.blocks.SkyBed;
import net.martin1912.upwardbound.wrappers.ExampleBlockWithModel;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.class_467;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.level.dimension.DimensionHelper;
import net.modificationstation.stationapi.api.level.dimension.VanillaDimensions;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.template.block.TemplateBed;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;
import net.modificationstation.stationapi.api.util.Null;

public class BlockListener {

    public static TemplateBed skyBed;

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();


    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {

        System.out.println(MOD_ID);

        skyBed = new SkyBed(Identifier.of(MOD_ID, "sky_bed")).setTranslationKey(MOD_ID, "sky_bed");

    }
}
