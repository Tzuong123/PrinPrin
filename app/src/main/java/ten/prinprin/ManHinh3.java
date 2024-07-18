package ten.prinprin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ten.prinprin.databinding.ActivityManHinh3Binding;

public class ManHinh3 extends AppCompatActivity {

    private ActivityManHinh3Binding binding;
    private OfficerAdapter adapter;
    private List<Officer> officerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityManHinh3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //setContentView(R.layout.activity_man_hinh3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        officerList = new ArrayList<>();
        adapter = new OfficerAdapter(this, officerList);
        binding.listView.setAdapter(adapter);

        binding.btnHienthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadOfficerData();
            }
        });
    }

    private void loadOfficerData() {
        String jsonData = "[{\"macb\": \"CB001\", \"hoten\": \"Nguyen Van A\"}," +
                "{\"macb\": \"CB002\", \"hoten\": \"Tran Thi B\"}," +
                "{\"macb\": \"CB003\", \"hoten\": \"Le Van C\"}]";

        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            officerList.clear();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String macb = jsonObject.getString("macb");
                String hoten = jsonObject.getString("hoten");

                Officer officer = new Officer(macb, hoten);
                officerList.add(officer);
            }
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}