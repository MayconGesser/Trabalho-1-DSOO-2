/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import controladores.interfaces.IControladorPrincipal;
import excecoes.BusinessException;
import util.Mensagens;

import java.awt.event.ActionEvent;

import static util.Mensagens.USUARIO_CADASTRADO;

public class TelaCadastroUsuario extends Tela {

    public TelaCadastroUsuario(IControladorPrincipal controladorPrincipal) {
        super(controladorPrincipal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        ctNomeUsr = new javax.swing.JTextField();
        lbCPF = new javax.swing.JLabel();
        ctCPF = new javax.swing.JFormattedTextField();
        lbTel = new javax.swing.JLabel();
        ctTel = new javax.swing.JTextField();
        btCadUsr = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("CADASTRO DE USUÁRIOS");

        lbNome.setText("Nome Completo:");

        lbCPF.setText("CPF:");

        lbTel.setText("Telefone:");

        btCadUsr.setText("Cadastrar Usuário");
        btCadUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadUsr(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSair(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(140, 140, 140)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lbNome)
                                                        .addComponent(lbCPF)
                                                        .addComponent(lbTel))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(ctNomeUsr)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(ctCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(ctTel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addContainerGap(142, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btCadUsr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btSair)
                                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbNome)
                                        .addComponent(ctNomeUsr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbCPF)
                                        .addComponent(ctCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbTel)
                                        .addComponent(ctTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btCadUsr)
                                        .addComponent(btSair))
                                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btSair(ActionEvent evt) {
        this.controladorPrincipal.fechaTelaCadastroUsuario();
    }

    private void btCadUsr(ActionEvent evt) {
        try {
            long cpf = Long.parseLong(this.ctCPF.getText());
            long telefone = Long.parseLong(this.ctTel.getText());
            this.controladorPrincipal.cadastrarUsuario(this.ctNomeUsr.getText(), cpf, telefone);
            this.util.lancaMessage(USUARIO_CADASTRADO);
            this.apagaCampos();
        } catch (BusinessException e) {
            this.util.lancaExcessao(e.toString());
        } catch (NumberFormatException n) {
            this.util.lancaExcessao(Mensagens.INPUT_IRREGULAR);
        }
    }

    private void apagaCampos() {
        this.ctNomeUsr.setText(null);
        this.ctCPF.setText(null);
        this.ctTel.setText(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadUsr;
    private javax.swing.JButton btSair;
    private javax.swing.JFormattedTextField ctCPF;
    private javax.swing.JTextField ctNomeUsr;
    private javax.swing.JTextField ctTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbTel;
    // End of variables declaration//GEN-END:variables
}
