package com.cl.entity.view;

import com.cl.entity.KechengyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 课程预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
@TableName("kechengyuyue")
public class KechengyuyueView  extends KechengyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KechengyuyueView(){
	}
 
 	public KechengyuyueView(KechengyuyueEntity kechengyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, kechengyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
