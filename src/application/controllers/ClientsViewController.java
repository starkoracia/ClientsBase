package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.interfaces.ClientManager;
import application.interfaces.impl.CollectionClientManager;
import application.model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.jetbrains.annotations.NonNls;

public class ClientsViewController implements Initializable {

    public Button newClientButton;
    private ClientManager clientManager;
    @NonNls
    private final String clientInfoViewLocation = "../view/ClientInfoView.fxml";
    private FXMLLoader loader;
    private ClientInfoViewController controller;
    private Stage clientInfoStage;
    private VBox clientInfoView;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Client> clientsTable;

    @FXML
    private TableColumn<Client, String> nameTableColumn;

    @FXML
    private TableColumn<Client, String> emailTableColumn;

    @FXML
    private TableColumn<Client, String> mobileNumberTableColumn;

    @FXML
    private TableColumn<Client, String> recommendationTableColumn;

    @FXML
    private TableColumn<Client, String> annotationTableColumn;

    public ClientsViewController() {
        this.clientManager = new CollectionClientManager();
        clientManager.fillData();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        initCellDataValues();
        clientsTable.setItems(clientManager.getClientsList());

        loaderAndControllerInit();
    }

    private void loaderAndControllerInit() {
        try {
            loader = new FXMLLoader(getClass().getResource(clientInfoViewLocation));
            loader.setResources(resources);
            clientInfoView = loader.load();
            controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initCellDataValues() {
        nameTableColumn.setCellValueFactory(
                cellData -> cellData.getValue().clientNameProperty());
        mobileNumberTableColumn.setCellValueFactory(
                cellData -> cellData.getValue().clientMobileNumberProperty());
    }

    public void pressedEnter(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            goToClientInfoView(false);
        }
    }

    private void goToClientInfoView(boolean isNewClient) {
        loadClientInfoStage();
        controller.setStage(clientInfoStage);
        controller.setClientManager(clientManager);
        controller.setIsNewClient(isNewClient);
        if (!isNewClient) {
            Client client = clientsTable.getSelectionModel().getSelectedItem();
            controller.setClient(client);
        } else {
            controller.setClient(null);
        }
        clientInfoStage.showAndWait();
    }

    private void loadClientInfoStage() {
        if (clientInfoStage == null) {
            clientInfoStage = new Stage();
            clientInfoStage.initModality(Modality.WINDOW_MODAL);
            clientInfoStage.initOwner(clientsTable.getScene().getWindow());
            clientInfoStage.setTitle(resources.getString("client.info.view_client.info"));
            Scene scene = new Scene(clientInfoView);
            clientInfoStage.setScene(scene);
        }
    }

    public void newClientButtonOnAction(ActionEvent actionEvent) {
        goToClientInfoView(true);
    }

    public void onMouseClickedTable(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() == 2) {
            goToClientInfoView(false);
        }
    }

}