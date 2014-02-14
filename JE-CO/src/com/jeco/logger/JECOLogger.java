package com.jeco.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JECOLogger {

	private static File logsDir;

	private static SimpleDateFormat format;

	static {
		format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		URL url = JECOLogger.class.getResource("/");
		File classesDir = new File(url.getPath());
		logsDir = new File(classesDir.getParentFile().getPath().replace("%20", " ") + "/logs/");

		if (!logsDir.exists()) {
			logsDir.mkdir();
		}
	}

	private File errosFile;

	private static JECOLogger singleton;

	public static JECOLogger getInstance(){
		if(singleton == null){
			singleton = new JECOLogger();
		}
		return singleton;
	}

	private JECOLogger(){
		errosFile = new File(logsDir,"erros.log");		
	}

	public void log(String msg){
		try {
			FileWriter out = new FileWriter(errosFile, true);
			out.write(cabecalho(msg));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void log(String msg, Throwable exception) {
		try {
			FileWriter out = new FileWriter(errosFile, true);
			out.write(cabecalho(msg));
			exception.printStackTrace(new PrintWriter(out));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void log(Throwable exception) {
		log(null,exception);
	}

	private String cabecalho(String msg){
		StringBuilder msgErro = new StringBuilder();
		msgErro.append(">>> "+format.format(new Date())+"\n");
		if(msg != null)
			msgErro.append("MSG: "+msg+"\n");
		return msgErro.toString();		
	}

}
