package com.example.elements;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        List<String> rows = new ArrayList<>();
        rows.add("row1");
        rows.add("row2");
        rows.add("row3");
        rows.add("row4");
        rows.add("row5");
        rows.add("row6");
        rows.add("row7");

        final MyAdapter adapter = new MyAdapter(rows);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemTouchHelper.SimpleCallback touchCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                adapter.onMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.onSwiped(viewHolder.getAdapterPosition());
            }
        };

        ItemTouchHelper helper = new ItemTouchHelper(touchCallback);
        helper.attachToRecyclerView(recyclerView);

        CardView cardView = (CardView) findViewById(R.id.cardView);

        SwipeDismissBehavior<CardView> swipe = new SwipeDismissBehavior<>();

        swipe.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY);
        swipe.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override
            public void onDismiss(View view) {
                Toast.makeText(SecondActivity.this, "onDismiss", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDragStateChanged(int state) {
                Toast.makeText(SecondActivity.this, "onStateChanged", Toast.LENGTH_SHORT).show();
            }
        });

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) cardView.getLayoutParams();
        params.setBehavior(swipe);

    }
}
