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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VoegItemToe_Wnd extends JDialog {

	private Item myItem;
	private JPanel contentPane;
	private JTextField txtNaam;
	private JTextField txtIdNummer;
	private JTextField txtBeschrijving;

	public Item getItem() {
		return myItem;
	}

	/**
	 * Create the frame.
	 */
	public VoegItemToe_Wnd() {

		setTitle("Voeg item toe");
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNaam = new JLabel("Naam:");
		lblNaam.setBounds(12, 127, 74, 16);
		contentPane.add(lblNaam);

		JLabel lblIdNummer = new JLabel("Id nummer:");
		lblIdNummer.setBounds(12, 81, 74, 16);
		contentPane.add(lblIdNummer);

		JLabel lblSoortItem = new JLabel("Soort item:");
		lblSoortItem.setBounds(12, 32, 74, 16);
		contentPane.add(lblSoortItem);

		txtNaam = new JTextField();
		txtNaam.setBounds(92, 124, 328, 22);
		contentPane.add(txtNaam);
		txtNaam.setColumns(10);

		txtIdNummer = new JTextField();
		txtIdNummer.setColumns(10);
		txtIdNummer.setBounds(92, 78, 328, 22);
		contentPane.add(txtIdNummer);

		JComboBox cmbSoortItem = new JComboBox(EnumItems.values());
		cmbSoortItem.setEditable(false);
		cmbSoortItem.setBounds(92, 29, 328, 22);
		contentPane.add(cmbSoortItem);

		JButton btnItemToevoegen = new JButton("Toevoegen");
		btnItemToevoegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(txtIdNummer.getText());
				String titel = txtNaam.getText();
				String beschrijving = txtBeschrijving.getText();

				if (cmbSoortItem.getSelectedItem().toString() == "CD") {
					myItem = new CD(titel, id, beschrijving);
				} else if (cmbSoortItem.getSelectedItem().toString() == "DVD") {
					myItem = new Movie(titel, id, beschrijving);
				} else if (cmbSoortItem.getSelectedItem().toString() == "Game") {
					myItem = new Game(titel, id, beschrijving);
				}
				setVisible(false);
			}
		});

		btnItemToevoegen.setBounds(215, 215, 97, 25);
		contentPane.add(btnItemToevoegen);

		JLabel lblBeschrijving = new JLabel("Beschrijving:");
		lblBeschrijving.setBounds(12, 177, 74, 16);
		contentPane.add(lblBeschrijving);

		txtBeschrijving = new JTextField();
		txtBeschrijving.setBounds(92, 174, 328, 22);
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

	}
}
