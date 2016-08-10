package com.example.nellya.firebasestudent;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


//import com.firebase.client.Firebase;
//import com.firebase.client.FirebaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment  {


    private Button btnSubmit;
    private EditText editTextId;
    private EditText editTextName;
    private DatabaseReference rootRef;

    public MainActivityFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        rootRef = FirebaseDatabase.getInstance().getReference();

        editTextId = (EditText)rootView.findViewById(R.id.editTextId);
        editTextName = (EditText)rootView.findViewById(R.id.editTextName);
        btnSubmit = (Button)rootView.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getActivity().getApplicationContext(), "tentative d'insertion d'un étudiant en cours", Toast.LENGTH_LONG);
                t.show();
                verif();
            }
        });

        return rootView;

    }

    public void verif(){
        String id = editTextId.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        if (TextUtils.isEmpty(id)){
            Toast t1 = Toast.makeText(getActivity().getApplicationContext(), "Vous devez obligatoirement donner l'id de l'étudiant", Toast.LENGTH_LONG);
            t1.show();
            return;
        }
        if (TextUtils.isEmpty(id)){
            Toast t2 = Toast.makeText(getActivity().getApplicationContext(), "Veuillez donner le nom de l'étudiant", Toast.LENGTH_LONG);
            t2.show();
            return;
        }

        Student student = new Student(id, name);
        rootRef.push().setValue(student);
        Toast m = Toast.makeText(getActivity().getApplicationContext(),"Nouvel étudiant ajouté à la base",Toast.LENGTH_SHORT);
        m.show();

    }
}