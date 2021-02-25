package br.com.bcredi.builder.impl;

import br.com.bcredi.builder.EventDtoBuilder;
import br.com.bcredi.dto.request.ProposalEventDto;
import br.com.bcredi.dto.request.ProposalsEventDto;
import br.com.bcredi.parser.Parseable;
import br.com.bcredi.parser.Parser;

public class EventDtoProposalEventDtoBuilderImpl implements EventDtoBuilder<Parseable> {

	private static final long serialVersionUID = -9157459519944363784L;

	private final Parser<ProposalEventDto> parser;

	public EventDtoProposalEventDtoBuilderImpl(Parser<ProposalEventDto> txtRowParser) {
		this.parser = txtRowParser;
	}

	@Override
	public ProposalEventDto build(Parseable value, ProposalsEventDto proposalsEventDto) {
		ProposalEventDto proposalEventDto = proposalsEventDto.getProposalEventDto(value.getString(4));
		ProposalEventDto newProposalEventDto = parser.parse(value);
		if (proposalEventDto != null) {
			newProposalEventDto.addProponentEventDto(proposalEventDto.getProponentsEventDto());
			newProposalEventDto.addWarrantyEventDto(proposalEventDto.getWarrantiesEventDto());
		}
		return newProposalEventDto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parser == null) ? 0 : parser.hashCode());
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
		EventDtoProposalEventDtoBuilderImpl other = (EventDtoProposalEventDtoBuilderImpl) obj;
		if (parser == null) {
			if (other.parser != null)
				return false;
		} else if (!parser.equals(other.parser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventDtoProposalEventDtoBuilderImpl [parser=" + parser + "]";
	}

}