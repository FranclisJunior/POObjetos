
package com.jeco.io;

public class JECOScriptTabelasDB {
	public static final String tbOvino ="CREATE TABLE IF NOT EXISTS `ovino` (" +
			"`OVINO_ID` INTEGER PRIMARY KEY ,"+
		  "`OVINO_CODIGO` varchar(15)  NOT NULL,"+
		  "`OVINO_SEXO` varchar(5)  NOT NULL,"+
		  "`OVINO_DATA` varchar NOT NULL,"+
		  "`OVINO_RACA` varchar(40) NOT NULL,"+
		  "`OVINO_STATUS` varchar(1) NOT NULL DEFAULT '1',"+
		  "`OVINO_COD_GENITORA` varchar(15) NOT NULL DEFAULT 'DESCONHECIDO',"+
		  "`OVINO_PRECO` float NOT NULL"+
		   " )  ;";
	
	public static final String tbPeso ="CREATE TABLE IF NOT EXISTS `peso` ("+
		  "`PESO_ID` INTEGER PRIMARY KEY,"+
		  "`PESO_COD_OVINO` varchar(15)  NOT NULL,"+
		  "`PESO_DATA` date NOT NULL,"+
		  "`PESO_PESO` float NOT NULL"+		  
		  ")  ;";

	
	public static final String tbRaca ="CREATE TABLE IF NOT EXISTS `raca` ("+
		  "`RACA_ID` INTEGER PRIMARY KEY,"+
		  "`RACA_NOME` VARCHAR(40) NOT NULL"+			  
		  ")  ;";
	
	public static final String tbOcorrenciaTipo ="CREATE TABLE IF NOT EXISTS `ocorrenciaTipo` ("+
		  "`OCORRENCIA_TIPO_ID` INTEGER PRIMARY KEY,"+
		  "`OCORRENCIA_TIPO_NOME` VARCHAR(40) NOT NULL"+			  
		  ")  ;";
	
	public static final String tbOcorrencia ="CREATE TABLE IF NOT EXISTS `ocorrencia` ("+
		  "`OCORRENCIA_ID` INTEGER PRIMARY KEY,"+
		  "`OCORRENCIA_TIPO` VARCHAR(15) NOT NULL,"+
		  "`OCORRENCIA_CODOVELHA` VARCHAR(40) NOT NULL,"+
		  "`OCORRENCIA_DESCRICAO` VARCHAR(40) NOT NULL,"+
		  "`OCORRENCIA_DATA` DATE NOT NULL,"+
		  "`OCORRENCIA_PRECO` FLOAT NOT NULL"+
		  ")  ;";
	
	public static final String tbUsuario ="CREATE TABLE IF NOT EXISTS `usuario` ("+
			  "`USUARIO_ID` INTEGER PRIMARY KEY,"+
			  "`USUARIO_NOME` VARCHAR(15) NOT NULL,"+			  
			  "`USUARIO_SENHA` VARCHAR(15) NOT NULL,"+
			  "`USUARIO_NIVEL` VARCHAR(4) NOT NULL"+
			  ")  ;";
}




