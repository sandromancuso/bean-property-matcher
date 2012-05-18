BeanMatcher 
-----------

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

Now, change the age check to:
<pre>
   property("age", <b>greaterThan(60)</b>) 
</pre>

Now you should get:

<pre>
    java.lang.AssertionError: 
    Expected: property "firstName" = "Another dude" , property "age" = a value greater than &lt;60&gt; 
    but: property "firstName" was "Sandro" , property "age" &lt;25&gt; was less than &lt;60&gt;
</pre>

Testing object graphs
---------------------

You can also do this

<pre>
    Person person = new Person();
    person.setFirstName("Sandro");
    person.setAge(35);
		
    Country uk = new Country();
    uk.setName("United Kingdom");
		
    Address address = new Address();
    address.setPostcode("1234556");
    address.setCity("London");
    <b>address.setCountry(uk);</b>
		
    <b>person.setAddress(address);</b>
		
    assertThat(person, has(
                            property("firstName", equalTo("Sandro")),
                            property("age", greaterThan(18)),
                            property("address.city", equalTo("London")),
                            property("address.postcode", equalTo("1234556")),
                            property("address.country.name", equalTo("United Kingdom"))));		

</pre>

Enjoy!!!