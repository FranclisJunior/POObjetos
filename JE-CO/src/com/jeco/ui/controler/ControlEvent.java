package com.jeco.ui.controler;

import java.awt.Component;

public class ControlEvent {
	private int value;
	private String msg="";
	private Component comp;
	public EnumNomeBotoes butonEnum = EnumNomeBotoes.OPCAO_NULL;
	
	public ControlEvent(Component comp,EnumNomeBotoes butonEnum, int value) {
		if(!(butonEnum == null))
			this.butonEnum = butonEnum;
		this.comp = comp;
		this.value = value;
		
	}
	
	public ControlEvent(Component comp) {
		this.msg = "";
		this.comp = comp;
		this.value = 0;		
	}
	
	public ControlEvent(EnumNomeBotoes butonEnum) {
		if(!(butonEnum == null))
			this.butonEnum = butonEnum;
	}
	
	public ControlEvent(String msg) {
		if(!(msg == null))
				this.msg = msg;		
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Component getComponent() {
		return comp;
	}

	public void setComponent(Component comp) {
		this.comp = comp;
	}

	public EnumNomeBotoes getButonEnum() {
		return butonEnum;
	}

	public void setButonEnum(EnumNomeBotoes butonEnum) {
		this.butonEnum = butonEnum;
	}
	



}
