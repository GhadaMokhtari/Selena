/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;

public class Club {

 
    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;
    
    Set<Plongee> mlPlongee = new HashSet();

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
    }

    public Set<Plongee> plongeesNonConformes() {
         // TODO: Implémenter cette méthode
       // throw new UnsupportedOperationException("Pas encore implémenté");
       Set<Plongee> mlPlongeeNC = new LinkedHashSet<>();
       
       for(Plongee p:mlPlongee){
           if (!p.estConforme())   
               mlPlongeeNC.add(p);
       }
       return mlPlongeeNC;
    }

    public void organisePlongee(Plongee p) {
         // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        mlPlongee.add(p);
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
