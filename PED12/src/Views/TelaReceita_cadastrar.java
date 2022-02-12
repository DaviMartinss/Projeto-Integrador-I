/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ControlerReceita;
import javax.swing.JOptionPane;
import Model.Receita;
import Utilities.Validacao;
import com.mysql.cj.util.StringUtils;
import java.awt.HeadlessException;
/**
 *
 * @author Alan
 */
public class TelaReceita_cadastrar extends javax.swing.JFrame {

   
    /**
     * Creates new form TelaReceita_cadastrar
     */
    public TelaReceita_cadastrar() {
        initComponents();
        this.setLocationRelativeTo(null);
        txt_id.setVisible(false);
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
    
    void TelaReceita(){
        
         TelaReceita TelaReceita = null;

           if (TelaReceita == null) {

               TelaReceita = new TelaReceita();

               TelaReceita.setVisible(true);
               
               TelaReceita.receberID(txt_id.getText());

           } else {

               TelaReceita.setVisible(true);

               TelaReceita.setState(TelaPrincipal.NORMAL);

               TelaReceita.receberID(txt_id.getText());
                
           }
           
         this.dispose();
    }
    
    void CadastrarReceita(){
        
        if(  StringUtils.isNullOrEmpty(txt_dia.getText()) || 
             StringUtils.isNullOrEmpty(txt_mes.getText()) ||
             StringUtils.isNullOrEmpty(txt_ano.getText()) || 
             StringUtils.isNullOrEmpty(txt_total.getText()))
        {
            
            JOptionPane.showMessageDialog(this, "Todos campos são de preenchimento obrigatório!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(!(Validacao.isNumeric(txt_dia.getText()) && 
             Validacao.isNumeric(txt_mes.getText()) &&
             Validacao.isNumeric(txt_ano.getText()) && 
             Validacao.isNumeric(txt_total.getText())))
        {
            JOptionPane.showMessageDialog(null, "Informe um valor numérico válido!!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try { 
            
            boolean cadastra = true;
            
            String dataString = txt_dia.getText() + txt_mes.getText() + txt_ano.getText();
            
            if(!Validacao.isDate(dataString))
            {
                JOptionPane.showMessageDialog(null, "Informe uma data válida!!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                cadastra = false;
            }
             
        Receita receita = new Receita.ReceitaBuild(Integer.parseInt(txt_id.getText()), Integer.parseInt(txt_mes.getText()), Integer.parseInt(txt_ano.getText()))
                .Dia(Integer.parseInt(txt_dia.getText()))
                .Total(Float.parseFloat(txt_total.getText()))
                .build();
                /*
            Receita receita = new Receita(
                Integer.parseInt(txt_dia.getText()),
                Integer.parseInt(txt_mes.getText()),
                Integer.parseInt(txt_ano.getText()),
                Float.parseFloat(txt_total.getText()),
                Integer.parseInt(txt_id.getText())
            );
            */
            if (ControlerReceita.ReceitaExiste(receita.getMes(), receita.getAno(), receita.getId_conta())) {

                JOptionPane.showMessageDialog(this, "Receita já existe!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                cadastra = false;
            }

            if (!(receita.verifica_total())) {

                JOptionPane.showMessageDialog(this, "Valor inválido!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
                cadastra = false;
            }

            if (cadastra)
            {
                ControlerReceita.CadastrarReceita(receita);    
                JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                TelaReceita();
                
            }else{
                
                JOptionPane.showMessageDialog(this, "Dados Inválidos!!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);                
            }

        } catch (HeadlessException e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        
        }catch (NumberFormatException e) {
            
            JOptionPane.showMessageDialog(this, e.getMessage(), "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
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

        txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_dia = new javax.swing.JTextField();
        txt_mes = new javax.swing.JTextField();
        txt_ano = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        btn_inicio = new javax.swing.JButton();
        btn_NovaReceita = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dateTitle = new javax.swing.JLabel();
        dayBarTitle = new javax.swing.JLabel();
        monthBarTitle = new javax.swing.JLabel();
        iconPed12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        txt_id.setEditable(false);
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Noto Serif", 1, 18)); // NOI18N
        jLabel2.setText("CADASTRAR NOVA RECEITA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(280, 0, 280, 27);

        txt_dia.setBackground(new java.awt.Color(187, 210, 240));
        txt_dia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txt_dia);
        txt_dia.setBounds(40, 140, 50, 27);

        txt_mes.setBackground(new java.awt.Color(187, 210, 240));
        txt_mes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txt_mes);
        txt_mes.setBounds(100, 140, 50, 27);

        txt_ano.setBackground(new java.awt.Color(187, 210, 240));
        txt_ano.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txt_ano);
        txt_ano.setBounds(160, 140, 50, 27);

        txt_total.setBackground(new java.awt.Color(187, 210, 240));
        txt_total.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txt_total);
        txt_total.setBounds(40, 210, 200, 27);

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
        btn_inicio.setBounds(40, 50, 90, 27);

        btn_NovaReceita.setBackground(new java.awt.Color(105, 69, 219));
        btn_NovaReceita.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        btn_NovaReceita.setForeground(new java.awt.Color(255, 255, 255));
        btn_NovaReceita.setText("Cadastrar Receita");
        btn_NovaReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NovaReceitaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_NovaReceita);
        btn_NovaReceita.setBounds(40, 260, 150, 27);

        jLabel1.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel1.setText("Total: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 180, 60, 27);

        dateTitle.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        dateTitle.setText("Data: (dd/mm/aaaa)");
        getContentPane().add(dateTitle);
        dateTitle.setBounds(40, 120, 170, 27);

        dayBarTitle.setFont(new java.awt.Font("Noto Serif", 1, 24)); // NOI18N
        dayBarTitle.setText("/");
        getContentPane().add(dayBarTitle);
        dayBarTitle.setBounds(90, 140, 10, 27);

        monthBarTitle.setFont(new java.awt.Font("Noto Serif", 1, 24)); // NOI18N
        monthBarTitle.setText("/");
        getContentPane().add(monthBarTitle);
        monthBarTitle.setBounds(150, 140, 10, 27);

        iconPed12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icon-280x200.png"))); // NOI18N
        getContentPane().add(iconPed12);
        iconPed12.setBounds(390, 180, 410, 370);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Back-2.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-150, -150, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void btn_NovaReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NovaReceitaActionPerformed
        
//        if(  StringUtils.isNullOrEmpty(txt_dia.getText()) || 
//             StringUtils.isNullOrEmpty(txt_mes.getText()) ||
//             StringUtils.isNullOrEmpty(txt_ano.getText()) || 
//             StringUtils.isNullOrEmpty(txt_total.getText()))
//        {
//            
//            JOptionPane.showMessageDialog(this, "Todos campos são de preenchimento obrigatório!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
//            
//        }else{
//            
//            if
//            (!( Validacao.isNumeric(txt_dia.getText()) && 
//                Validacao.isNumeric(txt_mes.getText()) &&
//                Validacao.isNumeric(txt_ano.getText()) && 
//                Validacao.isNumeric(txt_total.getText())))
//            {
//                JOptionPane.showMessageDialog(this, "Informe um valor numérico válido!!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
//                return;
//            }
//            
//            boolean cadastra = true;
//            
//            try {
//
//                Receita receita = new Receita(
//                        Integer.parseInt(txt_dia.getText()),
//                        Integer.parseInt(txt_mes.getText()),
//                        Integer.parseInt(txt_ano.getText()),
//                        Float.parseFloat(txt_total.getText()),
//                        Integer.parseInt(txt_id.getText())
//                );
//
//                Data data = new Data(Integer.parseInt(
//                        txt_dia.getText()),
//                        Integer.parseInt(txt_mes.getText()),
//                        Integer.parseInt(txt_ano.getText())
//                );
//
//                if (ControlerReceita.ReceitaExiste(receita.getMes(), receita.getAno(), receita.getId_conta())) {
//
//                    JOptionPane.showMessageDialog(this, "Receita já existe!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
//                    cadastra = false;
//                }
//
//                if (!(receita.verifica_total())) {
//
//                    JOptionPane.showMessageDialog(this, "Valor inválido!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
//                    cadastra = false;
//                }
//
//                if (!(data.verifica_dia())) {
//
//                    JOptionPane.showMessageDialog(this, "Dia inválido!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
//                    cadastra = false;
//                }
//
//                if (!(data.verifica_mes())) {
//
//                    JOptionPane.showMessageDialog(this, "Mês inválido!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
//                    cadastra = false;
//                }
//
//                if (!(data.verifica_ano())) {
//
//                    JOptionPane.showMessageDialog(this, "Ano inválido!", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
//                    cadastra = false;
//                }
//
//                if (cadastra) {
//
//                    cadastro_receita();
//                    JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
//                }
//
//            } catch (NumberFormatException e) {
//
//                JOptionPane.showMessageDialog(this, e.getMessage(), "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
//
//            }
//        }

        CadastrarReceita();

    }//GEN-LAST:event_btn_NovaReceitaActionPerformed

    private void btn_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicioActionPerformed
        // TODO add your handling code here:
        TelaPrincipal();
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
            java.util.logging.Logger.getLogger(TelaReceita_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaReceita_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaReceita_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaReceita_cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaReceita_cadastrar().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_NovaReceita;
    private javax.swing.JButton btn_inicio;
    private javax.swing.JLabel dateTitle;
    private javax.swing.JLabel dayBarTitle;
    private javax.swing.JLabel iconPed12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel monthBarTitle;
    private javax.swing.JTextField txt_ano;
    private javax.swing.JTextField txt_dia;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_mes;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables

    public void receberID(String recebe){
        txt_id.setText(recebe);
    }
}