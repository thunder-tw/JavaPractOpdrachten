package view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.*;
import model.tellers.Teller;
import view.*;

public class SlotController {
	private final static String DEBLOK_CODE = "deblok";
	private final static int MAX_AANTAL_POGINGEN = 3;

	private Slot slot;
	private BedieningsPanel bedieningsPanel;

	private ESlotStatus slotStatus;
	int aantalPogingen;
	private String logTekst = "";

	public SlotController(Slot slot, JFrame bedieningsVenster) {
		this.slot = slot;
		bedieningsPanel = new BedieningsPanel(slot.getAantalTellers());
		bedieningsPanel.setTekstForControleButton("OPEN KLUIS");
		bedieningsPanel.setSlotButtonsListener(new SlotButtonListener());
		bedieningsPanel.setControleButtonListener(new ControleButtonListener());
		bedieningsVenster.add(bedieningsPanel);

		slotStatus = ESlotStatus.CLOSED;
		aantalPogingen = 0;
		resetTellers();
	}

	private void resetTellers() {
		int index = 0;
		for (Teller teller : slot.getTellers()) {
			if (teller != null) {
				bedieningsPanel.setSysmboolForSlotButton(index, teller.getHuidigeWaarde());
				index++;
			}
		}
	}

	class SlotButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int tellerIndex = Integer.parseInt(e.getActionCommand());
			slot.updateHuidigeWaardeTeller(tellerIndex);
			char symbool = slot.getWaardeTeller(tellerIndex);
			bedieningsPanel.setSysmboolForSlotButton(tellerIndex, symbool);
		}
	}

	class ControleButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			logTekst = "";
			switch (slotStatus) {
			case OPEN:
				bedieningsPanel.sluitKluis();
				slotStatus = ESlotStatus.CLOSED;
				bedieningsPanel.setTekstForControleButton("OPEN KLUIS");
				slot.resetTellers();
				resetTellers();
				bedieningsPanel.setSlotButtonsActief(true);
				logTekst = "Kluis dicht";
				break;
			case CLOSED:
				aantalPogingen++;
				logTekst = "Poging " + aantalPogingen + " " + slot.getSlotKombinatie() + " FOUTE CODE!";
				boolean isGeheimGevonden = slot.isGeheimGevonden();
				if (isGeheimGevonden) {
					// TODO
				} else {
					if (aantalPogingen == MAX_AANTAL_POGINGEN) {
						// TODO
					}
				}
				break;
			case BLOCKED:
				logTekst = "Deblokkering slot mislukt";
				String deblokCode = JOptionPane.showInputDialog("Typ deblokkeercode");
				if (deblokCode.equals(DEBLOK_CODE)) {
					slotStatus = ESlotStatus.CLOSED;
					bedieningsPanel.setTekstForControleButton("OPEN KLUIS");
					slot.resetTellers();
					resetTellers();
					bedieningsPanel.setSlotButtonsActief(true);
					aantalPogingen = 0;
					logTekst = "Slot succesvol gedeblokkeerd";
				}
			}
			bedieningsPanel.updateLogTekst(logTekst);
		}
	}
}
