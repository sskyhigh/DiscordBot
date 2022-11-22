package com.skyhigh.commands.Listeners;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventListener extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        User user = event.getUser();
        String emoji = event.getReaction().getEmoji().getAsReactionCode();
        Channel channel = event.getChannel();
        String mentionedChannel = event.getChannel().getAsMention();
        String link = event.getJumpUrl();

        String userInfo = user.getAsTag()  + "reacted to a msg!";
        event.getGuild().getDefaultChannel().asTextChannel();
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        if(msg.contains("Hello")){
            event.getChannel().sendMessage("No").queue();
        }
    }
}
