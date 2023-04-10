package PojoDatas;

import java.util.HashMap;

public class PermissionData {
    public HashMap<String, Object> setUpExpectedData() {    //POST PERMİSSİON İCİN HAZIRLANDI

			/*
			{                           "resource": "CREATE"
									    "action": "WORK, WRİTE."
									   "app_id": 2

									  }
			 */

        HashMap<String, Object> setUpExpectedDataMap = new HashMap<>();

        setUpExpectedDataMap.put(" resource", "CREATE");
        setUpExpectedDataMap.put("action", "WORK, WRİTE.");
        setUpExpectedDataMap.put("app_id", 2);


        return setUpExpectedDataMap;
    }
}