/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musee.musee_vue;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import musee.Demande;
import musee.Photographe;

/**
 *
 * @author yirou
 */
public class ListeDemandePhotographe extends javax.swing.JFrame {

    Photographe photographe;
    static Demande tempo;
    static int indice;
    /**
     * Creates new form ListeDemandePhotographe
     */
    public ListeDemandePhotographe(Photographe photographe) {
        initComponents();
        this.photographe = photographe;
        genererTableau();
        descriptionDemande.setEditable(false);
        desactiverBouton();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void genererTableau() {

        String entete[] = {"ID", "Libellé demande"};
        jTable1.setModel(new DefaultTableModel(entete, photographe.demandePrisEnCharge.size()) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        for (int i = 0; i < photographe.demandePrisEnCharge.size(); i++) {
            Demande d = photographe.demandePrisEnCharge.get(i);
            jTable1.setValueAt(i, i, 0);
            jTable1.setValueAt(d.getNomDemande(), i, 1);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionDemande = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        descriptionDemande.setColumns(20);
        descriptionDemande.setRows(5);
        jScrollPane2.setViewportView(descriptionDemande);

        jButton1.setText("Se désengager");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton1)))
                .addGap(0, 52, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         if(evt.getClickCount()==1){
           indice=jTable1.getSelectedRow();
          
           tempo =chercherDemande(photographe.demandePrisEnCharge,indice);
            descriptionDemande.setText(tempo.getDescription()+"\n\n"+tempo.getEtat().getClass().getSimpleName());
            if(tempo.getEtat().getClass().getSimpleName().equalsIgnoreCase("EtatPrisEnCharge")){
                jButton1.setEnabled(true);
            }else{
                jButton1.setEnabled(false);
            }
             
       }
    }//GEN-LAST:event_jTable1MouseClicked

    private void desactiverBouton(){
        if(photographe.demandePrisEnCharge.size()<1){jButton1.setEnabled(false);
        descriptionDemande.setText("");}
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tempo.changerEtatEnNonPrisEnCompte();
        
        photographe.demandePrisEnCharge.remove(indice);
        genererTableau();
        desactiverBouton();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descriptionDemande;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

     public Demande chercherDemande(ArrayList v, int position) {

        for (int i = 0; i < v.size(); i++) {
            if (i == position) {
                return ((Demande) v.get(i));

            }
        }
        return null;
    }
}
