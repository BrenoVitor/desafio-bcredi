package br.com.bcredi.validator.impl;

import java.util.Collection;
import java.util.Iterator;

import br.com.bcredi.validation.Validation;
import br.com.bcredi.validator.ProposalValidations;

public class ProposalValidationsImpl implements ProposalValidations {

	private static final long serialVersionUID = -1864131917890048563L;

	private final Collection<Validation> validations;

	public ProposalValidationsImpl(Collection<Validation> validations) {
		this.validations = validations;
	}

	@Override
	public void addValidation(Validation validation) {
		this.validations.add(validation);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((validations == null) ? 0 : validations.hashCode());
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
		ProposalValidationsImpl other = (ProposalValidationsImpl) obj;
		if (validations == null) {
			if (other.validations != null)
				return false;
		} else if (!validations.equals(other.validations))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProposalValidations [validations=" + validations + "]";
	}

	@Override
	public Iterator<Validation> iterator() {
		return validations.iterator();
	}

}
