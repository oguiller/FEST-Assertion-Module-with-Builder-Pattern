package com.guille.league;
import static com.guille.league.asserts.LeagueAssert.assertThat;
import static org.fest.assertions.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class LeagueTest {
	
	private League spanishLeague;
	private League englishLeague;
	private Club athleticClub;
	private Club realMadrid;
	private Club arsenal;
	
	@Before
	public void setUp(){
		athleticClub = new Club
							.ClubBuilder("Athletic Club", Country.SPAIN)
								.city("Bilbao")
								.alias("Los Leones")
								.build();
//		athleticClub.setName("Athletic Club");
//		athleticClub.setCountry(Country.SPAIN);
		
		realMadrid = new Club
							.ClubBuilder("Real Madrid", Country.SPAIN)
								.city("Madrid")
								.alias("Merengues")
								.build();
//		realMadrid.setName("Real Madrid");
//		realMadrid.setCountry(Country.SPAIN);
		
		arsenal = new Club
						.ClubBuilder("Arsenal", Country.ENGLAND)
							.city("London")
							.alias("gunners")
							.build();
//		arsenal.setName("Arsenal");
//		arsenal.setCity("London");
//		arsenal.setCountry(Country.ENGLAND);
	}
	
	@Test
	public void league_has_clubs(){
		spanishLeague = League.LeagueBuilder.buildSpanishLeague();
		spanishLeague.addClub(athleticClub);
		assertThat(spanishLeague.getClubs()).isNotEmpty();
	}
	
	@Test(expected = IllegalStateException.class)
	public void add_club_from_different_country_fails(){
		spanishLeague = League.LeagueBuilder.buildSpanishLeague();
		spanishLeague.addClub(arsenal);
		assertThat(spanishLeague.getClubs()).isEmpty();
	}
	
	@Test
	public void validate_league(){
		spanishLeague = League.LeagueBuilder.buildSpanishLeague();
		spanishLeague.addClub(athleticClub);
		spanishLeague.addClub(realMadrid);
		assertThat(spanishLeague).hasName("La Liga").takesPlaceIn(Country.SPAIN);
		
		// We are going to create now a League using the builder and identation
		englishLeague = new League
								.LeagueBuilder(Country.ENGLAND,"Premier League", new HashSet<Club>())
								.sponsor("Barclays")
								.build();
		englishLeague.addClub(arsenal);
		assertThat(englishLeague).hasName("Premier League").takesPlaceIn(Country.ENGLAND);
		
	}
}
