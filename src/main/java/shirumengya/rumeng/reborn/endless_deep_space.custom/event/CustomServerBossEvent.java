package shirumengya.rumeng.reborn.endless_deep_space.custom.event;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.function.Function;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBossEventPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.world.entity.Entity;

public class CustomServerBossEvent extends ServerBossEvent {
	
	private Entity entitys;
	
	public CustomServerBossEvent(Entity entity, Component p_8300_, BossEvent.BossBarColor p_8301_, BossEvent.BossBarOverlay p_8302_) {
      	super(p_8300_, p_8301_, p_8302_);
      	this.entitys = entity;
    }
    
	@Override
    public UUID getId() {
      	return this.entitys.getUUID();
   	}
}
