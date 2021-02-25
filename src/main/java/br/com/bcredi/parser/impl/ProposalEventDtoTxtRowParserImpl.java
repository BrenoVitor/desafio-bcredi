package br.com.bcredi.parser.impl;

import br.com.bcredi.dto.request.EventDto;
import br.com.bcredi.dto.request.ProposalEventDto;
import br.com.bcredi.dto.request.impl.ProposalEventDtoImpl;
import br.com.bcredi.parser.Parseable;
import br.com.bcredi.parser.Parser;
import br.com.bcredi.parser.TxtRowParser;

public class ProposalEventDtoTxtRowParserImpl implements TxtRowParser<ProposalEventDto> {

	private static final long serialVersionUID = 6270306188802357984L;

	private final Parser<EventDto> parser;

	public ProposalEventDtoTxtRowParserImpl(Parser<EventDto> parser) {
		this.parser = parser;
	}

	@Override
	public ProposalEventDto parse(Parseable value) {
		return new ProposalEventDtoImpl(parser.parse(value), value.getString(4), value.getBigDecimal(5),
				value.getInt(6));
	}

	@Override
	public String toString() {
		return "ProposalEventDtoTxtRowParser [parser=" + parser + "]";
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
		ProposalEventDtoTxtRowParserImpl other = (ProposalEventDtoTxtRowParserImpl) obj;
		if (parser == null) {
			if (other.parser != null)
				return false;
		} else if (!parser.equals(other.parser))
			return false;
		return true;
	}

}
