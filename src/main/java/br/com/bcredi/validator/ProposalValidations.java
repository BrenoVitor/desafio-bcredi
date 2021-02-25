package br.com.bcredi.validator;

import java.io.Serializable;

import br.com.bcredi.validation.Validation;

public interface ProposalValidations extends Serializable, Iterable<Validation> {

	void addValidation(Validation validation);

}