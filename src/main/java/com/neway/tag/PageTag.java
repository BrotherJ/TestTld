package com.neway.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.neway.util.StrUtil;

/**
 * 分页Tag
 * @author jiong.sun
 *
 */
public class PageTag extends TagSupport{
	
	private static final long serialVersionUID = 1L;

	//第一页
	private int  first;
	//上一页
	private int  previous;
	//下一页
	private int  next;
	//最后一页
	private int  last;
	//css样式名称
	private String className;
	
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = super.pageContext.getOut(); 
		StringBuffer sb =new StringBuffer();
		try{
			sb.append("<nav>");
			sb.append("<ul class='"+StrUtil.nullToStr(className)+"'>");
			sb.append("<li><a href='#' onclick='goPage("+first+")'>First Page</a><li/>");
			sb.append("<li><a href='#' onclick='goPage("+previous+")'>Previous</a><li/>");
			sb.append("<li><a href='#' onclick='goPage("+next+")'>Next</a><li/>");
			sb.append("<li><a href='#' onclick='goPage("+last+")'>Last Page</a><li/>");
			sb.append("</ul>");
			sb.append("</nav>");
			out.println(sb.toString()); 
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return TagSupport.SKIP_BODY;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getPrevious() {
		return previous;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}
