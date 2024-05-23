package lk.ijse.hibernate.thogakade.sample.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
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
import lk.ijse.hibernate.thogakade.sample.entity.Orders;
import lk.ijse.hibernate.thogakade.sample.repository.OrderRepository;

public class OrderFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableView<Orders> tblOrder;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtOrderId;

    private Stage stage;
    private Scene scene;

    Orders orders;

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
    void btnClearOnAction(ActionEvent event) {
        txtOrderId.setText(null);
        txtDate.setText(null);
        txtCustomerId.setText(null);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        OrderRepository orderRepository = new OrderRepository();

        orders.setId(txtOrderId.getText());
        orders.setDate(Timestamp.valueOf(txtDate.getText()));
        orders.setCusId(txtCustomerId.getText());

        boolean isDeleted = orderRepository.deleteItem(orders);
        if(isDeleted){
            System.out.println("Order deleted");
            new Alert(Alert.AlertType.CONFIRMATION, "Order deleted").show();
        }else {
            System.out.println("Order not deleted");
            new Alert(Alert.AlertType.ERROR, "Order not deleted").show();
        }
        getAll();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        OrderRepository orderRepository = new OrderRepository();

        orders.setId(txtOrderId.getText());
        orders.setDate(Timestamp.valueOf(txtDate.getText()));
        orders.setCusId(txtCustomerId.getText());

        boolean isSaved = orderRepository.saveOrder(orders);
        if(isSaved){
            System.out.println("Order saved");
            new Alert(Alert.AlertType.CONFIRMATION, "Item saved").show();

        }else {
            System.out.println("Order not saved");
            new Alert(Alert.AlertType.ERROR, "Item not saved").show();

        }
        getAll();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        OrderRepository orderRepository = new OrderRepository();

        orders.setId(txtOrderId.getText());
        orders.setDate(Timestamp.valueOf(txtDate.getText()));
        orders.setCusId(txtCustomerId.getText());

        boolean isupdated = orderRepository.updateOrder(orders);
        if(isupdated){
            System.out.println("Order updated");
            new Alert(Alert.AlertType.CONFIRMATION, "Order updated").show();
        }else {
            System.out.println("Order not updated");
            new Alert(Alert.AlertType.ERROR, "Order not updated").show();
        }
        getAll();
    }

    @FXML
    void tblOrderOnMouseClicked(MouseEvent event) {
        TablePosition pos=tblOrder.getSelectionModel().getSelectedCells().get(0);
        int row=pos.getRow();

        ObservableList<TableColumn<Orders,?>> columns=tblOrder.getColumns();

        txtOrderId.setText(columns.get(0).getCellData(row).toString());
        txtDate.setText(columns.get(1).getCellData(row).toString());
        txtCustomerId.setText(columns.get(2).getCellData(row).toString());
    }

    @FXML
    void initialize() {
        orders = new Orders();
        getAll();
        setCellValueFactory();
        assert colCustomerId != null : "fx:id=\"colCustomerId\" was not injected: check your FXML file 'order_form.fxml'.";
        assert colDate != null : "fx:id=\"colDate\" was not injected: check your FXML file 'order_form.fxml'.";
        assert colOrderId != null : "fx:id=\"colOrderId\" was not injected: check your FXML file 'order_form.fxml'.";
        assert tblOrder != null : "fx:id=\"tblOrder\" was not injected: check your FXML file 'order_form.fxml'.";
        assert txtCustomerId != null : "fx:id=\"txtCustomerId\" was not injected: check your FXML file 'order_form.fxml'.";
        assert txtDate != null : "fx:id=\"txtDate\" was not injected: check your FXML file 'order_form.fxml'.";
        assert txtOrderId != null : "fx:id=\"txtOrderId\" was not injected: check your FXML file 'order_form.fxml'.";

    }
    private void getAll() {
        OrderRepository orderRepository = new OrderRepository();

        ObservableList<Orders> obList = FXCollections.observableArrayList();
        List<Orders> allOrder = orderRepository.getAllOrder();

        for (Orders orders : allOrder) {
            obList.add(new Orders(
                    orders.getId(),
                    orders.getDate(),
                    orders.getCusId()));
        }
        tblOrder.setItems(obList);
    }

    public void setCellValueFactory(){
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("cusId"));
    }
}
