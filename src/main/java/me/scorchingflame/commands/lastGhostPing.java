package me.scorchingflame.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class lastGhostPing implements ISlashCommand{
    @NotNull
    @Override
    public CommandData getCommandData() {
        return Commands.slash("ghostping",
                        "Shows the last ghost pings you've received (@me and @role)")
                .addSubcommands(
                        new SubcommandData(
                                "atme",
                                "Shows the last @me ghost pings you've received."
                        ),
                        new SubcommandData(
                                "role",
                                "Shows the last ghost pings you've received through mentioned role."
                        ),
                        new SubcommandData(
                                "all",
                                "Shows all the ghost pings that was sent in this server."
                        )
                )
                ;
    }

    @Override
    public void execute(@NotNull SlashCommandInteractionEvent event) {
        @Nullable String name = event.getSubcommandName();
        switch (name){
            case null:
                System.out.println("l");
                break;
            case "atme":
                break;
            case "role":
                break;
            case "all":
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
    }
}
