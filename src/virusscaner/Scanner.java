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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ThomasBriggs
 */
public class Scanner extends javax.swing.JFrame {

    /**
     * Creates new form Scanner
     */
    public Scanner() {
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

        scanBtn = new javax.swing.JButton();
        selectFileBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        selectedFileLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        hashLbl = new javax.swing.JLabel();
        closeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scanBtn.setText("Scan");
        scanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanBtnActionPerformed(evt);
            }
        });

        selectFileBtn.setText("Select File");
        selectFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFileBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Current Selected File:");

        selectedFileLbl.setText("Empty");

        jLabel2.setText("Hash:");

        hashLbl.setText("Empty");

        closeBtn.setText("Close");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scanBtn)
                    .addComponent(selectFileBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectedFileLbl)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(hashLbl))))
                .addContainerGap(224, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeBtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectFileBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectedFileLbl)
                .addGap(18, 18, 18)
                .addComponent(scanBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hashLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(closeBtn)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    File file = null;
    String logId;
    
    private void scanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanBtnActionPerformed
        FileIO io = new FileIO();
        String hash = null;
        try {
            logId = genId("log.txt");
        } catch (IOException ex) {
            Logger.getLogger(Scanner.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(file == null){
            JOptionPane.showMessageDialog(null, "Please select a file!");
        }else{
            try {
                // TODO add your handling code here:
                hash = Hash.getFileChecksum(Hash.md5(), file);
                hashLbl.setText(hash);
                int row = io.rowAmount("VirusDB.txt");
                String[][] VirusSigs = io.read2dArray("VirusDB.txt", row, 3);
                boolean found = false;
                int i = 0;
                while(found == false && i < row){
                    if(hash.equals(VirusSigs[i][1])){
                        found = true;
                    }
                    i++;
                }
                if(found){
                    JOptionPane.showMessageDialog(null, "Harmful file found and has been placed in quarantine!");
                    quarantine();
                }else{
                    JOptionPane.showMessageDialog(null, "No harmful file found!");
                }
                addLog();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Scanner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Scanner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_scanBtnActionPerformed

    private void selectFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileBtnActionPerformed
        // TODO add your handling code here:
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            file = fc.getSelectedFile();
            selectedFileLbl.setText(file.getName());
        }
    }//GEN-LAST:event_selectFileBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        // TODO add your handling code here:
        new MainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    /**
     *
     * @throws IOException
     */
    public void addLog() throws IOException{
        FileIO io = new FileIO();
        String[] logDataArray = new String[4];
        logDataArray[0] = logId;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        logDataArray[1] = dateFormat.format(date);
        logDataArray[2] = file.getAbsolutePath();
        logDataArray[3] = User.userId;
        String logData = String.join(",", logDataArray);
        io.saveLine("log.txt", logData, true);     
    }
    
    /**
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public String genId(String filename) throws IOException{
        FileIO io = new FileIO();
        if(io.rowAmount(filename) == 0){
            return "100";
        }else{
          int[] usedId = new int[io.rowAmount(filename)];
            String[] line;
            int id;
            String[] ids = io.read(filename);
            for(int i = 0; i < ids.length; i++){
                line = ids[i].split(",");
                id = Integer.parseInt(line[0]);
                usedId[i] = id;
            }
            return String.valueOf(usedId[usedId.length-1]+1);   
        }
    }
    
    private void quarantine() throws IOException {     
        FileIO io = new FileIO();
        String[] quarantineDataArray = new String[3];
        quarantineDataArray[0] = logId;
        quarantineDataArray[1] = file.getName();
        quarantineDataArray[2] = file.getAbsolutePath();
        String quarData = String.join(",", quarantineDataArray);
        io.saveLine("quarantineDB.txt", quarData, true);
        
        Path path = Paths.get("quarantine/" + file.getName());
        
        Files.move(file.toPath(), path, REPLACE_EXISTING);
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
            java.util.logging.Logger.getLogger(Scanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scanner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Scanner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel hashLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton scanBtn;
    private javax.swing.JButton selectFileBtn;
    private javax.swing.JLabel selectedFileLbl;
    // End of variables declaration//GEN-END:variables
  
}