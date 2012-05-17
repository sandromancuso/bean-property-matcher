package org.craftedsw.beanpropertymatcher.matcher;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;

public class BeanMatcher<T> extends BaseMatcher<T> {
	
	private Matcher<?>[] propertyMatchers;
	private Description expectedDescription = new StringDescription();
	private Description mismatchDescription = new StringDescription();

	public BeanMatcher(Matcher<?>... propertyMatchers) {
		this.propertyMatchers = propertyMatchers;
	}

	@Factory
	public static <T> BeanMatcher<T> has(Matcher<?>... propertyMatchers) {
		return new BeanMatcher<T>(propertyMatchers);
	}
	
	public boolean matches(Object item) {
		boolean matches = true;
		for (Matcher<?> matcher : propertyMatchers) {
			if (!matcher.matches(item)) {
				matches = false;
				appendDescriptions(item, matcher);
			}
		}
		return matches;
	}

	public void describeTo(Description description) {
		description.appendText(expectedDescription.toString());
	}

	@Override
	public void describeMismatch(Object item, Description description) {
		description.appendText(mismatchDescription.toString());
	}

	private void appendDescriptions(Object item, Matcher<?> matcher) {
		matcher.describeTo(expectedDescription);
		matcher.describeMismatch(item, mismatchDescription);
		mismatchDescription.appendText(" ");
	}
	
}
