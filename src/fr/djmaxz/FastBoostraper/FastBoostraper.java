package fr.djmaxz.FastBoostraper;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FastBoostraper {

	@SuppressWarnings("unused")
	private String softwareName;
	private FastVersion version;
	private JFrame frame;
	public JPanel panel;
	
	public FastBoostraper(String softwareName, FastVersion version){
		
		frame = new JFrame();
		frame.setTitle(softwareName);
		frame.setSize(900, 600);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(frame.getSize());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(false);
		
	}
	
	public void setFastPanel(FastPanel fastPanel) {
		frame.setContentPane(fastPanel);
		frame.setVisible(true);
	}

	public FastVersion getFastVersion() {
		return this.version;
	}
}
