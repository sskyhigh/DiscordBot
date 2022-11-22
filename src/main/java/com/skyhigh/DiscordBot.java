package com.skyhigh;

import com.skyhigh.commands.Command;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;
import java.util.EventListener;

public class DiscordBot {
    private ShardManager shardManager = null;

    public DiscordBot() throws LoginException {
        try {
            String discordToken = "MTA0NDQ2MDcyMzMxMDQ0NDYyNA.G9-g4-.ul-mJSHRwTcSBMeCmmFGP8BVh3rczoJFJWYDMY";
            DefaultShardManagerBuilder managerBuilder =
                    DefaultShardManagerBuilder.createDefault(discordToken);
            managerBuilder.setStatus(OnlineStatus.ONLINE);
            managerBuilder.setActivity(Activity.watching("Bitcoin"));
            shardManager = managerBuilder.build();
            shardManager.addEventListener(new EventListener(), new Command());

        } catch (Exception exception) {System.out.print("Invalid token");;}
    }

    public static void main(String[] args) {
        try {
            DiscordBot discordBot = new DiscordBot();
        } catch (Exception exception) {exception.printStackTrace();}
    }

    public ShardManager getShardManager() {
        return shardManager;
    }
}
