/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

import java.util.Arrays;

/**
 *
 * @author Manal
 */
public class Document {
    
    public Document(String ISBN, String titre, String[] auteurs, String editeur, int anneeEdition, int nbExemp){
        this.ISBN=ISBN;
        this.titre=titre;
        this.auteurs = java.util.Arrays.copyOf(auteurs, auteurs.length);
        this.editeur=editeur;
        this.anneeEdition=anneeEdition;
        this.nbExemp=nbExemp;
        this.numEnrg=nbDoc;
        nbDoc++;
    }
    private int numEnrg;
    private final String ISBN;   
    private String titre;
    private String[] auteurs = new String[5];
    private String editeur;
    private int anneeEdition;
    private int nbExemp;
    private static int nbDoc=0;
//    
////    public void setISBN(String ISBN){
////        this.ISBN=ISBN;
////    }
    public String getISBN(){
        return this.ISBN;
    }
    public void setTitre(String titre){
        this.titre=titre;
    }
    public String getTitre(){
        return this.titre;
    }
    public void setAuteurs(String[] auteurs){
        this.auteurs = java.util.Arrays.copyOf(auteurs, auteurs.length);
    }
    public String[] getAuteurs(){
        return this.auteurs;
    }
    public void setEditeur(String editeur){
        this.editeur=editeur;
    }
    public String getEditeur(){
        return this.editeur;
    }
    public void setAnneeEdition(int anneeEdition){
        this.anneeEdition=anneeEdition;
    }
    public int getAnneeEdition(){
        return this.anneeEdition;
    }
    public void setNbExemp(int nbExemp){
        this.nbExemp=nbExemp;
    }
    public int getNbExemp(){
        return this.nbExemp;
    }
    public int getNumEnrg(){
        return this.numEnrg;
    }
    public String toString(){
        return "Document numero: "+this.getNumEnrg()+" ,titre : "+this.getTitre()+" , editeur : "+this.getEditeur()+" , nombre exemplaires : "+this.nbExemp+" , annee edition : "+ this.anneeEdition+" , ISBN : "+this.ISBN+"Les auteurs : "+Arrays.toString(auteurs);
    }
    public void incrementerNbExemp(){
        this.nbExemp++;
    }
    public void decrementerNbExemp(){
        this.nbExemp--;
    }
    @Override
    public void finalize(){
        //this.toString();//<=>this
        System.out.println("L'objet est detruit"+this);
        
    }
    public static void main(String[] args){
        //String[] auteurs= {"a","b","c","d","e"};
        Document d=new Document("3436", "Sofies verden", new String[] {"a","b","c","d","e"}, "Jostein Gaarder", 1991, 123);
        System.out.println(d.toString());
    }
}
