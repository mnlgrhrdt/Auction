package mgerh001.auction.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import mgerh001.auction.data.SaleObjectProducer;
import mgerh001.auction.model.SaleObject;
import mgerh001.auction.util.Events.Deleted;

/**
 * Die Beispielanwendung Auction soll es Besitzern von Gegenständen, die sie nicht mehr benötigen, diese zu einem guten Preis zu verkaufen.
 * Über ein Onlineformular soll es möglich sein, Links zu erzeugen, damit der Verkäufer die Auktionen einfacher verteilen kann.
 * Dazu kommt später eine zweite Anwendung deren Aufgabe es sein wird zu einer vom Benutzer frei wählbaren Auktion eine Liste aller Gebote anzuzeigen, damit er verfolgen kann,
 * wie hoch sich die Gebote gerade befinden.
 * 
 * Dieser Controller erhält die Lebensdauer für die Sitzung.
 * Für jede mögliche Interaktion des Nutzers mit der View wird eine Kontrolllogik definiert.
 * @author mgerh001
 *
 */
@SessionScoped
@Named
public class ListSaleObjectsController implements Serializable{

	private static final long serialVersionUID = -8474443056704935809L;
	private SaleObject saleObjectToDelete;
	
	@Inject
	private SaleObjectProducer saleObjectProducer;
	@Inject @Deleted
	private Event<SaleObject> saleObjectDeleteEvent;
	
	public String doAddSaleObject() {
		saleObjectProducer.prepareAddSaleObject();
		return Pages.EDIT_SALEOBJECT;
	}
	
	public String doEditSaleObject(SaleObject saleObject) {
		saleObjectProducer.prepareEditSaleObject(saleObject);
		return Pages.EDIT_SALEOBJECT;
	}
	
	public String doEditBidForm(SaleObject saleObject) {
		saleObjectProducer.setSelectedSaleObject(saleObject);
		return Pages.EDIT_BID_FORM;
	}
	
	public String doListBids(SaleObject saleObject) {
		saleObjectProducer.setSelectedSaleObject(saleObject);
		return Pages.LIST_BIDS;
	}
	
	public void doDeleteSaleObject(SaleObject saleObject) {
		this.saleObjectToDelete = saleObject;
	}
	
	public void commitDeleteSaleObject() {
		saleObjectDeleteEvent.fire(saleObjectToDelete);
	}
	
	public String doAddCampaign() {
		saleObjectProducer.prepareAddSaleObject();
		return Pages.EDIT_SALEOBJECT;
	}
}
