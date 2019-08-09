package junit.org.vaadin.tutorial.nano.jetty;

import org.junit.jupiter.api.Test;
import org.vaadin.tutorial.nano.jetty.CoreUIService;

public class CoreUIServiceTest {


  @Test
  void test001() throws Exception {
    final CoreUIService service = new CoreUIService();
    service.initServer();

    service.jetty.get().stop();


  }
}
