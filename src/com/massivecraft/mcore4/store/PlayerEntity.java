package com.massivecraft.mcore4.store;

import java.util.Collection;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import com.massivecraft.mcore4.util.PlayerUtil;
import com.massivecraft.mcore4.util.Txt;


public abstract class PlayerEntity<E extends PlayerEntity<E>> extends Entity<E, String>
{
	public Player getPlayer()
	{
		return PlayerUtil.getPlayerExact(this.getId());
	}
	
	public boolean isOnline()
	{
		return this.getPlayer() != null;
	}
	
	public boolean isOffline()
	{
		return ! isOnline();
	}
	
	/*public String getCurrentUniverse()
	{
		Player player = this.getPlayer();
		if (player == null) return null;
		
		String aspectId = this.getColl().nameAspect();
		Aspect aspect = Aspect.get(aspectId);
		
		aspect.
		
		return USelColl.i.get(aspect).select(player.getWorld().getName());
		
		
		
		
		vi ska returna ett universeId
	}
	
	public boolean isInThisUniverse()
	{
		String universe = this.getUniverse(); 
		if (universe == null) return false;
		
		String currentUniverse = this.getCurrentUniverse(); 
		if (currentUniverse == null) return false;
		
		return universe.equals(currentUniverse);
	}*/
	
	// -------------------------------------------- //
	// CHECKER UTILS
	// -------------------------------------------- //
	public boolean isGameMode(GameMode gm, boolean defaultIfOffline)
	{
		Player player = this.getPlayer();
		if (player == null || ! player.isOnline()) return defaultIfOffline;
		return player.getGameMode() == gm;
	}
	
	// -------------------------------------------- //
	// Message Sending Helpers
	// -------------------------------------------- //
	
	public void sendMessage(String msg)
	{
		Player player = this.getPlayer();
		if (player == null) return;
		player.sendMessage(msg);
	}
	
	public void sendMessage(Collection<String> msgs)
	{
		Player player = this.getPlayer();
		if (player == null) return;
		for(String msg : msgs)
		{
			player.sendMessage(msg);
		}
	}
	
	public void msg(String msg)
	{
		this.sendMessage(Txt.parse(msg));
	}
	
	public void msg(String msg, Object... args)
	{
		this.sendMessage(Txt.parse(msg, args));
	}
	
	public void msg(Collection<String> msgs)
	{
		Player player = this.getPlayer();
		if (player == null) return;
		for(String msg : msgs)
		{
			player.sendMessage(Txt.parse(msg));
		}
	}
}
