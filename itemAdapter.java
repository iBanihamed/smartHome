package ismael.banihamed.my.a353.csun.edu.myfirstapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.text.ParsePosition;

import ismael.banihamed.my.a353.csun.edu.myfirstapp.R;

import static android.graphics.Color.rgb;

/**
 * Created by Abdu on 10/5/2017.
 */

public class itemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] devices;
    String[] power;
    String[] cost;
    String[] powerFactor;

    /*
    Map<int, double, double, double, double, double, double> map;
    List<int> device;
    List<double> apparentPower;
    List<double> activePower;
    List<double> irms;
    List<double> vrms;
    List<double> powerFactor;
    List<double> pricing;
     */
    public itemAdapter(Context c, String[] d, String[] p, String[] pf, String[] co) {
        devices = d;
        power = p;
        cost = co;
        powerFactor = pf;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /*
    public itemAdapter(Context c, Map m) {
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        map = m;
        device = new ArrayList<int>(map.id());
        power = new ArrayLost<double>(map.id());
        powerFactor = new ArrayList<double>(map.PF());
        price = new AarrayList<double>(map.PRICE());
    }

     */
    @Override
    public int getCount() {
        return devices.length;
    }

    @Override
    public Object getItem(int position) {
        return devices[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflater.inflate(R.layout.my_listview_detail, null);

        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView powerTextView = (TextView) v.findViewById(R.id.powerTextView);
        TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);
        TextView powerFactorTextView = (TextView) v.findViewById(R.id.powerFactorTextView);

        String name = devices[position];
        String pow = power[position];
        String price = cost[position];
        String pf = powerFactor[position];

        nameTextView.setText(name);
        powerTextView.setText(pow);
        priceTextView.setText(price);
        powerFactorTextView.setText(pf);
        setRowColor(v, pf);

        return v;
    }

    private void setRowColor(View v, String powerFactor) {
        int pf_int = Integer.parseInt(powerFactor);
        int level = getLevel(pf_int);
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

 /*   private void setRowColor(View v, TextView powerFactor) {
        int pf_int = Integer.parseInt(powerFactor.getText().toString());
        int level = getLevel(pf_int);
        switch (level) {
            //red spectrum
            case 1: powerFactor.setTextColor(Color.rgb(139,0,0));
                    break;
            //orange spectrum
            case 2: powerFactor.setTextColor(Color.rgb(255,165,0));
                break;
            //yellow
            case 3: powerFactor.setTextColor(Color.rgb(255,255,0));
                break;
            //lightgreen to  darkgreen spectrum
            case 4: powerFactor.setTextColor(Color.rgb(0,255,0));
                break;
            case 5: powerFactor.setTextColor(Color.rgb(34,139,34));
                break;
           // case 12: v.setBackgroundColor(Color.rgb(0,100,0));
             //   break;
            //white default
            default: powerFactor.setTextColor(Color.rgb(255,255,255));
                break;
        }
    }*/

    private int getLevel(int pf) {
        int level;
        if (pf < 0) {   //really bad pf
            level = 1;
        } else if (pf < 5) {    //bad pf
            level = 2;
        } else if (pf < 7) { //decent pf
            level = 3;
        } else if (pf < 9) {  //good pf
            level = 4;
        } else {  //great pf
            level = 5;
        }
        return level;
    }
}
