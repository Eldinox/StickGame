import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JFrame
{
	static final int felderZahl = 36;
	JFrame frame = new JFrame("Stickgame");
	JPanel panel = new JPanel();
	public static Button[] buttons = new Button[felderZahl];
	int[] disabledButtons = new int[]{0, 1, 4, 5, 6, 11, 24, 29, 30, 31, 34, 35};
	int index = 0;
	
	public View()
	{
		frame.add(panel);
		panel.setLayout(new GridLayout((int) Math.sqrt(felderZahl), (int) Math.sqrt(felderZahl)));
		File path = new File("D:\\Github\\StickGame\\StickGame\\src");
		for(int i = 0; i < buttons.length; i++)
		{
			buttons[i] = new Button();
			//buttons[i].setBorder(BorderFactory.createEmptyBorder());
			buttons[i].setText(Integer.toString(i));
			buttons[i].setForeground(new Color(255, 255, 255, 0));
			
			
			/* Das ist der Code damit die Bilder später überlappen und nicht überschrieben werden
			 * try 
			{
				//BufferedImage imgAktuel = ImageIO.read(new File(path, "newImage.png"));
				BufferedImage imgAktuel = buttons[i].getIcon();
				BufferedImage imgOverlay = ImageIO.read(new File(path, "UntereKanteP1.png"));
				int w = imgAktuel.getWidth();
				int h = imgAktuel.getHeight();
				BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				Graphics g = newImage.getGraphics();
				g.drawImage(imgOverlay, 0, 0, null);
				g.drawImage(imgAktuel, 0, 0, null);
					
				ImageIO.write(newImage, "PNG", new File(path, "newImage.png"));
				Image img = ImageIO.read(getClass().getResource("newImage.png"));
				buttons[i].setIcon(new ImageIcon(img));
			}
			catch(IOException e) 
			{
				System.out.println("fehler");
			}*/
			
			if(disabledButtons[index] == i)
			{
				buttons[i].setEnabled(false);
				buttons[i].setBackground(Color.BLACK);
				buttons[i].setForeground(Color.BLACK);
				index++;
			}
			panel.add(buttons[i]);
		}
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
