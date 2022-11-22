package com.skyhigh;

import com.skyhigh.commands.Command;
import com.skyhigh.commands.Listeners.EventListener;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    private ShardManager shardManager = null;

    public DiscordBot() throws LoginException {
        try {
            String discordToken = "No";
            DefaultShardManagerBuilder managerBuilder =
                    DefaultShardManagerBuilder.createDefault(discordToken);
            managerBuilder.setStatus(OnlineStatus.ONLINE);
            managerBuilder.setActivity(Activity.watching("Bitcoin"));
            shardManager = managerBuilder.build();
            shardManager.addEventListener(new Command());
        } catch (Exception exception) {System.out.print("Invalid token");
        }
    }
    public ShardManager getShardManager() {
        return shardManager;
    }
    public static void main(String[] args) {
        try {
            DiscordBot discordBot = new DiscordBot();
        } catch (Exception exception) {exception.printStackTrace();}
    }
}
