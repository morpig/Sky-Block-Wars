package me.kyle.burnett.SkyBlockWarriors.Listeners;

import me.kyle.burnett.SkyBlockWarriors.Game;
import me.kyle.burnett.SkyBlockWarriors.GameManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener{
    
    
    @EventHandler
    public void onMove(PlayerMoveEvent e){
        
        if(GameManager.getInstance().isPlayerInGame(e.getPlayer())) {
            
            if(GameManager.getInstance().hasPlayerGameStarted(e.getPlayer())){
                
                Player p = e.getPlayer();
                
                Game g = GameManager.getInstance().getPlayerGame(p);
                
                if(!g.isBlockInArena(p.getLocation())){
                    e.setTo(e.getFrom());
                }                               
            }           
        }       
    }
}

