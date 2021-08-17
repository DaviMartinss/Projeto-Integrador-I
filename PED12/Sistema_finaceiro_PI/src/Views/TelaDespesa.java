/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAO.DespesaDAO;
import DAO.ReceitaDAO;
import Model.Receita;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alan
 */
public class TelaDespesa extends javax.swing.JFrame {

    /**
     * Creates new form TelaDespesa
     */
    public TelaDespesa() {
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
    
    
    void cartao_credito() {

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
    
    void cartao_debito() {

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
    
    
    
    void receita() {
  
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
    
    void cadastrar_despesa() {
  
        TelaDespesa_cadastrar TelaDespesa_cadastrar = null;

           if (TelaDespesa_cadastrar == null) {

               TelaDespesa_cadastrar= new TelaDespesa_cadastrar();

               TelaDespesa_cadastrar.setVisible(true);
               
               TelaDespesa_cadastrar.receberID(txt_id.getText());

           } else {

               TelaDespesa_cadastrar.setVisible(true);

               TelaDespesa_cadastrar.setState(TelaPrincipal.NORMAL);

               TelaDespesa_cadastrar.receberID(txt_id.getText());
                
           }
        
        this.dispose();
        
      }
    
    
    void RecarregaTabela_Despesa(){
         
         DefaultTableModel mp1 = (DefaultTableModel) jtConsultaDespesa.getModel();
        
        int l = mp1.getRowCount();
        
        if(l>0){
            while(l>0){
                //Limpa tabela sempre que for fazer uma nova consulta
                ((DefaultTableModel) jtConsultaDespesa.getModel()).removeRow(l - 1);
                
                //Menos um pois a primeira linha é a linha zero
                l--;
            }
        }
        
        try{
            
            String Col0 = null;
            String Col1 = null;
            String Col2 = null;
            String Col3 = null;
            String Col4 = null;
            String Col5 = null;
            String Col6 = null;
            String Col7 = null;
            String Col8 = null;
            String Col9 = null;  

            ResultSet rs = null;
            
            DespesaDAO despesa = new DespesaDAO ();
            
            DefaultTableModel mp = (DefaultTableModel) jtConsultaDespesa.getModel();  

            rs = despesa.CarregaTabela_Despesa(Integer.parseInt(txt_id.getText()));

            while(rs.next()) {
                
                    Col0 = rs.getString("dia");
                    Col1 = rs.getString("mes");
                    Col2 = rs.getString("ano");
                    Col3 = rs.getString("valor");
                    Col4 = rs.getString("categoria");
                    Col5 = rs.getString("f_pagamento");
                 
                    
                    if(Col6 == null){
                        
                        Col6 = "----";       
                                
                    }else{
                        
                         Col6 = rs.getString("num_cartao");
                    }
                    
                    if(Col7 == null){
                        
                        Col7 = "----";
                                
                    }else{
                        
                        Col7 = rs.getString("n_parcelas");
                    }
                    
                    
                    Col8 = rs.getString("estatus");
                    
                    if(Col9 == null){
                        
                        Col9 = "----";
                        
                    }else{
                        
                        Col9 = rs.getString("descricao");
                    }
                    
 
                    mp.addRow(new String[]{Col0, Col1, Col2, Col3,
                                           Col4, Col5, Col6, Col7,
                                           Col8, Col9});
                   
            }
    
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(this, e.getMessage());
            
        }
        
        jtConsultaDespesa.setAutoCreateRowSorter(true);
         
         
     }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCartao_cred = new javax.swing.JButton();
        btnCartao_Deb = new javax.swing.JButton();
        btnReceitas = new javax.swing.JButton();
        btn_inicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        rbPago = new javax.swing.JRadioButton();
        rbNaoPago = new javax.swing.JRadioButton();
        txtValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescricao = new javax.swing.JTextArea();
        txtDia = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rbDebito = new javax.swing.JRadioButton();
        rbCredito = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtParcelas = new javax.swing.JTextField();
        btnNovaDespesa = new javax.swing.JToggleButton();
        txt_id = new javax.swing.JTextField();
        cbbTipo = new javax.swing.JComboBox<>();
        txt_Pesquisa = new javax.swing.JTextField();
        btPesquisarDespesa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtConsultaDespesa = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtMesReceita = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtAnoReceita = new javax.swing.JTextField();
        rbDescendente = new javax.swing.JRadioButton();
        rbAscendente = new javax.swing.JRadioButton();
        rbDinheiro = new javax.swing.JRadioButton();
        txt_NumCartao = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        btnCartao_cred.setText("Cartão de Crédito");
        btnCartao_cred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartao_credActionPerformed(evt);
            }
        });
        getContentPane().add(btnCartao_cred);
        btnCartao_cred.setBounds(2126, 25, 119, 23);

        btnCartao_Deb.setText("Cartão de Débito");
        btnCartao_Deb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartao_DebActionPerformed(evt);
            }
        });
        getContentPane().add(btnCartao_Deb);
        btnCartao_Deb.setBounds(2282, 25, 115, 23);

        btnReceitas.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        btnReceitas.setText("Receitas");
        btnReceitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceitasActionPerformed(evt);
            }
        });
        getContentPane().add(btnReceitas);
        btnReceitas.setBounds(200, 40, 83, 25);

        btn_inicio.setText("Início");
        btn_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inicioActionPerformed(evt);
            }
        });
        getContentPane().add(btn_inicio);
        btn_inicio.setBounds(2016, 25, 57, 23);

        jLabel1.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel1.setText("Valor:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 80, 41, 20);

        jLabel2.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel2.setText("Mês");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 320, 24, 16);

        jLabel3.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel3.setText("Descrição: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(230, 190, 64, 16);

        jLabel4.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel4.setText("Data: (dd/mm/aaaa)");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 210, 130, 16);

        jLabel5.setFont(new java.awt.Font("Noto Serif", 1, 24)); // NOI18N
        jLabel5.setText("/");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 230, 10, 27);

        jLabel6.setFont(new java.awt.Font("Noto Serif", 1, 24)); // NOI18N
        jLabel6.setText("/");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(140, 230, 10, 27);

        jLabel7.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel7.setText("Status: ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(450, 90, 43, 16);

        jLabel12.setFont(new java.awt.Font("Noto Serif", 1, 18)); // NOI18N
        jLabel12.setText("Despesa");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(310, 0, 90, 24);

        jButton1.setBackground(new java.awt.Color(201, 127, 206));
        jButton1.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jButton1.setText("Início");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 40, 63, 25);

        rbPago.setBackground(new java.awt.Color(158, 170, 230));
        rbPago.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        rbPago.setText("PAGO");
        rbPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPagoActionPerformed(evt);
            }
        });
        getContentPane().add(rbPago);
        rbPago.setBounds(450, 110, 59, 25);

        rbNaoPago.setBackground(new java.awt.Color(158, 170, 230));
        rbNaoPago.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        rbNaoPago.setText("NÃO PAGO");
        rbNaoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNaoPagoActionPerformed(evt);
            }
        });
        getContentPane().add(rbNaoPago);
        rbNaoPago.setBounds(510, 110, 87, 25);
        getContentPane().add(txtValor);
        txtValor.setBounds(30, 100, 400, 27);

        txtAreaDescricao.setColumns(20);
        txtAreaDescricao.setRows(5);
        jScrollPane1.setViewportView(txtAreaDescricao);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(230, 210, 400, 54);
        getContentPane().add(txtDia);
        txtDia.setBounds(30, 230, 50, 27);
        getContentPane().add(txtMes);
        txtMes.setBounds(90, 230, 50, 27);
        getContentPane().add(txtAno);
        txtAno.setBounds(150, 230, 50, 27);
        getContentPane().add(txtCategoria);
        txtCategoria.setBounds(30, 150, 400, 27);

        jLabel8.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel8.setText("Forma de Pagamento: ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(450, 140, 127, 16);

        rbDebito.setBackground(new java.awt.Color(158, 170, 230));
        rbDebito.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        rbDebito.setText("Débito");
        rbDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDebitoActionPerformed(evt);
            }
        });
        getContentPane().add(rbDebito);
        rbDebito.setBounds(450, 160, 61, 25);

        rbCredito.setBackground(new java.awt.Color(158, 170, 230));
        rbCredito.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        rbCredito.setText("Crédito");
        rbCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCreditoActionPerformed(evt);
            }
        });
        getContentPane().add(rbCredito);
        rbCredito.setBounds(510, 160, 67, 25);

        jLabel9.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel9.setText("Nº de Pacelas: ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(700, 140, 84, 16);
        getContentPane().add(txtParcelas);
        txtParcelas.setBounds(700, 160, 50, 27);

        btnNovaDespesa.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        btnNovaDespesa.setText("Nova Despesa");
        btnNovaDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaDespesaActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovaDespesa);
        btnNovaDespesa.setBounds(310, 40, 113, 25);

        txt_id.setEditable(false);
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        getContentPane().add(txt_id);
        txt_id.setBounds(2360, 119, 81, 20);

        cbbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Valor", "Categoria", "Descrição", "Forma de Pagamento", "Número do Cartão", "Estatus", "Dia", "Mês", "Ano", "Nº  Parcelas", " ", " ", " " }));
        getContentPane().add(cbbTipo);
        cbbTipo.setBounds(40, 360, 120, 27);

        txt_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PesquisaActionPerformed(evt);
            }
        });
        txt_Pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_PesquisaKeyReleased(evt);
            }
        });
        getContentPane().add(txt_Pesquisa);
        txt_Pesquisa.setBounds(170, 360, 400, 27);

        btPesquisarDespesa.setText("Pesquisar");
        btPesquisarDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarDespesaActionPerformed(evt);
            }
        });
        getContentPane().add(btPesquisarDespesa);
        btPesquisarDespesa.setBounds(610, 360, 100, 27);

        jtConsultaDespesa.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jtConsultaDespesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Mês", "Ano", "Valor", "Categoria", "Forma de Pagamento", "Nº Cartão", "Nº Parcelas", "Estatus", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtConsultaDespesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtConsultaDespesaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtConsultaDespesa);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(40, 410, 910, 170);

        jLabel10.setText("Selecione a receita: ");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 280, 150, 30);

        txtMesReceita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMesReceitaKeyPressed(evt);
            }
        });
        getContentPane().add(txtMesReceita);
        txtMesReceita.setBounds(89, 320, 70, 30);

        jLabel11.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel11.setText("Categoria: ");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(30, 130, 61, 16);

        jLabel13.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel13.setText("Ano:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(170, 320, 40, 16);

        txtAnoReceita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnoReceitaKeyPressed(evt);
            }
        });
        getContentPane().add(txtAnoReceita);
        txtAnoReceita.setBounds(210, 320, 70, 30);

        rbDescendente.setText("Descendente");
        rbDescendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDescendenteActionPerformed(evt);
            }
        });
        getContentPane().add(rbDescendente);
        rbDescendente.setBounds(470, 320, 110, 23);

        rbAscendente.setText("Ascendente");
        rbAscendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAscendenteActionPerformed(evt);
            }
        });
        getContentPane().add(rbAscendente);
        rbAscendente.setBounds(340, 320, 100, 23);

        rbDinheiro.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        rbDinheiro.setText("Dinheiro");
        rbDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDinheiroActionPerformed(evt);
            }
        });
        getContentPane().add(rbDinheiro);
        rbDinheiro.setBounds(590, 160, 90, 27);

        txt_NumCartao.setBackground(new java.awt.Color(187, 210, 240));
        txt_NumCartao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(txt_NumCartao);
        txt_NumCartao.setBounds(460, 50, 300, 27);

        jLabel14.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel14.setText("Nº do Cartão: ");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(460, 30, 76, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCartao_credActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartao_credActionPerformed
        // TODO add your handling code here:
        cartao_credito();

    }//GEN-LAST:event_btnCartao_credActionPerformed

    private void btnCartao_DebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartao_DebActionPerformed
        // TODO add your handling code here:
        cartao_debito();
    }//GEN-LAST:event_btnCartao_DebActionPerformed

    private void btnReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceitasActionPerformed
        // TODO add your handling code here:
        receita();
    }//GEN-LAST:event_btnReceitasActionPerformed

    private void btn_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicioActionPerformed
        // TODO add your handling code here:
        inicio();
    }//GEN-LAST:event_btn_inicioActionPerformed

    private void rbPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPagoActionPerformed
        // TODO add your handling code here:
        if(rbPago.isSelected()){
            
            rbNaoPago.setSelected(false);
            
        }
        
    }//GEN-LAST:event_rbPagoActionPerformed

    private void rbNaoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNaoPagoActionPerformed
        // TODO add your handling code here:
        
        if(rbNaoPago.isSelected()){
            
            rbPago.setSelected(false);
            
        }
    }//GEN-LAST:event_rbNaoPagoActionPerformed

    private void rbDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDebitoActionPerformed
        // TODO add your handling code here:
        
        if(rbDebito.isSelected()){
            
            txtParcelas.setEnabled(false);
            
            rbCredito.setSelected(false);
            
        }
    }//GEN-LAST:event_rbDebitoActionPerformed

    private void rbCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCreditoActionPerformed
        // TODO add your handling code here:
        
        if(rbCredito.isSelected()){
            
            txtParcelas.setEnabled(true);
            
            rbDebito.setSelected(false);
            
        }
        
    }//GEN-LAST:event_rbCreditoActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void btnNovaDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaDespesaActionPerformed
        // TODO add your handling code here:
        
        cadastrar_despesa();
        
    }//GEN-LAST:event_btnNovaDespesaActionPerformed


    private void txt_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PesquisaActionPerformed

    private void txt_PesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PesquisaKeyReleased
        // TODO add your handling code here

//        if(txt_Pesquisa.getText().isEmpty()){
//            RecarregaTabela_CartaoCC();
//        }

    }//GEN-LAST:event_txt_PesquisaKeyReleased

    private void btPesquisarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarDespesaActionPerformed
        // TODO add your handling code here:
        
        if (!(txtMesReceita.getText().isEmpty()) && !(txtAnoReceita.getText().isEmpty())) {

            if (rbAscendente.isSelected() || rbDescendente.isSelected()) {

                boolean ordenar = true;

                String tipo = "";

                String escolha = cbbTipo.getSelectedItem().toString().trim();

                if (escolha.equals("Valor")) {
                    tipo = " " + "valor";
                }

                if (escolha.equals("Categoria")) {
                    tipo = " " + "categoria";
                }

                if (escolha.equals("Número do Cartão")) {
                    tipo = " " + "num_cartao";
                }

                
                if (escolha.equals("Dia")) {
                    tipo = " " + "dia";
                }
                
                if (escolha.equals("Mês")) {
                    tipo = " " + "mes";
                }
                
                if (escolha.equals("Ano")) {
                    tipo = " " + "ano";
                }
                
                if (escolha.equals("Descrição")) {
                    tipo = " " + "descricao";
                }

                if (escolha.equals("Nº Parcelas")) {
                    tipo = " " + "n_parcelas";
                }
                
                if (escolha.equals("Forma de Pagamento")) {
                    tipo = " " + "f_pagamento";
                }
                
                if (escolha.equals("Estatus")) {
                    tipo = " " + "estatus";
                }
                
                if (rbAscendente.isSelected()) {

                    ordenar = true;

                } else {

                    ordenar = false;
                }

                String argumento = txt_Pesquisa.getText();

                DefaultTableModel mp1 = (DefaultTableModel) jtConsultaDespesa.getModel();

                int l = mp1.getRowCount();

                if (l > 0) {
                    while (l > 0) {
                        //Limpa tabela sempre que for fazer uma nova consulta
                        ((DefaultTableModel) jtConsultaDespesa.getModel()).removeRow(l - 1);

                        //Menos um pois a primeira linha é a linha zero
                        l--;
                    }
                }

                try {

                    String Col0 = null;
                    String Col1 = null;
                    String Col2 = null;
                    String Col3 = null;
                    String Col4 = null;
                    String Col5 = null;
                    String Col6 = null;
                    String Col7 = null;
                    String Col8 = null;
                    String Col9 = null;

                    ResultSet rs = null;

                    DespesaDAO despesaDAO = new DespesaDAO();

                    Receita receita = new Receita();

                    receita.setId_conta(Integer.parseInt(txt_id.getText()));
                    receita.setMes(Integer.parseInt(txtMesReceita.getText()));
                    receita.setAno(Integer.parseInt(txtAnoReceita.getText()));

                    DefaultTableModel mp = (DefaultTableModel) jtConsultaDespesa.getModel();

                    rs = despesaDAO.Consulta_Despesa(tipo, argumento, ordenar, receita);

                    while (rs.next()) {

                        Col0 = rs.getString("dia");
                        Col1 = rs.getString("mes");
                        Col2 = rs.getString("ano");
                        Col3 = rs.getString("valor");
                        Col4 = rs.getString("categoria");
                        Col5 = rs.getString("f_pagamento");

                        if (Col6 == null) {

                            Col6 = "----";

                        } else {

                            Col6 = rs.getString("num_cartao");
                        }

                        if (Col7 == null) {

                            Col7 = "----";

                        } else {

                            Col7 = rs.getString("n_parcelas");
                        }

                        Col8 = rs.getString("estatus");

                        if (Col9 == null) {

                            Col9 = "----";

                        } else {

                            Col9 = rs.getString("descricao");
                        }

                        mp.addRow(new String[]{Col0, Col1, Col2, Col3,
                            Col4, Col5, Col6, Col7,
                            Col8, Col9});

                    }

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(this, e.getMessage());

                }

            } else {

                JOptionPane.showMessageDialog(null, "Tipo de Ordenação Obrigatório");

            }

        } else {

            JOptionPane.showMessageDialog(this, "Informe o dia e mês da receita correspondente!!");

        }
           
            

//        if(rbAscendente.isSelected() || rbDescendente.isSelected()){
//
//            boolean ordenar = true;
//
//            String tipo = "";
//
//            String escolha = cbbTipo.getSelectedItem().toString().trim();
//
//            if (escolha.equals("Nº Cartão")) {
//                tipo = " " + "n_cartao_credito";
//            }
//
//            if (escolha.equals("Limite")) {
//                tipo = " " + "limite";
//            }
//
//            if (escolha.equals("Dia da Fatura")) {
//                tipo = " " + "dia_fatura";
//            }
//
//            if (escolha.equals("Valor da Fatura")) {
//                tipo = " " + "valor_fatura";
//            }
//
//            if (escolha.equals("Bandeira")) {
//                tipo = " " + "bandeira";
//            }
//
//            if (rbAscendente.isSelected()) {
//
//                ordenar = true;
//
//            } else {
//
//                ordenar = false;
//            }
//
//            String argumento = txt_Pesquisa.getText();
//
//            DefaultTableModel mp1 = (DefaultTableModel) jtConsultaCC.getModel();
//
//            int l = mp1.getRowCount();
//
//            if (l > 0) {
//                while (l > 0) {
//                    //Limpa tabela sempre que for fazer uma nova consulta
//                    ((DefaultTableModel) jtConsultaCC.getModel()).removeRow(l - 1);
//
//                    //Menos um pois a primeira linha é a linha zero
//                    l--;
//                }
//            }
//
//            try {
//
//                CartaoCreditoDAO cartao_c = new CartaoCreditoDAO();
//
//                DefaultTableModel mp = (DefaultTableModel) jtConsultaCC.getModel();
//
//                rs = cartao_c.ConsultaCartao_C(tipo, argumento, Integer.parseInt(txt_id.getText()), ordenar);
//
//                while (rs.next()) {
//
//                    String Col0 = rs.getString("n_cartao_credito");
//                    String Col1 = rs.getString("limite");
//                    String Col2 = rs.getString("dia_fatura");
//                    String Col3 = rs.getString("valor_fatura");
//                    String Col4 = rs.getString("bandeira");
//
//                    mp.addRow(new String[]{Col0, Col1, Col2, Col3, Col4});
//
//                }
//
//            } catch (Exception e) {
//
//                JOptionPane.showMessageDialog(this, e.getMessage());
//
//            }
//
//            jtConsultaCC.setAutoCreateRowSorter(true);
//
//        }else{
//
//            JOptionPane.showMessageDialog(null, "Tipo de Ordenação Obrigatório");
//
//        }

    }//GEN-LAST:event_btPesquisarDespesaActionPerformed

    private void jtConsultaDespesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtConsultaDespesaMouseClicked
        // TODO add your handling code here:

        String dia = "" + jtConsultaDespesa.getValueAt(jtConsultaDespesa.getSelectedRow(), 0);
        
        String mes = "" + jtConsultaDespesa.getValueAt(jtConsultaDespesa.getSelectedRow(), 1);
        
        String ano = "" + jtConsultaDespesa.getValueAt(jtConsultaDespesa.getSelectedRow(), 2);

        DespesaDAO despesaDAO = new DespesaDAO();

        ResultSet rs = null;

        try {

            rs = despesaDAO.PreencherCampos_Despesa(dia, mes, ano, txt_id.getText());

            if(rs.next()){

                txtValor.setText(rs.getString("valor"));
                txtCategoria.setText(rs.getString("categoria"));
                txtDia.setText(rs.getString("dia"));
                txtMes.setText(rs.getString("mes"));
                txtAno.setText(rs.getString("ano"));
                txtAreaDescricao.setText(rs.getString("descricao"));
                txtParcelas.setText(rs.getString("n_parcelas"));
                txt_NumCartao.setText(rs.getString("num_cartao"));
                
                if(rs.getString("f_pagamento").equals("CRÉDITO")){
                    
                    rbCredito.setSelected(true);
                    rbDebito.setSelected(false);
                    rbDinheiro.setSelected(false);
                    
                }else if(rs.getString("f_pagamento").equals("DÉBITO")){
                    
                    rbDebito.setSelected(true);
                    rbCredito.setSelected(false);
                    rbDinheiro.setSelected(false);
                    
                }else{
                    
                    rbDinheiro.setSelected(true);
                    rbDebito.setSelected(false);
                    rbCredito.setSelected(false);
                }
                
                if(rs.getString("estatus").equals("PAGO")){
                    
                    rbPago.setSelected(true);
                    rbNaoPago.setSelected(false);
                
                }else{
                    
                    rbNaoPago.setSelected(true);
                    rbPago.setSelected(false);
                }

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(this, "Erro ao selecionar os dados!!");
        }

    }//GEN-LAST:event_jtConsultaDespesaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        inicio();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        RecarregaTabela_Despesa();
    }//GEN-LAST:event_formWindowOpened

    private void txtMesReceitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMesReceitaKeyPressed
        // TODO add your handling code here:
 
    }//GEN-LAST:event_txtMesReceitaKeyPressed

    private void txtAnoReceitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoReceitaKeyPressed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_txtAnoReceitaKeyPressed

    private void rbDescendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDescendenteActionPerformed
        // TODO add your handling code here:

        if(rbDescendente.isSelected()){

            rbAscendente.setSelected(false);

        }
    }//GEN-LAST:event_rbDescendenteActionPerformed

    private void rbAscendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAscendenteActionPerformed
        // TODO add your handling code here:

        if(rbAscendente.isSelected()){

            rbDescendente.setSelected(false);

        }
    }//GEN-LAST:event_rbAscendenteActionPerformed

    private void rbDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDinheiroActionPerformed
        // TODO add your handling code here:

        if(rbDinheiro.isSelected()){

            rbCredito.setSelected(false);
            rbDebito.setSelected(false);
            txt_NumCartao.setEnabled(false);
            txtParcelas.setEnabled(false);

        }
    }//GEN-LAST:event_rbDinheiroActionPerformed


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
            java.util.logging.Logger.getLogger(TelaDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDespesa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisarDespesa;
    private javax.swing.JButton btnCartao_Deb;
    private javax.swing.JButton btnCartao_cred;
    private javax.swing.JToggleButton btnNovaDespesa;
    private javax.swing.JButton btnReceitas;
    private javax.swing.JButton btn_inicio;
    private javax.swing.JComboBox<String> cbbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtConsultaDespesa;
    private javax.swing.JRadioButton rbAscendente;
    private javax.swing.JRadioButton rbCredito;
    private javax.swing.JRadioButton rbDebito;
    private javax.swing.JRadioButton rbDescendente;
    private javax.swing.JRadioButton rbDinheiro;
    private javax.swing.JRadioButton rbNaoPago;
    private javax.swing.JRadioButton rbPago;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtAnoReceita;
    private javax.swing.JTextArea txtAreaDescricao;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtMesReceita;
    private javax.swing.JTextField txtParcelas;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txt_NumCartao;
    private javax.swing.JTextField txt_Pesquisa;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables


    public void receberID(String recebe){

        txt_id.setText(recebe);
    }


}
