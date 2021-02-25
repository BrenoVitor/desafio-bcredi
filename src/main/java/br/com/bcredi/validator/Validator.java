package br.com.bcredi.validator;

import java.io.Serializable;

import br.com.bcredi.dto.request.ErrorDto;
import br.com.bcredi.model.Proposal;

public interface Validator extends Serializable {

	boolean hasErros();

	Iterable<ErrorDto> getErros();

	void validate(Proposal proposal);

}
