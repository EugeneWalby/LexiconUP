package application.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import resources.Constants;

// +
public class TrainingGeneralView extends AdditionalWindowView {
	private Label wordToTranslate;					
	private TextField translationOfWord;

	public TrainingGeneralView(String title) {
		init(title);
	}
	
	@Override
	protected void createObjects() {
		super.createObjects();
		
		wordToTranslate = createLabel("");
		translationOfWord = createTextField();
		OKButton = createButton(Constants.CHECK_BUTTON_TITLE);
	}
	
	@Override
	protected void addObjects() {
		vBox.getChildren().add(wordToTranslate);
		vBox.getChildren().add(translationOfWord);
		
		super.addObjects();
	}
	
	@Override
	protected void setObjectsMargin() {
		super.setObjectsMargin();
		
        VBox.setMargin(wordToTranslate, new Insets(10, 0, 10, 0));
        VBox.setMargin(translationOfWord, new Insets(10, 50, 5, 50));
	}
	
	@Override
	protected void setStyles() {
		super.setStyles();
		borderPane.setId("training_root");
		wordToTranslate.setId("training_word_to_translate");
	}
	
	@Override
	protected Scene createScene() {							
		Scene scene = new Scene(borderPane);
		scene.getStylesheets().add(Constants.PATH_TO_MAIN_CSS);	
		
		return scene;
	}
	
	@Override
    public void setStatusOK() {
    	super.setStatusOK();
    	statusText.setText(Constants.STATUS_OK);
    }
	
    public String getTranslationOfWordText() {
		return translationOfWord.getText();
	}
    
	public void setWordToTranslateText(String text) {
		wordToTranslate.setText(text);
	}
	
	public void clearFields() {
		translationOfWord.clear();
	}
	
	public void setFocus() {
		translationOfWord.requestFocus();
	}
}
