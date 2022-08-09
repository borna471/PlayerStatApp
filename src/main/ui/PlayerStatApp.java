package ui;

import model.CompareList;
import model.Player;
import model.PlayerList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import javax.tools.Tool;


// Runs app initializing console with all features using methods from model classes
public class PlayerStatApp extends JFrame {
    private static final String JSON_STORE = "./data/CompareList.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    private JButton addPlayer;
    private JButton loadSavedList;
    private JButton saveCurrentList;
    private JButton filterCurrentList;
    private JTextField addPlayerBox;
    private JLabel playerBoxLabel;
    private DefaultListModel cmprList;
    private JList playerList;
    private ImageIcon imageIcon;
    // private JLabel displayField;
    private JLabel imageLabel;

    private Scanner input;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Player player5;

    private PlayerList plrList;
    private CompareList cmpList;
    private CompareList compareList;

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();


    public PlayerStatApp() {
        super("Player Stat App");

        initGraphics();
        // initApp();
    }

    // EFFECTS: intialize console app, bring up needed aspects to get it running
    public void initApp() {

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

    // MODIFIES: plrList, frame, panel
    // EFFECTS: initialize all the fields and aspects of the GUI
    @SuppressWarnings("methodlength")
    private void initGraphics() {

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

        cmprList = new DefaultListModel();
        // cmprList.addElement(player1);
        // cmprList.addElement(player2);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        imageIcon = new ImageIcon("./data/img.png");

        frame.setLayout(new BorderLayout());
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Player Stat App");

        panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        panel.setLayout(new GridLayout(0, 1));
        // frame.setContentPane(panel);

        displayMenuGUI();

    }

    // MODIFIES: frame, panel
    // EFFECTS: display the main interface of the GUI, showing the needed buttons and mapping them on the panel
    // and frame, initializing their own functionalities as well
    private void displayMenuGUI() {

        frame.add(panel, BorderLayout.CENTER);

        JTextArea players = new JTextArea("Compare player statistics below!\n");
        players.setEditable(false);
        frame.add(players, BorderLayout.NORTH);
        players.setVisible(true);

        initLoadButton();

        initSaveButton();

        initAddButton();

        initRemoveButton();


        addPlayerBox = new JTextField(20);
        addPlayerBox.setBounds(100, 20, 165, 25);
        panel.add(addPlayerBox);

        playerBoxLabel = new JLabel("Type a name, then press the button above to add to your list!");
        panel.add(playerBoxLabel);

        playerList = new JList(cmprList);
        playerList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        playerList.setSelectedIndex(0);
        playerList.setVisibleRowCount(6);
        JScrollPane listScrollPane = new JScrollPane(playerList);

        frame.add(playerList, BorderLayout.SOUTH);



        // System.out.println(addPlayerBox.getText());


    }

    private void initRemoveButton() {
        filterCurrentList = new JButton("Remove Player");
        panel.add(filterCurrentList, CENTER_ALIGNMENT);
        filterCurrentList.setVisible(true);
        filterCurrentList.addActionListener(new RemovePlayerListener());
    }

    private void initAddButton() {
        addPlayer = new JButton("Add Player");
        addPlayer.setPreferredSize(new Dimension(100, 100));
        panel.add(addPlayer, CENTER_ALIGNMENT);
        addPlayer.setVisible(true);
        addPlayer.addActionListener(new AddPlayerListener());
    }

    private void initSaveButton() {
        saveCurrentList = new JButton("Save Current List");
        panel.add(saveCurrentList, CENTER_ALIGNMENT);
        saveCurrentList.setVisible(true);
        saveCurrentList.addActionListener(new SaveListListener());
    }

    private void initLoadButton() {

        loadSavedList = new JButton("Load saved list");
        loadSavedList.setPreferredSize(new Dimension(70, 70));
        panel.add(loadSavedList, CENTER_ALIGNMENT);
        loadSavedList.setVisible(true);
        loadSavedList.addActionListener(new LoadListListener());
    }


    // MODIFIES: cmprList
    // EFFECTS: method called when add player button is pressed, take string entered by user, if player with matching
    // name found in plrList, add them to cmprList in a way it gets displayed, otherwise nothing happens
    private class AddPlayerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String plr = addPlayerBox.getText();

            for (Player player : plrList.getPlayerList()) {
                if (player.getName().equals(plr)) {
                    cmprList.add(cmprList.size(),
                            player.getName() + " "
                            + player.getCat() + " "
                            + player.getPost() + " "
                                    + player.getGs() + " "
                                    + player.getAst() + " "
                                    + player.getMts());
                }
            }

            if (plr.equals(player1.getName())) {

                imageLabel = new JLabel(imageIcon);
                imageLabel.setSize(new Dimension(30,30));
                imageLabel.setIcon(imageIcon);
                // imageLabel.setSize(5, 5);
                frame.add(imageLabel, BorderLayout.EAST);
            }




                //try {

                    // image = ImageIO.read(new File("data/tobs.jpg"));

                // imageIcon = new ImageIcon(getClass().getResource("tobs.jpg"));

                    // imageIcon = new ImageIcon();
                // playerBoxLabel = new JLabel(imageIcon);
//                } catch (Exception exception) {
//                    System.out.println("Image could not be found!");
//                }


                // playerBoxLabel.setVisible(true);


            // }



        }
    }

    // MODIFIES: cmprList
    // EFFECTS: method called when remove player button is pressed, removes the selected player in the list from the
    // list
    private class RemovePlayerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // String post = addPlayerBox.getText();

            int index = playerList.getSelectedIndex();
            try {
                cmprList.remove(index);

            } catch (Exception excep) {
                System.out.println("no player to remove!");
            }

        }
    }

    // MODIFIES: cmprList
    // EFFECTS: loads the previously saved list using JsonReader, throws IOException if it is unable to read from
    // given storing location
    private class LoadListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                for (Player player : jsonReader.read().getCompareList()) {
                    cmprList.addElement(player.getName() + " "
                            + player.getCat() + " "
                            + player.getPost() + " "
                            + player.getGs() + " "
                            + player.getAst() + " "
                            + player.getMts());
                }
                System.out.println("Loaded list from " + JSON_STORE);
            } catch (IOException ioException) {
                System.out.println("Unable to read from file: " + JSON_STORE);
            }

        }
    }

    // MODIFIES: guiCompareList
    // EFFECTS: saves current cmprList using JsonWriter by writing to a comparelist, throws
    // FileNotFoundException if unable to write to file
    private class SaveListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                CompareList guiCompareList = new CompareList();

                for (Object element : cmprList.toArray()) {
                    String element2 = element.toString().substring(0, element.toString().indexOf(" "));
                    
                    Player player = null;
                    
                    for (Player plr : plrList.getPlayerList()) {
                        if (plr.getName().equals(element2)) {
                            player = plr;
                        }
                    }

                    guiCompareList.addPlayer(player);
                }

                jsonWriter.open();
                jsonWriter.write(guiCompareList);
                jsonWriter.close();
                System.out.println("Saved list to " + JSON_STORE);
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("Unable to write to file: " + JSON_STORE);
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


    // MODIFIES: cmpList
    // EFFECTS: run comparison feature and allow user to add players by name from the master player list
    private CompareList openCompPage() {
        String plr;

        cmpList = new CompareList();

        System.out.println("add players to the comparison list!");


        System.out.println("Select from:");
        System.out.println("\tload -> load your previous list");
        System.out.println("\tnew -> start a new list");
        System.out.println("\tback -> return back to main menu");

        String command = input.next();

        if (command.equals("load")) {
            loadtool();
        } else if (command.equals("new")) {
            newListTool();
        } else {
            init();
        }
//
//
//
//        loadtool();
//
//        System.out.println("enter a player's name to add them to the list (capitalize as with regular names)");
//        plr = input.next();
//
//
//
//        for (Player player : plrList.getPlayerList()) {
//            if (player.getName().equals(plr)) {
//                cmpList.addPlayer(player);
//            }
//        }
//
////        System.out.println("would you like to add another player? (y/n)");
////        String answr;
////
////        answr = input.next();
//
//        String plr2;
//
//        System.out.println("\nenter a second player's name to add them to the list
//        (capitalize as w regular names)\n");

//        plr2 = input.next();
//
//        for (Player player : plrList.getPlayerList()) {
//            if (player.getName().equals(plr2)) {
//                cmpList.addPlayer(player);
//            }
//        }
//
//
//        displayPlayerList(cmpList.getCompareList());

        closeFunction();

        return cmpList;

    }

    private void newListTool() {
        String plr;
        System.out.println("enter a player's name to add them to the list (capitalize as with regular names)");
        plr = input.next();



        for (Player player : plrList.getPlayerList()) {
            if (player.getName().equals(plr)) {
                cmpList.addPlayer(player);
            }
        }

        String plr2;

        System.out.println("\nenter a second player's name to add them to the list (capitalize as w regular names)\n");
        plr2 = input.next();

        for (Player player : plrList.getPlayerList()) {
            if (player.getName().equals(plr2)) {
                cmpList.addPlayer(player);
            }
        }


        displayPlayerList(cmpList.getCompareList());

    }

    // EFFECTS: loads prompts and runs methods for loading previous saves if needed
    private void loadtool() {

        loadCompareList();
        System.out.println("\n");
        displayPlayerList(cmpList.getCompareList());
        System.out.println("your previous list is loaded!\n");
//        System.out.println("\nenter any key to return to main menu\n");
//        input.next();
//        init();

    }

    // EFFECTS: prompts and processes answers to end the compList function page
    private void closeFunction() {
        String backOrSave;

        System.out.println("- enter 'back' to return to main menu");
        System.out.println("- enter 'save' to save the current compareList\n");
        backOrSave = input.next();
        if (backOrSave.equals("back")) {
            init();
        } else if (backOrSave.equals("save")) {
            saveCompareList();
            System.out.println("\n");
            init();
        }

    }

    // MODIFIES: cmpList
    // EFFECTS: process yes/no response to adding another player from user during openCompPage method
    private boolean yesNoAddPlayer(String answr) {
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

    // EFFECTS: saves the comparelist to file
    private void saveCompareList() {
        try {
            jsonWriter.open();
            jsonWriter.write(cmpList);
            jsonWriter.close();
            System.out.println("Saved list to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads comparelist from file
    private void loadCompareList() {
        try {
            cmpList = jsonReader.read();
            System.out.println("Loaded list from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
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

    // EFFECTS: displays every player within a given player list
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


        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        plrList = new PlayerList();
        plrList.getPlayerList().add(player1);
        plrList.getPlayerList().add(player2);
        plrList.getPlayerList().add(player3);
        plrList.getPlayerList().add(player4);
        plrList.getPlayerList().add(player5);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    public class SplashScreen extends JWindow {
        private static final long serialVersionUID = 1L;
        private JPanel contentPane;

        public SplashScreen(JFrame frame, String msg) {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 100, 100);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(new BorderLayout(0, 0));
            setContentPane(contentPane);
        }
    }

}
