package me.scorchingflame;

import net.dv8tion.jda.api.entities.Message;

public class CachedPing {
    private String authorID;
    private String authorName;
    private String content;
    private GhostType type;

    public CachedPing(Message message){
        this.authorID = message.getAuthor().getId();
        this.authorName = message.getAuthor().getName();
        this.content = message.getContentRaw();
        this.type = null;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthor() {
        return authorID;
    }

    public String getContent() {
        return content;
    }

    public GhostType getType() {return type; }

    public void setAuthor(String author) {
        this.authorID = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CachedPing setType(GhostType type){
        this.type = type;
        return this;
    }
}

