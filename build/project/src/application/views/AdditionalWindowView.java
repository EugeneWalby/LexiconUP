package application.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import resources.Constants;

// +
public abstract class AdditionalWindowView extends AbstractView {
	protected Text statusText;
	protected Button OKButton;
		
	@Override
	protected void init(String title) {
		super.init(title);

		setEventToCloseForm();
	}

	protected void setEventToCloseForm() {
		scene.addEventFilter(KeyEvent.KEY_PRESSED, 
								new EventHandler<KeyEvent>() {
		    @Override
		    public void handle(KeyEvent evt) {
		        if (evt.getCode().equals(KeyCode.ESCAPE)) {
		            stage.close();
		        }
		    }
		});
	}
	
	@Override
	protected void createObjects() {
		super.createObjects();
		statusText = createText();
		OKButton = createButton();
	}
	
	@Override
	protected void addObjects() {
		super.addObjects();

		vBox.getChildren().add(statusText);
		vBox.getChildren().add(OKButton);
	}
	
	@Override
	protected void setObjectsMargin() {
        VBox.setMargin(statusText, new Insets(10, 0, 15, 0));
	}
	
	@Override
	protected void setStyles() {	
		borderPane.setId("additional_root");
		vBox.setId("additional_vbox");
		OKButton.setId("additional_button");
		statusText.setId("status");
	}
	
	public void setStatusOK() {
    	setStatusColor(Color.DARKGREEN);
    }
    
    public void setStatusERR(String status) {
    	setStatusColor(Color.DARKRED);
    	statusText.setText(status);
    }
    
	protected void setStatusColor(Color color) {
		statusText.setFill(color);
	}
	
	public void setOKButtonAction(EventHandler<ActionEvent> actionEvent) {
		OKButton.setDefaultButton(true);
		OKButton.setOnAction(actionEvent);
	}
	
	@Override
	protected Scene createScene() {									
		Scene scene = new Scene(borderPane);
		scene.getStylesheets().add(Constants.PATH_TO_MAIN_CSS);		
		
		return scene;
	}
	
	protected Text createText() {
		return new Text();
	}
	
	public Text getStatusText() {
		return statusText;
	}
	
	public void setStatusText(String statusText) {
		this.statusText.setText(statusText);
	}
}
