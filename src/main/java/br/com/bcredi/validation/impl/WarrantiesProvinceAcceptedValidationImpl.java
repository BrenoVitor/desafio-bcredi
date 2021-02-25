package br.com.bcredi.validation.impl;

import java.util.List;

import br.com.bcredi.dto.request.impl.ErrorDtoImpl;
import br.com.bcredi.model.Proposal;
import br.com.bcredi.model.ValidationErrorCode;
import br.com.bcredi.model.WarrantyProvince;
import br.com.bcredi.validation.AbstractValidation;

public class WarrantiesProvinceAcceptedValidationImpl extends AbstractValidation {

	private static final long serialVersionUID = -3062462506200238500L;

	@Override
	public void validate(Proposal proposal) {
		errorDto = null;
		if (proposal
				.isWarrantiesProvinceNotIn(List.of(WarrantyProvince.PR, WarrantyProvince.SC, WarrantyProvince.RS))) {
			return;
		}
		errorDto = new ErrorDtoImpl(ValidationErrorCode.WARRANTIES_PROVINCE_ACCEPTED.getCode(),
				"As garantias de imóvel dos estados PR, SC e RS não são aceitas", "warrantiesProvince");

	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WarrantiesProvinceAcceptedValidation []";
	}

}
