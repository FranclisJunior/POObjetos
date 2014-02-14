package com.jeco.ui.view;

import com.jeco.JECOException;
import com.jeco.ui.auxilares.BuscaDB;
import com.jeco.ui.controler.EnumNomeBotoes;
import com.jeco.ui.controler.TipoInformacaoEnum;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
public class BackupDB extends PanelDefault {

	public BackupDB() {
		super("BACKUP BANCO DE DADOS", EnumNomeBotoes.BACKUP_CLOSE);
		initGUI();
		run();
	}
	
	private void initGUI() {
		try {
			{
				FlowLayout thisLayout = new FlowLayout();
				this.setLayout(thisLayout);
				this.setSize(new java.awt.Dimension(424, 324));
				{
					jLabelBackup = new JLabel();
					this.add(jLabelBackup);
					jLabelBackup.setBounds(0, 0, 390, 276);
					jLabelBackup.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/backup.png")));
					jLabelBackup.setPreferredSize(new java.awt.Dimension(281, 250));
				}
				{
					jButtonRestore = new JButton();
					this.add(jButtonRestore);
					jButtonRestore.setText("Restaurar");
					jButtonRestore.setBackground(new java.awt.Color(183,91,0));
					jButtonRestore.setFont(new java.awt.Font("Segoe UI",0,16));
					jButtonRestore.setForeground(new java.awt.Color(192,192,192));
					jButtonRestore.setPreferredSize(new java.awt.Dimension(193, 39));
					jButtonRestore.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(new BuscaDB().restoryDB("Restaurar Banco de Dados"));
								new JanelaInformacao("DB restaurado com sucesso!", TipoInformacaoEnum.SUCESSO);
						}
					});
				}
				{
					jButton1 = new JButton();
					this.add(jButton1);
					jButton1.setText(" Backup");
					jButton1.setBackground(new java.awt.Color(64,128,128));
					jButton1.setFont(new java.awt.Font("Segoe UI",0,16));
					jButton1.setForeground(new java.awt.Color(192,192,192));
					jButton1.setSize(390, 39);
					jButton1.setPreferredSize(new java.awt.Dimension(195, 39));
					jButton1.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								if(new BuscaDB().backupDB("Banco de dados"));
									new JanelaInformacao("Backup feito com sucesso!", TipoInformacaoEnum.SUCESSO);
								
							} catch (JECOException e1) {
								new JanelaInformacao("Não foi possivel fazer backup do banco de dados!");
							}
							
						}
					});
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jButton1;
	private JButton jButtonRestore;
	private JLabel jLabelBackup;

}
