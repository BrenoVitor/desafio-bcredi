package br.com.bcredi.parser;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface Parseable extends Serializable {

	String getString(int position);

	BigDecimal getBigDecimal(int position);

	int getInt(int position);

	LocalDateTime getLocalDateTime(int position);

	boolean getBoolean(int position);

}
