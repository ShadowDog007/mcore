package com.massivecraft.mcore5.usys.cmd;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.mcore5.MCore;
import com.massivecraft.mcore5.Permission;
import com.massivecraft.mcore5.cmd.MCommand;
import com.massivecraft.mcore5.cmd.arg.ARMultiverse;
import com.massivecraft.mcore5.cmd.req.ReqHasPerm;
import com.massivecraft.mcore5.usys.Aspect;
import com.massivecraft.mcore5.usys.Multiverse;
import com.massivecraft.mcore5.util.Txt;

public class CmdUsysMultiverseShow extends MCommand
{
	public CmdUsysMultiverseShow()
	{
		this.addAliases("s", "show");
		this.addRequiredArg("multiverse");
		
		this.addRequirements(ReqHasPerm.get(Permission.CMD_USYS_MULTIVERSE_SHOW.node));
	}
	
	@Override
	public void perform()
	{
		Multiverse multiverse = this.arg(0, ARMultiverse.get());
		if (multiverse == null) return;
		
		msg(Txt.titleize("Multiverse: "+multiverse.getId()));
		
		for (String universe : multiverse.getUniverses())
		{
			if (universe.equals(MCore.DEFAULT)) continue;
			msg("<aqua>"+universe+"<i>: "+Txt.implodeCommaAndDot(multiverse.getWorlds(universe), "<h>%s", "<i>, ", " <i>and ", "<i>."));
		}
		msg("<aqua>default<i>: for all other worlds.");
		
		msg("");
		msg("<i>Aspects using this multiverse:");
		this.msgAspects(multiverse.myAspects());
		
		msg("");
		msg("<i>Aspects NOT using this multiverse:");
		this.msgAspects(multiverse.otherAspects());
	}
	
	public void msgAspects(List<Aspect> aspects)
	{
		List<String> ids = new ArrayList<String>();
		for (Aspect aspect : aspects)
		{
			ids.add(aspect.getId());
		}
		
		if (ids.size() == 0)
		{
			msg("<i>*none*");
		}
		else
		{
			msg(Txt.implodeCommaAndDot(ids, "<h>%s", "<i>, ", " <i>and ", "<i>."));
		}
	}
}
