package com.aem.geeks.core.models.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aem.geeks.core.models.User;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class UserImplTest {

    AemContext aemContext = new AemContext();
    private User user;
    @BeforeEach
    public void setUp() {
        /*registering  the Sling Model to be tested into the mock AEM Context,
        so it can be instantiated in the @Test methods */

        aemContext.addModelsForClasses(UserImpl.class);

        aemContext.load()
                  .json("/com/aem/geeks/core/models/impl/User.json", "/UserComponent");
    }

    @Test
    @DisplayName("Testing component resource with all values")
    public void testComponentValues() {

        aemContext.currentResource("/UserComponent/user");
        user = aemContext.request()
                         .adaptTo(User.class);

        String actual =user.getUserName();

        Assertions.assertEquals("Pedapati",actual);

    }

    @Test
    @DisplayName("Testing component resource with Missing Phone Numbers")
    public void testComponentValuesV1() {
        aemContext.currentResource("/UserComponent/user-without-phone");
        user = aemContext.request()
                         .adaptTo(User.class);
        Assertions.assertEquals(null, user.getPhoneNumber());

    }

}
