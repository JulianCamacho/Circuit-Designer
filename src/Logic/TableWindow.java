package Logic;

import DoublyLinkedList_Pack.DoublyLinkedList;
import Interface.AlertBox;
import Interface.GUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.MalformedURLException;

public class TableWindow {

    protected static Stage tableStage;
    protected static HBox hb;
    protected static HBox header;

    public static Stage createTableWindow() throws MalformedURLException {
        tableStage = new Stage();
        tableStage.setTitle("Truth Table");

        header = new HBox();
        header.setPadding(new Insets(10, 10, 10, 10));
        header.setSpacing(200);
        header.setStyle("-fx-background-color: #336699;");
        hb = new HBox();

        BorderPane bp = new BorderPane();
        bp.setCenter(hb);
        bp.setTop(header);

        Scene scene = new Scene(bp, 700, 180);

        generateTruth(GUI.gateList);

        tableStage.setScene(scene);
        tableStage.show();

        return tableStage;
    }

    public static void generateTruth(DoublyLinkedList finalList) {
        if (finalList.isEmpty()){
            AlertBox.displayAlertBox("Empty Circuit", "Your circuit is empty");
        }
        else {
            for (int i = 0; i < finalList.getLength(); i++) {
                Gate currentGate = finalList.getGate(i);
                System.out.println(currentGate);
                if (currentGate.getName() != "NOT") {
                    Label l1 = new Label(currentGate.getName());
                    l1.setTextFill(Color.WHITE);

                    ListView<String> newColumn1 = new ListView<>();
                    newColumn1.getItems().addAll(currentGate.getGateIn1().getId(), "true", "true", "false", "false");

                    ListView<String> newColumn2 = new ListView<>();
                    newColumn2.getItems().addAll(currentGate.getGateIn2().getId(), "true", "false", "true", "false");

                    ListView<String> newColumnResult = new ListView<>();
                    newColumnResult.getItems().addAll(currentGate.getGateOut().getId(),
                            toString(currentGate.logic(true, true)), toString(currentGate.logic(true, false)),
                            toString(currentGate.logic(false, true)), toString(currentGate.logic(false, false)));

                    hb.getChildren().addAll(newColumn1, newColumn2, newColumnResult);
                    header.getChildren().add(l1);
                    header.setAlignment(Pos.CENTER);

                } else if (currentGate.getName() == "NOT") {
                    Label l1 = new Label(currentGate.getName());
                    l1.setTextFill(Color.WHITE);

                    ListView<String> newColumn1 = new ListView<>();
                    newColumn1.getItems().addAll(currentGate.getGateIn1().getId(), "true", "true", "false", "false");

                    ListView<String> newColumnResult = new ListView<>();
                    newColumnResult.getItems().addAll(currentGate.getGateOut().getId(),
                            toString(currentGate.logic(true, true)), toString(currentGate.logic(true, false)),
                            toString(currentGate.logic(false, true)), toString(currentGate.logic(false, false)));

                    hb.getChildren().addAll(newColumn1, newColumnResult);
                    header.getChildren().add(l1);
                    header.setAlignment(Pos.CENTER);

                }
            }
        }
    }

    private static String toString(boolean logic) {
        String newString = "";
        if (logic == true){
            newString = "true";
        }
        else if(logic == false){
            newString = "false";
        }
        return newString;
    }
}
