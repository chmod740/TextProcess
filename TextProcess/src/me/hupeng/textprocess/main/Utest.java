package me.hupeng.textprocess.main;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Utest {
	
	
	@Test
	public void tets(){
		Configuration configuration = new Configuration("d:/4.txt", "d:/output1/");
		configuration.setMood(0);
		configuration.setInputCharCode("GBK");
		configuration.setOutputCharCod("UTF-8");
		TextUtil textUtil = new TextUtil(configuration);
		textUtil.doService();
		
	}
	
	@Test
	public void tyestt(){
		
		Map map = new HashMap();
		  
		  map.put(1, 1);
		  
		  System.out.println(map.get(2));	
		
	}
}
