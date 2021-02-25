package br.com.bcredi.validation;

import java.io.Serializable;

import br.com.bcredi.dto.request.ErrorDto;
import br.com.bcredi.model.Proposal;

public interface Validation extends Serializable {
	
	void validate(Proposal proposal);
	
	boolean hasError();
	
	ErrorDto getError();

}
