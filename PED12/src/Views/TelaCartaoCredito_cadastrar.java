/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAO.UsuarioDAO;
import Model.CartaoCredito;
import DAO.moduloConexao;
import DAO.CartaoCreditoDAO;
import Model.Cartao;
import ValidacaoComum.Validacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;
import Views.TelaLogin;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */

public class TelaCartaoCredito_cadastrar extends javax.swing.JFrame {
    
    //Usuario usuarioConta = new Usuario();

    public TelaCartaoCredito_cadastrar() {

        initComponents();
        this.setLocationRelativeTo(null);

        txt_id.setVisible(false);
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

    void volta_telaCartaoDeCredito() {
       
        TelaCartao_credito TelaCartao_credito = null;

        if (TelaCartao_credito == null) {

            TelaCartao_credito = new TelaCartao_credito();

            TelaCartao_credito.setVisible(true);

            TelaCartao_credito.receberID(txt_id.getText());

        } else {

            TelaCartao_credito.setVisible(true);

            TelaCartao_credito.setState(TelaPrincipal.NORMAL);

            TelaCartao_credito.receberID(txt_id.getText());

        }

        this.dispose();
    }

    public void cadastro_cartao_credito() {
        
        CartaoCredito cartao_aux = new CartaoCredito();
        
        if(cartao_aux.UpdateEhVazio(txt_NumCC.getText(), txt_ValorFatura.getText(), txt_LimiteCC.getText(), txt_BandeiraCC.getText(), txt_DiaFaturaCC.getText())){
            JOptionPane.showMessageDialog(null, "Nenhum Campo ser vazio");
            return;
         }
        
        CartaoCredito cartao_c = new CartaoCredito(
                Long.parseLong(txt_NumCC.getText()),
                Float.parseFloat(txt_LimiteCC.getText()),
                Integer.parseInt(txt_DiaFaturaCC.getText()),
                Float.parseFloat(txt_ValorFatura.getText()),
                txt_BandeiraCC.getText(),
                Integer.parseInt(txt_id.getText())
        );

        CartaoCreditoDAO cartao_creditoDAO = new CartaoCreditoDAO();

        try {
            
            if (cartao_c.verifica_bandeira_credito()
                    && cartao_c.verifica_dia_fatura()
                    && cartao_c.verifica_limite())
            {
                
                cartao_creditoDAO.CadastrarCartaoCredito(cartao_c);
                
                volta_telaCartaoDeCredito();
                
            }else{
                
                JOptionPane.showMessageDialog(null, "Dados Inválidos!!");
                
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

        pageTitle = new javax.swing.JLabel();
        txt_NumCC = new javax.swing.JTextField();
        txt_DiaFaturaCC = new javax.swing.JTextField();
        txt_BandeiraCC = new javax.swing.JTextField();
        txt_LimiteCC = new javax.swing.JTextField();
        txt_ValorFatura = new javax.swing.JTextField();
        cardNum = new javax.swing.JLabel();
        cardLimit = new javax.swing.JLabel();
        invoiceValue = new javax.swing.JLabel();
        invoiceDay = new javax.swing.JLabel();
        cardFlag = new javax.swing.JLabel();
        btn_inicio = new javax.swing.JButton();
        btn_cadastra_cartao = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cartão de Crédito");
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        pageTitle.setFont(new java.awt.Font("Noto Serif", 1, 18)); // NOI18N
        pageTitle.setText("Cadastrar Cartão de Crédito");
        getContentPane().add(pageTitle);
        pageTitle.setBounds(280, 0, 260, 27);

        txt_NumCC.setBackground(new java.awt.Color(187, 210, 240));
        txt_NumCC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txt_NumCC);
        txt_NumCC.setBounds(210, 120, 400, 27);

        txt_DiaFaturaCC.setBackground(new java.awt.Color(187, 210, 240));
        txt_DiaFaturaCC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txt_DiaFaturaCC);
        txt_DiaFaturaCC.setBounds(210, 300, 400, 27);

        txt_BandeiraCC.setBackground(new java.awt.Color(187, 210, 240));
        txt_BandeiraCC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txt_BandeiraCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BandeiraCCActionPerformed(evt);
            }
        });
        getContentPane().add(txt_BandeiraCC);
        txt_BandeiraCC.setBounds(210, 360, 400, 27);

        txt_LimiteCC.setBackground(new java.awt.Color(187, 210, 240));
        txt_LimiteCC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txt_LimiteCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_LimiteCCActionPerformed(evt);
            }
        });
        getContentPane().add(txt_LimiteCC);
        txt_LimiteCC.setBounds(210, 180, 400, 27);

        txt_ValorFatura.setBackground(new java.awt.Color(187, 210, 240));
        txt_ValorFatura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txt_ValorFatura);
        txt_ValorFatura.setBounds(210, 240, 400, 27);

        cardNum.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        cardNum.setText("Número do cartão");
        getContentPane().add(cardNum);
        cardNum.setBounds(210, 100, 120, 27);

        cardLimit.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        cardLimit.setText("Limite");
        getContentPane().add(cardLimit);
        cardLimit.setBounds(210, 160, 60, 27);

        invoiceValue.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        invoiceValue.setText("Valor da Fatura");
        getContentPane().add(invoiceValue);
        invoiceValue.setBounds(210, 220, 100, 27);

        invoiceDay.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        invoiceDay.setText("Dia da Fatura");
        getContentPane().add(invoiceDay);
        invoiceDay.setBounds(210, 280, 90, 27);

        cardFlag.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        cardFlag.setText("Bandeira");
        getContentPane().add(cardFlag);
        cardFlag.setBounds(210, 340, 70, 27);

        btn_inicio.setBackground(new java.awt.Color(105, 69, 219));
        btn_inicio.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        btn_inicio.setForeground(new java.awt.Color(255, 255, 255));
        btn_inicio.setText("Início");
        btn_inicio.setMaximumSize(new java.awt.Dimension(68, 30));
        btn_inicio.setMinimumSize(new java.awt.Dimension(68, 30));
        btn_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inicioActionPerformed(evt);
            }
        });
        getContentPane().add(btn_inicio);
        btn_inicio.setBounds(30, 40, 100, 27);

        btn_cadastra_cartao.setBackground(new java.awt.Color(105, 69, 219));
        btn_cadastra_cartao.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        btn_cadastra_cartao.setForeground(new java.awt.Color(255, 255, 255));
        btn_cadastra_cartao.setText("Cadastra cartao");
        btn_cadastra_cartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastra_cartaoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cadastra_cartao);
        btn_cadastra_cartao.setBounds(210, 410, 150, 27);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Back-2.png"))); // NOI18N
        background.setText("jLabel8");
        getContentPane().add(background);
        background.setBounds(0, 0, 1920, 1080);

        txt_id.setEditable(false);
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        getContentPane().add(txt_id);
        txt_id.setBounds(0, 0, 4, 21);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastra_cartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastra_cartaoActionPerformed
        // TODO add your handling code here:
        
        if( txt_NumCC.getText().isEmpty() || txt_LimiteCC.getText().isEmpty() ||
            txt_ValorFatura.getText().isEmpty() || txt_DiaFaturaCC.getText().isEmpty() ||
            txt_BandeiraCC.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Todos campos são de preenchimento obrigatório!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            
        }else{
            
            
            Validacao valida = new Validacao();
            
            
            if(!(valida.ehNum(txt_NumCC.getText())&& valida.ehNum(txt_ValorFatura.getText()) && valida.ehNum(txt_LimiteCC.getText()) && valida.ehNum(txt_DiaFaturaCC.getText())  )){
                JOptionPane.showMessageDialog(null, "Informe um valor numérico válido!!");
                return;
            } 
            
            
            boolean cadastra = true;
            
            CartaoCreditoDAO cartaoDAO = new CartaoCreditoDAO();
            
            CartaoCredito cartaoCC = new CartaoCredito(
                                      Long.parseLong(txt_NumCC.getText()),
                                      Float.parseFloat(txt_LimiteCC.getText()),
                                      Integer.parseInt(txt_DiaFaturaCC.getText()),
                                      Float.parseFloat(txt_ValorFatura.getText()),
                                      txt_BandeiraCC.getText(),
                                      Integer.parseInt(txt_id.getText())
                                            
            );
            
            try {
                if(cartaoDAO.CartaoCreditoExiste(cartaoCC)){
                            
                    JOptionPane.showMessageDialog(null, "Número do cartão de crédito já existe","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                    
                    cadastra = false;
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(TelaCartaoCredito_cadastrar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            if(!(cartaoCC.verifica_num_cartao_credito())){
                
                JOptionPane.showMessageDialog(null, "Número do cartão de crédito inválido","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                
                cadastra = false;
            }
            
            if(!(cartaoCC.verifica_bandeira_credito())){
                
                JOptionPane.showMessageDialog(null, "Bandeira inválida","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                
                cadastra = false;
            }
            
            if(cartaoCC.getValor_fatura() < 0 || cartaoCC.getLimite() < cartaoCC.getValor_fatura()){
                
                JOptionPane.showMessageDialog(null, "Valor da fatura inválido","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                
                cadastra = false;
            }
            
            if(!(cartaoCC.verifica_dia_fatura())){
                
                JOptionPane.showMessageDialog(null, "Dia da fatura inválido","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                
                cadastra = false;
            }
            
            if(!(cartaoCC.verifica_limite())){
                
                    JOptionPane.showMessageDialog(null, "Limite do cartão de crédito inválido","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                
                cadastra = false;
            }
            
            if(cadastra){
                
                cadastro_cartao_credito();
                
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "INFORMATION_MESSAGE" , JOptionPane.INFORMATION_MESSAGE);
                
            }

        }

    }//GEN-LAST:event_btn_cadastra_cartaoActionPerformed

    private void txt_LimiteCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_LimiteCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_LimiteCCActionPerformed

    private void txt_BandeiraCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BandeiraCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BandeiraCCActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void btn_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicioActionPerformed
        // TODO add your handling code here:
        inicio();
    }//GEN-LAST:event_btn_inicioActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCartaoCredito_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCartaoCredito_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCartaoCredito_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCartaoCredito_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCartaoCredito_cadastrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_cadastra_cartao;
    private javax.swing.JButton btn_inicio;
    private javax.swing.JLabel cardFlag;
    private javax.swing.JLabel cardLimit;
    private javax.swing.JLabel cardNum;
    private javax.swing.JLabel invoiceDay;
    private javax.swing.JLabel invoiceValue;
    private javax.swing.JLabel pageTitle;
    private javax.swing.JTextField txt_BandeiraCC;
    private javax.swing.JTextField txt_DiaFaturaCC;
    private javax.swing.JTextField txt_LimiteCC;
    private javax.swing.JTextField txt_NumCC;
    private javax.swing.JTextField txt_ValorFatura;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables

    public void receberID(String recebe) {

        txt_id.setText(recebe);
    }

}
