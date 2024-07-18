package ten.prinprin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ten.prinprin.databinding.ActivityManHinh2Binding;

public class ManHinh2 extends AppCompatActivity {
    private ActivityManHinh2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityManHinh2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //setContentView(R.layout.activity_man_hinh2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.etxtEmail.getText().toString().trim();
                String password = binding.etxtPassword.getText().toString().trim();

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(ManHinh2.this, "Email không hợp lệ", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(ManHinh2.this, "Mật khẩu phải ít nhất 6 ký tự", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ManHinh2.this, ManHinh3.class);
                    startActivity(intent);
                }
            }
        });
    }
}