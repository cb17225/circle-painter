// *** Your name: Matvey Volkov
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CirclePainterWindow extends JFrame implements ActionListener { 
	
	private CirclePanel circlePanel;
	private CirclePanelListener circlePanelListener;
	private JTextField radiusTextField;
	
	public CirclePainterWindow() {
		circlePanel = new CirclePanel();
		circlePanelListener = new CirclePanelListener(circlePanel);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(circlePanel, BorderLayout.CENTER);
		
		CirclePanel contentForInteraction = new CirclePanel();
		JButton removeRecent = new JButton("Remove Most Recent Circle");
		removeRecent.addActionListener(this); 
		JButton removeAll = new JButton("Remove All Circles");
		removeAll.addActionListener(this); 
		radiusTextField = new JTextField(16);
		JLabel radiusLabel = new JLabel("Radius:");
		radiusTextField.addActionListener(this);
		contentForInteraction.add(removeRecent);
		contentForInteraction.add(removeAll);
		contentForInteraction.add(radiusLabel);
		contentForInteraction.add(radiusTextField);
		mainPanel.add(contentForInteraction, BorderLayout.SOUTH);
		// Create a panel for the buttons, label, and text field
		// and then add it in the south position.
		// Remember to add this as an ActionListener for the
		// buttons and text field.
		
		// The line "radiusTextField.selectAll();" will be helpful for completing your requirements. 
		// You can look up what it does. 
		// As for where it goes, think about which section of your code it would be most helpful in.
		
		
		JMenuBar menuBar = new JMenuBar();
		JMenu color = new JMenu("Color");
        JMenuItem red = new JMenuItem("Red");
        red.addActionListener(this);
        JMenuItem blue = new JMenuItem("Blue");
        blue.addActionListener(this);
        JMenuItem green = new JMenuItem("Green");
        green.addActionListener(this);
        color.add(red);
        color.addSeparator();
        color.add(blue);
        color.addSeparator();
        color.add(green);
        menuBar.add(color);
		
		//Create a Color menu for the menu bar with Red, Blue, and Green menu items.
		//Remember to add this as an ActionListener for the menu items.
		
		this.setContentPane(mainPanel);
		this.setJMenuBar(menuBar);

	}


	@Override
	public void actionPerformed(ActionEvent ev) {
		String s = ev.getActionCommand();
		if (s.equals("Red")) {
			circlePanelListener.setColorOfNewlyCreatedCircles(Color.RED);
		} else if (s.equals("Blue")) {
			circlePanelListener.setColorOfNewlyCreatedCircles(Color.BLUE);
		} else if (s.equals("Green")) {
			circlePanelListener.setColorOfNewlyCreatedCircles(Color.GREEN);
		} else if (s.equals("Remove Most Recent Circle")) {
			circlePanel.removeMostRecentCircle();
		} else if (s.equals("Remove All Circles")) {
			circlePanel.removeAllCircles();
			return;
		} else {
			String x = radiusTextField.getText();
			try {
				int number = Integer.parseInt(x);
				if (number > 0) {
					circlePanelListener.setRadiusOfNewlyCreatedCircles(number);
				} else {
					radiusTextField.setText("Must enter a positive integer.");
				}
				radiusTextField.selectAll();
			} catch (NumberFormatException e) {
				radiusTextField.setText("Must enter a positive integer.");
				radiusTextField.selectAll();
			}
		}
		circlePanel.repaint();
	}
	

}
