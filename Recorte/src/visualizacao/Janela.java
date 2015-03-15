package visualizacao;

import java.awt.Graphics2D;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import objetos.Poligono;
import objetos.Ponto;
import objetos.Reta;
import transformacoes.Transformacoes;

/**
 *
 * @author Renato Diniz Ferreira - 1220735
 */
public class Janela extends javax.swing.JFrame {

    File arquivo;
    int homogenea = 1;
    //ArrayList objetos;
    HashMap<String, Object> objetos;
    Transformacoes t;
    boolean pivoRotacao = false;
    boolean pivoEscala = false;

    /**
     * Creates new form Janela
     */
    public Janela() {

        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_janela = new JDesenho();
        label_objeto = new javax.swing.JLabel();
        combo_objeto = new javax.swing.JComboBox();
        label_dx = new javax.swing.JLabel();
        textField_dx = new javax.swing.JTextField();
        textField_dy = new javax.swing.JTextField();
        label_dy = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textField_angulo = new javax.swing.JTextField();
        button_transladar = new javax.swing.JButton();
        textField_pivoRotacao = new javax.swing.JTextField();
        label_pivoRotacao = new javax.swing.JLabel();
        label_sx = new javax.swing.JLabel();
        textField_sx = new javax.swing.JTextField();
        label_sy = new javax.swing.JLabel();
        textField_sy = new javax.swing.JTextField();
        button_escalonar = new javax.swing.JButton();
        button_rotacionar = new javax.swing.JButton();
        scrollPane_matrizResultante = new javax.swing.JScrollPane();
        textArea_matrizResultante = new javax.swing.JTextArea();
        label_matrizResultante = new javax.swing.JLabel();
        radio_translacao = new javax.swing.JRadioButton();
        radio_rotacao = new javax.swing.JRadioButton();
        radio_escala = new javax.swing.JRadioButton();
        label_pivoEscala = new javax.swing.JLabel();
        textField_pivoEscala = new javax.swing.JTextField();
        label_arquivo = new javax.swing.JLabel();
        button_escolherArquivo = new javax.swing.JButton();
        textField_arquivo = new javax.swing.JTextField();
        button_desenharObjetos = new javax.swing.JButton();
        toogleButton_escolherPivoRotacao = new javax.swing.JToggleButton();
        toogleButton_escolherPivoEscala = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabalho CG 2");
        setBackground(new java.awt.Color(153, 153, 153));
        setResizable(false);

        panel_janela.setBackground(new java.awt.Color(153, 153, 153));
        panel_janela.setMaximumSize(new java.awt.Dimension(500, 500));
        panel_janela.setMinimumSize(new java.awt.Dimension(500, 500));
        panel_janela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_janelaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_janelaLayout = new javax.swing.GroupLayout(panel_janela);
        panel_janela.setLayout(panel_janelaLayout);
        panel_janelaLayout.setHorizontalGroup(
            panel_janelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panel_janelaLayout.setVerticalGroup(
            panel_janelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        label_objeto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_objeto.setText("Objeto:");

        combo_objeto.setEnabled(false);

        label_dx.setText("Dx:");

        textField_dx.setEnabled(false);

        textField_dy.setEnabled(false);

        label_dy.setText("Dy:");

        jLabel1.setText("Ângulo (em graus):");

        textField_angulo.setEnabled(false);

        button_transladar.setText("Transladar");
        button_transladar.setEnabled(false);
        button_transladar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_transladarActionPerformed(evt);
            }
        });

        textField_pivoRotacao.setEditable(false);
        textField_pivoRotacao.setEnabled(false);

        label_pivoRotacao.setText("Pivô (x,y):");

        label_sx.setText("Sx:");

        textField_sx.setEnabled(false);

        label_sy.setText("Sy:");

        textField_sy.setEnabled(false);

        button_escalonar.setText("Escalonar");
        button_escalonar.setEnabled(false);
        button_escalonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_escalonarActionPerformed(evt);
            }
        });

        button_rotacionar.setText("Rotacionar");
        button_rotacionar.setEnabled(false);
        button_rotacionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_rotacionarActionPerformed(evt);
            }
        });

        textArea_matrizResultante.setEditable(false);
        textArea_matrizResultante.setColumns(18);
        textArea_matrizResultante.setRows(3);
        textArea_matrizResultante.setFocusable(false);
        scrollPane_matrizResultante.setViewportView(textArea_matrizResultante);

        label_matrizResultante.setText("Matriz Resultante:");

        radio_translacao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        radio_translacao.setText("Translação");
        radio_translacao.setEnabled(false);
        radio_translacao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radio_translacaoItemStateChanged(evt);
            }
        });

        radio_rotacao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        radio_rotacao.setText("Rotação");
        radio_rotacao.setEnabled(false);
        radio_rotacao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radio_rotacaoItemStateChanged(evt);
            }
        });

        radio_escala.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        radio_escala.setText("Escala");
        radio_escala.setEnabled(false);
        radio_escala.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radio_escalaItemStateChanged(evt);
            }
        });

        label_pivoEscala.setText("Pivô (x,y):");

        textField_pivoEscala.setEnabled(false);

        label_arquivo.setText("Arquivo:");

        button_escolherArquivo.setText("Escolher...");
        button_escolherArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_escolherArquivoActionPerformed(evt);
            }
        });

        textField_arquivo.setMaximumSize(new java.awt.Dimension(239, 23));
        textField_arquivo.setMinimumSize(new java.awt.Dimension(6, 26));

        button_desenharObjetos.setText("Desenhar Objetos");
        button_desenharObjetos.setEnabled(false);
        button_desenharObjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_desenharObjetosActionPerformed(evt);
            }
        });

        toogleButton_escolherPivoRotacao.setText("Escolher");
        toogleButton_escolherPivoRotacao.setEnabled(false);
        toogleButton_escolherPivoRotacao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toogleButton_escolherPivoRotacaoItemStateChanged(evt);
            }
        });

        toogleButton_escolherPivoEscala.setText("Escolher");
        toogleButton_escolherPivoEscala.setEnabled(false);
        toogleButton_escolherPivoEscala.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toogleButton_escolherPivoEscalaItemStateChanged(evt);
            }
        });

        jButton1.setText("Recortar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_arquivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_escolherArquivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_desenharObjetos))
                    .addComponent(panel_janela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_matrizResultante)
                            .addComponent(scrollPane_matrizResultante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(radio_translacao)
                    .addComponent(radio_rotacao)
                    .addComponent(radio_escala)
                    .addComponent(label_pivoEscala)
                    .addComponent(jLabel1)
                    .addComponent(textField_angulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_transladar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_objeto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo_objeto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_dx)
                            .addComponent(textField_dx, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(label_dy, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField_dy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(label_pivoRotacao)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(toogleButton_escolherPivoRotacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField_pivoRotacao, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(toogleButton_escolherPivoEscala)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textField_pivoEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button_rotacionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_sx)
                            .addComponent(textField_sx, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_sy)
                            .addComponent(textField_sy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(button_escalonar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button_escolherArquivo)
                        .addComponent(button_desenharObjetos))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textField_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_arquivo)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_janela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_objeto)
                            .addComponent(combo_objeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(radio_translacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(label_dx)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField_dx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(label_dy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField_dy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_transladar)
                        .addGap(7, 7, 7)
                        .addComponent(radio_rotacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField_angulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_pivoRotacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(toogleButton_escolherPivoRotacao)
                            .addComponent(textField_pivoRotacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_rotacionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radio_escala)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_sx)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField_sx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_sy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField_sy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_pivoEscala)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textField_pivoEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toogleButton_escolherPivoEscala))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_escalonar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_matrizResultante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane_matrizResultante, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radio_translacaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radio_translacaoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            radio_rotacao.setSelected(false);
            radio_escala.setSelected(false);

            textField_dx.setEnabled(true);
            textField_dy.setEnabled(true);
            button_transladar.setEnabled(true);

        } else {

            textField_dx.setEnabled(false);
            textField_dy.setEnabled(false);
            button_transladar.setEnabled(false);

        }
    }//GEN-LAST:event_radio_translacaoItemStateChanged

    private void radio_rotacaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radio_rotacaoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            radio_translacao.setSelected(false);
            radio_escala.setSelected(false);

            textField_pivoRotacao.setEnabled(true);
            textField_angulo.setEnabled(true);
            toogleButton_escolherPivoRotacao.setEnabled(true);
            button_rotacionar.setEnabled(true);

        } else {

            textField_pivoRotacao.setEnabled(false);
            textField_angulo.setEnabled(false);
            toogleButton_escolherPivoRotacao.setEnabled(false);
            button_rotacionar.setEnabled(false);

        }
    }//GEN-LAST:event_radio_rotacaoItemStateChanged

    private void radio_escalaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radio_escalaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            radio_translacao.setSelected(false);
            radio_rotacao.setSelected(false);

            textField_sx.setEnabled(true);
            textField_sy.setEnabled(true);
            textField_pivoEscala.setEnabled(true);
            toogleButton_escolherPivoEscala.setEnabled(true);
            button_escalonar.setEnabled(true);

        } else {

            textField_sx.setEnabled(false);
            textField_sy.setEnabled(false);
            textField_pivoEscala.setEnabled(false);
            toogleButton_escolherPivoEscala.setEnabled(false);
            button_escalonar.setEnabled(false);

        }
    }//GEN-LAST:event_radio_escalaItemStateChanged

    private void button_escolherArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_escolherArquivoActionPerformed

        JFileChooser escolher = new JFileChooser();
        int escolha = escolher.showOpenDialog(this);

        if (escolha != JFileChooser.CANCEL_OPTION) {

            arquivo = escolher.getSelectedFile();
            textField_arquivo.setText(arquivo.getPath());
            criarObjetos();
        }

    }//GEN-LAST:event_button_escolherArquivoActionPerformed

    private void button_desenharObjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_desenharObjetosActionPerformed

        for (String chave : objetos.keySet()) {
            Object o = objetos.get(chave);
            if (o instanceof Reta) {
                Primitive.desenharReta((Graphics2D) panel_janela.getGraphics(), (Reta) o);
            } else if (o instanceof Poligono) {
                Primitive.desenharPoligono((Graphics2D) panel_janela.getGraphics(), (Poligono) o);
            }
        }

        radio_translacao.setEnabled(true);
        radio_rotacao.setEnabled(true);
        radio_escala.setEnabled(true);
        combo_objeto.setEnabled(true);
    }//GEN-LAST:event_button_desenharObjetosActionPerformed

    private void button_transladarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_transladarActionPerformed
        if (textField_dx.getText().isEmpty() || textField_dy.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Informe os valores de Dx e Dy.", "Aviso", JOptionPane.WARNING_MESSAGE);

        } else {

            double dx = Double.valueOf(textField_dx.getText().replace(",", "."));
            double dy = Double.valueOf(textField_dy.getText().replace(",", "."));

            Object o = objetos.get(combo_objeto.getSelectedItem().toString());

            panel_janela.removeAll();
            panel_janela.revalidate();

            panel_janela.getGraphics().clearRect(0, 0, 500, 500);

            if (o instanceof Reta) {
                Reta rLinha = t.transladarReta((Reta) o, dx, dy);
                Primitive.desenharReta((Graphics2D) panel_janela.getGraphics(), rLinha);
            } else {
                Poligono pLinha = t.transladarPoligono((Poligono) o, dx, dy);
                Primitive.desenharPoligono((Graphics2D) panel_janela.getGraphics(), pLinha);
                objetos.remove(combo_objeto.getSelectedItem().toString());
                objetos.put(combo_objeto.getSelectedItem().toString(), pLinha);

            }
            redesenhar();

            //panel_janela.validate();
        }


    }//GEN-LAST:event_button_transladarActionPerformed

    private void button_rotacionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_rotacionarActionPerformed
        if (textField_angulo.getText().isEmpty() || textField_pivoRotacao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe os valores do ângulo e do pivô.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            double angulo = Double.valueOf(textField_angulo.getText().replace(",", "."));
            String pivot = textField_pivoRotacao.getText();
            String[] xy = pivot.split(",");

            double[] pivo = new double[2];

            pivo[0] = Double.valueOf(xy[0]);
            pivo[1] = Double.valueOf(xy[1]);

            Object o = objetos.get(combo_objeto.getSelectedItem().toString());

            panel_janela.removeAll();
            panel_janela.revalidate();

            panel_janela.getGraphics().clearRect(0, 0, 500, 500);

            Poligono pLinha = t.rotacionarPoligono((Poligono) o, angulo, pivo);
            Primitive.desenharPoligono((Graphics2D) panel_janela.getGraphics(), pLinha);
            objetos.remove(combo_objeto.getSelectedItem().toString());
            objetos.put(combo_objeto.getSelectedItem().toString(), pLinha);
            redesenhar();

        }
    }//GEN-LAST:event_button_rotacionarActionPerformed

    private void redesenhar() {
        for (String chave : objetos.keySet()) {
            Object ob = objetos.get(chave);
            if (ob instanceof Reta) {
                Primitive.desenharReta((Graphics2D) panel_janela.getGraphics(), (Reta) ob);
            } else if (ob instanceof Poligono) {
                Primitive.desenharPoligono((Graphics2D) panel_janela.getGraphics(), (Poligono) ob);
            }
        }
    }
    private void toogleButton_escolherPivoRotacaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toogleButton_escolherPivoRotacaoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            pivoRotacao = true;
        }
    }//GEN-LAST:event_toogleButton_escolherPivoRotacaoItemStateChanged

    private void panel_janelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_janelaMouseClicked

        if (pivoRotacao || pivoEscala) {

            int sw = 500;
            int sh = 500;
            int lm = 0;
            int tm = 0;

            double xc = 0;
            double yc = 0;

            int xs = evt.getX();
            int ys = evt.getY();

            double xscale = sw * 2;
            double yscale = sh * 2;

            double x = (xs - lm - sw / 2) * (xscale / sw) + xc;
            double y = (sh / 2 - ys + tm) * (yscale / sh) + yc;

            Primitive.drawPixelOnly((Graphics2D) panel_janela.getGraphics(), (int) x, (int) y);

            if (pivoRotacao) {
                textField_pivoRotacao.setText((int) x + "," + (int) y);
                toogleButton_escolherPivoRotacao.setSelected(false);
                pivoRotacao = false;
            } else {
                textField_pivoEscala.setText((int) x + "," + (int) y);
                toogleButton_escolherPivoEscala.setSelected(false);
                pivoEscala = false;
            }
        }

    }//GEN-LAST:event_panel_janelaMouseClicked

    private void button_escalonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_escalonarActionPerformed
        if (textField_sx.getText().isEmpty() || textField_sy.getText().isEmpty() || textField_pivoEscala.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe os valores de sx, sy e do pivô.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {

            double sx = Double.valueOf(textField_sx.getText().replace(",", "."));
            double sy = Double.valueOf(textField_sy.getText().replace(",", "."));

            String pivot = textField_pivoEscala.getText();
            String[] xy = pivot.split(",");

            double[] pivo = new double[2];

            pivo[0] = Double.valueOf(xy[0]);
            pivo[1] = Double.valueOf(xy[1]);

            Object o = objetos.get(combo_objeto.getSelectedItem().toString());

            panel_janela.removeAll();
            panel_janela.revalidate();
            panel_janela.getGraphics().clearRect(0, 0, 500, 500);

            Poligono pLinha = t.escalonarPoligono((Poligono) o, sx, sy, pivo);
            Primitive.desenharPoligono((Graphics2D) panel_janela.getGraphics(), pLinha);

            objetos.remove(combo_objeto.getSelectedItem().toString());
            objetos.put(combo_objeto.getSelectedItem().toString(), pLinha);

            redesenhar();

        }
    }//GEN-LAST:event_button_escalonarActionPerformed

    private void toogleButton_escolherPivoEscalaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toogleButton_escolherPivoEscalaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            pivoEscala = true;
        } else {
            pivoEscala = false;
        }
    }//GEN-LAST:event_toogleButton_escolherPivoEscalaItemStateChanged

    private void criarObjetos() {

        BufferedReader in;
        objetos = new HashMap<>();

        try {
            in = new BufferedReader(new FileReader(arquivo));
            String linha;
            int nRetas = 0;
            int nPoligonos = 0;
            String[] pontos;
            while ((linha = in.readLine()) != null) {

                switch (linha.toUpperCase().charAt(0)) {
                    case 'M':
                        //Mundo
                        break;

                    case 'R':
                        nRetas++;
                        linha = linha.replace("R ", "");
                        pontos = linha.split("(?<!\\G[^,]*),");

                        Ponto p1 = new Ponto(Integer.valueOf(pontos[0].split(",")[0].trim()), Integer.valueOf(pontos[0].split(",")[1].trim()));
                        Ponto p2 = new Ponto(Integer.valueOf(pontos[1].split(",")[0].trim()), Integer.valueOf(pontos[1].split(",")[1].trim()));

                        Reta r = new Reta(p1, p2, "R" + nRetas);

                        objetos.put("R" + nRetas, r);

                        System.out.println(r);

                        break;

                    case 'P':
                        nPoligonos++;
                        linha = linha.replace("P ", "");
                        pontos = linha.split("(?<!\\G[^,]*),");
                        ArrayList pontosPoligono = new ArrayList();

                        for (String s : pontos) {
                            Ponto p = new Ponto(Integer.valueOf(s.split(",")[0].trim()), Integer.valueOf(s.split(",")[1].trim()));
                            pontosPoligono.add(p);
                        }
                        pontosPoligono.remove(pontosPoligono.size() - 1);
                        Poligono pol = new Poligono(pontosPoligono, "P" + nPoligonos);

                        objetos.put("P" + nPoligonos, pol);

                        System.out.println(pol);

                        break;

                    case 'J':

                        linha = linha.replace("J ", "");
                        pontos = linha.split("(?<!\\G[^,]*),");

                        Ponto p3 = new Ponto(Integer.valueOf(pontos[0].split(",")[0].trim()), Integer.valueOf(pontos[0].split(",")[1].trim()));
                        Ponto p4 = new Ponto(Integer.valueOf(pontos[1].split(",")[0].trim()), Integer.valueOf(pontos[1].split(",")[1].trim()));

                        
                        Poligono j = calculaJanela(p3, p4);

                        objetos.put("J", j);

                        System.out.println(j);

                        break;
                }
            }
            for (String chave : objetos.keySet()) {
                Object o = objetos.get(chave);
                if (o instanceof Reta) {
                    //combo_objeto.addItem(((Reta) o).getId());
                } else if (o instanceof Poligono) {
                    combo_objeto.addItem(((Poligono) o).getId());
                }
            }
            button_desenharObjetos.setEnabled(true);

            t = new Transformacoes();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Poligono calculaJanela(Ponto p1, Ponto p3){
        Poligono p = null;
        
        Ponto p2 = new Ponto(p1.getX(), p3.getY());
        Ponto p4 = new Ponto(p3.getX(), p1.getY());
        
        ArrayList<Ponto> pontos = new ArrayList();
        pontos.add(p1);
        pontos.add(p2);
        pontos.add(p3);
        pontos.add(p4);
               
        p = new Poligono(pontos, "J");
        
        return p;
    }

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
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Janela().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_desenharObjetos;
    private javax.swing.JButton button_escalonar;
    private javax.swing.JButton button_escolherArquivo;
    private javax.swing.JButton button_rotacionar;
    private javax.swing.JButton button_transladar;
    private javax.swing.JComboBox combo_objeto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_arquivo;
    private javax.swing.JLabel label_dx;
    private javax.swing.JLabel label_dy;
    private javax.swing.JLabel label_matrizResultante;
    private javax.swing.JLabel label_objeto;
    private javax.swing.JLabel label_pivoEscala;
    private javax.swing.JLabel label_pivoRotacao;
    private javax.swing.JLabel label_sx;
    private javax.swing.JLabel label_sy;
    private javax.swing.JPanel panel_janela;
    private javax.swing.JRadioButton radio_escala;
    private javax.swing.JRadioButton radio_rotacao;
    private javax.swing.JRadioButton radio_translacao;
    private javax.swing.JScrollPane scrollPane_matrizResultante;
    private javax.swing.JTextArea textArea_matrizResultante;
    private javax.swing.JTextField textField_angulo;
    private javax.swing.JTextField textField_arquivo;
    private javax.swing.JTextField textField_dx;
    private javax.swing.JTextField textField_dy;
    private javax.swing.JTextField textField_pivoEscala;
    private javax.swing.JTextField textField_pivoRotacao;
    private javax.swing.JTextField textField_sx;
    private javax.swing.JTextField textField_sy;
    private javax.swing.JToggleButton toogleButton_escolherPivoEscala;
    private javax.swing.JToggleButton toogleButton_escolherPivoRotacao;
    // End of variables declaration//GEN-END:variables
}