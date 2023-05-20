package Gui2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import exceptions.AbilityUseException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;

public class CastAbilitySingleTarget extends JFrame implements ActionListener{
	
	final Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
	MainFrame mainframe;
	
	JButton zerozero;
	JButton zeroOne;
	JButton zeroTwo;
	JButton zeroThree;
	JButton zeroFour;
	
	JButton oneZero;
	JButton oneOne;
	JButton oneTwo;
	JButton OneThree;
	JButton oneFour;
	
	JButton twoZero;
	JButton twoOne;
	JButton twoTwo;
	JButton twoThree;
	JButton twoFour;
	
	JButton threeZero;
	JButton threeOne;
	JButton threeTwo;
	JButton threeThree;
	JButton threeFour;
	
	JButton fourZero;
	JButton fourOne;
	JButton fourTwo;
	JButton fourThree;
	JButton fourFour;
	
	JComboBox<String> abilities;
	public CastAbilitySingleTarget(MainFrame mainframe)
	{
		this.mainframe = mainframe;
		this.setBounds(500,300,1200, 700);
		this.setResizable(true);
		setTitle("Choose Location");
		this.setVisible(true);
		
		JPanel selectAbility = new JPanel();
		selectAbility.setSize(500,700);
		
		abilities = new JComboBox<String>();
		updateabilties(abilities);
		selectAbility.add(abilities);
		this.add(selectAbility,BorderLayout.EAST);

		
		JPanel buttons = new JPanel();
		buttons.setSize(1050,700);
		buttons.setLayout(new GridLayout(5,5));
		
		zerozero = new JButton("0,0");
		zerozero.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		zerozero.setFocusable(false);
		zerozero.addActionListener(this);
		buttons.add(zerozero);
		
		zeroOne = new JButton("0,1");
		zeroOne.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		zeroOne.setFocusable(false);
		zeroOne.addActionListener(this);
		buttons.add(zeroOne);
		
		zeroTwo = new JButton("0,2");
		zeroTwo.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		zeroTwo.setFocusable(false);
		zeroTwo.addActionListener(this);
		buttons.add(zeroTwo);
		
		zeroThree = new JButton("0,3");
		zeroThree.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		zeroThree.setFocusable(false);
		zeroThree.addActionListener(this);
		buttons.add(zeroThree);
		
		
		zeroFour = new JButton("0,4");
		zeroFour.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		zeroFour.setFocusable(false);
		zeroFour.addActionListener(this);
		buttons.add(zeroFour);
		
		oneZero = new JButton("1,0");
		oneZero.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		oneZero.setFocusable(false);
		oneZero.addActionListener(this);
		buttons.add(oneZero);
		
		oneOne = new JButton("1,1");
		oneOne.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		oneOne.setFocusable(false);
		oneOne.addActionListener(this);
		buttons.add(oneOne);
		
		oneTwo = new JButton("1,2");
		oneTwo.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		oneTwo.setFocusable(false);
		oneTwo.addActionListener(this);
		buttons.add(oneTwo);
		
		OneThree = new JButton("1,3");
		OneThree.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		OneThree.setFocusable(false);
		OneThree.addActionListener(this);
		buttons.add(OneThree);
		
		oneFour = new JButton("1,4");
		oneFour.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		oneFour.setFocusable(false);
		oneFour.addActionListener(this);
		buttons.add(oneFour);
		
		twoZero = new JButton("2,0");
		twoZero.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		twoZero.setFocusable(false);
		twoZero.addActionListener(this);
		buttons.add(twoZero);
		
		twoOne = new JButton("2,1");
		twoOne.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		twoOne.setFocusable(false);
		twoOne.addActionListener(this);
		buttons.add(twoOne);
		
		twoTwo = new JButton("2,2");
		twoTwo.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		twoTwo.setFocusable(false);
		twoTwo.addActionListener(this);
		buttons.add(twoTwo);
		
		twoThree = new JButton("2,3");
		twoThree.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		twoThree.setFocusable(false);
		twoThree.addActionListener(this);
		buttons.add(twoThree);

		twoFour = new JButton("2,4");
		twoFour.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		twoFour.setFocusable(false);
		twoFour.addActionListener(this);
		buttons.add(twoFour);
		
		threeZero = new JButton("3,0");
		threeZero.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		threeZero.setFocusable(false);
		threeZero.addActionListener(this);
		buttons.add(threeZero);
		
		threeOne = new JButton("3,1");
		threeOne.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		threeOne.setFocusable(false);
		threeOne.addActionListener(this);
		buttons.add(threeOne);
		
		threeTwo = new JButton("3,2");
		threeTwo.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		threeTwo.setFocusable(false);
		threeTwo.addActionListener(this);
		buttons.add(threeTwo);
		
		threeThree = new JButton("3,3");
		threeThree.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		threeThree.setFocusable(false);
		threeThree.addActionListener(this);
		buttons.add(threeThree);
		
		threeFour = new JButton("3,4");
		threeFour.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		threeFour.setFocusable(false);
		threeFour.addActionListener(this);
		buttons.add(threeFour);
		
		fourZero = new JButton("4,0");
		fourZero.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		fourZero.setFocusable(false);
		fourZero.addActionListener(this);
		buttons.add(fourZero);
		
		fourOne = new JButton("4,1");
		fourOne.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		fourOne.setFocusable(false);
		fourOne.addActionListener(this);
		buttons.add(fourOne);
		
		fourTwo = new JButton("4,2");
		fourTwo.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		fourTwo.setFocusable(false);
		fourTwo.addActionListener(this);
		buttons.add(fourTwo);
		
		fourThree = new JButton("4,3");
		fourThree.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		fourThree.setFocusable(false);
		fourThree.addActionListener(this);
		buttons.add(fourThree);
		
		fourFour = new JButton("4,4");
		fourFour.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		fourFour.setFocusable(false);
		fourFour.addActionListener(this);
		buttons.add(fourFour);
		
		this.getContentPane().add(buttons,BorderLayout.CENTER);

		this.repaint();
		this.revalidate();
	}
	public void updateabilties(JComboBox<String> abilities) 
	{
		abilities.removeAll();
		for(int i = 0;i<mainframe.game.getCurrentChampion().getAbilities().size();i++)
		{
			if(mainframe.game.getCurrentChampion().getAbilities().get(i).getCastArea() == AreaOfEffect.SINGLETARGET)
			{
				abilities.addItem(mainframe.game.getCurrentChampion().getAbilities().get(i).getName());
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Ability a = null;
		for(int i = 0;i<mainframe.game.getCurrentChampion().getAbilities().size();i++)
		{
			if(mainframe.game.getCurrentChampion().getAbilities().get(i).getName() == abilities.getSelectedItem())
			{
				a = mainframe.game.getCurrentChampion().getAbilities().get(i);
			}
		}
		if(e.getSource() == zerozero)
		{
			
			try {
				mainframe.game.castAbility(a, 0, 0);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource() == zeroOne)
		{
			try {
				mainframe.game.castAbility(a, 0, 1);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == zeroTwo)
		{
			try {
				mainframe.game.castAbility(a, 0, 2);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == zeroThree)
		{
			try {
				mainframe.game.castAbility(a, 0, 3);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == zeroFour)
		{
			try {
				mainframe.game.castAbility(a, 0, 4);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == oneZero)
		{
			try {
				mainframe.game.castAbility(a, 1, 0);
			}catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == oneOne)
		{
			try {
				mainframe.game.castAbility(a, 1, 1);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == oneTwo)
		{
			try {
				mainframe.game.castAbility(a, 1, 2);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == OneThree)
		{
			try {
				mainframe.game.castAbility(a, 1, 3);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == oneFour)
		{
			try {
				mainframe.game.castAbility(a, 1, 4);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == twoZero)
		{
			try {
				mainframe.game.castAbility(a, 2,0);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == twoOne)
		{
			try {
				mainframe.game.castAbility(a, 2, 1);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == twoTwo)
		{
			try {
				mainframe.game.castAbility(a, 2, 2);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == twoThree)
		{
			try {
				mainframe.game.castAbility(a, 2, 3);
			}catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == twoFour)
		{
			try {
				mainframe.game.castAbility(a, 2, 4);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == threeZero)
		{
			try {
				mainframe.game.castAbility(a, 3, 0);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == threeOne)
		{
			try {
				mainframe.game.castAbility(a, 3, 1);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == threeTwo)
		{
			try {
				mainframe.game.castAbility(a, 3, 2);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == threeThree)
		{
			try {
				mainframe.game.castAbility(a, 3, 3);
			}catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == threeFour)
		{
			try {
				mainframe.game.castAbility(a, 3, 4);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == fourZero)
		{
			try {
				mainframe.game.castAbility(a, 4, 0);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == fourOne)
		{
			try {
				mainframe.game.castAbility(a, 4, 1);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == fourTwo)
		{
			try {
				mainframe.game.castAbility(a, 4, 2);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == fourThree)
		{
			try {
				mainframe.game.castAbility(a, 4, 3);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == fourFour)
		{
			try {
				mainframe.game.castAbility(a, 4, 4);
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),
			               "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
