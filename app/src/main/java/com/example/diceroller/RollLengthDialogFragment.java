package com.example.diceroller;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class RollLengthDialogFragment extends DialogFragment {

    public interface OnRollLengthSelectedListener {
        void onRollLengthClick(int which);
    }

    private OnRollLengthSelectedListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(R.string.pick_roll_length);
        builder.setItems(R.array.length_array, (dialog, which) -> {
            mListener.onRollLengthClick(which);
        });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (OnRollLengthSelectedListener) context;
    }
}