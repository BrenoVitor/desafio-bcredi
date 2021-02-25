package br.com.bcredi.validation.impl;

import java.math.BigDecimal;

import br.com.bcredi.dto.request.impl.ErrorDtoImpl;
import br.com.bcredi.model.Proposal;
import br.com.bcredi.model.ValidationErrorCode;
import br.com.bcredi.validation.AbstractValidation;

public class ProponentsMonthlyIncomeAgeBetween25And50YearsOldValidationImpl extends AbstractValidation {

	private static final long serialVersionUID = -7758297250108238193L;

	@Override
	public void validate(Proposal proposal) {
		errorDto = null;
		if (proposal.isProponentsMonthlyIncomeMoreThanrojectsProposalLoanMonthlyInstallmentsValueProponentAgeBetween(25, 50,
				new BigDecimal(3))) {
			return;
		}

		errorDto = new ErrorDtoImpl(ValidationErrorCode.PROPONENTS_MONTHLY_INCOME.getCode(),
				"A renda do proponente principal deve ser pelo menos 3 vezes o valor da parcela do empréstimo, se a idade dele for entre 25 e 50 anos",
				"proponentMonthlyIncome");

	}

	@Override
	public String toString() {
		return "ProponentsMonthlyIncomeAgeBetween25And50YearsOldValidation []";
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
