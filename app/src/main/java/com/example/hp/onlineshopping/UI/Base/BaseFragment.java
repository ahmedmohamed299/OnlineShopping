package com.example.hp.onlineshopping.UI.Base;

import android.support.v4.app.Fragment;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.hp.onlineshopping.R;


public class BaseFragment extends Fragment {


    public MaterialDialog showConfirmationDialog(String title, String message,
                                                 String posText, String negText,
                                                 MaterialDialog.SingleButtonCallback posAction,
                                                 MaterialDialog.SingleButtonCallback negAction){
        MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
                .title(title)
                .content(message)
                .positiveText(posText)
                .negativeText(negText)
                .onNegative(negAction)
                .onPositive(posAction)
                .show();

        return dialog;

    }
    MaterialDialog dialog;
    public MaterialDialog ShowProgressBar(){
        dialog =   new MaterialDialog.Builder(getActivity())
                .content(getString(R.string.loading))
                .progress(true,0)
                .cancelable(false)
                .show();

        return dialog;

    }
    public void hideProgressBar(){

        if(dialog !=null && dialog.isShowing())
            dialog.dismiss();
    }
}
