package musee.musee_vue;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import musee.Departement;
import musee.Historien;
import musee.Musee;
import musee.Oeuvre;
import musee.Photographe;

/**
 *
 * @author yirou
 */
public class Visite extends javax.swing.JFrame {

    Historien historien;
    Photographe photographe;
    Lancer_programme choix;
    String profil;
    Departement departement;
     Musee musee;
    String entete[] = {"ID", "Nom Oeuvre", "Description"};
    Vector<Oeuvre> sortie = new Vector<Oeuvre>();///liste de recherche

    /**
     * Creates new form Visite
     *
     * @param choix
     * @param profil
     */
    public Visite(Lancer_programme choix, String profil,Musee musee) {
        initComponents();
        this.musee=musee;
        //musee.genereListeDepartement();
        this.choix = choix;
        this.profil = profil;
        this.setEnabled(false);
        this.setVisible(true);
        setTitle(choix.jComboBox1.getSelectedItem().toString());
        initialiserMusee();
        
        setLocationRelativeTo(null);
        setResizable(false);
        gererDroit(profil);
        oeuvreDescription.setEditable(false);
        imageOeuvre.setEditable(false);
        departement = new Departement(1, null);
        departement.genereOeuvreManuelement();

        ajouterDepartementAuCombobox();

    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getProfil() {
        return profil;
    }
    

    public void genererTableau(Vector v) {
        int taille = v.size();
        Oeuvre temp;
        jTable2.setModel(new DefaultTableModel(entete, taille) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        jTable2.setToolTipText("Cliquer pour afficher description");
        for (int i = 0; i < taille; i++) {

            temp = (Oeuvre) v.elementAt(i);
            jTable2.setValueAt(temp.getIdOeuvre(), i, 0);
            jTable2.setValueAt(temp.getNom(), i, 1);
            jTable2.setValueAt(temp.getDescription(), i, 2);
        }
    }

    public void gererDroit(String profil) {

        switch (profil) {
            case "Visiteur":
                editionMenu.setVisible(false);

                break;
            case "Photographe":
                editionMenu.setVisible(true);
                ajouterDescription.setEnabled(false);
                ajouterPhoto.setEnabled(true);
                demandePhoto.setEnabled(false);
                demandePhotographe.setVisible(true);
                demandesHistorien.setVisible(false);

                consulterDemandeItem.setVisible(true);
                break;

            default:
                editionMenu.setVisible(true);
                ajouterPhoto.setEnabled(false);
                ajouterDescription.setEnabled(true);
                demandePhoto.setEnabled(true);
                demandePhotographe.setVisible(false);
                demandesHistorien.setVisible(true);

                consulterDemandeItem.setVisible(false);
        }

    }

    
    public  void ajouterDepartementAuCombobox() {
        listeDep.removeAllItems();
        Departement depTemp;
        for (int i = 0; i < musee.listeDepartement.size(); i++) {
            depTemp = (Departement) musee.listeDepartement.elementAt(i);
            listeDep.addItem(depTemp.getNomDepartement());
        }
    }

    //rechercher des oeuvres à partir d'un departement
    public Vector recherche(int dep) {
        Vector result = new Vector();
        Oeuvre temp;
        for (int i = 0; i < departement.listeOeuvre.size(); i++) {
            temp = (Oeuvre) departement.listeOeuvre.elementAt(i);
            if (temp.getDepartement() == dep) {
                result.add(temp);
            }
        }
        return result;
    }

    //rechercher une oeuvre à partir de son id dans une liste
    public static Vector recherche(int id, Vector v) {
        Vector result = new Vector();
        Oeuvre temp;
        for (int i = 0; i < v.size(); i++) {
            temp = (Oeuvre) v.elementAt(i);
            if (temp.getIdOeuvre() == id) {
                result.add(i);//on ajoute position de l'oeuvre dans la liste
                result.add(temp);//on ajoute l'oeuvre de l'oeuvre dans la liste 
                return result;
            }
        }
        return null;
    }

    public void recherche(String nom) {
        Oeuvre temp;
        departement.indicePosition = 0;

        sortie.removeAllElements();
        for (int i = 0; i < departement.listeOeuvre.size(); i++) {

            temp = (Oeuvre) departement.listeOeuvre.elementAt(i);
            if (temp.getNom().startsWith(nom)) {
                sortie.add(temp);

            }
        }
        desactiverBouton();
        genererTableau(sortie);

    }
      //chercher un hoistorien dans une liste à partir de son id
    public Historien chercherHistorien(ArrayList<Historien>listeH,int id){
        Historien h;
        for(int i=0;i<listeH.size();i++){
           h=listeH.get(i);
           if(h.getIdHistorien()==id){
               return h;
           }
        }
        return null;
    }

    public Photographe chercherPhotographe(ArrayList<Photographe>listeP,int id){
        Photographe p;
        for(int i=0;i<listeP.size();i++){
           p=listeP.get(i);
           if(p.getIdPhotographe()==id){
               return p;
           }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        imageOeuvre = new javax.swing.JEditorPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listeDep = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        oeuvrePrecedante = new javax.swing.JButton();
        oeuvreSuivante = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        oeuvreDescription = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nomOeuvre = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        editionMenu = new javax.swing.JMenu();
        ajouterPhoto = new javax.swing.JMenuItem();
        demandePhoto = new javax.swing.JMenuItem();
        ajouterDescription = new javax.swing.JMenuItem();
        consulterDemandeItem = new javax.swing.JMenuItem();
        demandesHistorien = new javax.swing.JMenuItem();
        demandePhotographe = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        imageOeuvre.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(imageOeuvre);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Recherche par département"));

        jLabel1.setText("Nom:");

        listeDep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setText("Valider");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre d'oeuvre disponible:");

        jLabel3.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(101, 101, 101)
                        .addComponent(listeDep, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(listeDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(jButton3))
                .addGap(32, 32, 32))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Navigation"));

        oeuvrePrecedante.setText("<< Oeuvre précédente");
        oeuvrePrecedante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oeuvrePrecedanteActionPerformed(evt);
            }
        });

        oeuvreSuivante.setText("Oeuvre suivante >>");
        oeuvreSuivante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oeuvreSuivanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(oeuvrePrecedante, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(oeuvreSuivante, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oeuvrePrecedante)
                    .addComponent(oeuvreSuivante))
                .addGap(36, 36, 36))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Description de l'oeuvre"));

        oeuvreDescription.setColumns(20);
        oeuvreDescription.setRows(5);
        jScrollPane2.setViewportView(oeuvreDescription);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Recherche par nom d'oeuvre"));

        jLabel4.setText("Mots clés:");

        nomOeuvre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomOeuvreActionPerformed(evt);
            }
        });
        nomOeuvre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomOeuvreKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(53, 53, 53)
                .addComponent(nomOeuvre)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nomOeuvre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(94, 94, 94))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jMenu1.setText("Fichier");

        jMenuItem1.setText("Quitter");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        editionMenu.setText("Edition");

        ajouterPhoto.setText("Ajouter Photo");
        ajouterPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterPhotoActionPerformed(evt);
            }
        });
        editionMenu.add(ajouterPhoto);

        demandePhoto.setText("Faire une demande photo");
        demandePhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demandePhotoActionPerformed(evt);
            }
        });
        editionMenu.add(demandePhoto);

        ajouterDescription.setText("Ajouter description");
        ajouterDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterDescriptionActionPerformed(evt);
            }
        });
        editionMenu.add(ajouterDescription);

        consulterDemandeItem.setText("Consulter les demandes du musee");
        consulterDemandeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consulterDemandeItemActionPerformed(evt);
            }
        });
        editionMenu.add(consulterDemandeItem);

        demandesHistorien.setText("Mes demandes ");
        demandesHistorien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demandesHistorienActionPerformed(evt);
            }
        });
        editionMenu.add(demandesHistorien);

        demandePhotographe.setText("Mes demandes");
        demandePhotographe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demandePhotographeActionPerformed(evt);
            }
        });
        editionMenu.add(demandePhotographe);

        jMenuBar1.add(editionMenu);

        jMenu3.setText("Changer d'utilisateur");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Choisir utilisateur");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterPhotoActionPerformed
        new AjoutPhoto(photographe).setVisible(true);
    }//GEN-LAST:event_ajouterPhotoActionPerformed

    private void ajouterDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterDescriptionActionPerformed
        new ModifierOeuvre(musee, departement,this).setVisible(true);
    }//GEN-LAST:event_ajouterDescriptionActionPerformed

    private void nomOeuvreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomOeuvreKeyPressed
        // TODO add your handling code here:
        if (nomOeuvre.getText().length() > 0) {
            recherche(nomOeuvre.getText());
        }


    }//GEN-LAST:event_nomOeuvreKeyPressed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if (evt.getClickCount() == 1) {
            int i = jTable2.getSelectedRow();
            departement.indicePosition = i;
            Oeuvre oeuvre = (Oeuvre) recherche(Integer.parseInt(jTable2.getValueAt(i, 0).toString()), departement.listeOeuvre).elementAt(1);
            afficheOeuvre(oeuvre);
            desactiverBouton();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void oeuvreSuivanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oeuvreSuivanteActionPerformed
        Oeuvre v = departement.getOeuvreSuivante(sortie);
        afficheOeuvre(v);
        desactiverBouton();

    }//GEN-LAST:event_oeuvreSuivanteActionPerformed

    private void oeuvrePrecedanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oeuvrePrecedanteActionPerformed
        Oeuvre v = departement.getOeuvrePrecendante(sortie);
        afficheOeuvre(v);
        desactiverBouton();
    }//GEN-LAST:event_oeuvrePrecedanteActionPerformed

    private void nomOeuvreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomOeuvreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomOeuvreActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int idDep = departement.getIdDep(listeDep.getSelectedItem().toString(), musee.listeDepartement);

        sortie = recherche(idDep);
        departement.indicePosition = 0;
        genererTableau(sortie);
        desactiverBouton();
        jLabel3.setText("" + sortie.size());
        int i = 0;
        try {
            i = Integer.parseInt(jTable2.getValueAt(0, 0).toString());
        } catch (Exception e) {

        }

        if (i > 0) {
            Oeuvre oeuvre = (Oeuvre) recherche(Integer.parseInt(jTable2.getValueAt(0, 0).toString()), departement.listeOeuvre).elementAt(1);
            afficheOeuvre(oeuvre);
            desactiverBouton();
        } else {

            oeuvreDescription.setText("Pas d'oeuvre disponible");
            imageOeuvre.setText("Pas d'oeuvre disponible");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void demandePhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demandePhotoActionPerformed

//        personne=new Historien(personne.getNom(),personne.getAdresse(), personne.getAge(), "Historien", 2);
        FaireDemande d = new FaireDemande(musee, historien);

        d.setVisible(true);
    }//GEN-LAST:event_demandePhotoActionPerformed

    private void consulterDemandeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consulterDemandeItemActionPerformed
        new ListeDemandeMusee(musee, photographe).setVisible(true);
    }//GEN-LAST:event_consulterDemandeItemActionPerformed

    private void demandesHistorienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demandesHistorienActionPerformed
        new ListeDemande(historien, musee,this).setVisible(true);
    }//GEN-LAST:event_demandesHistorienActionPerformed

    private void demandePhotographeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demandePhotographeActionPerformed
        new ListeDemandePhotographe(photographe).setVisible(true);
    }//GEN-LAST:event_demandePhotographeActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
       
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        choix.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void desactiverBouton() {
        if (sortie.size() == 0) {
            oeuvreSuivante.setEnabled(false);
            oeuvrePrecedante.setEnabled(false);
        } else if (departement.indicePosition == sortie.size() - 1) {
            oeuvreSuivante.setEnabled(false);
        } else {
            oeuvreSuivante.setEnabled(true);
        }
        if (departement.indicePosition == 0) {
            oeuvrePrecedante.setEnabled(false);
        } else {
            oeuvrePrecedante.setEnabled(true);
        }
    }

    public void afficheOeuvre(Oeuvre oeuvre) {

        imageOeuvre.setEditable(false);
        String photo = oeuvre.getAdresseImage();

        imageOeuvre.setContentType("text/html");
        String linkImage = "<img src=file:" + photo + "/> ";
        oeuvreDescription.setEditable(false);
        imageOeuvre.setText(linkImage);
        oeuvreDescription.setText(oeuvre.getDescription());

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem ajouterDescription;
    public javax.swing.JMenuItem ajouterPhoto;
    private javax.swing.JMenuItem consulterDemandeItem;
    private javax.swing.JMenuItem demandePhoto;
    private javax.swing.JMenuItem demandePhotographe;
    private javax.swing.JMenuItem demandesHistorien;
    private javax.swing.JMenu editionMenu;
    public javax.swing.JEditorPane imageOeuvre;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    public static javax.swing.JComboBox listeDep;
    private javax.swing.JTextField nomOeuvre;
    public javax.swing.JTextArea oeuvreDescription;
    private javax.swing.JButton oeuvrePrecedante;
    private javax.swing.JButton oeuvreSuivante;
    // End of variables declaration//GEN-END:variables

    public void initialiserMusee() {
        oeuvrePrecedante.setEnabled(false);
        oeuvreSuivante.setEnabled(false);
        Oeuvre o = new Oeuvre(0, "Musee de Louvres", "img/louvres1.jpg", "Le musée pyrénéen de Lourdes est un musée consacré aux Pyrénées sous tous leurs aspects,\n"
                + " installé depuis 1921 dans le château fort de Lourdes (Hautes-Pyrénées).\n"
                + "La création du musée pyrénéen est due à Louis Le Bondidier (1878-1945), inséparable de son épouse Margalide, lorrains d'origine,\n"
                + " tombés définitivement, comme beaucoup d'autres, amoureux de ces montagnes. Ils y déposèrent leurs propres collections glanées au cours\n"
                + " d'une longue carrière pyrénéiste et fruit de leurs relations avec le monde du pyrénéisme. En 1913, contraint par la maladie d'abandonner\n"
                + " toute activité physique, Le Bondidier se consacre entièrement à son projet de musée pyrénéen. Appuyé par le Touring club de France,\n "
                + "il réussit à convaincre la municipalité lourdaise de lui céder le vieux château, qui sert alors de réservoir d'eau pour la ville.\n"
                + " Un bail de 99 ans est signé avec le Touring Club de France, désormais locataire des lieux. Après une intense activité d'aménagement\n "
                + "et d'installations, le Musée peut ouvrir en 1921. Le Bondidier en est le conservateur. Il continue à s'occuper de tourisme, \n"
                + "de pyrénéisme, et de l'accroissement des collections du musée. Il crée les éditions de l'Échauguette (la vignette qui sert \n"
                + " de logotype est de Charles Jouas). Margalide réalise elle-même, au long de plusieurs années, des maquettes d'édifices pyrénéens \n"
                + " et des spécimens d'architecture : la cathédrale et le village de Saint-Bertrand de Comminges, Saint-Martin du Canigou, un village \n"
                + " aragonais, une ferme basque, etc.\n"
                + "\n"
                + "Le Bondidier, mort en 1945, est enterré à Gavarnie, près de Franz Schrader, au pied du cirque. Margalide lui succède comme conservateur du musée,\n"
                + " jusqu'à sa mort survenue en mai 1960. Le musée est labellisé Musée de France. Il est affilié à la Fédération des Écomusées et Musées de société.\n", 0);
        afficheOeuvre(o);
    }
}
