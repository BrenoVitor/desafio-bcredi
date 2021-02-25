package br.com.bcredi.validation.impl;

import java.math.BigDecimal;

import br.com.bcredi.dto.request.impl.ErrorDtoImpl;
import br.com.bcredi.model.Proposal;
import br.com.bcredi.model.ValidationErrorCode;
import br.com.bcredi.validation.AbstractValidation;

public class ProponentsMonthlyIncomeAgeBetween18And24YearsOldValidationImpl extends AbstractValidation {

	private static final long serialVersionUID = -8166976774885333453L;

	@Override
	public void validate(Proposal proposal) {
		errorDto = null;
		if (proposal.isProponentsMonthlyIncomeMoreThanrojectsProposalLoanMonthlyInstallmentsValueProponentAgeBetween(18, 24,
				new BigDecimal(4))) {
			return;
		}

		errorDto = new ErrorDtoImpl(ValidationErrorCode.PROPONENTS_MONTHLY_INCOME.getCode(),
				"A renda do proponente principal deve ser pelo menos 4 vezes o valor da parcela do empréstimo, se a idade dele for entre 18 e 24 anos",
				"proponentMonthlyIncome");

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
		return "ProponentsMonthlyIncomeAgeBetween18And24YearsOldValidation []";
	}

}
