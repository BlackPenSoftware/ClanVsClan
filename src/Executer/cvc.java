package Executer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Clan.clan;

public class cvc implements CommandExecutor{
	 
    @SuppressWarnings("unused")
    private clan plugin;
    public cvc(clan plugin){
        this.plugin = plugin;
 
    }
    
    
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if((commandLabel.equalsIgnoreCase("CvC") && args.length == 0)){
            if(sender instanceof Player){
            	Player player = (Player) sender;
  
                  sender.sendMessage(ChatColor.GOLD + "==================[CvC 1 / 2]===================");

				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC SetAdmin (Clan Number / Name) (Player Name)" + ChatColor.DARK_PURPLE + " This Command Is Used To Assign Clan Admins.");

				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC Claim (Clan Number / Name) " + ChatColor.DARK_PURPLE + "This Command Allows For Admins To Set The Main Starting Claim For Clans.");
				  
				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC ExpandCost " + ChatColor.DARK_PURPLE + "This Command Allows For The Admins Of The Clan To Check How Much It Will Cost To Expand Their Claim To The Nex Size."); 
				  
				  sender.sendMessage(ChatColor.GOLD + "================================================");
				  

            }
            
            return true;
            
            	
            }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("setAdmin"))){
            	
            	Player playerName = Bukkit.getPlayer(args[2]);
            	
            	if(args[1].equalsIgnoreCase("1")){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 1 Leader!");

            	   	 

            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Clan 1 Leader!");

            	   	 

            	     }

            	   	 

            	     if(args[1].equalsIgnoreCase("2")){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 2 Leader!");

            	   	 

            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Clan 2 Leader!");

            	    

            	   	 

            	     }

            	   	 

            	     if(args[1].equalsIgnoreCase("3")){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 3 Leader!");

            	    

            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Clan 3 Leader!");

            	    

            	   	 

            	     }



            	     if(args[1].equalsIgnoreCase("4")){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 4 Leader!");



            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Clan 4 Leader!");

            	   

            	   	 

            	     }
            
        
            return true;
            
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("2"))){
        	
        	 sender.sendMessage(ChatColor.GOLD + "==================[CvC 2 / 2]===================");
        	 
			  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC Expand " + ChatColor.DARK_PURPLE + "This Command Allows For The Admins Of The Clan To Expand Their Claim.");
			  
			  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC Bal " + ChatColor.DARK_PURPLE + "This Command Allows For The Admins Of A Clan To Check The Amount Of Money The Clan Has.");
			  
			  
			  sender.sendMessage(ChatColor.GOLD + "================================================");
        	
        return true;	
        }
        
        
        return false;
    }
}