package application.controllers;

import application.interfaces.ClientManager;
import application.model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientInfoViewController {

    @FXML
    public TextField mobileTextField;
    public Button deleteButton;
    public Button saveButton;

    private Client client;
    private Stage stage;
    private ClientManager clientManager;
    private boolean isNewClient;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label clientNameHeadLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    void initialize() {
    }

    public void setClient(Client client) {
        this.client = client;
        if (client != null) {
            setClientInfoInTextFields(client);
        } else {
            clearInfoTextFields();
        }
    }

    private void clearInfoTextFields() {
        clientNameHeadLabel.setText(resources.getString("client.info.view_new.client"));
        nameTextField.setText("");
        mobileTextField.setText("");
    }

    private void setClientInfoInTextFields(Client client) {
        clientNameHeadLabel.setText(client.getClientName());
        nameTextField.setText(client.getClientName());
        mobileTextField.setText(client.getClientMobileNumber());
    }

    public void deleteButtonOnAction(ActionEvent actionEvent) {
        if (!isNewClient) {
            clientManager.delete(client);
        }
        stage.hide();
    }

    public void saveButtonOnAction(ActionEvent actionEvent) {
        if (!isNewClient) {
            saveInfoIntoClient(client);
        } else {
            Client client = new Client();
            saveInfoIntoClient(client);
            clientManager.add(client);
        }
        stage.hide();
    }

    private void saveInfoIntoClient(Client client) {
        client.setClientName(nameTextField.getText());
        client.setClientMobileNumber(mobileTextField.getText());
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setIsNewClient(boolean isNewClient) {
        this.isNewClient = isNewClient;
    }
}