package application.windows;

import java.sql.SQLException;
import application.handlers.EventHandlerClass;
import application.views.DeleteWordsView;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import resources.Constants;

// +-
public class DeleteWordsWindow extends EventHandlerClass {
	private DeleteWordsView view;
	@SuppressWarnings("rawtypes")
	private ObservableList<ObservableList> data;
		
	public DeleteWordsWindow() {
		init();
	}
	
	@Override
	protected void init() {
		super.init();
		createObservableList();
		buildData();
	}

	@Override
	protected void createView() {
		view = new DeleteWordsView(Constants.DELETE_WORDS_WINDOW_TITLE);
	}
	
	private void createObservableList() {
		data = FXCollections.observableArrayList();
	}
	
	public void buildData() {
        try {
        	executeSelectQuery();
      		createRows();
      		addRowsToObservableList();
      		setTableItems();
        } catch(Exception e){
        	System.out.println(e);
        }
    }

	private void executeSelectQuery() throws SQLException {
		dbConnector.createSelectQuery();
		dbConnector.executeSelectQuery();
	}

	private void createRows() throws SQLException {
		for(int i = 0 ; i < dbConnector.getColumnCount(); i++) {
			final int j = i;                
			createColumn(i);
			createColumnData(j);
			addColumn();
			hideIdColumn(i);
		}
	}

	private void addRowsToObservableList() throws SQLException {
		dbConnector.getResultSet().beforeFirst();
		
		while(dbConnector.nextElement()) {
			ObservableList<String> row = addColumnToRow();
			data.add(row);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void setTableItems() {
		view.getTableView().setItems(data);
	}
	
	private void createColumn(int i) throws SQLException {
		if (i == 3) {
			i = 0;
		}
		
		view.createColumn(Constants.TABLE_COLUMN_TITLES[i]);
	}
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void createColumnData(int index) {
    	view.getColumn().setCellValueFactory(
    		new Callback<CellDataFeatures<ObservableList, String>,
    									ObservableValue<String>>(){                   
			
    			public ObservableValue<String> call(
    				CellDataFeatures<ObservableList, String> param) {                                                                                            
    				
    				String paramValue = 
    						param.getValue().get(index).toString();
    				
    				return new SimpleStringProperty(paramValue);                       
    			}                    
    	});
    }

	private void addColumn() {
		view.addColumn();
	}
    
	private void hideIdColumn(int i) throws SQLException {
		if (i == getMaxColumnIndex()) {
			view.getColumn().setVisible(false);
		}
	}

	private ObservableList<String> addColumnToRow() throws SQLException {
		ObservableList<String> row = FXCollections.observableArrayList();
		for(int i = 1 ; i <= dbConnector.getColumnCount(); i++){
			row.add(dbConnector.getDatabaseString(i));
		}
		
		return row;
	}
    
	private int getMaxColumnIndex() throws SQLException {
		return dbConnector.getColumnCount() - 1;
	}
	
	@Override
	public void handle(ActionEvent event) {
        try {
        	executeDeleteQuery();
		} catch (Exception ex) {
			System.out.println(ex);												
		}
	}
	
	private void executeDeleteQuery() throws SQLException {
		if (view.deleteFromTable()) {
			dbConnector.createDeleteQuery(view.getSelectedID());		
			dbConnector.executeDeleteQuery();
			view.setStatusOK();
		} else {
			view.setStatusERR(Constants.DELETE_STATUS_ERR);
		}		
	};
	
	@Override
	protected void setActionsForButtons() {	
		view.setOKButtonAction(this);
	}
	
	public void showWindow() {
		view.showStage();
	}
}
