package com.aem.geeks.core.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
class GeeksResourceTypesServletTest {

    AemContext aemContext = new AemContext();

    /*Method-1 :
    GeeksResourceTypesServlet servlet=new GeeksResourceTypesServlet();*/

    /*
    Method-2
    @InjectMocks
    private GeeksResourceTypesServlet servlet;*/

    GeeksResourceTypesServlet servlet;

    @BeforeEach
    void setUp() {
        this.servlet = this.aemContext.registerInjectActivateService(new GeeksResourceTypesServlet());
    }

    @Test
    void doGet() throws ServletException, IOException {
        //Creating in memory page using context object
        aemContext.build()
                  .resource("/content/aemgeeks/us/en/test", "jcr:title", "Welcome Page");

        /*Now we are going execute this resource*/
        aemContext.currentResource("/content/aemgeeks/us/en/test");

        /*Fetch request and response objects from context objecet*/
        MockSlingHttpServletRequest request = aemContext.request();
        MockSlingHttpServletResponse response = aemContext.response();

        String actualResName =request.getResource().getName();

        assertEquals("test",actualResName);

        assertNotNull(servlet);
        servlet.doGet(request, response);
        String expected = "Page Title = Welcome Page";
        String output = response.getOutputAsString();
        assertNotNull(output);

        assertEquals(expected, response.getOutputAsString());
    }

}