package com.example.elements;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Mohru on 22.02.2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<String> rows;

    public MyAdapter(List<String> rows) {
        this.rows = rows;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(view);
    }

    public void onMoved(int from, int to) {

        if (from < to) {
            for (int i = from; i < to; ++i) {
                Collections.swap(rows, i, i + 1);
            }
        } else {
            for (int i = from; i > to; --i) {
                Collections.swap(rows, i, i - 1);
            }
        }

        notifyItemMoved(from, to);
    }

    public void onSwiped(int position) {
        rows.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textView.setText(rows.get(position));
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.textView3);
        }
    }
}
