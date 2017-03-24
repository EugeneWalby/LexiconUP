package application.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import resources.Constants;

// +
public class DeleteWordsView extends AdditionalWindowView {
    @SuppressWarnings("rawtypes")
	private TableView tableView;
    @SuppressWarnings("rawtypes")
	private TableColumn tableColumn;
	private int selectedID;
	
	public DeleteWordsView(String title) {
		init(title);
	}
	
	@Override
	protected void createObjects() {
		super.createObjects();
		
		tableView = createTableView();
		OKButton = createButton(Constants.DELETE_BUTTON_TITLE);
	}	

	@Override
	protected void addObjects() {
		vBox.getChildren().add(tableView);
		
		super.addObjects();
	}
	
	@Override
	protected void setObjectsMargin() {
		super.setObjectsMargin();
		
		VBox.setMargin(tableView, new Insets(0, 5, 5, 5));		
	}
	
	@Override
	protected void setStyles() {
		super.setStyles();
		borderPane.setId("delete_root");
	}
	
	@Override
    public void setStatusOK() {
    	super.setStatusOK();
    	statusText.setText(Constants.DELETE_STATUS_OK);
    }
	
	@Override
	protected Scene createScene() {											
		Scene scene = new Scene(borderPane);
		scene.getStylesheets().add(Constants.PATH_TO_MAIN_CSS);					
		
		return scene;
	}
	
	public boolean deleteFromTable() {
		int selectedIndex = 
				tableView.getSelectionModel().getSelectedIndex();
		if (selectedIndex != -1) {
			setSelectedID((String)getColumn().getCellData(selectedIndex));
			tableView.getItems().remove(selectedIndex);
			return true;
		} 
		
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	private TableView createTableView() {
		return new TableView();
	}
	
	@SuppressWarnings("rawtypes")
	public void createColumn(String columnName) {
		this.tableColumn = new TableColumn(columnName);
		this.tableColumn.setResizable(false);
	}
	
	@SuppressWarnings("unchecked")
	public void addColumn() {
		tableView.getColumns().addAll(tableColumn);
	}
	
	public int getSelectedID() {
		return selectedID;
	}
	
	public void setSelectedID(String selectedID) {
		this.selectedID = Integer.parseInt(selectedID);
	}

	@SuppressWarnings("rawtypes")
	public TableView getTableView() {
		return tableView;
	}
	
	@SuppressWarnings("rawtypes")
	public void setTableView(TableView tableView) {
		this.tableView = tableView;
	}
	
	@SuppressWarnings("rawtypes")
	public TableColumn getColumn() {
		return tableColumn;
	}
}