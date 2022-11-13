package mainB;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = Player.makePlayers();

        for (Player p : players) {
            System.out.println("Name : " + p.getName() + " , Jersey Number : " +
                    p.getJerseyNumber() + " , Jersey Grade : " + p.getGrade() +
                    " , Jersey Position : " + p.getPosition());
        }

    }
}
