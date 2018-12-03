/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;
    
    HashSet<Plongeur> mlPlongeur = new HashSet();

    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
         // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");	    
        mlPlongeur.add(participant);
    }

    public Calendar getDate() {
        return date;
    }

    public boolean estConforme() {
         // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        
        for (Plongeur pl: mlPlongeur){
            
        if (!pl.getLicence().estValide(date)){
            return false;
        }
    }
        return true;  
                
    }

}
