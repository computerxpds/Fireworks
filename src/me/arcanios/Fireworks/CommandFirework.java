package me.arcanios.Fireworks;

import me.arcanios.Fireworks.Firework.FireworkBase;
import me.arcanios.Fireworks.Firework.FireworkSimple;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFirework implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command command,	String label, String[] args) {
		if(command.getName().equalsIgnoreCase("firework"))
		{
			Player player;
			if(sender instanceof Player)
				player = (Player)sender;
			else
				return false;
			
			if(args.length > 0)
				FireworkBase.launch(args[0],player.getLocation());
			else
				FireworkBase.launch(player.getLocation());
			
			return true;
		}
		return false;
	}

}
