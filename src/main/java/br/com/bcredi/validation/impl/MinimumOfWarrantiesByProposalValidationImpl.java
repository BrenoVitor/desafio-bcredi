package br.com.bcredi.validation.impl;

import br.com.bcredi.dto.request.impl.ErrorDtoImpl;
import br.com.bcredi.model.Proposal;
import br.com.bcredi.model.ValidationErrorCode;
import br.com.bcredi.validation.AbstractValidation;

public class MinimumOfWarrantiesByProposalValidationImpl extends AbstractValidation {

	private static final long serialVersionUID = 4347476772201080399L;

	@Override
	public void validate(Proposal proposal) {
		errorDto = null;
		if (proposal.isMinimumQuantityOfWarranties(1)) {
			return;
		}
		errorDto = new ErrorDtoImpl(ValidationErrorCode.MINIMUM_OF_WARRANTIES.getCode(),
				"Dever haver no mínimo 1 garantia de imóvel por proposta", "warranty");

	}

	@Override
	public String toString() {
		return "MinimumOfWarrantiesByProposalValidation []";
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
