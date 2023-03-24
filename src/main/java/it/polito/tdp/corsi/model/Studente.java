package it.polito.tdp.corsi.model;

public class Studente implements Comparable<Studente>{
	
	private String matricola;
	private String cognome;
	private String nome;
	private String cds;
	
	public Studente(String matricola, String cognome, String nome, String cds) {
		super();
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.cds = cds;
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

	public String getCds() {
		return cds;
	}

	public void setCds(String cds) {
		this.cds = cds;
	}

	@Override
	public String toString() {
		return this.matricola+", "+this.cognome+", "+this.nome+", "+this.cds;
	}

	@Override
	public int compareTo(Studente o) {
		// TODO Auto-generated method stub
		return this.cds.compareTo(o.cds);
	}
	
	

}
