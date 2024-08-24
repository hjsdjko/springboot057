package com.cl.entity.view;

import com.cl.entity.XunliankechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 训练课程
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
@TableName("xunliankecheng")
public class XunliankechengView  extends XunliankechengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XunliankechengView(){
	}
 
 	public XunliankechengView(XunliankechengEntity xunliankechengEntity){
 	try {
			BeanUtils.copyProperties(this, xunliankechengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
