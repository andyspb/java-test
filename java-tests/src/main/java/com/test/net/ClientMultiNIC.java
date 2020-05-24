package com.test.net;

import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

public class ClientMultiNIC {

  private static final Logger log = Logger.getLogger(ClientMultiNIC.class.getName());

  public static void main(String args[]) throws Exception {
    log.info(" >>> main() Welcome to Client side");

    ClientMultiNIC.run(5000);
  }

  public static void run(int port) throws Exception {
    log.info(" >>> run() port:" + port);
    List<InetAddress> addrList = new ArrayList<InetAddress>();
    Enumeration<NetworkInterface> interfaces = null;
    try {
      interfaces = NetworkInterface.getNetworkInterfaces();
    } catch (SocketException e) {
      e.printStackTrace();
    }

    InetAddress localhost = null;

    try {
      localhost = InetAddress.getByName("127.0.0.1");
      log.info("127.0.0.1 : " + localhost.toString());
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }

    while (interfaces.hasMoreElements()) {
      NetworkInterface ifc = interfaces.nextElement();
      Enumeration<InetAddress> addressesOfAnInterface = ifc.getInetAddresses();

      while (addressesOfAnInterface.hasMoreElements()) {
        InetAddress address = addressesOfAnInterface.nextElement();

        if (!address.equals(localhost) && !address.toString().contains(":")) {
          addrList.add(address);
          log.info("FOUND ADDRESS ON NIC: " + address.getHostAddress());
        }
      }
    }

    String addr = "localhost";

    Socket socket = null;
    try {
      log.info("create socket");
      socket = new Socket();
      log.info("connecting socket");
      socket.connect(new InetSocketAddress(addr, port));
    } catch (ConnectException e) {
      e.printStackTrace();
    } finally {
      log.info("finally: closing socket");
      socket.close();
    }
  }
}
