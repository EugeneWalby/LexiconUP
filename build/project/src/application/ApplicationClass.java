package application;

import application.windows.MainWindow;
import javafx.stage.Stage;
import javafx.application.Application;

// classes hierarchy -
// screenshots -
// instructions readme -
// Well done!

// + 
public class ApplicationClass extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		createWindow();
	}

	private void createWindow() {
		MainWindow mainWindow = new MainWindow();
		mainWindow.showWindow();
	}	
}