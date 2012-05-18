package org.craftedsw.beanpropertymatcher.model;

import static org.craftedsw.beanpropertymatcher.matcher.BeanMatcher.has;
import static org.craftedsw.beanpropertymatcher.matcher.BeanPropertyMatcher.property;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	
	private Person person;
	
	@Before 
	public void initialise() {
		this.person = new Person();
	}

	@Test public void
	should_have_properties_populated() {
		person.setFirstName("Sandro");
		person.setAge(25);
		person.setLastName("Mancuso");
		
		assertThat(person, has(
								property("firstName", equalTo("Sandro")),
								property("age", greaterThan(18)),
								property("lastName", equalTo("Mancuso"))));
	}
	
	@Test public void
	should_have_address_populated() {
		person.setFirstName("Sandro");
		person.setAge(35);
		
		Address address = new Address();
		address.setFirstLine("15 Some Street");
		address.setPostcode("1234556");
		address.setCity("London");
		address.setCountry("United Kingdom");
		
		person.setAddress(address);
		
		assertThat(person, has(
								property("firstName", equalTo("Sandro")),
								property("age", greaterThan(18)),
								property("address.city", equalTo("London")),
								property("address.postcode", equalTo("1234556"))));			
	}

}