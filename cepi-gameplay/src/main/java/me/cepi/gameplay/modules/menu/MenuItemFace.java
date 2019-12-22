package me.cepi.gameplay.modules.menu;

public interface MenuItemFace {

	void onClick(Runnable code, Boolean toCancel);
	public void onClick(Boolean toCancel);
	
}
