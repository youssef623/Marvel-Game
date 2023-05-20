package Gui2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import engine.Game;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.world.Champion;
import model.world.Direction;

public class GameActionsPanel extends JPanel implements ActionListener
{
	
	
	//fadel castabiltiy int x int y
	final Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
	MainFrame mainframe;
	
	//Directions buttons
	JButton up;
	JButton down;
	JButton right;
	JButton left;
	
	
	//EndTurn button
	JButton endTurn;
	
	//use Leader Ability button
	JButton useLeaderAbility;
	
	//Cast Ability Direction
	JComboBox<String> castAbilityDirection;
	
	//cast ability direction choose box 
	JComboBox<Direction> direction;
	
	//JButton cast ability direction
	JButton castAbilityDirectionButton;
	
	// JButton attack
	JButton attack;
	
	//cast ability direction choose box 
	JComboBox<String> castabilitycombo;
	
	//JButton castability
	JButton castAbilitybutton;
	
	//board
	GameBoardPanel board;
	
	//textarea
	GameBoardPlayersInfo playersInfotext;
	
	//CurrentChampInfo text
	CurrentChampInfo currentChampInfo;
	
	//JButton cast ability single target
	JButton castAbilitySingleTarget;
	public GameActionsPanel(MainFrame mainframe)
	{
		
		this.mainframe = mainframe;
		board = new GameBoardPanel(mainframe);
		this.setSize(screenSize.width,screenSize.height);
		this.setLayout(null);
		this.add(board);
		
		//firsttext.setBounds(1050, 0,300 , 400);
		playersInfotext = new GameBoardPlayersInfo(mainframe);
		playersInfotext.setBounds(1605, 0, 300, 250);
		this.add(playersInfotext);
		
		currentChampInfo = new CurrentChampInfo(mainframe);
		currentChampInfo.setBounds(1050, 0, 400, 800);
		this.add(currentChampInfo);
		
		//Direction Buttons
		up = new JButton("UP");
		down = new JButton("Down");
		right = new JButton("Right");
		left = new JButton("Left");
		
		up.setBounds(300, 720, 100, 100);
		up.addActionListener(this);
		up.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		up.setFocusable(false);
		this.add(up);
		
		down.setBounds(300, 920, 100, 100);
		down.addActionListener(this);
		down.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		down.setFocusable(false);
		this.add(down);
		
		right.setBounds(400, 820, 100, 100);
		right.addActionListener(this);
		right.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		right.setFocusable(false);
		this.add(right);
		
		left.setBounds(200, 820, 100, 100);
		left.addActionListener(this);
		left.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		left.setFocusable(false);
		this.add(left);
		
		//end turn button
		endTurn = new JButton("End Turn");
		
		endTurn.setBounds(1800, 950, 100, 100);
		endTurn.addActionListener(this);
		endTurn.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		endTurn.setFocusable(false);
		this.add(endTurn);
		
		//use leader ability button
		useLeaderAbility = new JButton("use Leader Ability");
		
		useLeaderAbility.setBounds(600,820,200,100);
		useLeaderAbility.addActionListener(this);
		useLeaderAbility.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		useLeaderAbility.setFocusable(false);
		this.add(useLeaderAbility);
		
		//castAbilityDirection Combo box
		castAbilityDirection = new JComboBox<String>();
		
		updateCastAbilityDirectionCombobox(castAbilityDirection);
		castAbilityDirection.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
		castAbilityDirection.setBounds(900,820,150,100);
		castAbilityDirection.addActionListener(this);
		castAbilityDirection.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		castAbilityDirection.setFocusable(false);
		this.add(castAbilityDirection);
		
		//direction combo box
		direction =  new JComboBox<Direction>();
		
		direction.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
		direction.addItem(Direction.UP);
		direction.addItem(Direction.DOWN);
		direction.addItem(Direction.LEFT);
		direction.addItem(Direction.RIGHT);
		direction.setBounds(1100,820,100,100);
		direction.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		direction.setFocusable(false);
		this.add(direction);
		
		//castAbilityDirectionButton
		castAbilityDirectionButton = new JButton("cast Ability Direction");
		
		castAbilityDirectionButton.setBounds(1250,820,150,100);
		castAbilityDirectionButton.addActionListener(this);
		castAbilityDirectionButton.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		castAbilityDirectionButton.setFocusable(false);
		this.add(castAbilityDirectionButton);
		
		//attack button
		attack = new JButton("attack");
		
		attack.setBounds(1450,820,100,100);
		attack.addActionListener(this);
		attack.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		attack.setFocusable(false);
		this.add(attack);
		
		//cast ability JCombo box
		castabilitycombo = new JComboBox<String>();
		
		updateCastAbility(castabilitycombo);
		castabilitycombo.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
		castabilitycombo.setBounds(1600,820,150,100);
		castabilitycombo.addActionListener(this);
		castabilitycombo.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		castabilitycombo.setFocusable(false);
		this.add(castabilitycombo);
		
		//cast ability button
		castAbilitybutton = new JButton("cast Ability");
		
		castAbilitybutton.setBounds(1800,820,100,100);
		castAbilitybutton.addActionListener(this);
		castAbilitybutton.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		castAbilitybutton.setFocusable(false);
		this.add(castAbilitybutton);
		
		
		//castability singletarget
		castAbilitySingleTarget = new JButton("cast Ability Single Target");
		
		castAbilitySingleTarget.setBounds(1600,700,300,100);
		castAbilitySingleTarget.addActionListener(this);
		castAbilitySingleTarget.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		castAbilitySingleTarget.setFocusable(false);
		this.add(castAbilitySingleTarget);
	}
	public void checkgameover()
	{
		if(mainframe.game.checkGameOver() !=null)
		{
			mainframe.switchToWiningFrame(mainframe.game.checkGameOver());
		}
	}
	public void updateCastAbilityDirectionCombobox(JComboBox<String> x)
	{
		x.removeAllItems();
		Champion temp = mainframe.game.getCurrentChampion();
		for(int i = 0;i<temp.getAbilities().size();i++)
		{
			if(temp.getAbilities().get(i).getCastArea() == AreaOfEffect.DIRECTIONAL)
			{
				x.addItem(temp.getAbilities().get(i).getName());
			}
		}
	}
	
	public void updateCastAbility(JComboBox<String> x)
	{
		x.removeAllItems();
		Champion temp = mainframe.game.getCurrentChampion();
		for(int i = 0;i<temp.getAbilities().size();i++)
		{
			if(temp.getAbilities().get(i).getCastArea() != AreaOfEffect.DIRECTIONAL && temp.getAbilities().get(i).getCastArea() != AreaOfEffect.SINGLETARGET)
			{
				x.addItem(temp.getAbilities().get(i).getName());
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == up)
		{
			try {
				mainframe.game.move(Direction.UP);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
			board.update(mainframe);
			currentChampInfo.update(mainframe);

		}
		else if(e.getSource() == down)
		{
			try {
				mainframe.game.move(Direction.DOWN);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
			board.update(mainframe);
			currentChampInfo.update(mainframe);

		}
		else if(e.getSource() == right)
		{
			try {
				mainframe.game.move(Direction.RIGHT);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
			board.update(mainframe);
			currentChampInfo.update(mainframe);

		}
		else if(e.getSource() == left)
		{
			try {
				mainframe.game.move(Direction.LEFT);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
			board.update(mainframe);
			currentChampInfo.update(mainframe);

		}
		else if(e.getSource() == endTurn)
		{
			mainframe.game.endTurn();
			updateCastAbilityDirectionCombobox(castAbilityDirection);
			updateCastAbility(castabilitycombo);
			board.update(mainframe);
			currentChampInfo.update(mainframe);
			checkgameover();
		}
		else if(e.getSource() == useLeaderAbility)
		{
			try {
				mainframe.game.useLeaderAbility();
			} catch (LeaderNotCurrentException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (LeaderAbilityAlreadyUsedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
			board.update(mainframe);
			currentChampInfo.update(mainframe);
			playersInfotext.update(mainframe);
			checkgameover();

		}
		else if(e.getSource() == castAbilityDirectionButton)
		{
			String abilityName =(String) castAbilityDirection.getSelectedItem();
			Direction dir = (Direction) ((JComboBox)direction).getSelectedItem();
			
			Ability a = null;
			for(int i = 0;i<mainframe.game.getCurrentChampion().getAbilities().size();i++)
			{
				if(mainframe.game.getCurrentChampion().getAbilities().get(i).getName() == abilityName)
				{
					a = mainframe.game.getCurrentChampion().getAbilities().get(i);
					break;
				}
			}
			try {
				mainframe.game.castAbility(a, dir);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
			board.update(mainframe);
			currentChampInfo.update(mainframe);
			checkgameover();
		}
		else if(e.getSource() == attack)
		{
			Direction dir = (Direction) ((JComboBox)direction).getSelectedItem();
			try {
				mainframe.game.attack(dir);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (ChampionDisarmedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
			board.update(mainframe);
			currentChampInfo.update(mainframe);
			checkgameover();

		}
		else if(e.getSource() == castAbilitybutton)
		{
			String abilityName =(String) castabilitycombo.getSelectedItem();
			Ability a = null;
			for(int i = 0;i<mainframe.game.getCurrentChampion().getAbilities().size();i++)
			{
				if(mainframe.game.getCurrentChampion().getAbilities().get(i).getName() == abilityName)
				{
					a = mainframe.game.getCurrentChampion().getAbilities().get(i);
					break;
				}
			}
			try {
				mainframe.game.castAbility(a);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
			board.update(mainframe);
			currentChampInfo.update(mainframe);
			checkgameover();

		}else if(e.getSource() == castAbilitySingleTarget)
		{
			new CastAbilitySingleTarget(mainframe);
		}
	}
	
}
