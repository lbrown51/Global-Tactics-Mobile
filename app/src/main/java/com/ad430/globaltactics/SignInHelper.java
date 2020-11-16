package com.ad430.globaltactics;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

public class SignInHelper {
    private final String TAG = SignInHelper.class.getSimpleName();

    public SignInHelper() {
        FirebaseAuth auth = FirebaseAuth.getInstance();

//        if (auth.getCurrentUser() == null) return;

        auth.signInAnonymously()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInAnonymously:success");
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInAnonymously:failure", task.getException());
                    }
                });
    }
}
