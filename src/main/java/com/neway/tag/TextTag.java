package com.neway.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.neway.util.StrUtil;


/**
 * �ı����Զ����ǩ
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
	//name ����
	private String name;
	//ֵ
	private String value;
	//css��ʽ����
	private String className;
	//�ı���Ĭ����ʾ����
	private String placeholder;

	@Override
	public int doStartTag() throws JspException {
		
		JspWriter out = super.pageContext.getOut(); 
		try{
			//��name����Ϊ��ʱ������ô��idһ��
			if(StrUtil.nullToStr(name).equals("")){
				name = id;
			}
			String result ="<input type='text' name='"+name+"' id='"+id+"' ";
			//�ж�ֵ�Ƿ�Ϊ��
			if(!StrUtil.nullToStr(value).equals("")){
				result = result+" value='"+value+"'";
			}
			//�ж�css��ʽ�Ƿ�Ϊ��
			if(!StrUtil.nullToStr(className).equals("")){
				result = result+" class='"+className+"'";
			}
			//�ж�css��ʽ�Ƿ�Ϊ��
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
