package com.csw.service;

import com.csw.dao.FileDao;
import com.csw.entity.File1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019/10/25.
 */
@Service
@Transactional
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<File1> queryAll() {
        return fileDao.queryAll();
    }

    @Override
    public void addFile(File1 file1) {
        fileDao.addFile(file1);
    }

    @Override
    public void delete(String id) {
        fileDao.delete(id);
    }

    @Override
    public File1 queryById(String id) {
        return fileDao.queryById(id);
    }

    @Override
    public void updateCount(File1 ff) {
        fileDao.updateCount(ff);
    }
}
