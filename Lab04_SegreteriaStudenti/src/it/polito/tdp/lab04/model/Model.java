package it.polito.tdp.lab04.model;

import java.util.ArrayList;
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

	public String elencoCorsiIscritti(String matricola) {
		StudenteDAO studentetemp = new StudenteDAO();
		String elenco = "";
		this.setElencoStudenti();
		for (Studente s : studenti.values()) {
			if (s.getMatricola().equals(matricola)) {
				for (String c : studentetemp.getCorsiIscritto(s)) {
					elenco += corsi.get(c).toString() + "\n";
				}
			}

		}
		return elenco;
	}

	public boolean controllaIscritto(String matricola, String nomecorso) {

		if (this.elencoIscritti(nomecorso).contains(matricola)) {
			return true;
		}
		return false;
	}

	public ArrayList<String> elencoIscritti(String nomecorso) {
		CorsoDAO corsitemp = new CorsoDAO();
		ArrayList<String> elenco = new ArrayList<String>();
		this.setElencoStudenti();
		for (Corso c : corsi.values()) {
			if (c.getNome().equals(nomecorso)) {
				for (String s : corsitemp.getStudentiIscrittiAlCorso(c)) {
					elenco.add(s);
				}
			}

		}
		return elenco;
	}

	public void iscriviStudente(String matricola, String nomecorso) {
		StudenteDAO studentetemp = new StudenteDAO();
		for (Corso c : corsi.values()) {
			if (c.getNome().equals(nomecorso)) {
				if (corsi.containsKey(c.getCodins()) && studenti.containsKey(matricola)) {
					studentetemp.iscriviStudente(studenti.get(matricola), corsi.get(c.getCodins()));

					return ;
				}
			}

		}
		throw new NullPointerException("Studente o corso non esistenti");
	}

}
