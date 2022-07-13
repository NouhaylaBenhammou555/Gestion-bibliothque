/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

public class Magazine extends Document {
    String periodicite;
    String mois;
    String jour;
    
    public Magazine(String ISBN, String titre, String[] auteurs, String editeur, int anneeEdition, int nbExemp,String periodicite,String mois,String jour) {
        super(ISBN, titre, auteurs, editeur, anneeEdition, nbExemp);
        this.periodicite=periodicite;
        this.mois=mois;
        this.jour=jour;
    }
    
    public String toString(){
        return super.toString()+" periodicite : "+periodicite+" mois: "+mois+" jour: "+jour;
    }
}
