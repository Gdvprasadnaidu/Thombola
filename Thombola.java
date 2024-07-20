import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.*;

class Thombola
{
   public static void main(String [] rk)
   {
   	JFrame board=new JFrame("Thombola");                        
        board.setSize(350,80);                                               
        board.setLocationRelativeTo(null);                                       
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    
	JLabel title= new JLabel("Let's play Thombola"); 			
	JButton st=new JButton("START");			 			
	
	JPanel p=new JPanel();
	board.setBackground(Color.CYAN);
	board.add(p,BorderLayout.SOUTH);
	p.add(st);
	p.add(title);

	st.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e)
		{
			JFrame gameFrame = new JFrame("THOMBOLA");
			gameFrame.setSize(380, 150);
			gameFrame.setLocationRelativeTo(null);
			gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			JPanel hd = new JPanel();
			hd.setLayout(new BoxLayout(hd, BoxLayout.Y_AXIS));
			gameFrame.setBackground(Color.CYAN);
			gameFrame.add(hd, BorderLayout.NORTH);

			JLabel players = new JLabel("SELECT TYPE OF THE PLAYERS");
			hd.add(players);
			String[] arr = { "2 PLAYERS", "3 PLAYERS", "4 PLAYERS" };
			JComboBox<String> jcb = new JComboBox<>(arr);
			hd.add(jcb, BorderLayout.SOUTH);
			
			gameFrame.setVisible(true);


			JPanel options = new JPanel();
			CardLayout ss = new CardLayout();
			options.setLayout(ss);
			gameFrame.add(options);

			gameFrame.setVisible(true);

			JPanel mainpanel = new JPanel();
			CardLayout cl = new CardLayout();
			mainpanel.setLayout(cl);
			gameFrame.add(mainpanel);


			jcb.addActionListener(new ActionListener() 
			{
    			public void actionPerformed(ActionEvent e) 
					{
        				String selected = (String) jcb.getSelectedItem();
       					switch (selected) 
							{
            					case "2 PLAYERS":
    							gameFrame.getContentPane().removeAll(); 
    							gameFrame.setLayout(new BorderLayout());

    
    							JPanel playersPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    							JLabel playersLabel = new JLabel("ENTER THE NAMES");
    							playersPanel.add(playersLabel);
    
    							gameFrame.add(playersPanel, BorderLayout.NORTH);

    
    							JPanel textFieldsPanel = new JPanel(new GridBagLayout());
    							GridBagConstraints gbc = new GridBagConstraints();
    							gbc.insets = new Insets(10, 10, 10, 10);
    							gbc.anchor = GridBagConstraints.WEST;
   								gbc.gridx = 0;
    							gbc.gridy = 0;

    							for (int i = 1; i <= 2; i++) 
									{
        								JTextField textField = new JTextField();
										textField.setColumns(15);
        								JLabel label = new JLabel("Player " + i + ":");
        								gbc.gridy++;
        								textFieldsPanel.add(label, gbc);
        								gbc.gridx++;
									 String defaultName = "Player " + i;
                    						textField.setText(defaultName);
        								textFieldsPanel.add(textField, gbc);
       									gbc.gridx--;
    								}
   								gameFrame.add(textFieldsPanel, BorderLayout.CENTER);
    
    							JButton beginButton = new JButton("Begin");
    							gameFrame.add(beginButton, BorderLayout.SOUTH);
//-------------------------------------------------------------------------------------2 PLAYER MODULE--------------------------------------------------------------------------------------

beginButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("Thombola");
        frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));

        JLabel player1Label = new JLabel("Player 1");
 
        labelPanel.add(player1Label);
        labelPanel.add(Box.createHorizontalGlue());

        mainPanel.add(labelPanel, BorderLayout.NORTH);

JPanel buttonPanel = new JPanel();
buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));


JPanel panel1 = new JPanel(new GridLayout(3, 9));


for (int i = 1; i <= 27; i++) {
    JButton button = new JButton(String.valueOf((int) (Math.random() * 90 + 1)));

 
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            button.setBackground(Color.RED);
        }
    });

    panel1.add(button);
}


JPanel gapPanel = new JPanel();
gapPanel.setLayout(new BoxLayout(gapPanel, BoxLayout.Y_AXIS));

gapPanel.add(Box.createVerticalStrut(20)); 

JLabel player2Label = new JLabel("Player 2");

gapPanel.add(player2Label);

JPanel panel2 = new JPanel(new GridLayout(3, 9));

for (int i = 1; i <= 27; i++) {
    JButton button = new JButton(String.valueOf((int) (Math.random() * 90 + 1)));

    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            button.setBackground(Color.RED);
        }
    });

    panel2.add(button);
}

buttonPanel.add(panel1);
buttonPanel.add(gapPanel);
buttonPanel.add(panel2);

        JPanel rollPanel = new JPanel(new FlowLayout());

        JButton rollButton = new JButton("Roll");
rollButton.addActionListener(new ActionListener() {
    int clickedButtonsPanel1 = 0;
    int clickedButtonsPanel2 = 0; 
    Set<Integer> previousNumbers = new HashSet<>(); // Keep track of previously generated numbers
    
    public void actionPerformed(ActionEvent e) {
        int randomNumber;
        do {
            randomNumber = (int) (Math.random() * 90 + 1);
        } while (previousNumbers.contains(randomNumber));
        
        JOptionPane.showMessageDialog(frame, "The random number is: " + randomNumber);
        
        previousNumbers.add(randomNumber);

        for (Component component : panel1.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (button.getText().equals(String.valueOf(randomNumber))) {
                    button.setBackground(Color.YELLOW);
                    button.removeActionListener(button.getActionListeners()[0]); 
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            button.setBackground(Color.RED);
                            clickedButtonsPanel1++;
                            
                            if (clickedButtonsPanel1 == 27) {
                                JOptionPane.showMessageDialog(frame, "Game Over: PLAYER 1 WIN!");
						frame.dispose();
                            }
                        }
                    });
                }
            }
        }

        for (Component component : panel2.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (button.getText().equals(String.valueOf(randomNumber))) {
                    button.setBackground(Color.YELLOW);
                    button.removeActionListener(button.getActionListeners()[0]); 
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            button.setBackground(Color.RED);
                            clickedButtonsPanel2++;
                            
                            if (clickedButtonsPanel2 == 27) {
                                JOptionPane.showMessageDialog(frame, "Game Over: PLAYER 2 WIN!");
						frame.dispose();
                            }
                        }
                    });
                }
            }
        }
    }
});
     
        rollPanel.add(rollButton);

        
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
mainPanel.add(rollPanel, BorderLayout.SOUTH);

    frame.getContentPane().add(mainPanel);

   
    frame.setVisible(true);
}
});



//-----------------------------------------------------------------------------------------END OF MODULE------------------------------------------------------------------------------------


    							gameFrame.pack();
    							gameFrame.setLocationRelativeTo(null); // Center the frame
    							gameFrame.setVisible(true);

    							break;

                                case "3 PLAYERS":
                                gameFrame.getContentPane().removeAll(); 
    							gameFrame.setLayout(new BorderLayout());

    
   					 			JPanel playersPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
   					 			JLabel playersLabel1 = new JLabel("ENTER THE NAMES");
   					 			playersPanel1.add(playersLabel1);
    
   					 			gameFrame.add(playersPanel1, BorderLayout.NORTH);

  
   					 			JPanel textFieldsPanel1 = new JPanel(new GridBagLayout());
   					 			GridBagConstraints gbc1 = new GridBagConstraints();
  					  			gbc1.insets = new Insets(10, 10, 10, 10);
   					 			gbc1.anchor = GridBagConstraints.WEST;
    							gbc1.gridx = 0;
   					 			gbc1.gridy = 0;

   					 			for (int i = 1; i <= 3; i++) 
								{
     					   			JTextField textField1 = new JTextField();
									textField1.setColumns(20);
     					   			JLabel label1 = new JLabel("Player " + i + ":");
       					 			gbc1.gridy++;
       				 				textFieldsPanel1.add(label1, gbc1);
       				 				gbc1.gridx++;
									 String defaultName = "Player " + i;
                    						textField1.setText(defaultName);
        							gbc1.gridwidth = GridBagConstraints.REMAINDER; 
        							textFieldsPanel1.add(textField1, gbc1);
        							gbc1.gridwidth = 1; 
        							gbc1.gridx--;
    							}
    							gameFrame.add(textFieldsPanel1, BorderLayout.CENTER);

   
    							JButton beginButton1 = new JButton("Begin");
    							gameFrame.add(beginButton1, BorderLayout.SOUTH);


//-------------------------------------------------------------------------------------3 PLAYER MODULE--------------------------------------------------------------------------------------


beginButton1.addActionListener(new ActionListener() 
{
    public void actionPerformed(ActionEvent e) 
	{
        JFrame frame = new JFrame("Thombola");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel player1Label = new JLabel("Player 1");
        JLabel player2Label = new JLabel("Player 2");
        JLabel player3Label = new JLabel("Player 3");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JPanel panel1 = new JPanel(new GridLayout(3, 9));
        for (int i = 1; i <= 27; i++) 
		{
            JButton button = new JButton(String.valueOf((int) (Math.random() * 90 + 1)));
            button.addActionListener(new ActionListener() 
		{
                public void actionPerformed(ActionEvent e) 
			{
                    button.setBackground(Color.RED);
            	}
            });
            panel1.add(button);
        }

        JPanel panel2 = new JPanel(new GridLayout(3, 9));
        for (int i = 1; i <= 27; i++) 
		{
            JButton button = new JButton(String.valueOf((int) (Math.random() * 90 + 1)));
            button.addActionListener(new ActionListener() 
		{
                public void actionPerformed(ActionEvent e) 
			{
                    button.setBackground(Color.RED);
                }
            });
            panel2.add(button);
        }

        JPanel panel3 = new JPanel(new GridLayout(3, 9));
        for (int i = 1; i <= 27; i++) 
		{
            JButton button = new JButton(String.valueOf((int) (Math.random() * 90 + 1)));
            button.addActionListener(new ActionListener() 
		{
                public void actionPerformed(ActionEvent e) 
			{
                    button.setBackground(Color.RED);
                }
            });
            panel3.add(button);
        }


        JPanel player1Panel = new JPanel(new BorderLayout());
        player1Panel.add(panel1, BorderLayout.CENTER);
        player1Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        player1Panel.add(new JLabel("Player 1"), BorderLayout.NORTH);

        JPanel player2Panel = new JPanel(new BorderLayout());
        player2Panel.add(panel2, BorderLayout.CENTER);
        player2Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        player2Panel.add(new JLabel("Player 2"), BorderLayout.NORTH);

        JPanel player3Panel = new JPanel(new BorderLayout());
        player3Panel.add(panel3, BorderLayout.CENTER);
        player3Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        player3Panel.add(new JLabel("Player 3"), BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(player1Panel);
        bottomPanel.add(Box.createHorizontalStrut(20));
        bottomPanel.add(player2Panel);
        bottomPanel.add(Box.createHorizontalStrut(20));
        bottomPanel.add(player3Panel);

	    mainPanel.add(bottomPanel, BorderLayout.CENTER);

    frame.getContentPane().add(mainPanel);
    frame.setVisible(true);


//roll button 

	JPanel rollPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	Set<Integer> numbersSet = new HashSet<Integer>();
	ArrayList<JPanel> panels = new ArrayList<JPanel>();
	panels.add(panel1);
panels.add(panel2);
panels.add(panel3);
JButton rollButton = new JButton("Roll");
rollButton.addActionListener(new ActionListener() 
	{
    public void actionPerformed(ActionEvent e) 
	{
        int number;
        do {
            number = (int) (Math.random() * 90 + 1);
        } while (numbersSet.contains(number));

        numbersSet.add(number);
        JOptionPane.showMessageDialog(null, "The number is " + number);

        for (JPanel panel : panels) 
		{
            Component[] components = panel.getComponents();
            for (Component component : components)
		 {
                if (component instanceof JButton) 
			{
                    JButton button = (JButton) component;
                    if (button.getText().equals(String.valueOf(number))) 
				{
                        button.setBackground(Color.YELLOW);
                    }
                }
            }
        }
        boolean allClicked = true;
        for (JPanel panel : panels) 
		{
            Component[] components = panel.getComponents();
            for (Component component : components) 
		{
                if (component instanceof JButton) 
			{
                    JButton button = (JButton) component;
                    if (!button.getBackground().equals(Color.YELLOW)) 
			{
                        allClicked = false;
                        break;
                    }
                }
            }
            if (!allClicked) 
		{
                break;
            }
        }
        if (allClicked) 
		{
            JOptionPane.showMessageDialog(null, "Game Over");
            frame.dispose();
        }
    }
});




	rollPanel.add(rollButton);

	mainPanel.add(buttonPanel, BorderLayout.CENTER);
	mainPanel.add(rollPanel, BorderLayout.SOUTH);

	frame.setContentPane(mainPanel);
	frame.setVisible(true);
}
});


//-----------------------------------------------------------------------------------------END OF MODULE------------------------------------------------------------------------------------


   					 			gameFrame.pack();
   					 			gameFrame.setLocationRelativeTo(null); 
   					 			gameFrame.setVisible(true);

    							break;
			                
                            
                            case "4 PLAYERS":
                            gameFrame.getContentPane().removeAll();
    						gameFrame.setLayout(new BorderLayout());

    						JPanel playersPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    						JLabel playersLabel2 = new JLabel("ENTER THE NAMES");
    						playersPanel2.add(playersLabel2);
    
    						gameFrame.add(playersPanel2, BorderLayout.NORTH);

    
    						JPanel textFieldsPanel2 = new JPanel(new GridBagLayout());
    						GridBagConstraints gbc2 = new GridBagConstraints();
    						gbc2.insets = new Insets(10, 10, 10, 10);
    						gbc2.anchor = GridBagConstraints.WEST;
    						gbc2.gridx = 0;
    						gbc2.gridy = 0;

    						for (int i = 1; i <= 4; i++) 
							{
        						JTextField textField2 = new JTextField();
								textField2.setColumns(20);
        						JLabel label2 = new JLabel("Player " + i + ":");
        						gbc2.gridy++;
        						textFieldsPanel2.add(label2, gbc2);
        						gbc2.gridx++;
							 String defaultName = "Player " + i;
                    				textField2.setText(defaultName);
        						gbc2.gridwidth = GridBagConstraints.REMAINDER;
        						textFieldsPanel2.add(textField2, gbc2);
        						gbc2.gridwidth = 1; 
        						gbc2.gridx--;
    						}
    						gameFrame.add(textFieldsPanel2, BorderLayout.CENTER);

    						JButton beginButton2 = new JButton("Begin");
    						gameFrame.add(beginButton2, BorderLayout.SOUTH);
//-------------------------------------------------------------------------------------4 PLAYER MODULE--------------------------------------------------------------------------------------
    						beginButton2.addActionListener(new ActionListener() 
{
    public void actionPerformed(ActionEvent e) 
	{
        JFrame frame = new JFrame("Thombola");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel player1Label = new JLabel("Player 1");
        JLabel player2Label = new JLabel("Player 2");
        JLabel player3Label = new JLabel("Player 3");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JPanel panel1 = new JPanel(new GridLayout(3, 9));
        for (int i = 1; i <= 27; i++) 
		{
            JButton button = new JButton(String.valueOf((int) (Math.random() * 90 + 1)));
            button.addActionListener(new ActionListener() 
		{
                public void actionPerformed(ActionEvent e) 
			{
                    button.setBackground(Color.RED);
            	}
            });
            panel1.add(button);
        }

        JPanel panel2 = new JPanel(new GridLayout(3, 9));
        for (int i = 1; i <= 27; i++) 
		{
            JButton button = new JButton(String.valueOf((int) (Math.random() * 90 + 1)));
            button.addActionListener(new ActionListener() 
		{
                public void actionPerformed(ActionEvent e) 
			{
                    button.setBackground(Color.RED);
                }
            });
            panel2.add(button);
        }

        JPanel panel3 = new JPanel(new GridLayout(3, 9));
        for (int i = 1; i <= 27; i++) 
		{
            JButton button = new JButton(String.valueOf((int) (Math.random() * 90 + 1)));
            button.addActionListener(new ActionListener() 
		{
                public void actionPerformed(ActionEvent e) 
			{
                    button.setBackground(Color.RED);
                }
            });
            panel3.add(button);
        }

        JPanel panel4 = new JPanel(new GridLayout(3, 9));
        for (int i = 1; i <= 27; i++) 
		{
            JButton button = new JButton(String.valueOf((int) (Math.random() * 90 + 1)));
            button.addActionListener(new ActionListener() 
		{
                public void actionPerformed(ActionEvent e) 
			{
                    button.setBackground(Color.RED);
                }
            });
            panel4.add(button);
        }
	
		

        JPanel player1Panel = new JPanel(new BorderLayout());
        player1Panel.add(panel1, BorderLayout.CENTER);
        player1Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        player1Panel.add(new JLabel("Player 1"), BorderLayout.NORTH);

        JPanel player2Panel = new JPanel(new BorderLayout());
        player2Panel.add(panel2, BorderLayout.CENTER);
        player2Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        player2Panel.add(new JLabel("Player 2"), BorderLayout.NORTH);

        JPanel player3Panel = new JPanel(new BorderLayout());
        player3Panel.add(panel3, BorderLayout.CENTER);
        player3Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        player3Panel.add(new JLabel("Player 3"), BorderLayout.NORTH);
		
		JPanel player4Panel = new JPanel(new BorderLayout());
        player4Panel.add(panel4, BorderLayout.CENTER);
        player4Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        player4Panel.add(new JLabel("Player 4"), BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(player1Panel);
        bottomPanel.add(Box.createHorizontalStrut(20));
        bottomPanel.add(player2Panel);
        bottomPanel.add(Box.createHorizontalStrut(20));
        bottomPanel.add(player3Panel);
        bottomPanel.add(Box.createHorizontalStrut(20));
        bottomPanel.add(player4Panel);

	    mainPanel.add(bottomPanel, BorderLayout.CENTER);

    frame.getContentPane().add(mainPanel);
    frame.setVisible(true);


//roll button 

	JPanel rollPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	Set<Integer> numbersSet = new HashSet<Integer>();
	ArrayList<JPanel> panels = new ArrayList<JPanel>();
	panels.add(panel1);
panels.add(panel2);
panels.add(panel3);
panels.add(panel4);
JButton rollButton = new JButton("Roll");
rollButton.addActionListener(new ActionListener() 
	{
    public void actionPerformed(ActionEvent e) 
	{
        int number;
        do {
            number = (int) (Math.random() * 90 + 1);
        } while (numbersSet.contains(number));

        numbersSet.add(number);
        JOptionPane.showMessageDialog(null, "The number is " + number);

        for (JPanel panel : panels) 
		{
            Component[] components = panel.getComponents();
            for (Component component : components)
		 {
                if (component instanceof JButton) 
			{
                    JButton button = (JButton) component;
                    if (button.getText().equals(String.valueOf(number))) 
				{
                        button.setBackground(Color.YELLOW);
                    }
                }
            }
        }
        boolean allClicked = true;
        for (JPanel panel : panels) 
		{
            Component[] components = panel.getComponents();
            for (Component component : components) 
		{
                if (component instanceof JButton) 
			{
                    JButton button = (JButton) component;
                    if (!button.getBackground().equals(Color.YELLOW)) 
			{
                        allClicked = false;
                        break;
                    }
                }
            }
            if (!allClicked) 
		{
                break;
            }
        }
        if (allClicked) 
		{
            JOptionPane.showMessageDialog(null, "Game Over");
            frame.dispose();
        }
    }
});




	rollPanel.add(rollButton);

	mainPanel.add(buttonPanel, BorderLayout.CENTER);
	mainPanel.add(rollPanel, BorderLayout.SOUTH);

	frame.setContentPane(mainPanel);
	frame.setVisible(true);
}
});



//-----------------------------------------------------------------------------------------END OF MODULE------------------------------------------------------------------------------------
   							gameFrame.pack();
    						gameFrame.setLocationRelativeTo(null); // Center the frame
    						gameFrame.setVisible(true);

    						break;


                        }
 
                    }
            });


        gameFrame.setVisible(true);

		}
	});

	board.setVisible(true); 
   }
}

