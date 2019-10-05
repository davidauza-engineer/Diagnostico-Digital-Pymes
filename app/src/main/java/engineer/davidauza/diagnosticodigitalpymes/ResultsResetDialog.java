package engineer.davidauza.diagnosticodigitalpymes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;


/**
 * This class handles the Dialog created when the user wants to reset its answers
 */
public class ResultsResetDialog extends AppCompatDialogFragment {

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.results_reset_title);
        builder.setMessage(R.string.results_reset_body);
        builder.setNegativeButton(R.string.results_reset_no,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });
        builder.setPositiveButton(R.string.results_reset_yes,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Set back all the answers to its default state
                        Context context = getContext();
                        SharedPreferences settings = null;
                        if (context != null) {
                            settings = getContext().
                                    getSharedPreferences(QuestionAdapter.PREFS_NAME, 0);
                        }
                        if (settings != null) {
                            SharedPreferences.Editor editor = settings.edit();
                            // Company name
                            editor.putString("mCompanyName", "");
                            // Need to reflect changes immediately
                            editor.apply();
                            //Question One
                            editor.putBoolean("QuestionOneCheckBoxOne", false);
                            editor.putBoolean("QuestionOneCheckBoxTwo", false);
                            editor.putBoolean("QuestionOneCheckBoxThree", false);
                            editor.putBoolean("QuestionOneCheckBoxFour", false);
                            // Question Two
                            editor.putBoolean("QuestionTwoRadioButtonOne", false);
                            editor.putBoolean("QuestionTwoRadioButtonTwo", false);
                            //Question Three
                            editor.putBoolean("QuestionThreeRadioButtonOne", false);
                            editor.putBoolean("QuestionThreeRadioButtonTwo", false);
                            // Question Four
                            editor.putBoolean("QuestionFourCheckBoxOne", false);
                            editor.putBoolean("QuestionFourCheckBoxTwo", false);
                            editor.putBoolean("QuestionFourCheckBoxThree", false);
                            editor.putBoolean("QuestionFourCheckBoxFour", false);
                            editor.putBoolean("QuestionFourCheckBoxFive", false);
                            editor.putBoolean("QuestionFourCheckBoxSix", false);
                            // Question Five
                            editor.putBoolean("QuestionFiveCheckBoxOne", false);
                            editor.putBoolean("QuestionFiveCheckBoxTwo", false);
                            editor.putBoolean("QuestionFiveCheckBoxThree", false);
                            editor.putBoolean("QuestionFiveCheckBoxFour", false);
                            // Question Six
                            editor.putBoolean("QuestionSixRadioButtonOne", false);
                            editor.putBoolean("QuestionSixRadioButtonTwo", false);
                            // Question Seven
                            editor.putBoolean("QuestionSevenRadioButtonOne", false);
                            editor.putBoolean("QuestionSevenRadioButtonTwo", false);
                            // Question Eight
                            editor.putBoolean("QuestionEightCheckBoxOne", false);
                            editor.putBoolean("QuestionEightCheckBoxTwo", false);
                            editor.putBoolean("QuestionEightCheckBoxThree", false);
                            editor.putBoolean("QuestionEightCheckBoxFour", false);
                            editor.putBoolean("QuestionEightCheckBoxFive", false);
                            editor.putBoolean("QuestionEightCheckBoxSix", false);
                            // Question Nine
                            editor.putBoolean("QuestionNineCheckBoxOne", false);
                            editor.putBoolean("QuestionNineCheckBoxTwo", false);
                            editor.putBoolean("QuestionNineCheckBoxThree", false);
                            editor.putBoolean("QuestionNineCheckBoxFour", false);
                            // Question Ten
                            editor.putBoolean("QuestionTenRadioButtonOne", false);
                            editor.putBoolean("QuestionTenRadioButtonTwo", false);

                            editor.apply();
                        }

                        // Finish the TestResults Activity
                        Activity currentActiviy = getActivity();
                        if (currentActiviy != null) {
                            getActivity().finish();
                        }

                        // Set reset to true in TestActivity so the Activity gets restarted when
                        // resumed
                        MainActivity.reset = true;
                    }
                });
        return builder.create();
    }
}
