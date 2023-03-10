package main.java;

import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class TronGameCanvas extends Canvas {

        //TODO: Store and Update all of the game state in here

        public TronGame game = new TronGame();

        private Color backgroundColor;

        public TronGameCanvas() {
            setBackground (Color.BLACK);    
            setSize(500, 500);  
            setFocusable(false);
        }

        public void paint(Graphics graphics) {
            

            // Draw the inside of the game border
            graphics.setColor(Color.DARK_GRAY);
            graphics.fillRect(10, 10, 480, 480);

            game.drawGame(graphics);



            /*
                // Draw all Players (Head and Tail)
                ArrayList<TronGameObject> players = new ArrayList<>();
                players.add(new TronGameObject(bike1.head.location.getX(), bike1.head.location.getY()));

                int cellSizeNew = TronWindow.retCellSize();
                int bike1headx = bike1.head.location.getX();
                int bike1heady = bike1.head.location.getY();

                System.out.println("retintdirection is " + TronWindow.retIntDirection());
                bike1.updateDirection(TronWindow.retIntDirection());
                System.out.println("the direction in use is: " + bike1.currDirection);

                if (bike1.currDirection==TronBike.Direction.UP) {
                    bike1.head.updateLocation(bike1headx, bike1heady-cellSizeNew);
                } 
                else if (bike1.currDirection==TronBike.Direction.RIGHT) {
                    bike1.head.updateLocation(bike1headx+cellSizeNew, bike1heady);
                } 
                else if (bike1.currDirection==TronBike.Direction.DOWN) {
                    bike1.head.updateLocation(bike1headx, bike1heady+cellSizeNew);
                } 
                else if (bike1.currDirection==TronBike.Direction.LEFT) {
                    bike1.head.updateLocation(bike1headx-cellSizeNew, bike1heady);
                }

                for (TronGameObject player: players) {
                    player.drawObject(graphics);
                }
            */
            

            
            // TODO: replace the below with drawing game objects
            //

        }

        public void loop() {
            for (;true;) {
                repaint();
                try {
                    Thread.sleep(50);
                } catch(InterruptedException e) {
    
                }
            }
        }




    }