package tp.ejbCompte;

import java.util.List;

import javax.ejb.Local;

import tp.modele.Compte;

@Local
public interface EjbComptesBancairesLocal {
	public void ajouterCompte(Compte c);
	public Compte rechercherCompte(int idCompteR);
	public void deposer(int idCompte ,double montant);
	public void retirer(int idCompte ,double montant);
	public List<Compte> listerComptes();
	public boolean supprimerCompte(int idCompteS);

}
