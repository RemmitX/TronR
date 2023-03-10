package main.java;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TronWindow extends JFrame implements KeyListener {

    int gameWindowWidth = 1000;
    int gameWindowHeigth = 1000;
    public static int cellSize = 10;
    int borderSize = 1;
    TronGameCanvas gameCanvas;
    ArrayList<ArrayList<Integer>> tronMap = new ArrayList<ArrayList<Integer>>();
    boolean started = false;

    //------------------------------------------------------------------------------------------------------------------

    int hx = 250;
    int hy = 250;
    static int time = 0;
    int sx[] = new int[1000];
    int sy[] = new int[1000];
    

    /*
        This is the TronGame "constructor" function.
        It is responsible for initializing the TronGame object when is getting created in your "main" function.
    */
    public TronWindow() {
        this.gameCanvas = new TronGameCanvas();
    }

    public void createWindow() {
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        setSize(600, 600);
        setVisible(true);
        setLayout(null);
        add(this.gameCanvas);
        gameCanvas.loop();
        System.out.println("tt");
    }


    /* --------------------------------
            Handling User Input
    -------------------------------- */
    public void keyPressed(KeyEvent e)  {
        Set<Integer> playerOneKeys = Stream.of(KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_LEFT, KeyEvent.VK_DOWN).collect(Collectors.toCollection(HashSet::new));
        Set<Integer> playerTwoKeys = Stream.of(KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D).collect(Collectors.toCollection(HashSet::new));
        Map<Integer, Direction> keyToDirectionMap = Stream.of(
        new AbstractMap.SimpleEntry<>(KeyEvent.VK_W, Direction.UP), 
        new AbstractMap.SimpleEntry<>(KeyEvent.VK_A, Direction.LEFT),
        new AbstractMap.SimpleEntry<>(KeyEvent.VK_S, Direction.DOWN),
        new AbstractMap.SimpleEntry<>(KeyEvent.VK_D, Direction.RIGHT),
        new AbstractMap.SimpleEntry<>(KeyEvent.VK_UP, Direction.UP),
        new AbstractMap.SimpleEntry<>(KeyEvent.VK_DOWN, Direction.DOWN),
        new AbstractMap.SimpleEntry<>(KeyEvent.VK_LEFT, Direction.LEFT),
        new AbstractMap.SimpleEntry<>(KeyEvent.VK_RIGHT, Direction.RIGHT)
        )
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if(playerOneKeys.contains(e.getKeyCode())) {
            System.out.println("arrows");
            this.gameCanvas.game.updatePlayerDirection(1, keyToDirectionMap.get(e.getKeyCode()));
        } else if(playerTwoKeys.contains(e.getKeyCode())) {
            this.gameCanvas.game.updatePlayerDirection(2, keyToDirectionMap.get(e.getKeyCode()));
        } else {
            // do nothing, an invalid key was presseed
        }
    }

    public void keyTyped(KeyEvent e)  {

    }

    public void keyReleased(KeyEvent e)  {

    }

    public static int retCellSize() {
        return cellSize;
    }

}