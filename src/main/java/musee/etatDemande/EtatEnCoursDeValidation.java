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
public class EtatEnCoursDeValidation implements EtatDemande{
private final Demande demande;

    public EtatEnCoursDeValidation(Demande demande) {
        this.demande = demande;
    }

    @Override
    public void changerEtatEnPrisEnCompte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changerEtatEnNonPrisEnCompte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changerEtatEnArchive() {
        demande.setEtat(new EtatArchive(demande));
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
