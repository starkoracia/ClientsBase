package application.interfaces;

import application.model.Client;
import javafx.collections.ObservableList;

public interface ClientManager {

    ObservableList<Client> getClientsList();

    ObservableList<Client> getBackupClientsList();

    void fillData();

    void add(Client client);

    void update(Client client);

    void delete(Client client);


}
