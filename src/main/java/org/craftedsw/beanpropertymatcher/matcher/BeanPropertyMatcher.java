package org.craftedsw.beanpropertymatcher.matcher;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.beans.HasPropertyWithValue;

public class BeanPropertyMatcher<T> extends HasPropertyWithValue<T> {

	private String propertyName;
	private Matcher<?> valueMatcher;
	
	public BeanPropertyMatcher(String propertyName, Matcher<?> valueMatcher) {
		super(propertyName, valueMatcher);
		this.propertyName = propertyName;
		this.valueMatcher = valueMatcher;
	}

	@Factory
	public static <T> Matcher<T> property(String propertyName, Matcher<?> value) {
		return new BeanPropertyMatcher<T>(propertyName, value);
	}
	
	@Override
	public void describeTo(Description description) {
		 description.appendText("property ");
	     description.appendValue(propertyName);
	     description.appendText(" = ");
	     description.appendDescriptionOf(valueMatcher);
	     description.appendText(" ");
	}

}
