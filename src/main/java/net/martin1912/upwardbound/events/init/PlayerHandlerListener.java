package net.martin1912.upwardbound.events.init;

import net.martin1912.upwardbound.events.ingame.ExamplePlayerHandler;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.entity.player.PlayerEvent;

public class PlayerHandlerListener {

    @EventListener
    public void registerPlayerHandlers(PlayerEvent.HandlerRegister event) {
        event.playerHandlers.add(new ExamplePlayerHandler());
    }
}
