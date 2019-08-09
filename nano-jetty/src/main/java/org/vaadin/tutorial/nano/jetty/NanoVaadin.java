/**
 * Copyright © 2017 Sven Ruppert (sven.ruppert@gmail.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.tutorial.nano.jetty;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import static java.lang.System.setProperty;


/**
 *
 */
public class NanoVaadin {
  private NanoVaadin() {
  }

  public static final String APM = "apm";

  public static final String CLI_HOST = "host";
  public static final String CLI_PORT = "port";

  public static void main(String[] args) throws ParseException {
    //init i18n
    final Options options = new Options();
    options.addOption(CLI_HOST, true, "host to use");
    options.addOption(CLI_PORT, true, "port to use");
    options.addOption(APM, false, "activate APM on");

    DefaultParser parser = new DefaultParser();
    CommandLine   cmd    = parser.parse(options, args);

    if (cmd.hasOption(CLI_HOST)) {
      setProperty(CoreUIService.CORE_UI_SERVER_HOST, cmd.getOptionValue(CLI_HOST));
    } if (cmd.hasOption(CLI_PORT)) {
      setProperty(CoreUIService.CORE_UI_SERVER_PORT, cmd.getOptionValue(CLI_PORT));
    } if(cmd.hasOption(APM)){
      //Stagemonitor.init();
    }
    new CoreUIService().startup();
  }
}
