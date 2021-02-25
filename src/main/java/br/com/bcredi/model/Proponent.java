package br.com.bcredi.model;

import java.io.Serializable;
import java.math.BigDecimal;

public interface Proponent extends Serializable {

	boolean isProponentIsMain();

	boolean isOlderThan(int age);

	boolean isYoungerThan(int age);

	int getProponentAge();

	boolean isProponentAgeBetween(int minimumAge, int maximumAge);

	BigDecimal getProponentMonthlyIncome();

	boolean isProponentMonthlyIncomeMoreThan(BigDecimal value);

	String getProponentId();

	String getProponentName();

}