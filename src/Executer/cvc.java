package Executer;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;

import Clan.clan;



public class cvc implements CommandExecutor{
	 
    @SuppressWarnings("unused")
    private clan plugin;
    public cvc(clan plugin){
        this.plugin = plugin;
 
    }
 
    int Bal = 1000;
    
 
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if((commandLabel.equalsIgnoreCase("CvC") && args.length == 0)){
            if(sender instanceof Player){
            	Player player = (Player) sender;
  
                  sender.sendMessage(ChatColor.GOLD + "==================[CvC 1 / 2]===================");

				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC SetAdmin (Clan Number / Name) (Player Name)" + ChatColor.DARK_PURPLE + " This Command Is Used To Assign Clan Admins.");

				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC Claim (Clan Number / Name) " + ChatColor.DARK_PURPLE + "This Command Allows For Admins To Set The Main Starting Claim For Clans.");
				  
				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC ExpandCost " + ChatColor.DARK_PURPLE + "This Command Allows For The Admins Of The Clan To Check How Much It Will Cost To Expand Their Claim To The Next Size."); 
				  
				  sender.sendMessage(ChatColor.GOLD + "================================================");
				  

            }
            
            return true;
            
            
            	
            }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("setAdmin"))){
            	
            	Player playerName = Bukkit.getPlayer(args[2]);
            	
            	   FileConfiguration config = plugin.getConfig();
            	   
            	
            	if(args[1].equalsIgnoreCase("1") && playerName.getName().toString() != config.get("Clan_2.Admin.UserName").toString() && playerName.getName().toString() != config.get("Clan_3.Admin.UserName").toString() && playerName.getName().toString() != config.get("Clan_4.Admin.UserName").toString()){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 1 Leader!");

            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Clan 1 Leader!");

            	     config.set("Clan_1.Admin.UserName", null);

            	     config.set("Clan_1.Admin.UserName", playerName.getDisplayName());

            	    plugin.configSave();

            	     plugin.reloadConfig();
            	     
            	     }

            	   	 

            	     if(args[1].equalsIgnoreCase("2") && playerName.getName().toString() != config.get("Clan_1.Admin.UserName").toString() && playerName.getName().toString() != config.get("Clan_3.Admin.UserName").toString() && playerName.getName().toString() != config.get("Clan_4.Admin.UserName").toString() ){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 2 Leader!");

            	   	 

            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Clan 2 Leader!");

            	     config.set("Clan_2.Admin.UserName", null);

            	     config.set("Clan_2.Admin.UserName", playerName.getDisplayName());

            	     plugin.configSave();

            	     plugin.reloadConfig();
            	     
            	     }

            	   	 

            	     if(args[1].equalsIgnoreCase("3") && playerName.getName().toString() != config.get("Clan_1.Admin.UserName").toString() && playerName.getName().toString() != config.get("Clan_2.Admin.UserName").toString() && playerName.getName().toString() != config.get("Clan_4.Admin.UserName").toString() ){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 3 Leader!");

            	    

            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Clan 3 Leader!");

            	     config.set("Clan_3.Admin.UserName", null);

            	     config.set("Clan_3.Admin.UserName", playerName.getDisplayName());

            	     plugin.configSave();

            	     plugin.reloadConfig();
            	     }



            	     if(args[1].equalsIgnoreCase("4") && playerName.getName() != config.get("Clan_1.Admin.UserName") && playerName.getName() != config.get("Clan_2.Admin.UserName") && playerName.getName() != config.get("Clan_3.Admin.UserName") ){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 4 Leader!");



            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Clan 4 Leader!");

            	     config.set("Clan_4.Admin.UserName", null);

            	     config.set("Clan_4.Admin.UserName", playerName.getDisplayName());

            	     plugin.configSave();

            	     plugin.reloadConfig();
            	     
            	     }
            
        
            return true;
            
            
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("2"))){
        	
       	 		sender.sendMessage(ChatColor.GOLD + "==================[CvC 2 / 2]===================");
       	 
			  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC Expand " + ChatColor.DARK_PURPLE + "This Command Allows For The Admins Of The Clan To Expand Their Claim.");
			  
			  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC Bal " + ChatColor.DARK_PURPLE + "This Command Allows For The Admins Of A Clan To Check The Amount Of Money The Clan Has.");
			  
			  
			  sender.sendMessage(ChatColor.GOLD + "================================================");
       	
       return true;	
       
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Bal"))){
        	
        	   FileConfiguration config = plugin.getConfig();
    
        	   
        	   if(sender.getName().equalsIgnoreCase((String) config.get("Clan_1.Admin.UserName"))){

   	 		sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Ballance Is " + ChatColor.GREEN + "$" + config.get("Clan_1.Admin.Ballance"));
 
   	 		plugin.saveConfig();
   	 		
        	}
        	   
        	   if(sender.getName().equalsIgnoreCase((String) config.get("Clan_2.Admin.UserName"))){

          	 		sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Ballance Is " + ChatColor.GREEN + "$" + config.get("Clan_2.Admin.Ballance"));
        
          	 		plugin.saveConfig();
          	 		
               	}
        	   
        	   
        	   
        	   if(sender.getName().equalsIgnoreCase((String) config.get("Clan_3.Admin.UserName"))){

          	 		sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Ballance Is " + ChatColor.GREEN + "$" + config.get("Clan_3.Admin.Ballance"));
        
          	 		plugin.saveConfig();
          	 		
               	}
        	   
        	   
        	   if(sender.getName().equalsIgnoreCase((String) config.get("Clan_4.Admin.UserName"))){

          	 		sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Ballance Is " + ChatColor.GREEN + "$" + config.get("Clan_4.Admin.Ballance"));
        
          	 		plugin.saveConfig();
          	 		
               	}else{
        		
        	 sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Are Not The Clan Leader!");
        		
        	}

        	return true;	
        
        
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Expand") && args[1].equalsIgnoreCase("Cost"))){
        	
     	   FileConfiguration config = plugin.getConfig();
     	   
     	   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] ");
     	   
     	   return true;
     	   
     	   
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Sell"))){
        	
        	FileConfiguration config = plugin.getConfig();
     	   
     	   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] ");
     	  
     	  List<String> list = config.getStringList("Clan_1.Players.Names");
     	   
     	  if(sender instanceof Player){
				
     		 list.add(sender.getName());
     		 
     		// add to config
     		config.set("Clan_1.Players.Names", list);
     		 
     		// save
     		plugin.saveConfig();
     			
     	  } 
     	  
     	   
     	   
     	   return true;
     	   
     	   
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("SetHome"))){
        	
        	FileConfiguration config = plugin.getConfig();
        	if(sender instanceof Player){
        		
        	int PlayerLocX = (int) ((Player) sender).getLocation().getX();
        	int PlayerLocY = (int) ((Player) sender).getLocation().getY();
        	int PlayerLocZ = (int) ((Player) sender).getLocation().getZ();
        	
        	
        	 if(sender.getName().equalsIgnoreCase((String) config.get("Clan_1.Admin.UserName"))){
        		 
        		 config.set("Clan_1.Home.X", PlayerLocX);
        		 config.set("Clan_1.Home.Y", PlayerLocY);
        		 config.set("Clan_1.Home.Z", PlayerLocZ);
         		
        		 
        		 if(sender.getName().equalsIgnoreCase((String) config.get("Clan_2.Admin.UserName"))){
        			 
        			 
        			 
        			 if(sender.getName().equalsIgnoreCase((String) config.get("Clan_3.Admin.UserName"))){
        				 
        				 
        				 
        				 if(sender.getName().equalsIgnoreCase((String) config.get("Clan_4.Admin.UserName"))){
        					 
        					 
        					 
        				 }
        			 }
        			 
        		 }
        		 
        	 }
        	
        }
        	
        }else{
        	
        	sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan]" + ChatColor.DARK_RED + "The Command You Enterd Is Not Correct Please Try Again");
       
        	 
        	
        }
        
       
        
    
        return false;
    }
}