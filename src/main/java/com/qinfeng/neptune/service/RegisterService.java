package com.qinfeng.neptune.service;

import com.qinfeng.neptune.dao.RegisterDao;
import com.qinfeng.neptune.entity.db.User;
import com.qinfeng.neptune.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RegisterService {

    @Autowired
    private RegisterDao registerDao;

    public boolean register(User user) throws IOException {
        user.setPassword(Util.encryptPassword(user.getUserId(), user.getPassword()));
        return registerDao.register(user);
    }
}
