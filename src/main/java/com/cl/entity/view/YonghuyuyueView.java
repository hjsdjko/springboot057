package com.cl.entity.view;

import com.cl.entity.YonghuyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 用户预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
@TableName("yonghuyuyue")
public class YonghuyuyueView  extends YonghuyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YonghuyuyueView(){
	}
 
 	public YonghuyuyueView(YonghuyuyueEntity yonghuyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, yonghuyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
