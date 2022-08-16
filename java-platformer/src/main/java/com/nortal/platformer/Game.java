package com.nortal.platformer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Game {

    public static void main(String[] args) {
        Game game = new Game("platforms.csv");
        try {
            game.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);

    }

    private Integer points = 500;
    private Platform activePlatform;
    private final String gameFile;

    public Game(String gameFile) {
        this.gameFile = gameFile;
    }

    public void run() throws FileNotFoundException {
        List<Platform> platforms = readPlatforms();
        int numOfJumps = 0;
        for (int i = 0; i < platforms.size() - 1; i++) {
            activePlatform = platforms.get(i);
            Platform next = platforms.get(i + 1);
            int jumpCost = next.getCost();
            int activeIndex = activePlatform.getIndex();
            while(jumpCost > points && activeIndex-- > 0) {
                jumpTo(platforms.get(activeIndex));
                numOfJumps++;
                points+=platforms.get(activeIndex).getCost();
            }
            points -= jumpCost;
            jumpTo(platforms.get(i));
            numOfJumps++;
        }

        System.out.println(numOfJumps);

    }

    /**
     * Reads platforms from csv file and returns the as list.
     * @return platforms - Platforms as list
     */
    private List<Platform> readPlatforms() throws FileNotFoundException {
        Scanner scan = new Scanner(new File(gameFile));
        List<Platform> list = new ArrayList<>();
        scan.nextLine();
        while(scan.hasNext()) {
            String[] line = scan.nextLine().split(", ");
            list.add(new Platform(Integer.valueOf(line[0]), Integer.valueOf(line[1])));
        }
        return list;
    }


    /**
     * Invoke this function to jump to next platform.
     * @param platform - Platform that you are going to jump to.
     */
    public void jumpTo(Platform platform) {

        activePlatform = platform;
    }
}
