package in.pankajchaudhary.pankajchaudhary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class QueryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        final DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference().child("Query");
        final EditText mCropName=(EditText) findViewById(R.id.editText);
        final EditText mDescription=(EditText) findViewById(R.id.editText2);
        Button Btn1=(Button) findViewById(R.id.button7);

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Farmername ="Ram Swarup";

                String name = mCropName.getText().toString().trim();
                String Description = mDescription.getText().toString().trim();

                //DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference().child("Query");

                HashMap<String, String> dataMap =new HashMap<String , String>();
                dataMap.put("Name", Farmername);
                dataMap.put("Description",Description);
                mDatabase.child(name).setValue(dataMap);

                mCropName.setText("");
                mDescription.setText("");
                toastMessage(" Query Sent sucessfully...");
                Intent koi=new Intent(QueryActivity.this,MainActivity.class);
                startActivity(koi);

            }
        });


    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
