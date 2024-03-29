package com.nirmaan.database;

import java.io.FileWriter;
import java.io.IOException;
<<<<<<< HEAD
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jxl.write.Label;

import com.utility.HibernateUtil;

public class DB2CSV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// usual database connection part
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/";
		String db = "db_name";
		String driver = "com.mysql.jdbc.Driver";
		String user = "username";
		String pass = "password";
		FileWriter fw;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url + db, user, pass);
			Statement st = con.createStatement();

			// this query gets all the tables in your database(put your db name
			// in the query)
			ResultSet res = st
					.executeQuery("SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = 'db_name' ");

			// Preparing List of table Names
			List<String> tableNameList = new ArrayList<String>();
			while (res.next()) {
				tableNameList.add(res.getString(1));
			}

			// path to the folder where you will save your csv files
			String filename = "D:/db2csv/";

			// star iterating on each table to fetch its data and save in a .csv
			// file
			for (String tableName : tableNameList) {
				int k = 0;

				int j = 1;

				System.out.println(tableName);

				List<String> columnsNameList = new ArrayList<String>();

				// select all data from table
				res = st.executeQuery("select * from xcms." + tableName);

				// colunm count is necessay as the tables are dynamic and we
				// need to figure out the numbers of columns
				int colunmCount = getColumnCount(res);

				try {
					fw = new FileWriter(filename + "" + tableName + ".csv");

					// this loop is used to add column names at the top of file
					// , if you do not need it just comment this loop
					for (int i = 1; i <= colunmCount; i++) {
						fw.append(res.getMetaData().getColumnName(i));
						fw.append(",");

					}

					fw.append(System.getProperty("line.separator"));

					while (res.next()) {
						for (int i = 1; i <= colunmCount; i++) {

							// you can update it here by using the column type
							// but i am fine with the data so just converting
							// everything to string first and then saving
							if (res.getObject(i) != null) {
								String data = res.getObject(i).toString();
								fw.append(data);
								fw.append(",");
							} else {
								String data = "null";
								fw.append(data);
								fw.append(",");
							}

						}
						// new line entered after each row
						fw.append(System.getProperty("line.separator"));
					}

					fw.flush();
					fw.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			con.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Could not load JDBC driver");
			e.printStackTrace();
		} catch (SQLException ex) {
			System.err.println("SQLException information");
		}
	}

	// to get numbers of rows in a result set
	public static int getRowCount(ResultSet res) throws SQLException {
		res.last();
		int numberOfRows = res.getRow();
		res.beforeFirst();
		return numberOfRows;
	}

	// to get no of columns in result set

	public static int getColumnCount(ResultSet res) throws SQLException {
		return res.getMetaData().getColumnCount();
	}

}
=======
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Class DumpDatabase to dump all teh database data to file
 * contains main method
 */
public class DumpDatabase {
   private Connection conn;
   private PrintWriter out;

 /**
 * To create file and call methods 
 */
public static void main(String[] args) {
      try {
         DumpDatabase app = new DumpDatabase();
         String timestamp = new SimpleDateFormat("MMdd-hhmmss")
.format(new Date());
         String fileName = "dumpdatabase-" + timestamp + ".txt";
         System.out.println("Creating " + fileName);
         app.dumpDatabase(fileName);
         System.out.println("Done.");
      } catch(Exception e) {
         e.printStackTrace();
         System.exit(1);
      }
   }

   /**
 * @throws IOException
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public DumpDatabase() throws IOException, 
ClassNotFoundException, SQLException {
      // Get database connection from hibernate.properties.
      // Or hard-code your own JDBC connection if desired.
      InputStream in = getClass().getResourceAsStream(
"/hibernate.properties");
      Properties properties = new Properties();
      properties.load(in);
      String driver = properties.getProperty(
"hibernate.connection.driver_class");
      String url = properties.getProperty(
"hibernate.connection.url");
      String user = properties.getProperty(
"hibernate.connection.username");
      String password = properties.getProperty(
"hibernate.connection.password");

      Class.forName(driver);
      conn = DriverManager.getConnection(url, user, password);
   }
   
   /**
 * @param fileName file where data is the be dumped
 * @throws FileNotFoundException
 * @throws SQLException
 */
public void dumpDatabase(String fileName) 
throws FileNotFoundException, SQLException {
      out = new PrintWriter(fileName);
      listAll();
      out.close();
      conn.close();
   }

   /**
 * @throws SQLException
 */
public void listAll() throws SQLException {
      DatabaseMetaData metadata = conn.getMetaData();
      String[] types = { "TABLE" };
      ResultSet rs = metadata.getTables(
null, null, null, types);
      while(rs.next()) {
         String tableName = rs.getString("TABLE_NAME");
         listTable(tableName);
      }
   }

   /**
 * @param tableName Name of table to be dumped
 * @throws SQLException
 */
private void listTable(String tableName) throws SQLException  {
      PreparedStatement statement = conn.prepareStatement(
            "select * from " + tableName + " a");
      out.println("----" + tableName + "----");
      int rowNo = 0;
      ResultSet rs = statement.executeQuery();
      while(rs.next()) {
         if (rowNo == 0)
            printTableColumns(rs);
         printResultRow(rs);
         rowNo++;
      }
   }

 /**
 * @param rs ResultSet
 * @throws SQLException
 */
private void printTableColumns(ResultSet rs) 
throws SQLException {
      ResultSetMetaData metaData = rs.getMetaData();
      for(int i = 0; i < metaData.getColumnCount(); i++) {
         int col = i + 1;
         out.println(metaData.getColumnName(col) + " "
               + metaData.getColumnTypeName(col) + " " + "("
               + metaData.getPrecision(col) + ")");
      }
      out.println("");
   }

   /**
 * @param rs ResultSet
 * @throws SQLException
 */
private void printResultRow(ResultSet rs) throws SQLException {
      ResultSetMetaData metaData = rs.getMetaData();
      for(int i = 0; i < metaData.getColumnCount(); i++) {
         String column = metaData.getColumnName(i + 1);
         try {
            String value = rs.getString(column);
            if (value != null && !value.equals("null") 
                  && !value.equals("") && !value.equals("0"))
               out.print(column + ": " + value + ", ");
         }
         catch(SQLException e) {
            out.print(column + ": " + e.getMessage());
         }
      }
      out.println("");
   }
}
>>>>>>> be67708a7b2b21984355b57c5653a612235d720f
