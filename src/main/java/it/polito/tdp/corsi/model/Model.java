package it.polito.tdp.corsi.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
	
	private List<Corso> corsi;

	public String stampaCorsi(List<Corso> corsiDaStampare) {
		
		String ritorno ="";
		for(Corso c : corsiDaStampare) {
			if(ritorno.compareTo("")==0)
				ritorno+= c.toString();
			else
				ritorno= ritorno+"\n"+c.toString();
		}
			
		return ritorno;
	}
	
	public String stampaStudenti(List<Studente> studentiDaStampare) {
		
		String ritorno ="";
		for(Studente s : studentiDaStampare) {
			if(ritorno.compareTo("")==0)
				ritorno+= s.toString();
			else
				ritorno= ritorno+"\n"+s.toString();
		}
			
		return ritorno;
	}
	
	public List<Studente> distinguiCDS(List<Studente> studentiDaOrdinare){
		List<Studente> ordinati = new ArrayList<Studente>(studentiDaOrdinare);
		Collections.sort(ordinati);
		return ordinati;
	}
	
	
}
