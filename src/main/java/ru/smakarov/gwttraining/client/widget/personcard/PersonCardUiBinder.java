package ru.smakarov.gwttraining.client.widget.personcard;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.AbsolutePanel;

public class PersonCardUiBinder extends Composite
{
	interface PersonCardUiBinderUiBinder extends
		UiBinder<Widget, PersonCardUiBinder> {}
	
	private static PersonCardUiBinderUiBinder uiBinder = GWT
			.create(PersonCardUiBinderUiBinder.class);
	
	@UiField Label accessCodeLabel;
	@UiField Label departmentLabel;
	@UiField Label nameLabel;
	@UiField Label securityBadgeLabel;
	@UiField Image photo;
	@UiField AbsolutePanel mainPanel;	

	public PersonCardUiBinder() 
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public PersonCardUiBinder(final PersonDO data) 
	{
		initWidget(uiBinder.createAndBindUi(this));
		accessCodeLabel.setText("Access code: " + data.getAccessCode());
		nameLabel.setText("Name: " + data.getName());
		departmentLabel.setText("Department: " + data.getDepartment());
	}
}
