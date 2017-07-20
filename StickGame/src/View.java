import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JFrame
{
	static final int felderZahl = 36;
	JFrame frame = new JFrame("Stickgame");
	JPanel panel = new JPanel();
	Button[] buttons = new Button[felderZahl];
	int[] disabledButtons = new int[]{0, 1, 4, 5, 6, 11, 24, 29, 30, 31, 34, 35};
	int index = 0;
	
	public View()
	{
		frame.add(panel);
		panel.setLayout(new GridLayout((int) Math.sqrt(felderZahl), (int) Math.sqrt(felderZahl)));
		for(int i = 0; i < buttons.length; i++)
		{
			buttons[i] = new Button();
			buttons[i].addActionListener(e ->{
				System.out.println(Integer.valueOf(e.getActionCommand()));
				});
			if(disabledButtons[index] == i)
			{
				//System.out.println("ouafhgsoüuaf");
				buttons[i].setEnabled(false);
				buttons[i].setBackground(Color.BLACK);
				buttons[i].setForeground(Color.BLACK);
				index++;
			}
			panel.add(buttons[i]);
		}
		
		
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/*public static void changeStatus(Button button)
	{
		System.out.print("ja");
		
		for(int i = 0; i < buttons.length; i++)
		{
			if(button == buttons[i])
			{
				System.out.print(i);
			}
		}
	}*/
	

	
}
