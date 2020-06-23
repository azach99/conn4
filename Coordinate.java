package game;

public class Coordinate {
    private int x;
    private int y;
    
    public Coordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
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
            Coordinate other = (Coordinate) obj;
            return (getX() == other.getX() && getY() == other.getY());
        }
        else
        {
            return false;
        }
    }
    public String toString()
    {
        return "X: " + getX() + " Y: " + getY();
    }
}
