//The application displays a virtual keyboard and allow users to watch what he or she is typing on the screen
//without looking at the actual keyboard.The application uses swing. As the user presses each key, the application highlights the corresponding 
//JButton on the GUI and adds the character to a JTextArea that shows what the user has typed so far.
//In addition, the user uses mouse click the virtual keys on the screen, the corresponding buttons highlight and the
//JTextArea shows what the users clicked on the virtual keyboard.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;


public class TypingTutor extends JFrame{
	private KeyBoardsPanel canvas = new KeyBoardsPanel();
	public TypingTutor() {
		this.add(canvas);
	}

	public static void main(String[] args) {		
		JFrame frame = new TypingTutor();
		frame.setTitle("Typing Tutor");
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class KeyBoardsPanel extends JPanel implements KeyListener, MouseListener, ActionListener{
	private JLabel info;
	private JTextArea text;
	//set J Panel t0 for adding JLabel info and JTextArea text
	private JPanel t0;	
	//set JPanel p0 for adding buttons
	private JPanel p0;
	private String firstRow[] = {"~","1","2","3","4","5","6","7","8","9","0","-","+"};
	private String firstRowShift[] = {"`", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "="};
	private String secondRow[] = {"Q","W","E","R","T","Y","U","I","O","P","[","]","\\"};
	private String thirdRow[] = {"A","S","D","F","G","H","J","K","L",":","\""};
	private String fourthRow[] = {"Z","X","C","V","B","N","M",",",".","?"};
	//set all buttons
	private JButton[] first = new JButton[firstRow.length];	
	private JButton[] second = new JButton[secondRow.length];
	private JButton[] third = new JButton[thirdRow.length];
	private JButton[] forth = new JButton[fourthRow.length];
	private JButton btBackspace = new JButton("Backspace");
	private JButton btTab = new JButton("Tab");
	private JButton btCaps = new JButton("Caps");
	private JButton btEnter = new JButton("Enter");
	private JButton btShift = new JButton("Shift");	
	private JButton btUp = new JButton("^");
	private JButton btSpace = new JButton();
	private JButton btLeft = new JButton("<");
	private JButton btDown = new JButton("˅");
	private JButton btRight = new JButton(">");
	private boolean isClick = false;

	public KeyBoardsPanel(){
		t0 = new JPanel(new BorderLayout());
		t0.setPreferredSize(new Dimension(780, 260));
		t0.add(getInfo(),BorderLayout.NORTH);
		t0.add(textSpace(),BorderLayout.SOUTH);

		p0 =new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
		p0.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));	
		p0.setPreferredSize(new Dimension(780, 260));
		p0.add(firstRowBts());
		p0.add(secondRowBts());
		p0.add(thirdRowBts());
		p0.add(forthRowBts());
		p0.add(fifthRowBts());	
		
		this.add(t0, BorderLayout.NORTH);
		this.add(p0, BorderLayout.SOUTH);
	}	
	//keyboard first row design
	public JPanel firstRowBts() {				
		JPanel p1 = new JPanel(new GridLayout(1, firstRow.length));
		for(int i = 0; i < firstRow.length; i++) {
			JButton bt = new JButton(firstRow[i]);
			bt.setPreferredSize(new Dimension(50, 50));
			first[i] = bt;	
			first[i].addMouseListener(this);
			first[i].addActionListener(this);
			p1.add(first[i]);
			
		}
		JPanel p1_fixed = new JPanel (new BorderLayout());		
		btBackspace.setPreferredSize(new Dimension(100, 50));
		btBackspace.addMouseListener(this);
		btBackspace.addActionListener(this);
		p1_fixed.add(p1, BorderLayout.WEST);
		p1_fixed.add(btBackspace, BorderLayout.EAST);
		return p1_fixed;
	}
	//keyboard second row design
	public JPanel secondRowBts() {		
		JPanel p2 = new JPanel(new GridLayout(1, secondRow.length));		
		for(int i = 0; i < secondRow.length; i++) {
			JButton bt = new JButton(secondRow[i]);
			bt.setPreferredSize(new Dimension(50, 50));
			second[i] = bt;
			second[i].addMouseListener(this);
			second[i].addActionListener(this);
			p2.add(second[i]);
		}
		JPanel p2_fixed = new JPanel(new BorderLayout());		
		btTab.setPreferredSize(new Dimension(75, 50));
		btTab.addMouseListener(this);
		btTab.addActionListener(this);
		p2_fixed.add(btTab, BorderLayout.WEST);
		p2_fixed.add(p2, BorderLayout.EAST);
		return p2_fixed;
	}
	//keyboard third row design
	public JPanel thirdRowBts() {		
		JPanel p3 = new JPanel(new GridLayout(1, thirdRow.length));		
		for(int i = 0; i < thirdRow.length; i++) {
			JButton bt = new JButton(thirdRow[i]);
			bt.setPreferredSize(new Dimension(50, 50));
			third[i] = bt;
			third[i].addMouseListener(this);
			third[i].addActionListener(this);
			p3.add(third[i]);
		}
		JPanel p3_fixed = new JPanel(new BorderLayout());		
		btCaps.setPreferredSize(new Dimension(75, 50));
		btCaps.addMouseListener(this);
		btCaps.addActionListener(this);
		btEnter.setPreferredSize(new Dimension(100, 50));
		btEnter.addMouseListener(this);
		btEnter.addActionListener(this);
		p3_fixed.add(btCaps, BorderLayout.WEST);
		p3_fixed.add(p3, BorderLayout.CENTER);
		p3_fixed.add(btEnter, BorderLayout.EAST);
		return p3_fixed;
	}
	//keyboard fourth row design
	public JPanel forthRowBts() {		
		JPanel p4 = new JPanel(new GridLayout(1, fourthRow.length));		
		for(int i = 0; i < fourthRow.length; i++) {
			JButton bt = new JButton(fourthRow[i]);
			bt.setPreferredSize(new Dimension(50, 50));
			forth[i] = bt;
			forth[i].addMouseListener(this);
			forth[i].addActionListener(this);
			p4.add(forth[i]);
		}			
		btShift.setPreferredSize(new Dimension(100, 50));
		btShift.addMouseListener(this);
		JPanel p4_fix1 = new JPanel(new BorderLayout());	
		p4_fix1.add(btShift, BorderLayout.WEST);
		p4_fix1.add(p4,BorderLayout.EAST);		
		btUp.setPreferredSize(new Dimension(50, 50));
		btUp.addMouseListener(this);
		btUp.addActionListener(this);
		JPanel p4_fixed = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));	
		p4_fixed.add(p4_fix1);
		p4_fixed.add(Box.createRigidArea(new Dimension(25, 0)));
		p4_fixed.add(btUp);	
		return p4_fixed;
	}
	//keyboard fifth row design
	public JPanel fifthRowBts() {
		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));		
		btSpace.setPreferredSize(new Dimension(320, 50));
		btSpace.addMouseListener(this);
		btSpace.addActionListener(this);
		btLeft.setPreferredSize(new Dimension(50, 50));	
		btLeft.addMouseListener(this);
		btLeft.addActionListener(this);
		btDown.setPreferredSize(new Dimension(50, 50));	
		btDown.addMouseListener(this);
		btDown.addActionListener(this);
		btRight.setPreferredSize(new Dimension(50, 50));
		btRight.addMouseListener(this);
		btRight.addActionListener(this);
		p5.add(Box.createRigidArea(new Dimension(190, 0)));
		p5.add(btSpace);
		p5.add(Box.createRigidArea(new Dimension(65, 0)));
		p5.add(btLeft);
		p5.add(btDown);
		p5.add(btRight);
		return p5;
	}

	//above label design
	public JPanel getInfo() {
		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
		info = new JLabel("<html><body><br>Type some text using your keyboard.The keys you press will be highlighted and text will be displayed."
				+ "<br>Note : Clicking the buttons with your mouse will not perform any action.</body></html>");
		labelPanel.add(info);
		return labelPanel;
	}
	//JTextArea design
	public JPanel textSpace() {
		text = new JTextArea();
		text.setPreferredSize(new Dimension(750, 200));	
		text.setLineWrap(true);
		text.requestFocusInWindow();
		text.addKeyListener(this);
		JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));	

		textPanel.add(text);
		return textPanel;
	}	


//implement KeyListener to process KeyEvent
	// when key pressed the responding button on the virtual keyboard highlights
	@Override
	public void keyPressed(KeyEvent ke) {	

		if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			btBackspace.setBackground(Color.BLUE);			
		}else if(ke.getKeyCode() == KeyEvent.VK_TAB) {
			btTab.setBackground(Color.BLUE);
		}else if(ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
			isClick = !isClick;
			if(isClick) {
				btCaps.setBackground(Color.BLUE); 
			}else {
				btCaps.setBackground(null) ;
			}
			
		}
		else if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
			btEnter.setBackground(Color.BLUE);
		}else if(ke.getKeyCode() == KeyEvent.VK_SHIFT) {
			btShift.setBackground(Color.BLUE);
		}else if(ke.getKeyCode() == KeyEvent.VK_UP) {
			btUp.setBackground(Color.BLUE);
		}else if(ke.getKeyCode() == KeyEvent.VK_SPACE) {
			btSpace.setBackground(Color.BLUE);
		}else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
			btLeft.setBackground(Color.BLUE);
		}else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
			btDown.setBackground(Color.BLUE);
		}else if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			btRight.setBackground(Color.BLUE);
		}else if(String.valueOf(ke.getKeyChar()).equals("{")){
			second[10].setBackground(Color.BLUE);
		}else if(String.valueOf(ke.getKeyChar()).equals("}")){
			second[11].setBackground(Color.BLUE);
		}else if(String.valueOf(ke.getKeyChar()).equals("|")){
			second[12].setBackground(Color.BLUE);
		}else if(String.valueOf(ke.getKeyChar()).equals(";")){
			third[9].setBackground(Color.BLUE);
		}else if(String.valueOf(ke.getKeyChar()).equals("'")){
			third[10].setBackground(Color.BLUE);
		}else if(String.valueOf(ke.getKeyChar()).equals("<")){
			forth[7].setBackground(Color.BLUE);
		}else if(String.valueOf(ke.getKeyChar()).equals(">")){
			forth[8].setBackground(Color.BLUE);
		}else if(String.valueOf(ke.getKeyChar()).equals("/")){
			forth[9].setBackground(Color.BLUE);
		}else{				
			for (int i = 0; i < firstRow.length; i++) {
				if(String.valueOf(ke.getKeyChar()).equals(first[i].getText())||String.valueOf(ke.getKeyChar()).equals(firstRowShift[i])) {
					first[i].setBackground(Color.BLUE);
					break;
				}
			}
			for(int i = 0; i < secondRow.length; i++) {
				if(String.valueOf(ke.getKeyChar()).toUpperCase().equals(second[i].getText())) {
					second[i].setBackground(Color.BLUE);
					break;
				}
			}
			for(int i = 0; i < thirdRow.length; i++) {
				if(String.valueOf(ke.getKeyChar()).toUpperCase().equals(third[i].getText())) {
					third[i].setBackground(Color.BLUE);	
					break;
				}
			}
			for(int i = 0; i < fourthRow.length; i++) {
				if(String.valueOf(ke.getKeyChar()).toUpperCase().equals(forth[i].getText())) {
					forth[i].setBackground(Color.BLUE);	
					break;
				}
			}
		}
	}
	// when key pressed the responding button on the virtual keyboard rests to default background color
	@Override
	public void keyReleased(KeyEvent ke) {
		if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			btBackspace.setBackground(null);
		}else if(ke.getKeyCode() == KeyEvent.VK_TAB) {
			btTab.setBackground(null);
		}else if(ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
			
			if(isClick) {
				btCaps.setBackground(Color.BLUE); 
			}else {
				btCaps.setBackground(null) ;
			}
		}
		else if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
			btEnter.setBackground(null);
		}else if(ke.getKeyCode() == KeyEvent.VK_SHIFT) {
			btShift.setBackground(null);
		}else if(ke.getKeyCode() == KeyEvent.VK_UP) {
			btUp.setBackground(null);
		}else if(ke.getKeyCode() == KeyEvent.VK_SPACE) {
			btSpace.setBackground(null);
		}else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
			btLeft.setBackground(null);
		}else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
			btDown.setBackground(null);
		}else if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			btRight.setBackground(null);
		}else if(String.valueOf(ke.getKeyChar()).equals("{")){
			second[10].setBackground(null);
		}else if(String.valueOf(ke.getKeyChar()).equals("}")){
			second[11].setBackground(null);
		}else if(String.valueOf(ke.getKeyChar()).equals("|")){
			second[12].setBackground(null);
		}else if(String.valueOf(ke.getKeyChar()).equals(";")){
			third[9].setBackground(null);
		}else if(String.valueOf(ke.getKeyChar()).equals("'")){
			third[10].setBackground(null);
		}else if(String.valueOf(ke.getKeyChar()).equals("<")){
			forth[7].setBackground(null);
		}else if(String.valueOf(ke.getKeyChar()).equals(">")){
			forth[8].setBackground(null);
		}else if(String.valueOf(ke.getKeyChar()).equals("/")){
			forth[9].setBackground(null);
		}else {
			for (int i = 0; i < firstRow.length; i++) {
				if(String.valueOf(ke.getKeyChar()).equals(first[i].getText())||String.valueOf(ke.getKeyChar()).equals(firstRowShift[i])) {
					first[i].setBackground(null);
					break;
				}
			}
			for(int i = 0; i < secondRow.length; i++) {
				if(String.valueOf(ke.getKeyChar()).toUpperCase().equals(second[i].getText())) {
					second[i].setBackground(null);
					break;
				}
			}
			for(int i = 0; i < thirdRow.length; i++) {
				if(String.valueOf(ke.getKeyChar()).toUpperCase().equals(third[i].getText())) {
					third[i].setBackground(null);	
					break;
				}
			}
			for(int i = 0; i < fourthRow.length; i++) {
				if(String.valueOf(ke.getKeyChar()).toUpperCase().equals(forth[i].getText())) {
					forth[i].setBackground(null);	
					break;
				}
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent ke) {
	}
//implement MouseListner to process MouseEvent
	@Override
	public void mouseClicked(MouseEvent e) {	
		
	}
	//when mouse enter the responding button highlights
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == btBackspace) {
			btBackspace.setBackground(Color.BLUE);
		}else if(e.getSource() == btTab) {
			btTab.setBackground(Color.BLUE);
		}else if(e.getSource() == btCaps) {
			btCaps.setBackground(Color.BLUE);	
		}else if(e.getSource() == btEnter) {
			btEnter.setBackground(Color.BLUE);
		}else if(e.getSource() == btShift) {
			btShift.setBackground(Color.BLUE);
		}else if(e.getSource() == btUp) {
			btUp.setBackground(Color.BLUE);
		}else if(e.getSource() == btSpace) {
			btSpace.setBackground(Color.BLUE);
		}else if(e.getSource() == btLeft) {
			btLeft.setBackground(Color.BLUE);
		}else if(e.getSource() == btDown) {
			btDown.setBackground(Color.BLUE);
		}else if(e.getSource() == btRight) {
			btRight.setBackground(Color.BLUE);
		}else {
			for (int i = 0; i < firstRow.length; i++) {
				if(e.getSource() == first[i]) {
					first[i].setBackground(Color.BLUE);
					break;
				}
			}
			for (int i = 0; i < secondRow.length; i++) {
				if(e.getSource() == second[i]) {
					second[i].setBackground(Color.BLUE);
					break;
				}
			}
			for (int i = 0; i < thirdRow.length; i++) {
				if(e.getSource() == third[i]) {
					third[i].setBackground(Color.BLUE);
					break;
				}
			}
			for (int i = 0; i < fourthRow.length; i++) {
				if(e.getSource() == forth[i]) {
					forth[i].setBackground(Color.BLUE);
					break;
				}
			}
		}
		
	}
	//when mouse exit the responding button reset to default background color
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == btBackspace) {
			btBackspace.setBackground(null);
		}else if(e.getSource() == btTab) {
			btTab.setBackground(null);
		}else if(e.getSource() == btCaps) {
			if(isClick) {
				btCaps.setBackground(Color.BLUE); 
			}else {
				btCaps.setBackground(null) ;
			}
		}else if(e.getSource() == btEnter) {
			btEnter.setBackground(null);
		}else if(e.getSource() == btShift) {
			btShift.setBackground(null);
		}else if(e.getSource() == btUp) {
			btUp.setBackground(null);
		}else if(e.getSource() == btSpace) {
			btSpace.setBackground(null);
		}else if(e.getSource() == btLeft) {
			btLeft.setBackground(null);
		}else if(e.getSource() == btDown) {
			btDown.setBackground(null);
		}else if(e.getSource() == btRight) {
			btRight.setBackground(null);
		}else {
			for (int i = 0; i < firstRow.length; i++) {
				if(e.getSource() == first[i]) {
					first[i].setBackground(null);
					break;
				}
			}
			for (int i = 0; i < secondRow.length; i++) {
				if(e.getSource() == second[i]) {
					second[i].setBackground(null);
					break;
				}
			}
			for (int i = 0; i < thirdRow.length; i++) {
				if(e.getSource() == third[i]) {
					third[i].setBackground(null);
					break;
				}
			}
			for (int i = 0; i < fourthRow.length; i++) {
				if(e.getSource() == forth[i]) {
					forth[i].setBackground(null);
					break;
				}
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {

	}
	@Override
	public void mouseReleased(MouseEvent e) {

	}
	
	//implement ActionListner to process ActionEvent
	//when click the button on the virtual keyboard, it functions the same as the keyboard does.
	@Override
	public void actionPerformed(ActionEvent e) {
		text.getCaret().setVisible(true);
			if(((JButton)e.getSource()).getText().equals("Backspace")) {
				if(text.getCaretPosition() > 0) {
					int l = text.getText().length() - text.getCaretPosition();
					text.setText(text.getText().substring(0, text.getCaretPosition() - 1) + 
					(text.getText().substring(text.getCaretPosition(), text.getText().length())));
					text.setCaretPosition(text.getCaretPosition() - l);
				}else {
					text.setCaretPosition(0);
				}
				text.requestFocusInWindow();
		}else if(String.valueOf(((JButton)e.getSource()).getText()).equals("Tab")) {
			for(int i = 0; i < text.getTabSize(); i++) {
				text.insert(" ", text.getCaretPosition());
			}
			text.requestFocusInWindow();
		}else if(String.valueOf(((JButton)e.getSource()).getText()).equals("Enter")) {
			text.insert("\n", text.getCaretPosition());	
			text.requestFocusInWindow();
		}
		else if(String.valueOf(((JButton)e.getSource()).getText()).equals("")) {
			text.insert(" ", text.getCaretPosition());
			text.requestFocusInWindow();
		}
		else if(String.valueOf(((JButton)e.getSource()).getText()).equals("Caps")){
			isClick = !isClick;	
			if(isClick) {
				btCaps.setBackground(Color.BLUE); 
			}else {
				btCaps.setBackground(null);
			}
			text.requestFocusInWindow();
		}else if(String.valueOf(((JButton)e.getSource()).getText()).equals("˅")) {
			try {
				int lineNum = text.getDocument().getDefaultRootElement().getElementIndex(text.getCaretPosition());
				int start = text.getLineStartOffset(lineNum);
				int end= text.getLineEndOffset(lineNum);
				String lineText = text.getText(start, end - start);
				int lineTextLength = lineText.length();
				
				int posi = text.getCaretPosition();
				Rectangle rec = text.modelToView(posi);
				int rows = rec.y / rec.height + 1;
				int r = text.getLineOfOffset(posi);
				int column = posi - text.getLineStartOffset(r) + 1;
				int charsNumTillCursorLine = text.getLineEndOffset(0);												
				if(rows < text.getLineCount()) {
					for(int i = 1; i < rows; i++) {	
						charsNumTillCursorLine += text.getLineEndOffset(i)-text.getLineEndOffset(i - 1);
					}
					int nextRowCharNum = text.getLineEndOffset(rows)-text.getLineEndOffset(rows - 1);
					if(nextRowCharNum < column) {
						text.setCaretPosition(text.getCaretPosition() + (charsNumTillCursorLine -text.getCaretPosition()) + nextRowCharNum - 1);				
					}else {
						text.setCaretPosition(text.getCaretPosition() + lineTextLength);
					}
				}else {
					text.setCaretPosition(text.getCaretPosition());
				}																
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
			text.requestFocusInWindow();
		}
		else if(String.valueOf(((JButton)e.getSource()).getText()).equals("^")) {
			try {
				int lineNum = text.getDocument().getDefaultRootElement().getElementIndex(text.getCaretPosition()) - 1;
				int lineTextLength = 0;
				if(lineNum >= 0) {
					int start = text.getLineStartOffset(lineNum);
					int end= text.getLineEndOffset(lineNum);
					String lineText = text.getText(start, end - start);
					lineTextLength = lineText.length();
				}else {
					lineTextLength = 0;
				}				
				int posi = text.getCaretPosition();
				Rectangle rec = text.modelToView(posi);
				int rows = rec.y / rec.height + 1;
				int r = text.getLineOfOffset(posi);
				int column = posi - text.getLineStartOffset(r) + 1;				
				int charsNumBeforeCursorLine = text.getLineEndOffset(0);
				
				for(int i = 1; i < rows - 1; i++) {	
					charsNumBeforeCursorLine += text.getLineEndOffset(i)-text.getLineEndOffset(i - 1);
				}							
				if(rows > 1) {					
					if(lineTextLength < column) {
						text.setCaretPosition(charsNumBeforeCursorLine - 1);				
					}else {
						text.setCaretPosition(text.getCaretPosition() - lineTextLength);
					}
				}else{
					text.setCaretPosition(text.getCaretPosition());	
				}																
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
			text.requestFocusInWindow();

		}
		else if(String.valueOf(((JButton)e.getSource()).getText()).equals("<")) {
			if(text.getCaretPosition() > 0) {
				text.setCaretPosition(text.getCaretPosition() - 1);	
			}else {
				text.setCaretPosition(text.getCaretPosition());
			}
			text.requestFocusInWindow();
		}
		else if(String.valueOf(((JButton)e.getSource()).getText()).equals(">")) {
			if(text.getCaretPosition() < text.getText().length()) {
				text.setCaretPosition(text.getCaretPosition() + 1);	
			}else {
				text.setCaretPosition(text.getCaretPosition());
			}
			text.requestFocusInWindow();
		}else {
			if(isClick) {
				text.insert(((JButton)e.getSource()).getText().toUpperCase(), text.getCaretPosition());
			}else {
				text.insert(((JButton)e.getSource()).getText().toLowerCase(), text.getCaretPosition());	
			}
			text.requestFocusInWindow();
		}	
	}

}




