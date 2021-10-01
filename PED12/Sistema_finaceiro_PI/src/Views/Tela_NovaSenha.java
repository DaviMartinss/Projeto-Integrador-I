/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAO.UsuarioDAO;
import Model.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class Tela_NovaSenha extends javax.swing.JFrame {
    int salvaId = -1;
    /**
     * Creates new form Tela_NovaSenha
     */
    public Tela_NovaSenha() {
        initComponents();
    }
    
    void volta_telaLogin(){
        
         TelaLogin telaDeLogin= new TelaLogin();
         telaDeLogin.setVisible(true);
         this.dispose();
         
    }
    void recebeID(int id){
        salvaId = id;
    }
    
    void  nova_Senha() {
        
            String senha1 = new String(this.txt_NovaSenha.getPassword());
            String senha2 = new String(this.txt_ConfirmaSenha.getPassword());
            
            
            Usuario senhaUser = new Usuario(
                senha1,
                senha2,
                salvaId
                
        );

        UsuarioDAO UserSenhaDAO = new UsuarioDAO();

        try {
            
            if (UserSenhaDAO.valida_UpdateSenha(senha1, senha2)){
                
                if(senhaUser.validaTamSenha(senha1)){
                    
                    UserSenhaDAO.UpdateSenha(senhaUser);
                    JOptionPane.showMessageDialog(null, "Senha atualizada com sucesso");
                    volta_telaLogin();
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null, "Falha,A senha dever ter no mínimo 6 caracteres!");
                }
                
                
            }else{
                
                JOptionPane.showMessageDialog(null, "Dados Inválidos, impossível atualizar!!");
                
            }

        } catch (Exception e) {

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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_NovaSenha = new javax.swing.JPasswordField();
        txt_ConfirmaSenha = new javax.swing.JPasswordField();
        btn_AlteraSenha = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("senha");

        jLabel3.setText("Confirma seenha");

        btn_AlteraSenha.setText("Salvar");
        btn_AlteraSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AlteraSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_AlteraSenha)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_NovaSenha)
                        .addComponent(txt_ConfirmaSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_NovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_ConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(btn_AlteraSenha)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AlteraSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AlteraSenhaActionPerformed
        // TODO add your handling code here:
        nova_Senha();
    }//GEN-LAST:event_btn_AlteraSenhaActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_NovaSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_NovaSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_NovaSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_NovaSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_NovaSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AlteraSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txt_ConfirmaSenha;
    private javax.swing.JPasswordField txt_NovaSenha;
    // End of variables declaration//GEN-END:variables
}