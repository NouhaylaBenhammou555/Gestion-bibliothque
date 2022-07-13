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

public class Bibliotheque {

    Document[] listeDocuments;
    Personne[] listeEmprunteurs;
    
    int posDoc ;
    int capaciteDoc ;
    int posEmp;
    int capaciteEmp;
    
    
    public Bibliotheque(int maxDoc,int maxEmp){
        posDoc=-1 ;
        capaciteDoc=maxDoc ;
        posEmp=-1 ;
        capaciteEmp=maxEmp ;
        this.listeDocuments=new Document[maxDoc];
        this.listeEmprunteurs=new Personne[maxEmp];
    }
    
    @Override
    public String toString(){
        
        return "Cette bibliotheque contient "+listeDocuments.length+Arrays.toString(listeDocuments)+" documents et "+listeEmprunteurs.length+" emprunteurs"+Arrays.toString(listeDocuments);
    }
    
//4. Définissez les méthodes suivantes :
    //Document[] getDocumentsByEditeur(String Editeur){
    public Document[] getDocumentsByEditeur(String Editeur){
        Document[] docEdt=new Document[this.capaciteDoc];
        int ps=-1;
        for(int i=0;i<this.capaciteDoc;i++){
            if(this.listeDocuments[i].getEditeur().equals(Editeur)){
                ps++;
                docEdt[ps]=this.listeDocuments[i];
            }
        }
        return docEdt;
    }
    //Document getDocumentsbyISBN(String isbn)
    public Document[] getDocumentsbyISBN(String isbn){
        Document[] docEdt=new Document[this.capaciteDoc];
        int ps=-1;
        for(int i=0;i<this.capaciteDoc;i++){
            if(this.listeDocuments[i].getISBN().equals(isbn)){
                ps++;
                docEdt[ps]=this.listeDocuments[i];
            }
        }
        return docEdt;
    }
    //Document[] getDocumentsByAuteur(String auteur)
    public Document[] getDocumentsByAuteur(String auteur){
        Document[] docEdt=new Document[this.capaciteDoc];
        int ps=-1;
        for(int i=0;i<this.capaciteDoc;i++){
            for(int j=0;j<5;j++){
                if(this.listeDocuments[i].getAuteurs()[j].equals(auteur)){
                    ps++;
                    docEdt[ps]=this.listeDocuments[i];
                    break;
                }
            }
        }
        return docEdt;
    }
    //Document[] getDocumentsByTitre(String titre)
    public Document[] getDocumentsByTitre(String titre){
        Document[] docEdt=new Document[this.capaciteDoc];
        int ps=-1;
        for(int i=0;i<this.capaciteDoc;i++){
            if(this.listeDocuments[i].getTitre().equals(titre)){
                ps++;
                docEdt[ps]=this.listeDocuments[i];
            }
        }
        return docEdt;
    }
    //Etudiant getEtudiantByCne(String cne)
    public Etudiant getEtudiantByCne(String cne){
        
        for(int i=0;i<this.capaciteEmp;i++){
            if(this.listeEmprunteurs[i] instanceof Etudiant){
                Etudiant etd=(Etudiant)this.listeEmprunteurs[i];
                if(etd.getCne().equals(cne)){
                    return etd;
                }
                
            }
        }
        return null;
    }
    //Professeur getProfesseurByCin(String cin)
    public Professeur getProfesseurByCin(String cin){
        for(int i=0;i<this.capaciteEmp;i++){
            if(this.listeEmprunteurs[i] instanceof Professeur){
                Professeur prof=(Professeur)this.listeEmprunteurs[i];
                if(prof.getCin().equals(cin)){
                    return prof;
                }
                
            }
        }
        return null;
    }
    //booleanSupprimerDocument(String titre)
    public boolean SupprimerDocument(String titre){
        for(int i=0;i<this.capaciteDoc;i++){
            if(this.listeDocuments[i].getTitre().equals(titre)){
                this.listeDocuments[i]=null;
                return true;
            }
        }
        return false;
    }
    //booleanSupprimerEtudiant(String cne)
    public boolean SupprimerEtudiant(String cne){
        for(int i=0;i<this.capaciteEmp;i++){
            if(this.listeEmprunteurs[i] instanceof Etudiant){
                Etudiant etd=(Etudiant)this.listeEmprunteurs[i];
                if(etd.getCne().equals(cne)){
                    this.listeEmprunteurs[i]=null;
                    return true;
                }
            }
        }
        return false;
    }
    //booleanSupprimerProfesseur(String cin)
    public boolean SupprimerProfesseur(String cin){
        for(int i=0;i<this.capaciteEmp;i++){
            if(this.listeEmprunteurs[i] instanceof Professeur){
                Professeur prof=(Professeur)this.listeEmprunteurs[i];
                if(prof.getCin().equals(cin)){
                    this.listeEmprunteurs[i]=null;
                    return true;
                }
            }
        }
        return false;
    }
    //booleanAjouterDocument(Document d)
    public boolean AjouterDocument(Document d){
        for(int i=0;i<this.capaciteDoc;i++){
            if(this.listeDocuments[i]==null){
                this.listeDocuments[i]=d;
                return true;
            }
        }
        return false;
    }
    public boolean AjouterAdherent(Personne p){
        for(int i=0;i<this.capaciteEmp;i++){
            if(this.listeEmprunteurs[i]==null){
                if(p instanceof Etudiant){
                    this.listeEmprunteurs[i]=(Etudiant)p;
                }
                if(p instanceof Professeur){
                    this.listeEmprunteurs[i]=(Professeur)p;
                }
                if(p instanceof Personne){
                    this.listeEmprunteurs[i]=p;
                }
                return true;
            }
        }
        return false;
    }
    //Document[] TrierAnneeAsc()
    public Document[] TrierAnneeAsc(){
        Document[] docTrAs=this.listeDocuments;
        Arrays.sort(docTrAs);
        return docTrAs;
    }
    //Document[] TrierAnneeDesc()
    public Document[] TrierAnneeDesc(){
        Document[] docTrDs=this.listeDocuments;
        for(int i=0;i<this.capaciteDoc;i++){
            for(int j=i+1;j<this.capaciteDoc;j++){
                if(docTrDs[i].getAnneeEdition()<docTrDs[j].getAnneeEdition()){
                    Document d=docTrDs[i];
                    docTrDs[i]=docTrDs[j];
                    docTrDs[j]=d;
                }
            }
        }
        return docTrDs;
    }
    public Livre[] getLivrebyType(String type){
        Livre[] lv=new Livre[this.capaciteDoc];
        int ps=-1;
        for(int i=0;i<this.capaciteDoc;i++){
            if(this.listeDocuments[i] instanceof Livre){
                Livre l=(Livre)this.listeDocuments[i];
                if(l.getType().equals(type)){
                    ps++;
                    lv[ps]=l;
                }
            }
        }
        return lv;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Bibliotheque biblio1=new Bibliotheque(2,2);
        Livre L=new Livre("isbn122232e", "livre Compliquee", new String[] {"x","y","z","a","b"}, "guigui", 1998, 3,300,"dramatique",6465);
        Etudiant p=new Etudiant("r132435476","sarane", "sara", "casablanca hay el anouar rue 15", 21, "Br3423","classe 1","iwim");
        if(biblio1.AjouterAdherent(p)){
            System.out.println("Cette personne "+p.toString()+" est ajoutee");
        }
        if(biblio1.AjouterDocument(L)){
            System.out.println("Ce document "+L.toString()+" est ajoute");
        }
    }
    
}
