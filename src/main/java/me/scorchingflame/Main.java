package me.scorchingflame;

import me.scorchingflame.commands.SlashCommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import me.scorchingflame.commands.lastGhostPing;

import java.io.IOException;


public class Main{
    public static MaxSizeHashMap<String, CachedPing> userMessageHashMap = new MaxSizeHashMap<>(10000);
    public static MaxSizeHashMap<String, GhostPing> ghostMessages = new MaxSizeHashMap<>(0);
    public static crudGSON<String, CachedPing> jsonUserMessageHashMap = new crudGSON<>();
    public static crudGSON<String, GhostPing> jsonGhostMessages = new crudGSON<>();
    public static void main(String[] args) throws IOException {
        ghostMessages = jsonGhostMessages.setUp("./ghostPings.json", 0);
        userMessageHashMap = jsonUserMessageHashMap.setUp("./userMessageHashMap.json", 100000);
        final var slashCommandManager = new SlashCommandManager();
        slashCommandManager.addCommands(
                new lastGhostPing()
                // Can also add more
        );

        JDA jda = JDABuilder.createLight(new DotEnv().setUp(".env").getEnv("TOKEN"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new event(), slashCommandManager)
                .addEventListeners()
                .build();
    }

    public static void addToGhostList(String key, CachedPing cachedPing){
        // TODO ; do the holy things
        ghostMessages.put(key, new GhostPing(cachedPing));
    }
}