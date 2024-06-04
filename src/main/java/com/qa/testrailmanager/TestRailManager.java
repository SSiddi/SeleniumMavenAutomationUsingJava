package com.qa.testrailmanager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

public class TestRailManager {

	public static int TEST_RUN_ID= 1;
	public static String TEST_RAIL_USERNAME = "shabnam.siddiqui0503@gmail.com";
	public static String TEST_RAIL_PASSWORD = "12345@Testrail";
	
	public static String TEST_RAIL_ENGINE_URL = "https://shabnamautomationsiddiquitestrail.testrail.io/";
	public static  int  TEST_CASE_PASS_STATUS = 1;
	public static  int  TEST_CASE_FAIL_STATUS = 5;
	
	public static void addResultForTestCase(String testcaseID, int status, String error)
	{
		int testRunId= TEST_RUN_ID;
		APIClient client = new APIClient(TEST_RAIL_ENGINE_URL);
		client.setUser(TEST_RAIL_USERNAME);
		client.setPassword(TEST_RAIL_PASSWORD);
		
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("status_id", status);
		data.put("comment", "Failed because of error " + error);
		
		try {
			client.sendPost("add_result_for_case/"+testRunId+"/"+testcaseID, data);

		} catch (IOException | APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
