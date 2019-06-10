package application.interfaces;

import application.sql.entitys.Client;
import javafx.collections.ObservableList;

public interface ClientManager {

    ObservableList<Client> getClientsList();

    ObservableList<Client> getBackupClientsList();

    void fillData();

    void add(Client client);

    void update();

    void delete(Client client);


}
