/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.Club;
import FFSSM.Embauche;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;


/**
 *
 * @author infoo
 */
public class FFSSMTest {
    Club leClub;
    Calendar c1, c2,c3,c4,c5,c6,c7,c8,c9;
    Moniteur m;
    Plongee p, p2;
    Site Alger;
    Licence l, l2;
    Plongeur pl,pl2;
    Embauche e;
/*
 Moi Mohamet KONE j'ai cloné le projet de Ghada   
 */

   @Before
    public void setUp() {

        Alger = new Site("Alger","blabla");
        
        c1 = Calendar.getInstance();
            	c1.set(1994,11,29);
                
        m= new Moniteur("055875", "MOKHTARI", "Rayan", "Hay bensouna Chlef", "telephone",c1 , 1);

        leClub = new Club(m, "WOC", "0556465181");
       
         c2 = Calendar.getInstance();
                 c2.set(2018,10,24);

        p= new Plongee(Alger, m, c2, 30, 4);

        c3 = Calendar.getInstance();
            	c3.set(1999,07,12);

        pl= new Plongeur("25689", "MOKHTARI", "Rania", "Hay Bensouna Chlef","telephone" , c3, 2);

        c4 = Calendar.getInstance();
            	c4.set(2017,12,12);

        l = new Licence(pl, "numero", c4, 2, leClub);

        c5 = Calendar.getInstance();
            	c5.set(2000,12,24);

        pl2 = new Plongeur("numéro2", "MOKHTARI", "Hamid", "Hay Bensouna", "TEL", c5, 1);

        c6 = Calendar.getInstance();
            	c6.set(2016,12,24);

        l2 = new Licence(pl2, "num1", c6, 1, leClub);

        c7 = Calendar.getInstance();
            	c7.set(2017,02,24);

        p2 = new Plongee(Alger, m, c7, 20, 30);
        
        c8 = Calendar.getInstance();
            	c8.set(2016,02,24);
        
        e = new Embauche(c8, m, leClub);
        
         c9 = Calendar.getInstance();
            	c9.set(2018,12,24);

    }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testAjoutLicence(){
        pl.ajouteLicence(l);
        //assertEquals(pl.mlLicence.size(), 1);
        System.out.println("RES: "+l);
        assertSame(pl.getLicence(),l);
    }
    @Test
    public void testEstValide(){
        //l.delivrance=c4;
        assertSame(l.estValide(c2), true);
    }

    @Test
    public void testPlongeeNonConforme(){
         pl.ajouteLicence(l);
         pl2.ajouteLicence(l2);
         
         p.ajouteParticipant(pl);
         p.ajouteParticipant(pl2);
         
         p2.ajouteParticipant(pl);
         
         leClub.organisePlongee(p);
         leClub.organisePlongee(p2);
         
         System.out.println("p "+p.estConforme()+" p2 "+p2.estConforme());
         
         System.out.println("taille "+leClub.plongeesNonConformes());
         
         assertEquals(leClub.plongeesNonConformes().size(),1);

    }

    @Test
    public void testOrganisePlongee(){
     leClub.organisePlongee(p2);
    }

    @Test
    public void testAjoutParticipant(){
        p.ajouteParticipant(pl);
    }

    @Test
     public void testEstConforme(){
         pl.ajouteLicence(l);
         pl2.ajouteLicence(l2);
         
         p.ajouteParticipant(pl);
         p.ajouteParticipant(pl2);

         assertFalse(p.estConforme());
    }

    @Test
     public void testNouvelleEmbauche(){
        m.nouvelleEmbauche(leClub, c8);
    }
     
     @Test
     public void testEmployeur(){
         
        m.nouvelleEmbauche(leClub, c8);
        assertSame(leClub,m.employeur());
    }


    @Test
    public void testListeEmplois(){
        m.emplois();
    }
    @Test
    public void testEmbaucheEstTerminée(){
       e.terminer(c9);
        assertTrue(e.estTerminee());
       
    }
   
}
