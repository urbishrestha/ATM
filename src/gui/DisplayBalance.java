package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

import extendedClass.ATMCustomer;
import extendedClass.Customer;

import states.ATM.ATMContext;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayBalance {

	private JFrame frame;
	private String balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayBalance window = new DisplayBalance();
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
	public DisplayBalance() {
		initialize();
	}

	public DisplayBalance(String balance) {
		this.balance = balance;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 102, 102));
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Balance Details");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 60, 564, 62);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 174, 215, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total Balance:");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 235, 215, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("account type");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(264, 174, 215, 50);
		Customer cust = ATMCustomer.getAtmCustomer();
		lblNewLabel_3.setText(cust.getAccount().getName());
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("total balance");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(264, 235, 215, 40);
		lblNewLabel_4.setText(this.balance);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose(); //closes the window--cannot be recovered
				LastTranscation last = new LastTranscation();
				last.NewScreen();
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 153));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(435, 301, 125, 50);
		frame.getContentPane().add(btnNewButton);
	}
	
	public void NewScreen(final String balance) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				DisplayBalance displaybalance = new DisplayBalance(balance);
				displaybalance.frame.setVisible(true);
			}
		});
	}

	
	
}
