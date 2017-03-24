package resources;

import java.util.regex.Pattern;

// +
public class Constants {
	// regexs
	public static final Pattern VALID_ENG_REGEX = 
								Pattern.compile("[A-Za-z]");
	public static final Pattern VALID_RUS_REGEX = 
								Pattern.compile("[А-Яа-я]");

	// paths
	public static final String ICON_PATH = "/resources/icon.jpg";
	public static final String PATH_TO_MAIN_CSS = "resources/main.css";

	// constants
	public static final String CHARACTER_SET = "cp1251";
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String DATABASE_NAME = "lexicondb";
	public static final String TABLE_NAME = "lexicon";
	public static final String EMPTY_URL = "jdbc:mysql://localhost:3306";
    public static final String URL = 
    					"jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    
	// queries
	public static final String CREATE_DATABASE_QUERY = 
			"CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME + 
			" DEFAULT CHARACTER SET " + CHARACTER_SET + ";";
	public static final String CREATE_TABLE_QUERY = 
			"CREATE TABLE IF NOT EXISTS " + DATABASE_NAME + 
			"." + TABLE_NAME + " (ID INT(25) NOT NULL AUTO_INCREMENT, " + 
			"EnglishWord VARCHAR(30) NOT NULL, " + 
			"RussianWord VARCHAR(30) NOT NULL, " +
			"StatusEnglish TINYINT(1) NOT NULL, " + 
			"StatusRussian TINYINT(1) NOT NULL, " + 
			"PRIMARY KEY (ID)) ENGINE = MyISAM " + 
			"DEFAULT CHARACTER SET = cp1251;";
	public static final String USE_DATABASE_QUERY = 
			"USE " + DATABASE_NAME + ";";
	public static final String OPTIMIZE_TABLE_QUERY = 
			"OPTIMIZE TABLE " + TABLE_NAME + ";";
    
	// strings
    public static final String SLOGAN = "Grow your vocabulary.";
    public static final String STATUS_OK = "Right!";		
	public static final String STATUS_ERR = "Wrong! Correct word: ";		
	public static final String FIELDS_ARE_EMPTY_STATUS = 
								"Please, fill empty fields!";
	public static final String INCORRECT_ENGLISH_WORD_STATUS = 
								"Enter the correct english word!";
	public static final String INCORRECT_RUSSIAN_WORD_STATUS = 
								"Enter the correct russian word!";
	public static final String LONG_ENGLISH_WORD_STATUS = 
									"English word is too long!";
	public static final String LONG_RUSSIAN_WORD_STATUS = 
									"Russian word is too long!";
	public static final String ADD_STATUS_OK = 
									"Word was added successfully!";	
	public static final String ADD_STATUS_ERR = 
									"Error! Word was not added!";	
	public static final String DELETE_STATUS_OK = "Word was deleted!";
	public static final String DELETE_STATUS_ERR = 
									"Please, select word to delete!";	
	public static final String TRAINED_ALL_WORDS_STATUS = 
									"ALL WORDS ARE TRAINED!";
	public static final String REPEATED_ALL_WORDS_STATUS = 
									"ALL WORDS ARE REPEATED!";
	
	// titles
	public static final String MAIN_WINDOW_TITLE = "Lexicon UP!";
	public static final String ADD_WORDS_WINDOW_TITLE = 
												"Adding new words";
	public static final String DELETE_WORDS_WINDOW_TITLE = 
												"Deleting words";
	public static final String TRAIN_ENG_RUS_WINDOW_TITLE = 
												"ENG-RUS Training";
	public static final String REPEAT_ENG_RUS_WINDOW_TITLE = 
												"ENG-RUS Repetition";
	public static final String TRAIN_RUS_ENG_WINDOW_TITLE = 
												"RUS-ENG Training";
	public static final String REPEAT_RUS_ENG_WINDOW_TITLE = 
												"RUS-ENG Repetition";
	public static final String ADD_WORDS_BUTTON_TITLE = "ADD WORDS";
	public static final String DELETE_WORDS_BUTTON_TITLE = "DELETE WORDS";
	public static final String TRAIN_ENG_RUS_BUTTON_TITLE = 
													"  TRAIN\nENG-RUS";
	public static final String REPEAT_ENG_RUS_BUTTON_TITLE = 
													" REPEAT\nENG-RUS";
	public static final String TRAIN_RUS_ENG_BUTTON_TITLE = 
													"  TRAIN\nRUS-ENG";
	public static final String REPEAT_RUS_ENG_BUTTON_TITLE = 
													" REPEAT\nRUS-ENG";
	public static final String CHECK_BUTTON_TITLE = "CHECK";
	public static final String ADD_BUTTON_TITLE = "ADD";	
	public static final String DELETE_BUTTON_TITLE = "DELETE";	
	public static final String TABLE_COLUMN_TITLES[] = 
								{"English word", "Russian word", "ID"};
	
	// labels
	public static final String ENG_WORD_LABEL = "English word:";
	public static final String RUS_WORD_LABEL = "Russian word:";
	
	// database fields
	public static final String ID_COLUMN = "ID";
	public static final String ENG_WORD_COLUMN = "EnglishWord";
	public static final String RUS_WORD_COLUMN = "RussianWord";
	public static final String ENG_WORD_STATUS_COLUMN = "StatusEnglish";
	public static final String RUS_WORD_STATUS_COLUMN = "StatusRussian";
}
