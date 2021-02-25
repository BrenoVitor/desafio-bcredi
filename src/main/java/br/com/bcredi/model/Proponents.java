package br.com.bcredi.model;

import java.io.Serializable;
import java.math.BigDecimal;

public interface Proponents extends Iterable<Proponent>, Serializable {

	void addProponent(Proponent proponent);

	void removeProponent(Proponent proponent);

	boolean isMinimumQuantityOfProponents(int minimumQuantity);

	boolean isProponentsOlderThan(int age);

	boolean isExactQuantityOfMainProponents(int maximumQuantity);

	boolean isProponentsMonthlyIncomeMoreThanProjectsProposalLoanMonthlyInstallmentsValueProponentAgeMoreThan(int age,
			BigDecimal times);

	boolean isProponentsMonthlyIncomeMoreThanProjectsProposalLoanMonthlyInstallmentsValueProponentAgeBetween(
			int minimumAge, int maximumAge, BigDecimal times);

}