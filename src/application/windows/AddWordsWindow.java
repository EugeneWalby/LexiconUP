package application.windows;

import java.sql.SQLException;
import application.handlers.EventHandlerClass;
import application.views.AddWordsView;
import javafx.event.ActionEvent;
import resources.Constants;

// +
public class AddWordsWindow extends EventHandlerClass {
	private AddWordsView view;

	public AddWordsWindow() {
		init();
	}
	
	@Override
	protected void createView() {
		view = new AddWordsView(Constants.ADD_WORDS_WINDOW_TITLE);
	}
	
	@Override
	public void handle(ActionEvent event) {
        try {
        	executeInsertQuery();
		} catch (Exception ex) {
			System.out.println(ex);											
		}
	}

	private void executeInsertQuery() throws SQLException {
		if (isWordsValid() && !isWordsTooLong()) {
			dbConnector.createInsertQuery(getEngWord(), getRusWord());
			if (dbConnector.executeInsertQuery()) {
				view.setStatusOK();
			} else {
				view.setStatusERR(Constants.ADD_STATUS_ERR);
			}
			refreshFields();
		}
	}

	protected boolean isWordsValid() {
		if(!isEnglishWordValid(getEngWord())) {
    		view.setStatusERR(Constants.INCORRECT_ENGLISH_WORD_STATUS);
    	} else if (!isRussianWordValid(getRusWord())) {
			view.setStatusERR(Constants.INCORRECT_RUSSIAN_WORD_STATUS);
		} else {
			return true;
		}
		
		return false;
	}
	
	protected boolean isWordsTooLong() {
		if (getEngWord().length() > 25) {
			view.setStatusERR(Constants.LONG_ENGLISH_WORD_STATUS);
		} else if (getRusWord().length() > 25) {
			view.setStatusERR(Constants.LONG_RUSSIAN_WORD_STATUS);
		} else {
			return false;
		}
		
		return true;
	}
	
	@Override
	protected void setActionsForButtons() {
		view.setOKButtonAction(this);
	}

	@Override
	protected void setFocus() {
		view.setFocus();
	}

	@Override
	protected void clearFields() {
		view.clearFields();
	}
	
	public void showWindow() {
		view.showStage();
	}
	
	private String getRusWord() {
		return view.getRusWord().toLowerCase();
	}

	private String getEngWord() {
		return view.getEngWord().toLowerCase();
	};
}
