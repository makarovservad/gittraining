package ru.smakarov.gwttraining.client.widget.personcard;

import ru.smakarov.gwttraining.client.GreetingService;
import ru.smakarov.gwttraining.client.GreetingServiceAsync;
import ru.smakarov.gwttraining.client.validation.ValidationInfoDO;
import ru.smakarov.gwttraining.client.validation.ValidationService;
import ru.smakarov.gwttraining.client.validation.ValidationServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.PushButton;

public class PersonCard extends Composite
{
	interface PersonCardUiBinder extends
		UiBinder<Widget, PersonCard> {}
	
	private static PersonCardUiBinder uiBinder = GWT
			.create(PersonCardUiBinder.class);
	
	@UiField Label accessCodeLabel;
	@UiField Label departmentLabel;
	@UiField Label nameLabel;
	@UiField Label securityBadgeLabel;
	@UiField Image photo;
	@UiField AbsolutePanel mainPanel;	
	@UiField PushButton validateButton;
	
	private final ValidationServiceAsync validationService = 
			GWT.create(ValidationService.class);
	
	private PersonDO data;
	
	public PersonCard() 
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public PersonCard(final PersonDO data) 
	{
		this();
		this.data = data;
		
		// Set UI fields
		accessCodeLabel.setText("Access code: " + data.getAccessCode());
		nameLabel.setText("Name: " + data.getName());
		departmentLabel.setText("Department: " + data.getDepartment());
		
		// Init button
		validateButton.addClickHandler(new ClickHandler() 
		{			
			public void onClick(ClickEvent event) 
			{
				validateButton.setEnabled(false);
				validationService.validate(data,
						new AsyncCallback<ValidationInfoDO>() 
				{							
					public void onSuccess(ValidationInfoDO result) 
					{
						Window.alert("Validation completed: " + result.getStatus());
						validateButton.setEnabled(true);
					}
					
					public void onFailure(Throwable exception) 
					{
						Window.alert("ERROR: " + exception.getMessage());
						validateButton.setEnabled(true);
					}
				});
			}
		});
	}
}
