package com.jeco.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;

public class ConnectionManager {

    private static final int BUFFER = 1 * 1024 * 1024;

    private static final File DATABASE = new File(
            System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "dbOvinos"
            + System.getProperty("file.separator")
            + "DB.db");

   
    public static Connection getConnection() throws Exception {
    	checkDatabase();
    		
        Class.forName("org.sqlite.JDBC");
        Connection conn =
                DriverManager.getConnection("jdbc:sqlite:" + DATABASE.getPath());
        return conn;

    }

    public static void checkDatabase() throws Exception {
        if (!DATABASE.exists()) {
            createNewDatabase();
        }
    }
    
    public static boolean databaseExists() throws Exception {        
        return DATABASE.exists();
    }

    public static void createNewDatabase() throws JECOPersistenciaException {
        try {

            DATABASE.getParentFile().mkdirs();
            DATABASE.createNewFile();
            if (!DATABASE.exists()) {
                throw new JECOPersistenciaException("Erro ao gravar o arquivo de banco de dados.");
            }

            Connection conn = getConnection();
            Statement s = conn.createStatement();
            s.execute(JECOScriptTabelasDB.tbOvino);
            s.execute(JECOScriptTabelasDB.tbPeso);
            s.execute(JECOScriptTabelasDB.tbRaca);
            s.execute(JECOScriptTabelasDB.tbOcorrenciaTipo);
            s.execute(JECOScriptTabelasDB.tbOcorrencia);
            s.execute(JECOScriptTabelasDB.tbUsuario);
            
            

        } catch (Exception ex) {
            throw new JECOPersistenciaException("Erro na criação do banco de dados<br />" + ex.getMessage());
        }
    }

    public static void removeDataBase() throws JECOPersistenciaException {
        DATABASE.delete();
    }

    public static void backupDatabase(File arquivoBkp) throws Exception {

        //Verificações iniciais
        if (!DATABASE.exists()) {
            throw new Exception("Não foi possível fazer backup porquê o arquivo de dados não foi localizado!");
        }
        if (!arquivoBkp.isDirectory() && !arquivoBkp.getName().toLowerCase().endsWith(".db")) {
            arquivoBkp = new File(arquivoBkp.getPath() + ".db");
        }

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        
        try {
            bis = new BufferedInputStream(new FileInputStream(DATABASE), BUFFER);
            bos = new BufferedOutputStream(new FileOutputStream(arquivoBkp), BUFFER);

            int byteLido; 
            while ((byteLido = bis.read()) != -1)
            {
                bos.write(byteLido);
            }

        } finally {
            if (bos != null) {
                bos.flush();
                bos.close();
            }
            if (bis != null) {
                bis.close();
            }
        }

    }


    public static void recoverBackupDatabase(File arquivoBkp) throws Exception {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {

            bis = new BufferedInputStream(new FileInputStream(arquivoBkp), BUFFER);
            bos = new BufferedOutputStream(new FileOutputStream(DATABASE), BUFFER);

            int byteLido;
            while ((byteLido = bis.read()) != -1)
            {
                bos.write(byteLido);
            }

        } finally {
            if (bos != null) {
                bos.flush();
                bos.close();
            }
            if (bis != null) {
                bis.close();
            }
        }

    }

}   //fim da classe
