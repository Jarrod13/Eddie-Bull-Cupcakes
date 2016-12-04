package com.liamgoodwin.eddiebullcupcakes;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CupcakeCalculatorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CupcakeCalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CupcakeCalculatorFragment extends Fragment {
    private View myFragmentView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    public double totalPrice;
    public double totalDiscount;

    public double rainbowSprinkleQuantity;
    public double tripleChocoQuantity;
    public double pumpkinSpiceQuantity;
    public double peanutButterCupQuantity;
    public double funfettiExplosionQuantity;

    public double rainbowSprinklePrice;
    public double tripleChocoPrice;
    public double pumpkinSpicePrice;
    public double peanutButterCupPrice;
    public double funfettiExplosionPrice;

    public EditText rainbowSprinkleTextEdit = (EditText)myFragmentView.findViewById(R.id.rainbowSprinkleField);
    public EditText tripleChocoTextEdit = (EditText)myFragmentView.findViewById(R.id.tripleChocoField);
    public EditText pumpkinSpiceTextEdit = (EditText)myFragmentView.findViewById(R.id.pumpkinSpiceField);
    public EditText peanutButterCupTextEdit = (EditText)myFragmentView.findViewById(R.id.peanutButterCupField);
    public EditText funfettiExplosionTextEdit = (EditText)myFragmentView.findViewById(R.id.funfettiExplosionField);

    public CheckBox seniorBox = (CheckBox)myFragmentView.findViewById(R.id.senior);
    public CheckBox studentBox = (CheckBox)myFragmentView.findViewById(R.id.student);


    private OnFragmentInteractionListener mListener;

    public CupcakeCalculatorFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CupcakeCalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CupcakeCalculatorFragment newInstance(String param1, String param2) {
        CupcakeCalculatorFragment fragment = new CupcakeCalculatorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragmentView = inflater.inflate(R.layout.fragment_ingredients_calculator, container, false);

        rainbowSprinkleTextEdit.addTextChangedListener(rainbow);
        tripleChocoTextEdit.addTextChangedListener(choco);
        pumpkinSpiceTextEdit.addTextChangedListener(pumpkin);
        peanutButterCupTextEdit.addTextChangedListener(peanut);
        funfettiExplosionTextEdit.addTextChangedListener(funfetti);

        rainbowSprinklePrice = rainbowSprinkleQuantity * RainbowSprinkle.getPrice();
        tripleChocoPrice = tripleChocoQuantity * TripleChoco.getPrice();
        pumpkinSpicePrice = pumpkinSpiceQuantity * PumpkinSpice.getPrice();
        peanutButterCupPrice =  peanutButterCupQuantity * PeanutButterCup.getPrice();
        funfettiExplosionPrice = funfettiExplosionQuantity * FunfettiExplosion.getPrice();

        totalPrice = rainbowSprinklePrice + tripleChocoPrice + pumpkinSpicePrice + peanutButterCupPrice

        seniorBox.isPressed();
        studentBox.isPressed();

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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private TextWatcher rainbow = new TextWatcher() {

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            rainbowSprinkleQuantity = Double.valueOf(rainbowSprinkleTextEdit.getText().toString());
        }
    };

    private TextWatcher choco = new TextWatcher() {

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            tripleChocoQuantity = Double.valueOf(tripleChocoTextEdit.getText().toString());
        }
    };

    private TextWatcher pumpkin = new TextWatcher() {

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            pumpkinSpiceQuantity = Double.valueOf(pumpkinSpiceTextEdit.getText().toString());
        }
    };

    private TextWatcher peanut = new TextWatcher() {

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            peanutButterCupQuantity = Double.valueOf(peanutButterCupTextEdit.getText().toString());
        }
    };

    private TextWatcher funfetti = new TextWatcher() {

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            funfettiExplosionQuantity = Double.valueOf(funfettiExplosionTextEdit.getText().toString());
        }
    };
}
