package me.cepi.gameplay.modules.mobhandler;

import org.bukkit.entity.EntityType;

import com.google.gson.annotations.SerializedName;

public enum AcceptableMob {
	@SerializedName("zombie") ZOMBIE(EntityType.ZOMBIE),
	@SerializedName("skeleton") SKELETON(EntityType.SKELETON);
	
	private EntityType type;

	private AcceptableMob (EntityType type) {
		this.type = type;
	}
	
	public EntityType getType() {
		return type;
	}
	
}