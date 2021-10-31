package net.martin1912.upwardbound.items;


import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

public class Energiumite extends TemplateItemBase {
    public Energiumite(Identifier identifier) {
        super(identifier);
    }

    @Override
    public ItemInstance use(ItemInstance item, Level level, PlayerBase player) {
        player.velocityY = 1;
    return item;
    }
}
