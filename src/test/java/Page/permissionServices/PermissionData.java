package Page.permissionServices;

import java.util.HashMap;
import java.util.Objects;

public class PermissionData {



    public HashMap<String, Object> expecdetData(Integer id, String resource, String  action, Integer app_id )   {

    /*{

         "id": 719,
        "resource": "book",
            "action": "deneme, write etc.",
            "app_id": 2
    }*/

        HashMap<String,Object>expecdetData=new HashMap<>();

        expecdetData.put("id",id);
        expecdetData.put("resource",resource);
        expecdetData.put("action",action);
        expecdetData.put("app_id",app_id);


        return expecdetData;


      
    }
    public HashMap<String, Objects>Permissionn(String resource, String action, int app_id) {
        HashMap<String,Objects> body=new HashMap<>();
    
     return body;
    }

    public HashMap<String, Objects>Permission(int id, String resource, String action, int app_id) {
        HashMap<String,Objects> body=new HashMap<>();
        return body;
    }




}