package mgerh001.auction.data;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import mgerh001.auction.model.SaleObject;
import mgerh001.auction.services.SaleObjectService;
import mgerh001.auction.util.Events.Added;
import mgerh001.auction.util.Events.Deleted;

/**
 * Die Klasse symbolisiert die noch fehlende Datenbankanbindung, die eine Liste von Gegenständen über eine Get-methode erhält.
 * @author mgerh001
 *
 */
@SessionScoped
public class SaleObjectListProducer implements Serializable {

	private static final long serialVersionUID = 9007546868616451373L;
	@Inject
	private List<SaleObject> saleObjects;
	@Inject
	private SaleObjectService saleObjectService;
	
	@PostConstruct
	public void init() {
		saleObjects = saleObjectService.getAllSaleObjects();
	}
	
	/**
	 * Eine Liste von SaleObject wird zur Verfügung gestellt.
	 * Klassen die diese Liste verwenden haben keine Abhängigkeit zu dieser Klasse, sonder lediglich zu dieser Liste.
	 * Die Named-Annotation wird genutzt um die Methode im Facelet zu referenzieren.
	 * @return
	 */
	@Produces
	@Named
	public List<SaleObject> getSaleObjects() {
		return saleObjects;
	}
	
	/**
	 * Das übergebene SaleObject wird in die Liste hinzugefügt durch den Aufruf von add
	 * @param saleObject
	 */
	public void onSaleObjectAdded(@Observes @Added SaleObject saleObject) {
		getSaleObjects().add(saleObject);		
	}
	
	/**
	 * Das Übergebene SaleObject wird aus der Liste entfernt durch den Aufruf von remove
	 * @param saleObject
	 */
	public void onSaleObjectDeleted(@Observes @Deleted SaleObject saleObject) {
		getSaleObjects().remove(saleObject);
	}
}
