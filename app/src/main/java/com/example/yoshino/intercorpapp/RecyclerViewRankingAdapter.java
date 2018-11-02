package com.example.yoshino.intercorpapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewRankingAdapter extends RecyclerView.Adapter<RecyclerViewRankingAdapter.MyViewHolder> implements Filterable {

    Context mContext;
    List<Contact2> mData;
    List<Contact2> mDataFull;


    public RecyclerViewRankingAdapter(Context mContext, List<Contact2> mData) {
        this.mContext = mContext;
        this.mData = mData;
        mDataFull=new ArrayList<>(mData); //--
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v ;
       v = LayoutInflater.from(mContext).inflate(R.layout.row_raking,parent,false);
       MyViewHolder vHolder = new MyViewHolder(v);
       return  vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.tv_name.setText(mData.get(position).getName());
    holder.tv_phone.setText(mData.get(position).getPhone());


   holder.img.setImageResource(mData.get(position).getPhoto());

        holder.tv_oro.setText(mData.get(position).getnOro()+"");
        holder.tv_plata.setText(mData.get(position).getnPlata()+"");
        holder.tv_bronce.setText(mData.get(position).getnCobre()+"");



//        String url ="http://fundaciontem.org/wp-content/uploads/2016/04/sinay-segun-veronica-1.jpg";
//                Picasso.with(mContext).load(url).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_phone;
        private ImageView img;
        private TextView tv_oro;
        private TextView tv_plata;
        private TextView tv_bronce;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_name= itemView.findViewById(R.id.name_contact);
            tv_phone= itemView.findViewById(R.id.phone_contac);
            img= itemView.findViewById(R.id.img_contact);
            tv_oro= itemView.findViewById(R.id.numOro);
            tv_plata= itemView.findViewById(R.id.numPlatino);
            tv_bronce= itemView.findViewById(R.id.numBronce);



        }
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Contact2> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mDataFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Contact2 item : mDataFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mData.clear();
            mData.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


}
