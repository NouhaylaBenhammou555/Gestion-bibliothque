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
public class Etudiant extends Personne {
    
    String filiere;
    String classe;
    int nbLivre=0;
    private String cne;
    
    public Etudiant(String cne,String nom, String prenom, String adresse, int age, String cin,String classe,String filiere) {
        super(nom, prenom, adresse, age, cin);
        this.filiere=filiere;
        this.classe=classe;
        this.cne=cne;
    }
    
    public String getCne(){
        return this.cne;
    }
    
    public void setCne(String cne){
        this.cne=cne;
    }

    @Override
    public void emprunter(Document d) {
        if(nbDoc<=3){
            System.out.println("Vous pouvez emprunter");
            doc[nbDoc]=d;
            nbDoc++;
        }
        else{
            System.out.println("Vous ne pouvez pas emprunter");
        }
    }
}
