package com.neway.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.neway.util.StrUtil;


/**
 * 文本框自定义标签
 * @author jiong.sun
 *
 */
public class TextTag extends TagSupport{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//id
	private String id;
	//name 属性
	private String name;
	//值
	private String value;
	//css样式名称
	private String className;
	//文本框默认提示内容
	private String placeholder;

	@Override
	public int doStartTag() throws JspException {
		
		JspWriter out = super.pageContext.getOut(); 
		try{
			//若name属性为空时，则那么与id一致
			if(StrUtil.nullToStr(name).equals("")){
				name = id;
			}
			String result ="<input type='text' name='"+name+"' id='"+id+"' ";
			//判断值是否为空
			if(!StrUtil.nullToStr(value).equals("")){
				result = result+" value='"+value+"'";
			}
			//判断css样式是否为空
			if(!StrUtil.nullToStr(className).equals("")){
				result = result+" class='"+className+"'";
			}
			//判断css样式是否为空
			if(!StrUtil.nullToStr(placeholder).equals("")){
				result = result+" placeholder='"+placeholder+"'";
			}
			result = result+">";
			out.println(result); 
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

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	
}
