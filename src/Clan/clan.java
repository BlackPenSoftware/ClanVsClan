package Clan;

import java.lang.reflect.Array;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Executer.cvc;


public class clan extends JavaPlugin implements Listener{

	int MainVersion = 0;
	int MidVersion = 2;
	int SubVersion = 0;
	
	String MinecraftVersion = "1.7.9";
	
	 String Clan_1Admin = "Admin";
	 String Clan_2Admin = "Admin";
	 String Clan_3Admin = "Admin";
	 String Clan_4Admin = "Admin";
	
	 String PlayerLogName = "Player";
	 
	 FileConfiguration config = getConfig();
	 
	public String[][] Clan_1_Player_List = {
			
	        	{}
	        
		};
	
	public String[][] Clan_2_Player_List = {
			
        		{}
        
	};
	
	public String[][] Clan_3_Player_List = {
			
        		{}
        
	};
	
	public String[][] Clan_4_Player_List = {
			
        		{}
        
	};
	
	 
	public final Logger logger = Logger.getLogger("Minecraft");
	
	
	
public void onDisable(){

	System.out.println("[Clan Vs Clan] Clan Vs Clan v" + MainVersion + "." + MidVersion + "." + SubVersion + " Has Been Disabled.");
  }

public void initConfig() {

	 
	
     
     config.addDefault("Clan_1.Admin.UserName.ClanAdmin", Clan_1Admin);
     
     config.addDefault("Clan_1.Admin.Ballance", 1000);
     
     config.addDefault("Clan_1.Players.Names", Clan_1_Player_List);
     
     	config.addDefault("Clan_1.Land.ClaimSize.1", true);
     	config.addDefault("Clan_1.Land.ClaimSize.1.Cost", 10000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.2", false);
     	config.addDefault("Clan_1.Land.ClaimSize.2.Cost", 100000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.3", false);
     	config.addDefault("Clan_1.Land.ClaimSize.3.Cost", 1000000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.4", false);
     	config.addDefault("Clan_1.Land.ClaimSize.4.Cost", 10000000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.5", false);
     	config.addDefault("Clan_1.Land.ClaimSize.5.Cost", 100000000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.6", false);
     	config.addDefault("Clan_1.Land.ClaimSize.6.Cost", 1000000000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.7", false);
     	config.addDefault("Clan_1.Land.ClaimSize.7.Cost", 200000000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.8", false);
     	config.addDefault("Clan_1.Land.ClaimSize.8.Cost", 300000000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.9", false);
     	config.addDefault("Clan_1.Land.ClaimSize.9.Cost", 400000000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.10", false);
     	config.addDefault("Clan_1.Land.ClaimSize.10.Cost", 500000000);
     	
        
     	
     	
     config.addDefault("Clan_2.Admin.UserName.ClanAdmin", Clan_2Admin);
     
     config.addDefault("Clan_2.Admin.Ballance", 100);
     
     config.addDefault("Clan_2.Players.Names", Clan_2_Player_List);
     
     config.addDefault("Clan_2.Land.ClaimSize.1", true);
  	config.addDefault("Clan_2.Land.ClaimSize.1.Cost", 10000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.2", false);
  	config.addDefault("Clan_2.Land.ClaimSize.2.Cost", 100000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.3", false);
  	config.addDefault("Clan_2.Land.ClaimSize.3.Cost", 1000000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.4", false);
  	config.addDefault("Clan_2.Land.ClaimSize.4.Cost", 10000000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.5", false);
  	config.addDefault("Clan_2.Land.ClaimSize.5.Cost", 100000000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.6", false);
  	config.addDefault("Clan_2.Land.ClaimSize.6.Cost", 1000000000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.7", false);
  	config.addDefault("Clan_2.Land.ClaimSize.7.Cost", 200000000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.8", false);
  	config.addDefault("Clan_2.Land.ClaimSize.8.Cost", 300000000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.9", false);
  	config.addDefault("Clan_2.Land.ClaimSize.9.Cost", 400000000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.10", false);
  	config.addDefault("Clan_2.Land.ClaimSize.10.Cost", 500000000);
 		
  	
  	
  	
 	config.addDefault("Clan_3.Admin.UserName.ClanAdmin", Clan_3Admin);
 	
 	config.addDefault("Clan_3.Admin.Ballance", 100);
 	
 	config.addDefault("Clan_3.Players.Names", Clan_3_Player_List);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.1", true);
 	config.addDefault("Clan_3.Land.ClaimSize.1.Cost", 10000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.2", false);
 	config.addDefault("Clan_3.Land.ClaimSize.2.Cost", 100000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.3", false);
 	config.addDefault("Clan_3.Land.ClaimSize.3.Cost", 1000000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.4", false);
 	config.addDefault("Clan_3.Land.ClaimSize.4.Cost", 10000000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.5", false);
 	config.addDefault("Clan_3.Land.ClaimSize.5.Cost", 100000000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.6", false);
 	config.addDefault("Clan_3.Land.ClaimSize.6.Cost", 1000000000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.7", false);
 	config.addDefault("Clan_3.Land.ClaimSize.7.Cost", 200000000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.8", false);
 	config.addDefault("Clan_3.Land.ClaimSize.8.Cost", 300000000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.9", false);
 	config.addDefault("Clan_3.Land.ClaimSize.9.Cost", 400000000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.10", false);
 	config.addDefault("Clan_3.Land.ClaimSize.10.Cost", 500000000);
 	
 	
 	
 	
     config.addDefault("Clan_4.Admin.UserName.ClanAdmin", Clan_4Admin);
     
     config.addDefault("Clan_4.Admin.Ballance", 100);
     
     config.addDefault("Clan_4.Players.Names", Clan_4_Player_List);
     
     config.addDefault("Clan_4.Land.ClaimSize.1", true);
  	config.addDefault("Clan_4.Land.ClaimSize.1.Cost", 10000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.2", false);
  	config.addDefault("Clan_4.Land.ClaimSize.2.Cost", 100000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.3", false);
  	config.addDefault("Clan_4.Land.ClaimSize.3.Cost", 1000000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.4", false);
  	config.addDefault("Clan_4.Land.ClaimSize.4.Cost", 10000000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.5", false);
  	config.addDefault("Clan_4.Land.ClaimSize.5.Cost", 100000000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.6", false);
  	config.addDefault("Clan_4.Land.ClaimSize.6.Cost", 1000000000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.7", false);
  	config.addDefault("Clan_4.Land.ClaimSize.7.Cost", 200000000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.8", false);
  	config.addDefault("Clan_4.Land.ClaimSize.8.Cost", 300000000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.9", false);
  	config.addDefault("Clan_4.Land.ClaimSize.9.Cost", 400000000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.10", false);
  	config.addDefault("Clan_4.Land.ClaimSize.10.Cost", 500000000);
 	
 	config.options().copyDefaults(true);
 		
     saveConfig();
	
}

public void configReload(){
	
	reloadConfig();
	
}

public void configSave(){
	
	saveConfig();
	
}


	
 

@Override
public void onEnable() {
    
       initConfig();
	  
	  System.out.println(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "Clan Vs Clan v" + MainVersion + "." + MidVersion + "." + SubVersion + " Is Running.");
	  System.out.println(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "**** THIS IS A DEVELOPMENT BUILD USE WITH CAUTION ****");
	  System.out.println(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED+ "This Version Is To Be Used With Minecraft Version " + MinecraftVersion);
	  
	  PluginManager pm = getServer().getPluginManager();
	  pm.registerEvents(this, this);
	  
	  registerCommands();
	  
	 
    }


public void registerCommands(){
	
	getCommand("cvc").setExecutor(new cvc(this));
   
}
	
@EventHandler
public void playerMove(PlayerMoveEvent event) {

	
	
	Player player = event.getPlayer();
	   
	   Location loc = player.getLocation();
	   
	  
	   
	   if(loc.getBlockX() > 100){
		   
		  player.sendMessage("PAST 100");
		
		 // event.setCancelled(true);
		  
		  player.teleport(new Location(Bukkit.getWorld("world"), 95, loc.getBlockY(), loc.getBlockZ()));
		   
		  
	   }
	
	   
	   
	   if(loc.getBlockZ() > 100){
		   
		  player.sendMessage("PAST 100");
		
		 // event.setCancelled(true);
		  
		  player.teleport(new Location(Bukkit.getWorld("world"), loc.getX(), loc.getBlockY(), 95));
		   
		  
	   }
	   
	   
	   if(loc.getBlockX() * -1 > 0){
		   
			  player.sendMessage("PAST 100");
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld("world"), 5 , loc.getBlockY(), loc.getBlockZ()));
			   
			  
		   }
		
		   
		   
		   if(loc.getBlockZ() * -1 > 0){
			   
			  player.sendMessage("PAST 100");
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld("world"), loc.getX(), loc.getBlockY(), 5 ));
			   
			  
		   }
	   
		  
		   
	}
}