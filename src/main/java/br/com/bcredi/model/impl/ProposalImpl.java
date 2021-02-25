package br.com.bcredi.model.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

import br.com.bcredi.model.Proponent;
import br.com.bcredi.model.Proponents;
import br.com.bcredi.model.Proposal;
import br.com.bcredi.model.Warranties;
import br.com.bcredi.model.Warranty;
import br.com.bcredi.model.WarrantyProvince;
import br.com.bcredi.util.BigDecimalCompareUtil;

public class ProposalImpl implements Proposal {

	private static final long serialVersionUID = 1L;

	private final String proposalId;

	private BigDecimal proposalLoanValue;

	private Integer proposalNumberOfMonthlyInstallments;

	private Warranties warranties;

	private Proponents proponents;

	public ProposalImpl(String proposalId, BigDecimal proposalLoanValue, int proposalNumberOfMonthlyInstallments) {
		this(proposalId);
		this.setProposalLoanValue(proposalLoanValue);
		this.setProposalNumberOfMonthlyInstallments(proposalNumberOfMonthlyInstallments);
	}

	public ProposalImpl(String proposalId) {
		this.proposalId = proposalId;
		this.warranties = new WarrantiesImpl();
		this.proponents = new ProponentsImpl();
	}

	@Override
	public void addWarranty(Warranty warranty) {
		this.warranties.addWarranty(warranty);
	}

	@Override
	public void addProponent(Proponent proponent) {
		this.proponents.addProponent(proponent);
	}

	@Override
	public void removeWarranty(Warranty warranty) {
		this.warranties.removeWarranty(warranty);
	}

	@Override
	public void removeProponent(Proponent proponent) {
		this.proponents.removeProponent(proponent);
	}

	@Override
	public String getProposalId() {
		return proposalId;
	}

	@Override
	public BigDecimal getProposalLoanValue() {
		return proposalLoanValue;
	}

	@Override
	public void setProposalLoanValue(BigDecimal proposalLoanValue) {
		this.proposalLoanValue = proposalLoanValue;
	}

	@Override
	public int getProposalNumberOfMonthlyInstallments() {
		return proposalNumberOfMonthlyInstallments;
	}

	@Override
	public void setProposalNumberOfMonthlyInstallments(int proposalNumberOfMonthlyInstallments) {
		this.proposalNumberOfMonthlyInstallments = proposalNumberOfMonthlyInstallments;
	}

	@Override
	public boolean isProposalLoanValueBetween(BigDecimal minimumValue, BigDecimal maximumValue) {
		return proposalLoanValue.compareTo(minimumValue) >= BigDecimalCompareUtil.EQUALITY_SYMBOL.getValue()
				&& proposalLoanValue.compareTo(maximumValue) <= BigDecimalCompareUtil.EQUALITY_SYMBOL.getValue();
	}

	@Override
	public boolean isProposalNumberOfMonthlyInstallmentsBetween(int minimumValue, int maximumValue) {
		return proposalNumberOfMonthlyInstallments.compareTo(minimumValue) >= BigDecimalCompareUtil.EQUALITY_SYMBOL
				.getValue()
				&& proposalNumberOfMonthlyInstallments.compareTo(maximumValue) <= BigDecimalCompareUtil.EQUALITY_SYMBOL
						.getValue();
	}

	@Override
	public boolean isMinimumQuantityOfProponents(int minimumQuantity) {
		return proponents.isMinimumQuantityOfProponents(minimumQuantity);
	}

	@Override
	public boolean isMinimumQuantityOfWarranties(int minimumQuantity) {
		return warranties.isMinimumQuantityOfWarranties(minimumQuantity);
	}

	@Override
	public boolean isSumOfWarrantiesMoreThanProjectsProposalLoanValue(BigDecimal times) {
		return warranties.isSumOfWarrantiesMoreThanProjectsProposalLoanValue(getProjectsProposalLoanValue(times));
	}

	@Override
	public boolean isWarrantiesProvinceNotIn(Collection<WarrantyProvince> notAcceptedWarrantyProvinces) {
		return warranties.isWarrantiesProvinceNotIn(notAcceptedWarrantyProvinces);
	}

	@Override
	public boolean isProponentsMonthlyIncomeMoreThanProjectsProposalLoanMonthlyInstallmentsValueProponentAgeMoreThan(int age,
			BigDecimal times) {
		return proponents.isProponentsMonthlyIncomeMoreThanProjectsProposalLoanMonthlyInstallmentsValueProponentAgeMoreThan(age,
				getProjectsProposalLoanMonthlyInstallmentsValue(times));
	}

	private BigDecimal getProjectsProposalLoanMonthlyInstallmentsValue(BigDecimal times) {
		return proposalLoanValue.divide(new BigDecimal(proposalNumberOfMonthlyInstallments), RoundingMode.HALF_UP).multiply(times);
	}

	@Override
	public boolean isProponentsMonthlyIncomeMoreThanrojectsProposalLoanMonthlyInstallmentsValueProponentAgeBetween(int minimumAge,
			int maximumAge, BigDecimal times) {
		return proponents.isProponentsMonthlyIncomeMoreThanProjectsProposalLoanMonthlyInstallmentsValueProponentAgeBetween(minimumAge,
				maximumAge, getProjectsProposalLoanMonthlyInstallmentsValue(times));
	}

	@Override
	public BigDecimal getProjectsProposalLoanValue(BigDecimal times) {
		return proposalLoanValue.multiply(times);
	}

	@Override
	public boolean isExactQuantityOfMainProponents(int maximumQuantity) {
		return proponents.isExactQuantityOfMainProponents(maximumQuantity);
	}

	@Override
	public boolean isProponentsOlderThan(int age) {
		return proponents.isProponentsOlderThan(age);
	}

	@Override
	public Proponents getProponents() {
		return proponents;
	}

	@Override
	public void setProponents(Proponents proponents) {
		this.proponents = proponents;
	}

	@Override
	public String toString() {
		return "Proposal [proposalId=" + proposalId + ", proposalLoanValue=" + proposalLoanValue
				+ ", proposalNumberOfMonthlyInstallments=" + proposalNumberOfMonthlyInstallments + ", warranties="
				+ warranties + ", proponents=" + proponents + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((proponents == null) ? 0 : proponents.hashCode());
		result = prime * result + ((proposalId == null) ? 0 : proposalId.hashCode());
		result = prime * result + ((proposalLoanValue == null) ? 0 : proposalLoanValue.hashCode());
		result = prime * result
				+ ((proposalNumberOfMonthlyInstallments == null) ? 0 : proposalNumberOfMonthlyInstallments.hashCode());
		result = prime * result + ((warranties == null) ? 0 : warranties.hashCode());
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
		ProposalImpl other = (ProposalImpl) obj;
		if (proponents == null) {
			if (other.proponents != null)
				return false;
		} else if (!proponents.equals(other.proponents))
			return false;
		if (proposalId == null) {
			if (other.proposalId != null)
				return false;
		} else if (!proposalId.equals(other.proposalId))
			return false;
		if (proposalLoanValue == null) {
			if (other.proposalLoanValue != null)
				return false;
		} else if (!proposalLoanValue.equals(other.proposalLoanValue))
			return false;
		if (proposalNumberOfMonthlyInstallments == null) {
			if (other.proposalNumberOfMonthlyInstallments != null)
				return false;
		} else if (!proposalNumberOfMonthlyInstallments.equals(other.proposalNumberOfMonthlyInstallments))
			return false;
		if (warranties == null) {
			if (other.warranties != null)
				return false;
		} else if (!warranties.equals(other.warranties))
			return false;
		return true;
	}

}
