package application.handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import resources.Constants;

// +
public class DatabaseConnector {	
    private Connection connection;
    private Statement statement;
	private ResultSet resultSet;
	private String query;
	
	public void executeCreateQuery() throws ClassNotFoundException,
														SQLException {
		createDatabase();
		createTable();
	}
	
	private void createDatabase() throws ClassNotFoundException, 
														SQLException {
		createFirstConnection();
		createStatement();
		executeQuery(Constants.CREATE_DATABASE_QUERY);
	}
	
	private void createTable() throws ClassNotFoundException, 
														SQLException {
		createConnection();
		createStatement();
		useDatabase();
		executeQuery(Constants.CREATE_TABLE_QUERY);
	}
	
	public boolean executeInsertQuery() throws SQLException {
		return executeUpdateQuery();
	}
	
	public boolean executeUpdateQuery() throws SQLException {
		createStatement();
		int value = executeQuery(query);
		if (value != 0) {
			return true;
		}
		
		return false;
	}
	
	public void executeSelectQuery() throws SQLException {
		createStatement();
		createResultSet();
	}
	
	public void executeDeleteQuery() throws SQLException {
		createStatement();
		executeQuery(query);
		optimizeTable();
	}
	
	public void createInsertQuery(String engWord, String rusWord) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ").append(Constants.TABLE_NAME)
			.append(" VALUES(not null, '").append(engWord).append("' , '")
			.append(rusWord).append("' , '0' , '0');");
		setQuery(sb.toString());
	}
	
	public void createUpdateQuery(String parameter, int value) 
													throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ").append(Constants.DATABASE_NAME).append(".")
			.append(Constants.TABLE_NAME).append(" SET ")
			.append(parameter).append(" = '")
			.append(value).append("' WHERE ID = '")
			.append(getID()).append("';");
		setQuery(sb.toString());
	}
	
	public void createSelectQuery(String parameter, int value) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ").append(Constants.TABLE_NAME)
			.append(" WHERE ").append(parameter)
			.append(" = '").append(value).append("';");
		setQuery(sb.toString());
	}
	
	public void createSelectQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EnglishWord, RussianWord, ID FROM ")
			.append(Constants.TABLE_NAME).append(";");
		setQuery(sb.toString());
	}
	
	public void createDeleteQuery(int id) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ")
			.append(Constants.TABLE_NAME).append(" WHERE id = '")
			.append(id).append("';");
		setQuery(sb.toString());
	}
	
	public boolean nextElement() throws SQLException {
		if (resultSet.next()) {
			return true;
		}
		
		return false;
	}
	
	public boolean isResultSetClosed() throws SQLException {
		return resultSet.isClosed();
	}
	
	private int executeQuery(String query) throws SQLException {
		return statement.executeUpdate(query);
	}
	
	private void createFirstConnection() throws ClassNotFoundException, 
															SQLException {
		Class.forName(Constants.DRIVER_NAME);
		connection = DriverManager.getConnection(
		Constants.EMPTY_URL, Constants.USER, Constants.PASSWORD);
	}
	
	private void createConnection() throws ClassNotFoundException, 
													SQLException {
		Class.forName(Constants.DRIVER_NAME);
		connection = DriverManager.getConnection(
		Constants.URL, Constants.USER, Constants.PASSWORD);
	}
	
	private void createStatement() throws SQLException {
		statement = connection.createStatement();
	}
	
	private void createResultSet() {
		try {    		
			setResultSet(statement.executeQuery(query));
		} catch(SQLException ex) {
			System.out.println(ex);							
		}
	}
	
	private void useDatabase() throws SQLException {
		statement.executeUpdate(Constants.USE_DATABASE_QUERY);
	}
	
	private void optimizeTable() throws SQLException {
		statement.executeUpdate(Constants.OPTIMIZE_TABLE_QUERY);
	}
	
	public Connection getConnection() {
		try {
			createConnection();
			return connection;
		} catch (Exception ex) {
			System.out.println(ex);								
		}
		
		return null;
	}
	
    public Statement getStatement() {
    	try {
    		createStatement();
    		return statement;
    	} catch (SQLException ex) {
			System.out.println(ex);						
		}
    	return null;
	}
	
	public ResultSet getResultSet() {
		return resultSet;
	}
	
	public int getColumnCount() throws SQLException {
		return resultSet.getMetaData().getColumnCount();
	}
	
	public String getDatabaseString(int number) throws SQLException {
		return resultSet.getString(number);
	}
	
	public int getID() throws SQLException {			
		return resultSet.getInt(Constants.ID_COLUMN);
	}
	
	public String getEnglishWord() throws SQLException {	
		return resultSet.getString(Constants.ENG_WORD_COLUMN);
	}
	
	public String getRussianWord() throws SQLException {	
		return resultSet.getString(Constants.RUS_WORD_COLUMN);
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
}
