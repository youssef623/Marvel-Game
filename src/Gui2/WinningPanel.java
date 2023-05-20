package Gui2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.Player;

public class WinningPanel extends JPanel{
	final Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();

	public WinningPanel(Player player)
	{
		this.setSize(screenSize.width,screenSize.height);
		JLabel winning = new JLabel("" + player.getName() + "WINS");
		winning.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
		winning.setBounds(400,400 , screenSize.width, screenSize.height);
		this.add(winning);
	}

}
