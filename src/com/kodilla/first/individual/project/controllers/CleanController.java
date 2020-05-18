package sample;

import com.kodilla.first.individual.project.controllers.MainController;
import javafx.fxml.FXML;


public class CleanController {
    private MainController mainController;
    @FXML
    public void paneOnClick(){
        mainController.loadAppScreen();
    }
}
