package me.cepi.gameplay.modules.mobhandler;

import org.bukkit.entity.EntityType;

import com.google.gson.annotations.SerializedName;

public enum AcceptableMobs {
	@SerializedName("zombie") ZOMBIE(EntityType.ZOMBIE);
	
	private EntityType type;

	private AcceptableMobs (EntityType type) {
		this.type = type;
	}
	
	public EntityType getType() {
		return type;
	}
	
}