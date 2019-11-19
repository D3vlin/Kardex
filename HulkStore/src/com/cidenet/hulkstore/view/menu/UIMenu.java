package com.cidenet.hulkstore.view.menu;

import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.users.UsersDto;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Main Menu View
 *
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-12
 */
public class UIMenu extends javax.swing.JFrame
{
    /**
     * Store the user id that uses the menu
     */
    public static int userId;
    private CMenu controller;
    
    public UIMenu(CMenu controller, UsersDto user) {
        initComponents();
        this.setVisible(true);
        this.setTitle("Menú - Sistema de Control de Inventarios");
        setLocationRelativeTo(null);
        
        this.controller = controller;
        controller.upload(
            user,
            this.lblRealName,
            this.lblIdentification,
            this.lblProfile,
            this.btnUser,
            this.btnProductExistence,
            this.btnProductEntry,
            this.btnProductExit
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblRealName = new javax.swing.JLabel();
        lblProfile = new javax.swing.JLabel();
        lblIdentification = new javax.swing.JLabel();
        btnStore = new javax.swing.JButton();
        btnProduct = new javax.swing.JButton();
        btnUnity = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnDocument = new javax.swing.JButton();
        btnKardex = new javax.swing.JButton();
        btnProductExistence = new javax.swing.JButton();
        btnProductEntry = new javax.swing.JButton();
        btnProductExit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniSettings = new javax.swing.JMenuItem();
        mniClose = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mniManual = new javax.swing.JMenuItem();
        mniAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/cidenet/hulkstore/resources/images/inventory_icon.png")).getImage());
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cidenet/hulkstore/resources/images/kardex_banner.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cidenet/hulkstore/resources/images/inventory_img.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel3.setText("Bienvenido(a)");

        lblRealName.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        lblProfile.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        lblIdentification.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        btnStore.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnStore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cidenet/hulkstore/resources/images/store_img.png"))); // NOI18N
        btnStore.setText("TIENDA");
        btnStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoreActionPerformed(evt);
            }
        });

        btnProduct.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cidenet/hulkstore/resources/images/product_img.png"))); // NOI18N
        btnProduct.setText("PRODUCTO");
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });

        btnUnity.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnUnity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cidenet/hulkstore/resources/images/unity_img.png"))); // NOI18N
        btnUnity.setText("UNIDAD");
        btnUnity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnityActionPerformed(evt);
            }
        });

        btnUser.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cidenet/hulkstore/resources/images/user_img.png"))); // NOI18N
        btnUser.setText("USUARIO");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        btnDocument.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnDocument.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cidenet/hulkstore/resources/images/document_img.png"))); // NOI18N
        btnDocument.setText("DOCUMENTO");
        btnDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocumentActionPerformed(evt);
            }
        });

        btnKardex.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnKardex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cidenet/hulkstore/resources/images/kardex_img.png"))); // NOI18N
        btnKardex.setText("KARDEX");
        btnKardex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKardexActionPerformed(evt);
            }
        });

        btnProductExistence.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnProductExistence.setText("EXISTENCIA DE PRODUCTOS");
        btnProductExistence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductExistenceActionPerformed(evt);
            }
        });

        btnProductEntry.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnProductEntry.setText("ENTRADA PRODUCTOS FECHA");
        btnProductEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductEntryActionPerformed(evt);
            }
        });

        btnProductExit.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnProductExit.setText("SALIDA PRODUCTOS FECHA");
        btnProductExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductExitActionPerformed(evt);
            }
        });

        jMenuBar1.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N

        mniSettings.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        mniSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cidenet/hulkstore/resources/images/settings_icon.png"))); // NOI18N
        mniSettings.setText("Configuración");
        mniSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSettingsActionPerformed(evt);
            }
        });
        jMenu1.add(mniSettings);

        mniClose.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        mniClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cidenet/hulkstore/resources/images/exit_icon.png"))); // NOI18N
        mniClose.setText("Cerrar Sesión");
        mniClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCloseActionPerformed(evt);
            }
        });
        jMenu1.add(mniClose);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenu2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N

        mniManual.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        mniManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cidenet/hulkstore/resources/images/manual_icon.png"))); // NOI18N
        mniManual.setText("Leer Manual");
        jMenu2.add(mniManual);

        mniAbout.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        mniAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cidenet/hulkstore/resources/images/about_icon.png"))); // NOI18N
        mniAbout.setText("Acerca De...");
        mniAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAboutActionPerformed(evt);
            }
        });
        jMenu2.add(mniAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRealName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIdentification, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnProductExistence, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProductEntry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnStore, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUnity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProductExit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKardex, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRealName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdentification, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStore)
                    .addComponent(btnProduct)
                    .addComponent(btnUnity))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUser)
                    .addComponent(btnDocument)
                    .addComponent(btnKardex))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProductExistence)
                    .addComponent(btnProductEntry)
                    .addComponent(btnProductExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSettingsActionPerformed
        controller.setting();
    }//GEN-LAST:event_mniSettingsActionPerformed

    private void mniCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCloseActionPerformed
        controller.logOut();
    }//GEN-LAST:event_mniCloseActionPerformed

    private void mniAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAboutActionPerformed
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/cidenet/hulkstore/resources/images/login_icon.png"));
        JOptionPane.showMessageDialog(null, "Sistema de Control de Inventarios\nHulkStore - 2019\nCIDENET S.A.S", "Acerca de...", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_mniAboutActionPerformed

    private void btnStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreActionPerformed
        controller.store();
    }//GEN-LAST:event_btnStoreActionPerformed

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        controller.product();
    }//GEN-LAST:event_btnProductActionPerformed

    private void btnUnityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnityActionPerformed
        controller.unity();
    }//GEN-LAST:event_btnUnityActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        controller.user();
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocumentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDocumentActionPerformed

    private void btnKardexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKardexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKardexActionPerformed

    private void btnProductExistenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductExistenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductExistenceActionPerformed

    private void btnProductEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductEntryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductEntryActionPerformed

    private void btnProductExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductExitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controller.logOut();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDocument;
    private javax.swing.JButton btnKardex;
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btnProductEntry;
    private javax.swing.JButton btnProductExistence;
    private javax.swing.JButton btnProductExit;
    private javax.swing.JButton btnStore;
    private javax.swing.JButton btnUnity;
    private javax.swing.JButton btnUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblIdentification;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblRealName;
    private javax.swing.JMenuItem mniAbout;
    private javax.swing.JMenuItem mniClose;
    private javax.swing.JMenuItem mniManual;
    private javax.swing.JMenuItem mniSettings;
    // End of variables declaration//GEN-END:variables
}
