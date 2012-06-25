package me.arcanios.Fireworks.Firework;

import java.util.Random;

import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class FireworkFire extends FireworkBase
{

	protected FireworkFire(World world, Vector pos) 
	{
		super(world);
		position = pos;
		
		Random rand = new Random();
		if(rand.nextInt(2) == 1)
			motion.setX(rand.nextFloat() / 3F);
		else
			motion.setX(-rand.nextFloat() / 3F);
		
		if(rand.nextInt(2) == 1)
			motion.setZ(rand.nextFloat() / 3F);
		else
			motion.setZ(-rand.nextFloat() / 3F);
		motion.setY(1.2F);
		
		int fuseDeviation = rand.nextInt(15);
		if(rand.nextInt(2) == 1)
			fuseDeviation = -fuseDeviation;
		 fuseTime += fuseDeviation;
	}

	public void launch() 
	{
		world.playEffect(position.toLocation(world), Effect.EXTINGUISH, 1);
	}
	
	public void update() 
	{
		super.update();
		world.playEffect(position.toLocation(world), Effect.MOBSPAWNER_FLAMES, 0);
	}
	
	public void onDie() {
		world.createExplosion(position.toLocation(world), 0);
		super.onDie();
	}
}
