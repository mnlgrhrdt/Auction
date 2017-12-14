package mgerh001.auction.data;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import mgerh001.auction.model.SaleObject;

/**
 * Das Anlegen und Bearbeiten von Gegenständen soll die selbe Eingabemaste besitzen. Daher werden beide über diesen Controller gesteuert.
 * Der Unterschied besteht nur darin, dass im zweiten Fall ein bestehendes SaleObject-Objekt bearbeitet werden muss 
 * und deshalb die Werte der Eigenschaften in der Eingabemaske angezeigt werden müssen.
 * Beim Erzeugen eines neuen Objektes müssen dessen Werte über die Eingabemaske gesetzt werden.
 * @author mgerh001
 *
 */
@SessionScoped
public class SaleObjectProducer implements Serializable {

	private static final long serialVersionUID = 8219732063711596846L;
	
	public enum Mode {
		EDIT, ADD;
	}
	
	private SaleObject saleObject;
	private Mode mode;
	
	@Produces
	@Named
	public SaleObject getSelectedSaleObject() {
		return saleObject;
	}
	
	public void setSelectedSaleObject(SaleObject saleObject) {
		this.saleObject = saleObject;
	}
	
	@Produces
	@Named
	public boolean isAddMode() {
		return mode == Mode.ADD;
	}
	
	
	/**
	 * Die Initialisierung der Bean ist Abhängig vom vorliegenden Arbeitsmodus.
	 * Ein neues SaleObject wird erzeugt.
	 */
	public void prepareAddSaleObject() {
		this.saleObject = new SaleObject();
		this.mode = Mode.ADD;
	}
	
	/**
	 * Die Initialisierung der Bean ist Abhängig vom vorliegenden Arbeitsmodus.
	 * Ein zu bearbeitendes SaleObject wird übergeben.
	 */
	public void prepareEditSaleObject(SaleObject saleObject) {
		this.saleObject = saleObject;
		this.mode = Mode.EDIT;
	}
}
