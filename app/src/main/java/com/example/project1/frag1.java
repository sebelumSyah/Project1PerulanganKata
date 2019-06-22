package com.example.project1;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import org.w3c.dom.Text;

public class frag1 extends Fragment {

    Button proses;
    EditText inputText;
    TextView resultView;
    @Nullable

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.frag1_layout,container,false );
    }

    @Nullable
    @Override
    public View getView() {

        inputText = (EditText) getActivity().findViewById(R.id.inputText);
        resultView = (TextView) getActivity().findViewById(R.id.resultView);
        proses = (Button) getActivity().findViewById(R.id.proses);
        requireActivity();
        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputText.getText().toString();
                resultView.setText(text);
            }
        });
        return super.getView();
    }
}







