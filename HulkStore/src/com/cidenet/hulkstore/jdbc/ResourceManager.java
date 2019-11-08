package com.cidenet.hulkstore.jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.swing.JOptionPane;

public class ResourceManager
{
    private static String JDBC_DRIVER   = "com.mysql.cj.jdbc.Driver";
    private static String JDBC_URL;
    private static String JDBC_USER;
    private static String JDBC_PASSWORD;

    private static Driver driver = null;
    
    public static String[] getDataConnection(){
        String[] data = null;
                
        try {
            data = new String[3];
            FileReader fReader = new FileReader("connection.dat");
            BufferedReader bReader = new BufferedReader(fReader);
            String line;
            int number = 0;

            while((line = bReader.readLine()) != null)
            {
                data[number] = line.substring(line.indexOf("=") + 1, line.length());
                number++;
                if(number > 2)
                    break;
            }
         
        } catch (IOException ex) {            
            JOptionPane.showMessageDialog(null, "Error al acceder al archivo connection.dat", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return data;
    }
    
    public static void setDataConnection(String host, String user, String pass){
        try
        (PrintWriter pWritter = new PrintWriter("connection.dat")) {
            
            pWritter.print("host=" + host +
                        "\nusuario=" + user +
                        "\npassword=" + pass +
                        "\n\nNo editar este archivo.");
        }
        catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "No se encontro el archivo connection.dat", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean testConnection(String host, String user, String pass) {
        boolean ok = false;
        Driver dvr;
        try
        {
            Class jdbcDriverClass = Class.forName( JDBC_DRIVER );
            dvr = (Driver) jdbcDriverClass.newInstance();
            DriverManager.registerDriver( dvr );
            close(DriverManager.getConnection(host, user, pass));
            ok = true;
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e)
        {    
            JOptionPane.showMessageDialog(null, "Falló test de conexión a la base de datos.\nConfigure la conexión correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return ok;
    }
    
    public static boolean setConnection() throws SQLException{
        boolean ok = false;
        
        String[] dataConection = getDataConnection();

        JDBC_URL = dataConection[0];
        JDBC_USER = dataConection[1];
        JDBC_PASSWORD = dataConection[2];

        try {
            close(getConnection());            
            ok = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos.\nConfigure la conexión correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);                
        }   
        
        return ok;  
    }

    public static synchronized Connection getConnection()
	throws SQLException
    {
        if (driver == null)
        {
            try
            {
                Class jdbcDriverClass = Class.forName( JDBC_DRIVER );
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver( driver );
            }
            catch (Exception e)
            {                
                System.out.println( "Failed to initialise JDBC driver" );
                e.printStackTrace();
            }
        }

        return DriverManager.getConnection(
                JDBC_URL,
                JDBC_USER,
                JDBC_PASSWORD
        );
    }


	public static void close(Connection conn)
	{
		try {
			if (conn != null) conn.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}

	public static void close(PreparedStatement stmt)
	{
		try {
			if (stmt != null) stmt.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}

	public static void close(ResultSet rs)
	{
		try {
			if (rs != null) rs.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}

	}

}
