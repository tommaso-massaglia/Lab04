package it.polito.tdp.lab04.model;

import java.util.HashMap;
import java.util.Map;

import it.polito.tdp.lab04.DAO.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {

	Map<String, Corso> corsi;
	Map<String, Studente> studenti;

	public Model() {
		this.corsi = new HashMap<String, Corso>();
		this.studenti = new HashMap<String, Studente>();
	}

	public ObservableList<String> getCorsi() {

		ObservableList<String> elencocorsi = FXCollections.observableArrayList();

		if (corsi.isEmpty()) {
			CorsoDAO corsitemp = new CorsoDAO();
			for (Corso c : corsitemp.getTuttiICorsi())
				corsi.put(c.getCodins(), c);
		}
		for (Corso c : corsi.values()) {
			elencocorsi.add(c.getNome());
		}
		return elencocorsi;

	}

	public void setElencoStudenti() {

		if (studenti.isEmpty()) {
			StudenteDAO studentetemp = new StudenteDAO();
			for (Studente s : studentetemp.getElencoStudenti())
				studenti.put(s.getMatricola(), s);
		}

	}

	public String getNomeFromMatricola(String matricola) {
		this.setElencoStudenti();
		return studenti.get(matricola).getNome();
	}

	public String getCognomeFromMatricola(String matricola) {
		this.setElencoStudenti();
		return studenti.get(matricola).getCognome();
	}

	public String elencoIscrittiCorso(String nomecorso) {
		CorsoDAO corsitemp = new CorsoDAO();
		String elenco = "";
		this.setElencoStudenti();
		for (Corso c : corsi.values()) {
			if (c.getNome().equals(nomecorso)) {
				for (String s : corsitemp.getStudentiIscrittiAlCorso(c)) {
					elenco += studenti.get(s).toString() + "\n";
				}
			}

		}
		return elenco;
	}

}
