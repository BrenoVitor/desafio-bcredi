package br.com.bcredi.parser;

import java.io.Serializable;

public interface Parser<T> extends Serializable {

	T parse(Parseable value);

}
