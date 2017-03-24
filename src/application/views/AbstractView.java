package application.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import resources.Constants;

// +
public abstract class AbstractView {
	protected BorderPane borderPane;						
    protected Scene scene;
    protected Stage stage;
    protected VBox vBox;
    
	protected void init(String title) {
		createWindow();
	    createStage(title);
	    setStyles();
	}
	
	protected void createWindow() {
		createObjects();
	    addObjects();
	    setPositions();
	    setObjectsMargin();
	}
	
	protected void createStage(String title) {
		stage = new Stage();
		stage.setTitle(title);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.getIcons().add(new Image(
				getClass().getResourceAsStream(Constants.ICON_PATH)));
	}
	
	protected void setStyles() {	
		
	}
	
	protected void createObjects() {
		borderPane = createBorderPane();
	    scene = createScene();
		vBox = createVBox();
	}
	
	protected void addObjects() {

	}
	
	private void setPositions() {
		borderPane.setTop(vBox);
	}
	
	protected void setObjectsMargin() {
		
	}
	
	public void showStage() {
		stage.show();
	}
	
	private BorderPane createBorderPane() {
		return new BorderPane();
	}
	
	protected Scene createScene() {
		return null;
	}
	
	protected Button createButton() {
		return new Button();
	}
	
	protected Button createButton(String textOnButton) {
		return new Button(textOnButton);
	}
	
	protected VBox createVBox() {
		return new VBox();
	}
	
	protected HBox createHBox() {
		return new HBox();
	}
	
	protected Label createLabel(String textOnLabel) {
		return new Label(textOnLabel);
	}
	
	protected TextField createTextField() {
		return new TextField();
	}
	
	protected void setScene(Scene scene) {
		this.scene = scene;
	}
}
