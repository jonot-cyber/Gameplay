package me.cepi.gameplay.modules.mobhandler;

import org.bukkit.entity.EntityType;

import com.google.gson.annotations.SerializedName;

public enum AcceptableMobs {
	@SerializedName("zombie") ZOMBIE(EntityType.ZOMBIE);
	
	public EntityType type;

	private AcceptableMobs (EntityType type) {
		this.type = type;
	}
	
}