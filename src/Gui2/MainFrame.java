package Gui2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import engine.Game;
import engine.Player;

public class MainFrame extends JFrame
{
	Game game;
	final Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
	PlayerNamesPanel playerNamePanel;
	
	String firstPlayerName;
	String secondPlayerName;
	Player first;
	Player second;
	StartGamePanel startGamePanel;
	
	ChampionSelectionPanel championSelectionPanel;
	ChampionSelectionTextArea firstPlayerArea;
	ChampionSelectionTextArea secondPlayerArea;
	
	GameActionsPanel gamepanel;
	
	WinningPanel winningpanel;
	public MainFrame()
	{
	    startGamePanel = new StartGamePanel(this);
	    
	    this.getContentPane().add(startGamePanel);
		this.setTitle("Marvel");
		this.setSize(screenSize.width,screenSize.height);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.repaint();
		this.revalidate();
	}
	
	public void switchToPlayernamesPanel()
	{
		this.getContentPane().remove(startGamePanel);
		playerNamePanel = new PlayerNamesPanel(this);
		this.getContentPane().add(playerNamePanel);
		this.revalidate();
		this.repaint();
	}
	public void switchToChampionSelectionPanel()
	{
		first = new Player(playerNamePanel.firstPlayername);
		second = new Player(playerNamePanel.secondPlayername);
		game = new Game(first,second);
		this.getContentPane().remove(playerNamePanel);
		try 
		{
			Game.loadAbilities("Abilities.csv");
			Game.loadChampions("Champions.csv");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		firstPlayerArea = new ChampionSelectionTextArea("First Player");
		secondPlayerArea = new ChampionSelectionTextArea("Second Player");
		championSelectionPanel = new ChampionSelectionPanel(this,Game.getAvailableChampions(),firstPlayerArea,secondPlayerArea);
		this.getContentPane().add(championSelectionPanel,BorderLayout.CENTER);
		this.getContentPane().add(firstPlayerArea,BorderLayout.WEST);
		this.getContentPane().add(secondPlayerArea,BorderLayout.EAST);
		this.revalidate();
		this.repaint();
	}
	
	public void switchToGamePanel()
	{
		game = new Game(first,second);
		this.getContentPane().remove(championSelectionPanel);
		this.getContentPane().remove(firstPlayerArea);
		this.getContentPane().remove(secondPlayerArea);
		gamepanel = new GameActionsPanel(this);
		this.getContentPane().add(gamepanel);
		this.revalidate();
		this.repaint();

	}
	public void switchToWiningFrame(Player player)
	{
		this.getContentPane().remove(gamepanel);
		winningpanel = new WinningPanel(player);
		this.add(winningpanel);
	}
	public static void main(String[] args)
	{
		new MainFrame();
	}
}
