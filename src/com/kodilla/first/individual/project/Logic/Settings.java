package com.kodilla.first.individual.project.Logic;

import javafx.scene.image.Image;

public final class Settings {
    private static Settings settings =null;
    public final static Integer EASY = 1;
    public final static Integer MEDIUM = 2;
    public final static Integer HARD = 3;

    public final static Image OLETTER = new Image("file:resources/o-letter.png");
    public final static Image XLETTER = new Image("file:resources/x-letter.png");
    public final static Image OLETTERRED = new Image("file:resources/o-letter-red.png");
    public final static Image XLETTERRED = new Image("file:resources/x-letter-red.png");

    public final static String XLETTERSTRING = "Krzyżyk";
    public final static String OLETTERSTRING = "Kółko";


    private final static Image TRANSP = new Image("file:resources/transp.png");
    private final static String GRAJ = "Graj!";
    private final static String RESET = "Nowa gra";


    private boolean endGame;
    private Image player = XLETTER;
    private Image playerRed = XLETTERRED;
    private Image computer = OLETTER;
    private Image computerRed = OLETTERRED;
    private Image startingFigure = XLETTER;


    private Integer oScore = 0;
    private Integer xScore = 0;
    private Integer numberOfPlayerMoves = 0;
    private Integer numberOfComputerMoves = 0;
    private Integer level = 1;
    private Integer numberOfGames =3;

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

    public Image getStartingFigure() {
        return startingFigure;
    }

    public void setStartingFigure(Image startingFigure) {
        this.startingFigure = startingFigure;
    }

    public Image getPlayer() {
        return player;
    }

    public void setPlayer(Image player) {
        this.player = player;
    }

    public Image getComputer() {
        return computer;
    }

    public void setComputer(Image computer) {
        this.computer = computer;
    }

    public Image getPlayerRed() {
        return playerRed;
    }

    public void setPlayerRed(Image playerRed) {
        this.playerRed = playerRed;
    }

    public Image getComputerRed() {
        return computerRed;
    }

    public void setComputerRed(Image computerRed) {
        this.computerRed = computerRed;
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

    public Integer getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(Integer numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public String getNameOfImage(Image image){
        if (XLETTER.equals(image)||XLETTERRED.equals(image)){
            return XLETTERSTRING;
        } else {
            return OLETTERSTRING;
        }
    }
}
