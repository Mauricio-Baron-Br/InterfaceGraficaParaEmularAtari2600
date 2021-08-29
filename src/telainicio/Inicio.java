package telainicio;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Inicio extends JFrame {

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
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
