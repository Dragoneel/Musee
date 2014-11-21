package musee;

import java.util.Vector;

/**
 *
 * @author yirou
 */
public class Oeuvre {
    //auteur de l'oeuvre
    String auteur;
    //nom de l'oeurvre
    String nom;
    //id de l'oeuvre
    int idOeuvre;
    //url de l'image de l'oeuvre
    String adresseImage;
    //descroiption de l'oeuvre
    String description;
   
    //departement auquel appartient l'oeuvre
    int departement;
    

    public Oeuvre() {
    }

    public Oeuvre(int idOeuvre, String nom,String adresseImage, String description, int departement) {
        this.idOeuvre = idOeuvre;
        this.nom=nom;
        this.adresseImage = adresseImage;
        this.description = description;
        this.departement = departement;
        
    }

    /**************************acceusseur **************************************/
    public String getAdresseImage() {
        return adresseImage;
    }

   
    

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }



    public String getDescription() {
        return description;
    }

    public void setIdOeuvre(int idOeuvre) {
        this.idOeuvre = idOeuvre;
    }

    public void setDepartement(int departement) {
        this.departement = departement;
    }

    public int getDepartement() {
        return departement;
    }

    public int getIdOeuvre() {
        return idOeuvre;
    }

    public void setAdresseImage(String adresseImage) {
        this.adresseImage = adresseImage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
    public void consulter(Oeuvre v){
        System.out.println(v.getNom()+", "+v.getAdresseImage());
    }

    

    //test si une oeuvre existe ,permet de parcourir les oeuvres
    public boolean testSiOeuvreSuivantExiste(int positionActuelle, Vector v) {
        int taille = v.size();
        if (positionActuelle < taille) {
            return true;
        }
        return false;
    }
}
