package me.scorchingflame;

import net.dv8tion.jda.api.entities.Mentions;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.MessageUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class event extends ListenerAdapter {
    @Override
    public void onMessageDelete(@NotNull MessageDeleteEvent event) {
        if (Main.userMessageHashMap.containsKey(event.getMessageId())){
            // ghost ping
            Main.addToGhostList(event.getMessageId(), Main.userMessageHashMap.get(event.getMessageId()).setType(GhostType.DELETE));
            Main.userMessageHashMap.remove(event.getMessageId());
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Mentions mentions = event.getMessage().getMentions();
        if (!(mentions.getMembers().isEmpty()) || !(mentions.getRoles().isEmpty())){
            Main.userMessageHashMap.put(event.getMessageId(), new CachedPing(event.getMessage()));
        }
    }

    @Override
    public void onMessageUpdate(MessageUpdateEvent event) {
        Mentions mentions = event.getMessage().getMentions();
        if (!(mentions.getMembers().isEmpty()) || !(mentions.getRoles().isEmpty())){
            Main.userMessageHashMap.put(event.getMessageId(), new CachedPing(event.getMessage()));
        }else {
            if (Main.userMessageHashMap.containsKey(event.getMessageId())){
                Main.addToGhostList(event.getMessageId(), Main.userMessageHashMap.get(event.getMessageId()).setType(GhostType.UPDATE));
                Main.userMessageHashMap.remove(event.getMessageId());
            }
        }
        super.onMessageUpdate(event);
    }
}
