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
import model.Movie;
import model.UitleenItem;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VoegUitleenItemToe_Wnd extends JDialog {

	private UitleenItem myItem;
	private JPanel contentPane;
	private JTextField txtNaam;
	private JTextField txtIdNummer;
	private JTextField txtBeschrijving;

	public UitleenItem getUitleenItem() {
		return myItem;
	}

	/**
	 * Create the frame.
	 */
	public VoegUitleenItemToe_Wnd() {

		setTitle("Voeg uitleen item toe");
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNaam = new JLabel("item-ID nummer:");
		lblNaam.setBounds(12, 145, 124, 16);
		contentPane.add(lblNaam);

		JLabel lblIdNummer = new JLabel("klant-ID nummer:");
		lblIdNummer.setBounds(12, 113, 124, 16);
		contentPane.add(lblIdNummer);

		JLabel lblSoortItem = new JLabel("Selecteer item:");
		lblSoortItem.setBounds(12, 32, 124, 16);
		contentPane.add(lblSoortItem);

		txtNaam = new JTextField();
		txtNaam.setBounds(134, 142, 286, 22);
		contentPane.add(txtNaam);
		txtNaam.setColumns(10);

		txtIdNummer = new JTextField();
		txtIdNummer.setColumns(10);
		txtIdNummer.setBounds(134, 110, 286, 22);
		contentPane.add(txtIdNummer);

		JComboBox cmbItem = new JComboBox();
		cmbItem.setEditable(false);
		cmbItem.setBounds(134, 29, 286, 22);
		contentPane.add(cmbItem);

		JButton btnItemToevoegen = new JButton("Toevoegen");
		btnItemToevoegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO create a new UitleenItem;
				setVisible(false);
			}
		});

		btnItemToevoegen.setBounds(215, 215, 97, 25);
		contentPane.add(btnItemToevoegen);

		JLabel lblBeschrijving = new JLabel("terugkeer datum:");
		lblBeschrijving.setBounds(12, 177, 124, 16);
		contentPane.add(lblBeschrijving);

		txtBeschrijving = new JTextField();
		txtBeschrijving.setBounds(134, 174, 286, 22);
		contentPane.add(txtBeschrijving);
		txtBeschrijving.setColumns(10);

		JButton btnAnnuleren = new JButton("Annuleren");
		btnAnnuleren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAnnuleren.setBounds(323, 215, 97, 25);
		contentPane.add(btnAnnuleren);
		
		JLabel lblSelecteerKlant = new JLabel("Selecteer klant:");
		lblSelecteerKlant.setBounds(12, 64, 124, 16);
		contentPane.add(lblSelecteerKlant);
		
		JComboBox comboBox = new JComboBox(new Object[]{});
		comboBox.setEditable(false);
		comboBox.setBounds(134, 61, 286, 22);
		contentPane.add(comboBox);

	}

}
