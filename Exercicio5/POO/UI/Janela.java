
package UI;

import Formulario.Campo;
import Formulario.Formulario;
import Validador.Validador;
import Validador.ValidadorNome;
import Validador.ValidadorSenha;
import javax.swing.JOptionPane;


public class Janela extends javax.swing.JFrame {
    
    public Janela() {
        initComponents();
    }

    Formulario formulario = new Formulario();
    StringBuffer erros= new StringBuffer();   
    
    public void teste(){     
               
        String nome = campoNome.getText();
        Campo campoN = new Campo("Nome","Campo de Nome",new ValidadorNome());  
        campoN.setValor(nome);
        if(formulario.setValor(campoN)!=true){
            erros.append("Nome Invalido\n");
            campoNome.setText(null);
        }else{
            formulario.addCampo(campoN);
        }  
        
        String senha = campoSenha.getText(); 
        Campo campoS = new Campo("Senha","Campo de Senha",new ValidadorSenha()); 
        campoS.setValor(senha);
        if(formulario.setValor(campoS)!=true){
            campoSenha.setText(null); 
            erros.append("Senha Invalida\n");            
        }       
       
        if(erros.toString()==null || erros.toString().equals("")){
        	//gravar formulario
        }else{
        	JOptionPane.showMessageDialog(null,erros);
        }
    }
    
    public void limparCampos(){
        campoNome.setText(null);
        campoIdade.setText(null);
        campoEmail.setText(null);
        campoSenha.setText(null);        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        rNome = new javax.swing.JLabel();
        rIdade = new javax.swing.JLabel();
        rEmail = new javax.swing.JLabel();
        rSenha = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoIdade = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        campoSenha = new javax.swing.JTextField();
        bLimpar = new javax.swing.JButton();
        bGravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painel.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario"));

        rNome.setText("Nome:");

        rIdade.setText("Idade:");

        rEmail.setText("Email:");

        rSenha.setText("Senha:");

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(rNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rIdade)
                            .addComponent(rEmail)
                            .addComponent(rSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(campoEmail)
                            .addComponent(campoIdade))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rNome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rIdade)
                    .addComponent(campoIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rEmail)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSenha)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        bLimpar.setText("Limpar");
        bLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimparActionPerformed(evt);
            }
        });

        bGravar.setText("Gravar");
        bGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bGravar)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bLimpar)
                    .addComponent(bGravar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        
    }//GEN-LAST:event_campoNomeActionPerformed

    private void bLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimparActionPerformed
       limparCampos();
    }//GEN-LAST:event_bLimparActionPerformed

    private void bGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGravarActionPerformed
        Janela janela =new Janela();
        janela.teste();
    }//GEN-LAST:event_bGravarActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bGravar;
    private javax.swing.JButton bLimpar;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoIdade;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoSenha;
    private javax.swing.JPanel painel;
    private javax.swing.JLabel rEmail;
    private javax.swing.JLabel rIdade;
    private javax.swing.JLabel rNome;
    private javax.swing.JLabel rSenha;
    // End of variables declaration//GEN-END:variables
}
