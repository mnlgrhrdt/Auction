package mgerh001.auction.model;

/**
 * Diese Klasse repräsentiert ein Gebot.
 * Ein Gebot kann sich in Bearbeitung befinden oder am Ende einer Aiktion überwiesen werden
 * @author mgerh001
 *
 */
public class Bid {
	private Double amount;
	private String tendererName;
	private Boolean receiptRequested;
	private Status status;
	private Account account;
	
	public enum Status {
		TRANSFERRED, IN_PROCESS;
	}
	
	public Bid() {
		this.setAccount(new Account());
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTendererName() {
		return tendererName;
	}

	public void setTendererName(String tendererName) {
		this.tendererName = tendererName;
	}

	public Boolean getReceiptRequested() {
		return receiptRequested;
	}

	public void setReceiptRequested(Boolean receiptRequested) {
		this.receiptRequested = receiptRequested;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
