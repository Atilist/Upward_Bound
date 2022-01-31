package net.martin1912.upwardbound.events.init;

import net.martin1912.upwardbound.items.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;
import net.modificationstation.stationapi.api.util.Null;

public class ItemListener {

    public static TemplateItemBase  skyBedItem,
                                    coldEnergiumite,
                                    dungeonKey,
                                    dungeonKeyBody,
                                    dungeonKeyHead,
                                    skyBean,
                                    robustString,
                                    pureAlphium,
                                    alphiumHoe,
                                    rodOfDreams,
                                    energiumite,
                                    amidiaIngot,
                                    sensitiveDust,
                                    sensorCrystal,
                                    skyStraw,
                                    goldLettuceSeeds;

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        skyBedItem = new SkyBedItem(Identifier.of(MOD_ID, "sky_bed_item")).setTranslationKey(MOD_ID, "sky_bed_item");
        coldEnergiumite = new ColdEnergiumite(Identifier.of(MOD_ID, "cold_energiumite")).setTranslationKey(MOD_ID, "cold_energiumite");
        dungeonKey = new DungeonKey(Identifier.of(MOD_ID, "dungeon_key")).setTranslationKey(MOD_ID, "dungeon_key");
        dungeonKeyBody = new DungeonKeyBody(Identifier.of(MOD_ID, "dungeon_key_body")).setTranslationKey(MOD_ID, "dungeon_key_body");
        dungeonKeyHead = new DungeonKeyHead(Identifier.of(MOD_ID, "dungeon_key_head")).setTranslationKey(MOD_ID, "dungeon_key_head");
        skyBean = new SkyBean(Identifier.of(MOD_ID, "sky_bean")).setTranslationKey(MOD_ID, "sky_bean");
        robustString = new RobustString(Identifier.of(MOD_ID, "robust_string")).setTranslationKey(MOD_ID, "robust_string");
        pureAlphium = new PureAlphium(Identifier.of(MOD_ID, "pure_alphium")).setTranslationKey(MOD_ID, "pure_alphium");
        alphiumHoe = new AlphiumHoe(Identifier.of(MOD_ID, "alphium_hoe")).setTranslationKey(MOD_ID, "alphium_hoe");
        rodOfDreams = new RodOfDreams(Identifier.of(MOD_ID, "rod_of_dreams")).setTranslationKey(MOD_ID, "rod_of_dreams");
        energiumite = new Energiumite(Identifier.of(MOD_ID, "energiumite")).setTranslationKey(MOD_ID, "energiumite");
        amidiaIngot = new AmidiaIngot(Identifier.of(MOD_ID, "amidia_ingot")).setTranslationKey(MOD_ID, "amidia_ingot");
        sensitiveDust = new SensitiveDust(Identifier.of(MOD_ID, "sensitive_dust")).setTranslationKey(MOD_ID, "sensitive_dust");
        sensorCrystal = new SensorCrystal(Identifier.of(MOD_ID, "sensor_crystal")).setTranslationKey(MOD_ID, "sensor_crystal");
        skyStraw = new SkyStraw(Identifier.of(MOD_ID, "sky_straw")).setTranslationKey(MOD_ID, "sky_straw");
        goldLettuceSeeds = new GoldLettuceSeeds(Identifier.of(MOD_ID, "gold_lettuce_seeds")).setTranslationKey(MOD_ID, "gold_lettuce_seeds");
    }
}
