package ten.prinprin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class OfficerAdapter extends BaseAdapter {
    private Context context;
    private List<Officer> officerList;

    public OfficerAdapter(Context context, List<Officer> officerList) {
        this.context = context;
        this.officerList = officerList;
    }

    @Override
    public int getCount() {
        return officerList.size();
    }

    @Override
    public Object getItem(int position) {
        return officerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view, parent, false);
        }

        Officer officer = officerList.get(position);

        TextView tvMaCB = convertView.findViewById(R.id.txtvMaCB);
        TextView tvHoTen = convertView.findViewById(R.id.txtvHoTen);

        tvMaCB.setText(officer.getMacb());
        tvHoTen.setText(officer.getHoten());

        return convertView;
    }
}
