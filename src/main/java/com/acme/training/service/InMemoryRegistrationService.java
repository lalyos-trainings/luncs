package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.UserInfo;

@Component
public class InMemoryRegistrationService {
    Logger logger = LoggerFactory.getLogger(InMemoryRegistrationService.class);
    private int userIdCounter = 0;
    private Map<String, UserInfo> users = new HashMap<String, UserInfo>();
    
    public UserInfo getUserInfo(Integer userId) {
        Collection<UserInfo> usersCollection = users.values();
        
        for (UserInfo userInfo : usersCollection) {
            if (userInfo.getUserId() == userId) {
                return userInfo;
            }
        }
        
        return null;
    }
    
    public UserInfo getUserInfo(String userName) {
        return users.get(userName);
    }
    
    public int registerUser(String userName, Address billingAndDeliveryAddr) {
        return registerUser(userName, billingAndDeliveryAddr, new Address(billingAndDeliveryAddr));
    }
    
    public Integer registerUser(String userName, Address billingAddr, Address deliveryAddr) {
        Integer userId = null;
        UserInfo user = getUserInfo(userName);
        
        if (user == null) {
            userId = userIdCounter++;
            user = new UserInfo(userName, userId, billingAddr, deliveryAddr);
            users.put(userName, user);
            logger.info("New registration." +
                        "\n -UserName:     " + user.getUserName() +
                        "\n -userId:       " + user.getUserId() +
                        "\n -billingAddr:  " + user.getBillingAddr().toString() +
                        "\n -deliveryAddr: " + user.getDeliveryAddr().toString());
        }
        
        return userId;
    }
    

}
