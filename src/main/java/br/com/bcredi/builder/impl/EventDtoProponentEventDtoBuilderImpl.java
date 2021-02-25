package br.com.bcredi.builder.impl;

import br.com.bcredi.builder.EventDtoBuilder;
import br.com.bcredi.dto.request.ProponentEventDto;
import br.com.bcredi.dto.request.ProposalEventDto;
import br.com.bcredi.dto.request.ProposalsEventDto;
import br.com.bcredi.dto.request.impl.ProposalEventDtoImpl;
import br.com.bcredi.parser.Parseable;
import br.com.bcredi.parser.Parser;

public class EventDtoProponentEventDtoBuilderImpl implements EventDtoBuilder<Parseable> {

	private static final long serialVersionUID = 5368055425741877562L;

	private final Parser<ProponentEventDto> parser;

	public EventDtoProponentEventDtoBuilderImpl(Parser<ProponentEventDto> txtRowParser) {
		this.parser = txtRowParser;
	}

	@Override
	public ProposalEventDto build(Parseable value, ProposalsEventDto proposalsEventDto) {
		ProposalEventDto proposalEventDto = proposalsEventDto.getProposalEventDto(value.getString(4));
		if (proposalEventDto == null) {
			proposalEventDto = new ProposalEventDtoImpl(value.getString(4));
		}
		proposalEventDto.addProponentEventDto(parser.parse(value));
		return proposalEventDto;
	}

	@Override
	public String toString() {
		return "EventDtoProponentEventDtoBuilderImpl [parser=" + parser + "]";
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
		EventDtoProponentEventDtoBuilderImpl other = (EventDtoProponentEventDtoBuilderImpl) obj;
		if (parser == null) {
			if (other.parser != null)
				return false;
		} else if (!parser.equals(other.parser))
			return false;
		return true;
	}

}