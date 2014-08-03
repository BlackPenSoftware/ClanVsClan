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
import Executer.cvc;


public class clan extends JavaPlugin{

	int MainVersion = 0;
	int MidVersion = 2;
	int SubVersion = 0;
	
	String MinecraftVersion = "1.7.9";
	
	 String Clan_1Admin = "Admin";
	 String Clan_2Admin = "Admin";
	 String Clan_3Admin = "Admin";
	 String Clan_4Admin = "Admin";
	
	 FileConfiguration config = getConfig();
	 
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public final clanlistener pl = new clanlistener();
	
public void onDisable(){

	System.out.println("[Clan Vs Clan] Clan Vs Clan v" + MainVersion + "." + MidVersion + "." + SubVersion + " Has Been Disabled.");


	
  }

public void initConfig() {

	 
	
     
     config.addDefault("Clan_1.Admin.UserName.ClanAdmin", Clan_1Admin);
     	config.addDefault("Clan.Admin.ClaimSize.1", true);
     	config.addDefault("Clan.Admin.ClaimSize.2", false);
     	config.addDefault("Clan.Admin.ClaimSize.3", false);
     	config.addDefault("Clan.Admin.ClaimSize.4", false);
     	config.addDefault("Clan.Admin.ClaimSize.5", false);
     	config.addDefault("Clan.Admin.ClaimSize.6", false);
     	config.addDefault("Clan.Admin.ClaimSize.7", false);
     	config.addDefault("Clan.Admin.ClaimSize.8", false);
     	config.addDefault("Clan.Admin.ClaimSize.9", false);
     	config.addDefault("Clan.Admin.ClaimSize.10", false);
        
     config.addDefault("Clan_2.Admin.UserName.ClanAdmin", Clan_2Admin);
 		config.addDefault("Clan.Admin.ClaimSize.1", true);
 		config.addDefault("Clan.Admin.ClaimSize.2", false);
 		config.addDefault("Clan.Admin.ClaimSize.3", false);
 		config.addDefault("Clan.Admin.ClaimSize.4", false);
 		config.addDefault("Clan.Admin.ClaimSize.5", false);
 		config.addDefault("Clan.Admin.ClaimSize.6", false);
 		config.addDefault("Clan.Admin.ClaimSize.7", false);
 		config.addDefault("Clan.Admin.ClaimSize.8", false);
 		config.addDefault("Clan.Admin.ClaimSize.9", false);
 		config.addDefault("Clan.Admin.ClaimSize.10", false);
 		
 	config.addDefault("Clan_3.Admin.UserName.ClanAdmin", Clan_3Admin);
 		config.addDefault("Clan.Admin.ClaimSize.1", true);
 		config.addDefault("Clan.Admin.ClaimSize.2", false);
 		config.addDefault("Clan.Admin.ClaimSize.3", false);
 		config.addDefault("Clan.Admin.ClaimSize.4", false);
 		config.addDefault("Clan.Admin.ClaimSize.5", false);
 		config.addDefault("Clan.Admin.ClaimSize.6", false);
 		config.addDefault("Clan.Admin.ClaimSize.7", false);
 		config.addDefault("Clan.Admin.ClaimSize.8", false);
 		config.addDefault("Clan.Admin.ClaimSize.9", false);
 		config.addDefault("Clan.Admin.ClaimSize.10", false);
 		
     config.addDefault("Clan_4.Admin.UserName.ClanAdmin", Clan_4Admin);
 		config.addDefault("Clan.Admin.ClaimSize.1", true);
 		config.addDefault("Clan.Admin.ClaimSize.2", false);
 		config.addDefault("Clan.Admin.ClaimSize.3", false);
 		config.addDefault("Clan.Admin.ClaimSize.4", false);
 		config.addDefault("Clan.Admin.ClaimSize.5", false);
 		config.addDefault("Clan.Admin.ClaimSize.6", false);
 		config.addDefault("Clan.Admin.ClaimSize.7", false);
 		config.addDefault("Clan.Admin.ClaimSize.8", false);
 		config.addDefault("Clan.Admin.ClaimSize.9", false);
 		config.addDefault("Clan.Admin.ClaimSize.10", false);
 
 	
     
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
	  pm.registerEvents(pl, this);
	  
	  registerCommands();
	  
    }


public void registerCommands(){
	
	getCommand("cvc").setExecutor(new cvc(this));
   
}
	  
public void playerJoin(PlayerJoinEvent event){
	
	
String PlayerName = event.getPlayer().getDisplayName();

//config.addDefault(PlayerName + "." + "Clan.Number", false);

int ClanNumber = 1;
	 
	 config.set(PlayerName + "." + "Clan.Number"  , ClanNumber);
	
}
  
}
  



