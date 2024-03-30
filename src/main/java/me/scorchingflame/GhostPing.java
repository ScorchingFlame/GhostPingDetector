package me.scorchingflame;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GhostPing {
    private final String authorUserName;
    private final String authorID;
    private final String timeStamp;
    private final String content;
    private final GhostType ghostType;
    private final List<String> ghostedUsers;
    private final List<String> ghostedRoles;

    public GhostPing(CachedPing cachedPing) {
        this.authorID = cachedPing.getAuthorID();
        this.authorUserName = cachedPing.getAuthorName();
        this.timeStamp = String.valueOf(Instant.now().getEpochSecond());
        this.content = cachedPing.getContent();
        this.ghostType = cachedPing.getType();
        ghostedUsers = new ArrayList<>();
        ghostedRoles = new ArrayList<>();
        Matcher match = Pattern.compile("<@\\d+>").matcher(content);
        while (match.find()) {
            ghostedUsers.add(match.group());
        }
        Matcher match1 = Pattern.compile("<@&\\d+>").matcher(content);
        while (match1.find()) {
            ghostedRoles.add(match1.group());
        }
    }

    public String getAuthorUserName() {
        return authorUserName;
    }

    public String getAuthorID() {
        return authorID;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getContent() {
        return content;
    }

    public List<String> getGhostedUsers() {
        return ghostedUsers;
    }

    public List<String> getGhostedRoles() {
        return ghostedRoles;
    }

    public GhostType getGhostType() {
        return ghostType;
    }
}
