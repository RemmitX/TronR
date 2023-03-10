package main.java;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class TronGame {

    /*
        A new TronGame object is created whenever a new game is started
        Stores/Manages all of the game state and game objects
    */
    List<TronBike> players = new ArrayList<>();
    ArrayList<ArrayList<Integer>> tronMap = new ArrayList<ArrayList<Integer>>();



    /*
        This is the TronGame "constructor" function.
        It is responsible for initializing the TronGame object when is getting created in your "main" function.
    */
    
    public TronGame() {
        players.add(new TronBike(false, 100, 100, Color.blue));
    }

    public void drawGame(Graphics g) {
        for (TronBike bike: players) {
            bike.drawBike(g);
        }
    }

    public void updatePlayerDirection(int playerNum, Direction dir) {
        if(playerNum <= players.size()) {
            players.get(playerNum - 1).updateDirection(dir);
        }
    }
}
