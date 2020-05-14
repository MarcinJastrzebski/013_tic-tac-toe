package com.kodilla.first.individual.project.Logic;

import javafx.scene.image.Image;

public final class Settings {
    private static Settings settings = null;

    public final static Integer EASY = 1;
    public final static Integer MEDIUM = 2;
    public final static Integer HARD = 3;

    public final static Image OLETTER = new Image("file:resources/o-letter.png");
    public final static Image XLETTER = new Image("file:resources/x-letter.png");
    public final static Image OLETTERRED = new Image("file:resources/o-letter-red.png");
    public final static Image XLETTERRED = new Image("file:resources/x-letter-red.png");
    public final static Image TRANSP = new Image("file:resources/transp.png");

    public final static String XLETTERSTRING = "Krzyżyk";
    public final static String OLETTERSTRING = "Kółko";

    private boolean endGame = false;
    private Image player = XLETTER;
    private Image playerRed = XLETTERRED;
    private Image computer = OLETTER;
    private Image computerRed = OLETTERRED;
    private Image startingFigure = XLETTER;
    private Image startingFigureRed = XLETTERRED;

    private Integer oScore = 0;
    private Integer xScore = 0;
    private Integer level = 3;
    private Integer numberOfGames = 1;

    private Settings() {
    }

    public static Settings getInstance() {
        if (settings == null) {
            synchronized (Settings.class) {
                if (settings == null) {
                    settings = new Settings();
                }
            }
        }
        return settings;
    }
    public void resetScore(){
        setoScore(0);
        setxScore(0);
    }

    public void reverseStartingFigure(){
        if (XLETTER.getUrl().equals(startingFigure.getUrl())){
            setStartingFigure(OLETTER);
            setStartingFigureRed(OLETTERRED);
        } else {
            setStartingFigure(XLETTER);
            setStartingFigureRed(XLETTERRED);
        }
    }

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public Image getPlayer() {
        return player;
    }

    public void setPlayer(Image player) {
        this.player = player;
    }

    public Image getPlayerRed() {
        return playerRed;
    }

    public void setPlayerRed(Image playerRed) {
        this.playerRed = playerRed;
    }

    public Image getComputer() {
        return computer;
    }

    public void setComputer(Image computer) {
        this.computer = computer;
    }

    public Image getComputerRed() {
        return computerRed;
    }

    public void setComputerRed(Image computerRed) {
        this.computerRed = computerRed;
    }

    public Image getStartingFigure() {
        return startingFigure;
    }

    public void setStartingFigure(Image startingFigure) {
        this.startingFigure = startingFigure;
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

    public Image getStartingFigureRed() {
        return startingFigureRed;
    }

    public void setStartingFigureRed(Image startingFigureRed) {
        this.startingFigureRed = startingFigureRed;
    }

    public String getNameOfImage(Image image) {
        if (XLETTER.equals(image) || XLETTERRED.equals(image)) {
            return XLETTERSTRING;
        } else {
            return OLETTERSTRING;
        }
    }
}