/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musee;

import java.util.logging.Level;
import java.util.logging.Logger;
import musee.etatDemande.EtatPrisEnCharge;

/**
 *
 * @author yirou
 */
public class LeBatch implements Runnable{
    Thread t;
    int tempsMaxi=20;
    int tempsDebut=0;
    Demande d;
    Musee musee;
    public LeBatch(Demande d,Musee musee) {
        this.d=d;
        this.musee=musee;
        t=new Thread(this);
        t.start();
    }
    
      public  int nombreAlea(int min,int max){
      return (int) (Math.random() * ( max - min ));
   }
    
  

    @Override
    public void run() {
        while(tempsDebut<=tempsMaxi){
            try {
                Thread.sleep(1000);
                tempsDebut++;
//                System.out.println("jatend sinon j'attribue automatiquement");
                if(tempsDebut==tempsMaxi&& this.d.getEtat().getClass().getSimpleName().equalsIgnoreCase("EtatNonPrisEnCharge")){
                 int a=nombreAlea(0, musee.listePhotoGraphe.size()-1);
                 Photographe p=musee.listePhotoGraphe.get(a);
                 p.demandePrisEnCharge.add(d);
                 d.setIdHistorien(a);
                 d.setEtat(new EtatPrisEnCharge(d));
                 
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(LeBatch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tempsDebut=0;
    }
    
}
