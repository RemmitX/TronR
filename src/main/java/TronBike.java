package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Graphics;
import java.awt.Color;

public class TronBike {
    
    Direction currDirection;
    TronGameObject head;
    List<Coordinate> tail;
    List<TronGameObject> segments;
    boolean _isAIPlayer = false;
    Color bikeColor;
    char linev = 'z';
    Coordinate prevHeadLoc = new Coordinate(100, 100);
    Coordinate currHeadLoc = new Coordinate(100, 100);

    public TronBike(boolean isAIPlayer, Integer startLocX, Integer startLocY, Color c) {
        this.head = new TronGameObject(startLocX, startLocY, c);
        this.tail = new ArrayList<>();
        this.segments = new ArrayList<>();
        this._isAIPlayer = isAIPlayer;
        this.currDirection = Direction.RIGHT;
        this.bikeColor = c;
    }
    
    private int getRandomValue(int min, int max) {
        return ThreadLocalRandom
            .current()
            .nextInt(min, max + 1);
    }

    private Direction generateRandomDirection() {
        int randomNum = getRandomValue(1, 4);
        switch(randomNum) {
            case 1:
                return Direction.UP;
            case 2:
                return Direction.DOWN;
            case 3:
                return Direction.LEFT;
            case 4:
                return Direction.RIGHT;
            default:
                return Direction.UP;
        }
    }

    public void updateDirection (Direction dir) {
        this.currDirection = dir;
    }

    public void advanceBike() {

        prevHeadLoc = new Coordinate(this.head.getLocation().getX(), this.head.getLocation().getY());

        switch(this.currDirection) {
            case UP:
                this.head.updateLocation(currHeadLoc.getX(), currHeadLoc.getY() - 10);
                break;
            case DOWN:
                this.head.updateLocation(currHeadLoc.getX(), currHeadLoc.getY() + 10);
                break;
            case LEFT:
                this.head.updateLocation(currHeadLoc.getX() - 10, currHeadLoc.getY());
                break;
            case RIGHT:
                this.head.updateLocation(currHeadLoc.getX() + 10, currHeadLoc.getY());
                break;
            default:
                break;
        }



        if (currHeadLoc.getX().equals(prevHeadLoc.getX()) && currHeadLoc.getY().equals(prevHeadLoc.getY())) {
            tail.add(new Coordinate(currHeadLoc.getX(), currHeadLoc.getY()));
            linev = 'z';
        } else if (!currHeadLoc.getX().equals(prevHeadLoc.getX())) {
            if (linev=='y' || linev=='z') {
                tail.add(new Coordinate(currHeadLoc.getX(), currHeadLoc.getY()));
            } else {
                tail.set(tail.size()-1, new Coordinate(currHeadLoc.getX(), currHeadLoc.getY()));
            }
            linev = 'x';
        } else if (!currHeadLoc.getY().equals(prevHeadLoc.getY())) {
            if (linev=='x' || linev=='z') {
                tail.add(new Coordinate(currHeadLoc.getX(), currHeadLoc.getY()));
            } else {
                tail.set(tail.size()-1, new Coordinate(currHeadLoc.getX(), currHeadLoc.getY()));
            }
            linev = 'y';
        }

        currHeadLoc = this.head.getLocation();

    }

    public void drawBike(Graphics g) {
        this.advanceBike();

        for (Integer x=0;!x.equals(tail.size());x++) {
        }

        segments.removeAll(segments);
        for (Integer x = 0;!x.equals(tail.size()-1); x++) {
            
            segments.add(new TronGameObject(tail.get(x).getX(), tail.get(x).getY(), Color.CYAN));
            
        }

        for (TronGameObject bit: segments) {

            if (segments.indexOf(bit)!=segments.size() && tail.size()!=segments.indexOf(bit)+1) {

                bit.updateLoc2(tail.get(segments.indexOf(bit)+1).getX().intValue(), tail.get(segments.indexOf(bit)+1).getY().intValue());

                if (bit.location.getX().equals(bit.loc2.getX())) {
                    if (bit.location.getY()<bit.loc2.getY()) {
                        bit.drawTailSeg(g, bit.location.getX(), bit.location.getY(), 10, bit.loc2.getY()-bit.location.getY());
                    } else {
                        bit.drawTailSeg(g, bit.loc2.getX(), bit.loc2.getY(), 10, bit.location.getY()-bit.loc2.getY()+10);
                    }
                } else {
                    if (bit.location.getX()<bit.loc2.getX()) {
                        bit.drawTailSeg(g, bit.location.getX(), bit.location.getY(), bit.loc2.getX()-bit.location.getX(), 10);
                    } else {
                        bit.drawTailSeg(g, bit.loc2.getX(), bit.loc2.getY(), bit.location.getX()-bit.loc2.getX()+10, 10);
                    }
                }

            } else {

            }

            //Draw the head
            head.drawObject(g);

            
        }

        

    }



        


        
}