package hust.soict.dsai.aims.screen.manager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MediaStore extends JPanel {

	private Media media;
	
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		if (media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(new PlayButtonListener());
			container.add(playButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private class PlayButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (media instanceof Playable) {
				try {
					Playable playableMedia = (Playable) media;
					JPanel p = new JPanel();
					JDialog d = new JDialog();
					JLabel l = null;
					l = new JLabel(playableMedia.getInfo(), SwingConstants.CENTER);
					p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
					l.setAlignmentX(Component.CENTER_ALIGNMENT);
					p.add(Box.createVerticalGlue());
					p.add(l);
					p.add(Box.createVerticalGlue());
					d.add(p);
					d.setSize(200,200);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					int w = d.getSize().width;
			        int h = d.getSize().height;
			        int x = (dim.width - w) / 2;
			        int y = (dim.height - h) / 2;
			        d.setLocation(x,y);
					d.setVisible(true);
				} catch (PlayerException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			} 
		}
	}
	
}
