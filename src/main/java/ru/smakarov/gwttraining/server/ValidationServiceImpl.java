package ru.smakarov.gwttraining.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import ru.smakarov.gwttraining.client.validation.ValidationInfoDO;
import ru.smakarov.gwttraining.client.validation.ValidationService;
import ru.smakarov.gwttraining.client.widget.personcard.PersonDO;

public class ValidationServiceImpl extends RemoteServiceServlet implements ValidationService {

	private static final long serialVersionUID = 1L;

	public ValidationInfoDO validate(PersonDO person) {
		return new ValidationInfoDO("Sussess!");
	}

}
