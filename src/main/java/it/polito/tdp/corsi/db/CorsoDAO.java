package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Corso;



public class CorsoDAO {
	
	//CRUD ma sti cazzi, mi serve solo il read
	
	/**
	 * metodo che ritorna una lista di corsi con un certo periodo didattico
	 * @param p periodo didattico
	 * @return lista di corsi
	 */
	public List<Corso> listCorsiPd(int p){
		
		//String jbdcURL = "jdbc:mariadb://localhost/librettovoti?user=root&password=Armadio2005.";
		
		try {
			Connection conn =  DBConnect.getConnection();
			
			Statement st = conn.createStatement();
			
			String sql = "SELECT * FROM corso";
			
			ResultSet res = st.executeQuery(sql);
			
			List<Corso> corsi = new ArrayList<>();
			
			while(res.next()) {
				String codins = res.getString("codins");
				int crediti = res.getInt("crediti");
				//LocalDate data = res.getDate("data").toLocalDate();
				String nome = res.getString("nome");
				int pd = res.getInt("pd");
				
				if(pd==p) {
					Corso co  = new Corso(codins, crediti, nome, pd);
					corsi.add(co);
				}
				
			}
			
			//System.out.println(voti.toString());
			conn.close();
			return corsi;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;  
		}
	}
	

}
