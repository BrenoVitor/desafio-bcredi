package br.com.bcredi.controller.impl;

import br.com.bcredi.controller.ProposalValidateController;
import br.com.bcredi.dto.request.EventDto;
import br.com.bcredi.dto.request.impl.ProposalsEventDtoImpl;
import br.com.bcredi.parser.EventParserEngine;
import br.com.bcredi.parser.Parseable;
import br.com.bcredi.parser.Parser;
import br.com.bcredi.parser.impl.TxtRowParseableImpl;
import br.com.bcredi.service.ValidateProposalService;

public class ProposalValidateControllerImpl implements ProposalValidateController {

	private static final long serialVersionUID = -2588106898580602051L;

	private final Parser<EventDto> eventDtoParser;

	private final EventParserEngine eventParserEngine;

	private final ValidateProposalService validateProposalService;

	public ProposalValidateControllerImpl(Parser<EventDto> eventDtoParser, EventParserEngine eventParserEngine,
			ValidateProposalService validateProposalService) {
		this.eventDtoParser = eventDtoParser;
		this.eventParserEngine = eventParserEngine;
		this.validateProposalService = validateProposalService;
	}

	public String validate(Iterable<String> messages) {
		ProposalsEventDtoImpl proposalsEventDto = new ProposalsEventDtoImpl();
		messages.forEach(message -> {
			Parseable txtRowParseable = new TxtRowParseableImpl(message.split(","));
			EventDto eventDto = eventDtoParser.parse(txtRowParseable);
			proposalsEventDto.setProposalEventDto(
					eventParserEngine.parse(txtRowParseable, eventDto.getEventSchema(), proposalsEventDto));
		});

		// TODO - Transformar o retorno uma estrutura de dados - DTO
		return validateProposalService.validate(proposalsEventDto).toString().replace("[", "").replace("]", "")
				.replace(" ", "");

	}

	@Override
	public String toString() {
		return "ProposalValidateControllerImpl [eventDtoParser=" + eventDtoParser + ", eventParserEngine="
				+ eventParserEngine + ", validateProposalService=" + validateProposalService + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventDtoParser == null) ? 0 : eventDtoParser.hashCode());
		result = prime * result + ((eventParserEngine == null) ? 0 : eventParserEngine.hashCode());
		result = prime * result + ((validateProposalService == null) ? 0 : validateProposalService.hashCode());
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
		ProposalValidateControllerImpl other = (ProposalValidateControllerImpl) obj;
		if (eventDtoParser == null) {
			if (other.eventDtoParser != null)
				return false;
		} else if (!eventDtoParser.equals(other.eventDtoParser))
			return false;
		if (eventParserEngine == null) {
			if (other.eventParserEngine != null)
				return false;
		} else if (!eventParserEngine.equals(other.eventParserEngine))
			return false;
		if (validateProposalService == null) {
			if (other.validateProposalService != null)
				return false;
		} else if (!validateProposalService.equals(other.validateProposalService))
			return false;
		return true;
	}

}
