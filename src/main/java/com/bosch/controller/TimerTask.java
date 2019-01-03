package com.bosch.controller;

import com.bosch.pojo.OpcServerList;
import com.bosch.service.OPCImpl.OpcServerServiceImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TimerTask {
    @Scheduled(cron = "*/5 * * * * ?")
    public void showopc() throws Exception{
        System.out.println("do something...");
        OpcServerServiceImpl opcServerService=new OpcServerServiceImpl();
        Map<Integer, OpcServerList> map=opcServerService.showAllServers("192.168.0.100",
                "Opcuser","123456","");

        for(Map.Entry<Integer, OpcServerList> entry:map.entrySet()){
            System.out.println("key="+entry.getKey()+" "
                    +"clid="+entry.getValue().getCLid()+" proid="+entry.getValue().getProID()
            );
        }
    }
}
