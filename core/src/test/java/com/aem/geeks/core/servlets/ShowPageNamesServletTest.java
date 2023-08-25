package com.aem.geeks.core.servlets;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
class ShowPageNamesServletTest {

    private final AemContext context = new AemContext();
    ShowPageNamesServlet showPageNamesServlet=new ShowPageNamesServlet();
    MockSlingHttpServletRequest request;
    MockSlingHttpServletResponse response;
    ResourceResolver resourceResolver;

    @BeforeEach
    public void setUp() {
        request = context.request();
        response = context.response();
        resourceResolver=context.resourceResolver();
    }

    @Test
    void testDoGet() throws Exception {
        assertNotNull(request);
        assertNotNull(resourceResolver);
        assertNotNull(showPageNamesServlet);
    }

}
