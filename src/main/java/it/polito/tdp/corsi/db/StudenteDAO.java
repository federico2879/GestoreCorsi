package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Studente;

public class StudenteDAO {
	
	public int numeroStudentiPd(int pd) {
		
		try {
			Connection conn = DBConnect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT matricola FROM iscrizione, corso WHERE iscrizione.codins=corso.codins AND corso.pd = ?");
			
			st.setInt(1, pd);
			
			List<String> matricoleStudenti = new ArrayList<String>();
			
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				matricoleStudenti.add(res.getString(1));
			}
			
		
			
			conn.close();
			return matricoleStudenti.size();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}}
	
	public List<Studente> studentiPerCorso(String corso){
		
		List <Studente> studentiCorso = new ArrayList<Studente>();

		try {
		Connection conn = DBConnect.getConnection();
		
		PreparedStatement st = conn.prepareStatement("SELECT studente.matricola, cognome, nome, CDS FROM studente, iscrizione WHERE iscrizione.matricola=studente.matricola AND iscrizione.codins = ?");
		
		st.setString(1, corso);
				
		ResultSet res = st.executeQuery();
		
		while(res.next()) {
			Studente nuovo = new Studente(res.getString(1), res.getString(2), res.getString(3), res.getString(4));
		
			studentiCorso.add(nuovo);}
			
		conn.close();
		return studentiCorso;
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return studentiCorso;
		
	}
		
	

}
