package eg.edu.alexu.csd.datastructure.iceHockey.cs22;
import java.awt.*;
import java.lang.Math;
import java.util.ArrayList;

interface IPlayersFinder
{
    java.awt.Point[] findPlayers(String[] photo,int team,int threshold);
}

class PlayersFinder implements IPlayersFinder
{
    //Finds players
    public java.awt.Point[] findPlayers(String[] photo, int team, int threshold)
    {
        char teamC = (char) (team + 48);
        char[][] photoArr = stringToArray(photo);
        ArrayList<Point> allTeam = new ArrayList<Point>();

        for (int i = 0; i < photo.length; i++)
        {
            for (int j = 0; j < photo[0].length(); j++)
            {
                if (photoArr[i][j] == teamC)
                {
                    Point temp = new Point(j, i);
                    allTeam.add(temp);
                }
            }
        }

        ArrayList<Point> list = players(allTeam, threshold);
        Point[] temp = list.toArray(new Point[list.size()]);
        return temp;
    }

    public static char[][] stringToArray(String[] str)
    {
        char[][] arr = new char[str.length][str[0].length()];
        for (int i = 0; i < str.length; i++)
        {
            for (int j = 0; j < str[0].length(); j++)
                arr[i][j] = str[i].charAt(j);
        }

        return arr;
    }

    ArrayList<java.awt.Point> players(ArrayList<Point> team, int threshold)
    {
        ArrayList<ArrayList<Point>> players = new ArrayList<ArrayList<Point>>();

        int counter = 0;                           //Indicates which list we are using
        while(team.size() != 0)
        {
            players.add(new ArrayList<Point>());
            players.get(counter).add(team.get(0));
            team.remove(0);

            //Getting adjacent cells
            for (int i = 0; i < team.size(); i++)
            {
                int diffX = (int) Math.abs(players.get(counter).get(0).getX() - team.get(i).getX());
                int diffY = (int) Math.abs(players.get(counter).get(0).getY() - team.get(i).getY());

                if ((diffX == 1 && diffY == 0) || (diffY == 1 && diffX == 0))
                {
                    //Adding player and removing him from the team
                    players.get(counter).add(team.get(i));
                    team.remove(i);
                }
            }

            int size;
            do{
                size = players.get(counter).size();

                for (int i = 0; i < players.get(counter).size(); i++)
                {
                    for (int j = 0; j < team.size(); j++)
                    {
                        int diffX = (int) Math.abs(players.get(counter).get(i).getX() - team.get(j).getX());
                        int diffY = (int) Math.abs(players.get(counter).get(i).getY() - team.get(j).getY());

                        if ((diffX == 1 && diffY == 0) || (diffY == 1 && diffX == 0))
                        {
                            //Adding player and removing him from the team
                            players.get(counter).add(team.get(j));
                            team.remove(j);
                        }
                    }
                }
            }while (players.get(counter).size() > size);
        }

        //Removing players less than threshold
        for (int i = 0; i < players.size(); i++)
        {
            if ((players.get(i).size() * 4)< threshold)
                players.remove(i--);
        }

        //Calculating center for each player
        ArrayList<Point> ps = new ArrayList<Point>();
        for (int i = 0; i < players.size(); i++)
        {
            Point temp = new Point(centerX(players.get(i)), centerY(players.get(i)));
            ps.add(temp);
        }
        return ps;
    }

    public static int centerX(ArrayList<Point> player)
    {
        //Calculating min
        int min = (int) player.get(0).getX();
        for (int i = 0; i < player.size(); i++)
        {
            if (player.get(i).getX() < min)
                min = (int) player.get(i).getX();
        }

        //Calculating max
        int max = (int) player.get(0).getX();
        for (int i = 0; i < player.size(); i++)
        {
            if (player.get(i).getX() > max)
                max = (int) player.get(i).getX();
        }

        return (max + 1 + min);
    }

    public static int centerY(ArrayList<Point> player)
    {
        //Calculating min
        int min = (int) player.get(0).getY();
        for (int i = 0; i < player.size(); i++)
        {
            if (player.get(i).getY() < min)
                min = (int) player.get(i).getY();
        }

        //Calculating max
        int max = (int) player.get(0).getY();
        for (int i = 0; i < player.size(); i++)
        {
            if (player.get(i).getY() > max)
                max = (int) player.get(i).getY();
        }

        return (max + 1 + min);
    }
}
