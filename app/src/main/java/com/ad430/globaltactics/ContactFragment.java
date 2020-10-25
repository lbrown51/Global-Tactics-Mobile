package com.ad430.globaltactics;

import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public ContactFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact,
                container, false);

        final EditText your_name = view.findViewById(R.id.your_name);
        final EditText your_email = view.findViewById(R.id.your_email);
        final EditText your_subject = view.findViewById(R.id.your_subject);
        final EditText your_message = view.findViewById(R.id.your_message);

        Button email = view.findViewById(R.id.post_message);
        boolean testEmailValidity = isValidEmail("test@gmail.com");
//        email.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                String name      = your_name.getText().toString();
//                String email     = your_email.getText().toString();
//                String subject   = your_subject.getText().toString();
//                String message   = your_message.getText().toString();
//
//                if (TextUtils.isEmpty(name)){
//                    your_name.setError("Enter Your Name");
//                    your_name.requestFocus();
//                    return;
//                }
//
//                boolean onError = false;
//
//                if (!isValidEmail(email)) {
//                    onError = true;
//                    your_email.setError("Invalid Email");
//                    return;
//                }
//
//                if (TextUtils.isEmpty(subject)){
//                    your_subject.setError("Enter Your Subject");
//                    your_subject.requestFocus();
//                    return;
//                }
//
//                if (TextUtils.isEmpty(message)){
//                    your_message.setError("Enter Your Message");
//                    your_message.requestFocus();
//                    return;
//                }
//
//            }
//        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //Get a Tracker (should auto-report)
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}