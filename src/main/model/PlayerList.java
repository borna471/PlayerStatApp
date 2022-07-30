package model;

import java.util.ArrayList;
import java.util.List;

// a list of Players that will be used throughout the program, but mainly for then main list of players on home page
// and for reference
public class PlayerList {
    private List<Player> playerList;


    // EFFECTS: instantiates a new blank playerList
    public PlayerList() {
        playerList = new ArrayList<>();

    }


    // REQUIRES: a non-empty list of players
    // EFFECTS: creates a new list of players that are in the given position
    public List<Player> filterByPost(String post) {

        List<Player> filteredList = new ArrayList<>();

        for (Player player : playerList) {

            // == checks it two objects point to the same place (w/ their arrows)
            // .equals() checks the values themselves

            if (player.getPost().equals(post)) {
                filteredList.add(player);
            }

        }

        return filteredList;
    }



//    // MODIFIES: this
//    // EFFECTS: adds player to playerList
//    private boolean addPlyer(Player player) {
//
//        playerList.add(player);
//
//        return true;
//
//    }

    // private void sortByStat() {

    // }


    public List<Player> getPlayerList() {
        return playerList;
    }



    // REQUIRES: a filtered list of players by position (ie. only one position in the given list)
    // EFFECTS: brings most relevant stats to that position to the top

//    @SuppressWarnings("methodlength")
//    public List<Player> showRelStats() {
//        List<Player> showRelList = new ArrayList<>();
//
//        for (Player player : playerList) {
//            switch (player.getPost()) {
//                case "striker":
//                    Player plyr1 = new Player(
//                            player.getName(),
//                            player.getCat(),
//                            player.getPost(),
//                            player.getGs(),
//                            player.getAst(),
//                            player.getMts(),
//                            player.getNpgs(),
//                            player.getTotalShts(),
//                            player.getShtsOnTrgt(),
//                            player.getTchsInBox(),
//                            player.getKypases(),
//                            player.getDrbls(),
//                            player.getGsPer90(),
//                            player.getGsAndAstPer90(),
//                            player.getNpgsAndAstPer90(),
//                            player.getDrblsPer90());
//                    showRelList.add(plyr1);
//                    break;
//
//                case "centre-forward":
//                    Player plyr2 = new Player(
//                            player.getName(),
//                            player.getCat(),
//                            player.getPost(),
//                            player.getAst(),
//                            player.getGs(),
//                            player.getMts(),
//                            player.getNpgs(),
//                            player.getTotalShts(),
//                            player.getShtsOnTrgt(),
//                            player.getTchsInBox(),
//                            player.getKypases(),
//                            player.getDrbls(),
//                            player.getGsPer90(),
//                            player.getGsAndAstPer90(),
//                            player.getNpgsAndAstPer90(),
//                            player.getDrblsPer90());
//                    showRelList.add(plyr2);
//                    break;
//
//                case "winger":
//                    Player plyr3 = new Player(
//                            player.getName(),
//                            player.getCat(),
//                            player.getPost(),
//                            player.getAst(),
//                            player.getGs(),
//                            player.getMts(),
//                            player.getDrbls(),
//                            player.getKypases(),
//                            player.getNpgs(),
//                            player.getTotalShts(),
//                            player.getShtsOnTrgt(),
//                            player.getTchsInBox(),
//                            player.getDrblsPer90(),
//                            player.getGsAndAstPer90(),
//                            player.getGsPer90(),
//                            player.getNpgsAndAstPer90());
//                    showRelList.add(plyr3);
//                    break;
//
//            }
//
//        }
//
//        return showRelList;
//
//    }


}



