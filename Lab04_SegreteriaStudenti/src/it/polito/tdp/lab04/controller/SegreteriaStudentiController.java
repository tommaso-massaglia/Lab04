package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.ResourceBundle;
import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

	Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<String> corsoSelector;

	@FXML
	private Button btnCercaIscrittiCorso;

	@FXML
	private TextField txtMatricola;

	@FXML
	private Button btnCompleta;

	@FXML
	private TextField txtNomeStudente;

	@FXML
	private TextField txtCognomeStudente;

	@FXML
	private Button btnCercaCorsi;

	@FXML
	private Button btnIscrivi;

	@FXML
	private TextArea txtAreaOutput;

	@FXML
	private Button btnReset;

	@FXML
	void doCercaCorsi(ActionEvent event) {

	}

	@FXML
	void doCercaIscrittiCorso(ActionEvent event) {

		this.txtAreaOutput.clear();
		this.txtAreaOutput.setText(model.elencoIscrittiCorso(this.corsoSelector.getValue()));

	}

	@FXML
	void doCompletaCampi(ActionEvent event) {

		this.txtNomeStudente.setText(model.getNomeFromMatricola(this.txtMatricola.getText()));
		this.txtCognomeStudente.setText(model.getCognomeFromMatricola(this.txtMatricola.getText()));

	}

	@FXML
	void doIscrivi(ActionEvent event) {

	}

	@FXML
	void doReset(ActionEvent event) {

	}

	@FXML
	void initialize() {
		assert corsoSelector != null : "fx:id=\"corsoSelector\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCompleta != null : "fx:id=\"btnCompleta\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtNomeStudente != null : "fx:id=\"txtNomeStudente\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtCognomeStudente != null : "fx:id=\"txtCognomeStudente\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtAreaOutput != null : "fx:id=\"txtAreaOutput\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

	}

	public void setModel(Model model) {
		this.model = model;
		this.corsoSelector.setItems(model.getCorsi());
		this.corsoSelector.getItems().add("");
		;
		this.corsoSelector.setValue("");
	}

}
