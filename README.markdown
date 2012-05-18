Hamcrest matcher to match multiple attributes of an object within a single assertion.

How to use it
-------------

<pre>
    // Static imports
    
    import static org.craftedsw.beanpropertymatcher.matcher.BeanMatcher.has;
    import static org.craftedsw.beanpropertymatcher.matcher.BeanPropertyMatcher.property;
    <b>import static org.hamcrest.MatcherAssert.assertThat;</b>
    import static org.hamcrest.Matchers.equalTo;
    import static org.hamcrest.Matchers.greaterThan;

    // Imagine that you have a method that returns an object Person

    Person person = new Person();
    person.setFirstName("Sandro");
    person.setAge(25);
    person.setLastName("Mancuso");
    
    // Then you can test it like that
    
    assertThat(person, has(
                            <b><font color="red">property("firstName", equalTo("Another dude")),  // Mistmatch</font></b>
                            property("age", <b>greaterThan(18)</b>),  <font color="green">// Use any matcher</font> 
                            property("lastName", equalTo("Mancuso"))));
</pre>

If you run this test, you will get a message like

<pre>
    java.lang.AssertionError: 
        Expected: property "firstName" = "Another dude" 
        but: property "firstName" was "Sandro" 
</pre>
