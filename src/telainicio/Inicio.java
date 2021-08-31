package telainicio;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Inicio extends JFrame implements KeyListener {

	public Inicio() {

		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("Interface Grafica Para Emular o Atari 2600");
			setSize(968, 550);
			setLocationRelativeTo(null);
			ImageIcon icone = new ImageIcon("./labels/icone.png");
			setIconImage(icone.getImage());
			final Image backgroundImage = javax.imageio.ImageIO.read(new File("./labels/atari2600.png"));
			setContentPane(new JPanel(new BorderLayout()) {
				@Override
				public void paintComponent(Graphics g) {
					g.drawImage(backgroundImage, 0, 0, null);

				}
			});
			addKeyListener(this);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == e.VK_ENTER){ 
			System.out.println("Tecla Enter");
		}
		if(e.getKeyCode() == e.VK_UP){ 
			//System.out.println("Tecla Cima");
			JPanel front = new JPanel();
			front.setBounds(50,240,210, 250);
			this.add(front);
			repaint();
			
		}
		if(e.getKeyCode() == e.VK_DOWN){ 
			//System.out.println("Tecla Baixo");
			JPanel front = new JPanel();
			front.setBounds(50,240,210, 250);
			this.add(front);
			repaint();
		}
		if(e.getKeyCode() == e.VK_S){ 
			boolean x;
			JOptionPane.showMessageDialog(null, " Realmente Deseja Sair? ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
			
			System.exit(0);
		}
	
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
