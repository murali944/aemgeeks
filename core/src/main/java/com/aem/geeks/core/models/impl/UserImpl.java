package com.aem.geeks.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.geeks.core.models.User;

@Model(adaptables = SlingHttpServletRequest.class,
       adapters = User.class,
       resourceType = UserImpl.RESOURCE_TYPE,
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserImpl implements User {

    final protected static String RESOURCE_TYPE="aemgeeks/components/content/user";

    @ValueMapValue
    private String userName;
    @ValueMapValue
    private String phoneNumber;
    @ValueMapValue
    private String city;
    @ValueMapValue
    private String state;
    @ValueMapValue
    private String country;

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public String getCountry() {
        return country;
    }

}
