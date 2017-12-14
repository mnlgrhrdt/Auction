package mgerh001.auction.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import mgerh001.auction.data.SaleObjectProducer;
import mgerh001.auction.model.SaleObject;
import mgerh001.auction.util.Events.Added;

@SessionScoped
@Named
public class EditSaleObjectController implements Serializable {

	private static final long serialVersionUID = 8885651631533865689L;

	@Inject
	private SaleObjectProducer saleObjectProducer;
	@Inject @Added
	private Event<SaleObject> saleObjectAddEvent;
	
	
	/**
	 * Beim Hinzufügen einer Auktion wird eine entsprechende Nachricht gesendet.
	 * Fire sendet die eigentliche Nachricht des Typs SaleObject.
	 * Alle anderen Beans können diese Nachricht empfangen.
	 * @return
	 */
	public String doSave() {
		if (saleObjectProducer.isAddMode()) {
			saleObjectAddEvent.fire(saleObjectProducer.getSelectedSaleObject());
		}
		return Pages.LIST_SALEOBJECTS;
	}
	
	public String doCancel() {
		return Pages.LIST_SALEOBJECTS;
	}
}
