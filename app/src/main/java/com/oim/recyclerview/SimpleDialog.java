package com.oim.recyclerview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

public class SimpleDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // création d'une instance alerte dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // titre du dialog
        builder.setTitle("Error")
                // message du dialog
                .setMessage("See fill all the fields")
                // bouton ok du dialog
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();
    }
}
