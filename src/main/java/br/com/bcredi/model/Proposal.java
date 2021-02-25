package br.com.bcredi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

public interface Proposal extends Serializable {

	void addWarranty(Warranty warranty);

	void addProponent(Proponent proponent);

	void removeWarranty(Warranty warranty);

	void removeProponent(Proponent proponent);

	String getProposalId();

	BigDecimal getProposalLoanValue();

	void setProposalLoanValue(BigDecimal proposalLoanValue);

	int getProposalNumberOfMonthlyInstallments();

	void setProposalNumberOfMonthlyInstallments(int proposalNumberOfMonthlyInstallments);

	boolean isProposalLoanValueBetween(BigDecimal minimumValue, BigDecimal maximumValue);

	boolean isProposalNumberOfMonthlyInstallmentsBetween(int minimumValue, int maximumValue);

	boolean isMinimumQuantityOfProponents(int minimumQuantity);

	boolean isMinimumQuantityOfWarranties(int minimumQuantity);

	boolean isSumOfWarrantiesMoreThanProjectsProposalLoanValue(BigDecimal times);

	boolean isWarrantiesProvinceNotIn(Collection<WarrantyProvince> notAcceptedWarrantyProvinces);

	boolean isProponentsMonthlyIncomeMoreThanProjectsProposalLoanMonthlyInstallmentsValueProponentAgeMoreThan(int age,
			BigDecimal times);

	boolean isProponentsMonthlyIncomeMoreThanrojectsProposalLoanMonthlyInstallmentsValueProponentAgeBetween(
			int minimumAge, int maximumAge, BigDecimal times);

	BigDecimal getProjectsProposalLoanValue(BigDecimal times);

	boolean isExactQuantityOfMainProponents(int maximumQuantity);

	boolean isProponentsOlderThan(int age);

	Proponents getProponents();

	void setProponents(Proponents proponents);

}