package com.bosch.service;

import com.bosch.pojo.OpcLists;
import com.bosch.pojo.OpcServerList;
import org.jinterop.dcom.common.JIException;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

public interface OpcServerService {
    Map<Integer, OpcServerList> showAllServers(String host, String user, String password, String domain) throws JIException, UnknownHostException;
}
