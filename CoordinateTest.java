package game;
import student.TestCase;
public class CoordinateTest extends TestCase {
    private Coordinate coordinate;
    
    public void setUp()
    {
        coordinate = new Coordinate(3, 4);
    }
    public void testGetX()
    {
        assertEquals(3, coordinate.getX());
    }
    public void testGetY()
    {
        assertEquals(4, coordinate.getY());
    }
    public void testSetX()
    {
        coordinate.setX(1);
        assertEquals(1, coordinate.getX());
    }
    public void testSetY()
    {
        coordinate.setY(2);
        assertEquals(2, coordinate.getY());
    }
    public void testEqualsSelf()
    {
        assertTrue(coordinate.equals(coordinate));
    }
    public void testEqualsNull()
    {
        Coordinate nothing = null;
        assertFalse(coordinate.equals(nothing));
    }
    public void testEqualsDifferentClass()
    {
        assertFalse(coordinate.equals(21));
    }
    public void testEqualsSame()
    {
        Coordinate other = new Coordinate(3, 4);
        assertTrue(coordinate.equals(other));
    }
    public void testEqualsNot()
    {
        Coordinate other2 = new Coordinate(1, 1);
        assertFalse(coordinate.equals(other2));
    }
    public void testEqualsX()
    {
        Coordinate sameX = new Coordinate(3, 1);
        assertFalse(coordinate.equals(sameX));
    }
    public void testEqualsY()
    {
        Coordinate sameY = new Coordinate(1, 4);
        assertFalse(coordinate.equals(sameY));
    }
    public void testToString()
    {
        String out = "X: 3 Y: 4";
        assertEquals(out, coordinate.toString());
    }
    

}
