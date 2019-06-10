package application;

import java.io.IOException;
import java.util.ResourceBundle;

import application.controllers.AuthenticateController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.jetbrains.annotations.NonNls;

public class Main extends Application {

    private Stage primaryStage;

    private AnchorPane rootView;


    private final String appName;
    @NonNls
    private final String authenticateLocation = "view/Authenticate.fxml";
    private ResourceBundle resources;

    public Main() {
        resources = ResourceBundle.getBundle("application.bundles.Locale");
        appName = resources.getString("main_clients.database");
    }

    @Override
    public void start(Stage primaryStage) {
        setPrimaryStage(primaryStage,appName);
        showAuthenticateView();
    }

    private void showAuthenticateView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(authenticateLocation));
            rootView = loader.load();

            AuthenticateController controller = loader.getController();
            controller.setAuthenticateStage(primaryStage);

            primaryStage.setScene(new Scene(rootView));
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPrimaryStage(Stage primaryStage, String stageName) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(stageName);
    }

    public static void main(String[] args) {
        launch(args);
    }
}