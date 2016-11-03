/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;


import controladores.interfaces.IControladorPrincipal;
import entidades.Usuario;
import excecoes.BusinessException;
import util.TableModelUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TelaUsuarios extends Tela {

    public TelaUsuarios(IControladorPrincipal cp) {
        super(cp);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsrs = new JTable();
        lbUsrs = new javax.swing.JLabel();
        btEncUsr = new javax.swing.JButton();
        btCadUsr = new javax.swing.JButton();
        btSitUsr = new javax.swing.JButton();
        btRemUsr = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableModelUsuario tableModelUsuario = new TableModelUsuario(null);
        tbUsrs = new JTable(tableModelUsuario);
        jScrollPane1.setViewportView(tbUsrs);

        lbUsrs.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbUsrs.setText("USUÁRIOS");

        btEncUsr.setText("Encontrar Usuário");

        btCadUsr.setText("Cadastrar Usuário");
        btCadUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadUsrActionPerformed(evt);
            }
        });

        btSitUsr.setText("Verificar Situação");

        btRemUsr.setText("Remover Usuário");
        btRemUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemUsrActionPerformed(evt);
            }
        });

        btSair.setText("Voltar");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbUsrs)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btEncUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btCadUsr)
                                                        .addComponent(btSitUsr)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(btSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btRemUsr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(17, Short.MAX_VALUE)
                                .addComponent(lbUsrs)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btEncUsr)
                                                .addGap(45, 45, 45)
                                                .addComponent(btCadUsr)
                                                .addGap(47, 47, 47)
                                                .addComponent(btSitUsr)
                                                .addGap(46, 46, 46)
                                                .addComponent(btRemUsr)
                                                .addGap(43, 43, 43)
                                                .addComponent(btSair)))
                                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRemUsrActionPerformed(ActionEvent evt) {
        int index = tbUsrs.getSelectedRow();
        if (index >= 0) {
            Usuario usuario = controladorPrincipal.getControladorUsuario().getUsuario(index);
            int resposta = util.confirm("Confirma exclusão do usuário " + usuario.getNome() + " ? ");
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    util.lancaMessage(controladorPrincipal.getControladorUsuario().deletaUsuario(index));
                    atualizaDados();
                } catch (BusinessException e) {
                    util.lancaExcessao(e.getMessage());
                }
            }
        }
    }

    private void btCadUsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadUsrActionPerformed
        this.controladorPrincipal.abreTelaCadastroUsuario();
    }//GEN-LAST:event_btCadUsrActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.controladorPrincipal.fechaTela(this);
    }//GEN-LAST:event_btSairActionPerformed

    public void atualizaDados() {
        TableModelUsuario tableModelUsuario = new TableModelUsuario(this.controladorPrincipal.getControladorUsuario().listarUsuarios());
        tbUsrs = new JTable(tableModelUsuario);
        jScrollPane1.setViewportView(tbUsrs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadUsr;
    private javax.swing.JButton btEncUsr;
    private javax.swing.JButton btRemUsr;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSitUsr;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbUsrs;
    private JTable tbUsrs;
    // End of variables declaration//GEN-END:variables
}
