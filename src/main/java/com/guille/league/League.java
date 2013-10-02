package com.guille.league;

import java.util.HashSet;
import java.util.Set;

public class League {
	
	private Set<Club> clubs;
	private Country country;
	private String name;
	private String sponsor;
	
	private League(LeagueBuilder builder){
		this.clubs = builder.clubs;
		this.country = builder.country;
		this.name = builder.name;
		this.sponsor = builder.sponsor;
	}

	public Set<Club> getClubs() {
		return clubs;
	}
	
	public void addClub(Club club){
		if(clubs == null){
			throw new IllegalStateException();
		}
		
		if(!club.getCountry().equals(country)){
			throw new IllegalStateException();
		}
		
		if(!clubs.add(club)){
			throw new IllegalStateException();
		}
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}
	
	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public static class LeagueBuilder implements Builder{
		
		private Set<Club> clubs;
		private Country country;
		private String name;
		private String sponsor;
		
		public LeagueBuilder(Country country, String name, Set<Club> clubs) {
			this.country = country;
			this.name = name;
			this.clubs = clubs;
		}
		
		public LeagueBuilder sponsor(String sponsor){
			this.sponsor = sponsor;
			return this;
		}
		
		public League build(){
			return new League(this);
		}
		
		public static League buildSpanishLeague(){
			return new League(new LeagueBuilder(Country.SPAIN, "La Liga", new HashSet<Club>()).sponsor("BBVA"));
		}
		
	}

}
