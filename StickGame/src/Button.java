import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton implements MouseListener
{
	int indexInt;
	String kante;
	
	public Button()
	{
		setBackground(Color.WHITE);
		addMouseListener(this);
		addActionListener(e ->{    
		JButton button = (JButton)e.getSource();
        String indexString = button.getText();
        indexInt = Integer.parseInt(indexString);
        System.out.println("Index : " + indexInt);
		});
	}

	@Override
	public void mouseClicked(MouseEvent clickE) 
	{
		if(clickE.getX() < 20 && clickE.getY() > 20 && clickE.getY() < 72)
		{
			System.out.println("Linke Kante");
			try 
			{
				Image links = ImageIO.read(getClass().getResource("LinkeKanteP1.png"));
				this.setIcon(new ImageIcon(links));
				checkNext(indexInt, "links");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
					
		}
		else if(clickE.getX() > 20 && clickE.getX() < 79 && clickE.getY() < 20)
		{
			System.out.println("Obere Kante");
			try 
			{
				Image oben = ImageIO.read(getClass().getResource("ObereKanteP1.png"));
				this.setIcon(new ImageIcon(oben));
				checkNext(indexInt, "oben");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		else if(clickE.getX() > 76 && clickE.getY() > 20 && clickE.getY() < 62)
		{
			System.out.println("Rechte Kante");
			try 
			{
				Image rechts = ImageIO.read(getClass().getResource("RechteKanteP1.png"));
				this.setIcon(new ImageIcon(rechts));
				checkNext(indexInt, "rechts");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		else if(clickE.getX() > 20 && clickE.getX() < 79 && clickE.getY() > 72)
		{
			System.out.println("Untere Kante");
			try 
			{
				Image unten = ImageIO.read(getClass().getResource("UntereKanteP1.png"));
				this.setIcon(new ImageIcon(unten));
				checkNext(indexInt, "unten");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	private void checkNext(int indexInt, String side)
	{
		if(side == "links")
		{
			try 
			{
				Image img = ImageIO.read(getClass().getResource("RechteKanteP1.png"));
				View.buttons[indexInt - 1].setIcon(new ImageIcon(img));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}	
		}
		else if(side == "oben")
		{
			try 
			{
				Image img = ImageIO.read(getClass().getResource("UntereKanteP1.png"));
				View.buttons[indexInt - 6].setIcon(new ImageIcon(img));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}	
		}
		else if(side == "rechts")
		{
			try 
			{
				Image img = ImageIO.read(getClass().getResource("LinkeKanteP1.png"));
				View.buttons[indexInt + 1].setIcon(new ImageIcon(img));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}	
		}
		else if(side == "unten")
		{
			try 
			{
				Image img = ImageIO.read(getClass().getResource("ObereKanteP1.png"));
				View.buttons[indexInt + 6].setIcon(new ImageIcon(img));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}	
		}
	}
	
	public int getIndex()
	{
		return indexInt;
	}
	
	public String getKante()
	{
		return kante;
	}
	
	
}
