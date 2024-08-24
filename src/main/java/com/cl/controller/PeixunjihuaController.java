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

import com.cl.entity.PeixunjihuaEntity;
import com.cl.entity.view.PeixunjihuaView;

import com.cl.service.PeixunjihuaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 培训计划
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
@RestController
@RequestMapping("/peixunjihua")
public class PeixunjihuaController {
    @Autowired
    private PeixunjihuaService peixunjihuaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PeixunjihuaEntity peixunjihua,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaolian")) {
			peixunjihua.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PeixunjihuaEntity> ew = new EntityWrapper<PeixunjihuaEntity>();

		PageUtils page = peixunjihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peixunjihua), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PeixunjihuaEntity peixunjihua, 
		HttpServletRequest request){
        EntityWrapper<PeixunjihuaEntity> ew = new EntityWrapper<PeixunjihuaEntity>();

		PageUtils page = peixunjihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peixunjihua), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PeixunjihuaEntity peixunjihua){
       	EntityWrapper<PeixunjihuaEntity> ew = new EntityWrapper<PeixunjihuaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( peixunjihua, "peixunjihua")); 
        return R.ok().put("data", peixunjihuaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PeixunjihuaEntity peixunjihua){
        EntityWrapper< PeixunjihuaEntity> ew = new EntityWrapper< PeixunjihuaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( peixunjihua, "peixunjihua")); 
		PeixunjihuaView peixunjihuaView =  peixunjihuaService.selectView(ew);
		return R.ok("查询培训计划成功").put("data", peixunjihuaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PeixunjihuaEntity peixunjihua = peixunjihuaService.selectById(id);
		peixunjihua = peixunjihuaService.selectView(new EntityWrapper<PeixunjihuaEntity>().eq("id", id));
        return R.ok().put("data", peixunjihua);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PeixunjihuaEntity peixunjihua = peixunjihuaService.selectById(id);
		peixunjihua = peixunjihuaService.selectView(new EntityWrapper<PeixunjihuaEntity>().eq("id", id));
        return R.ok().put("data", peixunjihua);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PeixunjihuaEntity peixunjihua, HttpServletRequest request){
    	peixunjihua.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peixunjihua);
        peixunjihuaService.insert(peixunjihua);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PeixunjihuaEntity peixunjihua, HttpServletRequest request){
    	peixunjihua.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peixunjihua);
        peixunjihuaService.insert(peixunjihua);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PeixunjihuaEntity peixunjihua, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peixunjihua);
        peixunjihuaService.updateById(peixunjihua);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        peixunjihuaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
