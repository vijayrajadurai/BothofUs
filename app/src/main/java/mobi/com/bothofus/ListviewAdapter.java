package mobi.com.bothofus;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Acer on 24-Mar-18.
 */

public class ListviewAdapter extends BaseAdapter {

    private List<Restaurants> restaurantsList;
    private static final String TAG = "ListviewAdapter";
    private Context context;
    private LayoutInflater inflater;

    public ListviewAdapter(List<Restaurants> restaurantsList, Context context) {
        this.restaurantsList = restaurantsList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return restaurantsList.size();
    }

    @Override
    public Object getItem(int position) {
        return restaurantsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent){


        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.res_list_item, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        Button locationbutton = (Button)convertView.findViewById(R.id.btn_location);
        final Restaurants restaurants = restaurantsList.get(position);
        locationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MapsActivity.class);
                double a = restaurants.getLatitude();
                intent.putExtra("LAAA",a );
                intent.putExtra("LO",restaurants.getLongitude());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Log.e(TAG, "onCreateeeeeeeeeeeeeeeeeeeeeeee: "+restaurants.getLatitude()+"Lo : " +restaurants.getLongitude());
                context.startActivity(intent);
            }
        });

//

//
        Log.e(TAG, "restaurants: " + restaurants.toString() );
        Log.e(TAG, "getView: " + restaurants.getName() );
        mViewHolder.txtResName.setText("Restaurant: " +restaurants.getName());
        mViewHolder.txtResAddress.setText("Address: " +restaurants.getAddress());
        mViewHolder.txtRestelephone.setText("Contact: " +restaurants.getTelephone());
        mViewHolder.txtReswebsite.setText("Website: " +restaurants.getWebsite());
        mViewHolder.txtResopenhours.setText("Open Hours: "+restaurants.getOpeninghours());
        mViewHolder.locationbutton.setText("Location");

        return convertView;
    }

    private class MyViewHolder {
        TextView txtResName, txtResAddress,txtReswebsite,txtRestelephone,txtResopenhours;
        Button locationbutton;

        public MyViewHolder(View item) {
            txtResName = (TextView) item.findViewById(R.id.res_name);
            txtResAddress = (TextView) item.findViewById(R.id.res_address);
            txtRestelephone = (TextView) item.findViewById(R.id.res_telephone);
            txtReswebsite = (TextView) item.findViewById(R.id.res_website);
            txtResopenhours = (TextView) item.findViewById(R.id.res_openhours);
            locationbutton = (Button)item.findViewById(R.id.btn_location);
        }
    }
}
