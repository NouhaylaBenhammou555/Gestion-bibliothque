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
public class Personne {
    String nom;
    String prenom;
    String adresse;
    int age;
    int nbEmp=1;
    private String cin;
    Document[] doc;
    int nbDoc=0;
    public Personne(String nom,String prenom,String adresse,int age,String cin){
        this.prenom=prenom;
        this.nom=nom;
        this.age=age;
        this.adresse=adresse;
        this.cin=cin;
        doc=new Document[5];
    }
    
    @Override
    public String toString(){
        return "nom : "+nom+"prenom : "+prenom+" adresse : "+adresse+" age : "+age+" cin : "+cin;
    }
    
    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin=cin;
    }
    
    public void emprunter(Document d){
        if(nbDoc<1){
            System.out.println("Vous pouvez emprunter");
            doc[0]=d;
            nbDoc++;
        }
        else{
            System.out.println("Vous ne pouvez pas emprunter");
        }
        
    }
}
