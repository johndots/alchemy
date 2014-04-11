package ie.alchemytours.alchemytours;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
 
public class Statues extends ListActivity  {
ArrayList<HashMap<String, String>> statueList;
private ProgressDialog progressMessage;
JSONParser jParser = new JSONParser();
private static String url = "http://www.alchemytours.ie/statues.php";
JSONArray statues = null;
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_list_statue);
statueList = new ArrayList<HashMap<String, String>>();
new LoadAllProducts().execute();
}
 
class LoadAllProducts extends AsyncTask<String, String, String> {
 
@Override
protected void onPreExecute() {
super.onPreExecute();
progressMessage = new ProgressDialog(Statues.this);
progressMessage.setMessage("Loading ...");
progressMessage.setIndeterminate(false);
progressMessage.setCancelable(false);
progressMessage.show();
}
 
protected String doInBackground(String... args) {
List<NameValuePair> params = new ArrayList<NameValuePair>();
JSONObject json = jParser.makeHttpRequest(url, "GET", params);
 
Log.d("Staues: ", json.toString());
 
try {
int success = json.getInt("success");
 
if (success == 1) {
statues = json.getJSONArray("statues");
for (int i = 0; i < statues.length(); i++) {
JSONObject c = statues.getJSONObject(i);
String id = c.getString("id");
String name = c.getString("name");
String sculptor = c.getString("sculptor");
HashMap<String, String> map = new HashMap<String, String>();
map.put("id", id);
map.put("name", name);
map.put("sculptor", sculptor);
statueList.add(map);
}
}
} catch (JSONException e) {
e.printStackTrace();
}
 
return null;
}
protected void onPostExecute(String file_url) {
progressMessage.dismiss();
runOnUiThread(new Runnable() {
public void run() {
ListAdapter adapter = new SimpleAdapter(
Statues.this, statueList,
R.layout.view_statue_entry, new String[] { "id",
"name","sculptor"},
new int[] { R.id.id, R.id.name,R.id.sculptor });
setListAdapter(adapter);
}
});
 
}
 
}
}

