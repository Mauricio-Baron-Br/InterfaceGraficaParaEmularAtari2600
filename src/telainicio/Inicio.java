package telainicio;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Inicio extends JFrame implements KeyListener {

	private JLabel lblImg;
	private ImageIcon imgIcon[] = new ImageIcon[200];
	private int x, y = 0;
	private boolean flagImage = true;

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

		if (e.getKeyCode() == e.VK_ENTER) {
			System.out.println("Tecla Enter");
		}
		if (e.getKeyCode() == e.VK_UP) {

			imgIcon[0] = imagemEscalonada("./labels/c_ChopperCommand_front.jpg", 200, 240);
			imgIcon[1] = imagemEscalonada("./labels/c_Enduro_front.jpg", 200, 240);
			imgIcon[2] = imagemEscalonada("./labels/c_Hero_front.jpg", 200, 240);
			imgIcon[3] = imagemEscalonada("./labels/c_Megamania_front.jpg", 200, 240);
			imgIcon[4] = imagemEscalonada("./labels/c_Pitfall_front.jpg", 200, 240);
			imgIcon[5] = imagemEscalonada("./labels/c_RiverRaid_front.jpg", 200, 240);
			imgIcon[6] = imagemEscalonada("./labels/c_SeaBattle_front.jpg", 200, 240);

			if (flagImage != false) {
				lblImg = new JLabel(imgIcon[0]);
				lblImg.setBounds(50, 240, imgIcon[0].getIconWidth(), imgIcon[0].getIconHeight());
				add(lblImg);
				flagImage = false;
			}

			if (lblImg.getIcon() != null) {
				lblImg.setIcon(imgIcon[x]);
				lblImg.setBounds(50, 240, imgIcon[0].getIconWidth(), imgIcon[0].getIconHeight());
				add(lblImg);
				x++;
				add(lblImg);
				repaint();

			} else {
				x = 0;
				flagImage = true;
			}

		}
		if (e.getKeyCode() == e.VK_DOWN) {

			imgIcon[0] = imagemEscalonada("./labels/c_ChopperCommand_front.jpg", 200, 240);
			imgIcon[1] = imagemEscalonada("./labels/c_Enduro_front.jpg", 200, 240);
			imgIcon[2] = imagemEscalonada("./labels/c_Hero_front.jpg", 200, 240);
			imgIcon[3] = imagemEscalonada("./labels/c_Megamania_front.jpg", 200, 240);
			imgIcon[4] = imagemEscalonada("./labels/c_Pitfall_front.jpg", 200, 240);
			imgIcon[5] = imagemEscalonada("./labels/c_RiverRaid_front.jpg", 200, 240);
			imgIcon[6] = imagemEscalonada("./labels/c_SeaBattle_front.jpg", 200, 240);

			if (flagImage != false) {
				lblImg = new JLabel(imgIcon[x]);
				lblImg.setBounds(50, 240, imgIcon[0].getIconWidth(), imgIcon[0].getIconHeight());
				add(lblImg);
				flagImage = false;
			}
			if(x<0) {
				x=6;
			}

			if (lblImg.getIcon() != null) {
				lblImg.setIcon(imgIcon[x]);
				lblImg.setBounds(50, 240, imgIcon[0].getIconWidth(), imgIcon[0].getIconHeight());
				add(lblImg);
				x--;
				add(lblImg);
				repaint();

			}
			else
			{
				x = 6;
				flagImage = true;
			}

		}
		if (e.getKeyCode() == e.VK_S) {
			boolean x;
			JOptionPane.showMessageDialog(null, " Realmente Deseja Sair? ", "INFORMATION",
					JOptionPane.INFORMATION_MESSAGE);

			System.exit(0);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private ImageIcon imagemEscalonada(String url, int altura, int largura) {
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File(url));
		} catch (IOException e) {
			System.out.println("Erro ao abrir a imagem…");
			e.fillInStackTrace();
		}

		return new ImageIcon(bufferedImage.getScaledInstance(altura, largura, 1000));
	}

}
