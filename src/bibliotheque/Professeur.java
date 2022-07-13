/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

/**
 *
 * @author Manal
 */
public class Professeur extends Personne {
    
    String specialite;
    int nbLivre=0;

    public Professeur(String nom, String prenom, String adresse, int age, String cin,String specialite) {
        super(nom, prenom, adresse, age, cin);
        this.specialite=specialite;
    }

    
    @Override
    public void emprunter(Document d) {
        if(nbDoc<=5){
            System.out.println("Vous pouvez emprunter");
            doc[nbDoc]=d;
            nbDoc++;
        }
        else{
            System.out.println("Vous ne pouvez pas emprunter");
        }
    }
}
