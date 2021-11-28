/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAO.CartaoDebitoDAO;
import DAO.moduloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Model.CartaoDebito;
import ValidacaoComum.Validacao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
/**
 *
 * @author pc
 */
public class TelaCartaoDebito_cadastrar extends javax.swing.JFrame {

    public TelaCartaoDebito_cadastrar() {
        initComponents();
        this.setLocationRelativeTo(null);
        txt_id.setVisible(false);
    }
    
    void voltaTelaCartao_Debito(){

          TelaCartao_debito TelaCartao_debito = null;

        if (TelaCartao_debito == null) {

            TelaCartao_debito = new TelaCartao_debito();

            TelaCartao_debito.setVisible(true);

            TelaCartao_debito.receberID(txt_id.getText());

        } else {

            TelaCartao_debito.setVisible(true);

            TelaCartao_debito.setState(TelaPrincipal.NORMAL);

            TelaCartao_debito.receberID(txt_id.getText());

        }

        this.dispose();

    }
    
    
   public void cadastro_cartao_debito(){

        CartaoDebito cartao_db = new CartaoDebito(
                Long.parseLong(txt_numCartDeb.getText()),
                Float.parseFloat(txt_valorCartaoDeb.getText()),
                txt_BandCartDeb.getText(),
                Integer.parseInt(txt_id.getText())
        );

        CartaoDebitoDAO cartao_dbDAO = new CartaoDebitoDAO();

        try {
            
            
            if (cartao_db.verifica_Bandeira_cartao_deb() && cartao_db.verifica_valor_atual())
            {
                
                cartao_dbDAO.CadastrarCartaoDebito(cartao_db);
                
                voltaTelaCartao_Debito();
                
            }else{
                
                JOptionPane.showMessageDialog(null, "Dados Inválidos!!");
                
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }

   void inicio(){
         
         TelaPrincipal TelaPrincipal = null;
         
         if (TelaPrincipal == null) {

             TelaPrincipal = new TelaPrincipal();

             TelaPrincipal.setVisible(true);

             TelaPrincipal.receberID(txt_id.getText());

         } else {

             TelaPrincipal.setVisible(true);

             TelaPrincipal.setState(TelaPrincipal.NORMAL);

             TelaPrincipal.receberID(txt_id.getText());
         }
         
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

        jTextField1 = new javax.swing.JTextField();
        pageTitle = new javax.swing.JLabel();
        cardNumber = new javax.swing.JLabel();
        currentValue = new javax.swing.JLabel();
        cardFlag = new javax.swing.JLabel();
        ped12Icon = new javax.swing.JLabel();
        txt_numCartDeb = new javax.swing.JTextField();
        txt_BandCartDeb = new javax.swing.JTextField();
        txt_valorCartaoDeb = new javax.swing.JTextField();
        btn_cadastraCartDeb = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        pageTitle.setFont(new java.awt.Font("Noto Serif", 1, 18)); // NOI18N
        pageTitle.setText("Cadastrar Cartão de Débito");
        getContentPane().add(pageTitle);
        pageTitle.setBounds(280, 0, 260, 27);

        cardNumber.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        cardNumber.setText("Número do cartão");
        getContentPane().add(cardNumber);
        cardNumber.setBounds(200, 140, 130, 27);

        currentValue.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        currentValue.setText("Valor Atual");
        getContentPane().add(currentValue);
        currentValue.setBounds(200, 200, 80, 27);

        cardFlag.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        cardFlag.setText("Bandeira");
        getContentPane().add(cardFlag);
        cardFlag.setBounds(200, 260, 70, 27);

        ped12Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-140x100.png"))); // NOI18N
        getContentPane().add(ped12Icon);
        ped12Icon.setBounds(620, 400, 140, 130);

        txt_numCartDeb.setBackground(new java.awt.Color(187, 210, 240));
        txt_numCartDeb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txt_numCartDeb);
        txt_numCartDeb.setBounds(200, 160, 400, 27);

        txt_BandCartDeb.setBackground(new java.awt.Color(187, 210, 240));
        txt_BandCartDeb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txt_BandCartDeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BandCartDebActionPerformed(evt);
            }
        });
        getContentPane().add(txt_BandCartDeb);
        txt_BandCartDeb.setBounds(200, 280, 400, 27);

        txt_valorCartaoDeb.setBackground(new java.awt.Color(187, 210, 240));
        txt_valorCartaoDeb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txt_valorCartaoDeb);
        txt_valorCartaoDeb.setBounds(200, 220, 400, 27);

        btn_cadastraCartDeb.setBackground(new java.awt.Color(105, 69, 219));
        btn_cadastraCartDeb.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        btn_cadastraCartDeb.setForeground(new java.awt.Color(255, 255, 255));
        btn_cadastraCartDeb.setText("Cadastrar");
        btn_cadastraCartDeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastraCartDebActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cadastraCartDeb);
        btn_cadastraCartDeb.setBounds(200, 340, 150, 27);

        startButton.setBackground(new java.awt.Color(105, 69, 219));
        startButton.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setText("Início");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startButton);
        startButton.setBounds(40, 60, 100, 27);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Back-2.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1920, 1080);

        txt_id.setEditable(false);
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        getContentPane().add(txt_id);
        txt_id.setBounds(343, 42, 81, 21);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastraCartDebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastraCartDebActionPerformed
       
        if(  txt_numCartDeb.getText().isEmpty() || txt_valorCartaoDeb.getText().isEmpty()   ||
             txt_BandCartDeb.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Todos campos são de preenchimento obrigatório!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            
        }else{
            
            Validacao valida = new Validacao();
            
            if(!( valida.ehNum(txt_numCartDeb.getText()) && valida.ehNum(txt_valorCartaoDeb.getText()))) {
                JOptionPane.showMessageDialog(null, "Informe um valor numérico válido!!");
                return;
            }
            
            
            boolean cadastra = true;
            
            CartaoDebitoDAO cartaoDAO = new CartaoDebitoDAO();
            
            CartaoDebito cartaoDB = new CartaoDebito(
                                      Long.parseLong(txt_numCartDeb.getText()),
                                      Float.parseFloat(txt_valorCartaoDeb.getText()),
                                      txt_BandCartDeb.getText(),
                                      Integer.parseInt(txt_id.getText())
                                            
            );
            
            try {
                if(cartaoDAO.CartaoDebitoExiste(cartaoDB)){
                            
                    JOptionPane.showMessageDialog(null, "Número do cartão de débito já existe", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                    
                    cadastra = false;
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(TelaCartaoDebito_cadastrar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            if(!(cartaoDB.verifica_num_cartao_deb())){
                
                JOptionPane.showMessageDialog(null, "Número do cartão de débito inválido", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                
                cadastra = false;
            }
            
            if(!(cartaoDB.verifica_valor_atual())){
                
                JOptionPane.showMessageDialog(null, "Valor inválido", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                
                cadastra = false;
            }
            
            if(!(cartaoDB.verifica_Bandeira_cartao_deb())){
                
                JOptionPane.showMessageDialog(null, "Bandeira inválida", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                
                cadastra = false;
            }
     
            if(cadastra){
                
                cadastro_cartao_debito();
                
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "INFORMATION_MESSAGE" , JOptionPane.INFORMATION_MESSAGE);
                
            }
            
            

        } 
 
    }//GEN-LAST:event_btn_cadastraCartDebActionPerformed

    private void txt_BandCartDebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BandCartDebActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BandCartDebActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        inicio();
    }//GEN-LAST:event_startButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCartaoDebito_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCartaoDebito_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCartaoDebito_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCartaoDebito_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCartaoDebito_cadastrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_cadastraCartDeb;
    private javax.swing.JLabel cardFlag;
    private javax.swing.JLabel cardNumber;
    private javax.swing.JLabel currentValue;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel pageTitle;
    private javax.swing.JLabel ped12Icon;
    private javax.swing.JButton startButton;
    private javax.swing.JTextField txt_BandCartDeb;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_numCartDeb;
    private javax.swing.JTextField txt_valorCartaoDeb;
    // End of variables declaration//GEN-END:variables



    public void receberID(String recebe){

        txt_id.setText(recebe);
    }


}
