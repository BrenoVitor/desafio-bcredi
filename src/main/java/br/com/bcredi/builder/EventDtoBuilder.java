package br.com.bcredi.builder;

import java.io.Serializable;

import br.com.bcredi.dto.request.ProposalEventDto;
import br.com.bcredi.dto.request.ProposalsEventDto;
import br.com.bcredi.parser.Parseable;

public interface EventDtoBuilder<K extends Parseable> extends Serializable {
	
	ProposalEventDto build(K value, ProposalsEventDto proposalsDto);

}
