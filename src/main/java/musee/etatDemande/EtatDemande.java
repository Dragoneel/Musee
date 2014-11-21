/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musee.etatDemande;

/**
 *
 * @author yirou
 */
public interface EtatDemande {
//public enum EtatDemande{
// EtatNonPrisEnCharge, EtatPrisEnCharge,EtatEnCoursDeValidation,EtatArchive;
// 
//     
     public void changerEtatEnPrisEnCompte();
     public void changerEtatEnNonPrisEnCompte();
     public void changerEtatEnArchive();
     public void changerEtatEnCoursDeValidation();
     public void seDesangager();
     
}
