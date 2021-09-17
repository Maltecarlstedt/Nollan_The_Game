import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;


public class NollanController {

    /**
     * The start menu with the buttons to start and exit the game
     *
     */

    @FXML
    private AnchorPane MainAnchorpane;

    @FXML
    private Button startGameButton;

    @FXML
    private Button exitGameButton;

    /**
     * Write your name site
     */

    @FXML
    private TextField nameTextField;

    @FXML
    private Button okButton;

    /**
     * Start the game
     */

    public void startGame(ActionEvent event) {
        System.out.println("Game started");

    }

    /**
     * Exit the game
     */

    public void exitGame(ActionEvent event) {
        System.out.println("Game closed");
        MainAnchorpane.getScene().getWindow().hide();
    }

}
