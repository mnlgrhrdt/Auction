package mgerh001.auction.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import mgerh001.auction.data.SaleObjectProducer;

/**
 * In dieser Bean wird dynamisch eine URL aus dem dazugehörigen Protokoll, Host, Port und Webkontext generiert
 * @author mgerh001
 *
 */
@SessionScoped
@Named
public class EditBidFormController implements Serializable {

	private static final long serialVersionUID = -3233849012830230076L;

	private String textColor = "000000";
	private String bgColor = "fffff";
	@Inject
	private SaleObjectProducer saleObjectProducer;
	@Inject
	private HttpServletRequest req;

	public String doOk() {
		return Pages.LIST_SALEOBJECTS;
	}

	public String getUrl() {
		return getAppUrl() + "/" + Pages.BID_MONEY + ".jsf" + "?bgColor=" + bgColor + "&textColor=" + textColor
				+ "&saleObjectId=" + saleObjectProducer.getSelectedSaleObject().getId();
	}
	
	private String getAppUrl() {
		String scheme = req.getScheme();
		String serverName = req.getServerName();
		int serverPort = req.getServerPort();
		String contextPath = req.getContextPath();
		return scheme + "://" + serverName + ":" + serverPort + contextPath;
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

}
