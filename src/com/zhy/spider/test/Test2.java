package com.zhy.spider.test;

import java.util.List;

import org.junit.Test;

import com.zhy.spider.bean.LinkTypeData;
import com.zhy.spider.core.ExtractService;
import com.zhy.spider.rule.Rule;

public class Test2
{
	String url = "http://www.fangan100.com/fangan/search.php";
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
			System.out.println(data.getLinkText());
			System.out.println(data.getLinkHref());
			System.out.println(data.getContent());
			System.out.println("***********************************");
		}

	}
	@org.junit.Test  
	public void getDatasByCssQueryUserBaidu()  
	{  
	    Rule rule = new Rule("http://www.fangan100.com/",new String[] { "kw" }, 
	    		new String[] { "智慧城市"},null, -1, Rule.GET);  
	    List<LinkTypeData> extracts = ExtractService.extract(rule);  
	    printf(extracts);  
	}  
	@org.junit.Test  
	public void getDatasByCssQueryTest1()  
	{  
	    Rule rule = new Rule(url,new String[] { "kw" }, 
	    		new String[] { "城市" },"catlist_li", Rule.CLASS, Rule.GET); 
	    List<LinkTypeData> extracts = ExtractService.extract(rule);  
	    printf(extracts);  
	    test2(extracts);
	    //getDatasByCssQueryTest2(extracts);
	}  
	
	public void test2(List<LinkTypeData> extracts) {
		String linkHref = "";
		for (LinkTypeData linkTypeData : extracts) {
			linkHref = linkTypeData.getLinkHref();
		}
	    Rule rule = new Rule(linkHref,null, 
	    		null,"content", 0, Rule.GET); 
	    List<LinkTypeData> extracts22 = ExtractService.extract(rule);  
	    printf(extracts22);  
	}
	/*@org.junit.Test  
	public void getDatasByCssQueryTest2(List<LinkTypeData> extractsextracts)  
	{  
		String linkHref = "";
		for (LinkTypeData linkTypeData : extractsextracts) {
			linkHref = linkTypeData.getLinkHref();
		}
	    Rule rule = new Rule(linkHref,null, 
	    		null,"introduce", 0, Rule.GET); 
	    List<LinkTypeData> extracts = ExtractService.extract(rule);  
	    printf(extracts);  
	}  */
	@org.junit.Test  
	public void getDatasByCssQueryTest3()  
	{  
		
	    Rule rule = new Rule("http://www.fangan100.com/fangan/1/812.html",null, 
	    		null,"title", 0, Rule.GET); 
	    List<LinkTypeData> extracts = ExtractService.extract(rule);  
	    printf(extracts);  
	}  
	
}
