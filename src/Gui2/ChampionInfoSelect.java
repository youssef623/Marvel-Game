package Gui2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.Game;
import model.world.Champion;

public class ChampionInfoSelect extends JFrame implements ActionListener
{
	JPanel buttons;
	JButton setAsLeader;
	JButton selectChampion;
	JTextArea area;
	MainFrame gameview;
	int count;
	String championName;
	ChampionSelectionPanel championselectionpanel;
	ChampionSelectionTextArea firstPlayerTextArea;
	ChampionSelectionTextArea secondPlayerTextArea;
	final Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();

	
	public ChampionInfoSelect(String x,int count,MainFrame gameview,ChampionSelectionPanel championselectionpanel,ChampionSelectionTextArea firstPlayerTextArea,ChampionSelectionTextArea secondPlayerTextArea) throws IOException 
	{
		this.gameview = gameview;
		this.firstPlayerTextArea = firstPlayerTextArea;
		this.secondPlayerTextArea = secondPlayerTextArea;
		championName = x;
		this.gameview = gameview;
		this.count = count;
		this.championselectionpanel = championselectionpanel;
		setTitle(x);
		
		setBounds(500, 300, 800, 600);
		this.setVisible(true);
		
		buttons = new JPanel();
		buttons.setLayout(null);
		add(buttons, BorderLayout.CENTER);
		
		
		setAsLeader = new JButton("setAsLeader");
		setAsLeader.setBounds(100,400,200,40);
		setAsLeader.addActionListener(this);
		setAsLeader.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		setAsLeader.setFocusable(false);
		buttons.add(setAsLeader);
		
		selectChampion = new JButton("Select Champion");
		selectChampion.setBounds(100,200,200,40);
		selectChampion.addActionListener(this);
		selectChampion.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		selectChampion.setFocusable(false);
		buttons.add(selectChampion);
		this.add(buttons);
		
		
		
		area = new JTextArea();
		area.setPreferredSize(new Dimension(400,getHeight()));
		area.setEditable(false);
		area.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
		add(area, BorderLayout.EAST);
		
		this.setResizable(false);
		BufferedReader br = new BufferedReader(new FileReader("Champions.csv"));
		String line = br.readLine();
		while (line != null) 
		{
			String[] content = line.split(",");
			if(content[1].equals(x))
			{
				String champ = "Type : " + content[0] + "\n";
				champ += "name : " + content[1] + "\n";
				champ += "maxHP : " + content[2] + "\n";
				champ += "mana : " + content[3] + "\n";
				champ += "actions : " + content[4] + "\n";
				champ += "speed : " + content[5] + "\n";
				champ += "attackRange : " + content[6] + "\n";
				champ += "attackDamage : " + content[7] + "\n";
				champ += "ability1 name : " + content[8] + "\n";
				champ += "ability2 name : " + content[9] + "\n";
				champ += "ability3 name : " + content[10] + "\n";
				area.setText(champ);
			}
			line = br.readLine();
		}
		
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == selectChampion)
		{
			if(count < 3)
			{
				if(count == 2)
				{
					if(gameview.first.getLeader()==null)
					{
						JOptionPane.showMessageDialog(this, "First Player should select Leader",
					               "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				for(int i =0;i< Game.getAvailableChampions().size();i++)
				{
					if(championName == Game.getAvailableChampions().get(i).getName())
					{
						Champion o = Game.getAvailableChampions().get(i);
						gameview.first.getTeam().add(o);
					}
				}
				if(count == 0)
					firstPlayerTextArea.updatetext("First Champion =>"+"\n" + championName);
				else if(count == 1)
					firstPlayerTextArea.updatetext("Second Champion =>"+"\n" + championName);
				else if(count == 2)
					firstPlayerTextArea.updatetext("Third Champion =>"+"\n" + championName);
			}
			else if(count < 6)
			{
				if(count == 5)
				{
					if(gameview.second.getLeader()==null)
					{
						JOptionPane.showMessageDialog(this, "Second Player should select Leader",
					               "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				for(int i =0;i< Game.getAvailableChampions().size();i++)
				{
					if(championName == Game.getAvailableChampions().get(i).getName())
					{
						Champion o = Game.getAvailableChampions().get(i);
						gameview.second.getTeam().add(o);
					}
				}
				if(count == 3)
					secondPlayerTextArea.updatetext("First Champion =>"+"\n" + championName);
				else if(count == 4)
					secondPlayerTextArea.updatetext("Second Champion =>"+"\n" + championName);
				else if(count == 5)
					secondPlayerTextArea.updatetext("Third Champion =>"+"\n" + championName);
			}
			championselectionpanel.updateCount();
			championselectionpanel.removebutton(championName);
			if(count==5)
			{
				gameview.switchToGamePanel();
			}
			this.dispose();
			
		}
		else if(e.getSource() == setAsLeader)
		{
			if(count < 3)
			{
				if(gameview.first.getLeader()==null)
				{
					for(int i =0;i< Game.getAvailableChampions().size();i++)
					{
						if(championName == Game.getAvailableChampions().get(i).getName())
						{
							Champion o = Game.getAvailableChampions().get(i);
							gameview.first.getTeam().add(o);
							gameview.first.setLeader(o);
						}
					}
					firstPlayerTextArea.updatetextLeader(championName);
					championselectionpanel.updateCount();
					championselectionpanel.removebutton(championName);
					this.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Leader Already set",
				               "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(count <6)
			{
				if(gameview.second.getLeader()==null)
				{
					for(int i =0;i< Game.getAvailableChampions().size();i++)
					{
						if(championName == Game.getAvailableChampions().get(i).getName())
						{
							Champion o = Game.getAvailableChampions().get(i);
							gameview.second.getTeam().add(o);
							gameview.second.setLeader(o);
						}
					}
					secondPlayerTextArea.updatetextLeader(championName);
					championselectionpanel.updateCount();
					championselectionpanel.removebutton(championName);
					this.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Leader Already set",
				               "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			if(count==5)
			{
				gameview.switchToGamePanel();
			}
		}
		
	}
	
	
	
}
