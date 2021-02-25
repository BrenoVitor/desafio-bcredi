package br.com.bcredi.validation.impl;

import br.com.bcredi.dto.request.impl.ErrorDtoImpl;
import br.com.bcredi.model.Proposal;
import br.com.bcredi.model.ValidationErrorCode;
import br.com.bcredi.validation.AbstractValidation;

public class ProponentAgeValidationImpl extends AbstractValidation {

	private static final long serialVersionUID = 7076809547894412808L;

	@Override
	public void validate(Proposal proposal) {
		errorDto = null;
		if (proposal.isProponentsOlderThan(18)) {
			return;
		}
		errorDto = new ErrorDtoImpl(ValidationErrorCode.PROPONENTS_AGE.getCode(),
				"Todos os proponentes devem ser maiores de 18 anos", "proponentAge");
	}

	@Override
	public String toString() {
		return "ProponentAgeValidation []";
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

}
