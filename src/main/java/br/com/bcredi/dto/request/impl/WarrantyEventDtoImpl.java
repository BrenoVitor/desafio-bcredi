package br.com.bcredi.dto.request.impl;

import java.math.BigDecimal;

import br.com.bcredi.dto.request.EventDto;
import br.com.bcredi.dto.request.WarrantyEventDto;
import br.com.bcredi.model.WarrantyProvince;

public class WarrantyEventDtoImpl implements WarrantyEventDto {

	private static final long serialVersionUID = 6201965604596791063L;

	private final EventDto event;

	private final String warrantyId;

	private BigDecimal warrantyValue;

	private WarrantyProvince warrantyProvince;

	public WarrantyEventDtoImpl(EventDto event, String warrantyId, BigDecimal warrantyValue,
			WarrantyProvince warrantyProvince) {
		this(event, warrantyId);
		this.warrantyValue = warrantyValue;
		this.warrantyProvince = warrantyProvince;
	}

	public WarrantyEventDtoImpl(EventDto event, String warrantyId) {
		this.event = event;
		this.warrantyId = warrantyId;
	}

	@Override
	public String getWarrantyId() {
		return warrantyId;
	}

	@Override
	public BigDecimal getWarrantyValue() {
		return warrantyValue;
	}

	@Override
	public void setWarrantyValue(BigDecimal warrantyValue) {
		this.warrantyValue = warrantyValue;
	}

	@Override
	public WarrantyProvince getWarrantyProvince() {
		return warrantyProvince;
	}

	@Override
	public void setWarrantyProvince(WarrantyProvince warrantyProvince) {
		this.warrantyProvince = warrantyProvince;
	}

	@Override
	public EventDto getEvent() {
		return event;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((warrantyId == null) ? 0 : warrantyId.hashCode());
		result = prime * result + ((warrantyProvince == null) ? 0 : warrantyProvince.hashCode());
		result = prime * result + ((warrantyValue == null) ? 0 : warrantyValue.hashCode());
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
		WarrantyEventDtoImpl other = (WarrantyEventDtoImpl) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (warrantyId == null) {
			if (other.warrantyId != null)
				return false;
		} else if (!warrantyId.equals(other.warrantyId))
			return false;
		if (warrantyProvince != other.warrantyProvince)
			return false;
		if (warrantyValue == null) {
			if (other.warrantyValue != null)
				return false;
		} else if (!warrantyValue.equals(other.warrantyValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WarrantyEventDto [event=" + event + ", warrantyId=" + warrantyId + ", warrantyValue=" + warrantyValue
				+ ", warrantyProvince=" + warrantyProvince + "]";
	}

}
