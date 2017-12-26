package com.zhy.spider.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.zhy.spider.bean.LinkTypeData;
import com.zhy.spider.core.ExtractService;
import com.zhy.spider.rule.Rule;

public class Test3
{
	String url = "http://www.fangan100.com/fangan/search.php";
	File file =  new File("d:\\1.txt");
	FileWriter fw = null;
	@org.junit.Test
	public void getDatasByClass()
	{
		Rule rule = new Rule(
				"http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery",
		new String[] { "query.enterprisename","query.registationnumber" }, new String[] { "兴网","" },
				"cont_right", Rule.CLASS, Rule.POST);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts);
	}
	
	@org.junit.Test
	public void getDatasByClassTest1()
	{
		Rule rule = new Rule(
				"http://www.fangan100.com/",
		new String[] { "kw" }, new String[] { "智慧城市" },
				"catlist_li", Rule.CLASS, Rule.POST);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts);
	}
	
	@org.junit.Test
	public void getDatasByClassTest2()
	{
		Rule rule = new Rule(
				"http://solution.chinabyte.com/",
		new String[] { "keywords" }, new String[] { "电子" },
				"div.result-main", Rule.CLASS, Rule.GET);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts);
	}

	@org.junit.Test
	public void getDatasByCssQuery()
	{
		Rule rule = new Rule("http://www.11315.com/search",
				new String[] { "name" }, new String[] { "百度" },
				"div.g-mn div.con-model", Rule.SELECTION, Rule.GET);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts);
	}
	
	public void printf(List<LinkTypeData> datas)
	{
		for (LinkTypeData data : datas)
		{
			System.out.println(data.getContent());
			//System.out.println(data.getSummary());
			//System.out.println(data.getLinkText());
			//System.out.println(data.getLinkHref());
			//System.out.println("***********************************");
		}

	}

	public void printf2(List<LinkTypeData> datas)
	{
		List<String> lis = new ArrayList<String>();
		for (LinkTypeData data : datas)
		{
			lis.add(data.getContent());
			//System.out.println(data.getContent());
			/*System.out.println(data.getSummary());
			System.out.println(data.getLinkText());
			System.out.println(data.getLinkHref());*/
			//System.out.println("***********************************");
		}
		try {
			for (String string : lis) {
				FileOutputStream fos = new FileOutputStream("d:\\44.txt",true);
				byte[] bytes = string.getBytes();
				String s = "----------------------------------------";
				fos.write(bytes);
				fos.write("\r\n".getBytes());
				fos.write("\r\n".getBytes());
				fos.write(s.getBytes());
				fos.write("\r\n".getBytes());
				fos.write("\r\n".getBytes());
				fos.close();
			}
		} catch (Exception e) {
			
		}
		
	}
	
	@org.junit.Test  
	public void getDatasByCssQueryUserBaidu()  
	{  
		//String url = "http://www.fangan100.com/fangan/search.php";
	    Rule rule = new Rule("http://www.fangan100.com/fangan/search.php",new String[] { "kw" }, 
	    		new String[] { "智慧城市"},null, -1, Rule.GET);  
	    List<LinkTypeData> extracts = ExtractService.extract(rule);  
	    getDatasByCssQueryTest1(extracts);
	    //printf(extracts);  
	}  
	
	public void getDatasByCssQueryTest1(List<LinkTypeData> extracts)  
	{  
		/*List<LinkTypeData> l = new ArrayList<LinkTypeData>();
		l.add(null);
		extracts.removeAll(l);*/
		List<String> list = new ArrayList<String>();
		String linkHref = "";
		for (LinkTypeData linkTypeData : extracts) {
			if (linkTypeData.getLinkHref()!=null) {
				linkHref = linkTypeData.getLinkHref();
				list.add(linkHref);
				//System.out.println(linkTypeData.getLinkHref());
			}
		}
		List<String> list2 = new ArrayList<String>();
		for (int i = 29; i < 42; i++) {
			list2.add(list.get(i));
		}
		for (String string : list2) {
			//System.out.println(string);
			//t(string);
			//t2(string);
			t3(string);
		}
	    /*Rule rule = new Rule(linkHref,null, 
	    		null,"article", 1, Rule.GET); 
	    List<LinkTypeData> extracts2 = ExtractService.extract(rule);  
	    printf2(extracts2); */
	}  
	public void t(String linkHref) {
		Rule rule = new Rule(linkHref,null, 
	    		null,"introduce", Rule.CLASS, Rule.GET); 
	    List<LinkTypeData> extracts2 = ExtractService.extract(rule);  
	    printf2(extracts2); 
	}
	
	public void t2(String linkHref) {
		Rule rule = new Rule(linkHref,null, 
	    		null,"title", Rule.CLASS, Rule.GET); 
	    List<LinkTypeData> extracts2 = ExtractService.extract(rule);  
	    printf2(extracts2); 
	}
	public void t3(String linkHref) {
		Rule rule = new Rule(linkHref,null, 
	    		null,"content", Rule.CLASS, Rule.GET); 
	    List<LinkTypeData> extracts2 = ExtractService.extract(rule);  
	    printf2(extracts2); 
	}
	@Test
	public void tt() {
		Rule rule = new Rule("http://www.fangan100.com/fangan/1/529.html",null, 
	    		null,"content", Rule.CLASS, Rule.GET); 
	    List<LinkTypeData> extracts2 = ExtractService.extract(rule);  
	    //printf(extracts2);
	    List<String> lis = new ArrayList<String>();
		for (LinkTypeData data : extracts2)
		{
			lis.add(data.getContent());
			System.out.println(data.getContent());
			/*System.out.println(data.getSummary());
			System.out.println(data.getLinkText());
			System.out.println(data.getLinkHref());*/
			//System.out.println("***********************************");
		}
		try {
			for (String string : lis) {
				FileOutputStream fos = new FileOutputStream("d:\\3.txt",true);
				byte[] bytes = string.getBytes();
				fos.write(bytes);
				fos.write("\r\n".getBytes());
				fos.close();
			}
		} catch (Exception e) {
			
		}
	}
	
}
