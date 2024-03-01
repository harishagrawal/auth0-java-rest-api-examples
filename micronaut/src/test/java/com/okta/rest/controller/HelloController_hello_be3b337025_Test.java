package com.okta.rest.controller;

import org.junit.Assert;
import org.junit.Test;
import java.security.Principal;

public class HelloController_hello_be3b337025_Test {

    HelloController helloController = new HelloController();

    @Test
    public void testHelloWithValidPrincipal() {
        Principal validPrincipal = new Principal() {
            @Override
            public String getName() {
                return "John";
            }
        };
        Assert.assertEquals("Hello, John!", helloController.hello(validPrincipal));
    }

    @Test
    public void testHelloWithEmptyPrincipal() {
        Principal emptyPrincipal = new Principal() {
            @Override
            public String getName() {
                return "";
            }
        };
        Assert.assertEquals("Hello, !", helloController.hello(emptyPrincipal));
    }

    @Test
    public void testHelloWithSpecialCharacterPrincipal() {
        Principal specialCharPrincipal = new Principal() {
            @Override
            public String getName() {
                return "Jo@hn#";
            }
        };
        Assert.assertEquals("Hello, Jo@hn#!", helloController.hello(specialCharPrincipal));
    }

    @Test(expected = NullPointerException.class)
    public void testHelloWithNullPrincipal() {
        helloController.hello(null);
    }

    @Test
    public void testHelloWithPrincipalNameIncludingSpaces() {
        Principal spacePrincipal = new Principal() {
            @Override
            public String getName() {
                return "John Smith";
            }
        };
        Assert.assertEquals("Hello, John Smith!", helloController.hello(spacePrincipal));
    }

    @Test
    public void testHelloWithLongNamePrincipal() {
        Principal longNamePrincipal = new Principal() {
            @Override
            public String getName() {
                // TODO User is supposed to change the value
                return "a".repeat(10000);
            }
        };
        Assert.assertEquals("Hello, " + "a".repeat(10000) + "!", helloController.hello(longNamePrincipal));
    }

    // TODO: Write Performance Test
    // TODO: Write Security Test
}
