package tp.ejbCompte;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import tp.modele.Compte;

/**
 * Session Bean implementation class EjbComptesBancaires
 */
@Stateless
@LocalBean
public class EjbComptesBancaires implements EjbComptesBancairesLocal {
	private Connection maconnexion=ConnexionBD.getConnection();
    /**
     * Default constructor. 
     */
    public EjbComptesBancaires() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouterCompte(Compte c) {
		// TODO Auto-generated method stub
		try {
			
			PreparedStatement statement=maconnexion.prepareStatement("Insert into compte(idCompte,solde,dateCreation,proprietaire)values(?,?,?,?)");
		
			statement.setInt(1, c.getIdCompte());
			statement.setDouble(2, c.getSolde());
			statement.setDate(3, (Date) c.getDateCreation());
			statement.setString(4, c.getProprietaire());
			statement.executeUpdate();
			statement.close();
			System.out.println("operation d'ajout effectuee avec succes");
			
		}catch(SQLException e1) {e1.printStackTrace();}
		
	}

	@Override
	public Compte rechercherCompte(int idCompteR) {
		// TODO Auto-generated method stub
		Compte c=null;
		try {
			
			PreparedStatement statement=maconnexion.prepareStatement("Select idCompte,solde,dateCreation,proprietaire from compte where idCompte="+idCompteR+";");
			ResultSet res=statement.executeQuery();
			while(res.next()) {
				c=new Compte();
				c.setIdCompte(res.getInt(1));
				c.setSolde(res.getDouble(2));
				c.setDateCreation(res.getDate(3));
				c.setProprietaire(res.getString(4));
				
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
			
		
		}
		return c;
	}

	@Override
	public void deposer(int idCompte, double montant) {
		// TODO Auto-generated method stub
		try {
			Double montantCourant;
			Compte c ;
			c=rechercherCompte(idCompte);
			montantCourant=c.getSolde();
			
			PreparedStatement statement=maconnexion.prepareStatement("update  compte set solde=? where idCompte="+ idCompte+";");
			statement.setDouble(1, montantCourant+montant);
			statement.executeUpdate();
			statement.close();
			System.out.println("operation de Virement effectuee avec succes");
			
		}catch(SQLException e1) {e1.printStackTrace();}

		
	}

	@Override
	public void retirer(int idCompte, double montant) {
		// TODO Auto-generated method stub
try {
			Double montantCourant;
			Compte c ;
			c=rechercherCompte(idCompte);
			montantCourant=c.getSolde();
			
			PreparedStatement statement=maconnexion.prepareStatement("update  compte set solde=? where idCompte="+ idCompte+";");
			statement.setDouble(1, montantCourant-montant);
			statement.executeUpdate();
			statement.close();
			System.out.println("operation de retrait effectuee avec succes");
			
		}catch(SQLException e1) {e1.printStackTrace();}
		
	}

	@Override
	public List<Compte> listerComptes() {
		// TODO Auto-generated method stub
		List<Compte>l=new ArrayList<Compte>();
		Compte c;
		try {
			
			PreparedStatement statement=maconnexion.prepareStatement("Select idCompte,solde,dateCreation,proprietaire from compte");
			ResultSet res=statement.executeQuery();
			while(res.next()) {
				c=new Compte();
				c.setIdCompte(res.getInt(1));
				c.setSolde(res.getDouble(2));
				c.setDateCreation(res.getDate(3));
				c.setProprietaire(res.getString(4));
				l.add(c);
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
			l=null;
		}
		return l;
	}

	@Override
	public boolean supprimerCompte(int idCompteS) {
		// TODO Auto-generated method stub
try {
			
			PreparedStatement statement=maconnexion.prepareStatement("Delete from compte where idCompte="+idCompteS +";");
			statement.executeUpdate();
			statement.close();
			System.out.println("operation de suppression effectuee avec succes");
			
		}catch(SQLException e1) {e1.printStackTrace();
		return false;}
	return true;
	}
}
