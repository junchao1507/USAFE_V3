package com.example.a0411_0127122_t2_v3usafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.reginald.editspinner.EditSpinner;

import java.util.ArrayList;
import java.util.List;

public class BookingAdapter extends ArrayAdapter<BookingItem>{
    List<BookingItem> items_list = new ArrayList<>();
    int menu_layout_id;

    public BookingAdapter(@NonNull Context context, int resource, @NonNull List<BookingItem> objects) {
        super(context, resource, objects);
        items_list = objects;
        menu_layout_id = resource;
    }

    @Override
    public int getCount() {
        return items_list.size();
    }

    @Override
    public BookingItem getItem(int position) {
        return items_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            // getting reference to the main layout and
            // initializing
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(menu_layout_id, null);
        }

        // initializing the imageview and textview and
        // setting data

        TextView tvModuleName = v.findViewById(R.id.tv_module_name);
        TextView tvDayDate = v.findViewById(R.id.tv_day_date);
        TextView tvTime = v.findViewById(R.id.tv_time);
        TextView tvLocation = v.findViewById(R.id.tv_location);
        TextView tvSeats = v.findViewById(R.id.tv_seats);
        EditSpinner spnSeatNo = v.findViewById(R.id.spn_select_seat);

        // get the item using the  position param
        BookingItem bookingItem = items_list.get(position);

        tvModuleName.setText(bookingItem.getModuleName());
        tvDayDate.setText(bookingItem.getDayDate());
        tvTime.setText(bookingItem.getTime());
        tvLocation.setText(bookingItem.getLocation());
        tvSeats.setText(bookingItem.getSeats());
//        spnSeatNo.setText(bookingItem.getSeatNo())

//        ArrayAdapter<String> listSeats;
//        String seatList[] = bookingItem.getSeatNo().toArray(new String[bookingItem.getSeatNo().size()]);
//
//        // Week Spinner
//        listSeats = new ArrayAdapter<String>(BookingActivity, android.R.layout.simple_spinner_item, seatList);
//        listSeats.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spnSeatNo.setAdapter(listSeats);

        return v;
    }
}
