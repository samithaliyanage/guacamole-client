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
    config.setParameter("private-key", "-----BEGIN RSA PRIVATE KEY-----\n" +
        "MIICXAIBAAKBgQDKDkrbngEtytdqVwaMbQLoiC+EV6Zmlf4pQ8rRCGy4AB3Rv8h+\n" +
        "6Fpkr8EGY1Zo65+BHf8H5sU5TK7D4Y4d+fZf9N48d1Celb4NzTh8Zup6rBIZUmvx\n" +
        "9eYOqTp09r35P9HC+Z1klryCoNYbvnzWuIG4fTdhODi777sH4KX/F0GVtQIDAQAB\n" +
        "AoGASwCJKwJ4v43G7pNFPAUPCk/bC44Zl4Tf5mNiursc2CQ67Wv6OZl4TF2tEfj3\n" +
        "z1R/Tcdbrowr83wSd2WXgmsR151qaiXrqcmHs89B8X/DHWXjxJAFq7Z8i3WgRRkC\n" +
        "goYLkpeKH1KtqWgUlzZXIyCl6uyAuCFaSTIVlF8wr7m8d/UCQQDzX8+xkvsVyOM1\n" +
        "ywAHXhfXRsdd0DqOrITE8Yq6nDxiEvRI361UZMD1Ct9WdI4CjCaawjOXV58ZHYGB\n" +
        "rwOFdNb/AkEA1Im99MASl5Z8GvX5tWwmy7tfYqs7BC1HknrJqZFMzvLWnP3rfQKh\n" +
        "/Ph2Q548ZppI7BcdS6hKqdHvw5vfenpnSwJAf2Kz9G9JayKmAp8JmdGfSvfqHGmE\n" +
        "bO9R4z/GbFygonjnUkl5kQXXlasmMTt6pUy0XCawGFQtm1i9U6LGhhEdAwJBAMOo\n" +
        "ekLSf0slseJwBw1JHv325HzE/XN+66ChgPylUnxBeejUqPFQdyeW4+ijxx79cZxG\n" +
        "OyXnK7TiG0OMP1NVU7kCQFPoObaIPx+4hQ4SMEybKPxBHgn2kzVU3BjhpmyMXSeA\n" +
        "TUY/DI5pyCTbUVvg3E2/IrESD0ppfHecAh9xWVFhZ+8=\n" +
        "-----END RSA PRIVATE KEY-----");


    // Connect to guacd - everything is hard-coded here.
    GuacamoleSocket socket = new ConfiguredGuacamoleSocket(
        new SSLGuacamoleSocket("localhost", 4822),
        config
    );

    // Return a new tunnel which uses the connected socket
    return new SimpleGuacamoleTunnel(socket);

  }

}