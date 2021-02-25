package br.com.bcredi.parser.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import br.com.bcredi.parser.TxtRowParseable;

public class TxtRowParseableImpl implements TxtRowParseable {

	private static final long serialVersionUID = -8882991517331137713L;

	private final String[] row;

	public TxtRowParseableImpl(String[] row) {
		this.row = row;
	}

	@Override
	public String getString(int position) {
		return row[position];
	}

	@Override
	public BigDecimal getBigDecimal(int position) {
		return new BigDecimal(row[position]);
	}

	@Override
	public int getInt(int position) {
		return Integer.parseInt(row[position]);
	}

	@Override
	public LocalDateTime getLocalDateTime(int position) {
		return LocalDateTime.parse(row[position], DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
	}

	@Override
	public boolean getBoolean(int position) {
		return Boolean.parseBoolean(row[position]);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(row);
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
		TxtRowParseableImpl other = (TxtRowParseableImpl) obj;
		if (!Arrays.equals(row, other.row))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TxtRowParseableImpl [row=" + Arrays.toString(row) + "]";
	}

}
