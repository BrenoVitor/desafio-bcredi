package br.com.bcredi.validation.impl;

import br.com.bcredi.dto.request.impl.ErrorDtoImpl;
import br.com.bcredi.model.Proposal;
import br.com.bcredi.model.ValidationErrorCode;
import br.com.bcredi.validation.AbstractValidation;

public class CountOfMainProponentsValidationImpl extends AbstractValidation {

	private static final long serialVersionUID = 7823375271302465465L;

	@Override
	public void validate(Proposal proposal) {
		errorDto = null;
		if (proposal.isExactQuantityOfMainProponents(1)) {
			return;
		}

		errorDto = new ErrorDtoImpl(ValidationErrorCode.COUNT_OF_MAIN_PROPONENTS.getCode(),
				"Deve haver exatamente 1 proponente principal por proposta", "proponents");

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
		return "CountOfMainProponentsValidation []";
	}

}
