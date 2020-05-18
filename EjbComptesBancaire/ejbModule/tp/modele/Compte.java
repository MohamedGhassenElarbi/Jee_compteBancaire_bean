package tp.modele;

import java.sql.Date;

public class Compte {
private int idCompte;
private double solde;
private Date dateCreation;
private String proprietaire;
public Compte(int idCompte, double solde, Date dateCreation, String proprietaire) {
	super();
	this.idCompte = idCompte;
	this.solde = solde;
	this.dateCreation = dateCreation;
	this.proprietaire = proprietaire;
}
public Compte() {
	super();
}
public int getIdCompte() {
	return idCompte;
}
public void setIdCompte(int idCompte) {
	this.idCompte = idCompte;
}
public double getSolde() {
	return solde;
}
public void setSolde(double solde) {
	this.solde = solde;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
public String getProprietaire() {
	return proprietaire;
}
public void setProprietaire(String proprietaire) {
	this.proprietaire = proprietaire;
}

}
