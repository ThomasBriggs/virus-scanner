/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusscaner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ThomasBriggs
 */
public class quarantineDB extends javax.swing.JFrame {

    /**
     * Creates new form LogsWindows
     */
    public quarantineDB() {
        initComponents();
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
        jTable = new javax.swing.JTable();
        sortCombo = new javax.swing.JComboBox<>();
        closeBtn = new javax.swing.JButton();
        restoreBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    jTable.setFocusCycleRoot(true);
    jScrollPane1.setViewportView(jTable);

    sortCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Log ID Low - High", "Log ID High - Low" }));
    sortCombo.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            sortComboItemStateChanged(evt);
        }
    });

    closeBtn.setText("Close");
    closeBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            closeBtnActionPerformed(evt);
        }
    });

    restoreBtn.setText("Restore");
    restoreBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            restoreBtnActionPerformed(evt);
        }
    });

    jLabel1.setText("Sort By:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(sortCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(restoreBtn)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(closeBtn)))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(sortCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(closeBtn)
                .addComponent(restoreBtn))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            loadData();
        } catch (IOException ex) {
            Logger.getLogger(quarantineDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated

    private void restoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreBtnActionPerformed
        // TODO add your handling code here:
        if(jTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }else{
            int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to restore this file?");
            if (answer == JOptionPane.YES_OPTION){
                try {
                    restore();
                } catch (IOException ex) {
                    Logger.getLogger(quarantineDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_restoreBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        // TODO add your handling code here:
        new MainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void sortComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sortComboItemStateChanged
        try {
            // TODO add your handling code here:
            loadData();
        } catch (IOException ex) {
            Logger.getLogger(quarantineDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_sortComboItemStateChanged

    /**
     *
     * @throws IOException
     */
    public void loadData() throws IOException{
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        String[] cols = {"LogID", "File Name", "Directory Found"};
        
        FileIO io = new FileIO();
        String[][] tableData = currentSort();
        
        model.setDataVector(tableData, cols);
      
    }
    
    /**
     *
     * @throws java.io.IOException
     * @throws IOException
     */
    public void restore() throws IOException{
        String[][] data = currentSort();
        int row = jTable.getSelectedRow();
        File file = new File(data[row][2]);
        if (file.getParentFile().exists()){
            Path srcPath = Paths.get("quarantine/" + file.getName());
            Path path = Paths.get(file.getAbsolutePath());
            Files.move(srcPath, path, REPLACE_EXISTING);
            delRecord();
            JOptionPane.showMessageDialog(null, "File has been restored to: " + path.toString());
        }else{
            JOptionPane.showMessageDialog(null, "Previous file location not found!");
        }
        
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    public String[][] currentSort() throws IOException{
        Sort sort = new Sort();
        String[][] output = {};
        int selected = sortCombo.getSelectedIndex();
        if(selected == 0){
            output = sort.bubbleSort2dArray("quarantineDB.txt", 0, 3);
        }else if(selected == 1){
            output = sort.bubbleSort2dArray("quarantineDB.txt", 0, 3, true);
        }
        return output;
    }
    
    public void delRecord() throws IOException{
        int selectedIndex = jTable.getSelectedRow();
        FileIO io = new FileIO();
        Sort sort = new Sort();
        Search se = new Search();
        String[][] fileData = currentSort();
        int index = se.idSearch(fileData[selectedIndex][0], "quarantineDB.txt");
        try {
            io.delRecord(io.read("quarantineDB.txt"), index, "quarantineDB.txt");
            sort.bubbleSort2dArraySave("quarantineDB.txt", 0, 3);
            loadData();
        } catch (IOException ex) {
            Logger.getLogger(AdminWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
            java.util.logging.Logger.getLogger(quarantineDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quarantineDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quarantineDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quarantineDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quarantineDB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton restoreBtn;
    private javax.swing.JComboBox<String> sortCombo;
    // End of variables declaration//GEN-END:variables
}
