package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.XunliankechengEntity;
import com.cl.entity.view.XunliankechengView;

import com.cl.service.XunliankechengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 训练课程
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
@RestController
@RequestMapping("/xunliankecheng")
public class XunliankechengController {
    @Autowired
    private XunliankechengService xunliankechengService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XunliankechengEntity xunliankecheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaolian")) {
			xunliankecheng.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("huiyuan")) {
			xunliankecheng.setHuiyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XunliankechengEntity> ew = new EntityWrapper<XunliankechengEntity>();

		PageUtils page = xunliankechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xunliankecheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XunliankechengEntity xunliankecheng, 
		HttpServletRequest request){
        EntityWrapper<XunliankechengEntity> ew = new EntityWrapper<XunliankechengEntity>();

		PageUtils page = xunliankechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xunliankecheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XunliankechengEntity xunliankecheng){
       	EntityWrapper<XunliankechengEntity> ew = new EntityWrapper<XunliankechengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xunliankecheng, "xunliankecheng")); 
        return R.ok().put("data", xunliankechengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XunliankechengEntity xunliankecheng){
        EntityWrapper< XunliankechengEntity> ew = new EntityWrapper< XunliankechengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xunliankecheng, "xunliankecheng")); 
		XunliankechengView xunliankechengView =  xunliankechengService.selectView(ew);
		return R.ok("查询训练课程成功").put("data", xunliankechengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XunliankechengEntity xunliankecheng = xunliankechengService.selectById(id);
		xunliankecheng = xunliankechengService.selectView(new EntityWrapper<XunliankechengEntity>().eq("id", id));
        return R.ok().put("data", xunliankecheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XunliankechengEntity xunliankecheng = xunliankechengService.selectById(id);
		xunliankecheng = xunliankechengService.selectView(new EntityWrapper<XunliankechengEntity>().eq("id", id));
        return R.ok().put("data", xunliankecheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XunliankechengEntity xunliankecheng, HttpServletRequest request){
    	xunliankecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xunliankecheng);
        xunliankechengService.insert(xunliankecheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XunliankechengEntity xunliankecheng, HttpServletRequest request){
    	xunliankecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xunliankecheng);
        xunliankechengService.insert(xunliankecheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XunliankechengEntity xunliankecheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xunliankecheng);
        xunliankechengService.updateById(xunliankecheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xunliankechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
