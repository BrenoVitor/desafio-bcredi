package br.com.bcredi.parser.impl;

import br.com.bcredi.dto.request.EventDto;
import br.com.bcredi.dto.request.impl.EventDtoImpl;
import br.com.bcredi.model.EventAction;
import br.com.bcredi.model.EventSchema;
import br.com.bcredi.parser.Parseable;
import br.com.bcredi.parser.TxtRowParser;

public class EventDtoTxtRowParserImpl implements TxtRowParser<EventDto> {

	private static final long serialVersionUID = 3089678796072626045L;

	@Override
	public EventDto parse(Parseable value) {
		return new EventDtoImpl(value.getString(0), EventSchema.valueOfSchema(value.getString(1)),
				EventAction.valueOfAction(value.getString(1) + "." + value.getString(2)), value.getLocalDateTime(3));
	}

	@Override
	public String toString() {
		return "EventDtoTxtRowParser []";
	}

}
