package application.handlers;

import java.sql.SQLException;
import java.util.regex.Matcher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import resources.Constants;

// +
public abstract class EventHandlerClass 
						implements EventHandler<ActionEvent> {
	protected DatabaseConnector dbConnector;							
	protected static boolean databaseExists;
	
	protected void init() {
		createWindowParameters();
		createView();
		setActionsForButtons();
		createConnection();
		createDatabaseIfNotExists();
	}
	
	protected void createWindowParameters() {
		
	}
	
	protected void createView() {

	}
	
	protected void setActionsForButtons() {
		
	}
	
	private void createConnection() {
		dbConnector = new DatabaseConnector();
	}

	private void createDatabaseIfNotExists() {
		if (!databaseExists) {
			readyDatabase();
		} else {
			dbConnector.getConnection();
		}
	}
	
	private void readyDatabase() {
		try {
			dbConnector.executeCreateQuery();
			databaseExists = true;
		} catch (SQLException ex) {
			System.out.println(ex);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		} 
	}
	
	@Override
	public void handle(ActionEvent event) {
		
	}
	
	protected static boolean isEnglishWordValid(String engWord) {
		Matcher matcher = Constants.VALID_ENG_REGEX.matcher(engWord);
		return matcher.find();
	}
	
	protected static boolean isRussianWordValid(String rusWord) {
		Matcher matcher = Constants.VALID_RUS_REGEX.matcher(rusWord);
		return matcher.find();
	}
	
	public void refreshFields() {
		clearFields();
		setFocus();
	}

	protected void setFocus() {

	}

	protected void clearFields() {

	}
}
