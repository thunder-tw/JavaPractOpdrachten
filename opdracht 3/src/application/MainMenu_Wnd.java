package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import db.DataBase;
import model.Item;
import view.ItemTableModel;
import view.KlantTableModel;
//import view.UitleenTableModel;
import view.UitleenTableModel;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MainMenu_Wnd extends JFrame {
	private DataBase db;
	//private DefaultListModel<Item> model;

	JFrame VoegItemToe = new JFrame();
	JFrame VoegKlantToe = new JFrame();
	private JPanel contentPane;
	private JTable tblKlanten;
	private JTable tblUitlenen;
	private JTable tblItems;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataBase db = new DataBase();
					MainMenu_Wnd frame = new MainMenu_Wnd(db);
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
	public MainMenu_Wnd(DataBase db) {
		this.db = db;
		setTitle("Beheer CD/DVD/Games Winkel");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 622, 301);
		contentPane.add(tabbedPane);
		
		
		//TabBlad Items
		
		JPanel Items = new JPanel();
		tabbedPane.addTab("Items", null, Items, null);
		Items.setLayout(null);
		
		JButton btnItemToevoegen = new JButton("Toevoegen");
		btnItemToevoegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoegItemToe_Wnd test = new VoegItemToe_Wnd();
				test.setModal( true);
				test.setVisible(true);
				if( test.getItem() != null )
				{
					db.VoegItemToe( test.getItem() );
					refreshItemList();
				}
			}
		});
		btnItemToevoegen.setBounds(12, 13, 103, 25);
		Items.add(btnItemToevoegen);
		
		JButton btnItemVerwijderen = new JButton("Verwijderen");
		btnItemVerwijderen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numRows = tblItems.getSelectedRows().length;
				ItemTableModel model = (ItemTableModel) tblItems.getModel();
				for(int i=0; i<numRows ; i++ ) {
					
					model.removeRow(tblItems.getSelectedRow());
				}
			}
		});
		btnItemVerwijderen.setBounds(12, 52, 103, 25);
		Items.add(btnItemVerwijderen);
		
		ItemTableModel model = new ItemTableModel(db);
		tblItems = new JTable( model );
		
		JScrollPane  panItems = new JScrollPane (tblItems);
		panItems.setBounds(127, 13, 478, 245);
		Items.add(panItems);
		
		
		//TabBlad Klanten
		
		JPanel Klanten = new JPanel();
		tabbedPane.addTab("Klanten", null, Klanten, null);
		Klanten.setLayout(null);
		
		/* BEGIN AANPASSINGEN */
		JButton btnKlantToevoegen = new JButton("Toevoegen");
		btnKlantToevoegen.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						VoegKlantToe_Wnd klantToevoegenWindow = new VoegKlantToe_Wnd();
						klantToevoegenWindow.setModal(true);
						klantToevoegenWindow.setSize(560,300);
						klantToevoegenWindow.setVisible(true);
						//klantToevoegenWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						if( klantToevoegenWindow.getKlant() != null )
						{
							db.VoegKlantToe(klantToevoegenWindow.getKlant());
							refreshKlantList();
						}
					}
				});
		btnKlantToevoegen.setBounds(12, 13, 103, 25);
		Klanten.add(btnKlantToevoegen);
		
		
		JButton btnKlantVerwijderen = new JButton("Verwijderen");
		btnKlantVerwijderen.setBounds(12, 52, 103, 25);
		Klanten.add(btnKlantVerwijderen);
		btnKlantVerwijderen.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
					int rowIndex = tblKlanten.getSelectedRow();	
					db.RemoveKlant(rowIndex);
					refreshKlantList();

			}
		});
		KlantTableModel modelKlanten = new KlantTableModel(db);
		tblKlanten = new JTable(modelKlanten);
		JScrollPane  panKlanten = new JScrollPane (tblKlanten);
		panKlanten.setBounds(127, 13, 478, 245);
		Klanten.add(panKlanten);
		
		//tblKlanten.setBorder(new LineBorder(new Color(0, 0, 0)));
		//tblKlanten.setBounds(126, 13, 479, 245);
		//Klanten.add(tblKlanten);
		
		/*EINDE AANPASSINGEN*/
		
		// TabBlad Uitlenen
		JPanel Uitlenen = new JPanel();
		tabbedPane.addTab("Uitlenen", null, Uitlenen, null);
		Uitlenen.setLayout(null);
		
		JButton btnUitleningToevoegen = new JButton("Toevoegen");
		btnUitleningToevoegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoegUitleenItemToe_Wnd test = new VoegUitleenItemToe_Wnd();
				test.setModal( true);
				test.setVisible(true);
				if( test.getUitleenItem() != null )
				{
					db.VoegUitleenItemToe( test.getUitleenItem() );
					refreshUitleenItemList();
				}
			}
		});
		btnUitleningToevoegen.setBounds(12, 13, 103, 25);
		Uitlenen.add(btnUitleningToevoegen);
		
		JButton btnUitleningVerwijderen = new JButton("Verwijderen");
		btnUitleningVerwijderen.setBounds(12, 52, 103, 25);
		Uitlenen.add(btnUitleningVerwijderen);
		
		UitleenTableModel uitleentablemodel = new UitleenTableModel(db.getAllUitleenItems());
		tblUitlenen = new JTable(uitleentablemodel );
		JScrollPane panUilenen = new JScrollPane(tblUitlenen);
		panUilenen.setBounds(127, 13, 478, 245);
		Uitlenen.add(panUilenen);
	}

	private void refreshItemList() {
		//ItemTableModel model = tblItems.getModel();
		ItemTableModel model = new ItemTableModel(db);
		tblItems.setModel(model);
		tblItems.updateUI();
	}
	
	private void refreshKlantList() {
		KlantTableModel model = new KlantTableModel(db);
		tblKlanten.setModel(model);
		tblKlanten.updateUI();
	}
	
	private void refreshUitleenItemList() {
		UitleenTableModel model = new UitleenTableModel(db.getAllUitleenItems());
		tblUitlenen.setModel(model);
		tblUitlenen.updateUI();
	}
}
