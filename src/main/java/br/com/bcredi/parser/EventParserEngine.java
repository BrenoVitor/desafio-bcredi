package br.com.bcredi.parser;

import java.io.Serializable;

import br.com.bcredi.dto.request.ProposalEventDto;
import br.com.bcredi.dto.request.ProposalsEventDto;
import br.com.bcredi.model.EventSchema;

public interface EventParserEngine extends Serializable {

	ProposalEventDto parse(Parseable eventParseable, EventSchema eventSchema, ProposalsEventDto proposalsEventDto);

}
