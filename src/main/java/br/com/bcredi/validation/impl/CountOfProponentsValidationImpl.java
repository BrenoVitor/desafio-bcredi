package br.com.bcredi.validation.impl;

import br.com.bcredi.dto.request.impl.ErrorDtoImpl;
import br.com.bcredi.model.Proposal;
import br.com.bcredi.model.ValidationErrorCode;
import br.com.bcredi.validation.AbstractValidation;

public class CountOfProponentsValidationImpl extends AbstractValidation {

	private static final long serialVersionUID = -3849553217484145401L;

	@Override
	public void validate(Proposal proposal) {
		errorDto = null;
		if (proposal.isMinimumQuantityOfProponents(2)) {
			return;
		}

		errorDto = new ErrorDtoImpl(ValidationErrorCode.COUNT_OF_PROPONENTS.getCode(),
				"Deve haver no mínimo 2 proponentes por proposta", "proponents");

	}

	@Override
	public String toString() {
		return "CountOfProponentsValidation []";
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
