package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	

	public ArrayList<Studente> getElencoStudenti() {

		final String sql = "SELECT cognome, nome, CDS, matricola FROM studente";
		ArrayList<Studente> elencostudenti = new ArrayList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String codins = rs.getString("CDS");
				String matricola = Integer.toString(rs.getInt("matricola"));

				System.out.println(nome + " " + cognome + " " + matricola);

				Studente nuovo = new Studente(matricola, cognome, nome, codins);
				elencostudenti.add(nuovo);

			}

			return elencostudenti;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

}
