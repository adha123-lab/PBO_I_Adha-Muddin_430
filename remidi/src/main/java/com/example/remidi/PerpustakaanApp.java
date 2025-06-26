package com.example.remidi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.text.Font;

public class PerpustakaanApp extends Application {
    private ManajerPerpustakaan manajer = new ManajerPerpustakaan();
    private TableView<Buku> tableView = new TableView<>();
    private ObservableList<Buku> data = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("📚 Perpustakaan Pribadi");

        // Tabel
        TableColumn<Buku, String> judulCol = new TableColumn<>("Judul");
        judulCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getJudul()));
        judulCol.setMinWidth(200);

        TableColumn<Buku, String> penulisCol = new TableColumn<>("Penulis");
        penulisCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getPenulis()));
        penulisCol.setMinWidth(150);

        TableColumn<Buku, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().isTersedia() ? "✅ Tersedia" : "❌ Dipinjam"));
        statusCol.setMinWidth(120);

        tableView.getColumns().addAll(judulCol, penulisCol, statusCol);
        tableView.setItems(data);

        // Input
        TextField judulField = new TextField();
        judulField.setPromptText("Judul Buku");
        judulField.setPrefWidth(200);

        TextField penulisField = new TextField();
        penulisField.setPromptText("Penulis Buku");
        penulisField.setPrefWidth(200);

        Button tambahBtn = new Button("➕ Tambah Buku");
        tambahBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        tambahBtn.setOnAction(e -> {
            String judul = judulField.getText();
            String penulis = penulisField.getText();
            if (!judul.isEmpty() && !penulis.isEmpty()) {
                Buku buku = new Buku(judul, penulis);
                manajer.tambahBuku(buku);
                data.setAll(manajer.getSemuaBuku());
                judulField.clear();
                penulisField.clear();
            }
        });

        Button pinjamBtn = new Button("📕 Tandai Dipinjam");
        pinjamBtn.setStyle("-fx-background-color: #f57c00; -fx-text-fill: white;");
        pinjamBtn.setOnAction(e -> {
            int index = tableView.getSelectionModel().getSelectedIndex();
            try {
                manajer.pinjamBuku(index);
                data.setAll(manajer.getSemuaBuku());
            } catch (IndexOutOfBoundsException ex) {
                showAlert("Pilih buku terlebih dahulu!");
            }
        });

        Button kembaliBtn = new Button("📗 Tandai Tersedia");
        kembaliBtn.setStyle("-fx-background-color: #039be5; -fx-text-fill: white;");
        kembaliBtn.setOnAction(e -> {
            int index = tableView.getSelectionModel().getSelectedIndex();
            try {
                manajer.kembalikanBuku(index);
                data.setAll(manajer.getSemuaBuku());
            } catch (IndexOutOfBoundsException ex) {
                showAlert("Pilih buku terlebih dahulu!");
            }
        });

        HBox formBox = new HBox(10, judulField, penulisField, tambahBtn);
        formBox.setPadding(new Insets(10));
        HBox actionBox = new HBox(10, pinjamBtn, kembaliBtn);
        actionBox.setPadding(new Insets(10));
        VBox root = new VBox(10, tableView, formBox, actionBox);
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: #f1f8e9;");

        Scene scene = new Scene(root, 650, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Informasi");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
