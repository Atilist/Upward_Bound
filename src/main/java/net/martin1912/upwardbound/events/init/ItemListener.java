package net.martin1912.upwardbound.events.init;

import net.martin1912.upwardbound.items.SkyBedItem;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;
import net.modificationstation.stationapi.api.util.Null;

public class ItemListener {

    public static TemplateItemBase coolItem;
    public static TemplateItemBase skyBedItem;

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        skyBedItem = new SkyBedItem(Identifier.of(MOD_ID, "sky_bed_item")).setTranslationKey(MOD_ID, "sky_bed_item");
    }
}
