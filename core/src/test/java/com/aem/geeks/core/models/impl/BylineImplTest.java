/*
 *  Copyright 2019 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.aem.geeks.core.models.impl;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aem.geeks.core.models.Byline;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
class BylineImplTest {

    private final AemContext ctx = new AemContext();

    @BeforeEach
    void setUp() throws Exception {
        /**/
        ctx.addModelsForClasses(BylineImpl.class);
        ctx.load()
           .json("/com/aem/geeks/core/models/impl/BylineImplTest.json", "/content");
    }

    @Test
    public void testGetName() {


        ctx.currentResource("/content/byline");
        Byline byline = ctx.request()
                           .adaptTo(Byline.class);

        String actual = byline.getName();
        String expected = "Murali";


        assertEquals(expected, actual);
    }

    @Test
    public void testGetOccupations() {
       /* List<String> expected = new ImmutableList.Builder<String>().add("Developer")
                                                                   .add("Scrum Master")
                                                                   .build();*/

        List<String> fromJson = Arrays.asList("Developer", "Scrum Master");

        ctx.currentResource("/content/byline_only_occupations");
        Byline byline = ctx.request()
                           .adaptTo(Byline.class);

        List<String> actual = byline.getOccupations();

        assertEquals(fromJson, actual);
    }

    @Test
    public void testNameMatch() {
        ctx.currentResource("/content/byline_only_name");
        Byline byline = ctx.request()
                           .adaptTo(Byline.class);
        String expected = "Ravi";
        String actual = byline.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void testEmpty() {
        ctx.currentResource("/content/empty");
        Byline byline = ctx.request()
                           .adaptTo(Byline.class);

        assertNull(byline.getName());
        assertTrue(byline.getOccupations().isEmpty());
    }

    @Test
    public void testEmptyOccupations() {
        ctx.currentResource("/content/byline_empty_occupations");
        Byline byline = ctx.request()
                           .adaptTo(Byline.class);
        boolean actual = byline.getOccupations()
                               .isEmpty();
        assertTrue(byline.getOccupations()
                         .isEmpty());
    }

}
