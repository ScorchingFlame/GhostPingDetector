package me.scorchingflame.commands.utils;

import me.scorchingflame.GhostPing;

import java.util.List;

public class Pagination {
    private static List<GhostPing> ghostPingList;
    private static Integer mpp;
    public Pagination(List<GhostPing> pings, Integer mpp1){
        ghostPingList = pings;
        mpp = mpp1;
    }
    public static void getMessage(){
        Integer numberOfPages = ((ghostPingList.size() % mpp) == 0)
                ? (ghostPingList.size() / mpp) :
                ((ghostPingList.size() -(ghostPingList.size() % mpp)) / mpp);


    }
}
