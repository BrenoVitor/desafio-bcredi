package br.com.bcredi.controller;

import java.io.Serializable;

public interface ProposalValidateController extends Serializable {

	String validate(Iterable<String> messages);

}
