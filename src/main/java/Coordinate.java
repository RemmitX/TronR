package main.java;

public class Coordinate {

    private Integer _x;
    private Integer _y;

    public Coordinate(Integer x, Integer y) {
        this._x = x;
        this._y = y;
    }
    
    public Integer getX() {
        return _x;
    }

    public void setX(int x) {
        this._x = x;
    }

    public Integer getY() {
        return _y;
    }

    public void setY(int y) {
        this._y = y;
    }
}