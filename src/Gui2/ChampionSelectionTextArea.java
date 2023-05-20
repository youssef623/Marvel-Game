package Gui2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ChampionSelectionTextArea extends JTextArea{

	final Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
	String information;
	JLabel xLabel;
	public ChampionSelectionTextArea(String x)
	{
		xLabel = new JLabel(x);
		xLabel.setBounds(10, 0, 300, 50);
		xLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		this.add(xLabel);
		this.setPreferredSize(new Dimension(300, screenSize.height));
		this.setEditable(false);
		this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		information ="\n"  ;
		this.setText(information);
	}
	public void updatetext(String x)
	{
		information += "\n" + x;
		this.setText(information);
	}
	public void updatetextLeader(String x)
	{
		information = "\n" + "\n" +"Team Leader =>"+ "\n" + x + information;
		this.setText(information);
	}
}
