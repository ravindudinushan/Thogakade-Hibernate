package lk.ijse.hibernate.thogakade.sample.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.hibernate.thogakade.sample.entity.Item;
import lk.ijse.hibernate.thogakade.sample.repository.ItemRepository;

public class ItemFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableView<Item> tblItem;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;
    private Stage stage;
    private Scene scene;

    private Item item;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/hibernate/thogakade/sample/resources/view/dashboard_form.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("POS");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void tblItemOnMouseClicked(MouseEvent event) {
        TablePosition pos=tblItem.getSelectionModel().getSelectedCells().get(0);
        int row=pos.getRow();

        ObservableList<TableColumn<Item,?>> columns=tblItem.getColumns();

        txtCode.setText(columns.get(0).getCellData(row).toString());
        txtDescription.setText(columns.get(1).getCellData(row).toString());
        txtUnitPrice.setText(columns.get(2).getCellData(row).toString());
        txtQtyOnHand.setText(columns.get(3).getCellData(row).toString());
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtCode.setText(null);
        txtDescription.setText(null);
        txtUnitPrice.setText(null);
        txtQtyOnHand.setText(null);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        ItemRepository itemRepository = new ItemRepository();

        item.setCode(txtCode.getText());
        item.setDescription(txtDescription.getText());
        item.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
        item.setQty(Integer.parseInt(txtQtyOnHand.getText()));

        boolean isDeleted = itemRepository.deleteItem(item);
        if(isDeleted){
            System.out.println("Item deleted");
            new Alert(Alert.AlertType.CONFIRMATION, "Item deleted").show();
        }else {
            System.out.println("Item not deleted");
            new Alert(Alert.AlertType.ERROR, "Item not deleted").show();
        }
        getAll();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        ItemRepository itemRepository = new ItemRepository();

        item.setCode(txtCode.getText());
        item.setDescription(txtDescription.getText());
        item.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
        item.setQty(Integer.parseInt(txtQtyOnHand.getText()));

        boolean isSaved = itemRepository.saveItem(item);
        if(isSaved){
            System.out.println("Item saved");
            new Alert(Alert.AlertType.CONFIRMATION, "Item saved").show();

        }else {
            System.out.println("Item not saved");
            new Alert(Alert.AlertType.ERROR, "Item not saved").show();

        }
        getAll();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        ItemRepository itemRepository = new ItemRepository();

        item.setCode(txtCode.getText());
        item.setDescription(txtDescription.getText());
        item.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
        item.setQty(Integer.parseInt(txtQtyOnHand.getText()));

        boolean isupdated = itemRepository.updateItem(item);
        if(isupdated){
            System.out.println("Item updated");
            new Alert(Alert.AlertType.CONFIRMATION, "Item updated").show();
        }else {
            System.out.println("Item not updated");
            new Alert(Alert.AlertType.ERROR, "Item not updated").show();
        }
        getAll();
    }


    @FXML
    void initialize() {
        item = new Item();
        getAll();
        setCellValueFactory();
        assert colCode != null : "fx:id=\"colCode\" was not injected: check your FXML file 'item_form.fxml'.";
        assert colDescription != null : "fx:id=\"colDescription\" was not injected: check your FXML file 'item_form.fxml'.";
        assert colQtyOnHand != null : "fx:id=\"colQtyOnHand\" was not injected: check your FXML file 'item_form.fxml'.";
        assert tblItem != null : "fx:id=\"tblItem\" was not injected: check your FXML file 'item_form.fxml'.";
        assert txtCode != null : "fx:id=\"txtCode\" was not injected: check your FXML file 'item_form.fxml'.";
        assert txtDescription != null : "fx:id=\"txtDescription\" was not injected: check your FXML file 'item_form.fxml'.";
        assert txtQtyOnHand != null : "fx:id=\"txtQtyOnHand\" was not injected: check your FXML file 'item_form.fxml'.";
        assert txtUnitPrice != null : "fx:id=\"txtUnitPrice\" was not injected: check your FXML file 'item_form.fxml'.";

    }
    private void getAll() {
        ItemRepository itemRepository = new ItemRepository();

        ObservableList<Item> obList = FXCollections.observableArrayList();
        List<Item> allItem = itemRepository.getAllItem();

        for (Item item : allItem) {
            obList.add(new Item(
                    item.getCode(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQty()));
        }
        tblItem.setItems(obList);
    }

    public void setCellValueFactory(){
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

}
