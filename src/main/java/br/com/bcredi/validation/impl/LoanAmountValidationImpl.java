package br.com.bcredi.validation.impl;

import java.math.BigDecimal;

import br.com.bcredi.dto.request.impl.ErrorDtoImpl;
import br.com.bcredi.model.Proposal;
import br.com.bcredi.model.ValidationErrorCode;
import br.com.bcredi.validation.AbstractValidation;

public class LoanAmountValidationImpl extends AbstractValidation {

	private static final long serialVersionUID = -8449499278750242526L;

	@Override
	public void validate(Proposal proposal) {
		errorDto = null;
		if (proposal.isProposalLoanValueBetween(new BigDecimal("30000"), new BigDecimal("3000000"))) {
			return;
		}

		errorDto = new ErrorDtoImpl(ValidationErrorCode.LOAN_AMOUNT.getCode(),
				"O valor do empréstimo deve estar entre R$ 30.000,00 e R$ 3.000.000,00", "proposalLoanValue");

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
		return "LoanAmountValidation []";
	}

}
