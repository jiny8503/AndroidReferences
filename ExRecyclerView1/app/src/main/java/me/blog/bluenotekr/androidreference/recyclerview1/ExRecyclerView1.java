package me.blog.bluenotekr.androidreference.recyclerview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.blog.bluenotekr.androidreference.R;

public class ExRecyclerView1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_recycler_view1);

        // TODO : 데이터 리스트를 정의합니다
        List<Item> list = new ArrayList<Item>();
        list.add(new Item("푸른노트", 34));
        list.add(new Item("학생", 21));
        // TODO : RecyclerView Instance 를 얻어오고 Adapter 에 Assemble 합니다
        RecyclerView ex_recycler_view1_lsv = (RecyclerView)findViewById(R.id.ex_recycler_view1_lsv);
        // ** RecyclerView 는 Layout의 형태를 지정하는 LayoutManager 를 지정해주어야 합니다
        ex_recycler_view1_lsv.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(list);
        ex_recycler_view1_lsv.setAdapter(adapter);
    }

    // TODO : Data Item
    class Item {
        public String name;
        public int age;
        public Item(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    // TODO : ViewHolder - 1 Row 의 View 를 대표하는 Model 객체입니다. (*static 으로 정의)
    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ex_recycler_view1_item_txv;
        public ViewHolder(View view) {
            super(view);
            ex_recycler_view1_item_txv = (TextView)view.findViewById(R.id.ex_recycler_view1_item_txv);
        }
    }

    // TODO : Adapter - 정의시 ViewHolder 클래스를 Generic 으로 지정해 줍니다
    class RecyclerViewAdapter extends RecyclerView.Adapter<ExRecyclerView1.ViewHolder> {

        // TODO : RecyclerView 의 Adapter 에서는 데이터 리스트 객체를 직접 관리합니다
        private List<Item> list = null;

        public RecyclerViewAdapter(List<Item> list) {
            this.list = list;
        }

        @Override
        public int getItemCount() {
            // TODO : 반환되는 count 만큼 row 가 반복됩니다. (즉, onCreateViewHolder, onBindViewHolder 반복)
            if (list == null) return 0;
            else return list.size();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // TODO : 1 Row 를 대표하는 ViewHolder 객체를 반환합니다.
            ViewHolder holder;
            // ** 1 Row 의 Layout 을 Inflate 합니다
            View view = getLayoutInflater().inflate(R.layout.activity_ex_recycler_view1_item, parent, false);
            holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            // TODO : 1 Row 의 View 에 데이터를 설정합니다
            final Item item = list.get(position);
            holder.ex_recycler_view1_item_txv.setText(
                    "이름은 " + item.name + " 이고, 나이는 " + item.age + " 입니다"
            );
        }
    }

}
