package br.com.bcredi.parser.impl;

import br.com.bcredi.dto.request.EventDto;
import br.com.bcredi.dto.request.ProponentEventDto;
import br.com.bcredi.dto.request.impl.ProponentEventDtoImpl;
import br.com.bcredi.parser.Parseable;
import br.com.bcredi.parser.Parser;
import br.com.bcredi.parser.TxtRowParser;

public class ProponentEventDtoTxtRowParserImpl implements TxtRowParser<ProponentEventDto> {

	private static final long serialVersionUID = 6985306255511097425L;

	private final Parser<EventDto> parser;

	public ProponentEventDtoTxtRowParserImpl(Parser<EventDto> parser) {
		this.parser = parser;
	}

	@Override
	public ProponentEventDto parse(Parseable value) {
		return new ProponentEventDtoImpl(value.getString(5), parser.parse(value), value.getString(6), value.getInt(7),
				value.getBigDecimal(8), value.getBoolean(9));
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
		ProponentEventDtoTxtRowParserImpl other = (ProponentEventDtoTxtRowParserImpl) obj;
		if (parser == null) {
			if (other.parser != null)
				return false;
		} else if (!parser.equals(other.parser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProponentEventDtoTxtRowParser [parser=" + parser + "]";
	}
}