package com.skyhigh.commands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Command extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String comm = event.getName();
        if (comm.equals("Hi")) {
            String tag = event.getUser().getAsTag();
            event.reply("Hello, welcome to server.").queue();
        }
    }
/*    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        List<CommandData> data = new ArrayList<>();
        data.add(Commands.slash("Hello", "Nice meeting you"));
        event.getGuild().updateCommands().addCommands(data).queue();
    }*/
    // bot ID: 1044460723310444624
    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> data = new ArrayList<>();
        data.add(Commands.slash("welcome", "Bot welcomes you to heaven"));
        event.getGuild().updateCommands().addCommands(data).queue();

        // 1044460723310444624 is the discord bot ID
        /*if(event.getGuild().getIdLong() == 1044460723310444624L){
               check if bots exist
        }*/
    }
}
