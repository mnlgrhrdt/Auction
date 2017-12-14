package mgerh001.auction.util;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * Nachrichten des gleichen Types werden mit Qualifiern von einander unterschieden
 * @author mgerh001
 *
 */
public class Events {
	@Qualifier
	@Target({ FIELD, PARAMETER})
	@Retention(RUNTIME)
	public @interface Added {
	}
	@Qualifier
	@Target({FIELD, PARAMETER})
	@Retention(RUNTIME)
	public @interface Deleted{
	}
	
}
