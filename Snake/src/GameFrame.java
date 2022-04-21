import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameFrame extends JFrame implements ActionListener  {
	
	GamePanel gamepanel;
	JButton resetButton;
	JButton musicButton;
	
	GameFrame() {
		
		
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setSize(600, 500);
		
		resetButton = new JButton();
		resetButton.setText("Reset");
		resetButton.setSize(100,50);
		resetButton.setLocation(248,450);
		resetButton.addActionListener(this);
		
		musicButton = new JButton();
		musicButton.setText("Music");
		musicButton.setSize(90, 40);
		musicButton.setLocation(248, 600);
		musicButton.addActionListener(this);
		
		
		
		gamepanel = new GamePanel();
		this.add(resetButton);
		this.add(gamepanel);
		
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==resetButton) {
			this.remove(gamepanel);
			gamepanel = new GamePanel();
			this.add(gamepanel);
			gamepanel.requestFocusInWindow();
			SwingUtilities.updateComponentTreeUI(this);
			
		}
		
		if(e.getSource()==musicButton) {
			try {
				Main.music();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
