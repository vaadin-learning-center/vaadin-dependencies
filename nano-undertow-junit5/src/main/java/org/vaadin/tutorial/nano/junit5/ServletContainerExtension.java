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
       .get(CoreUIServiceJava.class.getSimpleName(), CoreUIServiceJava.class).jetty.ifPresent(server -> {
      try {
        server.stop();
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }
}
