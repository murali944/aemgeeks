package com.aem.geeks.core.models.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.geeks.core.models.Byline;

@Model(adaptables = { SlingHttpServletRequest.class },
       adapters = { Byline.class },
       resourceType = { BylineImpl.RESOURCE_TYPE },
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BylineImpl implements Byline {

    protected static final String RESOURCE_TYPE = "aemgeeks/components/content/byline";

    @Self
    private SlingHttpServletRequest request;

    @ValueMapValue
    private String name;

    @ValueMapValue
    private List<String> occupations;

    // Add a logger for any errors
    private static final Logger LOGGER = LoggerFactory.getLogger(BylineImpl.class);

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getOccupations() {
        if (occupations != null) {
            Collections.sort(occupations);
            return new ArrayList<String>(occupations);
        } else {
            return Collections.emptyList();
        }
    }

}