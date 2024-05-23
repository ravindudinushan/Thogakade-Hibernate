package lk.ijse.hibernate.thogakade.sample.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlaceOrderFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> cmbCustomerId;

    @FXML
    private ComboBox<?> cmbItemCode;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblOrderDate;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblQtyOnHand;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private TableView<?> tblOrderCart;

    @FXML
    private TextField txtQty;

    private Stage stage;
    private Scene scene;

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

    }

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
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void cmbCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void cmbItemOnAction(ActionEvent event) {

    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert cmbCustomerId != null : "fx:id=\"cmbCustomerId\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert cmbItemCode != null : "fx:id=\"cmbItemCode\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert colAction != null : "fx:id=\"colAction\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert colDescription != null : "fx:id=\"colDescription\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert colItemCode != null : "fx:id=\"colItemCode\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert colQty != null : "fx:id=\"colQty\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert colTotal != null : "fx:id=\"colTotal\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert colUnitPrice != null : "fx:id=\"colUnitPrice\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert lblCustomerName != null : "fx:id=\"lblCustomerName\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert lblDescription != null : "fx:id=\"lblDescription\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert lblNetTotal != null : "fx:id=\"lblNetTotal\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert lblOrderDate != null : "fx:id=\"lblOrderDate\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert lblOrderId != null : "fx:id=\"lblOrderId\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert lblQtyOnHand != null : "fx:id=\"lblQtyOnHand\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert lblUnitPrice != null : "fx:id=\"lblUnitPrice\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert tblOrderCart != null : "fx:id=\"tblOrderCart\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
        assert txtQty != null : "fx:id=\"txtQty\" was not injected: check your FXML file 'placeOrder_form.fxml'.";
    }

}
