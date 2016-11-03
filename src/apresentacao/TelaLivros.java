/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import controladores.interfaces.IControladorPrincipal;
import entidades.Livro;
import excecoes.BusinessException;
import util.TableModelLivro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Vector;

public class TelaLivros extends Tela {

    public TelaLivros(IControladorPrincipal ctrl) {
        super(ctrl);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLivros = new javax.swing.JTable();
        btEncLiv = new javax.swing.JButton();
        btCadLiv = new javax.swing.JButton();
        btRemLiv = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("LIVROS");

        TableModelLivro tableModelLivro = new TableModelLivro(null);
        tbLivros = new JTable(tableModelLivro);
        jScrollPane1.setViewportView(tbLivros);

        btEncLiv.setText("Encontrar Livro");

        btCadLiv.setText("Cadastrar Livro");
        btCadLiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadLivActionPerformed(evt);
            }
        });

        btRemLiv.setText("Remover Livro");
        btRemLiv.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                btRemLivActionPerformed(arg0);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btEncLiv)
                                        .addComponent(btCadLiv)
                                        .addComponent(btRemLiv)
                                        .addComponent(btVoltar))
                                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btEncLiv)
                                                .addGap(40, 40, 40)
                                                .addComponent(btCadLiv)
                                                .addGap(36, 36, 36)
                                                .addComponent(btRemLiv)
                                                .addGap(40, 40, 40)
                                                .addComponent(btVoltar)
                                                .addGap(0, 216, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRemLivActionPerformed(ActionEvent arg0) {
        int index = tbLivros.getSelectedRow();
        if (index >= 0) {
            Livro livro = controladorPrincipal.getControladorLivro().getLivro(index);
            int resposta = util.confirm("Confirma exclusão do livro " + livro.getTitulo() + " ? ");
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    util.lancaMessage(controladorPrincipal.getControladorLivro().deleteLivro(index));
                    atualizaDados();
                } catch (BusinessException e) {
                    util.lancaExcessao(e.getMessage());
                }
            }
        }
    }

    public void atualizaDados() {
        TableModelLivro tableModelLivro = new TableModelLivro(this.controladorPrincipal.getControladorLivro().listarLivros());
        tbLivros = new JTable(tableModelLivro);
        jScrollPane1.setViewportView(tbLivros);
    }

    private void btCadLivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadLivActionPerformed
        this.controladorPrincipal.abreTelaCadastroLivro();
    }//GEN-LAST:event_btCadLivActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.controladorPrincipal.fechaTela(this);
    }//GEN-LAST:event_btVoltarActionPerformed

    private javax.swing.JButton btCadLiv;
    private javax.swing.JButton btEncLiv;
    private javax.swing.JButton btRemLiv;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLivros;
    // End of variables declaration//GEN-END:variables
}
