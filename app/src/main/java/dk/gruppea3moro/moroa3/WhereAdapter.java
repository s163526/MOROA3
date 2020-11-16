package dk.gruppea3moro.moroa3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WhereAdapter extends BaseAdapter {

    private final Context mContext;
    private final String[] mPlaces;


    // 1
    public WhereAdapter(Context context, String[] places) {
        this.mContext = context;
        this.mPlaces = places;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView dummyTextView = new TextView(mContext);
        dummyTextView.setText(String.valueOf(position));
        return dummyTextView;
    }
}
