/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;


import controladores.interfaces.IControladorPrincipal;

public class TelaPrincipal extends Tela {

    public TelaPrincipal(IControladorPrincipal ctrl) {
        super(ctrl);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btTelaEmp = new javax.swing.JButton();
        btTelaDev = new javax.swing.JButton();
        btTelaUsuario = new javax.swing.JButton();
        btCadLivro = new javax.swing.JButton();
        contUsrs = new javax.swing.JLabel();
        contLivsDisp = new javax.swing.JLabel();
        contEmps = new javax.swing.JLabel();
        contDevs = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TELA PRINCIPAL");

        jLabel2.setText("Usuários Cadastrados:");

        jLabel3.setText("Livros disponíveis:");

        jLabel4.setText("Empréstimos realizados:");

        jLabel5.setText("Devoluções em aberto:");

        btTelaEmp.setText("Tela de Empréstimo");
        btTelaEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTelaEmpActionPerformed(evt);
            }
        });

        btTelaDev.setText("Tela de Devolução");
        btTelaDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTelaDevActionPerformed(evt);
            }
        });

        btTelaUsuario.setText("Usuários");
        btTelaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTelaUsuarioActionPerformed(evt);
            }
        });

        btCadLivro.setText("Livros");
        btCadLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadLivroActionPerformed(evt);
            }
        });

        contUsrs.setText("0");

        contLivsDisp.setText("0");

        contEmps.setText("0");

        contDevs.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(166, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(161, 161, 161))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(96, 96, 96)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(contDevs))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(contEmps))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(contLivsDisp))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(contUsrs))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btTelaEmp)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(btTelaDev)))
                                                .addGap(95, 95, 95)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btTelaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                        .addComponent(btCadLivro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1)
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(contUsrs))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(contLivsDisp))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(contEmps))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(contDevs))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btTelaEmp)
                                        .addComponent(btTelaUsuario))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btTelaDev)
                                        .addComponent(btCadLivro))
                                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btTelaEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTelaEmpActionPerformed
        this.controladorPrincipal.abreTelaEmprestimo();
    }//GEN-LAST:event_btTelaEmpActionPerformed

    private void btTelaDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTelaDevActionPerformed
        this.controladorPrincipal.abreTelaDevolucao();
    }//GEN-LAST:event_btTelaDevActionPerformed

    private void btTelaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTelaUsuarioActionPerformed
        this.controladorPrincipal.abreTelaUsuarios();
    }//GEN-LAST:event_btTelaUsuarioActionPerformed

    private void btCadLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadLivroActionPerformed
        this.controladorPrincipal.abreTelaLivros();
    }//GEN-LAST:event_btCadLivroActionPerformed

    public void atualizaDados(){
        this.contLivsDisp.setText(String.valueOf(this.controladorPrincipal.getControladorLivro().listarLivros().size()));
        this.contUsrs.setText(String.valueOf(this.controladorPrincipal.getControladorUsuario().listarUsuarios().size()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadLivro;
    private javax.swing.JButton btTelaDev;
    private javax.swing.JButton btTelaEmp;
    private javax.swing.JButton btTelaUsuario;
    private javax.swing.JLabel contDevs;
    private javax.swing.JLabel contEmps;
    private javax.swing.JLabel contLivsDisp;
    private javax.swing.JLabel contUsrs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
