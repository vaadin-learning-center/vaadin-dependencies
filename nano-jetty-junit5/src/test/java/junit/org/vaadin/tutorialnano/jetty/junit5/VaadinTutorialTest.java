/**
 * Copyright © 2019 Vaadin - Marketing Team - Developer Relations (devrel@vaadin.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package junit.org.vaadin.tutorialnano.jetty.junit5;

import demo.DemoAppServlet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.vaadin.tutorial.nano.junit5.VaadinTutorial;
import org.vaadin.tutorial.nano.junit5.WebDriverParameterResolver.GenericPageObject;

@VaadinTutorial
public class VaadinTutorialTest {

  @Test
  @Disabled
  void test001(GenericPageObject pageObject) {

    pageObject.getWebdriver().get("http://" + pageObject.getHostIpAddress() + ":8899/demo");
    final String pageSource = pageObject.getWebdriver()
                                        .getPageSource();

    Assertions.assertEquals(DemoAppServlet.RESPONSE_TEXT, pageSource);

  }
}
