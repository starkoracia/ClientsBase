package application;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jetbrains.annotations.NonNls;

public class Main extends Application {

    private Stage primaryStage;

    private BorderPane rootView;


    private final String appName;
    @NonNls
    private final String rootViewLocation = "view/RootView.fxml";
    private ResourceBundle resources;

    public Main() {
        resources = ResourceBundle.getBundle("application.bundles.Locale");
        appName = resources.getString("main_clients.database");
    }

    @Override
    public void start(Stage primaryStage) {
        setPrimaryStage(primaryStage,appName);
        showRootView();
    }

    private void showRootView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rootViewLocation));
            loader.setResources(resources);
            rootView = loader.load();

            primaryStage.setScene(new Scene(rootView));
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