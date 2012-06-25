package me.arcanios.Fireworks;

import me.arcanios.Fireworks.Firework.FireworkBase;

public class FireworksUpdater implements Runnable
{
	public void run() 
	{
		if(FireworkBase.fireworksList.isEmpty())
			return;
		
		for(int i = 0; i < FireworkBase.fireworksList.size(); i++)
			FireworkBase.fireworksList.get(i).update();
	}
}
