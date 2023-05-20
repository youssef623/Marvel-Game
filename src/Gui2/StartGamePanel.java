package Gui2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartGamePanel extends JPanel  implements ActionListener
{
	final Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
	JButton startgame = new JButton("Start Game");
	MainFrame gameview;
	ImageIcon intro;
	JLabel background;

	public StartGamePanel(MainFrame gameview)
	{
		
		this.setSize(screenSize.width,screenSize.height);
		this.setLayout(null);
		startgame.setBounds(910,600,125,40);
		startgame.addActionListener(this);
		startgame.setFocusable(false);
		startgame.setVerticalAlignment(JLabel.CENTER);
		startgame.setHorizontalAlignment(JLabel.CENTER);
		startgame.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		this.add(startgame);
	
		intro = new ImageIcon("intro.png");
		background= new JLabel();
		background.setIcon(intro);
		background.setSize(screenSize.width,screenSize.height);
		this.add(background);
		
		
		this.gameview = gameview;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == startgame)
		{
			gameview.switchToPlayernamesPanel();
		}
	}
	
}
