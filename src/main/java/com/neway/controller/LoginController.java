package com.neway.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class LoginController {

	
	@ResponseBody
	@RequestMapping(value="/doLogin")
	public String doLogin(HttpServletRequest request){
		String jsonStr="";
		//map���󣬴�ŷ�����Ϣ
		Map<String, Object> map =new HashMap<String, Object>();
		//jackson����
		ObjectMapper mapper =new ObjectMapper();
		try{
			//�ж��û��Ƿ����
			map.put("succeed", true);
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	
	@RequestMapping(value="/index")
	public String index(){
		return "test/testTld";
	}

	@RequestMapping(value="/yyy")
	public String yyy(){
		return "test/yyy";
	}
}
