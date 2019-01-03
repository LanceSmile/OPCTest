package com.bosch.service.OPCImpl;


import com.bosch.pojo.OpcServerList;
import com.bosch.service.OpcServerService;
import org.jinterop.dcom.common.JIException;
import org.openscada.opc.dcom.list.ClassDetails;
import org.openscada.opc.lib.list.Categories;
import org.openscada.opc.lib.list.Category;
import org.openscada.opc.lib.list.ServerList;

import java.net.UnknownHostException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OpcServerServiceImpl implements OpcServerService {

    @Override
    public Map<Integer, OpcServerList> showAllServers(String host, String user, String password, String domain) throws JIException, UnknownHostException {

        ServerList serverList;
        serverList = new ServerList(host,user,password,domain);
        OpcServerList opcServerList;

        Collection<ClassDetails> classDetails = serverList.listServersWithDetails(new Category[] {
                Categories.OPCDAServer10, Categories.OPCDAServer20,
                Categories.OPCDAServer30 }, new Category[] {});
        Map<Integer, OpcServerList> map=new HashMap<>();

        int k=0;
        for (ClassDetails cds : classDetails) {
            opcServerList=new OpcServerList();
            opcServerList.setCLid(cds.getClsId());
            opcServerList.setProID(cds.getProgId());

            map.put(k,opcServerList);
            k++;
            System.out.println(cds.getProgId() + "=" + cds.getDescription()+" clsid="+cds.getClsId());
        }
        return map;
    }
}
