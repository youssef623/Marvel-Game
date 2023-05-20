package Gui2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.AntiHero;
import model.world.Hero;

public class CurrentChampInfo extends JTextArea 
{
	MainFrame mainframe;
	public CurrentChampInfo(MainFrame mainframe)
	{
		this.mainframe = mainframe;
		this.setSize(400, 800);
		this.setEditable(false);
		this.setBackground(Color.GRAY);
		this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		String x = "";
		String s ="";
		x += "Current Champion :";
		x += "\n" + "Name => " + mainframe.game.getCurrentChampion().getName();
		if(mainframe.game.getCurrentChampion() instanceof AntiHero)
		{
			x += "\n" + "Type => AntiHero" ;
		}
		else if(mainframe.game.getCurrentChampion() instanceof Hero)
		{
			x += "\n" + "Type => Hero" ;
		}
		else
		{
			x += "\n" + "Type => Villian" ;
		}
		x += "\n" + "CurrentHP => " + mainframe.game.getCurrentChampion().getCurrentHP();
		x += "\n" + "Mana => " + mainframe.game.getCurrentChampion().getMana();
		x += "\n" + "MaxActionPoints => " + mainframe.game.getCurrentChampion().getMaxActionPointsPerTurn();
		x += "\n" + "CurrentActionPoints => " + mainframe.game.getCurrentChampion().getCurrentActionPoints();
		for(int i = 0;i<mainframe.game.getCurrentChampion().getAbilities().size();i++)
		{
			s="";
			x += "\n" + "Ability " + (i+1)+ " : " +  mainframe.game.getCurrentChampion().getAbilities().get(i).getName();
			if(mainframe.game.getCurrentChampion().getAbilities().get(i) instanceof DamagingAbility)
			{
				DamagingAbility temp = ((DamagingAbility)mainframe.game.getCurrentChampion().getAbilities().get(i));
				x += "\n" +"Ability Type : Damaging Ability";
				s += "Damage Amount : " + temp.getDamageAmount();
			}
			else if(mainframe.game.getCurrentChampion().getAbilities().get(i) instanceof HealingAbility)
			{
				HealingAbility temp = ((HealingAbility)mainframe.game.getCurrentChampion().getAbilities().get(i));
				x += "\n" +"Ability Type : Healing Ability";
				s += "Heal Amount : " + temp.getHealAmount();
			}
			else
			{
				CrowdControlAbility temp = ((CrowdControlAbility)mainframe.game.getCurrentChampion().getAbilities().get(i));
				x += "\n" +"Ability Type : CrowdControl Ability";
				s += "Effect Name : " + temp.getEffect().getName();
				s += "\n" + "Effect Duration : " + temp.getEffect().getDuration();
			}
			x += "\n" +"Area of Effect : " + mainframe.game.getCurrentChampion().getAbilities().get(i).getCastArea();
			x += "\n" + "Cast Range : " +mainframe.game.getCurrentChampion().getAbilities().get(i).getCastRange();
			x += "\n" + "Mana : " +mainframe.game.getCurrentChampion().getAbilities().get(i).getManaCost();
			x += "\n" + "Action cost : " +mainframe.game.getCurrentChampion().getAbilities().get(i).getRequiredActionPoints();
			x += "\n" + "BaseCool Down : " +mainframe.game.getCurrentChampion().getAbilities().get(i).getBaseCooldown();
			x += "\n" + "current CoolDown : " +mainframe.game.getCurrentChampion().getAbilities().get(i).getCurrentCooldown();
			x += "\n" + s;
			
			
			
		}
		this.setText(x);
	}
	
	public void update(MainFrame mainframe)
	{
		this.mainframe = mainframe;
		String x = "";
		String s ="";
		x += "Current Champion :";
		x += "\n" + "Name => " + mainframe.game.getCurrentChampion().getName();
		if(mainframe.game.getCurrentChampion() instanceof AntiHero)
		{
			x += "\n" + "Type => AntiHero" ;
		}
		else if(mainframe.game.getCurrentChampion() instanceof Hero)
		{
			x += "\n" + "Type => Hero" ;
		}
		else
		{
			x += "\n" + "Type => Villian" ;
		}
		x += "\n" + "CurrentHP => " + mainframe.game.getCurrentChampion().getCurrentHP();
		x += "\n" + "Mana => " + mainframe.game.getCurrentChampion().getMana();
		x += "\n" + "MaxActionPoints => " + mainframe.game.getCurrentChampion().getMaxActionPointsPerTurn();
		x += "\n" + "CurrentActionPoints => " + mainframe.game.getCurrentChampion().getCurrentActionPoints();
		for(int i = 0;i<mainframe.game.getCurrentChampion().getAbilities().size();i++)
		{
			s="";
			x += "\n" + "Ability " + (i+1)+ " : " +  mainframe.game.getCurrentChampion().getAbilities().get(i).getName();
			if(mainframe.game.getCurrentChampion().getAbilities().get(i) instanceof DamagingAbility)
			{
				DamagingAbility temp = ((DamagingAbility)mainframe.game.getCurrentChampion().getAbilities().get(i));
				x += "\n" +"Ability Type : Damaging Ability";
				s += "Damage Amount" + temp.getDamageAmount();
			}
			else if(mainframe.game.getCurrentChampion().getAbilities().get(i) instanceof HealingAbility)
			{
				HealingAbility temp = ((HealingAbility)mainframe.game.getCurrentChampion().getAbilities().get(i));
				x += "\n" +"Ability Type : Healing Ability";
				s += "Heal Amount : " + temp.getHealAmount();
			}
			else
			{
				CrowdControlAbility temp = ((CrowdControlAbility)mainframe.game.getCurrentChampion().getAbilities().get(i));
				x += "\n" +"Ability Type : CrowdControl Ability";
				s += "Effect Name : " + temp.getEffect().getName();
				s += "\n" + "Effect Duration : " + temp.getEffect().getDuration();
			}
			x += "\n" +"Area of Effect : " + mainframe.game.getCurrentChampion().getAbilities().get(i).getCastArea();
			x += "\n" + "Cast Range : " +mainframe.game.getCurrentChampion().getAbilities().get(i).getCastRange();
			x += "\n" + "Mana : " +mainframe.game.getCurrentChampion().getAbilities().get(i).getManaCost();
			x += "\n" + "Action cost : " +mainframe.game.getCurrentChampion().getAbilities().get(i).getRequiredActionPoints();
			x += "\n" + "BaseCool Down : " +mainframe.game.getCurrentChampion().getAbilities().get(i).getBaseCooldown();
			x += "\n" + "current CoolDown : " +mainframe.game.getCurrentChampion().getAbilities().get(i).getCurrentCooldown();
			x += "\n" + s;
			
			
			
		}
		this.setText(x);
	}
}
