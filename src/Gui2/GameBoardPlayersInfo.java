package Gui2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextArea;

import engine.Player;
import model.world.AntiHero;
import model.world.Hero;

public class GameBoardPlayersInfo extends JTextArea 
{
	MainFrame mainframe;
	public GameBoardPlayersInfo(MainFrame mainframe)
	{
		this.mainframe = mainframe;
		this.setSize(300,250);
		this.setEditable(false);
		this.setBackground(Color.GRAY);
		this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		String x = "First Player :";
		x += "\n" + "Name =>" + mainframe.game.getFirstPlayer().getName();
		x += "\n" + "LeaderAbility used =>"+ "\n" + mainframe.game.isFirstLeaderAbilityUsed();
		x += "\n" + "Second Player :";
		x += "\n" + "Name =>" + mainframe.game.getSecondPlayer().getName();
		x += "\n" + "LeaderAbility used =>" + "\n" +mainframe.game.isSecondLeaderAbilityUsed();
		
		this.setText(x);
	}
	public void update(MainFrame mainframe)
	{
		this.mainframe = mainframe;
		String x = "First Player :";
		x += "\n" + "Name =>" + mainframe.game.getFirstPlayer().getName();
		x += "\n" + "LeaderAbility used =>"+ "\n" + mainframe.game.isFirstLeaderAbilityUsed();
		x += "\n" + "Second Player :";
		x += "\n" + "Name =>" + mainframe.game.getSecondPlayer().getName();
		x += "\n" + "LeaderAbility used =>" + "\n" +mainframe.game.isSecondLeaderAbilityUsed();
		this.setText(x);
	}
}
