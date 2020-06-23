package game;

import java.awt.Color;
import java.util.Iterator;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

public class GameWindow {
    private Window window;
    private Window window2;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button practice;
    private TextShape player1;
    private TextShape player2;
    private TextShape currentTurn;
    private boolean oneTurn;
    private boolean twoTurn;
    private GameBoard board;
    public GameWindow()
    {
        board = new GameBoard();
        oneTurn = true;
        twoTurn = false;
        window = new Window("Connect Four");
        window2 = new Window("Player Status");
        buttonOne = new Button("Row 1");
        buttonTwo = new Button("Row 2");
        buttonThree = new Button("Row 3");
        buttonFour = new Button("Row 4");
        buttonFive = new Button("Row 5");
        buttonSix = new Button("Row 6");
        buttonSeven = new Button("Row 7");
        practice = new Button("Refresh");
        player1 = new TextShape(window2.getGraphPanelWidth() / 4, window2.getGraphPanelWidth() / 4, "Player 1");
        player2 = new TextShape((window2.getGraphPanelWidth() * 3) / 4, (window2.getGraphPanelWidth() * 1) / 4, "Player 2");
        player1.move(-player1.getWidth() / 2, 0);
        player2.move(-player2.getWidth() / 2, 0);
        player1.setBackgroundColor(Color.RED);
        player2.setBackgroundColor(Color.YELLOW);
        practice.onClick(this, "refresh");
        buttonOne.onClick(this, "insertRow1");
        buttonTwo.onClick(this, "insertRow2");
        buttonThree.onClick(this, "insertRow3");
        buttonFour.onClick(this, "insertRow4");
        buttonFive.onClick(this, "insertRow5");
        buttonSix.onClick(this, "insertRow6");
        buttonSeven.onClick(this, "insertRow7");
        window.addButton(buttonOne,  WindowSide.SOUTH);
        window.addButton(buttonTwo,  WindowSide.SOUTH);
        window.addButton(buttonThree,  WindowSide.SOUTH);
        window.addButton(buttonFour,  WindowSide.SOUTH);
        window.addButton(buttonFive,  WindowSide.SOUTH);
        window.addButton(buttonSix,  WindowSide.SOUTH);
        window.addButton(buttonSeven,  WindowSide.SOUTH);
        window.addButton(practice,  WindowSide.NORTH);
        window2.addShape(player1);
        window2.addShape(player2);
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                CircleShape circle = new CircleShape((i * window.getGraphPanelWidth()) / 7, (j * window.getGraphPanelHeight()) / 6, 40, Color.WHITE);
                circle.setForegroundColor(Color.BLACK);
                window.addShape(circle);
                window.moveToFront(circle);
            }
        }
        Iterator iterator = window.getShapesIterator();
        while (iterator.hasNext())
        {
            Shape something = (Shape) iterator.next();
            something.move(window.getGraphPanelHeight() / 12, 0);
        }
        updateTurn();
    }
    public void refresh(Button button)
    {
        window.removeAllShapes();
        window2.removeAllShapes();
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                CircleShape circle = new CircleShape((i * window.getGraphPanelWidth()) / 7, (j * window.getGraphPanelHeight()) / 6, 40, Color.YELLOW);
                circle.setForegroundColor(Color.BLACK);
                window.addShape(circle);
                window.moveToFront(circle);
            }
        }
        Iterator iterator = window.getShapesIterator();
        while (iterator.hasNext())
        {
            Shape something = (Shape) iterator.next();
            something.move(window.getGraphPanelHeight() / 12, 0);
        }
        updateTurn();
    }
    public void insertRow1(Button button)
    {
        updateBooleans();
        board.drop(1);
        Color color;
        if (oneTurn == true)
        {
            color = Color.RED;
        }
        else
        {
            color = Color.YELLOW;
        }

        addCoin(0, 7 - board.getList0().size() - 1, color);
        boolean original = oneTurn;
        oneTurn = twoTurn;
        twoTurn = original;
        updateBooleans();
        updateTurn();
        if (board.getList0().size() == 6)
        {
            button.disable();
        }
        if (board.win())
        {
            button.disable();
        }
    }
    public void insertRow2(Button button)
    {
        updateBooleans();
        board.drop(2);
        Color color;
        if (oneTurn == true)
        {
            color = Color.RED;
        }
        else
        {
            color = Color.YELLOW;
        }
        addCoin(1, 7 - board.getList1().size() - 1, color);
        boolean original = oneTurn;
        oneTurn = twoTurn;
        twoTurn = original;
        updateBooleans();
        updateTurn();
        if (board.getList1().size() == 6)
        {
            button.disable();
        }
        if (board.win())
        {
            button.disable();
        }
    }
    public void insertRow3(Button button)
    {
        updateBooleans();
        board.drop(3);
        Color color;
        if (oneTurn == true)
        {
            color = Color.RED;
        }
        else
        {
            color = Color.YELLOW;
        }
        addCoin(2, 7 - board.getList2().size() - 1, color);
        boolean original = oneTurn;
        oneTurn = twoTurn;
        twoTurn = original;
        updateBooleans();
        updateTurn();
        if (board.getList2().size() == 6)
        {
            button.disable();
        }
        if (board.win())
        {
            button.disable();
        }
    }
    public void insertRow4(Button button)
    {
        updateBooleans();
        board.drop(4);
        Color color;
        if (oneTurn == true)
        {
            color = Color.RED;
        }
        else
        {
            color = Color.YELLOW;
        }
        addCoin(3, 7 - board.getList3().size() - 1, color);
        boolean original = oneTurn;
        oneTurn = twoTurn;
        twoTurn = original;
        updateBooleans();
        updateTurn();
        if (board.getList3().size() == 6)
        {
            button.disable();
        }
        if (board.win())
        {
            button.disable();
        }
    }
    public void insertRow5(Button button)
    {
        updateBooleans();
        board.drop(5);
        Color color;
        if (oneTurn == true)
        {
            color = Color.RED;
        }
        else
        {
            color = Color.YELLOW;
        }
        addCoin(4, 7 - board.getList4().size() - 1, color);
        boolean original = oneTurn;
        oneTurn = twoTurn;
        twoTurn = original;
        updateBooleans();
        updateTurn();
        if (board.getList4().size() == 6)
        {
            button.disable();
        }
        if (board.win())
        {
            button.disable();
        }
    }
    public void insertRow6(Button button)
    {
        updateBooleans();
        board.drop(6);
        Color color;
        if (oneTurn == true)
        {
            color = Color.RED;
        }
        else
        {
            color = Color.YELLOW;
        }
        addCoin(5, 7 - board.getList5().size() - 1, color);
        boolean original = oneTurn;
        oneTurn = twoTurn;
        twoTurn = original;
        updateBooleans();
        updateTurn();
        if (board.getList5().size() == 6)
        {
            button.disable();
        }
        if (board.win())
        {
            button.disable();
        }
    }
    public void insertRow7(Button button)
    {
        updateBooleans();
        board.drop(7);
        Color color;
        if (oneTurn == true)
        {
            color = Color.RED;
        }
        else
        {
            color = Color.YELLOW;
        }
        addCoin(6, 7 - board.getList6().size() - 1, color);
        boolean original = oneTurn;
        oneTurn = twoTurn;
        twoTurn = original;
        updateBooleans();
        updateTurn();
        if (board.getList6().size() == 6)
        {
            button.disable();
        }
        if (board.win())
        {
            button.disable();
        }
    }
    public void updateTurn()
    {
      window2.removeAllShapes();
      player1 = new TextShape(window2.getGraphPanelWidth() / 4, window2.getGraphPanelWidth() / 4, "Player 1");
      player2 = new TextShape((window2.getGraphPanelWidth() * 3) / 4, (window2.getGraphPanelWidth() * 1) / 4, "Player 2");
      player1.move(-player1.getWidth() / 2, 0);
      player2.move(-player2.getWidth() / 2, 0);
      player1.setBackgroundColor(Color.RED);
      player2.setBackgroundColor(Color.YELLOW);
      window2.addShape(player1);
      window2.addShape(player2);
        if (oneTurn == true)
        {
            currentTurn = new TextShape(window2.getGraphPanelWidth() / 2, (3 * window2.getGraphPanelHeight()) / 4, "Current Turn: Player 1");
            currentTurn.move(-currentTurn.getWidth() / 2, 0);
            window2.addShape(currentTurn);
            currentTurn.setBackgroundColor(Color.WHITE);
        }
        if (twoTurn == true)
        {
            currentTurn = new TextShape(window2.getGraphPanelWidth() / 2, (3 * window2.getGraphPanelHeight()) / 4, "Current Turn: Player 2");
            currentTurn.move(-currentTurn.getWidth() / 2, 0);
            window2.addShape(currentTurn);
            currentTurn.setBackgroundColor(Color.WHITE);
        }
        displayWin();
    }
    public void displayWin()
    {
        if (board.win())
        {
            if (oneTurn == true)
            {
                TextShape text = new TextShape(window2.getGraphPanelWidth() / 2, window2.getGraphPanelHeight() / 4, "Winner: Player 2");
                window2.addShape(text);
                text.move(-text.getWidth() / 2, -text.getHeight() / 2);
                text.setBackgroundColor(Color.WHITE);
            }
            else
            {
                TextShape text = new TextShape(window2.getGraphPanelWidth() / 2, window2.getGraphPanelHeight() / 4, "Winner: Player 1");
                window2.addShape(text);
                text.move(-text.getWidth() / 2, -text.getHeight() / 2);
                text.setBackgroundColor(Color.WHITE);
            }
        }
    }
    public void updateBooleans()
    {
        board.setOne(oneTurn);
        board.setTwo(twoTurn);
    }
    public void addCoin(int x, int y, Color color)
    {
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0 ; j < 6; j++)
            {
                if (i == x - 0 && j == y)
                {
                    CircleShape circle = new CircleShape((i * window.getGraphPanelWidth()) / 7, (j * window.getGraphPanelHeight()) / 6, 40, Color.WHITE);
                    circle.setForegroundColor(color);
                    window.addShape(circle);
                    window.moveToFront(circle);
                    circle.move(window.getGraphPanelHeight() / 12, 0);
                }
            }
        }
    }
}
