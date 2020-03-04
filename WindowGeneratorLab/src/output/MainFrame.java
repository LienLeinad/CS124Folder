package output;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JToggleButton.ToggleButtonModel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		// GENERATED UI CODE GOES HERE -- assume that you will add to rootPanel called "panel"
		
		// THIS IS THE BASIC FORM OF A TEXT PANE
		{
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("name");
		panel_1.add(lblNewLabel);
		
		name = new JTextPane();
		name.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_1.add(name);
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(0, 20));
		panel_1.add(separator);
		}
		// THIS IS THE BASIC FORM OF A TEXT PANE
		{
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("newPane");
		panel_1.add(lblNewLabel);
		
		newPane = new JTextPane();
		newPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_1.add(newPane);
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(0, 20));
		panel_1.add(separator);
		}
		// THIS IS THE BASIC FORM OF A CHECKBOX
		{
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		status = new JCheckBox("Employed");
		panel_1.add(status);
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(0, 20));
		panel_1.add(separator);
		}
		// THIS IS THE BASIC FORM OF A SINGLE SELECTION
		{
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JLabel label = new JLabel("programmingLevel");
		panel_1.add(label);
		
		programmingLevel = new ButtonGroup();
		

			// THIS IS THE BASIC FORM OF A RADIO BUTTON
		{
		JRadioButton rb = new JRadioButton("Beginner");
		panel_1.add(rb);
		programmingLevel.add(rb);
		}

			// THIS IS THE BASIC FORM OF A RADIO BUTTON
		{
		JRadioButton rb = new JRadioButton("Intermediate");
		panel_1.add(rb);
		programmingLevel.add(rb);
		}

			// THIS IS THE BASIC FORM OF A RADIO BUTTON
		{
		JRadioButton rb = new JRadioButton("Advanced");
		panel_1.add(rb);
		programmingLevel.add(rb);
		}
		
	
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(0, 20));
		panel_1.add(separator);
		}

		
		// END GENERATED UI CODE
		
		
		
		JButton btnEchoSelections = new JButton("Echo selections");
		btnEchoSelections.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				echo();
			}
		});
		panel.add(btnEchoSelections);
		
	}
	
	
	// GENERATED UI FIELDS GO HERE
	
    	private JTextPane name;
    	private JTextPane newPane;
    	private JCheckBox status;
    	private ButtonGroup programmingLevel;
	
	
	// END GENERATED UI FIELDS
	
	
	
	public void echo()
	{
		
		lab.UIModel model = new lab.UIModel();
		
		// GENERATED FIELD PROCESSING 

		model.setName(name.getText());
		model.setNewPane(newPane.getText());
		model.setStatus(status.isSelected());
		for (Enumeration e = programmingLevel.getElements(); e.hasMoreElements(); )
		{
			JRadioButton rb = (JRadioButton) e.nextElement();
			if (rb.isSelected())
			{
				model.setProgrammingLevel(rb.getText());
				break;
			}
		}


		// END GENERATED FIELD PROCESSING

		System.out.println(model);
		
		
	}

}
