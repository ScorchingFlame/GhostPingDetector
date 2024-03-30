package me.scorchingflame.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

public interface ISlashCommand {
    // Returns the object describing the slash command
    @NotNull
    CommandData getCommandData();

    // Runs the slash command, only called if the command name matches
    void execute(@NotNull SlashCommandInteractionEvent event);
}
