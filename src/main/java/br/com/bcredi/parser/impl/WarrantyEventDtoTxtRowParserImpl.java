package br.com.bcredi.parser.impl;

import br.com.bcredi.dto.request.EventDto;
import br.com.bcredi.dto.request.WarrantyEventDto;
import br.com.bcredi.dto.request.impl.WarrantyEventDtoImpl;
import br.com.bcredi.model.WarrantyProvince;
import br.com.bcredi.parser.Parseable;
import br.com.bcredi.parser.Parser;
import br.com.bcredi.parser.TxtRowParser;

public class WarrantyEventDtoTxtRowParserImpl implements TxtRowParser<WarrantyEventDto> {

	private static final long serialVersionUID = 3703957449110924309L;

	private final Parser<EventDto> parser;

	public WarrantyEventDtoTxtRowParserImpl(Parser<EventDto> parser) {
		this.parser = parser;
	}

	@Override
	public WarrantyEventDto parse(Parseable value) {
		return new WarrantyEventDtoImpl(parser.parse(value), value.getString(5), value.getBigDecimal(6),
				WarrantyProvince.valueOf(value.getString(7)));
	}

	@Override
	public String toString() {
		return "WarrantyEventDtoTxtRowParser [parser=" + parser + "]";
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
		WarrantyEventDtoTxtRowParserImpl other = (WarrantyEventDtoTxtRowParserImpl) obj;
		if (parser == null) {
			if (other.parser != null)
				return false;
		} else if (!parser.equals(other.parser))
			return false;
		return true;
	}
}
