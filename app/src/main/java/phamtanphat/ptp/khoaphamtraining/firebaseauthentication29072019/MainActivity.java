package phamtanphat.ptp.khoaphamtraining.firebaseauthentication29072019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText mEdtEmail , mEdtPassword;
    Button btnDangky, btnDangnhap;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mEdtEmail = findViewById(R.id.edittextEmail);
        mEdtPassword = findViewById(R.id.edittextPassword);
        btnDangky = findViewById(R.id.buttonDangky);

        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEdtEmail.getText().toString();
                String password = mEdtPassword.getText().toString();

                mAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(MainActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                }else{
                                    Log.d("BBB",task.getException().toString());
                                }
                            }
                        });
            }
        });

    }
}
