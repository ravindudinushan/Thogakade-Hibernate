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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hibernate.thogakade.sample.entity.Customer;
import lk.ijse.hibernate.thogakade.sample.repository.CustomerRepository;

public class CustomerFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableView<Customer> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSalary;

    @FXML
    private AnchorPane root;
    private Stage stage;
    private Scene scene;

    Customer customer;

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
        txtId.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtSalary.setText(null);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        CustomerRepository customerRepository = new CustomerRepository();

        customer.setId(txtId.getText());
        customer.setName(txtName.getText());
        customer.setAddress(txtAddress.getText());
        customer.setSalary(Double.parseDouble(txtSalary.getText()));

        boolean isDeleted = customerRepository.deleteCustomer(customer);
        if(isDeleted){
            System.out.println("Customer Deleted");
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Deleted").show();
        }else {
            System.out.println("Customer not Deleted");
            new Alert(Alert.AlertType.ERROR, "Customer not Deleted").show();
        }
        getAll();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        CustomerRepository customerRepository = new CustomerRepository();

        customer.setId(txtId.getText());
        customer.setName(txtName.getText());
        customer.setAddress(txtAddress.getText());
        customer.setSalary(Double.parseDouble(txtSalary.getText()));

        boolean isSaved = customerRepository.saveCustomer(customer);
        if(isSaved){
            System.out.println("Customer Saved");
            new Alert(Alert.AlertType.CONFIRMATION, "Customer not Saved").show();
        }else {
            System.out.println("Customer not saved");
            new Alert(Alert.AlertType.ERROR, "Customer not Saved").show();
        }
        getAll();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        CustomerRepository customerRepository = new CustomerRepository();

        customer.setId(txtId.getText());
        customer.setName(txtName.getText());
        customer.setAddress(txtAddress.getText());
        customer.setSalary(Double.parseDouble(txtSalary.getText()));

        boolean isUpdated = customerRepository.updateCustomer(customer);
        if(isUpdated){
            System.out.println("Customer Updated");
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Updated").show();
        }else {
            System.out.println("Customer not Updated");
            new Alert(Alert.AlertType.ERROR, "Customer not Updated").show();
        }
        getAll();
    }

    @FXML
    void tblCustomerOnMouseClicked(MouseEvent event) {
        TablePosition pos=tblCustomer.getSelectionModel().getSelectedCells().get(0);
        int row=pos.getRow();

        ObservableList<TableColumn<Customer,?>> columns=tblCustomer.getColumns();

        txtId.setText(columns.get(0).getCellData(row).toString());
        txtName.setText(columns.get(1).getCellData(row).toString());
        txtAddress.setText(columns.get(2).getCellData(row).toString());
        txtSalary.setText(columns.get(3).getCellData(row).toString());
    }

    @FXML
    void initialize() {
        setCellValueFactory();
        getAll();
        customer = new Customer();
        assert colAddress != null : "fx:id=\"colAddress\" was not injected: check your FXML file 'customer_form.fxml'.";
        assert colId != null : "fx:id=\"colId\" was not injected: check your FXML file 'customer_form.fxml'.";
        assert colName != null : "fx:id=\"colName\" was not injected: check your FXML file 'customer_form.fxml'.";
        assert colSalary != null : "fx:id=\"colSalary\" was not injected: check your FXML file 'customer_form.fxml'.";
        assert tblCustomer != null : "fx:id=\"tblCustomer\" was not injected: check your FXML file 'customer_form.fxml'.";
        assert txtAddress != null : "fx:id=\"txtAddress\" was not injected: check your FXML file 'customer_form.fxml'.";
        assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'customer_form.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'customer_form.fxml'.";
        assert txtSalary != null : "fx:id=\"txtSalary\" was not injected: check your FXML file 'customer_form.fxml'.";
    }
    private void getAll() {
        CustomerRepository customerRepository = new CustomerRepository();

        ObservableList<Customer> obList = FXCollections.observableArrayList();
        List<Customer> allCustomer = customerRepository.getAllCustomer();

        for (Customer customer : allCustomer) {
            obList.add(new Customer(
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getSalary()));
        }
        tblCustomer.setItems(obList);
    }

    public void setCellValueFactory(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }
}
