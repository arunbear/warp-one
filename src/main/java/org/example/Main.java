package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Main extends JFrame {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new Main();
            ex.setVisible(true);
        });
    }

    public Main() {

        initUI();
    }

    private void initUI() {

        createMenuBar();

        setTitle("Warp One");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {

        var menuBar = new JMenuBar();

        JMenu fileMenu = createFileMenu();
        menuBar.add(fileMenu);

        var viewMenu = createViewMenu();
        menuBar.add(viewMenu);

        var turnMenu = createTurnMenu();
        menuBar.add(turnMenu);

        var commandsMenu = createCommandsMenu();
        menuBar.add(commandsMenu);

        var reportMenu = createReportMenu();
        menuBar.add(reportMenu);

        var helpMenu = createHelpMenu();

        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    private JMenu createFileMenu() {

        var menu = new JMenu("File");

        var newMenuItem = new JMenuItem("New...");
        menu.add(newMenuItem);
        menu.add(new JMenuItem("Custom Race Wizard..."));

        var openMenuItem = new JMenuItem("Open...");
        menu.add(openMenuItem);

        menu.add(new JMenuItem("Close"));
        var saveMenuItem = new JMenuItem("Save");
        menu.add(saveMenuItem);
        menu.add(new JMenuItem("Save And Submit"));
        menu.addSeparator();

        menu.add(new JMenuItem("Print Map"));

        var exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setToolTipText("Exit application");
        exitMenuItem.addActionListener((event) -> System.exit(0));

        menu.addSeparator();
        menu.add(exitMenuItem);
        return menu;
    }

    private JMenu createViewMenu() {
        var menu = new JMenu("View");

        var showToolBarMenuItem = new JCheckBoxMenuItem("Toolbar");
        showToolBarMenuItem.setMnemonic(KeyEvent.VK_S);
        showToolBarMenuItem.setDisplayedMnemonicIndex(5);
        showToolBarMenuItem.setSelected(true);

        menu.add(showToolBarMenuItem);
        menu.addSeparator();

        var findMenuItem = new JMenuItem("Find...");
        menu.add(findMenuItem);

        var zoomMenu = new JMenu("Zoom");
        var zoomGroup = new ButtonGroup();
        var zoomOptions = List.of(
                new JRadioButtonMenuItem("25%"),
                new JRadioButtonMenuItem("38%"),
                new JRadioButtonMenuItem("50%"),
                new JRadioButtonMenuItem("75%"),
                new JRadioButtonMenuItem("100%"),
                new JRadioButtonMenuItem("125%"),
                new JRadioButtonMenuItem("150%"),
                new JRadioButtonMenuItem("200%"),
                new JRadioButtonMenuItem("400%")
        );
        zoomOptions.forEach((item) -> {
            zoomGroup.add(item);
            zoomMenu.add(item);
        });
        menu.add(zoomMenu);

        JMenu windowLayoutMenu = new JMenu("Window Layout");
        ButtonGroup windowLayoutGroup = new ButtonGroup();
        var windowLayoutOptions = List.of(
                new JRadioButtonMenuItem("Large Screen"),
                new JRadioButtonMenuItem("Medium Screen"),
                new JRadioButtonMenuItem("Small Screen")
        );
        windowLayoutOptions.forEach((item) -> {
            windowLayoutMenu.add(item);
            windowLayoutGroup.add(item);
        });
        menu.add(windowLayoutMenu);

        var showPlayerColoursMenuItem = new JCheckBoxMenuItem("Player Colours");
        showPlayerColoursMenuItem.setMnemonic(KeyEvent.VK_S);
        showPlayerColoursMenuItem.setDisplayedMnemonicIndex(7);
        showPlayerColoursMenuItem.setSelected(true);

        menu.add(showPlayerColoursMenuItem);
        menu.addSeparator();

        var raceMenuItem = new JMenuItem("Race...");
        menu.add(raceMenuItem);

        var gameParametersMenuItem = new JMenuItem("Game Parameters...");
        menu.add(gameParametersMenuItem);

        return menu;
    }

    private JMenu createTurnMenu() {
        var menu = new JMenu("Turn");

        var waitMenuItem = new JMenuItem("Wait For New");
        menu.add(waitMenuItem);

        var generateMenuItem = new JMenuItem("Generate");
        menu.add(generateMenuItem);
        return menu;
    }

    private JMenu createCommandsMenu() {
        JMenu menu = new JMenu("Commands");

        menu.add(new JMenuItem("Ship Design..."));
        menu.add(new JMenuItem("Research..."));
        menu.add(new JMenuItem("Battle Plans..."));
        menu.add(new JMenuItem("Player Relations..."));
        menu.addSeparator();

        menu.add(new JMenuItem("Change Password..."));
        return menu;
    }

    private JMenu createReportMenu() {
        JMenu menu = new JMenu("Report");

        menu.add(new JMenuItem("Planets..."));
        menu.add(new JMenuItem("Fleets..."));
        menu.add(new JMenuItem("Enemy Fleets..."));
        menu.addSeparator();

        menu.add(new JMenuItem("Battles..."));
        menu.addSeparator();

        menu.add(new JMenuItem("Score..."));
        menu.addSeparator();

        JMenu dumpMenu = new JMenu("Dump To Text File");
        dumpMenu.add(new JMenuItem("Universe Definition"));
        dumpMenu.add(new JMenuItem("Planet Information"));
        dumpMenu.add(new JMenuItem("Fleet Information"));
        menu.add(dumpMenu);

        return menu;
    }

    private JMenu createHelpMenu() {
        JMenu menu = new JMenu("Help");

        menu.add(new JMenuItem("Introduction"));
        menu.add(new JMenuItem("Player's Guide"));
        menu.addSeparator();

        menu.add(new JMenuItem("Technology Browser"));
        menu.add(new JMenuItem("Tutorial"));
        menu.addSeparator();

        menu.add(new JMenuItem("About..."));

        return menu;
    }
}