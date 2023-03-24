/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.corsi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.StudenteDAO;
import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtPeriodo"
    private TextField txtPeriodo; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorso"
    private TextField txtCorso; // Value injected by FXMLLoader

    @FXML // fx:id="btnCorsiPerPeriodo"
    private Button btnCorsiPerPeriodo; // Value injected by FXMLLoader

    @FXML // fx:id="btnNumeroStudenti"
    private Button btnNumeroStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="btnStudenti"
    private Button btnStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="btnDivisioneStudenti"
    private Button btnDivisioneStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML
    void corsiPerPeriodo(ActionEvent event) {
    	
    	CorsoDAO daoC = new CorsoDAO();
    	//int prova = this.txtPeriodo.getText()
    	List<Corso> corsi = daoC.listCorsiPd(Integer.parseInt(""+this.txtPeriodo.getText()));
    	this.txtRisultato.setText(model.stampaCorsi(corsi));
    	
    }

    @FXML
    void numeroStudenti(ActionEvent event) {
    	
    	StudenteDAO daoS = new StudenteDAO();
    	this.txtRisultato.setText(""+daoS.numeroStudentiPd(Integer.parseInt(""+this.txtPeriodo.getText())));
    	
    }

    @FXML
    void stampaDivisione(ActionEvent event) {
    	
    	StudenteDAO daoS = new StudenteDAO();
    	String corso = this.txtCorso.getText();
    	this.txtRisultato.setText(model.stampaStudenti(model.distinguiCDS(daoS.studentiPerCorso(corso))));
    	

    }

    @FXML
    void stampaStudenti(ActionEvent event) {
    	
    	StudenteDAO daoS = new StudenteDAO();
    	String corso = this.txtCorso.getText();
    	this.txtRisultato.setText(model.stampaStudenti(daoS.studentiPerCorso(corso)));
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCorsiPerPeriodo != null : "fx:id=\"btnCorsiPerPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnNumeroStudenti != null : "fx:id=\"btnNumeroStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnStudenti != null : "fx:id=\"btnStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDivisioneStudenti != null : "fx:id=\"btnDivisioneStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
    
    
}