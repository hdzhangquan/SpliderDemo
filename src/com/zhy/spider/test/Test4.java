package com.zhy.spider.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.zhy.spider.bean.LinkTypeData;
import com.zhy.spider.core.ExtractService;
import com.zhy.spider.rule.Rule;

public class Test4
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
			lis.add(data.getImage());
			//System.out.println(data.getContent());
			/*System.out.println(data.getSummary());
			System.out.println(data.getLinkText());
			System.out.println(data.getLinkHref());*/
			//System.out.println("***********************************");
		}
		try {
			for (String string : lis) {
				//jdbc(string);
				FileOutputStream fos = new FileOutputStream("d:\\allCode2.txt",true);
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
	@Test
	public void xunhuan() {
		for (int i = 0; i < 40; i++) {
			getDatasByCssQueryUserBaidu(i);
		}
	}
	
	//@org.junit.Test  
	public void getDatasByCssQueryUserBaidu(int num)  
	{  
		//String url = "http://www.fangan100.com/fangan/search.php";
	    Rule rule = new Rule("http://www.fangan100.com/fangan/search.php?kw=&fields=0&catid=0&order=0&x=36&y=25&page="+num,null, 
	    		null,null, -1, Rule.GET);  
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
			lis.add(data.getImage());
			//System.out.println(data.getImage());
			//System.out.println(data.getContent());
			/*System.out.println(data.getSummary());
			System.out.println(data.getLinkText());
			System.out.println(data.getLinkHref());*/
			//System.out.println("***********************************");
		}
		try {
			for (String string : lis) {
				FileOutputStream fos = new FileOutputStream("d:\\1.txt",true);
				byte[] bytes = string.getBytes();
				fos.write(bytes);
				fos.write("\r\n".getBytes());
				fos.close();
			}
		} catch (Exception e) {
			
		}
	}
	
	public void jdbc(String s) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "123";
		Connection con = DriverManager.getConnection(url,username,password);
		
		Statement stmt = con.createStatement();
		// 2. 使用Statement发送sql语句！
//		String sql = "INSERT INTO stu VALUES('ITCAST_0003', 'wangWu', 88, 'male')";
//		String sql = "UPDATE stu SET name='zhaoLiu', age=22, " +
//				"gender='female' WHERE number='ITCAST_0003'";
		String sql = "INSERT INTO test3 VALUES ('" + s + "')";
		stmt.executeUpdate(sql);
	}
	
}
