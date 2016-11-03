/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import excecoes.BusinessException;
import controladores.interfaces.IControladorPrincipal;

import java.awt.event.ActionEvent;

import static util.Mensagens.LIVRO_CADASTRADO;
import static util.Mensagens.USUARIO_CADASTRADO;

public class TelaCadastroLivro extends Tela {

    public TelaCadastroLivro(IControladorPrincipal controladorPrincipal) {
        super(controladorPrincipal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        inputTitulo = new javax.swing.JTextField();
        lbAutor = new javax.swing.JLabel();
        inputAutor = new javax.swing.JTextField();
        lbEditora = new javax.swing.JLabel();
        inputEditora = new javax.swing.JTextField();
        btCadLivro = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("CADASTRO DE LIVROS");

        lbTitulo.setText("Título: ");

        lbAutor.setText("Autor:");

        lbEditora.setText("Editora:");

        btCadLivro.setText("Cadastrar Livro");

        btSair.setText("Sair");

        btCadLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadLivro(evt);
            }
        });

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(151, 151, 151)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbTitulo)
                                                        .addComponent(lbAutor))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(inputTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                        .addComponent(inputAutor)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(143, 143, 143)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lbEditora)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(inputEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel1)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addComponent(btCadLivro)
                                                .addGap(88, 88, 88)
                                                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbTitulo)
                                        .addComponent(inputTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbAutor)
                                        .addComponent(inputAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbEditora)
                                        .addComponent(inputEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btCadLivro)
                                        .addComponent(btSair))
                                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSair(ActionEvent evt) {
        this.controladorPrincipal.fechaTelaCadastroLivro();
    }

    private void btCadLivro(ActionEvent evt) {
        try {
            this.util.lancaMessage(this.controladorPrincipal.cadastrarLivro(inputTitulo.getText(), inputAutor.getText(), inputEditora.getText()));
            this.apagaCampos();
        } catch (BusinessException e) {
            this.util.lancaExcessao(e.toString());
        }
    }

    private void apagaCampos() {
        inputAutor.setText(null);
        inputEditora.setText(null);
        inputTitulo.setText(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadLivro;
    private javax.swing.JButton btSair;
    private javax.swing.JTextField inputAutor;
    private javax.swing.JTextField inputEditora;
    private javax.swing.JTextField inputTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbAutor;
    private javax.swing.JLabel lbEditora;
    private javax.swing.JLabel lbTitulo;
    // End of variables declaration//GEN-END:variables
}
