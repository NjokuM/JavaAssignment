package homework;

//all imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class GUI{ //Class that creates the user Interface
	
	private JFrame frame;
	private JPanel panel;
	private JButton SearchButton;
	private JTextField SearchTextField;
	private String userSearch;

	private JScrollPane scrollPane;
	private DefaultListModel<String> listModel;
	

	
	public GUI(){
		
		frame = new JFrame("My Seach Engine");
		panel = new JPanel();
		
		
		SearchButton = new JButton("Search");
		SearchTextField = new JTextField();
		listModel = new DefaultListModel<>();
		JList<String> resultList = new JList<>(listModel);
		scrollPane = new JScrollPane(resultList);
		scrollPane.setPreferredSize(new Dimension(400, 400));
		
		//add all objects
		frame.add(panel);
		panel.add(SearchTextField);
		panel.add(SearchButton);
		panel.add(scrollPane);
		
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30)); //top bottom left right
		
		panel.setLayout(new FlowLayout()); //sets the layout to go line by line
		frame.setPreferredSize(new Dimension(800, 600)); //set frame size
		SearchTextField.setPreferredSize(new Dimension(200, 25)); //set size of text field
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closes the panel when clicking the exit button.
		panel.setBackground(Color.gray);
		
		
		frame.pack();
		frame.setVisible(true); //Displays the panel when set to true.
		
		SearchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				 String userSearch = SearchTextField.getText().trim(); //retrieves user text and eliminates excess whitespace
			        List<String> searchResults = FileSearch.searchFiles(userSearch, "/Users/michaelnjoku/git/JavaAssignment"); //searches for files in that directory

			        listModel.clear(); //clears the scroll pane
			        for (String result : searchResults) {
			            listModel.addElement(result); //adds the results to the Scroll Pane
			        }
			
			}
		});
		
	}


	public String getUserSearch() {
		return userSearch;
	}



	public void setUserSearch(String userSearch) {
		this.userSearch = userSearch;
	}


}

