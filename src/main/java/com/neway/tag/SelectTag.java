package com.neway.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.neway.util.StrUtil;

/**
 * 下拉框自定义标签
 * @author jiong.sun
 *
 */
public class SelectTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	//id
	private String id;
	//name 属性
	private String name;
	//值
	private String value;
	
	private String options;
	
	private String className;

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = super.pageContext.getOut(); 
		StringBuffer sb =new StringBuffer();
		
		//根据","切割字符串
		String[] opts = options.split(",");
		
		try{
			//判断name属性是否为空
			if(StrUtil.nullToStr(name).equals("")){
				name=id;
			}
			sb.append("<select id='"+id+"'"+" name='"+name+"'");
			//css样式是否为空
			if(!StrUtil.nullToStr(className).equals("")){
				sb.append(" class='"+className+"'");
			}
			//补全
			sb.append(">");
			sb.append("<option value=''>--请选择--</option>");
			
			for (int i = 0; i < opts.length; i++) {
				if(value.equals(opts[i]) ){
					sb.append("<option value='"+opts[i]+"' selected>"+opts[i]+"</option>");
				}else{
					sb.append("<option value='"+opts[i]+"'>"+opts[i]+"</option>");
				}
			}
			sb.append("</select>");
			out.println(sb.toString()); 
		}catch (Exception e) {
			e.printStackTrace();
		}
		return TagSupport.SKIP_BODY;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getClassName() {
		return className;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}
