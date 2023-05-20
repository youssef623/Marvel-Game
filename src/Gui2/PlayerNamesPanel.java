package Gui2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.Game;
import engine.Player;



public class PlayerNamesPanel extends JPanel  implements ActionListener
{
	String firstPlayername;
	String secondPlayername;
	
	final Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
	ImageIcon intro;
	JLabel background;
	
	JLabel firstPlayerNameLabel = new JLabel("Enter first player name");
	JTextField firstNameField = new JTextField();
	JButton firstPlayerNameSubmit = new JButton("Submit");
	JLabel secondPlayerNameLabel = new JLabel("Enter second player name");
	JTextField secondNameField = new JTextField();
	JButton secondPlayerNameSubmit = new JButton("Submit");
	MainFrame gameview;
	
	public PlayerNamesPanel(MainFrame gameview)
	{
		this.setSize(screenSize.width,screenSize.height);
		this.setLayout(null);
		firstPlayerNameLabel.setBounds(150,150,screenSize.width/2,screenSize.height/2);
		firstPlayerNameLabel.setFont(new Font(null,Font.BOLD,25));
		firstNameField.setBounds(154,450,250,40);
		firstNameField.setFont(new Font(null,Font.BOLD,30));
		firstPlayerNameSubmit.setBounds(200,500 ,125 ,40 );
		firstPlayerNameSubmit.addActionListener(this);
		firstPlayerNameSubmit.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		firstPlayerNameSubmit.setFocusable(false);
		this.add(firstNameField);
		this.add(firstPlayerNameLabel);
		this.add(firstPlayerNameSubmit);
		
		secondPlayerNameLabel.setBounds(1450,150,screenSize.width/2,screenSize.height/2);
		secondPlayerNameLabel.setFont(new Font(null,Font.BOLD,25));
		secondNameField.setBounds(1454,450,250,40);
		secondNameField.setFont(new Font(null,Font.BOLD,30));
		secondPlayerNameSubmit.setBounds(1520,500 ,125 ,40 );
		secondPlayerNameSubmit.addActionListener(this);
		secondPlayerNameSubmit.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		secondPlayerNameSubmit.setFocusable(false);
		this.add(secondNameField);
		this.add(secondPlayerNameLabel);
		this.add(secondPlayerNameSubmit);
		
		
		intro = new ImageIcon("namesimage.jpg");
		background= new JLabel();
		background.setIcon(intro);
		background.setSize(screenSize.width,screenSize.height);
		this.add(background);
		
		this.gameview = gameview;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		 if(e.getSource() == firstPlayerNameSubmit)
			{
			 	if(firstNameField.getText().isBlank())
			 	{
					JOptionPane.showMessageDialog(this, "First Player Should enter his name",
				               "Error", JOptionPane.ERROR_MESSAGE);
			 	}
			 	else
				{
			 		firstNameField.setEditable(false);
			 		firstPlayername = firstNameField.getText();
			 	}
			 	if(!secondNameField.getText().isBlank() && !firstNameField .getText().isBlank())
				{
					gameview.switchToChampionSelectionPanel();
				}
			}
			else if(e.getSource() == secondPlayerNameSubmit)
			{
				if(secondNameField.getText().isBlank())
			 	{
					JOptionPane.showMessageDialog(this, "First Player Should enter his name",
				               "Error", JOptionPane.ERROR_MESSAGE);
			 	}
				else
				{
					secondNameField.setEditable(false);
					secondPlayername = secondNameField.getText();
				}
				if(!secondNameField.getText().isBlank() && !firstNameField .getText().isBlank())
				{
					gameview.switchToChampionSelectionPanel();
				}
			}
	}

}
