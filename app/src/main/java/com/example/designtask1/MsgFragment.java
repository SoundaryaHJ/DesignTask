package com.example.designtask1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MsgFragment extends Fragment {

    Button now, later, cancel;
    EditText to, subject, body;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_msg, container, false);

        to = view.findViewById(R.id.to);
        subject = view.findViewById(R.id.subject);
        body = view.findViewById(R.id.body);

        now = view.findViewById(R.id.now);

        now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String To= to.getText().toString();
                String Subject = subject.getText().toString();
                String Body = body.getText().toString();

                if (To.equals("") || Subject.equals("") || Body.equals("") )
                {
                    Toast.makeText(getActivity(), "Field should not be Empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                Toast.makeText(getActivity(), "Message sent", Toast.LENGTH_SHORT).show();
                }
            }
        });

        later = view.findViewById(R.id.later);
        later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getActivity(), "Send later", Toast.LENGTH_SHORT).show();
            }
        });

        cancel = view.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getActivity(), "Message canceled", Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }
}
