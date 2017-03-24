package application.windows;

import java.sql.SQLException;

import application.handlers.EventHandlerClass;
import application.views.TrainingGeneralView;
import javafx.event.ActionEvent;
import resources.Constants;

// +
public abstract class TrainingGeneralWindow extends EventHandlerClass {
	protected TrainingGeneralView view;
	protected String windowTitle;
	protected String enteredText;
	protected String wordStatusColumn;
	protected int wordStatusValue;
	protected String wordToTranslate;
	protected String translationOfWord;

	@Override
	protected void createView() {
		view = new TrainingGeneralView(windowTitle);
	}
	
	@Override
	public void handle(ActionEvent event) {
        try {
        	if (!isResultSetClosed()) {
        		createTranslation();				
	        	
        		if (isTranslationCorrected()) {
        			checkTranslationOnEquality();
        			refreshFields();
    	        	getNextWordIfExists();
        		}
        	} 
		} catch (Exception ex) {
			System.out.println(ex);							
		}
	}
	
	protected boolean isResultSetClosed() throws SQLException {
		return dbConnector.isResultSetClosed();
	}
	
	protected void createTranslation() {
		enteredText = view.getTranslationOfWordText();	
	}
	
	protected boolean isTranslationCorrected() {					
		if (isTranslationFieldNotEmpty() && isTranslationValid()) {
			return true;
		} 
		
		return false;
	}
	
	protected boolean isTranslationFieldNotEmpty() {
		if (enteredText.equals("")) {
			view.setStatusERR(Constants.FIELDS_ARE_EMPTY_STATUS);
			return false;
		} 
		
		return true;
	}
	
	protected boolean isTranslationValid() {
		return false;
	}
	
	protected void checkTranslationOnEquality() throws SQLException {
		
	}
	
    protected boolean isTranslationEquals(String rightTranslation) {
    	if (enteredText.equals(rightTranslation)) {
    		return true;
    	}
    	
    	return false;
    }
	
	@Override
	protected void setFocus() {
		view.setFocus();
	}

	@Override
	protected void clearFields() {
		view.clearFields();
	}
	
    protected void getNextWordIfExists() throws SQLException {
		
	};
	
	@Override
	protected void setActionsForButtons() {
        view.setOKButtonAction(this);
	}
	
	public void showWindow() {
		try {
			showWordToTranslate();
		} catch (SQLException ex) {
			System.out.println(ex);										
		}
		
		view.showStage();
	}
	
	protected void showWordToTranslate() throws SQLException {
		dbConnector.createSelectQuery(wordStatusColumn, wordStatusValue);
		dbConnector.executeSelectQuery();
		getNextWordIfExists();
	}
	
	protected void updateWordStatus() throws SQLException {
		if (wordStatusValue == 0) {			
			dbConnector.createUpdateQuery(wordStatusColumn, 1);
		} else {
			dbConnector.createUpdateQuery(wordStatusColumn, 0);
		}
		
		dbConnector.executeUpdateQuery();
	}
}