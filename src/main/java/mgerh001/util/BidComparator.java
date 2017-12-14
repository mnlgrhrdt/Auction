package mgerh001.auction.util;

import java.util.Comparator;

import mgerh001.auction.model.Bid;

public class BidComparator implements Comparator<Bid> {

	@Override
	public int compare(Bid o1, Bid o2) {
		return o1.getAmount() > o2.getAmount() ? -1 : o1.getAmount() == o2.getAmount() ? 0 : 1;
	}

}
