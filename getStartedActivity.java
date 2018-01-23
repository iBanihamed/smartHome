package ismael.banihamed.my.a353.csun.edu.myfirstapp;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.Map;

public class getStartedActivity extends AppCompatActivity {

    ListView myListView;
    /*
    Context thisContext;
    TextView progressTextView;
    Map<String, Double> deviceMap = new LinkedHashMap<String, Double>();
    */
    String[] devices;
    String[] power;
    String[] price;
    String[] powerFactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        devices = res.getStringArray(R.array.devices);
        power = res.getStringArray(R.array.power);
        price = res.getStringArray(R.array.price);
        powerFactor = res.getStringArray(R.array.powerFactor);
        /*
        progressTextView = (TextView) findViewById(R.id.progressTextView);
        thisContext = this;
         */


        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.listview_header,myListView,false);
        myListView.addHeaderView(header);
       // myListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_listview_detail, devices));
        itemAdapter itemAdapt = new itemAdapter(this, devices, power, powerFactor, price);
        myListView.setAdapter(itemAdapt);
    }
}
