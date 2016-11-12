package org.usd232.hackathon.twentysixteen;

import org.usd232.hackathon.twentysixteen.authentication.IAuthenticationService;
import org.usd232.hackathon.twentysixteen.database.IDatabaseConnection;
import org.usd232.hackathon.twentysixteen.providers.IMessageProvider;

public abstract class ModuleFactory {
	public static final IAuthenticationService[] AUTHENTICATION_SERVICES = new IAuthenticationService[] {

	};

	public static final IMessageProvider[] MESSAGE_PROVIDERS = new IMessageProvider[] {

	};

	public static final IDatabaseConnection DATABASE_CONNECTION = null;
}
