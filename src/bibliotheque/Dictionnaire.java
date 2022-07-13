/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

public class Dictionnaire extends Document{
    String langue;
    int nbTomes;
    
    public Dictionnaire(String ISBN, String titre, String[] auteurs, String editeur, int anneeEdition, int nbExemp,String langue,int nbTomes) {
        super(ISBN, titre, auteurs, editeur, anneeEdition, nbExemp);
        this.langue=langue;
        this.nbTomes=nbTomes;
    }
    
    @Override
    public String toString(){
        return super.toString()+" langue : "+langue+" nombre de tomes: "+nbTomes;
    }
}
