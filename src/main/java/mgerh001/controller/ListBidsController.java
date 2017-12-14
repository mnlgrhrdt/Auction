package mgerh001.auction.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class ListBidsController implements Serializable{

	private static final long serialVersionUID = -2169874259508183400L;
	
	public String doOk() {
		return Pages.LIST_SALEOBJECTS;
	}
	
}
