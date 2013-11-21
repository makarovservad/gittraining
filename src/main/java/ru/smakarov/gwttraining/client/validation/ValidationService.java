package ru.smakarov.gwttraining.client.validation;

import ru.smakarov.gwttraining.client.widget.personcard.PersonDO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("validate")
public interface ValidationService extends RemoteService 
{
	ValidationInfoDO validate(PersonDO person);
}
