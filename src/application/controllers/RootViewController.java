package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.org.omg.CORBA.Initializer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NonNls;

public class RootViewController implements Initializable {

    @NonNls
    private final String clientsViewLocation = "../view/ClientsView.fxml";
    @NonNls
    private final String stockViewLocation = "../view/StockView.fxml";
    @NonNls
    private final String storeViewLocation = "../view/StoreView.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TabPane mainTabPane;

    @FXML
    private Tab clientsTab;

    @FXML
    private Tab stockTab;

    @FXML
    private Tab storeTab;

    @FXML
    private Tab reportsTab;

    @FXML
    private Tab paymentsTab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        loadClientsTabContent();
        loadStockTabContent();
        loadStoreTabContent();
    }

    private void loadClientsTabContent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(clientsViewLocation));
            loader.setResources(resources);
            AnchorPane clientsView = loader.load();
            clientsTab.setContent(clientsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadStockTabContent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(stockViewLocation));
            loader.setResources(resources);
            AnchorPane stockView = loader.load();
            stockTab.setContent(stockView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadStoreTabContent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(storeViewLocation));
            loader.setResources(resources);
            AnchorPane storeView = loader.load();
            storeTab.setContent(storeView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadReportsTabContent() {
    }

    private void loadPaymentsTabContent() {
    }
}
