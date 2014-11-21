/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musee;

import java.util.ArrayList;

/**
 *
 * @author yirou
 */
public class Photographe{
    int idPhotographe;
    String nom;
    String fonction;
   public ArrayList<Demande> demandePrisEnCharge = new ArrayList<>();

    public Photographe(int idPhotographe,String nom, String fonction) {
        this.idPhotographe=idPhotographe;
        this.nom = nom;
        this.fonction = fonction;
    }
   
    public ArrayList<Demande> getDemandePrisEnCharge() {
        return demandePrisEnCharge;
    }

    public void setDemandePrisEnCharge(ArrayList<Demande> demandePrisEnCharge) {
        this.demandePrisEnCharge = demandePrisEnCharge;
    }

    public void ajouterDemandeDansListe(Demande d){
        demandePrisEnCharge.add(d);
    }

    public String getFonction() {
        return fonction;
    }

    public int getIdPhotographe() {
        return idPhotographe;
    }

    public String getNom() {
        return nom;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public void setIdPhotographe(int idPhotographe) {
        this.idPhotographe = idPhotographe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
