/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;


public class Livre extends Document {
    //chaque livre sont associés, en plus, 
    //un nombre de pages, un type et un tome.
    String[] associes;
    int nbPage;
    private String type;
    int tome;
    public Livre(String ISBN, String titre, String[] auteurs, String editeur, int anneeEdition, int nbExemp,int nbPage,String type,int tome) {
        super(ISBN, titre, auteurs, editeur, anneeEdition, nbExemp);
        this.nbPage=nbPage;
        this.tome=tome;
        this.type=type;
    }
    
    public String getType(){
        return this.type;
    }
    
    public void setType(String type){
        this.type=type;
    }
    
    @Override
    public String toString(){
//        String assoc="";
//        for (String associe : associes) {
//            assoc = assoc + associe;
//        }
        return super.toString()+" nombre de pages est : "+nbPage+" type: "+type+" tomes: "+tome;
    }
}
