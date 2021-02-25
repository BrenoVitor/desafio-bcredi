package br.com.bcredi.model.impl;

import java.math.BigDecimal;

import br.com.bcredi.model.Warranty;
import br.com.bcredi.model.WarrantyProvince;

public class WarrantyImpl implements Warranty {

	private static final long serialVersionUID = 1L;

	private final String warrantyId;

	private final BigDecimal warrantyValue;

	private final WarrantyProvince warrantyProvince;

	public WarrantyImpl(String warrantyId, BigDecimal warrantyValue, WarrantyProvince warrantyProvince) {
		this.warrantyId = warrantyId;
		this.warrantyValue = warrantyValue;
		this.warrantyProvince = warrantyProvince;
	}

	@Override
	public BigDecimal getWarrantyValue() {
		return warrantyValue;
	}

	@Override
	public WarrantyProvince getWarrantyProvince() {
		return warrantyProvince;
	}

	@Override
	public String getWarrantyId() {
		return warrantyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		WarrantyImpl other = (WarrantyImpl) obj;
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
		return "Warranty [warrantyId=" + warrantyId + ", warrantyValue=" + warrantyValue + ", warrantyProvince="
				+ warrantyProvince + "]";
	}

}
