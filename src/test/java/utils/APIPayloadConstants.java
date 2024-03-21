package utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    public static String createEmployeePayload(){
        String createEmployeePayload ="{\n" +
                "  \"emp_firstname\": \"Marco\",\n" +
                "  \"emp_lastname\": \"Philip\",\n" +
                "  \"emp_middle_name\": \"BB\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2000-10-09\",\n" +
                "  \"emp_status\": \"Temporary\",\n" +
                "  \"emp_job_title\": \"IT\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeeJsonPayload(){
        JSONObject  obj= new JSONObject();
        obj.put("emp_firstname","Marco");
        obj.put("emp_lastname","Philip");
        obj.put("emp_middle_name","BB");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2000-10-09");
        obj.put("emp_status","Temporary");
        obj.put("emp_job_title","IT");

return obj.toString();
    }


    public static String createEmployeeJsonPayloadDynamic
            (String emp_firstname, String emp_lastname, String emp_middle_name,
            String emp_gender,String emp_birthday , String emp_status,String emp_job_title){
        JSONObject  obj= new JSONObject();
        obj.put("emp_firstname",emp_firstname);
        obj.put("emp_lastname",emp_lastname);
        obj.put("emp_middle_name",emp_middle_name);
        obj.put("emp_gender",emp_gender);
        obj.put("emp_birthday",emp_birthday);
        obj.put("emp_status",emp_status);
        obj.put("emp_job_title",emp_job_title);

        return obj.toString();
    }


    public static String updateEmployeeJsonPayload(){
    JSONObject  obj= new JSONObject();
        obj.put("employee_id", "104149A");
        obj.put("emp_firstname","Gogaa");
        obj.put("emp_lastname","Alfred");
        obj.put("emp_middle_name","ME");
        obj.put("emp_gender","F");
        obj.put("emp_birthday","2000-10-10");
        obj.put("emp_status","Permenant");
        obj.put("emp_job_title","QA Engineer");

        return obj.toString();
    }

}
