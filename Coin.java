package game;

import java.awt.Color;

public class Coin {
    private Color color;
    private Coordinate coordinate;
    
    public Coin(Color color, Coordinate coordinate)
    {
        this.color = color;
        this.coordinate = coordinate;
    }
    public Color getColor()
    {
        return this.color;
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    public Coordinate getCoordinate()
    {
        return this.coordinate;
    }
    public void setCoordinate(Coordinate coordinate)
    {
        this.coordinate = coordinate;
    }
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() == obj.getClass())
        {
            Coin other = (Coin) obj;
            return (getColor() == other.getColor() && (this.getCoordinate().equals(other.getCoordinate())));
        }
        else
        {
            return false;
        }
    }
}
