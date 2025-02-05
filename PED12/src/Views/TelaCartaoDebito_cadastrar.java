/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ControlerCartaoDebito;
import javax.swing.JOptionPane;
import Model.CartaoDebito;
import Utilities.Validacao;
import com.mysql.cj.util.StringUtils;
import java.awt.HeadlessException;
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
    
    void voltaTelaCartaoDebito(){

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
    
    void TelaPrincipal(){
         
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
    
    public void CadastrarCartaoDebito() {
 
        try {

            if (StringUtils.isNullOrEmpty(txt_numCartDeb.getText())
                    || StringUtils.isNullOrEmpty(txt_valorCartaoDeb.getText())
                    || StringUtils.isNullOrEmpty(txt_BandCartDeb.getText())) {

                JOptionPane.showMessageDialog(this, "Todos campos são de preenchimento obrigatório!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);

            } else {

                if (!(Validacao.isNumeric(txt_numCartDeb.getText()) && 
                      Validacao.isNumeric(txt_valorCartaoDeb.getText()))) 
                {
                    JOptionPane.showMessageDialog(this, "Informe um valor numérico válido!!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                boolean cadastra = true;

                CartaoDebito cartaoDB = new CartaoDebito.CartaoDebitoBuild(
                        Long.parseLong(txt_numCartDeb.getText()))
                        .ValorAtual(Float.parseFloat(txt_valorCartaoDeb.getText()))
                        .Bandeira(txt_BandCartDeb.getText())
                        .IdConta(Integer.parseInt(txt_id.getText()))
                        .build();

                if (ControlerCartaoDebito.CartaoDebitoExiste(cartaoDB)) {

                    JOptionPane.showMessageDialog(this, "Número do cartão de débito já existe", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                    cadastra = false;
                }

                if (!(cartaoDB.verifica_num_cartao_deb())) {

                    JOptionPane.showMessageDialog(this, "Número do cartão de débito inválido", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                    cadastra = false;
                }

                if (!(cartaoDB.verifica_valor_atual())) {

                    JOptionPane.showMessageDialog(this, "Valor inválido", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                    cadastra = false;
                }

                if (!(cartaoDB.verifica_bandeira())) {

                    JOptionPane.showMessageDialog(this, "Bandeira inválida", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                    cadastra = false;
                }

                if (cadastra) {

                    ControlerCartaoDebito.CadastrarCartaoDebito(cartaoDB);
                    voltaTelaCartaoDebito();
                    JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (HeadlessException | NumberFormatException | NullPointerException e) {
            
            JOptionPane.showMessageDialog(this, "Erro!" + e.getMessage(), "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            
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
        setTitle("Cadastrar Cartao de Debito");
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
        txt_id.setBounds(343, 42, 81, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastraCartDebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastraCartDebActionPerformed

        CadastrarCartaoDebito(); 

    }//GEN-LAST:event_btn_cadastraCartDebActionPerformed

    private void txt_BandCartDebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BandCartDebActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BandCartDebActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        TelaPrincipal();
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
        java.awt.EventQueue.invokeLater(() -> {
            new TelaCartaoDebito_cadastrar().setVisible(true);
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