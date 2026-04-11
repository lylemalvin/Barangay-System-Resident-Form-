package com.sanmarino.barangaysystem;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.*;

public class HelloController {

    @FXML private TableView<Resident> table;

    @FXML private TableColumn<Resident, String> idCol, lastCol, middleCol,
            firstCol, suffixCol, contactCol, emailCol,
            houseCol, streetCol, civilCol, birthCol;

    private ObservableList<Resident> list = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        idCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getId()));
        lastCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getLast()));
        middleCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getMiddle()));
        firstCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getFirst()));
        suffixCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getSuffix()));
        contactCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getContact()));
        emailCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmail()));
        houseCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getHouse()));
        streetCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getStreet()));
        civilCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCivil()));
        birthCol.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getBirth()));

        table.setItems(list);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    // ================= popup for add =================
    @FXML
    public void openAddPopup() {

        Stage popup = new Stage();
        popup.setTitle("Add Resident");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        TextField id = new TextField();
        TextField first = new TextField();
        TextField middle = new TextField();
        TextField last = new TextField();
        TextField suffix = new TextField();
        TextField contact = new TextField();
        TextField email = new TextField();
        TextField civil = new TextField();
        TextField house = new TextField();
        TextField street = new TextField();
        TextField birth = new TextField();

        grid.addRow(0, new Label("Resident ID"), id);
        grid.addRow(1, new Label("Last Name"), last);
        grid.addRow(2, new Label("Middle Name"), middle);
        grid.addRow(3, new Label("First Name"), first);
        grid.addRow(4, new Label("Suffix"), suffix);
        grid.addRow(5, new Label("Contact Number"), contact);
        grid.addRow(6, new Label("Email"), email);
        grid.addRow(7, new Label("Civil Status"), civil);
        grid.addRow(8, new Label("House Number"), house);
        grid.addRow(9, new Label("Street"), street);
        grid.addRow(10, new Label("Date of Birth"), birth);

        Button addBtn = new Button("Add");

        addBtn.setOnAction(e -> {
            list.add(new Resident(
                    id.getText(),
                    last.getText(),
                    middle.getText(),
                    first.getText(),
                    suffix.getText(),
                    contact.getText(),
                    email.getText(),
                    house.getText(),
                    street.getText(),
                    civil.getText(),
                    birth.getText()
            ));
            popup.close();
        });

        HBox buttonBox = new HBox(addBtn);
        buttonBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10,
                new Label("ADD RESIDENT"),
                grid,
                buttonBox
        );

        layout.setPadding(new Insets(10));

        popup.setScene(new Scene(layout, 350, 500));
        popup.show();
    }

    // ================= popup for delete =================
    @FXML
    public void openDeletePopup() {

        Stage popup = new Stage();
        popup.setTitle("Delete Resident");

        Button deleteBtn = new Button("Confirm Delete");

        deleteBtn.setOnAction(e -> {
            Resident selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                list.remove(selected);
            }
            popup.close();
        });

        HBox buttonBox = new HBox(deleteBtn);
        buttonBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10,
                new Label("DELETE RESIDENT"),
                new Label("Select a resident in table"),
                buttonBox
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));

        popup.setScene(new Scene(layout, 250, 200));
        popup.show();
    }
}