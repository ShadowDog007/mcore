package com.massivecraft.mcore5.usys;

import com.massivecraft.mcore5.MCore;
import com.massivecraft.mcore5.store.Coll;

public class MultiverseColl extends Coll<Multiverse, String>
{
	// -------------------------------------------- //
	// META
	// -------------------------------------------- //
	public static MultiverseColl i = new MultiverseColl();
	
	private MultiverseColl()
	{
		super(MCore.p, "ai", "usys_multiverse", Multiverse.class, String.class, false);
	}
	
	@Override
	public void init()
	{
		super.init();
		
		// Ensure the default multiverse exits
		this.get(MCore.DEFAULT, true);
	}
	
}
