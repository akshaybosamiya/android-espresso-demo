package com.akshaybosamiya.demoespresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.akshaybosamiya.demoespresso.IdlingResourceSample.IdlingResourceActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    // The TextView used to display the message inside the Activity.
    private TextView mTextView;

    // The EditText where the user types the message.
    private EditText mEditText;

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the listeners for the buttons.
        findViewById(R.id.changeTextBt).setOnClickListener(this);
        findViewById(R.id.activityChangeTextBtn).setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textToBeChanged);
        mEditText = (EditText) findViewById(R.id.editTextUserInput);
        mButton = (Button)findViewById(R.id.activityIdleResource);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Get the text from the EditText view.
        final String text = mEditText.getText().toString();

        switch (view.getId()) {
            case R.id.changeTextBt:
                // First button's interaction: set a text in a text view.
                //For a while commented
                if (TextUtils.isEmpty(text)) {
                    mEditText.setError("Type Here!");
                    return;
                }
                //mTextView.setText(text);
                break;
            case R.id.activityChangeTextBtn:
                // Second button's interaction: start an activity and send a message to it.
                if (TextUtils.isEmpty(text)) {
                    mEditText.setError("Type Here!");
                    return;
                }
                Intent intent = ShowTextActivity.newStartIntent(this, text);
                startActivity(intent);
                break;

            case R.id.activityDataAdapter:
                break;

            case R.id.activityIdleResource:
                Intent i = new Intent(this, IdlingResourceActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
        Log.e(TAG, "onClick: "+view.getId());
    }
}
