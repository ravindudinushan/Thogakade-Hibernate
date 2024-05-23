package lk.ijse.hibernate.thogakade.sample.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DashboardFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane root;
    private Stage stage;
    private Scene scene;

    @FXML
    void customerOnAction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/hibernate/thogakade/sample/resources/view/customer_form.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Customer Manage");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void iteamOnActoin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/hibernate/thogakade/sample/resources/view/item_form.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Item Manage");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void placeOrderOnAction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/hibernate/thogakade/sample/resources/view/placeOrder_form.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Place Order Manage");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void orderOnAction(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/hibernate/thogakade/sample/resources/view/order_form.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Order Manage");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void initialize() {

    }

}
