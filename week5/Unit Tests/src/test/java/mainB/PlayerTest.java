package mainB;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private static Player player;

    @BeforeAll
    static void setup() {
        player = new Player("name", 44, 90, "Goal Keeper");
    }

    @Test
    void getGradeFunction_Returns_TheGrade() {
        assertEquals(90, player.getGrade());
    }

    @Test
    void getPositionFunction_Returns_ThePosition() {
        assertEquals("Goal Keeper", player.getPosition());
    }

    @Test
    void makeRandomNumber_Generate_Number() {
        assertTrue((Player.makeRandomNumber(5) < 5) & (Player.makeRandomNumber(5) > 0));
    }

    @Test
    void getNameFunction_Returns_PlaterName() {
        assertEquals("name", player.getName());
    }

    @Test
    void getJerseyNumberFunction_Returns_PlaterJerseyNumber() {
        assertEquals(44, player.getJerseyNumber());
    }

    @Test
    void makeRandomUniqNumsFunction_Returns_SetOfUniqNumbers() {
        assertTrue(Player.makeRandomUniqNums().size() > 0);
    }


    @Test
    void makePositionsFunction_Returns_Position() {
        String positionOptions[] = new String[]{"Goal Keeper", "Defender", "Midfielder", "Attacker"};
        assertTrue(Player.makePositions(positionOptions).size() > 0);
    }


    // I just tried to make a helper functions , each test should be alone , for example Defender numbers is a single test
    @Test
    void makePlayersFunction_Returns_Position() {
        String positionOptions[] = new String[]{"Goal Keeper", "Defender", "Midfielder", "Attacker"};
        ArrayList<Player> players = Player.makePlayers();
        assertTrue((Player.makePlayers().size()) > 0
                & (goalKeeperCounter(players) == 1)
                & (defenderCounter(players) >= 2)
                & (midfielderCounter(players) >= 2)
                & (attackerCounter(players) >= 2)
        );
    }

    int goalKeeperCounter(ArrayList<Player> players) {
        return (int) players.stream()
                .filter(player -> player.getPosition().equals("Goal Keeper")).count();
    }

    int defenderCounter(ArrayList<Player> players) {
        return (int) players.stream()
                .filter(player -> player.getPosition().equals("Defender")).count();
    }

    int midfielderCounter(ArrayList<Player> players) {
        return (int) players.stream()
                .filter(player -> player.getPosition().equals("Midfielder")).count();
    }

    int attackerCounter(ArrayList<Player> players) {
        return (int) players.stream()
                .filter(player -> player.getPosition().equals("Attacker")).count();
    }


    @Test
    void makePositionsFunction_Returns_towOrMoreDefender() {
        String positionOptions[] = new String[]{"Goal Keeper", "Defender", "Midfielder", "Attacker"};
        ArrayList<Player> players = Player.makePlayers();
        assertTrue(defenderCounter(players) >= 2);
    }


    @Test
    void makePositionsFunction_Returns_onlyOneGoalKeeper() {
        String positionOptions[] = new String[]{"Goal Keeper", "Defender", "Midfielder", "Attacker"};
        ArrayList<Player> players = Player.makePlayers();
        assertEquals(1, goalKeeperCounter(players));
    }

}