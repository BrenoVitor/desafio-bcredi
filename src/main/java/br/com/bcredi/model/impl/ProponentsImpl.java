package br.com.bcredi.model.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.bcredi.model.Proponent;
import br.com.bcredi.model.Proponents;

public class ProponentsImpl implements Proponents {

	private static final long serialVersionUID = 1L;

	private final Collection<Proponent> proponents;

	public ProponentsImpl() {
		this.proponents = new HashSet<>();
	}

	@Override
	public Iterator<Proponent> iterator() {
		return proponents.iterator();
	}

	@Override
	public void addProponent(Proponent proponent) {
		this.proponents.add(proponent);
	}

	@Override
	public void removeProponent(Proponent proponent) {
		this.proponents.remove(proponent);
	}

	@Override
	public boolean isMinimumQuantityOfProponents(int minimumQuantity) {
		return getQuantityOfProponents() >= minimumQuantity;
	}

	private int getQuantityOfProponents() {
		return proponents.size();
	}

	@Override
	public boolean isProponentsOlderThan(int age) {
		return getProponentsStream().allMatch(proponent -> proponent.isOlderThan(age));
	}

	@Override
	public boolean isExactQuantityOfMainProponents(int maximumQuantity) {
		return getQuantityOfMainProponents() == maximumQuantity;
	}

	@Override
	public boolean isProponentsMonthlyIncomeMoreThanProjectsProposalLoanMonthlyInstallmentsValueProponentAgeMoreThan(
			int age, BigDecimal times) {
		return isProponentsMonthlyIncomeMoreThanProjectsProposalLoanMonthlyInstallmentsValueProponentAgeBase(
				getMainProponentsStream().filter(proponent -> proponent.isOlderThan(age)), times);
	}

	@Override
	public boolean isProponentsMonthlyIncomeMoreThanProjectsProposalLoanMonthlyInstallmentsValueProponentAgeBetween(
			int minimumAge, int maximumAge, BigDecimal times) {
		return isProponentsMonthlyIncomeMoreThanProjectsProposalLoanMonthlyInstallmentsValueProponentAgeBase(
				getMainProponentsStream().filter(proponent -> proponent.isProponentAgeBetween(minimumAge, maximumAge)),
				times);
	}

	private boolean isProponentsMonthlyIncomeMoreThanProjectsProposalLoanMonthlyInstallmentsValueProponentAgeBase(
			Stream<Proponent> proponents, BigDecimal rojectsProposalLoanMonthlyInstallmentsValue) {
		return proponents.allMatch(
				proponent -> proponent.isProponentMonthlyIncomeMoreThan(rojectsProposalLoanMonthlyInstallmentsValue));
	}

	private Stream<Proponent> getProponentsStream() {
		return proponents.stream();
	}

	private int getQuantityOfMainProponents() {
		return getMainProponents().size();
	}

	private Set<Proponent> getMainProponents() {
		return getMainProponentsStream().collect(Collectors.toSet());
	}

	private Stream<Proponent> getMainProponentsStream() {
		return getProponentsStream().filter(Proponent::isProponentIsMain);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((proponents == null) ? 0 : proponents.hashCode());
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
		ProponentsImpl other = (ProponentsImpl) obj;
		if (proponents == null) {
			if (other.proponents != null)
				return false;
		} else if (!proponents.equals(other.proponents))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProponentsImpl [proponents=" + proponents + "]";
	}

}
