package com.jeco.ui.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;

import com.jeco.logger.JECOLogger;
import com.jeco.ui.butons.BtCancelar;
import com.jeco.ui.controler.EnumNomeBotoes;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class JanelaEventos  extends PanelDefault{
	private JButton bPeso;
	private JPanel painelSecundario;
	private JButton bCancelar;
	private JButton bOvinoEsterio;
	
	
	public JanelaEventos() {
		super("EVENTOS", EnumNomeBotoes.VISUALIZAR_EVENTOS_CLOSE);
		initGUI();
		run();
	}
	
	private void initGUI() {
		try {
			this.setSize(new java.awt.Dimension(351, 250));
			this.setLayout(null);
			{
				painelSecundario = new JPanel();
				this.add(painelSecundario);
				painelSecundario.setLayout(null);
				painelSecundario.setBounds(12, 12, 327, 179);
				painelSecundario.setBorder(BorderFactory.createTitledBorder(null, "Escolha um evento:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,12)));
				{
					bPeso = new JButton();
					painelSecundario.add(bPeso);
					bPeso.setText("Ovinos com peso X");
					bPeso.setBounds(53, 47, 231, 28);
					bPeso.setFont(new java.awt.Font("Segoe UI",1,12));
					bPeso.addActionListener(new Action());
				}
				{
					bOvinoEsterio = new JButton();
					painelSecundario.add(bOvinoEsterio);
					bOvinoEsterio.setText("Ovinos que não pariu a mais de 1 ano");
					bOvinoEsterio.setBounds(53, 102, 231, 28);
					bOvinoEsterio.setFont(new java.awt.Font("Segoe UI",1,12));
				}
			}
			{
				bCancelar = new BtCancelar();
				this.add(bCancelar);
				bCancelar.setText("Cancelar");
				bCancelar.setBounds(235, 209, 103, 30);
				bCancelar.setFont(new java.awt.Font("Segoe UI",1,12));
				bCancelar.addActionListener(new Action());
			}
		} catch (Exception e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte. ",JanelaInformacao.ERRO);
		}
	}
	
	private class Action extends MouseAdapter implements ActionListener{

    	@Override
    	public void actionPerformed(ActionEvent e) {    		
    		if(e.getSource().equals(bCancelar)) {
    			close();
    		}
    		else if(e.getSource().equals(bPeso)) {
    			new JanelaPesosCadastrados(true);
    			validate();
    		}
    	}
	}

}
