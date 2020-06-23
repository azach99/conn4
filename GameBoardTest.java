package game;
import java.awt.Color;
import student.TestCase;

public class GameBoardTest extends TestCase {
    private GameBoard board;
    
    public void setUp()
    {
        board = new GameBoard();
    }
    public void testGetOne()
    {
        assertTrue(board.getOne());
    }
    public void testGetTwo()
    {
        assertFalse(board.getTwo());
    }
    public void testSetOne()
    {
        board.setOne(false);
        assertFalse(board.getOne());
    }
    public void testSetTwo()
    {
        board.setTwo(true);
        assertTrue(board.getTwo());
    }
    public void testDrop()
    {
        board.drop(1);
        assertEquals(1, board.getList0().size());
        assertEquals(1, board.getCoinList().size());
        Coordinate coordinate = new Coordinate(0, 0);
        Coin coin = new Coin(Color.RED, coordinate);
        assertEquals(Color.RED, ((Coin)board.getList0().get(0)).getColor());
        assertEquals(coordinate, ((Coin)board.getList0().get(0)).getCoordinate());
    }
    public void testHorizontal()
    {
        board.drop(1);
        board.drop(1);
        board.drop(2);
        board.drop(2);
        board.drop(3);
        board.drop(3);
        board.drop(4);
        assertTrue(board.horizontal());
        assertTrue(board.win());
    }
    public void testVertical()
    {
        board.drop(1);
        board.drop(2);
        board.drop(3);
        board.drop(2);
        board.drop(3);
        board.drop(2);
        board.drop(3);
        board.drop(2);
        assertTrue(board.vertical());
        assertTrue(board.win());
    }
    public void testNotHorizontal()
    {
        board.drop(4);
        assertFalse(board.horizontal());
        assertFalse(board.win());
    }
    public void testNotVerical()
    {
        board.drop(6);
        assertFalse(board.vertical());
        assertFalse(board.win());
    }
    public void testUpwardsRightDiagonal()
    {
        board.drop(2); //Red
        board.drop(3); //Yellow
        board.drop(3); //Red
        board.drop(4); //Yellow
        board.drop(5); //Red
        board.drop(4); //Yellow
        board.drop(4); //Red
        board.drop(5); //Yellow
        board.drop(5); //Red
        board.drop(6); //Yellow
        assertFalse(board.upwardsRightDiagonal());
        assertFalse(board.win());
        board.drop(5); //Red
        assertTrue(board.upwardsRightDiagonal()); 
        assertTrue(board.win());
    }
    public void testDownwardsRightDiagonal()
    {
        board.drop(1); //red
        board.drop(1); //yellow
        board.drop(1); //red
        board.drop(1); //yellow
        board.drop(3); //red
        board.drop(3); //yellow
        board.drop(2); //red
        board.drop(4); //yellow
        board.drop(2); //red
        assertFalse(board.downwardsRightDiagonal());
        assertFalse(board.win());
        board.drop(2); //yellow
        assertTrue(board.downwardsRightDiagonal());
        assertTrue(board.win());
    }
}
