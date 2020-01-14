package com.example.shippingcostcalculator2app;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    private ShipItem shipItem;
    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment2, container,false);

        shipItem = new ShipItem();
        weightET = view.findViewById(R.id.editText1);
        baseCostTV = view.findViewById(R.id.textView4);
        addedCostTV = view.findViewById(R.id.textView6);
        totalCostTV = view.findViewById(R.id.textView8);

        weightET.addTextChangedListener(weightTextWatcher);

        return view;
    }
    private TextWatcher weightTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try{
                shipItem.setWeight((int)Double.parseDouble(s.toString()));
            }catch (NumberFormatException e){
                shipItem.setWeight(0);
            }
            displayShipping();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void displayShipping(){
        baseCostTV.setText("$"+ String.format("%.02f", shipItem.getBaseCost()));
        addedCostTV.setText("$"+String.format("%.02f",shipItem.getAddedCost()));
        totalCostTV.setText("$"+String.format("%.02f",shipItem.getTotalCost()));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
