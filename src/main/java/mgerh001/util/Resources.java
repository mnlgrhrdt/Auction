package mgerh001.auction.util;

import java.util.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;

/**
 * Um eine beliebige Klasse als Bean verwenden zu können, verfügt die Klasse über Producer-methoden, die wieder Instanzen der Klasse erstellen können.
 * Diese stehen dadurch als Bean innerhalb des Containers zur verfügung und können über Inject verknüpft werden.
 * @author mgerh001
 *
 */
@Dependent
public class Resources {
	
	/**
	 * Der Logger protokolliert die Ausgaben in einer Log-Datei.
	 * @param injectionPoint
	 * @return
	 */
	@Produces
	public Logger produceLog(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName(), "messages");
	}
	
	@Produces
	@RequestScoped
	public FacesContext produceFacesContext() {
		return FacesContext.getCurrentInstance();
	}
}
