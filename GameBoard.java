package game;

import java.awt.Color;
import java.lang.Iterable;

public class GameBoard {
    private SinglyLinkedList mainList;
    private SinglyLinkedList list0;
    private SinglyLinkedList list1;
    private SinglyLinkedList list2;
    private SinglyLinkedList list3;
    private SinglyLinkedList list4;
    private SinglyLinkedList list5;
    private SinglyLinkedList list6;
    private SinglyLinkedList coinList;
    private boolean one;
    private boolean two;
    private boolean win;
    
    public GameBoard()
    {
        mainList = new SinglyLinkedList();
        list0 = new SinglyLinkedList();
        list1 = new SinglyLinkedList();
        list2 = new SinglyLinkedList();
        list3 = new SinglyLinkedList();
        list4 = new SinglyLinkedList();
        list5 = new SinglyLinkedList();
        list6 = new SinglyLinkedList();
        coinList = new SinglyLinkedList();
        mainList.add(list0);
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        mainList.add(list4);
        mainList.add(list5);
        mainList.add(list6);
        one = true;
        two = false;
        win = false;
    }
    public SinglyLinkedList getCoinList()
    {
        return coinList;
    }
    public SinglyLinkedList getMainList()
    {
        return mainList;
    }
    public SinglyLinkedList getList0()
    {
        return list0;
    }
    public SinglyLinkedList getList1()
    {
        return list1;
    }
    public SinglyLinkedList getList2()
    {
        return list2;
    }
    public SinglyLinkedList getList3()
    {
        return list3;
    }
    public SinglyLinkedList getList4()
    {
        return list4;
    }
    public SinglyLinkedList getList5()
    {
        return list5;
    }
    public SinglyLinkedList getList6()
    {
        return list6;
    }
    public boolean getOne()
    {
        return one;
    }
    public boolean getTwo()
    {
        return two;
    }
    public void setOne(boolean bool)
    {
        one = bool;
    }
    public void setTwo(boolean bool)
    {
        two = bool;
    }
    public void drop(int row)
    {
        if (one == true)
        {
            if (row == 1)
            {
                Coin coin = new Coin(Color.RED, new Coordinate(0, getList0().size()));
                getList0().add(coin);
                coinList.add(coin);
            }
            else if (row == 2)
            {
                Coin coin = new Coin(Color.RED, new Coordinate(1, getList1().size()));
                getList1().add(coin);
                coinList.add(coin);
            }
            else if (row == 3)
            {
                Coin coin = new Coin(Color.RED, new Coordinate(2, getList2().size()));
                getList2().add(coin);
                coinList.add(coin);
            }
            else if (row == 4)
            {
                Coin coin = new Coin(Color.RED, new Coordinate(3, getList3().size()));
                getList3().add(coin);
                coinList.add(coin);
            }
            else if (row == 5)
            {
                Coin coin = new Coin(Color.RED, new Coordinate(4, getList4().size()));
                getList4().add(coin);
                coinList.add(coin);
            }
            else if (row == 6)
            {
                Coin coin = new Coin(Color.RED, new Coordinate(5, getList5().size()));
                getList5().add(coin);
                coinList.add(coin);
            }
            else if (row == 7)
            {
                Coin coin = new Coin(Color.RED, new Coordinate(6, getList6().size()));
                getList6().add(coin);
                coinList.add(coin);

            }
        }
        if (two == true)
        {
            if (row == 1)
            {
                Coin coin = new Coin(Color.YELLOW, new Coordinate(0, getList0().size()));
                getList0().add(coin);
                coinList.add(coin);
            }
            else if (row == 2)
            {
                Coin coin = new Coin(Color.YELLOW, new Coordinate(1, getList1().size()));
                getList1().add(coin);
                coinList.add(coin);
            }
            else if (row == 3)
            {
                Coin coin = new Coin(Color.YELLOW, new Coordinate(2, getList2().size()));
                getList2().add(coin);
                coinList.add(coin);
            }
            else if (row == 4)
            {
                Coin coin = new Coin(Color.YELLOW, new Coordinate(3, getList3().size()));
                getList3().add(coin);
                coinList.add(coin);
            }
            else if (row == 5)
            {
                Coin coin = new Coin(Color.YELLOW, new Coordinate(4, getList4().size()));
                getList4().add(coin);
                coinList.add(coin);
            }
            else if (row == 6)
            {
                Coin coin = new Coin(Color.YELLOW, new Coordinate(5, getList5().size()));
                getList5().add(coin);
                coinList.add(coin);
            }
            else if (row == 7)
            {
                Coin coin = new Coin(Color.YELLOW, new Coordinate(6, getList6().size()));
                getList6().add(coin);
                coinList.add(coin);
            }
        }
        boolean og = one;
        one = two;
        two = og;
    }
    public boolean horizontal()
    {
        for (Object coin1: getCoinList().toArray())
        {
            for (Object coin2: getCoinList().toArray())
            {
                for (Object coin3: getCoinList().toArray())
                {
                    for (Object coin4: getCoinList().toArray())
                    {
                        if ((((Coin)coin1).getColor().equals(((Coin)coin2).getColor())) &&
                            (((Coin)coin2).getColor().equals(((Coin)coin3).getColor())) &&
                            (((Coin)coin3).getColor().equals(((Coin)coin4).getColor())) &&
                            (((Coin)coin1).getCoordinate().getY() == (((Coin)coin2).getCoordinate().getY())) && 
                            (((Coin)coin2).getCoordinate().getY() == (((Coin)coin3).getCoordinate().getY())) &&
                            (((Coin)coin3).getCoordinate().getY() == (((Coin)coin4).getCoordinate().getY())) &&
                            (((Coin)coin1).getCoordinate().getX() == (((Coin)coin2).getCoordinate().getX() - 1)) &&
                            (((Coin)coin1).getCoordinate().getX() == (((Coin)coin3).getCoordinate().getX() - 2)) &&
                            (((Coin)coin1).getCoordinate().getX() == (((Coin)coin4).getCoordinate().getX() - 3)))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean vertical()
    {
        for (Object coin1: getCoinList().toArray())
        {
            for (Object coin2: getCoinList().toArray())
            {
                for (Object coin3: getCoinList().toArray())
                {
                    for (Object coin4: getCoinList().toArray())
                    {
                        if ((((Coin)coin1).getColor().equals(((Coin)coin2).getColor())) &&
                            (((Coin)coin2).getColor().equals(((Coin)coin3).getColor())) &&
                            (((Coin)coin3).getColor().equals(((Coin)coin4).getColor())) &&
                            (((Coin)coin1).getCoordinate().getX() == (((Coin)coin2).getCoordinate().getX())) && 
                            (((Coin)coin2).getCoordinate().getX() == (((Coin)coin3).getCoordinate().getX())) &&
                            (((Coin)coin3).getCoordinate().getX() == (((Coin)coin4).getCoordinate().getX())) &&
                            (((Coin)coin1).getCoordinate().getY() == (((Coin)coin2).getCoordinate().getY() - 1)) &&
                            (((Coin)coin1).getCoordinate().getY() == (((Coin)coin3).getCoordinate().getY() - 2)) &&
                            (((Coin)coin1).getCoordinate().getY() == (((Coin)coin4).getCoordinate().getY() - 3)))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean upwardsRightDiagonal()
    {
        for (Object coin1: getCoinList().toArray())
        {
            for (Object coin2: getCoinList().toArray())
            {
                for (Object coin3: getCoinList().toArray())
                {
                    for (Object coin4: getCoinList().toArray())
                    {
                        if ((((Coin)coin1).getColor().equals(((Coin)coin2).getColor())) &&
                            (((Coin)coin2).getColor().equals(((Coin)coin3).getColor())) &&
                            (((Coin)coin3).getColor().equals(((Coin)coin4).getColor())) &&
                            (((Coin)coin1).getCoordinate().getX() == (((Coin)coin2).getCoordinate().getX() - 1)) && 
                            (((Coin)coin1).getCoordinate().getX() == (((Coin)coin3).getCoordinate().getX() - 2)) &&
                            (((Coin)coin1).getCoordinate().getX() == (((Coin)coin4).getCoordinate().getX() - 3)) &&
                            (((Coin)coin1).getCoordinate().getY() == (((Coin)coin2).getCoordinate().getY() - 1)) &&
                            (((Coin)coin1).getCoordinate().getY() == (((Coin)coin3).getCoordinate().getY() - 2)) &&
                            (((Coin)coin1).getCoordinate().getY() == (((Coin)coin4).getCoordinate().getY() - 3)))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean downwardsRightDiagonal()
    {
        for (Object coin1: getCoinList().toArray())
        {
            for (Object coin2: getCoinList().toArray())
            {
                for (Object coin3: getCoinList().toArray())
                {
                    for (Object coin4: getCoinList().toArray())
                    {
                        if ((((Coin)coin1).getColor().equals(((Coin)coin2).getColor())) &&
                            (((Coin)coin2).getColor().equals(((Coin)coin3).getColor())) &&
                            (((Coin)coin3).getColor().equals(((Coin)coin4).getColor())) &&
                            (((Coin)coin1).getCoordinate().getX() == (((Coin)coin2).getCoordinate().getX() - 1)) && 
                            (((Coin)coin1).getCoordinate().getX() == (((Coin)coin3).getCoordinate().getX() - 2)) &&
                            (((Coin)coin1).getCoordinate().getX() == (((Coin)coin4).getCoordinate().getX() - 3)) &&
                            (((Coin)coin1).getCoordinate().getY() == (((Coin)coin2).getCoordinate().getY() + 1)) &&
                            (((Coin)coin1).getCoordinate().getY() == (((Coin)coin3).getCoordinate().getY() + 2)) &&
                            (((Coin)coin1).getCoordinate().getY() == (((Coin)coin4).getCoordinate().getY() + 3)))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean win()
    {
        return horizontal() || vertical() || upwardsRightDiagonal() || downwardsRightDiagonal();
    }
}
