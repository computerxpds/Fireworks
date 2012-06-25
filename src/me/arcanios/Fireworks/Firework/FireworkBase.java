package me.arcanios.Fireworks.Firework;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

public abstract class FireworkBase 
{
	public static ArrayList<FireworkBase> fireworksList = new ArrayList<FireworkBase>();
	Vector position;
	Vector motion;
	int fuseTime;
	World world;
	
	protected FireworkBase(World world)
	{
		position = new Vector(0, 0, 0);
		motion = new Vector(0, 0, 0);
		fuseTime = 40;
		this.world = world;
		
		fireworksList.add(this);
		launch();
	}
	
	public void update()
	{
		position.setX(position.getX() + motion.getX());
		position.setY(position.getY() + motion.getY());
		position.setZ(position.getZ() + motion.getZ());
		fuseTime--;
		if(fuseTime < 1)
			onDie();
	}
	
	public void onDie()
	{
		if(fireworksList.contains(this))
		fireworksList.remove(this);
	}
	
	public abstract void launch();
	
	public static void launch(Location loc)
	{
		FireworkSimple firework = new FireworkSimple(loc.getWorld(), loc.toVector());
	}
	
	public static void launch(String name, Location loc)
	{
		FireworkBase firework;
		if(name.equalsIgnoreCase("fire"))
		{
			firework = new FireworkFire(loc.getWorld(), loc.toVector());
		}
		else
			firework = new FireworkSimple(loc.getWorld(), loc.toVector());
			
	}
}
