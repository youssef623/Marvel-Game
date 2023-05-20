package Gui2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import model.world.Champion;

public class infoAboutItem extends JFrame
{//still cover info
	JTextArea area;
	MainFrame gameview;
	public infoAboutItem(String s,MainFrame gameview)
	{
		this.gameview = gameview;
		setBounds(500, 300, 800, 600);
		this.setVisible(true);
		area = new JTextArea();
		area.setPreferredSize(new Dimension(this.getWidth(),getHeight()));
		area.setEditable(false);
		area.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
		
		if(!s.equals("Cover"))
		{

			Champion champ = null;
			for(int i = 0;i<gameview.game.getFirstPlayer().getTeam().size();i++)
			{
				if(gameview.game.getFirstPlayer().getTeam().get(i).getName().equals(s))
				{
					champ = gameview.game.getFirstPlayer().getTeam().get(i);
					break;
				}
			}
			if(champ == null)
			{
				for(int i = 0;i<gameview.game.getSecondPlayer().getTeam().size();i++)
				{
					if(gameview.game.getSecondPlayer().getTeam().get(i).getName().equals(s))
					{
						champ = gameview.game.getSecondPlayer().getTeam().get(i);
						break;
					}
				}
			}
			if(champ!= null)
			{this.setTitle(champ.getName());
			String x = "Name =>" + champ.getName();
			x+= "\n" + "Current HP => " + champ.getCurrentHP();
			x+= "\n" + "Max HP => " + champ.getMaxHP();
			x+= "\n" + "mana => " + champ.getMana();
			x+= "\n" + "speed => " + champ.getSpeed();
			x+= "\n" + "max actions per turn => " + champ.getMaxActionPointsPerTurn();
			x+= "\n" + "current actions per turn => " + champ.getCurrentActionPoints();

			x+= "\n" + "Attack Damage => " + champ.getAttackDamage();
			x+= "\n" + "Attack Range => " + champ.getAttackRange();
			x+= "\n" + champ.getLocation().x;
			x+= "\n" + champ.getLocation().y;
			for(int i=0;i<champ.getAppliedEffects().size();i++)
			{
				x+= "\n" + "Effect Name => " + champ.getAppliedEffects().get(i).getName(); 
				x+= "\n" + "Effect Duration => " + champ.getAppliedEffects().get(i).getDuration(); 
			}
			area.setText(x);
		}}
		add(area);
		this.revalidate();
		this.repaint();
	}
}
