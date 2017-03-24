package application.windows;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import resources.Constants;

// +
public class RepeatRusEngWindow extends TrainingGeneralWindow {
	
	public RepeatRusEngWindow() {
		init();
	}
	
	@Override
	protected void init() {
		super.init();
	}
	
	@Override
	protected void createWindowParameters() {
		windowTitle = Constants.REPEAT_RUS_ENG_WINDOW_TITLE;
		wordStatusColumn = Constants.RUS_WORD_STATUS_COLUMN;
		wordStatusValue = 1;
	}
	
	@Override
	public void handle(ActionEvent event) {
        super.handle(event);
	}
	
	@Override
	protected boolean isTranslationValid() {
		if (!isEnglishWordValid(enteredText)) {
			view.setStatusERR(Constants.INCORRECT_ENGLISH_WORD_STATUS);
			return false;
		} 
		
		return true;
	}
	
	@Override
	protected void checkTranslationOnEquality() throws SQLException {
		if (isTranslationEquals(dbConnector.getEnglishWord())) {
		    view.setStatusOK();
		} else {
			updateWordStatus();
			view.setStatusERR(Constants.STATUS_ERR 
								+ dbConnector.getEnglishWord());
		}
	}
	
	@Override
	protected void getNextWordIfExists() throws SQLException {
		if (dbConnector.nextElement()) {									
			view.setWordToTranslateText(dbConnector.getRussianWord());
		} else {
			view.setWordToTranslateText(Constants.REPEATED_ALL_WORDS_STATUS);
			dbConnector.getResultSet().close();
		}
	};
}
