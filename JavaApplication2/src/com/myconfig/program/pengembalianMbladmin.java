/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myconfig.program;

import com.project.program.adminpage;
import com.project.program.connect_db;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author muhammad7fold
 */
public class pengembalianMbladmin extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pat = null;
    ResultSet rs = null;
    String nopol = "";

    /**
     * Creates new form pengembalianMbladmin
     */
    public pengembalianMbladmin() {
        initComponents();
        this.showTableData();
    }
    
     public void showTableData(){
        String[] column = {"penyewa", "nopol", "tgl_mulai", "tgl_akhir", "lama", "total"};
        DefaultTableModel model = new DefaultTableModel(column, 0);
//        model.addColumn(column);
        try{
            conn = connect_db.configDB();
            String Sql = "SELECT nama, nopol, tgl_mulai, tgl_akhir, lama, total FROM menyewa INNER JOIN db_mobil ON mobil_id=id_mobil INNER JOIN user ON id_user=user_id";
            
            pat = (PreparedStatement)conn.prepareStatement(Sql);
            rs = pat.executeQuery();
            System.out.println(rs.toString());
            while(rs.next()){
                column[0] = rs.getString("nama");
                column[1] = rs.getString("nopol");
                column[2] = rs.getString("tgl_mulai");
                column[3] = rs.getString("tgl_akhir");
                column[4] = rs.getString("lama");
                column[5] = rs.getString("total");
                model.addRow(column);
                System.out.println(model.getRowCount());
                
            }
            jTable1.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        field_nopol = new javax.swing.JTextField();
        btn_find = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        field_tglMulai = new javax.swing.JTextField();
        field_penyewa = new javax.swing.JTextField();
        field_tglAkhir = new javax.swing.JTextField();
        field_lama = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        field_total = new javax.swing.JTextField();
        btn_submit = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "nopol", "penyewa", "tgl_mulai", "tgl_akhir", "lama", "total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Pengembalian Mobil");

        jLabel2.setText("nopol");

        field_nopol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_nopolActionPerformed(evt);
            }
        });

        btn_find.setText("FIND");
        btn_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findActionPerformed(evt);
            }
        });

        jLabel3.setText("penyewa");

        jLabel4.setText("tgl_mulai");

        jLabel5.setText("tgl_akhir");

        jLabel6.setText("lama");

        field_tglMulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_tglMulaiActionPerformed(evt);
            }
        });

        field_penyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_penyewaActionPerformed(evt);
            }
        });

        field_tglAkhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_tglAkhirActionPerformed(evt);
            }
        });

        field_lama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_lamaActionPerformed(evt);
            }
        });

        jLabel7.setText("total");

        field_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_totalActionPerformed(evt);
            }
        });

        btn_submit.setText("SUBMIT");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        btn_back.setText("BACK");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(field_nopol, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(field_tglAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(field_tglMulai))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(field_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(95, 95, 95)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(field_lama, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(field_total, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_submit)
                                        .addGap(31, 31, 31)
                                        .addComponent(btn_back))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btn_find)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(jLabel1)))
                        .addContainerGap(17, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(field_nopol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_find))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(field_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(field_lama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(field_tglMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(field_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(field_tglAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_submit)
                    .addComponent(btn_back))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void field_nopolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nopolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nopolActionPerformed

    private void field_tglMulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_tglMulaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_tglMulaiActionPerformed

    private void field_penyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_penyewaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_penyewaActionPerformed

    private void field_tglAkhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_tglAkhirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_tglAkhirActionPerformed

    private void field_lamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_lamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_lamaActionPerformed

    private void field_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_totalActionPerformed

    private void btn_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findActionPerformed
        // TODO add your handling code here:
        try {
            if(this.field_nopol.getText().isEmpty()){
                throw new SQLException ("Nopol tidak boleh kosong!!");
            }
            this.nopol = this.field_nopol.getText();
            String sql = String.format("SELECT nama, lama, total, tgl_mulai, tgl_akhir, nopol FROM db_mobil "
                + "INNER JOIN menyewa ON mobil_id=id_mobil"
                + " INNER JOIN user ON user_id=id_user WHERE nopol='%s'", 
                this.field_nopol.getText());
            pat = (PreparedStatement)conn.prepareStatement(sql);
            rs = pat.executeQuery();
            int i = 0;
            while (rs.next()) {
                this.field_penyewa.setText(rs.getString("nama"));
                this.field_lama.setText(rs.getString("lama"));
                this.field_total.setText(rs.getString("total"));
                this.field_tglMulai.setText(rs.getString("tgl_mulai"));
                this.field_tglAkhir.setText(rs.getString("tgl_akhir"));
                i++;
            }
            if(i==0){
                throw new SQLException("Nopol tidak ditemukan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_findActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
        System.out.println("Executed");
//        String presql = String.format("SELECT mobil_id from menyewa WHERE user_id=%d", 
//                Integer.valueOf(this.user_id));
        int n = 0;
        try {
            if("".equals(this.nopol)){
                throw new SQLException("nopol tidak boleh kosong!!!");
            }
//            pat = (PreparedStatement)conn.prepareStatement(presql);
//            rs = pat.executeQuery();
//            rs.next();
//            System.out.println("Tereksekusi " + rs.getString("mobil_id"));
            String sql2 = String.format("DELETE menyewa FROM menyewa INNER JOIN db_mobil ON id_mobil=mobil_id WHERE nopol='%s'", this.nopol);
            pat = (PreparedStatement)conn.prepareStatement(sql2);
            n = pat.executeUpdate();
            JOptionPane.showMessageDialog(this, "Mobil telah berhasil dikembalikan");
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        if(n != 0){
            String sql = "UPDATE db_mobil SET status='READY' WHERE nopol='"+this.nopol+"'";
            try {
                pat = (PreparedStatement)conn.prepareStatement(sql);
                pat.execute();
            } catch (SQLException e) {
            
                JOptionPane.showMessageDialog(null, e);
        }
        }
        this.showTableData();
    }//GEN-LAST:event_btn_submitActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        adminpage admin = new adminpage();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pengembalianMbladmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pengembalianMbladmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pengembalianMbladmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pengembalianMbladmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pengembalianMbladmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_find;
    private javax.swing.JButton btn_submit;
    private javax.swing.JTextField field_lama;
    private javax.swing.JTextField field_nopol;
    private javax.swing.JTextField field_penyewa;
    private javax.swing.JTextField field_tglAkhir;
    private javax.swing.JTextField field_tglMulai;
    private javax.swing.JTextField field_total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}