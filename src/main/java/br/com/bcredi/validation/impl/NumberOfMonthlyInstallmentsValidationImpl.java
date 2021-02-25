package br.com.bcredi.validation.impl;

import br.com.bcredi.dto.request.impl.ErrorDtoImpl;
import br.com.bcredi.model.Proposal;
import br.com.bcredi.model.ValidationErrorCode;
import br.com.bcredi.validation.AbstractValidation;

public class NumberOfMonthlyInstallmentsValidationImpl extends AbstractValidation {

	private static final long serialVersionUID = -8042439867597149194L;

	@Override
	public void validate(Proposal proposal) {
		errorDto = null;
		if (proposal.isProposalNumberOfMonthlyInstallmentsBetween(24, 180)) {
			return;
		}
		errorDto = new ErrorDtoImpl(ValidationErrorCode.NUMBER_OF_MONTHLY_INSTALLMENTS.getCode(),
				"O empréstimo deve ser pago em no mínimo 2 anos e no máximo 15 anos",
				"proposalNumberOfMonthlyInstallments");
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
		return "NumberOfMonthlyInstallmentsValidation []";
	}

}
