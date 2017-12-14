package mgerh001.auction.services;

import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

import mgerh001.auction.model.Bid;
import mgerh001.auction.model.SaleObject;

@RequestScoped
@Alternative
public class SaleObjectServiceBean implements SaleObjectService{

	@Override
	public List<SaleObject> getAllSaleObjects() {
		return new LinkedList<SaleObject>();
	}

	@Override
	public Double computeMaxBidSoFar(List<Bid> bids) {
		
		return null;
	}

	@Override
	public List<Bid> sortBidList(List<Bid> bids) {
		
		return null;
	}
}
