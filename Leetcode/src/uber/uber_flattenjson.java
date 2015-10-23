package uber;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class uber_flattenjson {
//	public List<Map<String, Object>> flatternJSON(String jsonString) {
//        JSONParser parser = new JSONParser();
//        List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
//
//        try {
//            JSONObject jObj = (JSONObject)parser.parse(jsonString);
//            Map<String, Object> map = new HashMap<String, Object>();
//            String key = (String) jObj.get("uuid");
//            Object value = jObj;
//            map.put(key, jObj);
//            recursiveProcess(jObj, res);
//            return res;
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }     

//    private void recursiveProcess(JSONObject jObj, List<Map<String, Object>>res) {
//        Iterator iter = jObj.keySet().iterator();
//        while(iter.hasNext()) {
//        	String key = (String) iter.next();
//            Object obj = jObj.get(key);
//            if (obj instanceof String) {
//                continue;
//            } else if (obj instanceof JSONArray) {
//                JSONArray array = (JSONArray)obj;
//                Iterator arrIter = array.iterator();
//                JSONArray newArray = new JSONArray();
//                while(arrIter.hasNext()) {
//                    JSONObject o = (JSONObject) arrIter.next();
//                    newArray.add(o.get("uuid"));
//                    Map<String, Object> map = new HashMap<String, Object>();
//                    map.put((String) o.get("uuid"), obj);
//                    res.add(map);
//                    recursiveProcess(o, res);
//                }
//                jObj.put(key, newArray);
//            } else {
//                recursiveProcess((JSONObject)obj, res);
//            }
//        }
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
