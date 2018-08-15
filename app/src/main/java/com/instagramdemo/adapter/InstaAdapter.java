package com.instagramdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.instagramdemo.R;
import com.instagramdemo.inteface.EditFocus;

import java.util.ArrayList;

/**
 * Created by Ashok on 8/12/2018.
 */

public class InstaAdapter extends RecyclerView.Adapter<InstaAdapter.InstaHolder> {


    private Context context;
    private ArrayList<String> nameList;
    private EditFocus editFocus;

    public InstaAdapter(Context context, ArrayList<String> nameList, EditFocus editFocus) {
        this.context = context;
        this.nameList = nameList;
        this.editFocus = editFocus;
    }

    @Override
    public InstaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_layout, parent, false);
        return new InstaHolder(view);
    }

    @Override
    public void onBindViewHolder(final InstaHolder holder, final int position) {
        holder.txt_name.setText(nameList.get(position));
        holder.txt_reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editFocus.OpenKeyboard(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return nameList == null ? 0 : nameList.size();
    }

    class InstaHolder extends RecyclerView.ViewHolder {
        private TextView txt_name, txt_reply;

        public InstaHolder(View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_reply = itemView.findViewById(R.id.txt_reply);
        }
    }
}
