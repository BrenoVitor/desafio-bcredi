package br.com.bcredi.validator.impl;

import java.util.ArrayList;
import java.util.Collection;

import br.com.bcredi.dto.request.ErrorDto;
import br.com.bcredi.model.Proposal;
import br.com.bcredi.validator.Validator;

public class ProposalValidatorImpl implements Validator {

	private static final long serialVersionUID = -4512323083020555759L;

	private final ProposalValidationsImpl proposalValidations;

	private Collection<ErrorDto> errorsDto;

	public ProposalValidatorImpl(ProposalValidationsImpl proposalValidations) {
		this.proposalValidations = proposalValidations;
		this.errorsDto = new ArrayList<>();
	}

	@Override
	public void validate(Proposal proposal) {
		errorsDto = new ArrayList<>();
		proposalValidations.forEach(validation -> {
			validation.validate(proposal);
			if (validation.hasError()) {
				errorsDto.add(validation.getError());
			}
		});
	}

	@Override
	public boolean hasErros() {
		return !errorsDto.isEmpty();
	}

	@Override
	public Iterable<ErrorDto> getErros() {
		return errorsDto;
	}

	@Override
	public String toString() {
		return "ProposalValidator [proposalValidations=" + proposalValidations + ", errorsDto=" + errorsDto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errorsDto == null) ? 0 : errorsDto.hashCode());
		result = prime * result + ((proposalValidations == null) ? 0 : proposalValidations.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProposalValidatorImpl other = (ProposalValidatorImpl) obj;
		if (errorsDto == null) {
			if (other.errorsDto != null)
				return false;
		} else if (!errorsDto.equals(other.errorsDto))
			return false;
		if (proposalValidations == null) {
			if (other.proposalValidations != null)
				return false;
		} else if (!proposalValidations.equals(other.proposalValidations))
			return false;
		return true;
	}

}
