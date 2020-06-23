package game;
import java.awt.Color;
import student.TestCase;

public class CoinTest extends TestCase {
    private Coin coin;
    
    public void setUp()
    {
        coin = new Coin(Color.RED, new Coordinate(3, 3));
    }
    public void testGetColor()
    {
        assertEquals(new Color(255, 0, 0), coin.getColor());
    }
    public void testGetCoordinate()
    {
        assertEquals(new Coordinate(3, 3), coin.getCoordinate());
    }
    public void testSetColor()
    {
        coin.setColor(Color.BLUE);
        assertEquals(Color.BLUE, coin.getColor());
    }
    public void testSetCoordinate()
    {
        coin.setCoordinate(new Coordinate(1, 1));
        assertEquals(new Coordinate(1, 1), coin.getCoordinate());
    }
    public void testEqualsSame()
    {
        assertTrue(coin.equals(coin));
    }
    public void testEqualsNull()
    {
        Coin nothing = null;
        assertFalse(coin.equals(nothing));
    }
    public void testEqualsDiffClass()
    {
        assertFalse(coin.equals(22));
    }
    public void testEqualsTrue()
    {
        Coin coin2 = new Coin(Color.RED, new Coordinate(3, 3));
        assertTrue(coin2.equals(coin));
    }

}
