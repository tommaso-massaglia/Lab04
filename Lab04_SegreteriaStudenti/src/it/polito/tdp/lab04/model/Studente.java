package it.polito.tdp.lab04.model;

public class Studente {

	String matricola = new String();
	String cognome = new String();
	String nome = new String();
	String corsodistudi = new String();

	public Studente(String matricola, String cognome, String nome, String corsodistudi) {
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.corsodistudi = corsodistudi;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCorsodistudi() {
		return corsodistudi;
	}

	public void setCorsodistudi(String corsodistudi) {
		this.corsodistudi = corsodistudi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", cognome=" + cognome + ", nome=" + nome + ", corsodistudi="
				+ corsodistudi + "]";
	}

}
