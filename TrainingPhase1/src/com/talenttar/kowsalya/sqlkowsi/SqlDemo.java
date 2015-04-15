package com.talenttar.kowsalya.sqlkowsi;


	import java.io.DataInputStream;
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
				      connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/kowsi?"+"user=root&password=root");

				      // Statements allow to issue SQL queries to the database
				      statement = (Statement) connect.createStatement();
				      // Result set get the result of the SQL query
				      resultSet = statement.executeQuery("select * from kowsi.mytable");
				      writeResultSet(resultSet);
				      preparedStatement = (PreparedStatement) connect
				              .prepareStatement("insert into  kowsi.mytable values (?,?)");
				          // "myuser, webpage, datum, summery, COMMENTS from kowsi.mytable");
				          // Parameters start with 1
				      System.out.println("Please enter your name");
				      name = in.readLine();
				      System.out.println("Please enter your id");
				      int id;
				      id = Integer.parseInt(in.readLine());
				          preparedStatement.setInt(1, id);
				          preparedStatement.setString(2, name);
				          preparedStatement.executeUpdate();

				          preparedStatement = (PreparedStatement) connect
				              .prepareStatement("SELECT id,name from kowsi.mytable");
				          resultSet = preparedStatement.executeQuery();
				          writeResultSet(resultSet);
				          
				          preparedStatement = (PreparedStatement) connect
				        	      .prepareStatement("delete from kowsi.mytable where name= ? ; ");
				          System.out.println("Please enter your name to delete");
					      name = in.readLine();
					          preparedStatement.setString(1, name);
					          
				        	      preparedStatement.executeUpdate();
				        	      
				        	      resultSet = statement
				        	      .executeQuery("select * from kowsi.mytable");
				        	      writeResultSet(resultSet);

				    } catch (Exception e) {
				      throw e;
				    } finally {
				      close();
				    }
				  }
			  
			  private void writeResultSet(ResultSet resultSet) throws SQLException {
				    while (resultSet.next()) {
				      int user = Integer.parseInt(resultSet.getString("id"));
				      String name = resultSet.getString("name");
				      System.out.println("id: " + user);
				      System.out.println("name: " + name);
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
