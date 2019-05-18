package application.interfaces.impl;

import application.interfaces.ClientManager;
import application.model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class CollectionClientManager implements ClientManager {

    private ObservableList<Client> clientsList;

    public CollectionClientManager(ObservableList<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public CollectionClientManager() {
        this.clientsList = FXCollections.observableArrayList();
    }

    @Override
    public void fillData() {
        fillTestData();
    }

    private void fillTestData() {
        add(new Client("Тарас Распорня", "380981451312"));
        add(new Client("Виталий Кановалов", "380981212121"));
        add(new Client("Илья Авдан", "380982000777"));
        add(new Client("Леха Губенко", "380974646888"));
        add(new Client("Денис Исаев", "+380984252103"));
    }

    @Override
    public void add(Client client) {
        clientsList.add(client);
    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(Client client) {
        clientsList.remove(client);
    }

    @Override
    public ObservableList<Client> getClientsList() {
        return clientsList;
    }
}
