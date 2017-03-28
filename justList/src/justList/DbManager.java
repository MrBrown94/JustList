package justList;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DbManager {
	
	private File dbDir = null;
	private String path = "";
	private Statement st = null;
	private Connection connection = null;
	private ResultSet rs = null;
	private int countVini = 0;
	
	//Inizializzazione connessione DB
	public DbManager() {
		
		//Get Path DB
		getPath();
		
		//Connessione al DB
		try {
			connection = DriverManager.getConnection("jdbc:ucanaccess://" + path);
		
			st = connection.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				connection.close();
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	//Get Path del programma
	public void getPath() {
		
		//Estrazione path
		dbDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
		
		//Decode path e creazione string
	    path = dbDir.getAbsolutePath();
	    try {
			path = java.net.URLDecoder.decode(path, "UTF-8");
			
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
	    
	    path = path.replaceAll("bin", "");
	    path = path.replace("\\", "/");
	    path += "db/db.mdb;memory=false";
	}
	
	
	//Count elementi nel DB
	public int countVini() {
		
		try {
			st.execute("SELECT COUNT(*) FROM articoli");
			rs = st.getResultSet();
			
			while (rs.next()) {
				
				countVini = rs.getInt(1);
			}
			
			return countVini;
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				st.close();
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return 0;
	}
	
	//Get Info Vini
	public Object[][] getAllData() {
		
		Object[][] tb = new Object[countVini()][3];
		int count = 0;
		
		try {
			st.execute("SELECT * FROM articoli");
			rs = st.getResultSet();
			
			while (rs.next()){
				
				tb[count][0]=rs.getString(2); //Descrizione
				tb[count][1]=rs.getString(10); //Quantità
				tb[count][2]=rs.getString(15); //Prezzo
				count++;
			}
			
			return tb;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				st.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return tb;
    }
}