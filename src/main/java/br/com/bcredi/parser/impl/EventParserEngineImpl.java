package br.com.bcredi.parser.impl;

import java.util.Map;

import br.com.bcredi.builder.EventDtoBuilder;
import br.com.bcredi.dto.request.ProposalEventDto;
import br.com.bcredi.dto.request.ProposalsEventDto;
import br.com.bcredi.model.EventSchema;
import br.com.bcredi.parser.EventParserEngine;
import br.com.bcredi.parser.Parseable;

public class EventParserEngineImpl implements EventParserEngine {

	private static final long serialVersionUID = -7733807515180854339L;

	private final Map<EventSchema, EventDtoBuilder<Parseable>> parserUnity;

	public EventParserEngineImpl(Map<EventSchema, EventDtoBuilder<Parseable>> parserUnity) {
		this.parserUnity = parserUnity;
	}

	public ProposalEventDto parse(Parseable eventParseable, EventSchema eventSchema,
			ProposalsEventDto proposalsEventDto) {

		EventDtoBuilder<Parseable> builder = parserUnity.get(eventSchema);

		if (builder == null) {
			throw new RuntimeException("builder");
		}

		return builder.build(eventParseable, proposalsEventDto);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parserUnity == null) ? 0 : parserUnity.hashCode());
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
		EventParserEngineImpl other = (EventParserEngineImpl) obj;
		if (parserUnity == null) {
			if (other.parserUnity != null)
				return false;
		} else if (!parserUnity.equals(other.parserUnity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventParserEngineImpl [parserUnity=" + parserUnity + "]";
	}

}
