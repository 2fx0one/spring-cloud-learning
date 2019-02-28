package com.tfx0one.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

  @Override
  public void insertFill(MetaObject metaObject) {
    System.out.println("插入方法实体填充");
    //!!! 注意这里是 fieldName 不是数据库名字
    setFieldValByName("createDate", new Date(), metaObject);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    System.out.println("更新方法实体填充");
    setFieldValByName("updateDate", new Date(), metaObject);
//    setFieldValByName("email", LocalDateTime, metaObject);
  }
}
