import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton implements MouseListener
{
	 int indexInt;
	 String kante;
	public Button()
	{
		addMouseListener(this);
		addActionListener(e ->{    
		JButton button = (JButton)e.getSource();
        String indexString = button.getText();
        indexInt = Integer.parseInt(indexString);
        System.out.println("Index : "+indexInt);
	});
	}

	@Override
	public void mouseClicked(MouseEvent clickE) 
	{
		//System.out.println("X: " + clickE.getX());
		//System.out.println(" Y: " + clickE.getY());
		if(clickE.getX() < 20 && clickE.getY() > 20 && clickE.getY() < 72)
		{
			kante = "Linke Kante";
			System.out.println(kante);
			this.setBackground(Color.RED);
			
			//View.changeStatus(this);
		}
		else if(clickE.getX() > 20 && clickE.getX() < 79 && clickE.getY() < 20)
		{
			kante = "Obere Kante";
			System.out.println(kante);
			
			this.setBackground(Color.BLUE);
		}
		else if(clickE.getX() > 76 && clickE.getY() > 20 && clickE.getY() < 62)
		{
			kante = "Rechte Kante";
			System.out.println(kante);
			this.setBackground(Color.GREEN);
		}
		else if(clickE.getX() > 20 && clickE.getX() < 79 && clickE.getY() > 72)
		{
			kante = "Untere Kante";
			System.out.println(kante);
			this.setBackground(Color.YELLOW);
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
