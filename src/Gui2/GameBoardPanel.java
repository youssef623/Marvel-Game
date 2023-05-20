package Gui2;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.world.Champion;
import model.world.Cover;

public class GameBoardPanel extends JPanel  implements ActionListener 
{
	ArrayList<JButton> buttons;
	MainFrame gameview;
	public GameBoardPanel(MainFrame gameview)
	{
		this.gameview = gameview;
		this.setSize(1050,700);
		this.setLayout(new GridLayout(5,5));
		
		JButton temp;
		for(int i=0;i<5;i++)
		{
			for(int j = 0;j<5;j++)
			{
				if(gameview.game.getBoard()[i][j] == null)
				{
					temp = new JButton("null");
					temp.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
					temp.setEnabled(false);
					temp.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
					temp.setFocusable(false);
					this.add(temp);
				}
				else if(gameview.game.getBoard()[i][j] instanceof Champion)
				{
					Champion o = ((Champion) gameview.game.getBoard()[i][j]);
					
					
					boolean isfirst = false;
					for(int x = 0;x<gameview.game.getFirstPlayer().getTeam().size();x++)
					{
						if(o == gameview.game.getFirstPlayer().getTeam().get(x))
						{
							isfirst = true;
						}
					}
					if(isfirst)
					{
						temp = new JButton(o.getName());
						temp.setBackground(Color.blue);
						temp.setForeground(Color.WHITE);
						temp.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
						temp.addActionListener(this);
						if(gameview.game.getCurrentChampion() == o)
						{
							temp.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2, true));
						}
						else
						{
							temp.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
						}
						temp.setFocusable(false);
						this.add(temp);
					}
					else
					{
						temp = new JButton(o.getName());
						temp.setBackground(Color.green);
						temp.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
						temp.addActionListener(this);
						if(gameview.game.getCurrentChampion() == o)
						{
							temp.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2, true));
						}
						else
						{
							temp.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
						}
						temp.setFocusable(false);
						this.add(temp);
					}
				}
				else
				{
					Cover c =((Cover) gameview.game.getBoard()[i][j]);
					temp = new JButton("Cover Hp" + c.getCurrentHP());
					temp.setBackground(Color.gray);
					temp.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
					temp.addActionListener(this);
					temp.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
					temp.setFocusable(false);
					this.add(temp);
				}
			}
		}
		this.repaint();
		this.revalidate();
	}
	
	public void update(MainFrame gameview)
	{
		this.removeAll();
		JButton temp;
		for(int i=0;i<5;i++)
		{
			for(int j = 0;j<5;j++)
			{
				if(gameview.game.getBoard()[i][j] == null)
				{
					temp = new JButton("null");
					temp.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
					temp.setEnabled(false);
					temp.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
					temp.setFocusable(false);
					this.add(temp);
				}
				else if(gameview.game.getBoard()[i][j] instanceof Champion)
				{
					Champion o = ((Champion) gameview.game.getBoard()[i][j]);
					
					boolean isfirst = false;
					for(int x = 0;x<gameview.game.getFirstPlayer().getTeam().size();x++)
					{
						if(o == gameview.game.getFirstPlayer().getTeam().get(x))
						{
							isfirst = true;
						}
					}
					if(isfirst)
					{
						temp = new JButton(o.getName());
						temp.setBackground(Color.blue);
						temp.setForeground(Color.WHITE);
						temp.addActionListener(this);
						if(gameview.game.getCurrentChampion() == o)
						{
							temp.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2, true));
						}
						else
						{
							temp.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
						}
						temp.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
						temp.setFocusable(false);
						this.add(temp);
					}
					else
					{
						temp = new JButton(o.getName());
						temp.setBackground(Color.green);
						temp.addActionListener(this);
						if(gameview.game.getCurrentChampion() == o)
						{
							temp.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2, true));
						}
						else
						{
							temp.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
						}
						temp.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
						temp.setFocusable(false);
						this.add(temp);
					}
				}
				else
				{
					Cover c =((Cover) gameview.game.getBoard()[i][j]);
					temp = new JButton("Cover Hp" + c.getCurrentHP());
					temp.setBackground(Color.gray);
					temp.addActionListener(this);
					temp.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
					temp.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
					temp.setFocusable(false);
					this.add(temp);
				}
			}
		}
		this.repaint();
		this.revalidate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new infoAboutItem(((JButton)e.getSource()).getText(),gameview);
		
	}
}
