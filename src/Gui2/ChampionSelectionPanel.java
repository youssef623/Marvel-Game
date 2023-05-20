package Gui2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.world.Champion;

public class ChampionSelectionPanel extends JPanel  implements ActionListener 
{
	final Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
	ArrayList<JButton> buttons;
	MainFrame gameview;
	JTextArea Player1txtarea;
	ImageIcon icon;
	int count;
	ChampionSelectionTextArea firstPlayerTextArea;
	ChampionSelectionTextArea secondPlayerTextArea;
	ArrayList<ImageIcon> icons;
	
	ImageIcon CaptainAmerica;
	ImageIcon Deadpool;
	ImageIcon DrStrange;
	ImageIcon Electro;
	ImageIcon GhostRider;
	ImageIcon Hela;
	ImageIcon Hulk;
	ImageIcon Iceman;
	ImageIcon Ironman;
	ImageIcon Loki;
	ImageIcon Quicksilver;
	ImageIcon Spiderman;
	ImageIcon Thor;
	ImageIcon Venom;
	ImageIcon YellowJacket;
	
	public ChampionSelectionPanel(MainFrame gameview,ArrayList<Champion> champions,ChampionSelectionTextArea firstPlayerTextArea,ChampionSelectionTextArea secondPlayerTextArea)
	{
		icons= new ArrayList<ImageIcon>();
		
		CaptainAmerica = new ImageIcon("captainamerica2.png");
		icons.add(CaptainAmerica);
		
		Deadpool = new ImageIcon("deadpool2.png");
		icons.add(Deadpool);
		
		DrStrange = new ImageIcon("drstrange2.png");
		icons.add(DrStrange);
		
		Electro = new ImageIcon("electro2.png");
		icons.add(Electro);
		
		GhostRider = new ImageIcon("ghostrider2.png");
		icons.add(GhostRider);
		
		Hela = new ImageIcon("hela2.png");
		icons.add(Hela);
		
		Hulk = new ImageIcon("hulk2.png");
		icons.add(Hulk);
		
		Iceman = new ImageIcon("iceman2.png");
		icons.add(Iceman);
		
		Ironman = new ImageIcon("ironman2.png");
		icons.add(Ironman);
		
		Loki = new ImageIcon("loki2.png");
		icons.add(Loki);
		
		Quicksilver =  new ImageIcon("quicksilver2.png");
		icons.add(Quicksilver);
		
		Spiderman =  new ImageIcon("spiderman2.png");
		icons.add(Spiderman);
		
		Thor = new ImageIcon("thor2.png");
		icons.add(Thor);
		
		Venom = new ImageIcon("venom2.png");
		icons.add(Venom);
		
		YellowJacket = new ImageIcon("yellowjacket2.png");
		icons.add(YellowJacket);
		
		this.gameview = gameview;
		this.firstPlayerTextArea = firstPlayerTextArea;
		this.secondPlayerTextArea = secondPlayerTextArea;
		
		this.setLayout(new GridLayout(0,3));
		buttons = new ArrayList<JButton>();
		
		for(int i = 0;i<champions.size();i++)
		{
			JButton temp = new JButton();
			temp.setName(champions.get(i).getName());
			System.out.println(champions.get(i).getName());
			temp.setIcon(icons.get(0));
			icons.remove(0);
			temp.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
			temp.setFocusable(false);
			temp.addActionListener(this);
			buttons.add(temp);
		}
		for(int i = 0;i<buttons.size();i++)
		{
			this.add(buttons.get(i));
		}
		this.repaint();
		this.revalidate();
	}
	
	public void removebutton(String x)
	{
		for(int i = 0;i<buttons.size();i++)
		{
			if(buttons.get(i).getName().equals(x))
			{
				buttons.get(i).setEnabled(false);
			}
		}
	}
	public void updateCount()
	{
		count++;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String championname = ((JButton)e.getSource()).getName();
		try {
			new ChampionInfoSelect(championname,count,gameview,this,firstPlayerTextArea,secondPlayerTextArea);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
