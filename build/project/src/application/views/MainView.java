package application.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import resources.Constants;

// +
public class MainView extends AbstractView {
	private HBox hBox;
	private VBox vBoxLeft;
	private VBox vBoxRight;
	private Label titleLabel;
	private Label sloganLabel;
	private Button trainEngRusButton;
    private Button repeatEngRusButton;
    private Button trainRusEngButton;
    private Button repeatRusEngButton;
    private Button addWordsButton;
    private Button deleteWordsButton;
    
    public MainView(String title) {
    	init(title);
    }
    
    @Override
	protected void createObjects() {
		super.createObjects();
		
		hBox = createHBox();
		vBoxLeft = createVBox();
		vBoxRight = createVBox();
		titleLabel = createLabel(Constants.MAIN_WINDOW_TITLE);
		sloganLabel = createLabel(Constants.SLOGAN);
		trainEngRusButton = 
				createButton(Constants.TRAIN_ENG_RUS_BUTTON_TITLE);
		repeatEngRusButton = 
				createButton(Constants.REPEAT_ENG_RUS_BUTTON_TITLE);
		trainRusEngButton = 
				createButton(Constants.TRAIN_RUS_ENG_BUTTON_TITLE);
		repeatRusEngButton = 
				createButton(Constants.REPEAT_RUS_ENG_BUTTON_TITLE);
		addWordsButton = 
				createButton(Constants.ADD_WORDS_BUTTON_TITLE);
		deleteWordsButton = 
				createButton(Constants.DELETE_WORDS_BUTTON_TITLE);
	}
	
	@Override
	protected void addObjects() {
		super.addObjects();
		
		vBox.getChildren().add(titleLabel);
		vBox.getChildren().add(sloganLabel);
		vBox.getChildren().add(hBox);
		hBox.getChildren().add(vBoxLeft);
		hBox.getChildren().add(vBoxRight);
		vBoxLeft.getChildren().add(trainEngRusButton);
		vBoxLeft.getChildren().add(repeatEngRusButton);
		vBoxLeft.getChildren().add(addWordsButton);
		vBoxRight.getChildren().add(trainRusEngButton);
		vBoxRight.getChildren().add(repeatRusEngButton);
		vBoxRight.getChildren().add(deleteWordsButton);
	}
	
	@Override
	protected Scene createScene() {
		Scene scene = new Scene(borderPane);
		scene.getStylesheets().add(Constants.PATH_TO_MAIN_CSS);		
		
		return scene;
	}

	@Override
	protected void setStyles() {	
		borderPane.setId("main_root");
		titleLabel.setId("main_label_title");
		sloganLabel.setId("main_label_slogan");
		addWordsButton.setId("main_button_add_delete");
		deleteWordsButton.setId("main_button_add_delete");
	}
	
	public void setAddWordsButtonAction(
			EventHandler<ActionEvent> eventHandler) {
		
		addWordsButton.setOnAction(eventHandler);
	}
	
	public void setDeleteWordsButtonAction(
			EventHandler<ActionEvent> eventHandler) {			
		
		deleteWordsButton.setOnAction(eventHandler);
	}

	public void setTrainEngRusButtonAction(
			EventHandler<ActionEvent> eventHandler) {
		
		trainEngRusButton.setOnAction(eventHandler);
	}

	public void setRepeatEngRusButtonAction(
			EventHandler<ActionEvent> eventHandler) {
		
		repeatEngRusButton.setOnAction(eventHandler);
	}
	
	public void setTrainRusEngButtonAction(
			EventHandler<ActionEvent> eventHandler) {
		
		trainRusEngButton.setOnAction(eventHandler);
	}

	public void setRepeatRusEngButtonAction(
			EventHandler<ActionEvent> eventHandler) {
		
		repeatRusEngButton.setOnAction(eventHandler);
	}
}
