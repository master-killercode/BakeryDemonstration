package com.master.killercode.libmsgdemonstration.ToolBox;

import android.content.res.ColorStateList;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ToolBox {

    public static void disableAllOptions(RadioGroup group) {
        for (int i = 0; i < group.getChildCount(); i++) {
            group.getChildAt(i).setEnabled(false);
        }
    }

    public static void setColor(RadioGroup group) {
        for (int i = 0; i < group.getChildCount(); i++) {
            group.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(0x000000));
        }
    }
}
