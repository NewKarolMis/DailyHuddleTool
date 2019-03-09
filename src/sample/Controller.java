package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button exitButton;
    @FXML
    private TextArea mainTextArea;
    @FXML
    private Button randomButton;

    private List<String> stringListOne = new ArrayList<>(Arrays.asList("MKu", "AMi", "ASz", "AOd", "ANa", "WSk",
            "FKu", "RSz", "TWa", "AKo", "KMi", "RKu", "BMi", "JMa", "KSt", "KGo"));

    private List<String> stringListTwo = new ArrayList<>(Arrays.asList("MKu", "AMi", "ASz", "AOd", "ANa", "WSk",
            "FKu", "RSz", "TWa", "AKo", "KMi", "RKu", "BMi", "JMa", "KSt", "KGo"));
    private String text;

    private int counter = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainTextArea.setWrapText(true);

        exitButton.setOnAction(event -> {
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
        });

        addButton.setOnAction(event -> {
            String newName = mainTextArea.getText();
            stringListOne.add(newName);
            stringListTwo.add(newName);
            mainTextArea.clear();
        });

        removeButton.setOnAction(event -> {
            String nameToRemove = mainTextArea.getText();

            removePerson(nameToRemove, stringListOne);

            removePerson(nameToRemove, stringListTwo);

            mainTextArea.clear();
        });

        randomButton.setOnAction(event -> {

            Random rand = new Random();

            int n = rand.nextInt(stringListOne.size());
            int e = rand.nextInt(stringListTwo.size());


            while(stringListOne.get(n).equals(stringListTwo.get(e))) {
                e = rand.nextInt(stringListTwo.size());
            }
            counter++;
            if (counter > 10){
                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            }
            text = counter + " " + stringListOne.get(n) + " -> " + stringListTwo.get(e);
            stringListOne.remove(n);
            stringListTwo.remove(e);

            mainTextArea.setText(text);
        });
    }

    private void removePerson(String nameToRemove, List<String> stringListTwo) {
        for (int i = 0; i < stringListTwo.size(); i++) {
            String stringToRemove = stringListTwo.get(i);

            if((nameToRemove.toLowerCase()).equals(stringToRemove.toLowerCase())){
                stringListTwo.remove(i);
            }
        }
    }
}