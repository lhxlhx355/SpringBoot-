package com.example.demo.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class test {
	   @Autowired
	   private JdbcTemplate jdbcTemplate;
	   
	   @RequestMapping("/hello")
	   @ResponseBody
	   public ModelAndView getDbType( List<Map<String, Object>> list ){
	        String sql = "select * from tc_menu";
	        list =  jdbcTemplate.queryForList(sql);
	        
	        for (Map<String, Object> map : list) {
	            Set<Entry<String, Object>> entries = map.entrySet( );
	                if(entries != null) {
	                    Iterator<Entry<String, Object>> iterator = entries.iterator( );
	                    while(iterator.hasNext( )) {
	                    Entry<String, Object> entry =(Entry<String, Object>) iterator.next( );
	                    Object key = entry.getKey( );
	                    Object value = entry.getValue();
	                    System.out.println(key+":"+value);
	                }
	            }
	        }
	        ModelAndView mv = new ModelAndView("myTest");     
			return mv;
	    }
	   
}
