package com.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;

import com.dbcon.StudentEntity;


public class JSONUtils
{

	public static <T> String toJSONString(List<T> list){
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}
	
	public static JSONArray toJSONObject( Iterator<StudentEntity> v ) {
		List<Object> data = new ArrayList<Object>();
		while(v.hasNext()) {
			StudentEntity studentEntity = (StudentEntity) v.next();
			Map<Object, Object> map = new HashMap<>();
			map.put("fullName", studentEntity.getFullName());
			map.put("account", studentEntity.getAccount());
			map.put("college", studentEntity.getCollege());
			map.put("major", studentEntity.getMajor());
			map.put("classNumber", studentEntity.getClassNumber());
			data.add(map);
		}
		
		JSONArray JSONdata = JSONArray.fromObject(data);
		return JSONdata;
	}
}