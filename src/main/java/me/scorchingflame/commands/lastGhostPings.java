package me.scorchingflame.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

public class lastGhostPings implements ISlashCommand{
    @NotNull
    @Override
    public CommandData getCommandData() {
        return Commands.slash(
                "lastghostping",
                "Shows the last ghost pings you've received (@me and @role)"
        );
    }

    @Override
    public void execute(@NotNull SlashCommandInteractionEvent event) {
        event.getInteraction().deferReply().queue();
    }
}
