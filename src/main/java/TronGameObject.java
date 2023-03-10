package main.java;

import java.awt.Color;
import java.awt.Graphics;

public class TronGameObject {

    public Coordinate location;
    private Color objectColor;
    public Coordinate loc2 = new Coordinate(10, 10);

    public TronGameObject(Integer x, Integer y, Color c) {
        this.location = new Coordinate(x,y);
        this.objectColor = c;
    }

    public Coordinate getLocation() {
        return this.location;
    }

    public void updateLocation(int x, int y) {
        this.location.setX(x);
        this.location.setY(y);
    }

    public void updateLoc2(int x, int y) {
        this.loc2.setX(x);
        this.loc2.setY(y);
    }

    public Coordinate getLoc2() {
        return this.loc2;
    }

    public void drawObject(Graphics g) {
        g.setColor(this.objectColor);
        g.fillRect(this.location.getX(), this.location.getY(), loc2.getX().intValue(), loc2.getY().intValue());
    }

    public void drawTailSeg(Graphics g, int x1, int y1, int x2, int y2) {
        g.setColor(this.objectColor);
        g.fillRect(x1, y1, x2, y2);
    }

    public void setColor(Color col) {
        this.objectColor = col;
    }

}