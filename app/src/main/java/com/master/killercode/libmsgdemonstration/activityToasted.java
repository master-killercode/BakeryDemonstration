package com.master.killercode.libmsgdemonstration;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.master.killercode.toolbox_msg.Logger;
import com.master.killercode.toolbox_msg.Toasted;

import static com.master.killercode.libmsgdemonstration.ToolBox.ToolBox.disableAllOptions;
import static com.master.killercode.libmsgdemonstration.ToolBox.ToolBox.setColor;

public class activityToasted extends AppCompatActivity implements View.OnClickListener {

    //Toasted Functions
    private int toastedType;
    private int toastedGravity;
    private int toastedGravityText;
    private int toastedDuration;
    private int toastedIconShow;

    //Toolbar
    private Toolbar toolbar;

    //init
    private Activity activity;

    //String
    private String msg = "";

    //EditText
    private EditText etMsg;

    //Button
    private Button btnWarning;
    private Button btnSuccess;
    private Button btnInfo;
    private Button btnError;
    private Button btnNeutral;

    //FloatingActionButton
    private FloatingActionButton fab;

    //RadioGroup
    private RadioGroup rgType;
    private RadioGroup rgTextGravity;
    private RadioGroup rgShow;
    private RadioGroup rgToastedGravity;
    private RadioGroup rgIconShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.Information();
        Logger.Information("Wellcome to app");

        activity = activityToasted.this;

        initVars();
        initActions();

    }

    private void initVars() {

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Toasted");

        //EditText
        etMsg = findViewById(R.id.etMsg);

        //Button
        btnWarning = findViewById(R.id.btnWarning);
        btnSuccess = findViewById(R.id.btnSuccess);
        btnInfo = findViewById(R.id.btnInfo);
        btnError = findViewById(R.id.btnError);
        btnNeutral = findViewById(R.id.btnNeutral);

        //FloatingActionButton
        fab = (FloatingActionButton) findViewById(R.id.fab);

        //RadioGroup
        rgType = findViewById(R.id.rgType);
        rgTextGravity = findViewById(R.id.rgTextGravity);
        rgShow = findViewById(R.id.rgShow);
        rgToastedGravity = findViewById(R.id.rgToastedGravity);
        rgIconShow = findViewById(R.id.rgIconShow);

    }

    private void initActions() {

        //Button's Clicks
        btnWarning.setOnClickListener(this);
        btnSuccess.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        btnError.setOnClickListener(this);
        btnNeutral.setOnClickListener(this);

        //
        rgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton button = (RadioButton) group.findViewById(checkedId);

                switch (checkedId) {
                    case R.id.rbW:
                        toastedType = Toasted.TYPE_WARNING;
                        break;
                    case R.id.rbS:
                        toastedType = Toasted.TYPE_SUCCESS;
                        break;
                    case R.id.rbI:
                        toastedType = Toasted.TYPE_INFO;
                        break;
                    case R.id.rbE:
                        toastedType = Toasted.TYPE_ERROR;
                        break;
                    case R.id.rbN:
                        toastedType = Toasted.TYPE_NELTO;
                        break;
                }
            }
        });

        //
        rgTextGravity.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton button = (RadioButton) group.findViewById(checkedId);

                switch (checkedId) {
                    case R.id.rbGS:
                        toastedGravityText = Toasted.TEXT_GRAVITY_START;
                        break;
                    case R.id.rbGC:
                        toastedGravityText = Toasted.TEXT_GRAVITY_CENTER;
                        break;
                    case R.id.rbGE:
                        toastedGravityText = Toasted.TEXT_GRAVITY_END;
                        break;
                    case R.id.rbGL:
                        toastedGravityText = Toasted.TEXT_GRAVITY_LEFT;
                        break;
                    case R.id.rbGR:
                        toastedGravityText = Toasted.TEXT_GRAVITY_RIGHT;
                        break;
                }
            }
        });

        //
        rgShow.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton button = (RadioButton) group.findViewById(checkedId);

                switch (checkedId) {
                    case R.id.rbL:
                        toastedDuration = Toasted.DURATION_LONG;
                        break;
                    case R.id.rbSh:
                        toastedDuration = Toasted.DURATION_SHORT;
                        break;
                }
            }
        });

        //
        rgToastedGravity.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton button = (RadioButton) group.findViewById(checkedId);

                switch (checkedId) {
                    case R.id.rbTosBF:
                        toastedGravity = Toasted.GRAVITY_BOTTON_FILL;
                        break;
                    case R.id.rbTosCF:
                        toastedGravity = Toasted.GRAVITY_CENTER_FILL;
                        break;
                    case R.id.rbTosTF:
                        toastedGravity = Toasted.GRAVITY_TOP_FILL;
                        break;
                    case R.id.rbTosB:
                        toastedGravity = Toasted.GRAVITY_BOTTON;
                        break;
                    case R.id.rbTosC:
                        toastedGravity = Toasted.GRAVITY_CENTER;
                        break;
                    case R.id.rbTosT:
                        toastedGravity = Toasted.GRAVITY_TOP;
                        break;
                    case R.id.rbTosFS:
                        toastedGravity = Toasted.GRAVITY_FULL_SCREEN;
                        break;
                    case R.id.rbTosN:
                        toastedGravity = Toasted.GRAVITY_NORMAL;
                        break;
                    case R.id.rbTosHT:
                        toastedGravity = Toasted.GRAVITY_HALF_TOP;
                        break;
                    case R.id.rbTosHB:
                        toastedGravity = Toasted.GRAVITY_HALF_BOTTON;
                        break;
                }
            }
        });

        //
        rgIconShow.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton button = (RadioButton) group.findViewById(checkedId);

                switch (checkedId) {
                    case R.id.rbINS:
                        toastedIconShow = Toasted.ICON_NOT_SHOW;
                        break;
                    case R.id.rbISA:
                        toastedIconShow = Toasted.ICON_SHOW_ALL;
                        break;
                    case R.id.rbSL:
                        toastedIconShow = Toasted.ICON_SHOW_LEFT;
                        break;
                    case R.id.rbSR:
                        toastedIconShow = Toasted.ICON_SHOW_RIGHT;
                        break;
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = etMsg.getText().toString().trim();

                if (msg.equals("") || msg.equals("null")) {
                    Toasted.makeTextError(activity, getString(R.string.please_type), Toasted.DURATION_SHORT, Toasted.ICON_SHOW_LEFT);
                } else {
                    Toasted.makeTextCustom(activity,
                            msg,
                            toastedDuration,
                            toastedGravity,
                            toastedType,
                            toastedGravityText,
                            toastedIconShow);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        msg = etMsg.getText().toString().trim();

        if (msg.equals("")) {
            Toasted.makeTextError(activity, getString(R.string.please_type), Toasted.DURATION_SHORT, Toasted.ICON_SHOW_LEFT);
        } else {
            switch (id) {
                case R.id.btnWarning:
                    Toasted.makeTextWarning(activity, msg, Toasted.DURATION_SHORT, Toasted.ICON_SHOW_LEFT);
                    break;
                case R.id.btnSuccess:
                    Toasted.makeTextSuccess(activity, msg, Toasted.DURATION_SHORT, Toasted.ICON_SHOW_LEFT);
                    break;
                case R.id.btnInfo:
                    Toasted.makeTextInfo(activity, msg, Toasted.DURATION_SHORT, Toasted.ICON_SHOW_LEFT);
                    break;
                case R.id.btnError:
                    Toasted.makeTextError(activity, msg, Toasted.DURATION_SHORT, Toasted.ICON_SHOW_LEFT);
                    break;
                case R.id.btnNeutral:
                    Toasted.makeText(activity, msg, Toasted.DURATION_SHORT, Toasted.ICON_SHOW_LEFT);
                    break;
            }
        }
        Logger.Information(String.valueOf(v.getTransitionName()) + " Clicked");
        Logger.Information(msg);
    }
}
