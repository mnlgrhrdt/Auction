package mgerh001.auction.controller;

import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import mgerh001.auction.model.Bid;

/**
 * Diese Klasse soll nicht vom Ersteller der Auktion genutzt werden, sondern von einem beliebigen Internetnutzer.
 * Daher ist hier auch noch kein Zugriff auf den gebotenen Gegestand möglich, da eine Zuordnung ohne Persitenzschicht so noch nicht möglich ist.
 * Erst mit dem Ergänzen der Datendank soll dies realisiert werden.
 * @author mgerh001
 *
 */
@SessionScoped
@Named
public class BidMoneyController implements Serializable {

	private static final long serialVersionUID = 8603796693370307181L;
	private String textColor = "000000";
	private String bgColor = "ffffff";
	private Long auctionId;
	private Bid bid;
	@Inject
	private FacesContext facesContext;
	@Inject
	private Logger logger;

	@PostConstruct
	public void init() {
		this.bid = new Bid();
	}

	/**
	 * Der Benutzer erhält eine Meldung zur Bestätigung der Zahlung in der entsprechenden Sprache
	 * @return
	 */
	public String doBid() {
		logger.log(Level.INFO, "log.bidMoney.processing",
				new Object[] { getBid().getTendererName(), getBid().getAmount() });
		final ResourceBundle resourceBundle = facesContext.getApplication().getResourceBundle(facesContext, "msg");
		final String msg = resourceBundle.getString("bidMoney.processing");
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
		init();
		return Pages.BID_MONEY;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public Long getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(Long auctionId) {
		this.auctionId = auctionId;
	}

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

}
