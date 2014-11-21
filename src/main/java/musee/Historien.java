/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musee;

import musee.etatDemande.EtatDemande;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author yirou
 */
public class Historien {
    int idHistorien;
    String nom;
    String fonction;
    public ArrayList<Demande> demandeHistorien = new ArrayList<>();
//    public ArrayList<Demande> demandeApprouve=new ArrayList<>();
    public Historien(int idHistorien,String nom, String fonction) {
        this.idHistorien=idHistorien;
        this.nom = nom;
        this.fonction = fonction;
    }
    

    public ArrayList<Demande> getDemandeHistorien() {
        return demandeHistorien;
    }

    public void setDemandeHistorien(ArrayList<Demande> demandeHistorien) {
        this.demandeHistorien = demandeHistorien;
    }

//    public void misAjourDemande(Demande d){
//        d.setEtat(EtatDemande.EtatPrisEnCharge);
//    }

//    public ArrayList<Demande> getDemandeApprouve() {
//        return demandeApprouve;
//    }

    public String getFonction() {
        return fonction;
    }

    public int getIdHistorien() {
        return idHistorien;
    }

    public String getNom() {
        return nom;
    }

//    public void setDemandeApprouve(ArrayList<Demande> demandeApprouve) {
//        this.demandeApprouve = demandeApprouve;
//    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public void setIdHistorien(int idHistorien) {
        this.idHistorien = idHistorien;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
