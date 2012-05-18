Hamcrest matcher to match multiple attributes of an object within a single assertion.

How to use it:

<pre>
    // Static imports
    
    import static org.craftedsw.beanpropertymatcher.matcher.BeanMatcher.has;
    import static org.craftedsw.beanpropertymatcher.matcher.BeanPropertyMatcher.property;
    import static org.hamcrest.MatcherAssert.assertThat;
    import static org.hamcrest.Matchers.equalTo;
    import static org.hamcrest.Matchers.greaterThan;

    // Imagine that you have a method that returns an object Person

    Person person = new Person();
    person.setFirstName("Sandro");
    person.setAge(25);
    person.setLastName("Mancuso");
    
    // Then you can test it like that
    
    assertThat(person, has(
                            property("firstName", equalTo("Sandro")),
                            property("age", greaterThan(18)),
                            property("lastName", equalTo("Mancuso"))));
</pre>
