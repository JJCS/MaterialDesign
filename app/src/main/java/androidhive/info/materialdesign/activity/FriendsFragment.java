package androidhive.info.materialdesign.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidhive.info.materialdesign.R;
import androidhive.info.materialdesign.adapter.ListCostAdapter;


public class FriendsFragment extends Fragment {
    ArrayList<Cost> arrayCosts;
    ListView listViewCost;


    public FriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    /*
         *
         */
        arrayCosts = new ArrayList<Cost>();

        //fill Costs data
        Cost audi = new Cost(R.drawable.audi, "Audi A4", "Gray", 18000);
        Cost opel = new Cost(R.drawable.opel, "Opel Insigna", "Black", 14000);
        Cost mercedes = new Cost(R.drawable.mercedes, "mercedes CLS 320", "Black", 16000);
        Cost ferrari = new Cost(R.drawable.ferrari_enzo, "Ferrari Enzo", "White", 93000);
        Cost fiesta = new Cost(R.drawable.ford_fiesta, "Ford Fiesta", "Green", 18000);
        Cost porshe = new Cost(R.drawable.porshe_cayenne, "porshe_cayenne", "Dark Gray", 101000);
        Cost lambo = new Cost(R.drawable.lamborghini_gallardo, "Lamborghini gallardo", "orange", 100000);
        Cost hyundai = new Cost(R.drawable.hyundai_i30, "Hyundai i30", "blue", 20000);
        Cost honda = new Cost(R.drawable.honda_accord, "Honda accord", "red", 19000);

        arrayCosts.add(audi);
        arrayCosts.add(opel);
        arrayCosts.add(mercedes);
        arrayCosts.add(ferrari);
        arrayCosts.add(fiesta);
        arrayCosts.add(porshe);
        arrayCosts.add(lambo);
        arrayCosts.add(hyundai);
        arrayCosts.add(honda);


        listViewCost = (ListView) getView().findViewById(R.id.list_cars);
        ListCostAdapter adapter = new ListCostAdapter(getActivity(), arrayCosts);
        listViewCost.setAdapter(adapter);
        // Set the onItemClickListener on the ListView to listen for items clicks
        listViewCost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cost selectedCar = arrayCosts.get(position);
                Toast.makeText(getActivity(), "You've selected :\n Car Model : " + selectedCar.getModel() + "\n Car Color : "+ selectedCar.getColor(), Toast.LENGTH_SHORT).show();
            }
        });



        /*
         *
         */

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friends, container, false);
    }


}
