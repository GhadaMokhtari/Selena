/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.Calendar;
//import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Personne {

    public int numeroDiplome;
    
    //List<Club> mlClub =new LinkedList();
    List<Embauche> mlEmbauche = new LinkedList();
    
    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
    }

    public Club employeur() {
         // TODO: Implémenter cette méthode
        Embauche monEmbauche= mlEmbauche.get(mlEmbauche.size()-1);
        if (monEmbauche.estTerminee()){
            return null;
        }
        else{ 
            return monEmbauche.getEmployeur();
        }
    }
    
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {   
         // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");	    
        Embauche e = new Embauche(debutNouvelle, this, employeur);
        mlEmbauche.add(e);
    }

    public List<Embauche> emplois() {
         // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        return mlEmbauche;
    }

}
