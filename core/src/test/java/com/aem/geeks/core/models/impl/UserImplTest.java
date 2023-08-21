package com.aem.geeks.core.models.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aem.geeks.core.models.User;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class })
public class UserImplTest {

    AemContext aemContext = new AemContext();
    private User user;

    @BeforeEach
    public void setUp() {
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
        Assertions.assertEquals("Pedapati", user.getUserName());

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
