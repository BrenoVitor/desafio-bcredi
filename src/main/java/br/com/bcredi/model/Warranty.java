package br.com.bcredi.model;

import java.io.Serializable;
import java.math.BigDecimal;

public interface Warranty extends Serializable {

	BigDecimal getWarrantyValue();

	WarrantyProvince getWarrantyProvince();

	String getWarrantyId();

}