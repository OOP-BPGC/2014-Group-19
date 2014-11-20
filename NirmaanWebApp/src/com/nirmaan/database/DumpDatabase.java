package com.nirmaan.database;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class DumpDatabase {
   private Connection conn;
   private PrintWriter out;

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
   
   public void dumpDatabase(String fileName) 
throws FileNotFoundException, SQLException {
      out = new PrintWriter(fileName);
      listAll();
      out.close();
      conn.close();
   }

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