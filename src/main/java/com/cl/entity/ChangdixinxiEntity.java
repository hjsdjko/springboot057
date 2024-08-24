package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 场地信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
@TableName("changdixinxi")
public class ChangdixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChangdixinxiEntity() {
		
	}
	
	public ChangdixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 场地名称
	 */
					
	private String changdimingcheng;
	
	/**
	 * 场地图片
	 */
					
	private String changditupian;
	
	/**
	 * 场地面积
	 */
					
	private String changdimianji;
	
	/**
	 * 可约时间
	 */
					
	private String keyueshijian;
	
	/**
	 * 场地详情
	 */
					
	private String changdixiangqing;
	
	/**
	 * 可约状态
	 */
					
	private String keyuezhuangtai;
	
	/**
	 * 场地设施
	 */
					
	private String changdisheshi;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：场地名称
	 */
	public void setChangdimingcheng(String changdimingcheng) {
		this.changdimingcheng = changdimingcheng;
	}
	/**
	 * 获取：场地名称
	 */
	public String getChangdimingcheng() {
		return changdimingcheng;
	}
	/**
	 * 设置：场地图片
	 */
	public void setChangditupian(String changditupian) {
		this.changditupian = changditupian;
	}
	/**
	 * 获取：场地图片
	 */
	public String getChangditupian() {
		return changditupian;
	}
	/**
	 * 设置：场地面积
	 */
	public void setChangdimianji(String changdimianji) {
		this.changdimianji = changdimianji;
	}
	/**
	 * 获取：场地面积
	 */
	public String getChangdimianji() {
		return changdimianji;
	}
	/**
	 * 设置：可约时间
	 */
	public void setKeyueshijian(String keyueshijian) {
		this.keyueshijian = keyueshijian;
	}
	/**
	 * 获取：可约时间
	 */
	public String getKeyueshijian() {
		return keyueshijian;
	}
	/**
	 * 设置：场地详情
	 */
	public void setChangdixiangqing(String changdixiangqing) {
		this.changdixiangqing = changdixiangqing;
	}
	/**
	 * 获取：场地详情
	 */
	public String getChangdixiangqing() {
		return changdixiangqing;
	}
	/**
	 * 设置：可约状态
	 */
	public void setKeyuezhuangtai(String keyuezhuangtai) {
		this.keyuezhuangtai = keyuezhuangtai;
	}
	/**
	 * 获取：可约状态
	 */
	public String getKeyuezhuangtai() {
		return keyuezhuangtai;
	}
	/**
	 * 设置：场地设施
	 */
	public void setChangdisheshi(String changdisheshi) {
		this.changdisheshi = changdisheshi;
	}
	/**
	 * 获取：场地设施
	 */
	public String getChangdisheshi() {
		return changdisheshi;
	}

}
