package mobi.com.bothofus;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Acer on 24-Mar-18.
 */

public class EventAdapter extends BaseAdapter {

    private List<Event> eventList;
    private static final String TAG = "EventAdapter";
    private Context context;
    private LayoutInflater inflater;

    public EventAdapter(List<Event> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EventAdapter.MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.event_list_item, parent, false);
            mViewHolder = new EventAdapter.MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (EventAdapter.MyViewHolder) convertView.getTag();
        }

//
        Event event = eventList.get(position);
//
        Log.e(TAG, "event: " + event.toString() );
        mViewHolder.txtEventId.setText("Identifier: " +event.getIdentifier());
        mViewHolder.txtEventdate.setText("EventDate: " +event.getEventdate());
        mViewHolder.txtEventtitle.setText("Title: " +event.getTitle());
        mViewHolder.txtEventlocation.setText("Location: " +event.getLocation());
        mViewHolder.txtEventvenue.setText("Venue: "+event.getVenue());
        mViewHolder.txtEventtype.setText("EventType: "+event.getEventtype());

        return convertView;
    }

    private class MyViewHolder {
        TextView txtEventId,txtEventdate,txtEventtitle,txtEventlocation,txtEventvenue,txtEventtype;

        public MyViewHolder(View item) {
            txtEventId = (TextView) item.findViewById(R.id.event_id);
            txtEventdate = (TextView) item.findViewById(R.id.event_date);
            txtEventtitle = (TextView) item.findViewById(R.id.event_title);
            txtEventlocation = (TextView) item.findViewById(R.id.event_location);
            txtEventvenue = (TextView) item.findViewById(R.id.event_venue);
            txtEventtype = (TextView) item.findViewById(R.id.event_type);
        }
    }
}
