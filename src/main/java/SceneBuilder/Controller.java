package SceneBuilder;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

    /**
     * The start menu with the buttons to start and exit the game
     *
     */

    @FXML
    private AnchorPane startAnchorPane;

    @FXML
    private Button startGameButton, exitGameButton;

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

    public void startGame(ActionEvent event) throws Exception{
            System.out.println("Game started");

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("playerName.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.showAndWait();
    }

    /**
     * Fill in name and approve
     */

    public void approveName(ActionEvent event) {
        //nameTextField.setText(nameTextField.getText());
        System.out.println("Name: " + nameTextField.getText());
    }

    /**
     * Exit the game
     */

    public void exitGame(ActionEvent event) {
        System.out.println("Game closed");
        Stage stage = (Stage) exitGameButton.getScene().getWindow();
        stage.close();
    }

}
