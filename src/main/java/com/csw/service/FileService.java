package com.csw.service;

import com.csw.entity.File1;

import java.util.List;

/**
 * Created by Administrator on 2019/10/25.
 */
public interface FileService {
    List<File1> queryAll();

    void addFile(File1 file1);

    void delete(String id);

    File1 queryById(String id);

    void updateCount(File1 ff);
}
