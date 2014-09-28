package Clan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import net.minecraft.server.v1_7_R3.MinecraftServer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import Executer.cvc;


public class clan extends JavaPlugin implements Listener{

	/**
	 * 
	 * Sets Up The Version System So That It Only Needs To Be Changed Here And In The Plugin.yml
	 * 
	 */
	
	int MainVersion = 1;
	int MidVersion = 0;
	int SubVersion = 0;
	
	/**
	 * 
	 * String That Tells What Minecraft Version The Plugin Is Used For Called Directly From THe Server
	 * 
	 */
	
	String MinecraftVersion = MinecraftServer.getServer().getVersion();
	
	/**
	 * 
	 * Sets Up The Default Names For The Admins In Config.yml
	 * 
	 */
	
	 String Clan_1Admin = "Admin";
	 String Clan_2Admin = "Admin";
	 String Clan_3Admin = "Admin";
	 String Clan_4Admin = "Admin";
	
	 /**
	  * 
	  * Setup Default Player Names For Config.yml
	  * 
	  */
	 
	 String PlayerLogName = "Player";
	 
	 /**
	  * 
	  * Gets The Config.yml File and Sets It To A Sting 
	  * 
	  */
	 
	 FileConfiguration config = getConfig();
	 
	 /**
	  * 
	  * Creates The String Array For The Clan PLayer Lists
	  * 
	  */
	 
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
	
	 
	/**
	 * 
	 * Sets Up A Logger To Tell When A Player Logs In 
	 * 
	 */
	
	public final Logger logger = Logger.getLogger("Minecraft");
	
	
	/**
	 * 
	 * Runs On Startup 
	 * Prints License Information To Console 
	 * 
	 */
	
	@Override
	public void onEnable() {
	    
	       initConfig();
		  
		  System.out.println("[Clan Vs Clan] " + "Clan Vs Clan v" + MainVersion + "." + MidVersion + "." + SubVersion + " Is Running.");
		  System.out.println("[Clan Vs Clan] " + "**** THIS IS A LICENSED COPY DO NOT DISTRIBUTE ****");
		  System.out.println("[Clan Vs Clan] " + "This Version Is To Be Used With Minecraft Version " + MinecraftVersion);
		  
		  PluginManager pm = getServer().getPluginManager();
		  pm.registerEvents(this, this);
		  
		  registerCommands();
		  
		  BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
	            public void run() {
	               int time = (Integer)config.get("Clans.WarTime.Time");
	               
	               if(time <= 10080){
	            	   
	            	   config.set("Clans.WarTime.Time", ((Integer)config.get("Clans.WarTime.Time") + 1));
	            	  
	            	   saveConfig();
	            	   
	            	 
	               }
	     
	               if(time > 10080){
	            	   
	            	 Bukkit.broadcastMessage(ChatColor.BLUE + "[Clan Vs Clan]" + ChatColor.RED + " Let The War Begin!");  
	            	 
	            	 config.set("Clans.WarTime.Time", 0);
	            	 
	            	 saveConfig();
	            	 
	            	 War();
	            	 
	               }
	               
	            }
	        }, 1200L, 1200L);
		 
	        
		  saveConfig();
		  
		  
		  
		  
	    }

	
	public void War(){
		
		Bukkit.broadcastMessage("WAR");
		
		List<Player> Clan_1_Player_List = Bukkit.getWorld((String) config.get("Clan_1.Land.World.Name")).getPlayers();
		Player Random_Player_In_Clan_1 = Clan_1_Player_List.get(new Random().nextInt(Clan_1_Player_List.size()));
		
		List<Player> Clan_2_Player_List = Bukkit.getWorld((String) config.get("Clan_2.Land.World.Name")).getPlayers();
		Player Random_Player_In_Clan_2 = Clan_2_Player_List.get(new Random().nextInt(Clan_2_Player_List.size()));
		
		List<Player> Clan_3_Player_List = Bukkit.getWorld((String) config.get("Clan_3.Land.World.Name")).getPlayers();
		Player Random_Player_In_Clan_3 = Clan_3_Player_List.get(new Random().nextInt(Clan_3_Player_List.size()));
		
		List<Player> Clan_4_Player_List = Bukkit.getWorld((String) config.get("Clan_4.Land.World.Name")).getPlayers();
		Player Random_Player_In_Clan_4 = Clan_4_Player_List.get(new Random().nextInt(Clan_4_Player_List.size()));
		
		 World p = Bukkit.getWorld((String) config.get("Clan_2.Land.World.Name"));
		 Random_Player_In_Clan_1.teleport(new Location(p, 50, 60, 50));
		
		
	}
	
	
	/**
	 * 
	 * On System Disable 
	 * Prints Out To Console That The Plugin Has Stopped
	 * 
	 */
	
	
public void onDisable(){

	System.out.println("[Clan Vs Clan] Clan Vs Clan v" + MainVersion + "." + MidVersion + "." + SubVersion + " Has Been Disabled.");
	
  }




/**
 * 
 * Creates And Starts The Config.yml File
 * Also Adds Defaults To The File
 * 
 */

public void initConfig() {


	config.addDefault("Clans.WarTime.Time", 0);
	
	config.addDefault("Clans.Shop.Sell.PayoutReturn", 3);
     
     config.addDefault("Clan_1.Admin.UserName.ClanAdmin", Clan_1Admin);
     
     config.addDefault("Clan_1.Admin.UserName.User", "Player");
     
     
     config.addDefault("Clan_1.Admin.Ballance", 1000);
     
     
     config.addDefault("Clan_1.Home.World", "");
     
     config.addDefault("Clan_1.Home.X", 0.0D);
     
     config.addDefault("Clan_1.Home.Y", 60.0D);
     
     config.addDefault("Clan_1.Home.Z", 0.0D);
     
     config.addDefault("Clan_1.Home.Yaw", 0.0D);
     
     config.addDefault("Clan_1.Home.Pitch", 0.0D);
     
     
     config.addDefault("Clan_1.Players.Names", Clan_1_Player_List);
     
     config.addDefault("Clan_1.Players.UserName.Bal", 0);
     

     config.addDefault("Clan_1.Land.World.Name", "Clan_1");
     

  	config.addDefault("Clan_1.Land.ClaimSize.Size", Max);
  	

     	

     config.addDefault("Clan_2.Admin.UserName.ClanAdmin", Clan_2Admin);
     
     config.addDefault("Clan_2.Admin.Ballance", 100);
     
     config.addDefault("Clan_2.Players.Names", Clan_2_Player_List);
     
     
     config.addDefault("Clan_2.Land.World.Name", "Clan_2");
     
     config.addDefault("Clan_1.Home.World", "");
     config.addDefault("Clan_2.Home.X", 0.0D);
     
     config.addDefault("Clan_2.Home.Y", 60.0D);
     
     config.addDefault("Clan_2.Home.Z", 0.0D);
     
     config.addDefault("Clan_2.Home.Yaw", 0.0D);
     
     config.addDefault("Clan_2.Home.Pitch", 0.0D);
     
     
  	config.addDefault("Clan_2.Players.Names", Clan_2_Player_List);

  	config.addDefault("Clan_2.Land.ClaimSize.Size", Max_2);
  	

 	
  	
 	config.addDefault("Clan_3.Admin.UserName.ClanAdmin", Clan_3Admin);
 	
 	config.addDefault("Clan_3.Admin.Ballance", 100);
 	
 	config.addDefault("Clan_1.Home.World", "");
 	config.addDefault("Clan_3.Home.X", 0.0D);
     
     config.addDefault("Clan_3.Home.Y", 60.0D);
     
     config.addDefault("Clan_3.Home.Z", 0.0D);
     
     config.addDefault("Clan_3.Home.Yaw", 0.0D);
     
     config.addDefault("Clan_3.Home.Pitch", 0.0D);
 	
     
     config.addDefault("Clan_3.Land.World.Name", "Clan_3");
     
 	
 	config.addDefault("Clan_3.Players.Names", Clan_3_Player_List);

 	config.addDefault("Clan_3.Land.ClaimSize.Size", Max_3);
 	

 	
 
 	
     config.addDefault("Clan_4.Admin.UserName.ClanAdmin", Clan_4Admin);
     
     config.addDefault("Clan_4.Admin.Ballance", 100);
     
     config.addDefault("Clan_1.Home.World", "");
     config.addDefault("Clan_1.Home.X", 0.0D);
     
     config.addDefault("Clan_4.Home.Y", 60.0D);
     
     config.addDefault("Clan_4.Home.Z", 0.0D);
     
     config.addDefault("Clan_4.Home.Yaw", 0.0D);
     
     config.addDefault("Clan_4.Home.Pitch", 0.0D);
     
     
     config.addDefault("Clan_4.Land.World.Name", "Clan_4");
     
     
     config.addDefault("Clan_4.Players.Names", Clan_4_Player_List);
     

  	config.addDefault("Clan_4.Land.ClaimSize.Size", Max_4);

 	
 	config.options().copyDefaults(true);
 		
     saveConfig();
	
}

/**
 * 
 * Called From Other Classes To Reload The Config.yml File
 * This Is Used When Adding Or Taking From The File
 * 
 */

public void configReload(){
	
	reloadConfig();
	
}

/**
 * 
 * Called From Other Classes To Save The Config.yml File
 * This Is Used When Adding Or Taking From The File
 * Usually Called Before The Reloading Config.yml File
 * 
 */

public void configSave(){
	
	saveConfig();
	
}

/**
 * 
 * Creates A Base Line For The Clan Claim Size 
 * Changing These Ints Changes The Base Size Of The Clan Claim
 * 
 */

int Max = 100;
int Max_2 = 100;
int Max_3 = 100;
int Max_4 = 100;
 
/**
 * 
 * Creates The Main Command That All
 * 
 */

public void registerCommands(){
	
	getCommand("cvc").setExecutor(new cvc(this));
   
}
	
/**
 * 
 * Takes The String Arrays Created Before And Turns Them Into A String List
 * 
 */

List<String> Clan_1 = config.getStringList("Clan_1.Players.Names");

List<String> Clan_2 = config.getStringList("Clan_2.Players.Names");

List<String> Clan_3 = config.getStringList("Clan_3.Players.Names");

List<String> Clan_4 = config.getStringList("Clan_4.Players.Names");



/**
 * 
 * Every Time The Player Moves, The Game Checks The Clan Balance And Updates The Player ScoreBoard
 * THis Then Causes The CsoreBoard To Sort The Clans Form Most To Least Money
 * 
 */

@SuppressWarnings("deprecation")
@EventHandler(priority = EventPriority.HIGHEST)
public void playerMove(PlayerMoveEvent event) {

	Player player = event.getPlayer();

	
/**
 * 
 * Creates The ScoreBoard
 * 
 */
	
	// CLAN 1 BAL //
	ScoreboardManager Clan_1_Bal_Board_Manager = Bukkit.getScoreboardManager();
	
	Scoreboard board = Clan_1_Bal_Board_Manager.getNewScoreboard();
	
	Team Clan_1_Bal_Board_Team = board.registerNewTeam("Clan_1");
	
	Clan_1_Bal_Board_Team.setPrefix("* Clan 1 * ");
	
	Objective Clan_1_Bal_Board_Objective = board.registerNewObjective("test", "dummy");
	
	Clan_1_Bal_Board_Objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	 
	//Setting the display name of the scoreboard objective
	
	Clan_1_Bal_Board_Objective.setDisplayName("Balance");
	
	Score score = Clan_1_Bal_Board_Objective.getScore(ChatColor.BLUE + "Clan 1: "); //Get a fake offline player
	
	int Clan_1_Bal = getConfig().getInt("Clan_1.Admin.Ballance");
	
	score.setScore(Clan_1_Bal);
	
	//reloadConfig();

	/**
	 * 
	 * Resets The Scores Every Movement
	 * 
	 */
	
	board.resetScores(player);
	

	
	// CLAN 2 //
	
		Score Clan_2_Score = Clan_1_Bal_Board_Objective.getScore(ChatColor.BLUE + "Clan 2: "); //Get a fake offline player
		
		int Clan_2_Bal = getConfig().getInt("Clan_2.Admin.Ballance");
		
		Clan_2_Score.setScore(Clan_2_Bal);
		
		
		
		// CLAN 3 //
		
		Score Clan_3_Score = Clan_1_Bal_Board_Objective.getScore(ChatColor.BLUE + "Clan 3: "); //Get a fake offline player
		
		int Clan_3_Bal = getConfig().getInt("Clan_3.Admin.Ballance");
		
		Clan_3_Score.setScore(Clan_3_Bal);
		
		
		// CLAN 4//
		
		Score Clan_4_Score = Clan_1_Bal_Board_Objective.getScore(ChatColor.BLUE + "Clan 4: "); //Get a fake offline player
		
		int Clan_4_Bal = getConfig().getInt("Clan_4.Admin.Ballance");
		
		Clan_4_Score.setScore(Clan_4_Bal);
	
	
	player.setScoreboard(board);
	

	
	   Location loc = player.getLocation();
	   
	  
	   if(Clan_1.contains(player.getName())){
	   
	  
	   if(loc.getBlockX() > (Integer)config.get("Clan_1.Land.ClaimSize.Size")){
		   
		  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
		
		 // event.setCancelled(true);
		  
		  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_1.Land.World.Name").toString()), (Integer)config.get("Clan_1.Land.ClaimSize.Size") - 5, loc.getBlockY(), loc.getBlockZ()));
		   
		  
		  
	   }
	
	   
	   
	   if(loc.getBlockZ() > (Integer)config.get("Clan_1.Land.ClaimSize.Size")){
		   
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
			
		
		 // event.setCancelled(true);
		  
		  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_1.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), (Integer)config.get("Clan_1.Land.ClaimSize.Size") - 5));
		   
		  
	   }
	   
	   
	   if(loc.getBlockX() * -1 > 0){
		   
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_1.Land.World.Name").toString()), (Integer)config.get("Clan_1.Land.ClaimSize.Size") - (Integer)config.get("Clan_1.Land.ClaimSize.Size") + 5 , loc.getBlockY(), loc.getBlockZ()));
			   
			  
		   }
		
		   
		   
		   if(loc.getBlockZ() * -1 > 0){
			   
				  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
				
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_1.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), (Integer)config.get("Clan_1.Land.ClaimSize.Size") - (Integer)config.get("Clan_1.Land.ClaimSize.Size") + 5));
			   
			  
		   }
	   
	  } 
	   
	   

	   
	   

	   if(Clan_2.contains(player.getName())){
	   
	  
	   if(loc.getBlockX() > Max_2){
		   
		  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
		
		 // event.setCancelled(true);
		  
		  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_2.Land.World.Name").toString()), Max_2 - 5, loc.getBlockY(), loc.getBlockZ()));
		   
		  
		  
	   }
	
	   
	   
	   if(loc.getBlockZ() > Max_2){
		   
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
			
		
		 // event.setCancelled(true);
		  
		  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_2.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), Max_2 - 5));
		   
		  
	   }
	   
	   
	   if(loc.getBlockX() * -1 > 0){
		   
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_2.Land.World.Name").toString()), Max_2 - Max_2 + 5 , loc.getBlockY(), loc.getBlockZ()));
			   
			  
		   }
		
		   
		   
		   if(loc.getBlockZ() * -1 > 0){
			   
				  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
				
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_2.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), Max_2 - Max_2 + 5));
			   
			  
		   }
	   
	  } 
	   
	  
	   
	   if(Clan_3.contains(player.getName())){
		   
			  
		   if(loc.getBlockX() > Max_3){
			   
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_3.Land.World.Name").toString()), Max_3 - 5, loc.getBlockY(), loc.getBlockZ()));
			   
			  
			  
		   }
		
		   
		   
		   if(loc.getBlockZ() > Max_3){
			   
				  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
				
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_3.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), Max_3 - 5));
			   
			  
		   }
		   
		   
		   if(loc.getBlockX() * -1 > 0){
			   
				  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
				
				 // event.setCancelled(true);
				  
				  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_3.Land.World.Name").toString()), Max_3 - Max_3 + 5 , loc.getBlockY(), loc.getBlockZ()));
				   
				  
			   }
			
			   
			   
			   if(loc.getBlockZ() * -1 > 0){
				   
					  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
					
				
				 // event.setCancelled(true);
				  
				  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_3.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), Max_3 - Max_3 + 5));
				   
				  
			   }
		   
		  } 
		   
	   
	   
	   if(Clan_4.contains(player.getName())){
		   
			  
		   if(loc.getBlockX() > Max_4){
			   
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_4.Land.World.Name").toString()), Max_4 - 5, loc.getBlockY(), loc.getBlockZ()));
			   
			  
			  
		   }
		
		   
		   
		   if(loc.getBlockZ() > Max_4){
			   
				  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
				
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_4.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), Max_4 - 5));
			   
			  
		   }
		   
		   
		   if(loc.getBlockX() * -1 > 0){
			   
				  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
				
				 // event.setCancelled(true);
				  
				  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_4.Land.World.Name").toString()), Max_4 - Max_4 + 5 , loc.getBlockY(), loc.getBlockZ()));
				   
				  
			   }
			
			   
			   
			   if(loc.getBlockZ() * -1 > 0){
				   
					  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
					
				
				 // event.setCancelled(true);
				  
				  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_4.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), Max_4 - Max_4 + 5));
				   
				  
			   }
		   
		  } 
		   
	   
	   
	   
}




@EventHandler 

public void OnPlayerLogin(PlayerJoinEvent event){
	
	Player player = event.getPlayer();

	if(player.getDisplayName().toString().equalsIgnoreCase("magaBenG")){
		
		Bukkit.broadcastMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Head Plugin Developer " + ChatColor.GOLD + "MagaBenG " + ChatColor.DARK_PURPLE + "Has Joined The Game!");
		
	}
	
	if(player.getDisplayName().toString().equalsIgnoreCase("MenTal_H4cKz")){
		
		Bukkit.broadcastMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Lead Plugin Tester " + ChatColor.GOLD + player.getDisplayName() + ChatColor.DARK_PURPLE + " Has Joined The Game!");
		
	}
	
	
	Random Random = new Random();

	int pick = Random.nextInt(4);

	if(!Clan_1.contains(player.getName())){
		
		if(!Clan_2.contains(player.getName())){
			
			if(!Clan_3.contains(player.getName())){
				
				if(!Clan_4.contains(player.getName())){
	
	if(pick == 1){

		
		
	player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Are Now A Member Of " + ChatColor.GOLD + "Clan 1!");

	
	
	 Clan_1.add(player.getName());
		 
		// add to config
		config.set("Clan_1.Players.Names", Clan_1);
		
		config.addDefault("Clan_1.Players." + player.getDisplayName() + ".Bal", 0);
		
		// save
		saveConfig();

	}


	if(pick == 2){

		
		
		

		player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Are Now A Member Of " + ChatColor.GOLD + "Clan 2!");


	
	
	 Clan_2.add(player.getName());
		 
		// add to config
		config.set("Clan_2.Players.Names", Clan_2);
		 
		// config.set("Clan_2.Players.Users.UserNames", player.getDisplayName());
		
		config.addDefault("Clan_2.Players." + player.getDisplayName() + ".Bal", 0);
		
		// save
		saveConfig();

	}


	if(pick == 3){


		player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Are Now A Member Of " + ChatColor.GOLD + "Clan 3!");

		
	 Clan_3.add(player.getName());
		 
		// add to config
		config.set("Clan_3.Players.Names", Clan_3);
		 
		// config.set("Clan_3.Players.Users.UserNames", player.getDisplayName());
		
		config.addDefault("Clan_3.Players." + player.getDisplayName() + ".Bal", 0);
		
		// save
		saveConfig();

	}


	if(pick == 4){

		
		player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Are Now A Member Of " + ChatColor.GOLD + "Clan 4!");

	
	
	 Clan_4.add(player.getName());
		 
		// add to config
		config.set("Clan_4.Players.Names", Clan_4);
		
		// config.set("Clan_4.Players.Users.UserNames", player.getDisplayName());
		
		config.addDefault("Clan_4.Players." + player.getDisplayName() + ".Bal", 0); 
		
		// save
		saveConfig();

	}


	}
			}
		}
	}
}





@SuppressWarnings("deprecation")
@EventHandler
public void onClick(InventoryClickEvent event) {
	
	
	if(event.getInventory().getName().equalsIgnoreCase("Shop")){
	
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		
		if (clicked.getType() == Material.ANVIL) {
			event.setCancelled(true);
			
     		  
	     		player.openInventory(cvc.ClanBuyInventory);
			
			}

		if (clicked.getType() == Material.PAPER) {
			event.setCancelled(true);
			
				player.openInventory(cvc.ClanSellInventory);
			
			}
		
		
	}
	
	
	if (event.getInventory().getName().equalsIgnoreCase("Clan Buy")){
		

		
		Player player = (Player) event.getWhoClicked();


		List<String> Clan_1 = config.getStringList("Clan_1.Players.Names");

		List<String> Clan_2 = config.getStringList("Clan_2.Players.Names");

		List<String> Clan_3 = config.getStringList("Clan_3.Players.Names");

		List<String> Clan_4 = config.getStringList("Clan_4.Players.Names");

		ItemStack clicked = event.getCurrentItem();
		
		
		ItemStack DiamondHead = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta DiamondHead_Meta = DiamondHead.getItemMeta();
		DiamondHead_Meta.setDisplayName("Diamond Helmet");
		ArrayList<String> DiamondHeadLore = new ArrayList<String>();
		DiamondHeadLore.add("This Helmet Costs $2000");
		DiamondHeadLore.add("Click Me To Buy!");
		DiamondHead.addEnchantment(Enchantment.OXYGEN, 3);
  		DiamondHead.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
  		DiamondHead.addEnchantment(Enchantment.WATER_WORKER, 1);
  		
  	
	  		
	  		ItemStack DiamondChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
	  		ItemMeta DiamondChestMeta = DiamondChest.getItemMeta();
	  		DiamondChestMeta.setDisplayName("Diamond Chestplate");
	  		DiamondChest.setItemMeta(DiamondChestMeta);
			ArrayList<String> DiamondChest_Lore = new ArrayList<String>();
	  		DiamondChest_Lore.add("This Helmet Costs $5000");
	  		DiamondChest_Lore.add("Click Me To Buy!");
	  		DiamondChest.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
	  		DiamondChest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
	  		DiamondChest.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
		
	  		
	  		ItemStack DiamondLegs = new ItemStack(Material.DIAMOND_LEGGINGS);
	  		ItemMeta DiamondLegsMeta = DiamondLegs.getItemMeta();
	  		DiamondLegsMeta.setDisplayName("Diamond Chestplate");
	  		DiamondLegs.setItemMeta(DiamondLegsMeta);
			ArrayList<String> DiamondLegs_Lore = new ArrayList<String>();
	  		DiamondLegs_Lore.add("This Helmet Costs $3500");
	  		DiamondLegs_Lore.add("Click Me To Buy!");
	  		DiamondLegs.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
	  		DiamondLegs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
	  		DiamondLegs.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
	  		
	  		
	  		
	  		ItemStack DiamondBoots = new ItemStack(Material.DIAMOND_BOOTS);
	  		ItemMeta DiamondBootsMeta = DiamondBoots.getItemMeta();
	  		DiamondBootsMeta.setDisplayName("Diamond Boots");
	  		DiamondBoots.setItemMeta(DiamondBootsMeta);
			ArrayList<String> DiamondBoots_Lore = new ArrayList<String>();
	  		DiamondBoots_Lore.add("This Helmet Costs $3200");
	  		DiamondBoots_Lore.add("Click Me To Buy!");
	  		DiamondBoots.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
	  		DiamondBoots.addEnchantment(Enchantment.PROTECTION_FALL, 4);
	  		
	  		
	  		ItemStack DiamondSword = new ItemStack(Material.DIAMOND_SWORD);
	  		ItemMeta DiamondSwordMeta = DiamondSword.getItemMeta();
	  		DiamondSwordMeta.setDisplayName("Diamond Sword");
	  		DiamondSword.setItemMeta(DiamondSwordMeta);
			ArrayList<String> DiamondSword_Lore = new ArrayList<String>();
	  		DiamondSword_Lore.add("This Sword Costs $10000");
	  		DiamondSword_Lore.add("Click Me To Buy!");
	  		DiamondSword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
	  		DiamondSword.addEnchantment(Enchantment.DURABILITY, 3);
	  		DiamondSword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
	  		DiamondSword.addEnchantment(Enchantment.LOOT_BONUS_MOBS, 3);
	  		
	  		
	  		ItemStack DiamondPickAxe = new ItemStack(Material.DIAMOND_PICKAXE);
	  		ItemMeta DiamondPickAxeMeta = DiamondPickAxe.getItemMeta();
	  		DiamondPickAxeMeta.setDisplayName("Diamond Pickaxe");
	  		DiamondPickAxe.setItemMeta(DiamondPickAxeMeta);
			ArrayList<String> DiamondPickAxe_Lore = new ArrayList<String>();
	  		DiamondPickAxe_Lore.add("This Pickaxe Costs $10000");
	  		DiamondPickAxe_Lore.add("Click Me To Buy!");
	  		DiamondPickAxe.addEnchantment(Enchantment.DIG_SPEED, 5);
	  		DiamondPickAxe.addEnchantment(Enchantment.DURABILITY, 3);
	  		DiamondPickAxe.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
	  		
	  		
	  		
	  		ItemStack DiamondAxe = new ItemStack(Material.DIAMOND_AXE);
	  		ItemMeta DiamondAxeMeta = DiamondAxe.getItemMeta();
	  		DiamondAxeMeta.setDisplayName("Diamond Axe");
	  		DiamondAxe.setItemMeta(DiamondAxeMeta);
			ArrayList<String> DiamondAxe_Lore = new ArrayList<String>();
	  		DiamondAxe_Lore.add("This axe Costs $10000");
	  		DiamondAxe_Lore.add("Click Me To Buy!");
	  		DiamondAxe.addEnchantment(Enchantment.DIG_SPEED, 5);
	  		DiamondAxe.addEnchantment(Enchantment.DURABILITY, 3);
	  		DiamondAxe.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
	  		
	  		
	  		
	  		ItemStack DiamondShovel = new ItemStack(Material.DIAMOND_SPADE);
	  		ItemMeta DiamondShovelMeta = DiamondShovel.getItemMeta();
	  		DiamondShovelMeta.setDisplayName("Diamond Spade");
	  		DiamondShovel.setItemMeta(DiamondShovelMeta);
			ArrayList<String> DiamondShovel_Lore = new ArrayList<String>();
	  		DiamondShovel_Lore.add("This Shovel Costs $10000");
	  		DiamondShovel_Lore.add("Click Me To Buy!");
	  		DiamondShovel.addEnchantment(Enchantment.DIG_SPEED, 5);
	  		DiamondShovel.addEnchantment(Enchantment.DURABILITY, 3);
	  		DiamondShovel.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
	  		
		
		
		if (clicked.getType() == Material.PAPER) {
			event.setCancelled(true);
			
				player.openInventory(cvc.ClanSellInventory);
			
			}
		
		if (clicked.getType() == Material.DIAMOND_HELMET) {
			event.setCancelled(true);
			
			if(Clan_1.contains(player.getDisplayName()) && ((Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") >= 3500)){
			
				config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") - 3500); 
			
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondHead);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondHead);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_2.contains(player.getDisplayName()) && ((Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") >= 3500)){
				
				config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") - 3500); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondHead);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondHead);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_3.contains(player.getDisplayName()) && ((Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") >= 3500)){
				
				config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") - 3500); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondHead);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondHead);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_4.contains(player.getDisplayName()) && ((Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") >= 3500)){
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") - 3500); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondHead);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondHead);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			}
		
		if (clicked.getType() == Material.DIAMOND_CHESTPLATE) {
			event.setCancelled(true);
			
			if(Clan_1.contains(player.getDisplayName()) && ((Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") >= 5000)){
				
				config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") - 5000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondChest);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondChest);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_2.contains(player.getDisplayName()) && ((Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") >= 5000)){
				
				config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") - 5000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondChest);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondChest);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_3.contains(player.getDisplayName()) && ((Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") >= 5000)){
				
				config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") - 5000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondChest);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondChest);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_4.contains(player.getDisplayName()) && ((Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") >= 5000)){
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") - 5000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondChest);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondChest);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			
			}
		
		if (clicked.getType() == Material.DIAMOND_LEGGINGS) {
			event.setCancelled(true);
			
			
			if(Clan_1.contains(player.getDisplayName()) && ((Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") >= 3500)){
				
				config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") - 3500); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondLegs);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondLegs);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_2.contains(player.getDisplayName()) && ((Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") >= 3500)){
				
				config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") - 3500); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondLegs);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondLegs);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_3.contains(player.getDisplayName()) && ((Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") >= 3500)){
				
				config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") - 3500); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondLegs);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondLegs);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_4.contains(player.getDisplayName()) && ((Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") >= 3500)){
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") - 3500); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondLegs);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondLegs);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			
			}
		
		if (clicked.getType() == Material.DIAMOND_BOOTS) {
			event.setCancelled(true);
			
				
			if(Clan_1.contains(player.getDisplayName()) && ((Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") >= 3200)){
				
				config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") - 3200); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondBoots);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondBoots);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_2.contains(player.getDisplayName()) && ((Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") >= 3200)){
				
				config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") - 3200); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondBoots);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondBoots);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_3.contains(player.getDisplayName()) && ((Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") >= 3200)){
				
				config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") - 3200); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondBoots);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondBoots);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_4.contains(player.getDisplayName()) && ((Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") >= 3200)){
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") - 3200); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondBoots);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondBoots);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			
			}
		
		if (clicked.getType() == Material.DIAMOND_SWORD) {
			event.setCancelled(true);
			
			if(Clan_1.contains(player.getDisplayName()) && ((Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondSword);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondSword);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_2.contains(player.getDisplayName()) && ((Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondSword);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondSword);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_3.contains(player.getDisplayName()) && ((Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondSword);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondSword);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_4.contains(player.getDisplayName()) && ((Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondSword);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondSword);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			}
		
		if (clicked.getType() == Material.DIAMOND_PICKAXE) {
			event.setCancelled(true);
			
		if(Clan_1.contains(player.getDisplayName()) && ((Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondPickAxe);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondPickAxe);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_2.contains(player.getDisplayName()) && ((Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondPickAxe);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondPickAxe);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_3.contains(player.getDisplayName()) && ((Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondPickAxe);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondPickAxe);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_4.contains(player.getDisplayName()) && ((Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondPickAxe);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondPickAxe);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			}
		
		if (clicked.getType() == Material.DIAMOND_AXE) {
			event.setCancelled(true);
			
		if(Clan_1.contains(player.getDisplayName()) && ((Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondAxe);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondAxe);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_2.contains(player.getDisplayName()) && ((Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondAxe);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondAxe);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_3.contains(player.getDisplayName()) && ((Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondAxe);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondAxe);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_4.contains(player.getDisplayName()) && ((Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondAxe);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondAxe);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			}
		
		if (clicked.getType() == Material.DIAMOND_SPADE) {
			event.setCancelled(true);
			
		if(Clan_1.contains(player.getDisplayName()) && ((Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondShovel);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondShovel);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_2.contains(player.getDisplayName()) && ((Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondShovel);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondShovel);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_3.contains(player.getDisplayName()) && ((Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondShovel);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondShovel);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			if(Clan_4.contains(player.getDisplayName()) && ((Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") >= 10000)){
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") - 10000); 
				
				if (player.getInventory().firstEmpty() == -1){
				    // if inventory is full, drop it to the ground (item is a ItemStack)
				    player.getWorld().dropItem(player.getLocation().add(0, 1, 0), DiamondShovel);
				} else{
				    // if there is a empty place, put it in
				    int newItemSlot = player.getInventory().firstEmpty();
				    player.getInventory().setItem(newItemSlot, DiamondShovel);
				 }
				
				 player.updateInventory();
				
				saveConfig();
				
				}
			
			}
		
		
	}
	
if (event.getInventory().getName().equalsIgnoreCase("Clan Sell")){
	
	
	
	Player player = (Player) event.getWhoClicked();


	List<String> Clan_1 = config.getStringList("Clan_1.Players.Names");

	List<String> Clan_2 = config.getStringList("Clan_2.Players.Names");

	List<String> Clan_3 = config.getStringList("Clan_3.Players.Names");

	List<String> Clan_4 = config.getStringList("Clan_4.Players.Names");

	
//Makes it so the code will only work if its in the CustomInv inventory
ItemStack clicked = event.getCurrentItem();
//The item that was clicked


if (clicked.getType() == Material.ANVIL) {
	event.setCancelled(true);
	
		  
 		player.openInventory(cvc.ClanBuyInventory);
	
	}

if (clicked.getType() == Material.DIAMOND) {
event.setCancelled(true);

if(event.getInventory().contains(Material.DIAMOND)){
    
	if(Clan_1.contains(player.getName())){
	
	 player.getInventory().removeItem(new ItemStack(Material.DIAMOND, 1));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 500 );
	
	
	
	config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") + (500 * (Integer)config.get("Clans.Shop.Sell.PayoutReturn"))); 
	
	
	saveConfig();
	
	}
	
	if(event.getInventory().contains(Material.DIAMOND)){
	    
		if(Clan_2.contains(player.getName())){
		
		 player.getInventory().removeItem(new ItemStack(Material.DIAMOND, 1));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 500 );
		
		config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") + (500 * (Integer)config.get("Clans.Shop.Sell.PayoutReturn"))); 
		
		
		saveConfig();
		
		}
		
		
		
		if(event.getInventory().contains(Material.DIAMOND)){
		    
			if(Clan_3.contains(player.getName())){
			
			 player.getInventory().removeItem(new ItemStack(Material.DIAMOND, 1));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 500 );
			
			config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") + (500 * (Integer)config.get("Clans.Shop.Sell.PayoutReturn"))); 
			
		
			saveConfig();
			
			}
			
			
			
			if(event.getInventory().contains(Material.DIAMOND)){
			    
				if(Clan_4.contains(player.getName())){
				
				 player.getInventory().removeItem(new ItemStack(Material.DIAMOND, 1));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 500 );
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") + (500 * (Integer)config.get("Clans.Shop.Sell.PayoutReturn"))); 
				
				
				saveConfig();
				
				
								}
							}
						}			
					}
			}


}
		
if (clicked.getType() == Material.COBBLESTONE) {
event.setCancelled(true);

if(event.getInventory().contains(Material.COBBLESTONE)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.COBBLESTONE, 32)){
		
	 player.getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 32));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 32 );
	
	config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") + (32 * (Integer)config.get("Clans.Shop.Sell.PayoutReturn"))); 
	
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.COBBLESTONE)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.COBBLESTONE, 32)){
			
		 player.getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 32));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 32);
		
		config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") + (32 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.COBBLESTONE)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.COBBLESTONE, 32)){
				
			 player.getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 32));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 32 );
			
			config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") + (32 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.COBBLESTONE)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.COBBLESTONE, 32)){
					
				 player.getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 32));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 32 );
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") + (32 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}

}

if (clicked.getType() == Material.IRON_ORE) {
event.setCancelled(true);

if(event.getInventory().contains(Material.IRON_ORE)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.IRON_ORE, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.IRON_ORE, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 100 );
	
	config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") + (100 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.IRON_ORE)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.IRON_ORE, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.IRON_ORE, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 100);
		
		config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") + (100 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.IRON_ORE)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.IRON_ORE, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.IRON_ORE, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 100 );
			
			config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") + (100 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.IRON_ORE)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.IRON_ORE, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.IRON_ORE, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 100 );
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") + (100 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}

}

if (clicked.getType() == Material.GOLD_ORE) {
event.setCancelled(true);

if(event.getInventory().contains(Material.GOLD_ORE)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.GOLD_ORE, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.GOLD_ORE, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 150 );
	
	config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") + (150 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.GOLD_ORE)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.GOLD_ORE, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.GOLD_ORE, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 150);
		
		config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") + (150 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.GOLD_ORE)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.GOLD_ORE, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.GOLD_ORE, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 150 );
			
			config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") + (150 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.GOLD_ORE)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.GOLD_ORE, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.GOLD_ORE, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 150 );
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") + (150 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}


}

				


if (clicked.getType() == Material.LAPIS_ORE) {
event.setCancelled(true);

if(event.getInventory().contains(Material.LAPIS_ORE)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.LAPIS_ORE, 1)){
		
	 player.getInventory().removeItem(new ItemStack(Material.LAPIS_ORE, 1));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 300 );
	
	config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") + (300 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.LAPIS_ORE)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.LAPIS_ORE, 1)){
			
		 player.getInventory().removeItem(new ItemStack(Material.LAPIS_ORE, 1));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 300);
		
		config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") + (300 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.LAPIS_ORE)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.LAPIS_ORE, 1)){
				
			 player.getInventory().removeItem(new ItemStack(Material.LAPIS_ORE, 1));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 300 );
			
			config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") + (300 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.LAPIS_ORE)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.LAPIS_ORE, 1)){
					
				 player.getInventory().removeItem(new ItemStack(Material.LAPIS_ORE, 1));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 300 );
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") + (300 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}

}

if (clicked.getType() == Material.REDSTONE_ORE) {
event.setCancelled(true);

if(event.getInventory().contains(Material.REDSTONE_ORE)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.REDSTONE_ORE, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.REDSTONE_ORE, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 400 );
	
	config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") + (400 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.REDSTONE_ORE)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.REDSTONE_ORE, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.REDSTONE_ORE, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 400);
		
		config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") + (400 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.REDSTONE_ORE)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.REDSTONE_ORE, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.REDSTONE_ORE, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 400 );
			
			config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") + (400 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
			
			saveConfig();
			
				}
			}
			
			
			if(event.getInventory().contains(Material.REDSTONE_ORE)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.REDSTONE_ORE, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.REDSTONE_ORE, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 400 );
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") + (400 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}
}


if (clicked.getType() == Material.IRON_INGOT) {
event.setCancelled(true);

if(event.getInventory().contains(Material.IRON_INGOT)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.IRON_INGOT, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 150 );
	
	config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") + (150 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.IRON_INGOT)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.IRON_INGOT, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 150);
		
		config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") + (150 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.IRON_INGOT)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.IRON_INGOT, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 150 );
			
			config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") + (150 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.IRON_INGOT)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.IRON_INGOT, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 150 );
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") + (150 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}

}




if (clicked.getType() == Material.GOLD_INGOT) {
event.setCancelled(true);

if(event.getInventory().contains(Material.GOLD_INGOT)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.GOLD_INGOT, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 250 );
	
	config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") + (250 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.GOLD_INGOT)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.GOLD_INGOT, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 250);
		
		config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") + (250 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.GOLD_INGOT)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.GOLD_INGOT, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 250 );
			
			config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") + (250 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.GOLD_INGOT)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.GOLD_INGOT, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 250 );
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") + (250 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}

}


if (clicked.getType() == Material.REDSTONE) {
event.setCancelled(true);

if(event.getInventory().contains(Material.REDSTONE)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.REDSTONE, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.REDSTONE, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 300 );
	
	config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") + (300 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.REDSTONE)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.REDSTONE, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.REDSTONE, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 300);
		
		config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") + (300 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.REDSTONE)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.REDSTONE, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.REDSTONE, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 300 );
			
			config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") + (300 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.REDSTONE)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.REDSTONE, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.REDSTONE, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 300 );
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") + (300 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}
}


if (clicked.getType() == Material.OBSIDIAN) {
event.setCancelled(true);

if(event.getInventory().contains(Material.OBSIDIAN)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.OBSIDIAN, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.OBSIDIAN, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 400 );
	
	config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") + (400 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.OBSIDIAN)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.OBSIDIAN, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.OBSIDIAN, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 400);
		
		config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") + (400 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.OBSIDIAN)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.OBSIDIAN, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.OBSIDIAN, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 400 );
			
			config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") + (400 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.OBSIDIAN)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.OBSIDIAN, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.OBSIDIAN, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 400 );
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") + (400 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}
}


if (clicked.getType() == Material.GLOWSTONE) {
event.setCancelled(true);

if(event.getInventory().contains(Material.GLOWSTONE)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.GLOWSTONE, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.GLOWSTONE, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 600 );
	
	config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") + (600 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.GLOWSTONE)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.GLOWSTONE, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.GLOWSTONE, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 600);
		
		config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") + (600 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.GLOWSTONE)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.GLOWSTONE, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.GLOWSTONE, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 600 );
			
			config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") + (600 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.GLOWSTONE)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.GLOWSTONE, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.GLOWSTONE, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 600 );
				
				config.set("Clan_4.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_4.Players." + player.getName().toString() + ".Bal") + (600 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}

}

if (clicked.getType() == Material.BLAZE_ROD) {
event.setCancelled(true);

if(event.getInventory().contains(Material.BLAZE_ROD)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.BLAZE_ROD, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.BLAZE_ROD, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 800 );
	
	config.set("Clan_1.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_1.Players." + player.getName().toString() + ".Bal") + (800 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.BLAZE_ROD)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.BLAZE_ROD, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.BLAZE_ROD, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 800);
		
		config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") + (800 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.BLAZE_ROD)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.BLAZE_ROD, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.BLAZE_ROD, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 800 );
			
			config.set("Clan_3.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_3.Players." + player.getName().toString() + ".Bal") + (800 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.BLAZE_ROD)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.BLAZE_ROD, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.BLAZE_ROD, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 800 );
				
				config.set("Clan_2.Players." + player.getName().toString() + ".Bal", (Integer)config.get("Clan_2.Players." + player.getName().toString() + ".Bal") + (800 / (Integer)config.get("Clans.Shop.Sell.PayoutReturn")));
				
				saveConfig();
				
																				}
																			}
																		}
																	}
																}
															}
														}


													}
												}
											}