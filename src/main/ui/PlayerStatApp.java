package ui;

import model.CompareList;
import model.Player;
import model.PlayerList;

import java.sql.DataTruncation;
import java.util.List;
import java.util.Scanner;



// Runs app initializing console with all features using methods from model classes
public class PlayerStatApp {
    private Scanner input;
    private Player player1;
    private Player player2;

    private Player player3;
    private Player player4;
    private Player player5;

    private PlayerList plrList;
    private CompareList cmpList;




    // EFFECTS: runs runApp method
    public PlayerStatApp() {
        runApp();

    }

    // EFFECTS: intialize console app, bring up needed aspects to get it running
    public void runApp() {

        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

    }

    // EFFECTS: process command from user to take to other parts of app
    private void processCommand(String command) {
        if (command.equals("comp")) {
            openCompPage();
        } else if (command.equals("rel")) {
            // relStatSort();
            System.out.println("Sorry, this feature is not available yet, please check back again soon!");
        } else if (command.equals("filter")) {
            filterByPosition();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    //
    // EFFECTS: filter the list of players by the position the user enter, uses PlayerList methods
    // MODIFIES: this
    private void filterByPosition() {
        String position;

        System.out.println("filter by what position?");
        position = input.next();

        displayPlayerList(plrList.filterByPost(position));

        input.useDelimiter("\n");
        System.out.println("enter 'back' to return to main menu\n");
        if (input.next() == "back") {
            init();
        }

    }

    //
    // private void relStatSort() {

    //    System.out.println("Showing sorted version");

    //}

    // TODO: fix bug (doesnt show cmpList when user is done)
    // MODIFIES: cmpList
    // EFFECTS: run comparison feature and allow user to add players by name from the master player list
    private CompareList openCompPage() {
        String plr;

        System.out.println("add players to the comparison list!");
        System.out.println("enter a player's name to add them to the list (capitalize as with regular names)");
        plr = input.next();

        cmpList = new CompareList();

        for (Player player : plrList.getPlayerList()) {
            if (player.getName().equals(plr)) {
                cmpList.addPlayer(player);
            }
        }

        System.out.println("would you like to add another player? (y/n)");
        String answr;

        answr = input.next();

        yesNoController(answr);


        displayPlayerList(cmpList.getCompareList());


        System.out.println("enter 'back' to return to main menu\n");
        if (input.next() == "back") {
            init();
        }

        return cmpList;

    }

    // MODIFIES: cmpList
    // EFFECTS: process yes/no response from user during openCompPage method
    private boolean yesNoController(String answr) {
        if (answr.equals("y")) {
            String plr2;

            System.out.println("enter a player's name to add them to the list (capitalize as w regular names)");
            plr2 = input.next();

            for (Player player : plrList.getPlayerList()) {
                if (player.getName().equals(plr2)) {
                    cmpList.addPlayer(player);
                }
            }

            return true;
        }

        return false;
    }

    // EFFECTS: display menu options when initializing console application
    private void displayMenu() {

        displayPlayerList(plrList.getPlayerList());

        System.out.println("Select from:");
        System.out.println("\tcomp -> compare list page");
        System.out.println("\trel -> rel stats");
        System.out.println("\tfilter -> filter by given position");
        System.out.println("\tq -> quit");
    }


    private String displayPlayerList(List<Player> players) {
        for (Player player : players) {
            System.out.println(player.getName() + " " + player.getCat() + " " + player.getPost() + " "
                    + player.getGs() + " " + player.getAst() + " " + player.getMts());
        }
        System.out.println("\n");

        return "no players found...";
    }


    // EFFECTS: initialize the needed values throughout the application
    @SuppressWarnings("methodlength")
    private void init() {


        player1 = new Player("Messi", "att", "winger",
                11, 14, 34, 9,
                115, 39, 0, 76, 87,
                0.32, 0.74, 0.68, 2.56);

        player2 = new Player("Ronaldo", "att", "striker",
                24, 3, 39, 21,
                133, 55, 0, 36, 30,
                0.62, 0.69, 0.62, 0.77);

        player3 = new Player("Benzema", "att", "centre-forward",
                42, 13, 44, 33,
                174, 81, 0, 0, 75,
                1.01, 1.34, 1.08, 1.22);

        player4 = new Player("Lewandowski", "att", "striker",
                50, 6, 46, 42,
                191, 96, 0, 0, 61,
                1.13, 1.26, 1.08, 1.01);

        player5 = new Player("Salah", "att", "winger",
                31, 15, 51, 25,
                184, 70, 0, 0, 71,
                0.70, 1.03, 0.90, 1.96);


        plrList = new PlayerList();
        plrList.getPlayerList().add(player1);
        plrList.getPlayerList().add(player2);
        plrList.getPlayerList().add(player3);
        plrList.getPlayerList().add(player4);
        plrList.getPlayerList().add(player5);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }


}
