package me.arcanios.Fireworks;

import org.bukkit.plugin.java.JavaPlugin;

public class Fireworks extends JavaPlugin
{
	private EventManager eventMgr;
	
	@Override
	public void onEnable() 
	{
		eventMgr = new EventManager(this);
		this.getServer().getPluginManager().registerEvents(eventMgr, this);
		
		// Command Zone
		this.getCommand("firework").setExecutor(new CommandFirework());
		this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new FireworksUpdater(), 0L, 1);
	}
	
	@Override
	public void onDisable() 
	{
		this.getServer().getScheduler().cancelAllTasks();
	}
}
