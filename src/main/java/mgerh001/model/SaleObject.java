package mgerh001.auction.model;

import java.util.List;


/**
 * Auf einen Gegenstand kann geboten werden. Sämmtliche Gebote sollen in einer Liste gespeichert werden damit man immer sehen kann, wer und wie viel geoten hat.
 * Der Verkäufer kann auch einen Sofortkaufpreis erstellen. Bieten soll bis zum Enddatum möglich sein.
 * @author mgerh001
 *
 */
public class SaleObject {
	private String name;
	private Double immediatePurchase;
	private Double bidMinimum;
	private Double maxBidSoFar;
	private Account account;
	private Long id;
	private List<Bid> bids;
	private String endDate;
	
	public SaleObject() {
		setAccount(new Account());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getImmediatePurchase() {
		return immediatePurchase;
	}

	public void setImmediatePurchase(Double immediatePurchase) {
		this.immediatePurchase = immediatePurchase;
	}

	public Double getMaxBidSoFar() {
		return maxBidSoFar;
	}

	public void setMaxBidSoFar(Double maxBidSoFar) {
		this.maxBidSoFar = maxBidSoFar;
	}

	public Double getBidMinimum() {
		return bidMinimum;
	}

	public void setBidMinimum(Double bidMinimum) {
		this.bidMinimum = bidMinimum;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
