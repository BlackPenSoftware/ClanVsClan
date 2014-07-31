package Clan;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ClanListener.clanlistener;


public class clan extends JavaPlugin{

	int MainVersion = 0;
	int MidVersion = 0;
	int SubVersion = 1;
	
	String MinecraftVersion = "1.7.9";
	
	 String Clan_1Admin = "Admin";
	 String Clan_2Admin = "Admin";
	 String Clan_3Admin = "Admin";
	 String Clan_4Admin = "Admin";
	
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public final clanlistener pl = new clanlistener();
	
public void onDisable(){

	System.out.println("[Clan Vs Clan] Clan Vs Clan v" + MainVersion + "." + MidVersion + "." + SubVersion + " Has Been Disabled.");


	
  }

public void initConfig() {

	 
	 
	 FileConfiguration config = getConfig();

     
     config.addDefault("Clan_1.Admin.UserName", Clan_1Admin);

     config.addDefault("Clan_2.Admin.UserName", Clan_2Admin);

     config.addDefault("Clan_3.Admin.UserName", Clan_3Admin);
     
     config.addDefault("Clan_4.Admin.UserName", Clan_4Admin);
     
     
     config.options().copyDefaults(true);
     
     saveConfig();
	
}

@Override
public void onEnable() {
    
       initConfig();
	  
	  System.out.println(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "Clan Vs Clan v" + MainVersion + "." + MidVersion + "." + SubVersion + " Is Running.");
	  System.out.println(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "**** THIS IS A DEVELOPMENT BUILD USE WITH CAUTION ****");
	  System.out.println(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED+ "This Version Is To Be Used With Minecraft Version " + MinecraftVersion);
	  
	  PluginManager pm = getServer().getPluginManager();
	  pm.registerEvents(pl, this);
	  
    }
	  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	  
	  if(cmd.getName().equalsIgnoreCase("clan")){
		  if(sender instanceof Player){
				
				
	  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "Clan Vs Clan v" + MainVersion + "." + MidVersion + "." + SubVersion + " Is Running.");
	  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "**** THIS IS A DEVELOPMENT BUILD USE WITH CAUTION ****");
	  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED+ "This Version Is To Be Used With Minecraft Version " + MinecraftVersion);

	  }
		  
		  return true;
		  
	  }
	  
	  if(cmd.getName().equalsIgnoreCase("setAdminC1")){

		  if(sender instanceof Player){

		  Player player = (Player) sender;
		  
		  Player target = Bukkit.getPlayer(args[0]);

		  String C1A = target.getName();


		  if(target != null){
			  
			  Clan_1Admin = C1A;
			  
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.RED + "The Player " + target.getName() + " Is Now Clan #1 Admin.");
			  
			  saveConfig();
			  
		  }else{


			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.RED + "The Player " + target.getName() + " Is Not Online.");


		  }


		  }


		  return true;


	  
  }

	  
	return false;
  
  }
  
  
  
  }


