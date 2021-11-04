import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Start {

	private JFrame frame;
	private JComboBox <String> startBox;
	private JComboBox <String> endBox;
	private JLabel lblResult;
	private JButton btnReset;
	private JButton btnConvert;
	private JButton btnExit;
	double result = 0.0;
	double input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {

		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 530, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		
		JLabel lblNewLabel = new JLabel("Convert:");
		lblNewLabel.setBounds(10, 11, 52, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JTextField textFieldConvert = new JTextField();
		textFieldConvert.setText("--,--");
		textFieldConvert.setBounds(60, 8, 119, 20);
		frame.getContentPane().add(textFieldConvert);
		textFieldConvert.setColumns(10);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTo.setBounds(10, 61, 20, 14);
		frame.getContentPane().add(lblTo);
		
		endBox = new JComboBox<>();
		endBox.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECT", "USD", "EUR"}));
		endBox.setBounds(60, 57, 184, 22);
		frame.getContentPane().add(endBox);
		
		startBox = new JComboBox<>();
		startBox.setModel(new DefaultComboBoxModel<String>(new String[] {"SELECT", "USD", "EUR"}));
		startBox.setBounds(231, 7, 184, 22);
		frame.getContentPane().add(startBox);
		
		lblResult = new JLabel("RESULT");
		lblResult.setBounds(270, 61, 119, 14);
		frame.getContentPane().add(lblResult);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				startBox.setSelectedIndex(0);
				endBox.setSelectedIndex(0);
				lblResult.setText("0.00");
				textFieldConvert.setText("--,--");
			}
		});
		btnReset.setBounds(10, 129, 89, 23);
		frame.getContentPane().add(btnReset);
		
		btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
//				btn pressed now convert
				
				try {
//					This will convert the input string into a double
					
					input = Double.parseDouble(textFieldConvert.getText());
					
					
					if(startBox.getSelectedItem().equals("EUR") && endBox.getSelectedItem().equals("USD")) {
						result = input * 1.17;
						lblResult.setText("$ "+ result);
					}
					if(startBox.getSelectedItem().equals("USD") && endBox.getSelectedItem().equals("EUR")) {
							result = input * 0.83;
							lblResult.setText(result + " €");	
					}
					if(startBox.getSelectedItem().equals("EUR") && endBox.getSelectedItem().equals("EUR")) {

						lblResult.setText("why?");
					}
					if(startBox.getSelectedItem().equals("USD") && endBox.getSelectedItem().equals("USD")) {
						lblResult.setText("stop it fool");
						}
				}
				catch(Exception e){
//					This will warn the user if the input is invalid
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
			}
		});
		btnConvert.setBounds(155, 129, 89, 23);
		frame.getContentPane().add(btnConvert);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
		btnExit.setBounds(300, 129, 89, 23);
		frame.getContentPane().add(btnExit);
	}
}
