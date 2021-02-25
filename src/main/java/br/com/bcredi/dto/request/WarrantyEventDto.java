package br.com.bcredi.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.bcredi.model.WarrantyProvince;

public interface WarrantyEventDto extends Serializable {

	String getWarrantyId();

	BigDecimal getWarrantyValue();

	void setWarrantyValue(BigDecimal warrantyValue);

	WarrantyProvince getWarrantyProvince();

	void setWarrantyProvince(WarrantyProvince warrantyProvince);

	EventDto getEvent();

}