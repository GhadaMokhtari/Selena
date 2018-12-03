package FFSSM;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Plongeur extends Personne {
    public int niveau;
 public  List<Licence> mlLicence = new LinkedList();
    //private Licence licence;
    public Plongeur (String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance,int niv){
         super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        niv=niveau;
    }
    public void ajouteLicence(Licence l){
        mlLicence.add(l);
        //this.licence=l;
    }
    //retourner le dernier element 
    public Licence getLicence(){
        //return mlLicence;
        Licence m = mlLicence.get(mlLicence.size()-1);
        return m;
    }
}
