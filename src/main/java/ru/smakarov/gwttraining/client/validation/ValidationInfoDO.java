package ru.smakarov.gwttraining.client.validation;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ValidationInfoDO implements IsSerializable
{
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public ValidationInfoDO() {
		
	}

	public ValidationInfoDO(String status) {
		super();
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValidationInfoDO other = (ValidationInfoDO) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ValidationInfoDO [status=" + status + "]";
	}
	
	
	
	
}
