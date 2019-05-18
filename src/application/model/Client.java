package application.model;

import javafx.beans.property.SimpleStringProperty;

public class Client {

    private SimpleStringProperty clientName;
    private SimpleStringProperty clientEmail;
    private SimpleStringProperty clientMobileNumber;
    private SimpleStringProperty clientFindRecommendation;
    private SimpleStringProperty clientAnnotation;
    private SimpleStringProperty clientID;

    public Client(String clientName, String clientMobileNumber) {
	this.clientName = new SimpleStringProperty(clientName);
	this.clientMobileNumber = new SimpleStringProperty(clientMobileNumber);
    }

    public Client() {
	this(null, null);
    }

    public final SimpleStringProperty clientNameProperty() {
	return this.clientName;
    }

    public final String getClientName() {
	return this.clientNameProperty().get();
    }

    public final void setClientName(final String clientName) {
	this.clientNameProperty().set(clientName);
    }

    public final SimpleStringProperty clientEmailProperty() {
	return this.clientEmail;
    }

    public final String getClientEmail() {
	return this.clientEmailProperty().get();
    }

    public final void setClientEmail(final String clientEmail) {
	this.clientEmailProperty().set(clientEmail);
    }

    public final SimpleStringProperty clientMobileNumberProperty() {
	return this.clientMobileNumber;
    }

    public final String getClientMobileNumber() {
	return this.clientMobileNumberProperty().get();
    }

    public final void setClientMobileNumber(final String clientMobileNumber) {
	this.clientMobileNumberProperty().set(clientMobileNumber);
    }

    public final SimpleStringProperty clientFindRecommendationProperty() {
	return this.clientFindRecommendation;
    }

    public final String getClientFindRecommendation() {
	return this.clientFindRecommendationProperty().get();
    }

    public final void setClientFindRecommendation(final String clientFindRecommendation) {
	this.clientFindRecommendationProperty().set(clientFindRecommendation);
    }

    public final SimpleStringProperty clientAnnotationProperty() {
	return this.clientAnnotation;
    }

    public final String getClientAnnotation() {
	return this.clientAnnotationProperty().get();
    }

    public final void setClientAnnotation(final String clientAnnotation) {
	this.clientAnnotationProperty().set(clientAnnotation);
    }

    public final SimpleStringProperty clientIDProperty() {
	return this.clientID;
    }

    public final String getClientID() {
	return this.clientIDProperty().get();
    }

    public final void setClientID(final String clientID) {
	this.clientIDProperty().set(clientID);
    }

}
