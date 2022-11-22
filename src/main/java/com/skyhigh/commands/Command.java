package com.skyhigh.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Command extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
       String comm = event.getName();
       if(comm.equals("Hi")){
           String tag = event.getUser().getAsTag();
           event.reply("Hello, welcome to server.").queue();
       }
    }
}
