package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.DataBase;
import model.CD;
import model.EnumItems;
import model.Game;
import model.Item;
import model.Klant;
import model.Movie;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
	

public class VoegKlantToe_Wnd extends JDialog{
	
	private Klant myKlant;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtVoornaam;
	private JTextField txtAchternaam;
	private JTextField txtStraat;
	private JTextField txtNummer;
	private JTextField txtGemeente;
	private JTextField txtPostcode;
	
	public Klant getKlant()
	{
		return myKlant;
	}
	
	public VoegKlantToe_Wnd()
	{
		setTitle("Voeg klant toe");
		setBounds(100,100,450,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVoornaam = new JLabel("Voornaam:");
		lblVoornaam.setBounds(12, 35, 74, 16);
		contentPane.add(lblVoornaam);
		
		txtVoornaam = new JTextField();
		txtVoornaam.setBounds(100, 35, 300, 22);
		contentPane.add(txtVoornaam);
		
		JLabel lblAchternaam = new JLabel("Achternaam:");
		lblAchternaam.setBounds(12, 65, 74, 16);
		contentPane.add(lblAchternaam);
		
		txtAchternaam = new JTextField();
		txtAchternaam.setBounds(100, 65, 300, 22);
		contentPane.add(txtAchternaam);
		
		JLabel lblStraat = new JLabel("Straat:");
		lblStraat.setBounds(12, 95, 74, 16);
		contentPane.add(lblStraat);
		
		txtStraat = new JTextField();
		txtStraat.setBounds(100, 95, 300, 22);
		contentPane.add(txtStraat);
		
		JLabel lblNummer = new JLabel("Nr:");
		lblNummer.setBounds(410,95,50,16);
		contentPane.add(lblNummer);
		
		txtNummer = new JTextField();
		txtNummer.setBounds(435, 95, 50, 22);
		contentPane.add(txtNummer);
		
		JLabel lblPostcode = new JLabel("Postcode:");
		lblPostcode.setBounds(12,125,74,16);
		contentPane.add(lblPostcode);
		
		txtPostcode = new JTextField();
		txtPostcode.setBounds(100, 125, 300, 22);
		contentPane.add(txtPostcode);
		
		JLabel lblGemeente = new JLabel("Gemeente:");
		lblGemeente.setBounds(12,155,74,16);
		contentPane.add(lblGemeente);
		
		txtGemeente = new JTextField();
		txtGemeente.setBounds(100, 155, 300, 22);
		contentPane.add(txtGemeente);
		
		JButton btnKlantToevoegen = new JButton("Toevoegen");
		btnKlantToevoegen.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) {
						String voornaam = txtVoornaam.getText();
						String achternaam = txtAchternaam.getText();
						String straat = txtStraat.getText();
						String postcode = txtPostcode.getText();
						String nummer = txtNummer.getText();
						String gemeente = txtGemeente.getText();
						setVisible(false);
						
						myKlant = new Klant(voornaam,achternaam,straat,postcode,nummer,gemeente);;
					}
				});
		btnKlantToevoegen.setBounds(140, 215, 97, 25);
		contentPane.add(btnKlantToevoegen);
		
		
		JButton btnAnnuleren = new JButton("Annuleren");
		btnAnnuleren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAnnuleren.setBounds(250, 215, 97, 25);
		contentPane.add(btnAnnuleren);
		
		
		
		
		
	}
	
}
