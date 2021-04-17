package com.csw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/10/25.
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class File1 extends Dir implements Serializable {
    private String id;// varchar2(99),
    private String oname;// varchar2(99),
    private String nname;// varchar2(99),
    private String z_file;//varchar2(10),
    private String path;//varchar2 (99),
    private String sizes;// varchar2(11),
    private String type;// varchar2(11),
    private String istrue;// varchar2(11),
    private String count;//\\ varchar2(999)
}
