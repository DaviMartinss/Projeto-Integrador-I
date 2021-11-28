/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;
import DAO.UsuarioDAO;
import java.sql.*;
import DAO.moduloConexao;
import Model.Usuario;
import javax.swing.JOptionPane;
/**
 *
 * @author pc
 */
public class TelaUsuario_cadastrar extends javax.swing.JFrame {

    /**
     * Creates new form TelaUsuario_cadastrar
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelaUsuario_cadastrar() {
        initComponents();
        //conexao = moduloConexao.conector();
        this.setLocationRelativeTo(null);
        txtAvatar.setEnabled(false);
        
    }
    
    void volta_telaLogin(){
        
         TelaLogin telaDeLogin= new TelaLogin();
         telaDeLogin.setVisible(true);
         this.dispose();
         
    }
    
    
    private void cadastro_cliente(){

        Usuario novo_usuario = new Usuario(txtNome.getText(), txtEmail.getText(), txtSenha.getText());
        
        UsuarioDAO userDAO = new UsuarioDAO();
        
        try {
            
            userDAO.CadastrarUsuario(novo_usuario);
            
            volta_telaLogin();
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
  
    }
    
    void VoltarLogin(){
         //telaCliente cadastroCliente = new telaCliente();
         TelaLogin tela_login = new TelaLogin();
         tela_login.setVisible(true);
         this.dispose();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pageTitle = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        txtAvatar = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        btnRealizarCadastro = new javax.swing.JButton();
        nameTitle = new javax.swing.JLabel();
        emailTitle = new javax.swing.JLabel();
        passwdTitle = new javax.swing.JLabel();
        avatarTitle = new javax.swing.JLabel();
        iconPed12 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        pageTitle.setFont(new java.awt.Font("Noto Serif", 1, 18)); // NOI18N
        pageTitle.setText("Cadastro de Usuário");
        getContentPane().add(pageTitle);
        pageTitle.setBounds(300, 0, 190, 26);

        txtNome.setBackground(new java.awt.Color(187, 210, 240));
        txtNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txtNome);
        txtNome.setBounds(200, 120, 400, 27);

        txtEmail.setBackground(new java.awt.Color(187, 210, 240));
        txtEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txtEmail);
        txtEmail.setBounds(200, 180, 400, 27);

        txtSenha.setBackground(new java.awt.Color(187, 210, 240));
        txtSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txtSenha);
        txtSenha.setBounds(200, 240, 400, 27);

        txtAvatar.setBackground(new java.awt.Color(187, 210, 240));
        txtAvatar.setToolTipText("");
        txtAvatar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAvatarActionPerformed(evt);
            }
        });
        getContentPane().add(txtAvatar);
        txtAvatar.setBounds(200, 300, 400, 27);

        btnVoltar.setBackground(new java.awt.Color(105, 69, 219));
        btnVoltar.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar);
        btnVoltar.setBounds(30, 50, 100, 27);

        btnRealizarCadastro.setBackground(new java.awt.Color(105, 69, 219));
        btnRealizarCadastro.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        btnRealizarCadastro.setForeground(new java.awt.Color(255, 255, 255));
        btnRealizarCadastro.setText("Realizar cadastro");
        btnRealizarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(btnRealizarCadastro);
        btnRealizarCadastro.setBounds(330, 350, 138, 27);

        nameTitle.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        nameTitle.setText("Nome");
        getContentPane().add(nameTitle);
        nameTitle.setBounds(200, 100, 50, 27);

        emailTitle.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        emailTitle.setText("Email");
        getContentPane().add(emailTitle);
        emailTitle.setBounds(200, 160, 50, 27);

        passwdTitle.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        passwdTitle.setText("Senha");
        getContentPane().add(passwdTitle);
        passwdTitle.setBounds(200, 220, 60, 27);

        avatarTitle.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        avatarTitle.setText("Avatar");
        getContentPane().add(avatarTitle);
        avatarTitle.setBounds(200, 280, 60, 27);

        iconPed12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-140x100.png"))); // NOI18N
        getContentPane().add(iconPed12);
        iconPed12.setBounds(600, 430, 140, 100);

        background.setBackground(new java.awt.Color(187, 210, 240));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Back-2.png"))); // NOI18N
        background.setText("jLabel5");
        getContentPane().add(background);
        background.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAvatarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvatarActionPerformed

    private void btnRealizarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarCadastroActionPerformed
        // TODO add your handling code here:
        
        if(  txtNome.getText().isEmpty() || txtEmail.getText().isEmpty()   ||
             txtSenha.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(this, "Todos campos são de preenchimento obrigatório!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            
        }else{
            
            cadastro_cliente();

        } 
        
    }//GEN-LAST:event_btnRealizarCadastroActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        
        VoltarLogin();
        
        
    }//GEN-LAST:event_btnVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaUsuario_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuario_cadastrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatarTitle;
    private javax.swing.JLabel background;
    private javax.swing.JButton btnRealizarCadastro;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel emailTitle;
    private javax.swing.JLabel iconPed12;
    private javax.swing.JLabel nameTitle;
    private javax.swing.JLabel pageTitle;
    private javax.swing.JLabel passwdTitle;
    private javax.swing.JTextField txtAvatar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
