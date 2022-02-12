/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ControlerCartaoCredito;
import Model.CartaoCredito;
import Utilities.Validacao;
import com.mysql.cj.util.StringUtils;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan
 */
public class TelaAtualizarCartaoCredito extends javax.swing.JFrame {

    private CartaoCredito cartaoCredito = null;
    
    /**
     * Creates new form TelaAtualizarCartaoCredito
     */
    public TelaAtualizarCartaoCredito() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    void TelaCartaoCredito() {

        TelaCartao_credito TelaCartao_credito = null;

        if (TelaCartao_credito == null) {

            TelaCartao_credito = new TelaCartao_credito();

            TelaCartao_credito.setVisible(true);

            TelaCartao_credito.receberID(Integer.toString(cartaoCredito.getId_conta()));

        } else {

            TelaCartao_credito.setVisible(true);

            TelaCartao_credito.setState(TelaPrincipal.NORMAL);

            TelaCartao_credito.receberID(Integer.toString(cartaoCredito.getId_conta()));

        }

        this.dispose();
    }
    
    void AtualizarCartaoCredito() {
        
        try {

            CartaoCredito cartao_aux = new CartaoCredito.CartaoCreditoBuild().build();

            if (StringUtils.isNullOrEmpty(txt_NumCartaoC.getText())
                    || StringUtils.isNullOrEmpty(txt_ValorFatura.getText())
                    || StringUtils.isNullOrEmpty(txt_Limite.getText())
                    || StringUtils.isNullOrEmpty(txt_Bandeira.getText())
                    || StringUtils.isNullOrEmpty(txt_DiaFatura.getText())) {
                JOptionPane.showMessageDialog(this, "Nenhum Campo ser vazio", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (!(cartao_aux.Update_CamposValidos(txt_ValorFatura.getText(), txt_Bandeira.getText(), txt_Limite.getText(), txt_DiaFatura.getText()))) {
                JOptionPane.showMessageDialog(this, "Valor inválido", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (!(Validacao.isNumeric(txt_NumCartaoC.getText()))) {
                JOptionPane.showMessageDialog(this, "Valor inválido", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            CartaoCredito cartao_c = new CartaoCredito.CartaoCreditoBuild(
                    Long.parseLong(txt_NumCartaoC.getText()))
                    .Limite(Float.parseFloat(txt_Limite.getText()))
                    .DiaFatura(Integer.parseInt(txt_DiaFatura.getText()))
                    .ValorFatura(Float.parseFloat(txt_ValorFatura.getText()))
                    .Bandeira(txt_Bandeira.getText())
                    .IdConta(this.cartaoCredito.getId_conta())
                    .NumCartaoAux(this.cartaoCredito.getN_cartao_credito())
                    .build();
                        /*
                    CartaoCredito cartao_c = new CartaoCredito(
                            Long.parseLong(txt_NumCartaoC.getText()),
                            Float.parseFloat(txt_Limite.getText()),
                            Integer.parseInt(txt_DiaFatura.getText()),
                            Float.parseFloat(txt_ValorFatura.getText()),
                            txt_Bandeira.getText(),
                            this.cartaoCredito.getId_conta(),
                            this.cartaoCredito.getN_cartao_credito()
                    );
                         */
            //Verifica se o número do cartao de crédito foi modificado
            if (cartao_c.getN_cartao_credito() != this.cartaoCredito.getN_cartao_credito()) {
                //Verifica se o novo número já existe
                if (ControlerCartaoCredito.GetCartaoCredito(cartao_c.getN_cartao_credito(), cartao_c.getId_conta()) != null) {
                    JOptionPane.showMessageDialog(null, "Número de Cartão de Crédito já existe!!\n Tente outro número", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            if (cartao_c.varifica_valor_fatura()
                    && cartao_c.verifica_bandeira()
                    && cartao_c.verifica_dia_fatura()
                    && cartao_c.verifica_limite()) {

                if (!(cartao_c.ValidaNUM_Cartao(txt_NumCartaoC.getText()))) {

                    JOptionPane.showMessageDialog(this, "Número do cartão de crédito inválido", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);

                } else {

                    ControlerCartaoCredito.AtualizarCartaoCredito(cartao_c);
                }

            } else {

                JOptionPane.showMessageDialog(this, "Dados Inválidos, impossível atuzalizar!!", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (HeadlessException | NullPointerException | NumberFormatException e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
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

        numCardTitle = new javax.swing.JLabel();
        txt_NumCartaoC = new javax.swing.JTextField();
        invoiceValueTitle = new javax.swing.JLabel();
        txt_ValorFatura = new javax.swing.JTextField();
        limitTitle = new javax.swing.JLabel();
        txt_Limite = new javax.swing.JTextField();
        txt_DiaFatura = new javax.swing.JTextField();
        invoiceDayTitle = new javax.swing.JLabel();
        txt_Bandeira = new javax.swing.JTextField();
        flagTitle = new javax.swing.JLabel();
        numCardTitle1 = new javax.swing.JLabel();
        btn_update = new javax.swing.JButton();
        btnReceitas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        numCardTitle.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        numCardTitle.setText("Número do cartão");
        getContentPane().add(numCardTitle);
        numCardTitle.setBounds(120, 240, 130, 27);

        txt_NumCartaoC.setBackground(new java.awt.Color(187, 210, 240));
        txt_NumCartaoC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txt_NumCartaoC);
        txt_NumCartaoC.setBounds(115, 271, 400, 27);

        invoiceValueTitle.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        invoiceValueTitle.setText("Valor da Fatura");
        getContentPane().add(invoiceValueTitle);
        invoiceValueTitle.setBounds(535, 251, 100, 27);

        txt_ValorFatura.setBackground(new java.awt.Color(187, 210, 240));
        txt_ValorFatura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txt_ValorFatura);
        txt_ValorFatura.setBounds(535, 271, 150, 27);

        limitTitle.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        limitTitle.setText("Limite");
        getContentPane().add(limitTitle);
        limitTitle.setBounds(535, 301, 100, 27);

        txt_Limite.setBackground(new java.awt.Color(187, 210, 240));
        txt_Limite.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txt_Limite);
        txt_Limite.setBounds(535, 321, 150, 27);

        txt_DiaFatura.setBackground(new java.awt.Color(187, 210, 240));
        txt_DiaFatura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txt_DiaFatura);
        txt_DiaFatura.setBounds(395, 321, 50, 27);

        invoiceDayTitle.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        invoiceDayTitle.setText("Dia da Fatura");
        getContentPane().add(invoiceDayTitle);
        invoiceDayTitle.setBounds(395, 301, 100, 27);

        txt_Bandeira.setBackground(new java.awt.Color(187, 210, 240));
        txt_Bandeira.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txt_Bandeira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BandeiraActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Bandeira);
        txt_Bandeira.setBounds(115, 321, 250, 27);

        flagTitle.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        flagTitle.setText("Bandeira");
        getContentPane().add(flagTitle);
        flagTitle.setBounds(115, 301, 100, 27);

        numCardTitle1.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        numCardTitle1.setText("Atualizar Cartão de Crédito");
        getContentPane().add(numCardTitle1);
        numCardTitle1.setBounds(292, 20, 152, 34);

        btn_update.setBackground(new java.awt.Color(105, 69, 219));
        btn_update.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Atualizar");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_update);
        btn_update.setBounds(290, 430, 140, 25);

        btnReceitas.setBackground(new java.awt.Color(105, 69, 219));
        btnReceitas.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        btnReceitas.setForeground(new java.awt.Color(255, 255, 255));
        btnReceitas.setText("Voltar");
        btnReceitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceitasActionPerformed(evt);
            }
        });
        getContentPane().add(btnReceitas);
        btnReceitas.setBounds(470, 430, 111, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_BandeiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BandeiraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BandeiraActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:

        AtualizarCartaoCredito();
        TelaCartaoCredito();

    }//GEN-LAST:event_btn_updateActionPerformed

    private void btnReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceitasActionPerformed
        // TODO add your handling code here:
        TelaCartaoCredito();
    }//GEN-LAST:event_btnReceitasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        try {
            txt_NumCartaoC.setText(Long.toString(cartaoCredito.getN_cartao_credito()));
            txt_Limite.setText(Float.toString(cartaoCredito.getLimite()));
            txt_ValorFatura.setText(Float.toString(cartaoCredito.getValor_fatura()));
            txt_DiaFatura.setText(Integer.toString(cartaoCredito.getDia_fatura()));
            txt_Bandeira.setText(cartaoCredito.getBandeira());
            
        } catch (NumberFormatException e) {
            
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(TelaAtualizarCartaoCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAtualizarCartaoCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAtualizarCartaoCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAtualizarCartaoCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaAtualizarCartaoCredito().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReceitas;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel flagTitle;
    private javax.swing.JLabel invoiceDayTitle;
    private javax.swing.JLabel invoiceValueTitle;
    private javax.swing.JLabel limitTitle;
    private javax.swing.JLabel numCardTitle;
    private javax.swing.JLabel numCardTitle1;
    private javax.swing.JTextField txt_Bandeira;
    private javax.swing.JTextField txt_DiaFatura;
    private javax.swing.JTextField txt_Limite;
    private javax.swing.JTextField txt_NumCartaoC;
    private javax.swing.JTextField txt_ValorFatura;
    // End of variables declaration//GEN-END:variables


public void receberCartaoCredito(CartaoCredito cartaoCredito) {
    
   this.cartaoCredito = cartaoCredito;
}

}