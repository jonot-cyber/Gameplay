package me.cepi.gameplay.modules.mobhandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class SpawnableMob {
	
	private String name;
	private AcceptableMob type;

	public SpawnableMob(String name, AcceptableMob type) {
		this.name = name;
		this.type = type;
	}
	
	public static SpawnableMob fromJson(File file) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Gson gson = new GsonBuilder().create();
		SpawnableMob mob = gson.fromJson(new FileReader(file), SpawnableMob.class);
		Bukkit.broadcastMessage(mob.getType().toString());
		return mob;
	}
	
	public Entity spawnMob(Location loc) {
		Bukkit.broadcastMessage(type.toString());
		Entity entity = loc.getWorld().spawnEntity(loc, type.getType());
		entity.setCustomName(this.name);
		return entity;
	}
	
	public EntityType getType() {
		return type.getType();
	}
	
}
