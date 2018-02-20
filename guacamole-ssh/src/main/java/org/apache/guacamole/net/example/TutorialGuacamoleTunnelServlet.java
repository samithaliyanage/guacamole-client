package org.apache.guacamole.net.example;

import javax.servlet.http.HttpServletRequest;
import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.*;
import org.apache.guacamole.protocol.ConfiguredGuacamoleSocket;
import org.apache.guacamole.protocol.GuacamoleConfiguration;
import org.apache.guacamole.servlet.GuacamoleHTTPTunnelServlet;

public class TutorialGuacamoleTunnelServlet
    extends GuacamoleHTTPTunnelServlet {

  @Override
  protected GuacamoleTunnel doConnect(HttpServletRequest request)
      throws GuacamoleException {

    // Create our configuration
    GuacamoleConfiguration config = new GuacamoleConfiguration();
    config.setProtocol("ssh");
    config.setParameter("hostname", "oilpalm2.pti.indiana.edu");
    config.setParameter("port", "16032");
    config.setParameter("username", "dcuser");
    //config.setParameter("password", "dcuser");
    config.setParameter("private-key", "<PRIVATE_KEY_VALUE>");


    // Connect to guacd - everything is hard-coded here.
    GuacamoleSocket socket = new ConfiguredGuacamoleSocket(
        new SSLGuacamoleSocket("localhost", 4822),
        config
    );

    // Return a new tunnel which uses the connected socket
    return new SimpleGuacamoleTunnel(socket);

  }

}