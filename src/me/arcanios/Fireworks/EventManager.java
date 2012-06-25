package me.arcanios.Fireworks;

import java.util.ArrayList;

import me.arcanios.Fireworks.Firework.FireworkBase;
import me.arcanios.Fireworks.Firework.FireworkSimple;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventManager implements Listener
{
	Fireworks instance;
	public EventManager(Fireworks instance)
	{
		this.instance = instance;
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			if(event.getClickedBlock().getType() == Material.DRAGON_EGG)
				event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onRedstoneChange(BlockRedstoneEvent event)
	{
		checkBlock(event.getBlock());
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event)
	{
		if(event.getBlock().getType() == Material.REDSTONE_TORCH_ON)
			checkBlock(event.getBlock());
	}
	
	public void checkBlock(Block block)
	{
		for(Block b : arroundBlocks(block))
		{
			if(b.getType() == Material.DRAGON_EGG && (!b.isBlockPowered() || !b.isBlockIndirectlyPowered()))
			{
				if(b.getWorld().getBlockAt(b.getX(), b.getY()-1, b.getZ()).getType() == Material.GOLD_BLOCK)
					FireworkBase.launch("fire", b.getLocation());
				else
				FireworkBase.launch(b.getLocation());
			}
		}
	}
	
	public ArrayList<Block> arroundBlocks(Block block)
	{
		ArrayList<Block> arroundBlocks = new ArrayList<Block>();
		arroundBlocks.add(block.getRelative(BlockFace.UP));
		arroundBlocks.add(block.getRelative(BlockFace.DOWN));
		arroundBlocks.add(block.getRelative(BlockFace.NORTH));
		arroundBlocks.add(block.getRelative(BlockFace.SOUTH));
		arroundBlocks.add(block.getRelative(BlockFace.WEST));
		arroundBlocks.add(block.getRelative(BlockFace.EAST));
		return arroundBlocks;
	}
	
}
