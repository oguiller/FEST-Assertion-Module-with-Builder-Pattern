package com.guille.league.asserts;

import org.fest.assertions.*;

import com.guille.league.Country;
import com.guille.league.League;

public class LeagueAssert extends GenericAssert<LeagueAssert, League> {

	public LeagueAssert(League actual){
		super(LeagueAssert.class, actual);
	}
	
	public static LeagueAssert assertThat(League actual) {
		return new LeagueAssert(actual);
	}

	public LeagueAssert hasName(String name){
		isNotNull();
		Assertions.assertThat(actual.getName()).isEqualTo(name);
		return this;
	}
	
	public LeagueAssert takesPlaceIn(Country country){
		isNotNull();
		Assertions.assertThat(actual.getCountry()).isEqualTo(country);
		return this;
	}
}
