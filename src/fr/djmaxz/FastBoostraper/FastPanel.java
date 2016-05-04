package fr.djmaxz.FastBoostraper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class FastPanel extends JPanel{
	
	private Image backgroundImage;
	@SuppressWarnings("unused")
	private FastVersion version;
	private FastPanel instance;
	
	public FastPanel(Image background, FastVersion version, ImageIcon buttonIcon) {
		this.instance = this;
		this.backgroundImage = background;
		this.version = version;
		
		this.setSize(900, 600);
		this.setLayout(null);
		
		JLabel versionLabel = new JLabel("Version : " + version.getActualVersion());
		if(version.isUpdated()){
			versionLabel.setForeground(new Color(0, 153, 0));
			versionLabel.setText("A jour | " + versionLabel.getText());
		}else{
			versionLabel.setForeground(new Color(153, 0, 0));
			versionLabel.setText("Mettre à jour | " + versionLabel.getText());
		}
		versionLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
		int labelWidth = (int)versionLabel.getPreferredSize().getWidth(), labelHeight = (int)versionLabel.getPreferredSize().getHeight();
		versionLabel.setBounds((this.instance.getWidth()-labelWidth)/2, 550, labelWidth , labelHeight);
		this.add(versionLabel);
		
		Icon closeBackground = new ImageIcon(FastBoostraper.class.getResource("/resources/close.jpg"));
		JButton closeButton = new JButton(closeBackground);
		closeButton.setBounds((this.instance.getWidth()-110), 10, 100, 50);
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((Window) getRootPane().getParent()).dispose();
			}
		});
		this.add(closeButton);
		
		Icon reduceBackground = new ImageIcon(FastBoostraper.class.getResource("/resources/reduce.jpg"));
		JButton reduceButton = new JButton(reduceBackground);
		reduceButton.setBounds((this.instance.getWidth()-220), 10, 100, 50);
		reduceButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((Frame) getRootPane().getParent()).setState(Frame.ICONIFIED);
			}
		});
		this.add(reduceButton);
		
		Icon buttonBackground = buttonIcon;
		JButton mainButton = new JButton(buttonBackground);
		if(version.isUpdated()){
			mainButton.setText("Lancer");
		}else{
			mainButton.setText("Mettre à jour");
		}
		mainButton.setHorizontalTextPosition(SwingConstants.CENTER);
		mainButton.setBounds((this.instance.getWidth()-200)/2, 400, 200, 60);
		this.add(mainButton);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        g.drawImage(this.backgroundImage, 0, 0, null);
	}

}
