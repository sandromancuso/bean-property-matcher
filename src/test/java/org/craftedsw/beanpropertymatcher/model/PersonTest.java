package org.craftedsw.beanpropertymatcher.model;

import static org.craftedsw.beanpropertymatcher.matcher.BeanMatcher.has;
import static org.craftedsw.beanpropertymatcher.matcher.BeanPropertyMatcher.property;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.Test;

public class PersonTest {
	
	@Test public void
	should_have_mutable_properties() {
		Person person = new Person();
		
		person.setFirstName("Sandro");
		person.setAge(25);
		person.setLastName("Mancuso");
		
		assertThat(person, has(
								property("firstName", equalTo("Sandro")),
								property("age", greaterThan(18)),
								property("lastName", equalTo("Mancuso"))));
	}

}
