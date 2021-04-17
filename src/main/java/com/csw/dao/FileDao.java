package com.csw.dao;

import com.csw.entity.File1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/25.
 */
public interface FileDao {
    List<File1> queryAll();

    void addFile(@Param("f") File1 file1);

    void delete(@Param("id") String id);

    File1 queryById(@Param("id") String id);

    void updateCount(@Param("f") File1 ff);
}
