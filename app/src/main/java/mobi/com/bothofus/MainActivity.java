package mobi.com.bothofus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    private static final  String RESTAURANT_JSON_URL = "http://www.opendatamalta.org/ckan/dataset/1d5df898-1481-42cf-85a5-673c6cdec65e/resource/73e13022-0ae6-445e-9bb5-d3d91f154a7b/download/restaurants.json";
    ListView listView;
    List<Restaurants> restaurantsList =new ArrayList<>();
    ListviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.res_list);
        adapter = new ListviewAdapter(restaurantsList,getApplicationContext());
        listView.setAdapter(adapter);
        loadRestaurentList();

    }

    private void loadRestaurentList(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET,RESTAURANT_JSON_URL,
                new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject object = new JSONObject(response);
                            JSONObject object1 = object.getJSONObject("restaurants");

                            JSONArray restaurentArray = object1.getJSONArray("restaurant");

                            for (int i=0; i< restaurentArray.length();i++){
                                Log.e(TAG, "llllllllllllll: " + restaurentArray.length() );
                                JSONObject restaurantObject = restaurentArray.getJSONObject(i);

//                                Restaurants restaurants = new Restaurants(restaurantObject.getString("name"),restaurantObject.getString("address"), restaurantObject.getDouble("latitude"), restaurantObject.getDouble("longitude"), restaurantObject.getInt("telephone"), restaurantObject.getString("website"), restaurantObject.getString("opening-hours") );
                                Restaurants restaurants = new Restaurants();
                                restaurants.setName(restaurantObject.optString("name"));
                                restaurants.setAddress(restaurantObject.optString("address"));
                                restaurants.setLatitude(restaurantObject.optDouble("latitude"));
                                restaurants.setLongitude(restaurantObject.optDouble("longitude"));
                                restaurants.setTelephone(restaurantObject.optString("telephone"));
                                restaurants.setOpeninghours(restaurantObject.optString("opening-hours"));
                                restaurants.setWebsite(restaurantObject.optString("website"));

                                restaurantsList.add(restaurants);
                                Log.e(TAG, "restaurantsListtttttttttttt: " + restaurantsList );
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }finally {
                            adapter.notifyDataSetChanged();
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


    public void eventlist(View view) {

        Intent intent = new Intent(MainActivity.this,Events.class);
        startActivity(intent);
    }
}
