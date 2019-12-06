package me.cepi.gameplay.modules.mobhandler;

import java.io.FileReader;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import com.google.gson.Gson;

public class SpawnableMob {
	
	private String name;
	private EntityType type;

	public SpawnableMob(){
		
	}
	
	public SpawnableMob(String name, EntityType type) {
		this.name = name;
		this.type = type;
	}
	
	public SpawnableMob fromJson(String file) throws IOException {
		Gson gson = new Gson();
		SpawnableMob mob = gson.fromJson(new FileReader(file), SpawnableMob.class);
		return mob;
	}
	
	public Entity compile(Location loc) {
		Entity entity = loc.getWorld().spawnEntity(loc, type);
		entity.setCustomName(this.name);
		return entity;
	}
	
}
