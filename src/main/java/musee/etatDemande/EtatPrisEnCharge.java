/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musee.etatDemande;

import musee.Demande;

/**
 *
 * @author yirou
 */
public class EtatPrisEnCharge implements EtatDemande{
 private final Demande demande;

    public EtatPrisEnCharge(Demande demande) {
        this.demande = demande;
    }

    @Override
    public void changerEtatEnPrisEnCompte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changerEtatEnNonPrisEnCompte() {
       demande.setEtat(new EtatNonPrisEnCharge(demande));
    }

    @Override
    public void changerEtatEnArchive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changerEtatEnCoursDeValidation() {
        demande.setEtat(new EtatEnCoursDeValidation(demande));
    }

    @Override
    public void seDesangager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
     
}
