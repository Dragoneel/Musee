package musee;

import musee.etatDemande.EtatDemande;
import java.util.ArrayList;
import java.util.Vector;
import static musee.Departement.indicePosition;
import musee.etatDemande.EtatNonPrisEnCharge;

/**
 *
 * @author yirou
 */
public class Musee {
//nom du musée

    String nomMusee;
    //liste de departement disponible au musée
    public Vector listeDepartement=new Vector();
    public ArrayList<Demande> listeDemande=new ArrayList<>();
    public ArrayList<Photographe> listePhotoGraphe=new ArrayList<>();
    public ArrayList<Historien> listeHistorien=new ArrayList<>();

    public Musee(String nomMusee) {
        this.nomMusee = nomMusee;
        genereListeDepartement();
        initialiserHistorienEtPhotographe();
    }

    /**
     * ***************les accesseurs *************************
     */
    public void setListeDepartement(Vector listeDepartement) {
        this.listeDepartement = listeDepartement;
    }

    public Vector getListeDepartement() {
        return listeDepartement;
    }

    public ArrayList<Demande> getListeDemande() {
        return listeDemande;
    }

    public void setListeDemande(ArrayList<Demande> listeDemande) {
        this.listeDemande = listeDemande;
    }

    public Demande creerDemande(int idDem, String nom, String descr,int idHist,int idPho) {
        return new Demande(idDem, nom, descr, idHist, idPho, null);
    }

    public void supprimerDemande(int idDemande) {
        Demande temp;
        for (int i = 0; i < listeDemande.size(); i++) {
            temp = listeDemande.get(i);
            if (temp.getIdDemande() == idDemande) {
                listeDemande.remove(i);
                break;
            }
        }
    }

    public void prendreEnChargeDemande(Demande d) {
        d.setEtat(new EtatNonPrisEnCharge(d));
    }

    public String getNomMusee() {
        return nomMusee;
    }

    public void setNomMusee(String nomMusee) {
        this.nomMusee = nomMusee;
    }

    //chercher une oeuvre dans un departement
    public Oeuvre ChercherOeuvre(int departement, Vector v) {
        for (int i = indicePosition; i < v.size(); i++) {
            Oeuvre oeuvre = (Oeuvre) v.elementAt(indicePosition);
            if (oeuvre.getDepartement() == departement) {
                indicePosition++;
                return oeuvre;

            }
        }

        return null;
    }

    public void ChercherOeuvre(String name) {

    }

//    public Demande seDesengager() {
//        return d.seDesengager(d);
//    }

    public double calculChemin() {
        return 0;
    }

    public ArrayList<Historien> getListeHistorien() {
        return listeHistorien;
    }

    public ArrayList<Photographe> getListePhotoGraphe() {
        return listePhotoGraphe;
    }

    public void setListeHistorien(ArrayList<Historien> listeHistorien) {
        this.listeHistorien = listeHistorien;
    }

    public void setListePhotoGraphe(ArrayList<Photographe> listePhotoGraphe) {
        this.listePhotoGraphe = listePhotoGraphe;
    }

    public void ChercherOeuvres(int idDepartement) {

    }

    //chercher une demande par apport à sa positon dans une liste
    public Demande chercherDemande(ArrayList v, int position) {

        for (int i = 0; i < v.size(); i++) {
            if (i == position) {
                return ((Demande) v.get(i));

            }
        }
        return null;
    }

    //chercher la position d'une demande dans une liste par apport à son id
    public int chercherIdDemande(ArrayList v, int idDemande) {
        Demande temp;
        for (int i = 0; i < v.size(); i++) {
            temp = (Demande) v.get(i);
            if (temp.getIdDemande() == idDemande) {
                return i;
            }
        }
        return -1;
    }
    
  
    //generer la liste de departement dans le musee
    public void genereListeDepartement() {

        listeDepartement.add(new Departement(1, "Histoire ancienne"));
        listeDepartement.add(new Departement(2, "Art contemporain"));
        listeDepartement.add(new Departement(3, "Tableau grec"));
        listeDepartement.add(new Departement(4, "Egypte antique"));
        listeDepartement.add(new Departement(5, "Peinture"));
    }

    public void initialiserHistorienEtPhotographe() {
        
        Historien his1 = new Historien(1, "Hollande", "Historien");
        Historien his2 = new Historien(2, "Hubert", "Historien");
        this.listeHistorien.add(his1);
        this.listeHistorien.add(his2);
        Photographe pho1 = new Photographe(1, "Philippe", "Photographe");
        Photographe pho2 = new Photographe(2, "Pierre", "Photographe");
        this.listePhotoGraphe.add(pho1);
        this.listePhotoGraphe.add(pho2);
    }

}
