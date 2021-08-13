/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;
import DAO.moduloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class TelaReceita_Consulta extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelaReceita_Consulta() {
        initComponents();
        conexao = moduloConexao.conector();
        this.setLocationRelativeTo(null);
    }
    
    void voltaTelaReceita(){

          TelaReceita Tela_receita = null;

        if (Tela_receita == null) {

            Tela_receita = new TelaReceita();

            Tela_receita.setVisible(true);

            Tela_receita.receberID(txt_id.getText());

        } else {

            Tela_receita.setVisible(true);

            Tela_receita.setState(TelaPrincipal.NORMAL);

            Tela_receita.receberID(txt_id.getText());

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtPesquisa = new javax.swing.JTable();
        txt_id = new javax.swing.JTextField();
        btn_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Total", "Dia", "Mês", "Ano"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtPesquisa);

        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_voltar)
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_voltar))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // CONSULTA
        DefaultTableModel mp1 = (DefaultTableModel) jtPesquisa.getModel();
        
        int l = mp1.getRowCount();
        
        if(l>0){
            while(l>0){
                //Limpa tabela sempre que for fazer uma nova consulta
                ((DefaultTableModel) jtPesquisa.getModel()).removeRow(l - 1);
                
                //Menos um pois a primeira linha é a linha zero
                l--;
            }
        }
        
        try{
            
            String sql = "select * from (receita R JOIN receita_data Rdt ON R.receita_data_cod_receita = Rdt.cod_receita) where conta_id_conta=?";
            
            pst = conexao.prepareStatement(sql);
         
            pst.setInt(1, Integer.parseInt(txt_id.getText()));

            DefaultTableModel mp = (DefaultTableModel) jtPesquisa.getModel();
            
            rs = pst.executeQuery(); 

            while(rs.next()) {
               
                String Col0 = rs.getString("total");
                String Col1 = rs.getString("dia");
                String Col2 = rs.getString("mes");
                String Col3 = rs.getString("ano");
                
                
                //Redimensiona a tabela
                //TamanhoColunas();
                
                mp.addRow(new String[] {Col0,Col1,Col2, Col3});
                
            }
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(this, e.getMessage());
            
        }
        
        jtPesquisa.setAutoCreateRowSorter(true);
    }//GEN-LAST:event_formWindowOpened

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        // TODO add your handling code here:
        voltaTelaReceita();
    }//GEN-LAST:event_btn_voltarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaReceita_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaReceita_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaReceita_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaReceita_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaReceita_Consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_voltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPesquisa;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables

 public void receberID(String recebe){

        txt_id.setText(recebe);
    }

}