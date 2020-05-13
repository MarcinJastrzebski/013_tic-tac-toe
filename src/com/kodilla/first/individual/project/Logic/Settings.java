package com.kodilla.first.individual.project.Logic;

import javafx.scene.image.Image;

public final class Settings {
    private static Settings settings =null;
    public final static Image OLETTER = new Image("file:resources/o-letter.png");
    public final static Image XLETTER = new Image("file:resources/x-letter.png");
    public final static Image OLETTERRED = new Image("file:resources/o-letter-red.png");
    public final static Image XLETTERRED = new Image("file:resources/x-letter-red.png");
    private final static Image TRANSP = new Image("file:resources/transp.png");
    private final static String GRAJ = "Graj!";
    private final static String RESET = "Nowa gra";
    private static boolean endGame;
    private static Image player;
    private static Image computer;
    private Integer oScore = 0;
    private Integer xScore = 0;
    private Integer numberOfPlayerMoves = 0;
    private Integer numberOfComputerMoves = 0;
    private Integer level = 1;

    private Settings() {
    }

    public static Settings getInstance() {
        if (settings == null) {
            synchronized(Settings.class) {
                if (settings == null) {
                    settings = new Settings();
                }
            }
        }
        return settings;
    }

    public Integer getoScore() {
        return oScore;
    }

    public void setoScore(Integer oScore) {
        this.oScore = oScore;
    }

    public Integer getxScore() {
        return xScore;
    }

    public void setxScore(Integer xScore) {
        this.xScore = xScore;
    }

    public Integer getNumberOfPlayerMoves() {
        return numberOfPlayerMoves;
    }

    public void setNumberOfPlayerMoves(Integer numberOfPlayerMoves) {
        this.numberOfPlayerMoves = numberOfPlayerMoves;
    }

    public Integer getNumberOfComputerMoves() {
        return numberOfComputerMoves;
    }

    public void setNumberOfComputerMoves(Integer numberOfComputerMoves) {
        this.numberOfComputerMoves = numberOfComputerMoves;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
