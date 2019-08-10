package junit.org.vaadin.tutorialnano.jetty.junit5;

import demo.DemoAppServlet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.vaadin.tutorial.nano.jetty.junit5.VaadinTutorial;
import org.vaadin.tutorial.nano.jetty.junit5.WebDriverParameterResolver.GenericPageObject;

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
