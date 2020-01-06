package me.cepi.gameplay.modules.mobhandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import me.cepi.gameplay.Main;
import me.cepi.gameplay.modules.itemhandler.CustomItem;
import net.md_5.bungee.api.ChatColor;

public class SpawnableMob {

	private String name;
	private AcceptableMob type;
	private CustomItem mainHand;
	private CustomItem offHand;

	public SpawnableMob(String name, AcceptableMob type) {
		this.name = name;
		this.type = type;
	}

	public SpawnableMob(String name, AcceptableMob type, CustomItem mainHand, CustomItem offHand) {
		this.name = name;
		this.type = type;
		if (mainHand != null) this.mainHand = mainHand;
		if (offHand != null) this.offHand = offHand;
	}

	public static SpawnableMob fromJson(File file) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		JsonDeserializer<SpawnableMob> deserializer = new JsonDeserializer<SpawnableMob>() {
			public SpawnableMob deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				JsonObject jsonObject = json.getAsJsonObject();
				String stringType = jsonObject.get("type").getAsString();
				AcceptableMob mob = null;
				for (AcceptableMob acceptableMob : AcceptableMob.values()) {
					if (stringType.equalsIgnoreCase(acceptableMob.name())) {
						mob = acceptableMob;
						break;
					}
				}
				CustomItem mainHand = null;
				if (!jsonObject.get("mainHand").isJsonNull()) {
					String path = Main.getPlugin(Main.class).getServer().getWorldContainer().getAbsolutePath();
					path = path.substring(0, path.length() - 1) + "items\\" + jsonObject.get("mainHand").getAsString() + ".json";
					File file = new File(path);
					try {
						mainHand = CustomItem.fromJson(file);
					} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				CustomItem offHand = null;
				if (!jsonObject.get("offHand").isJsonNull()) {
					String path = Main.getPlugin(Main.class).getServer().getWorldContainer().getAbsolutePath();
					path = path.substring(0, path.length() - 1) + "items\\" + jsonObject.get("offHand").getAsString() + ".json";
					File file = new File(path);
					try {
						offHand = CustomItem.fromJson(file);
					} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				return new SpawnableMob(ChatColor.translateAlternateColorCodes('&', jsonObject.get("name").getAsString()), mob, mainHand, offHand);
			}
		};
		gsonBuilder.registerTypeAdapter(SpawnableMob.class, deserializer);
		Gson gson = gsonBuilder.create();
		SpawnableMob mob = gson.fromJson(new FileReader(file), SpawnableMob.class);
		return mob;
	}

	public Entity spawnMob(Location loc) {
		LivingEntity entity = (LivingEntity) loc.getWorld().spawnEntity(loc, type.getType());
		entity.setCustomName(this.name);
		if (mainHand != null)
			entity.getEquipment().setItemInMainHand(mainHand.toItem());
		if (offHand != null)
			entity.getEquipment().setItemInOffHand(offHand.toItem());
		return entity;
	}

	public EntityType getType() {
		return type.getType();
	}

}
