
//The application displays a virtual keyboard and allow users to watch what he or she is typing on the screen
//without looking at the actual keyboard. The application uses Javafx. As the user presses each key, the application highlights the corresponding 
//Button on the GUI and adds the character to a TextArea that shows what the user has typed so far.
//In addition, the user uses mouse click the virtual keys on the screen, the corresponding buttons highlight and the
//TextArea shows what the users clicked on the virtual keyboard.

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TypingTutorJavaFx extends Application{
	private Keys canvas = new Keys();
	@Override
	public void start(Stage primaryStage) {

		Scene scene = new Scene(canvas, 800, 600);
		primaryStage.setTitle("Typing Tutor");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch();

	}

}

class Keys extends GridPane {
	private TextArea text = new TextArea();
	private Label lb = new Label();
	private GridPane textPane = new GridPane();
	private GridPane keyPane = new GridPane();	
	private String firstRow[] = {"~","1","2","3","4","5","6","7","8","9","0","-","+"};
	private String firstRowShift[] = {"`", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "="};
	private String secondRow[] = {"Q","W","E","R","T","Y","U","I","O","P","[","]","\\"};
	private String thirdRow[] = {"A","S","D","F","G","H","J","K","L",":","\""};
	private String fourthRow[] = {"Z","X","C","V","B","N","M",",",".","?"};
	private String fifthRow[] = {"<","˅",">"};
   // set all buttons
	private Button[] first = new Button[firstRow.length];
	private Button[] second = new Button[secondRow.length];
	private Button[] third = new Button[thirdRow.length];
	private Button[] fourth = new Button[fourthRow.length];
	private Button[] fifth = new Button[fifthRow.length];
	private Button btBackSpace = new Button("Backspace");
	private Button btTab = new Button("Tab");
	private Button btCaps = new Button("Caps");
	private Button btEnter= new Button("Enter");
	private Button btShift = new Button("Shift");
	private Button btUp= new Button("^");
	private Button btSpace= new Button("");
	private boolean isClick = false;
	//firstRow design
	public HBox firstRowBt() {
		HBox hbox1 = new HBox();
		for(int i = 0; i < firstRow.length; i++) {
			Button bt = new Button(firstRow[i]);
			bt.setPrefSize(50, 50);			
			first[i] = bt;
			first[i].setStyle("-fx-background-radius: 0");
			first[i].addEventFilter(javafx.scene.input.MouseEvent.MOUSE_ENTERED, eventHandler1);
			first[i].addEventFilter(javafx.scene.input.MouseEvent.MOUSE_EXITED, eventHandler2);
			first[i].setOnAction(buttonHandler);
			hbox1.getChildren().add(first[i]);
		}

		btBackSpace.setPrefSize(100,  50);
		btBackSpace.setStyle("-fx-background-radius: 0");
		btBackSpace.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_ENTERED, eventHandler1);
		btBackSpace.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_EXITED, eventHandler2);
		btBackSpace.setOnAction(buttonHandler);
		hbox1.getChildren().add(btBackSpace);
		return hbox1;
	}
	//secondRow design
	public HBox secondRowBt() {
		HBox hbox2 = new HBox();		
		btTab.setPrefSize(75,  50);
		btTab.setStyle("-fx-background-radius: 0");
		btTab.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_ENTERED, eventHandler1);
		btTab.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_EXITED, eventHandler2);
		btTab.setOnAction(buttonHandler);
		hbox2.getChildren().add(btTab);
		for(int i = 0; i < secondRow.length; i++) {
			Button bt = new Button(secondRow[i]);
			bt.setPrefSize(50, 50);			
			second[i] = bt;
			second[i].setStyle("-fx-background-radius: 0");
			second[i].addEventFilter(javafx.scene.input.MouseEvent.MOUSE_ENTERED, eventHandler1);
			second[i].addEventFilter(javafx.scene.input.MouseEvent.MOUSE_EXITED, eventHandler2);
			second[i].setOnAction(buttonHandler);
			hbox2.getChildren().add(second[i]);
		}		
		return hbox2;		
	}
	//thirdRow design
	public HBox thirdRowBt() {
		HBox hbox3 = new HBox();
		btCaps.setPrefSize(75,  50);
		btCaps.setStyle("-fx-background-radius: 0" );
		btCaps.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_ENTERED, eventHandler1);
		btCaps.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_EXITED, eventHandler2);
		btCaps.setOnAction(buttonHandler);
		hbox3.getChildren().add(btCaps);
		for(int i = 0; i < thirdRow.length; i++) {
			Button bt = new Button(thirdRow[i]);
			bt.setPrefSize(50, 50);			
			third[i] = bt;
			third[i].setStyle("-fx-background-radius: 0");
			third[i].addEventFilter(javafx.scene.input.MouseEvent.MOUSE_ENTERED, eventHandler1);
			third[i].addEventFilter(javafx.scene.input.MouseEvent.MOUSE_EXITED, eventHandler2);
			third[i].setOnAction(buttonHandler);
			hbox3.getChildren().add(third[i]);
		}		
		btEnter.setPrefSize(100,  50);
		btEnter.setStyle("-fx-background-radius: 0");
		btEnter.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_ENTERED, eventHandler1);
		btEnter.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_EXITED, eventHandler2);
		btEnter.setOnAction(buttonHandler);
		hbox3.getChildren().add(btEnter);
		return hbox3;		
	}
	//fourthRow design
	public HBox fourthRowBt() {
		HBox hbox4 = new HBox();
		btShift.setPrefSize(100,  50);
		btShift.setStyle("-fx-background-radius: 0");
		btShift.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_ENTERED, eventHandler1);
		btShift.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_EXITED, eventHandler2);
		hbox4.getChildren().add(btShift);
		for(int i = 0; i < fourthRow.length; i++) {
			Button bt = new Button(fourthRow[i]);
			bt.setPrefSize(50, 50);			
			fourth[i] = bt;
			fourth[i].setStyle("-fx-background-radius: 0");
			fourth[i].addEventFilter(javafx.scene.input.MouseEvent.MOUSE_ENTERED, eventHandler1);
			fourth[i].addEventFilter(javafx.scene.input.MouseEvent.MOUSE_EXITED, eventHandler2);
			fourth[i].setOnAction(buttonHandler);
			hbox4.getChildren().add(fourth[i]);
		}
		HBox hbox4_fix = new HBox(25);
		btUp.setPrefSize(50,  50);
		btUp.setStyle("-fx-background-radius: 0");
		btUp.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_ENTERED, eventHandler1);
		btUp.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_EXITED, eventHandler2);
		hbox4_fix.getChildren().add(hbox4);
		hbox4_fix.getChildren().add(btUp);
		return hbox4_fix;		
	}
	//fifthRow design
	public HBox fifthRowBt() {
		HBox hbox5 = new HBox();
		hbox5.setPadding(new Insets(0, 0, 0, 65));
		for(int i = 0; i < fifthRow.length; i++) {
			Button bt = new Button(fifthRow[i]);
			bt.setPrefSize(50, 50);			
			fifth[i] = bt;
			fifth[i].setStyle("-fx-background-radius: 0");
			fifth[i].addEventFilter(javafx.scene.input.MouseEvent.MOUSE_ENTERED, eventHandler1);
			fifth[i].addEventFilter(javafx.scene.input.MouseEvent.MOUSE_EXITED, eventHandler2);		
			hbox5.getChildren().add(fifth[i]);
		}
		fifth[0].setOnAction(buttonHandler);
		fifth[2].setOnAction(buttonHandler);
		HBox hbox5_fix = new HBox();
		hbox5_fix.setPadding(new Insets(0, 0, 0, 190));

		btSpace.setPrefSize(320,  50);
		btSpace.setStyle("-fx-background-radius: 0");
		btSpace.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_ENTERED, eventHandler1);
		btSpace.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_EXITED, eventHandler2);
		btSpace.setOnAction(buttonHandler);
		hbox5_fix.getChildren().add(btSpace);
		hbox5_fix.getChildren().add(hbox5);
		return hbox5_fix;		
	}
	//label design
	public Label setLabel() {
		lb = new Label("Type some text using your keyboard.The keys you press will be highlighted and text will be displayed.\n"
				+ "Note : Clicking the buttons with your mouse will not perform any action.");	
		lb.setStyle("-fx-font: normal bold 13px 'cursive'; -fx-text-fill: black;");
		lb.setPadding(new Insets(10, 0, 10, 0));
		return lb;
	}
	//TextArea design, add KeyEvent
	public TextArea setText() {
		text.setPrefSize(750, 200);
		text.setWrapText(true);
		
		text.setOnKeyPressed(e -> {
			switch(e.getCode()) {			
			case BACK_SPACE:
				btBackSpace.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				break;
			case TAB:
				btTab.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				break;
			case ENTER:
				btEnter.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				break;
			case CAPS:
				isClick = !isClick;
				if(isClick) {
					btCaps.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				}else {
					btCaps.setStyle(null);
					btCaps.setStyle("-fx-background-radius: 0");
				}				
				break;
			case SHIFT:
				btShift.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				break;
			case UP:
				btUp.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				break;
			case LEFT:
				fifth[0].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				break;
			case DOWN:
				fifth[1].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				break;
			case RIGHT:
				fifth[2].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				break;
			case SPACE:
				btSpace.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				break;
			case SLASH:
				fourth[9].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				break;
			case SEMICOLON:
				third[9].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				break;
			case QUOTE:
				third[10].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				break;
			default:
				for(int i = 0; i < firstRow.length; i++) {
					if(e.getText().toUpperCase().equals(firstRow[i])||e.getText().equals(firstRowShift[i])) {
						first[i].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
						break;
					}						
				}
				for(int i = 0; i < secondRow.length; i++) {
					if(e.getText().toUpperCase().equals(secondRow[i])) {
						second[i].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
						break;
					}
				}
				for(int i = 0; i < thirdRow.length; i++) {
					if(e.getText().toUpperCase().equals(thirdRow[i])) {
						third[i].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
						break;
					}
				}
				for(int i = 0; i < fourthRow.length; i++) {
					if(e.getText().toUpperCase().equals(fourthRow[i])) {
						fourth[i].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
						break;
					}
				}
			}

		});
		text.setOnKeyReleased(e -> {
			switch(e.getCode()) {
			case BACK_SPACE:
				btBackSpace.setStyle(null);
				btBackSpace.setStyle("-fx-background-radius: 0");
				break;
			case TAB:
				btTab.setStyle(null);
				btTab.setStyle("-fx-background-radius: 0");
				break;
			case ENTER:
				btEnter.setStyle(null);
				btEnter.setStyle("-fx-background-radius: 0");
				break;
			case SHIFT:
				btShift.setStyle(null);
				btShift.setStyle("-fx-background-radius: 0");
				break;
			case UP:
				btUp.setStyle(null);
				btUp.setStyle("-fx-background-radius: 0");
				break;
			case LEFT:
				fifth[0].setStyle(null);
				fifth[0].setStyle("-fx-background-radius: 0");
				break;
			case DOWN:
				fifth[1].setStyle(null);
				fifth[1].setStyle("-fx-background-radius: 0");
				break;
			case RIGHT:
				fifth[2].setStyle(null);
				fifth[2].setStyle("-fx-background-radius: 0");
				break;
			case SPACE:
				btSpace.setStyle(null); 
				btSpace.setStyle("-fx-background-radius: 0");
				break;
			case SLASH:
				fourth[9].setStyle(null); 
				fourth[9].setStyle("-fx-background-radius: 0");
				break;
			case SEMICOLON:
				third[9].setStyle(null); 
				third[9].setStyle("-fx-background-radius: 0");
				break;
			case QUOTE:
				third[10].setStyle(null); 
				third[10].setStyle("-fx-background-radius: 0");
				break;
			default:
				for(int i = 0; i < firstRow.length; i++) {
					if(e.getText().toUpperCase().equals(firstRow[i])||e.getText().equals(firstRowShift[i])) {
						first[i].setStyle(null);
						first[i].setStyle("-fx-background-radius: 0");
						break;
					}
				}
				for(int i = 0; i < secondRow.length; i++) {
					if(e.getText().toUpperCase().equals(secondRow[i])) {
						second[i].setStyle(null);
						second[i].setStyle("-fx-background-radius: 0");
						break;
					}
				}
				for(int i = 0; i < thirdRow.length; i++) {
					if(e.getText().toUpperCase().equals(thirdRow[i])) {
						third[i].setStyle(null);
						third[i].setStyle("-fx-background-radius: 0");
						break;
					}
				}
				for(int i = 0; i < fourthRow.length; i++) {
					if(e.getText().toUpperCase().equals(fourthRow[i])) {
						fourth[i].setStyle(null);
						fourth[i].setStyle("-fx-background-radius: 0");
						break;
					}
				}
			}
		});

		return text;
	}
	//mouseEvent 
	EventHandler<javafx.scene.input.MouseEvent> eventHandler1 = new EventHandler<javafx.scene.input.MouseEvent>() { 
		@Override 
		public void handle(javafx.scene.input.MouseEvent e) { 
			if(e.getSource() == btBackSpace) {
				btBackSpace.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
			}else if(e.getSource() == btTab) {
				btTab.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
			}else if(e.getSource() == btCaps) {
				btCaps.setStyle("-fx-background-color: grey; -fx-background-radius: 0");				
			}else if(e.getSource() == btEnter) {
				btEnter.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
			}else if(e.getSource() == btShift) {
				btShift.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
			}else if(e.getSource() == btSpace) {
				btSpace.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
			}else if(e.getSource() == btUp) {
				btUp.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
			}else {
				for(int i = 0; i < firstRow.length; i++) {
					if(e.getSource() == first[i]) {
						first[i].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
						break;
					}
				}
				for(int i = 0; i < secondRow.length; i++) {
					if(e.getSource() == second[i]) {
						second[i].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
						break;
					}
				}
				for(int i = 0; i < thirdRow.length; i++) {
					if(e.getSource() == third[i]) {
						third[i].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
						break;
					}
				}
				for(int i = 0; i < fourthRow.length; i++) {
					if(e.getSource() == fourth[i]) {
						fourth[i].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
						break;
					}
				}
				for(int i = 0; i < fifthRow.length; i++) {
					if(e.getSource() == fifth[i]) {
						fifth[i].setStyle("-fx-background-color: grey; -fx-background-radius: 0");
						break;
					}
				}
			}
		} 
	}; 
	EventHandler<javafx.scene.input.MouseEvent> eventHandler2 = new EventHandler<javafx.scene.input.MouseEvent>() { 
		@Override 
		public void handle(javafx.scene.input.MouseEvent e) { 
			if(e.getSource() == btBackSpace) {
				btBackSpace.setStyle(null); 
				btBackSpace.setStyle("-fx-background-radius: 0");
			}else if(e.getSource() == btTab) {
				btTab.setStyle(null); 
				btTab.setStyle("-fx-background-radius: 0");
			}else if(e.getSource() == btCaps) {
				if(isClick) {
					btCaps.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				}else {
					btCaps.setStyle(null); 
					btCaps.setStyle("-fx-background-radius: 0");
				}				
			}else if(e.getSource() == btEnter) {
				btEnter.setStyle(null); 
				btEnter.setStyle("-fx-background-radius: 0");
			}else if(e.getSource() == btShift) {
				btShift.setStyle(null); 
				btShift.setStyle("-fx-background-radius: 0");
			}else if(e.getSource() == btSpace) {
				btSpace.setStyle(null); 
				btSpace.setStyle("-fx-background-radius: 0");
			}else if(e.getSource() == btUp) {
				btUp.setStyle(null); 
				btUp.setStyle("-fx-background-radius: 0");
			}else {
				for(int i = 0; i < firstRow.length; i++) {
					if(e.getSource() == first[i]) {
						first[i].setStyle(null); 
						first[i].setStyle("-fx-background-radius: 0");
						break;
					}					
				}
				for(int i = 0; i < secondRow.length; i++) {
					if(e.getSource() == second[i]) {
						second[i].setStyle(null); 
						second[i].setStyle("-fx-background-radius: 0");
						break;
					}					
				}
				for(int i = 0; i < thirdRow.length; i++) {
					if(e.getSource() == third[i]) {
						third[i].setStyle(null); 
						third[i].setStyle("-fx-background-radius: 0");
						break;
					}					
				}
				for(int i = 0; i < fourthRow.length; i++) {
					if(e.getSource() == fourth[i]) {
						fourth[i].setStyle(null); 
						fourth[i].setStyle("-fx-background-radius: 0");
					}					
				}
				for(int i = 0; i < fifthRow.length; i++) {
					if(e.getSource() == fifth[i]) {
						fifth[i].setStyle(null); 
						fifth[i].setStyle("-fx-background-radius: 0");
						break;
					}					
				}
			}
		} 
	};  
	//actionEvent
	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {	    	
			if(e.getSource() == btBackSpace) {
				if(text.getCaretPosition() > 0) {
					int caretPos = text.getCaretPosition();
					text.setText(text.getText().substring(0, caretPos - 1) + 
							(text.getText().substring(caretPos, text.getText().length())));
					text.positionCaret(caretPos- 1);					
				}else {
					text.positionCaret(0);
				}
				text.requestFocus();
			}else if(e.getSource() == btTab) {
				text.replaceSelection("        ");
				text.requestFocus();
			}else if(e.getSource() == btEnter) {
				text.insertText(text.getCaretPosition(), "\n");
				text.requestFocus();
			}else if(e.getSource() == btSpace) {
				text.insertText(text.getCaretPosition(), " ");
				text.requestFocus();
			}else if(e.getSource() == btCaps) {
				isClick = !isClick;	
				if(isClick) {
					btCaps.setStyle("-fx-background-color: grey; -fx-background-radius: 0");
				}else {
					btCaps.setStyle(null); 
					btCaps.setStyle("-fx-background-radius: 0");
				}
				text.requestFocus();
			}else if(e.getSource() == fifth[0]) {
				int caretPos = text.getCaretPosition();
				if(caretPos > 0) {
					text.backward();
				}else {
					text.positionCaret(0);
				}    		
				text.requestFocus();
			}else if(e.getSource() == fifth[2]) {
				int caretPos = text.getCaretPosition();
				if(caretPos < text.getText().length()) {
					text.forward();
				}else {
					text.positionCaret(text.getText().length());
				}
				text.requestFocus();
			}
			else {
				if(isClick) {
					text.insertText(text.getCaretPosition(), ((Button)e.getSource()).getText().toUpperCase());
				}else {
					text.insertText(text.getCaretPosition(), ((Button)e.getSource()).getText().toLowerCase());
				}
				text.requestFocus();
			}	    	
		}
	};

	public Keys(){
		textPane.setPadding(new Insets(20, 0, 0, 20));
		textPane.add(setLabel(), 1,  0);
		textPane.add(setText(), 1, 1);
		keyPane.setPadding(new Insets(20, 0, 0, 20));
		keyPane.add(firstRowBt(), 1, 0);
		keyPane.add(secondRowBt(), 1, 1);
		keyPane.add(thirdRowBt(), 1, 2);
		keyPane.add(fourthRowBt(), 1, 3);
		keyPane.add(fifthRowBt(), 1, 4);
		this.add(textPane, 1, 0);
		this.add(keyPane, 1, 1);

	}





}
