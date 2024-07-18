package ten.prinprin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ten.prinprin.databinding.ActivityManHinh1Binding;

public class ManHinh1 extends AppCompatActivity {
    private ActivityManHinh1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityManHinh1Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //setContentView(R.layout.activity_man_hinh1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Chọn mã sinh viên
        binding.etxtmasv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStudentIDDialog();
            }
        });

        // Lưu và hiển thị kết quả
        binding.btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        // Thoát ứng dụng
        binding.btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Mở màn hình 2
        binding.btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManHinh1.this, ManHinh2.class);
                startActivity(intent);
            }
        });
    }

    private void showStudentIDDialog() {
        final String[] studentIDs = {"SV001", "SV002", "SV003", "SV004"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chọn Mã Sinh Viên");
        builder.setItems(studentIDs, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                binding.etxtmasv.setText(studentIDs[which]);
            }
        });
        builder.show();
    }

    private void saveData() {
        String name = binding.etxttensv.getText().toString();
        String studentID = binding.etxtmasv.getText().toString();
        String age = binding.etxttuoi.getText().toString();
        String gender = binding.rg1.getCheckedRadioButtonId() == R.id.rbnam ? "Nam" : "Nữ";

        StringBuilder hobbies = new StringBuilder();
        if (binding.chbdabong.isChecked()) hobbies.append("Đá bóng ");
        if (binding.chbchoigame.isChecked()) hobbies.append("Chơi game ");

        String result = "Tên: " + name + "\nMã sinh viên: " + studentID + "\nTuổi: " + age +
                "\nGiới tính: " + gender + "\nSở thích: " + hobbies.toString();

        binding.tvResult.setText(result);
    }
}