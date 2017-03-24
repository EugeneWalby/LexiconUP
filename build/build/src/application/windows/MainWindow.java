package application.windows;

import application.handlers.EventHandlerClass;
import application.views.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import resources.Constants;

// +
public class MainWindow extends EventHandlerClass {
	private MainView view;
	
	public MainWindow() {
		init();
	}

	@Override
	protected void createView() {
		view = new MainView(Constants.MAIN_WINDOW_TITLE);
	}
	
	@Override
	protected void setActionsForButtons() {
		setAddWordsButtonAction();
		setDeleteWordsButtonAction();
		setTrainEngRusButtonAction();
		setRepeatEngRusButtonAction();
		setTrainRusEngButtonAction();
		setRepeatRusEngButtonAction();
	}
	
	private void setAddWordsButtonAction() {												
		view.setAddWordsButtonAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	openAddWordsWindow();
            }
		});
	}

	private void setDeleteWordsButtonAction() {												
		view.setDeleteWordsButtonAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
				openDeleteWordsWindow();
            }
		});
	}
	
	private void setTrainEngRusButtonAction() {
		view.setTrainEngRusButtonAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               openTrainEngRusWindow();
            }
		});
	}
	
	private void setRepeatEngRusButtonAction() {
		view.setRepeatEngRusButtonAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	openRepeatEngRusWindow();
            }
		});
	}
	
	private void setTrainRusEngButtonAction() {
		view.setTrainRusEngButtonAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               openTrainRusEngWindow();
            }
		});
	}
	
	private void setRepeatRusEngButtonAction() {
		view.setRepeatRusEngButtonAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               openRepeatRusEngWindow();
            }
		});
	}
	
	private void openAddWordsWindow() {
		AddWordsWindow window = new AddWordsWindow();
		window.showWindow();
	}
	
	private void openDeleteWordsWindow() {        
		DeleteWordsWindow window = new DeleteWordsWindow();
		window.showWindow();
	}
	
	private void openTrainEngRusWindow() {
		TrainingGeneralWindow window = new TrainEngRusWindow();	
		window.showWindow();
	}
	
	private void openRepeatEngRusWindow() {		
		TrainingGeneralWindow window = new RepeatEngRusWindow();
		window.showWindow();
	}
	
	private void openTrainRusEngWindow() {			
		TrainingGeneralWindow window = new TrainRusEngWindow();		
		window.showWindow();
	}
	
	private void openRepeatRusEngWindow() {	
		TrainingGeneralWindow window = new RepeatRusEngWindow();
		window.showWindow();
	}
	
	public void showWindow() {
		view.showStage();
	}
}