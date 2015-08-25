package br.com.atlantico.listexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Ygor on 25/08/2015.
 */
public class ContactAdapter extends BaseAdapter {

    private Contact[] contacts = new Contact[]{
            new Contact("Fabiano", "555-6885", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcREvE7_GRUf8_AmF9XYSlHz0kzEdVyX89QYiZPxfcIEVZNOleZw"),
            new Contact("Katarine", "555-8495", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQSTr_XoLIoRiEtxWGJJc4UVLiWrBJd0BrKGb7MCOONrHZBA5TbYg"),
            new Contact("Joao", "555-8870", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQkj9ujXKwhPayF6pcUksU8f7Ac85ZJ4Sg192YOl6UH5xOKu0h3"),
            new Contact("Lucia", "555-0058", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtK4VWfsd10Fkp61ZXEEWVrAwunUQU39EbA84iwZwMMn9pqv0DUg"),
            new Contact("Saulo", "555-0666", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTVHR1OSVMyAYZq4U41QFMXbmkAQKroO8vE_OeW-DUzTC7JwiLi"),
    };

    private LayoutInflater inflater;
    private Context context;

    public ContactAdapter(Context context) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return contacts.length;
    }

    @Override
    public Contact getItem(int position) {
        return contacts[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if (convertView == null) {
            view = inflater.inflate(R.layout.contact_item, parent, false);
        } else {
            view = convertView;
        }

        Contact c = contacts[position];

        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        TextView txtPhone = (TextView) view.findViewById(R.id.txtPhone);
        ImageView imgPhoto = (ImageView) view.findViewById(R.id.imgPhoto);

        txtName.setText(c.getName());
        txtPhone.setText(c.getPhone());

        Picasso.with(context).load(c.getImage()).placeholder(R.drawable.placeholder).into(imgPhoto);

        return view;
    }
}
