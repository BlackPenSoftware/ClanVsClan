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

     
     config.addDefault("Clan_1.Admin.UserName.ClanAdmin", Clan_1Admin);

     config.addDefault("Clan_2.Admin.UserName.ClanAdmin", Clan_2Admin);

     config.addDefault("Clan_3.Admin.UserName.ClanAdmin", Clan_3Admin);
     
     config.addDefault("Clan_4.Admin.UserName.ClanAdmin", Clan_4Admin);
     
 
    
     
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
	  
	  if(cmd.getName().equalsIgnoreCase("CvC")){

		  if(sender instanceof Player){

		  Player player = (Player) sender;
		  
		  Player playerName = Bukkit.getPlayer(args[2]);
		  
		if(args.length == 3){	   
		  
			  if(args[0].equalsIgnoreCase("SetAdmin") && playerName != null ){
			  
			  if(args[1].equalsIgnoreCase("1")){
				  
				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 1 Leader!");
				  
				  getConfig().set("Clan_1.Admin.UserName", null);
				  
				  getConfig().set("Clan_1.Admin.UserName", playerName.getDisplayName());
				  
				  saveConfig();
				  
				  this.reloadConfig();
			  	}
		  
			  if(args[1].equalsIgnoreCase("2") && playerName != null ){
				  
				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 2 Leader!");
				  
				  getConfig().set("Clan_2.Admin.UserName", null);
				  
				  getConfig().set("Clan_2.Admin.UserName", playerName.getDisplayName());
				  
				  saveConfig();
				  
				  this.reloadConfig();
				  
			  	}
			  
			  if(args[1].equalsIgnoreCase("3") && playerName != null ){
	  
				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 3 Leader!");
				  		
				  getConfig().set("Clan_3.Admin.UserName", null);
				  
				  getConfig().set("Clan_3.Admin.UserName", playerName.getDisplayName());
				  
				  saveConfig();
				  
				  this.reloadConfig();
				  
			  	}

			  if(args[1].equalsIgnoreCase("4") && playerName != null ){
	  
				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 4 Leader!");

				  getConfig().set("Clan_4.Admin.UserName", null);
				  
				  getConfig().set("Clan_4.Admin.UserName", playerName.getDisplayName());
				  
				  saveConfig();
				  
				  this.reloadConfig();
				  
			  	}  
			  }
			    
			  }else{


			  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "The Command You Enter Was Incorrect! Please Try Agian.");
			  
		  }
		  

		  
		 
		  }
		  
		  
		  return true;


	  
  }

	return false;
  
  }
  
}
  



