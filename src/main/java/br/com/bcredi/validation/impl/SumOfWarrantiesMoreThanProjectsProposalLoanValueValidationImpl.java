package br.com.bcredi.validation.impl;

import java.math.BigDecimal;

import br.com.bcredi.dto.request.impl.ErrorDtoImpl;
import br.com.bcredi.model.Proposal;
import br.com.bcredi.model.ValidationErrorCode;
import br.com.bcredi.validation.AbstractValidation;

public class SumOfWarrantiesMoreThanProjectsProposalLoanValueValidationImpl extends AbstractValidation {

	private static final long serialVersionUID = 6277869435178870750L;

	@Override
	public void validate(Proposal proposal) {
		errorDto = null;
		if (proposal.isSumOfWarrantiesMoreThanProjectsProposalLoanValue(new BigDecimal(2))) {
			return;
		}
		errorDto = new ErrorDtoImpl(ValidationErrorCode.SUM_OF_WARRANTIES_VALUES.getCode(),
				"A soma do valor das garantias deve ser maior ou igual ao dobro do valor do empréstimo",
				"warrantyValue");

	}

	@Override
	public String toString() {
		return "SumOfWarrantiesMoreThanProjectsProposalLoanValueValidation []";
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
