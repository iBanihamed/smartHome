package ismael.banihamed.my.a353.csun.edu.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ismael.banihamed.my.a353.csun.edu.myfirstapp.R.array.devices;

/**
 * Created by Abdu on 11/8/2017.
 */

public class itemAdapterDB extends BaseAdapter {

    LayoutInflater mInflator;
    Map<String, Double> map;
    List<String> devices;
    List<Double> pf;
    List<Double> prices;

    public itemAdapterDB(Context c, Map m) {
        mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        map = m;
        devices = new ArrayList<String>(map.keySet());
        pf = new ArrayList<Double>(map.values());
        prices = new ArrayList<Double>(map.values());

     }

     @Override
    public int getCount() {
         return map.size();
     }

     public Object getItem(int position) {
         return devices.get(position);
     }

     @Override
    public long getItemId(int position) {
         return position;
     }

     @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         View v = mInflator.inflate(R.layout.item_layout, null);
         TextView devicesTextView = (TextView) v.findViewById(R.id.nameTextView);
         TextView pfTextView = (TextView) v.findViewById(R.id.PFTextView);
         TextView costTextView = (TextView) v.findViewById(R.id.costTextView);

         devicesTextView.setText(devices.get(position).toString());
         pfTextView.setText(pf.get(position).toString());
         costTextView.setText("$" + prices.get(position).toString());

       //stays comented out until we can query data from database
      //   setRowColor(v, pf.get(position));

         return v;
     }

    private void setRowColor(View v, Double powerFactor) {
        int level = getLevel(powerFactor);
        switch (level) {
            case 1: v.setBackgroundResource(R.color.colorDarkGreen);
                break;
            case 2: v.setBackgroundResource(R.color.colorLimeGreen);
                break;
            case 3: v.setBackgroundResource(R.color.colorYellow);
                break;
            case 4: v.setBackgroundResource(R.color.colorOrange);
                break;
            case 5: v.setBackgroundResource(R.color.colorRed);
                break;
            // case 12: v.setBackgroundColor(Color.rgb(0,100,0));
            //   break;
            //white default
            default: v.setBackgroundResource(R.color.colorPrimary);
                break;
        }
    }

    private int getLevel(Double pf) {
        int level;
        if (pf < 0) {   //really bad pf
            level = 1;
        } else if (pf < 0.5) {    //bad pf
            level = 2;
        } else if (pf < 0.7) { //decent pf
            level = 3;
        } else if (pf < 0.9) {  //good pf
            level = 4;
        } else {  //great pf
            level = 5;
        }
        return level;
    }
}
