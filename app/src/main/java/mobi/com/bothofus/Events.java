package mobi.com.bothofus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Events extends AppCompatActivity {

    private static final String TAG = "Events";

    private static final  String EVENT_JSON_URL = "http://www.opendatamalta.org/ckan/dataset/dfdefba9-745e-4618-bddd-fbd179e910c8/resource/90f81009-fbc9-41ef-b031-fe3ae8bef03b/download/events.json";
    ListView listView;
    List<Event> eventList =new ArrayList<>();
    EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        listView = (ListView) findViewById(R.id.eventlist);
        eventAdapter = new EventAdapter(eventList,getApplicationContext());
        listView.setAdapter(eventAdapter);
        loadEventList();


    }

    private void loadEventList(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET,EVENT_JSON_URL,
                new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject object = new JSONObject(response);


                            JSONArray eventArray = object.getJSONArray("EventList");

                            for (int i=0; i< eventArray.length();i++){
                                Log.e(TAG, "llllllllllllll: " + eventArray.length() );
                                JSONObject eventObject = eventArray.getJSONObject(i);

//                                Restaurants restaurants = new Restaurants(restaurantObject.getString("name"),restaurantObject.getString("address"), restaurantObject.getDouble("latitude"), restaurantObject.getDouble("longitude"), restaurantObject.getInt("telephone"), restaurantObject.getString("website"), restaurantObject.getString("opening-hours") );
                                Event event = new Event();
                                event.setIdentifier(eventObject.optString("Identifier"));
                                event.setEventdate(eventObject.optString("EventDate"));
                                event.setTitle(eventObject.optString("Title"));
                                event.setLocation(eventObject.optString("Location"));
                                event.setVenue(eventObject.optString("Venue"));
                                event.setEventtype(eventObject.optString("EventType"));

                                eventList.add(event);
                                Log.e(TAG, "restaurantsListtttttttttttt: " + eventList );
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }finally {
                            eventAdapter.notifyDataSetChanged();
                        }
                    }
                },
                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
