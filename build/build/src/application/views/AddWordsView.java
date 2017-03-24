package application.views;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import resources.Constants;

// +
public class AddWordsView extends AdditionalWindowView {
	private Label engLabel;
	private TextField engTextField;
	private Label rusLabel;
	private TextField rusTextField;
	
	public AddWordsView(String title) {
		init(title);
	}
	
	@Override
	protected void createObjects() {
		super.createObjects();
		
		engLabel = createLabel(Constants.ENG_WORD_LABEL);
		engTextField = createTextField();
		rusLabel = createLabel(Constants.RUS_WORD_LABEL);
		rusTextField =  createTextField();
		OKButton = createButton(Constants.ADD_BUTTON_TITLE);
	}
	
	@Override
	protected void addObjects() {
		vBox.getChildren().add(engLabel);
		vBox.getChildren().add(engTextField);
		vBox.getChildren().add(rusLabel);
		vBox.getChildren().add(rusTextField);
		
		super.addObjects();
	}

	@Override
	protected void setObjectsMargin() {
		super.setObjectsMargin();
		
        VBox.setMargin(engTextField, new Insets(5, 5, 15, 5));
        VBox.setMargin(rusTextField, new Insets(5, 5, 0, 5));
	}
	
	@Override
    public void setStatusOK() {
		super.setStatusOK();
		statusText.setText(Constants.ADD_STATUS_OK);
    }
	
	public String getEngWord() {
		return  engTextField.getText();
	}

	public String getRusWord() {
		return rusTextField.getText();
	}
	
	public void clearFields() {
		engTextField.clear();
		rusTextField.clear();
	}
	
	public void setFocus() {
		engTextField.requestFocus();
	}
}
