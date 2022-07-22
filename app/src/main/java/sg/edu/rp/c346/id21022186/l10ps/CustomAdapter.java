package sg.edu.rp.c346.id21022186.l10ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.time.temporal.Temporal;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Songs> songList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<Songs> objects) {
        super(context, resource, objects);

        this.parent_context = context;
        this.layout_id = resource;
        this.songList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tt = rowView.findViewById(R.id.title);
        TextView yr = rowView.findViewById(R.id.year);
        TextView st = rowView.findViewById(R.id.stars);
        TextView sg = rowView.findViewById(R.id.singer);

        Songs currentVersion = songList.get(position);

        // Set values to the TextView to display the corresponding information
        tt.setText(currentVersion.getTitle());
        yr.setText(currentVersion.getYear());
        st.setText(currentVersion.getStars());
        sg.setText(currentVersion.getSingers());

        return rowView;
    }
}




