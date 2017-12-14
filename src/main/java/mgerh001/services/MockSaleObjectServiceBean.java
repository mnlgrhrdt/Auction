package mgerh001.auction.services;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

import mgerh001.auction.model.Account;
import mgerh001.auction.model.Bid;
import mgerh001.auction.model.SaleObject;
import mgerh001.auction.util.BidComparator;
import mgerh001.auction.model.Bid.Status;

@RequestScoped
public class MockSaleObjectServiceBean implements SaleObjectService{

	@Override
	public List<SaleObject> getAllSaleObjects() {
		Bid bid1 = new Bid();
		Bid bid2 = new Bid();
		Bid bid3 = new Bid();
		Bid bid4 = new Bid();
		Bid bid5 = new Bid();
		Bid bid6 = new Bid();
		SaleObject saleObject1 = new SaleObject();
		SaleObject saleObject2 = new SaleObject();
		List<Bid> bids1 = new LinkedList<Bid>();
		List<Bid> bids2 = new LinkedList<Bid>();
		List<SaleObject> retList = new LinkedList<SaleObject>();
		
		bid1.setTendererName("Erster Bieter");
		bid1.setAmount(60d);
		bid1.setReceiptRequested(true);
		bid1.setStatus(Status.IN_PROCESS);
		bid1.setAccount(new Account(bid1.getTendererName(), "Bankname", "Bankleitzahl"));
		bid2.setTendererName("Zweiter Bieter");
		bid2.setAmount(50d);
		bid2.setReceiptRequested(false);
		bid2.setStatus(Status.IN_PROCESS);
		bid2.setAccount(new Account(bid2.getTendererName(), "Bankname", "Bankleitzahl"));
		bid3.setTendererName("Dritter Bieter");
		bid3.setAmount(55d);
		bid3.setReceiptRequested(true);
		bid3.setStatus(Status.IN_PROCESS);
		bid3.setAccount(new Account(bid3.getTendererName(), "Bankname", "Bankleitzahl"));
		bid4.setTendererName("Vierter Bieter");
		bid4.setAmount(70d);
		bid4.setReceiptRequested(true);
		bid4.setStatus(Status.IN_PROCESS);
		bid4.setAccount(new Account(bid4.getTendererName(), "Bankname", "Bankleitzahl"));
		bid5.setTendererName("Fünfter Bieter");
		bid5.setAmount(210d);
		bid5.setReceiptRequested(false);
		bid5.setStatus(Status.IN_PROCESS);
		bid5.setAccount(new Account(bid5.getTendererName(), "Bankname", "Bankleitzahl"));
		bid6.setTendererName("Sechster Bieter");
		bid6.setAmount(200d);
		bid6.setReceiptRequested(false);
		bid6.setStatus(Status.IN_PROCESS);
		bid6.setAccount(new Account(bid6.getTendererName(), "Bankname", "Bankleitzahl"));
		
		bids1.add(bid2);
		bids1.add(bid1);
		bids1.add(bid3);
		bids1.add(bid4);
		bids2.add(bid5);
		bids2.add(bid6);
		
		bids1 = sortBidList(bids1);
		bids2 = sortBidList(bids2);
		
		saleObject1.setName("Hochbett");
		saleObject1.setBidMinimum(50d);
		saleObject1.setImmediatePurchase(100d);
		saleObject1.setId(1L);
		saleObject1.setMaxBidSoFar(computeMaxBidSoFar(bids1));
		saleObject1.setEndDate("01/01/2018");
		saleObject1.setAccount(new Account("Erster Verkäufer", "Bankname", "Bankleitzahl"));
		saleObject1.setBids(bids1);
		saleObject2.setName("Computer");
		saleObject2.setBidMinimum(200d);
		saleObject2.setImmediatePurchase(350d);
		saleObject2.setId(2L);
		saleObject2.setMaxBidSoFar(computeMaxBidSoFar(bids2));
		saleObject2.setEndDate("28/04/2018");
		saleObject2.setAccount(new Account("Zweiter Verkäufer", "Bankname", "Bankleitzahl"));
		
		retList.add(saleObject1);
		retList.add(saleObject2);
		
		return retList;
	}

	@Override
	public Double computeMaxBidSoFar(List<Bid> bids) {
		Double maxBidSoFar = 0.0;
		for(Bid aktBid : bids) {
			if(aktBid.getAmount() > maxBidSoFar) {
				maxBidSoFar = aktBid.getAmount();
			}
		}
		return maxBidSoFar;
	}

	@Override
	public List<Bid> sortBidList(List<Bid> bids) {
		Collections.sort(bids, new BidComparator());
		return bids;
	}
	
	
}
