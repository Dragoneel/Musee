package musee;

import java.util.Vector;

/**
 *
 * @author yirou
 */
public class Departement {

    int idDepartement;
    //id du departement
    String nomDepartement;
    //nom du departement
    Musee musee;
    //object Musee qui va interagir avec les departements
    public Vector<Oeuvre> listeOeuvre = new Vector<Oeuvre>();
    //liste d'oeuvre avec disponible dans les departements
    public static int indicePosition = 0;
    //la position lors du parcours des oeuvres

    //constructeur pour creer un departement
    public Departement(int idDepartement, String nomDepartement) {
        this.idDepartement = idDepartement;
        this.nomDepartement = nomDepartement;

    }

    /**
     * ***************** LES ACCESSEURS**********************************
     */
    public void setMusee(Musee musee) {
        this.musee = musee;
    }

    public Musee getMusee() {
        return musee;
    }

    public void setListeOeuvre(Vector listeOeuvre) {
        this.listeOeuvre = listeOeuvre;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public static void setIndicePosition(int indicePosition) {
        Departement.indicePosition = indicePosition;
    }

    public static int getIndicePosition() {
        return indicePosition;
    }

    public Vector getListeOeuvre() {
        return listeOeuvre;
    }

    public int getIdDepartement() {
        return idDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    //methode qui permet de récuperer une oeuvre dans un departement
    public Oeuvre getOeuvre(int departement, Vector v) {
        for (int i = indicePosition; i < v.size(); i++) {
            Oeuvre oeuvre = (Oeuvre) v.elementAt(indicePosition);
            if (oeuvre.getDepartement() == departement) {
                indicePosition++;
                return oeuvre;

            }
        }

        return null;
    }

    //supprimer une oeuvre dans un departement
    public void deleteOeuvre(int oeuvre) {
        Oeuvre temp;
        for (int i = 0; i < listeOeuvre.size(); i++) {
            temp = (Oeuvre) listeOeuvre.elementAt(i);
            if (temp.getIdOeuvre() == oeuvre) {
                listeOeuvre.removeElementAt(i);
                break;
            }
        }
    }

    //methode permettant d'avoir une oeuvre suivante  à partir de la position de l'indice de parcours
    public Oeuvre getOeuvreSuivante(Vector v) {
        if (v.size() > 0 && indicePosition < v.size() + 1) {
            Oeuvre oeuvre = (Oeuvre) v.elementAt(indicePosition + 1);
            indicePosition++;
            return oeuvre;
        }
        return null;

    }

    //methode pour avoir l'oeuvre precedante à partir de la position de l'indice
    public Oeuvre getOeuvrePrecendante(Vector v) {
        if (v.size() > 0 && indicePosition > 0) {
            Oeuvre oeuvre = (Oeuvre) v.elementAt(indicePosition - 1);
            indicePosition--;
            return oeuvre;
        }
        return null;
    }

    //methode pour avoir l'id d'un departement à travers une recherche
    public int getIdDep(String departement, Vector v) {

        for (int i = 0; i < v.size(); i++) {

            Departement temp = (Departement) v.elementAt(i);

            if (departement.equalsIgnoreCase(temp.getNomDepartement())) {

                return temp.getIdDepartement();

            }
        }
        return 0;
    }

    
    //prévu dans l'incrément 2 mais plus utile
    public Oeuvre recherche(String nom) {
        return null;

    }

   
    public boolean oeuvreExiste(String nom) {
        if (recherche(nom) != null) {
            return true;
        }
        return false;
    }

    //test si un departement existe
    public boolean departementExiste(String nom) {
        if (getIdDep(nom, musee.listeDepartement) == 0) {
            return false;
        }
        return true;
    }

    //consulter un departement
    public Oeuvre consulter(Departement d) {
        return getOeuvre(d.getIdDepartement(), musee.listeDepartement);
    }

    //methode pour generer des oeuvres
    public void genereOeuvreManuelement() {
        listeOeuvre = new Vector();
        listeOeuvre.add(new Oeuvre(1, "Peinture grec", "img/peinture/grec1.jpg", "Grec1", 1));
        listeOeuvre.add(new Oeuvre(2, "Peinture grec2", "img/peinture/grec2.jpg", "Grec2", 1));
        listeOeuvre.add(new Oeuvre(3, "Peinture grec2", "img/peinture/grec3.jpg", "Grec3", 1));
        listeOeuvre.add(new Oeuvre(4, "Peinture egypte", "img/egypte/egypte1.jpg", "egypte1", 2));
        listeOeuvre.add(new Oeuvre(5, "Machin", "img/autre/ChefsDoeuvre1.jpg", "machin", 4));
        listeOeuvre.add(new Oeuvre(6, "Peinture grec2", "img/autre/africa.jpg", "Peinture Africaine", 4));
        listeOeuvre.add(new Oeuvre(7, "Peinture grec2", "img/autre/afrika.jpg", "Peinture Africaine", 4));
        listeOeuvre.add(new Oeuvre(8, "Hercule", "img/autre/hercule.jpg", "Le graal", 4));
        listeOeuvre.add(new Oeuvre(9, "Le clown", "img/autre/leclown.jpg", "Le clown", 4));
        listeOeuvre.add(new Oeuvre(10, "Peinture grec2", "img/autre/hollande.jpg", "Peinture hollande", 4));
        listeOeuvre.add(new Oeuvre(11, "les sims", "img/autre/les_sims.jpg", "les sims", 4));
        listeOeuvre.add(new Oeuvre(12, "Joconde", "img/joconde/j1.jpg", "Joconde", 3));
        listeOeuvre.add(new Oeuvre(13, "Joconde", "img/joconde/joconde.jpg", "la Joconde", 3));
        listeOeuvre.add(new Oeuvre(14, "Joconde", "img/joconde/joconde.png", "Joconde", 3));
        listeOeuvre.add(new Oeuvre(15, "Joconde", "img/joconde/joconderase.jpg", "Joconde", 3));
//        listeOeuvre.add(new Oeuvre(13, "/img/autre/img1", "machin", 4, null));
    }

}
