
package musee;

import musee.etatDemande.EtatDemande;
import musee.etatDemande.EtatNonPrisEnCharge;

/**
 *
 * @author yirou
 */
public class Demande {

    int idDemande;
    String nomDemande;
    String description;
   
    int idPhotographe;
    int idHistorien;
    Photo photoDeLaDemande;
    private EtatDemande etat;
    public Demande(int idDemande, String nomDemande, String description,int idHistorien,int idPhotographe,Photo photoDeLaDemande) {
        this.idDemande = idDemande;
        this.nomDemande = nomDemande;
        this.description = description;
        this.idHistorien=idHistorien;
        this.idPhotographe=idPhotographe;
        this.photoDeLaDemande=photoDeLaDemande;
        etat=new EtatNonPrisEnCharge(this);
    }

    public void setNomDemande(String nomDemande) {
        this.nomDemande = nomDemande;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
  
    
  
    public void seDesangager() {
       etat.changerEtatEnNonPrisEnCompte();
    }

    
    public void changerEtatEnPrisEnCompte() {
        etat.changerEtatEnPrisEnCompte();
    }

    
    public void changerEtatEnNonPrisEnCompte() {
       etat.changerEtatEnNonPrisEnCompte();
    }

   
    public void changerEtatEnArchive() {
       etat.changerEtatEnArchive();
    }

   
    public void changerEtatEnCoursDeValidation() {
        etat.changerEtatEnCoursDeValidation();
    }
    public EtatDemande getEtat() {
        return etat;
    }

    public void setEtat(EtatDemande etat) {
        this.etat = etat;
    }

    
    

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public String getNomDemande() {
        return nomDemande;
    }

    public String getDescription() {
        return description;
    }
    
    public Demande prendreEnCharge(Demande d){
        return d;
    }

    public void setPhotoDeLaDemande(Photo photoDeLaDemande) {
        this.photoDeLaDemande = photoDeLaDemande;
    }

    public Photo getPhotoDeLaDemande() {
        return photoDeLaDemande;
    }

    public void setIdPhotographe(int idPhotographe) {
        this.idPhotographe = idPhotographe;
    }

    public void setIdHistorien(int idHistorien) {
        this.idHistorien = idHistorien;
    }

    public int getIdPhotographe() {
        return idPhotographe;
    }

    public int getIdHistorien() {
        return idHistorien;
    }

//    public Demande seDesengager(Demande d){
//        d.setEtat(EtatDemande.EtatNonPrisEnCharge);
//        return d;
//    }
}
