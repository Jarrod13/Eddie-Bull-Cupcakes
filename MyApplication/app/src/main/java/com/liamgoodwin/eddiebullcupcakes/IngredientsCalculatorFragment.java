package com.liamgoodwin.eddiebullcupcakes;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IngredientsCalculatorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IngredientsCalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class IngredientsCalculatorFragment extends Fragment {

    private View myFragmentView;

    EditText flour;
    EditText bakingPowder;
    EditText bakingSoda;
    EditText salt;
    EditText sugar;
    EditText cocoa;
    EditText vegetableOil;
    EditText eggs;
    EditText vanillaExtract;
    EditText milk;

    SeekBar seekBar;

    private double flourAmount = 1.5;
    private double bakingPowderAmount = 1.5;
    private double bakingSodaAmount = .5;
    private double saltAmount = .25;
    private double sugarAmount = 1;
    private double cocoaAmount = .75;
    private double vegetableOilAmount = .75;
    private double eggsAmount = 2;
    private double vanillaExtractAmount = 1;
    private double milkAmount = 1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IngredientsCalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IngredientsCalculatorFragment newInstance(String param1, String param2) {
        IngredientsCalculatorFragment fragment = new IngredientsCalculatorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public IngredientsCalculatorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flour = (EditText) myFragmentView.findViewById(R.id.flourEditText);
        bakingPowder = (EditText) myFragmentView.findViewById(R.id.bakingPowderEditText);
        bakingSoda = (EditText) myFragmentView.findViewById(R.id.bakingSodaEditText);
        salt = (EditText) myFragmentView.findViewById(R.id.saltEditText);
        sugar = (EditText) myFragmentView.findViewById(R.id.sugarEditText);
        cocoa = (EditText) myFragmentView.findViewById(R.id.cocoaEditText);
        vegetableOil = (EditText) myFragmentView.findViewById(R.id.vegetableOilEditText);
        eggs = (EditText) myFragmentView.findViewById(R.id.eggsEditText);
        vanillaExtract = (EditText) myFragmentView.findViewById(R.id.vanillaExtractEditText);
        milk = (EditText) myFragmentView.findViewById(R.id.milkEditText);

        seekBar = (SeekBar) myFragmentView.findViewById(R.id.sb);

        flour.setText(flourAmount + "");
        bakingPowder.setText(bakingPowderAmount + "");
        bakingSoda.setText(bakingSodaAmount + "");
        salt.setText(saltAmount + "");
        sugar.setText(sugarAmount + "");
        cocoa.setText(cocoaAmount + "");
        vegetableOil.setText(vegetableOilAmount + "");
        eggs.setText(eggsAmount + "");
        vanillaExtract.setText(vanillaExtractAmount + "");
        milk.setText(milkAmount + "");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        myFragmentView = inflater.inflate(R.layout.fragment_ingredients_calculator, container, false);

        return myFragmentView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private final SeekBar.OnSeekBarChangeListener sbListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar)
        {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

}
