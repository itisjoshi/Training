package com.talenttar.kowsalya.sqlquery;

import java.io.DataInputStream;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SqlDemo {
		  private Connection connect = null;
		  private Statement statement = null;
		  private PreparedStatement preparedStatement = null;
		  private ResultSet resultSet = null;
		  DataInputStream in = new DataInputStream(System.in);
		  String name;
		  @SuppressWarnings("deprecation")
		public void readDataBase() throws Exception {
			    try {
			      // This will load the MySQL driver, each DB has its own driver
			      Class.forName("com.mysql.jdbc.Driver");
			      // Setup the connection with the DB
			      connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/joshi?"+"user=sqluser&password=sqluserpw");

			      // Statements allow to issue SQL queries to the database
			      statement = (Statement) connect.createStatement();
			      // Result set get the result of the SQL query
			      resultSet = statement
			          .executeQuery("select * from joshi.comments");
			      writeResultSet(resultSet);
			      preparedStatement = (PreparedStatement) connect
			              .prepareStatement("insert into  joshi.comments values (default, ?, ?, ?, ? , ?, ?)");
			          // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
			          // Parameters start with 1
			      System.out.println("Please enter your name");
			      name = in.readLine();
			          preparedStatement.setString(1, name);
			          preparedStatement.setString(2, "TestEmail");
			          preparedStatement.setString(3, "TestWebpage");
			          preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
			          preparedStatement.setString(5, "TestSummary");
			          preparedStatement.setString(6, "TestComment");
			          preparedStatement.executeUpdate();

			          preparedStatement = (PreparedStatement) connect
			              .prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from joshi.comments");
			          resultSet = preparedStatement.executeQuery();
			          writeResultSet(resultSet);
			          
			          preparedStatement = (PreparedStatement) connect
			        	      .prepareStatement("delete from joshi.comments where myuser= ? ; ");
			          System.out.println("Please enter your name to delete");
				      name = in.readLine();
				          preparedStatement.setString(1, name);
				          
			        	      preparedStatement.executeUpdate();
			        	      
			        	      resultSet = statement
			        	      .executeQuery("select * from joshi.comments");
			        	      writeResultSet(resultSet);

			    } catch (Exception e) {
			      throw e;
			    } finally {
			      close();
			    }
			  }
		  
		  private void writeResultSet(ResultSet resultSet) throws SQLException {
			    // ResultSet is initially before the first data set
			    while (resultSet.next()) {
			      // It is possible to get the columns via name
			      // also possible to get the columns via the column number
			      // which starts at 1
			      // e.g. resultSet.getSTring(2);
			      String user = resultSet.getString("myuser");
			      String website = resultSet.getString("webpage");
			      String summery = resultSet.getString("summary");
			      Date date = resultSet.getDate("datum");
			      String comment = resultSet.getString("comments");
			      System.out.println("User: " + user);
			      System.out.println("Website: " + website);
			      System.out.println("Summery: " + summery);
			      System.out.println("Date: " + date);
			      System.out.println("Comment: " + comment);
			    }
			  }

			  // You need to close the resultSet
			  private void close() {
			    try {
			      if (resultSet != null) {
			        resultSet.close();
			      }

			      if (statement != null) {
			        statement.close();
			      }

			      if (connect != null) {
			        connect.close();
			      }
			    } catch (Exception e) {

			    }
			  }
			} 
