package com.st.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {

    private BeanCopyUtils(){

    }

    //单个实体类的拷贝
    public static <T> T copyBean(Object source,Class<T> clazz){
        //创建目标对象
        T result = null;
        try {
            result = clazz.newInstance();
            //实现属性的拷贝
            BeanUtils.copyProperties(source,result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回结果
        return result;
    }

    public static <O,T> List<T> copyBeanList(List<O> list,Class<T> clazz){
        return list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }
}
