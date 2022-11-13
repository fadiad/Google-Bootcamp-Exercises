package mainB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Player {
    private String name;
    private int jerseyNumber;
    private int grade;
    private String position;

    public Player(String name, int jerseyNumber, int grade, String position) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.grade = grade;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public int getGrade() {
        return grade;
    }

    public String getPosition() {
        return position;
    }


    public static ArrayList<Player> makePlayers() {

        String positionOptions[] = new String[]{"Goal Keeper", "Defender", "Midfielder", "Attacker"};
        String names[] = new String[]{"Jain", "Dan", "Avraham", "Sara", "Husam", "Maya"};

        ArrayList<Player> players = new ArrayList<>();
        ArrayList<String> positions = makePositions(positionOptions);
        Set<Integer> randomUniqNums = makeRandomUniqNums();

        Integer[] randomUniqNumsArr = randomUniqNums.toArray(new Integer[randomUniqNums.size()]);

        int playerNum = 0;

        for (; playerNum < positions.size(); playerNum++)
            players.add(new Player(names[(playerNum + makeRandomNumber(3)) % 5], randomUniqNumsArr[playerNum], randomUniqNumsArr[playerNum] + 33, positions.get(playerNum)));

        for (; playerNum < 11; playerNum++)
            players.add(new Player(names[(playerNum + makeRandomNumber(3)) % 5], randomUniqNumsArr[playerNum], randomUniqNumsArr[playerNum] + 33, positionOptions[makeRandomNumber(3)]));

        return players;
    }

    public static Set<Integer> makeRandomUniqNums() {

        Set<Integer> randomUniqNums = new HashSet<>();

        while (randomUniqNums.size() != 11)
            randomUniqNums.add(makeRandomNumber(100));

        return randomUniqNums;
    }

    public static int makeRandomNumber(int modo) {
        Random r = new Random();
        int randomMultipleOffour = r.nextInt(100) % modo + 1;
        return randomMultipleOffour;
    }

    public static ArrayList<String> makePositions(String[] positionOptions) {
        ArrayList<String> positions = new ArrayList<>();

        positions.add("Goal Keeper");

        for (int i = 1; i < positionOptions.length; i++)
            addPosistion(positions, positionOptions[i]);

        return positions;
    }

    public static void addPosistion(ArrayList<String> positions, String p) {
        for (int i = 0; i < 2; i++)
            positions.add(p);
    }

}
