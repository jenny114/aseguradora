/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.DBAseguradora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class Compañia extends javax.swing.JFrame {
 connection Ca=new connection();
    Connection AS=Ca.conexiondb();
    PreparedStatement ps=null;
    ResultSet re=null;
    /**
     * Creates new form Compañoa
     */
    public Compañia() {
        initComponents();
        Cargartablas();
       
    }

public void Cargartablas(){
    DefaultTableModel tabla=new DefaultTableModel();
        tabla.addColumn("NIT");
        tabla.addColumn("Nombre Compañia");
        tabla.addColumn("Año de fundacion");
        tabla.addColumn("Representante legal");
        
        
       
        
        tablaconsulta.setModel(tabla);
        String datos[]=new String[9];
        try{
            ps=AS.prepareStatement("SELECT*FROM compania");
            re=ps.executeQuery();
            while(re.next()){
                datos[0]=re.getString(1);
                datos[1]=re.getString(2);
                datos[2]=re.getString(3);
                datos[3]=re.getString(4);
                
                
                tabla.addRow(datos);
                
            }
        }
        catch (Exception e){
            System.out.print(e);
            
        }
        
}        
    public void Registrar(){
    try{
    
    ps=AS.prepareStatement("INSERT INTO compania(comnit,comnombre,comanofun,comreplegal) values (?,?,?,?)");
    ps.setString(1,jTextnit.getText());
    ps.setString(2,jTextnE.getText());
    ps.setInt(3,Integer.parseInt(jTextAF.getText()));
    ps.setString(4,jTexRP.getText());

    ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Datos guardados");
    }
    catch (Exception e){
    System.out.print("es " + e);
    }
}
    public void Eliminar(String dat){
        try{
        ps=AS.prepareStatement("DELETE FROM compania where  comnit='"+dat+"' ");
        ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos eliminados");
        }
            catch(Exception e){
                    System.out.print(e);
                    }
        }

      public void Modificar(String  cod,String nom,String fe,String le){
        try{
            ps=AS.prepareStatement("UPDATE compania SET comnombre='"+nom+"',comanofun='"+fe+"',comreplegal='"+le+"' where comnit='"+ cod +"' ");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Modificados");
        }
        catch(Exception e){
            
            System.out.print( e);
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
        tablaconsulta = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextnit = new javax.swing.JTextField();
        jTextnE = new javax.swing.JTextField();
        jTextAF = new javax.swing.JTextField();
        jTexRP = new javax.swing.JTextField();
        jBuModifi = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaconsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaconsulta);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 780, 198));

        jButton7.setText("Registrar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 223, -1, -1));

        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 223, -1, -1));

        jButton5.setText("Limpiar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 223, -1, -1));

        jButton1.setText("ATRAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 223, -1, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nit");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre empresa");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Año de fundacion");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Representante legal");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));
        getContentPane().add(jTextnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 147, 28));
        getContentPane().add(jTextnE, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 147, 28));
        getContentPane().add(jTextAF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 147, 28));
        getContentPane().add(jTexRP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 147, 28));

        jBuModifi.setText("Modificar");
        jBuModifi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuModifiActionPerformed(evt);
            }
        });
        getContentPane().add(jBuModifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 223, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compañia.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 840, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Registrar();
        Cargartablas();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String dat=jTextnit.getText();
        Eliminar(dat);
        Cargartablas();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTextnit.setText(null);
        jTextnE.setText(null);
        jTextAF.setText(null);
        jTexRP.setText(null);
 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ASE a=new ASE();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBuModifiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuModifiActionPerformed
        String  cod,nom,fe,le;
       
        cod=jTextnit.getText();
     
        nom=jTextnE.getText();
        fe=jTextAF.getText();
        le=jTexRP.getText();
       

        Modificar(cod, nom, fe, le);
        Cargartablas();
    }//GEN-LAST:event_jBuModifiActionPerformed

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
            java.util.logging.Logger.getLogger(Compañia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compañia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compañia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compañia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compañia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBuModifi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTexRP;
    private javax.swing.JTextField jTextAF;
    private javax.swing.JTextField jTextnE;
    private javax.swing.JTextField jTextnit;
    private javax.swing.JTable tablaconsulta;
    // End of variables declaration//GEN-END:variables
}
