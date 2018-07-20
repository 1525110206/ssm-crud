package com.javaweb.crud.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;

/*
 * ʹ��Spring����ģ���ṩ�Ĳ��������ܣ�����crud�������ȷ��
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
// spring�ṩ�ĵ�Ԫ����ģ��
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:applicationContext.xml",
		"file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml" })
public class MvcTest {
	// ����mvc���󣬻�ȡ��������
	MockMvc mockMvc;
	@Autowired
	WebApplicationContext context;

	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void testPage() throws Exception{
		//ģ�������õ�����ֵ
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
	
		MockHttpServletRequest request = result.getRequest();
		PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
		
		System.out.println("��ǰҳ�룺" + pi.getPageNum());
		System.out.println("��ҳ�룺" + pi.getPages());
		System.out.println("�ܼ�¼����" + pi.getTotal());
		System.out.println("��ҳ����Ҫ������ʾ��ҳ�룺");
		int[] nums = pi.getNavigatepageNums();
		for(int i : nums){
			System.out.println(" " + i);
		}
		
	}
	
}
