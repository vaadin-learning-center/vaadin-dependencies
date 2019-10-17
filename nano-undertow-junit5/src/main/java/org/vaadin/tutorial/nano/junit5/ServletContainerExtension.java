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
package org.vaadin.tutorial.nano.junit5;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.rapidpm.vaadin.nano.CoreUIServiceJava;


public class ServletContainerExtension
    implements BeforeEachCallback, AfterEachCallback {

  @Override
  public void beforeEach(ExtensionContext ctx) throws Exception {
    final CoreUIServiceJava uiService = new CoreUIServiceJava();
    uiService.startup();
    ctx.getStore(ExtensionContext.Namespace.GLOBAL)
       .put(CoreUIServiceJava.class.getSimpleName(), uiService);
  }


  @Override
  public void afterEach(ExtensionContext ctx) throws Exception {
    ctx.getStore(ExtensionContext.Namespace.GLOBAL)
       .get(CoreUIServiceJava.class.getSimpleName(), CoreUIServiceJava.class).undertow.ifPresent(server -> {
      try {
        server.stop();
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }
}
