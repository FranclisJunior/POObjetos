package com.jeco.ui.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class ListennerControldefault implements ActionListener{
	private List<ControlerHomeListener> listeners;
	
	public ListennerControldefault() {
		listeners = new LinkedList<>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void enviarListeners(ControlEvent ev){
		for(ControlerHomeListener lis: listeners)
			lis.event(ev);
	}

}
