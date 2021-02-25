package br.com.bcredi.dto.request;

import java.io.Serializable;

public interface ErrorDto extends Serializable {

	long getCode();

	String getMessage();

	String getField();

}