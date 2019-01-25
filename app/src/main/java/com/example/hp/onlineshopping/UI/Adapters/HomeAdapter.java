package com.example.hp.onlineshopping.UI.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hp.onlineshopping.Model.DataModel.GetHome;
import com.example.hp.onlineshopping.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Holder> {

    GetHome.HomeData homeData;
    Context context;
    List<GetHome.Product> products;

    public HomeAdapter(Context context, List<GetHome.Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.home_item,parent,false));

    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        GetHome.Product product=products.get(position);
        holder.item_name.setText(product.getTitle());
        holder.price.setText(product.getPriceAfter());
        holder.old_price.setText(product.getPriceBefore());

        Glide.with(context)
                .load(product.getImage())
                .into(holder.item_image);




    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView like,item_image;
        TextView item_name,price,old_price;
        public Holder(View itemView) {
            super(itemView);
            like=itemView.findViewById(R.id.like);
            item_image=itemView.findViewById(R.id.item_image);
            item_name=itemView.findViewById(R.id.item_name);
            price=itemView.findViewById(R.id.price);
            old_price=itemView.findViewById(R.id.old_price);
        }
    }
}
