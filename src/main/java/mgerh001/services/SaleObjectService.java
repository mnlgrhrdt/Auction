package mgerh001.auction.services;

import java.util.List;

import mgerh001.auction.model.Bid;
import mgerh001.auction.model.SaleObject;

/**
 * Die Serviceklasse dient momentan zur Anpassung der Zielarchitektur.
 * Später soll hier das Persistieren der Entitäten, das Bilden der Transaktionsklammern und eine weitere Absicherung der Anwendung stattfinden.
 * @author mgerh001
 *
 */
public interface SaleObjectService {
	List<SaleObject> getAllSaleObjects();
	Double computeMaxBidSoFar(List<Bid> bids);
	List<Bid> sortBidList(List<Bid> bids);
}
