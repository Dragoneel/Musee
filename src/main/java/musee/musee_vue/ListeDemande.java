package musee.musee_vue;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import musee.Demande;
import musee.etatDemande.EtatDemande;
import musee.Historien;
import musee.Musee;
import musee.Oeuvre;

/**
 *
 * @author yirou
 */
public class ListeDemande extends javax.swing.JFrame {

    Historien historien;
    Musee musee;
    static Demande demande;
    Visite visite;
    /**
     * Creates new form ListeDemande
     */
    public ListeDemande(Historien historien,Musee musee,Visite visite) {
        initComponents();
        this.historien = historien;
        this.musee=musee;
        this.visite=visite;
        genererTableau();
        descriptionDemande.setEditable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        oui.setEnabled(false);
        non.setEnabled(false);
        activerPanelTransfert();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionDemande = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        oui = new javax.swing.JButton();
        non = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        );

        jLabel2.setText("Valider la Photo ?");

        oui.setText("Oui");
        oui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouiActionPerformed(evt);
            }
        });

        non.setText("Non");
        non.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonActionPerformed(evt);
            }
        });

        jButton1.setText("Transferer comme oeuvre >>");
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(oui)
                                        .addGap(18, 18, 18)
                                        .addComponent(non, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(non)
                                    .addComponent(oui))))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

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
           int i=jTable1.getSelectedRow();
           //historien.demandeHistorien.addAll(historien.demandeApprouve);
            demande=musee.chercherDemande(historien.demandeHistorien,i);
            descriptionDemande.setText(demande.getDescription());
            if(demande.getEtat().getClass().getSimpleName().equalsIgnoreCase("EtatEnCoursDeValidation")){
                oui.setEnabled(true);
                non.setEnabled(true);
           }
             if(demande.getEtat().getClass().getSimpleName().equalsIgnoreCase("EtatEnCoursDeValidation")||demande.getEtat().getClass().getSimpleName().equalsIgnoreCase("EtatArchive")){
                String  imagesrc = new String("<html>" +
                        "<center><img alt =\"\" src=\"" + new String("file:///"+demande.getPhotoDeLaDemande().getAdresseImage()) + "\" width=\""
                        + jLabel1.getWidth() + "\"" + "height=\""
                        + jLabel1.getHeight() + "\">" +
                        "</center></html>");
                jLabel1.setText(imagesrc);
            }
         activerPanelTransfert();
       }
    }//GEN-LAST:event_jTable1MouseClicked

    private void activerPanelTransfert(){
        if(demande!=null && demande.getEtat().getClass().getSimpleName().equalsIgnoreCase("EtatArchive")){
             jButton1.setVisible(true);
         }else{
            jButton1.setVisible(false);
        }
    }
    private void ouiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ouiActionPerformed
        
        demande.changerEtatEnArchive();
        genererTableau();
    }//GEN-LAST:event_ouiActionPerformed

    private void nonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonActionPerformed
        demande.changerEtatEnPrisEnCompte();
        genererTableau();
    }//GEN-LAST:event_nonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Oeuvre oeuvre=new Oeuvre(visite.departement.listeOeuvre.size()+1, "", demande.getPhotoDeLaDemande().getAdresseImage(), "",0);
      visite.departement.listeOeuvre.add(oeuvre);
        JOptionPane.showMessageDialog(null, "Oeuvre bien transferée !");
    }//GEN-LAST:event_jButton1ActionPerformed

    public void genererTableau() {
        int taille = historien.demandeHistorien.size();
//        historien.demandeHistorien.addAll(historien.demandeApprouve);
        String entete[] = {"ID", "Libellé demande", "Etat"};
        jTable1.setModel(new DefaultTableModel(entete, taille) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        for (int i = 0; i < taille; i++) {
            Demande d = historien.demandeHistorien.get(i);
            jTable1.setValueAt(i, i, 0);
            jTable1.setValueAt(d.getNomDemande(), i, 1);
            jTable1.setValueAt(d.getEtat().getClass().getSimpleName(), i, 2);
//            if (d.getEtat().equals(EtatDemande.EtatPrisEnCharge)) {
//                jTable1.setValueAt("Demande pris en charge", i, 2);
//            } else {
//                jTable1.setValueAt("Demande non pris en charge", i, 2);
//            }

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descriptionDemande;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton non;
    private javax.swing.JButton oui;
    // End of variables declaration//GEN-END:variables
}
