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
public class EtatNonPrisEnCharge implements EtatDemande{
 
    private final Demande demande;

    public EtatNonPrisEnCharge(Demande demande) {
        this.demande = demande;
    }

    @Override
    public void changerEtatEnPrisEnCompte() {
        demande.setEtat(new EtatPrisEnCharge(demande));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seDesangager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
    
}
