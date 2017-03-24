package application.windows;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import resources.Constants;

// +
public class TrainRusEngWindow extends TrainingGeneralWindow {
	
	public TrainRusEngWindow() {
		init();
	}
	
	@Override
	protected void init() {
		super.init();
	}
	
	@Override
	protected void createWindowParameters() {
		windowTitle = Constants.TRAIN_RUS_ENG_WINDOW_TITLE;
		wordStatusColumn = Constants.RUS_WORD_STATUS_COLUMN;
		wordStatusValue = 0;
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
			updateWordStatus();
			view.setStatusOK();
		} else {
			view.setStatusERR(Constants.STATUS_ERR);
		}
	}
	
	@Override
	protected void getNextWordIfExists() throws SQLException {
		if (dbConnector.nextElement()) {									
			view.setWordToTranslateText(dbConnector.getRussianWord());
		} else {
			view.setWordToTranslateText(Constants.TRAINED_ALL_WORDS_STATUS);
			dbConnector.getResultSet().close();
		}
	};
}
