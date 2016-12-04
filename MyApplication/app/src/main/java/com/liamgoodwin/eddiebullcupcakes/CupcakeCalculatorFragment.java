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
import android.widget.TextView;

import org.w3c.dom.Text;


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
        myFragmentView = inflater.inflate(R.layout.fragment_cupcake_calculator, container, false);

        final EditText rainbowSprinkleTextEdit = (EditText)myFragmentView.findViewById(R.id.rainbowSprinkleField);
        final EditText tripleChocoTextEdit = (EditText)myFragmentView.findViewById(R.id.tripleChocoField);
        final EditText pumpkinSpiceTextEdit = (EditText)myFragmentView.findViewById(R.id.pumpkinSpiceField);
        final EditText peanutButterCupTextEdit = (EditText)myFragmentView.findViewById(R.id.peanutButterCupField);
        final EditText funfettiExplosionTextEdit = (EditText)myFragmentView.findViewById(R.id.funfettiExplosionField);

        final TextView rainbowSprinkleTotal = (TextView)myFragmentView.findViewById(R.id.rainbowSprinkleTotal);
        final TextView tripleChocoTotal = (TextView)myFragmentView.findViewById(R.id.tripleChocoTotal);
        final TextView pumpkinSpiceTotal = (TextView)myFragmentView.findViewById(R.id.pumpkinSpiceTotal);
        final TextView peanutButterCupTotal = (TextView)myFragmentView.findViewById(R.id.peanutButterCupTotal);
        final TextView funfettiExplosionTotal = (TextView)myFragmentView.findViewById(R.id.funfettiExplosionTotal);

        final CheckBox seniorBox = (CheckBox)myFragmentView.findViewById(R.id.senior);
        final CheckBox studentBox = (CheckBox)myFragmentView.findViewById(R.id.student);

        final TextView discountText = (TextView)myFragmentView.findViewById(R.id.discountTextView);
        final TextView totalText = (TextView)myFragmentView.findViewById(R.id.totalTextView);

        TextWatcher rainbow = new TextWatcher() {

            public void afterTextChanged(Editable s) {
                try {
                    rainbowSprinkleQuantity = Double.valueOf(rainbowSprinkleTextEdit.getText().toString());
                    rainbowSprinklePrice = rainbowSprinkleQuantity * RainbowSprinkle.getPrice();
                    rainbowSprinkleTotal.setText("$" + rainbowSprinklePrice);

                    totalPrice = rainbowSprinklePrice + tripleChocoPrice + pumpkinSpicePrice + peanutButterCupPrice + funfettiExplosionPrice;

                    if(seniorBox.isPressed() || studentBox.isPressed()) {
                        totalPrice = totalPrice * .90;
                        totalDiscount = totalPrice * .10;
                    }

                    discountText.setText("$" + totalDiscount);
                    totalText.setText("$" + totalPrice);

                } catch (NumberFormatException e) {
                    rainbowSprinkleQuantity = 0; // your default value
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }
        };

        TextWatcher choco = new TextWatcher() {

            public void afterTextChanged(Editable s) {
                try {
                    tripleChocoQuantity = Double.valueOf(tripleChocoTextEdit.getText().toString());
                    tripleChocoPrice = tripleChocoQuantity * TripleChoco.getPrice();
                    tripleChocoTotal.setText("$" + tripleChocoPrice);

                    totalPrice = rainbowSprinklePrice + tripleChocoPrice + pumpkinSpicePrice + peanutButterCupPrice + funfettiExplosionPrice;

                    if(seniorBox.isPressed() || studentBox.isPressed()) {
                        totalPrice = totalPrice * .90;
                        totalDiscount = totalPrice * .10;
                    }

                    discountText.setText("$" + totalDiscount);
                    totalText.setText("$" + totalPrice);
                } catch (NumberFormatException e) {
                    tripleChocoQuantity = 0; // your default value
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }
        };

        TextWatcher pumpkin = new TextWatcher() {

            public void afterTextChanged(Editable s) {
                try {
                    pumpkinSpiceQuantity = Double.valueOf(pumpkinSpiceTextEdit.getText().toString());
                    pumpkinSpicePrice = pumpkinSpiceQuantity * PumpkinSpice.getPrice();
                    pumpkinSpiceTotal.setText("$" + pumpkinSpicePrice);

                    totalPrice = rainbowSprinklePrice + tripleChocoPrice + pumpkinSpicePrice + peanutButterCupPrice + funfettiExplosionPrice;

                    if(seniorBox.isPressed() || studentBox.isPressed()) {
                        totalPrice = totalPrice * .90;
                        totalDiscount = totalPrice * .10;
                    }

                    discountText.setText("$" + totalDiscount);
                    totalText.setText("$" + totalPrice);
                } catch (NumberFormatException e) {
                    pumpkinSpiceQuantity = 0; // your default value
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }
        };

        TextWatcher peanut = new TextWatcher() {

            public void afterTextChanged(Editable s) {
                try {
                    peanutButterCupQuantity = Double.valueOf(peanutButterCupTextEdit.getText().toString());
                    peanutButterCupPrice =  peanutButterCupQuantity * PeanutButterCup.getPrice();
                    peanutButterCupTotal.setText("$" + peanutButterCupPrice);

                    totalPrice = rainbowSprinklePrice + tripleChocoPrice + pumpkinSpicePrice + peanutButterCupPrice + funfettiExplosionPrice;

                    if(seniorBox.isPressed() || studentBox.isPressed()) {
                        totalPrice = totalPrice * .90;
                        totalDiscount = totalPrice * .10;
                    }

                    discountText.setText("$" + totalDiscount);
                    totalText.setText("$" + totalPrice);
                } catch (NumberFormatException e) {
                    peanutButterCupQuantity = 0; // your default value
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }
        };

        TextWatcher funfetti = new TextWatcher() {

            public void afterTextChanged(Editable s) {
                try {
                    funfettiExplosionQuantity = Double.valueOf(funfettiExplosionTextEdit.getText().toString());
                    funfettiExplosionPrice = funfettiExplosionQuantity * FunfettiExplosion.getPrice();
                    funfettiExplosionTotal.setText("$" + funfettiExplosionPrice);

                    totalPrice = rainbowSprinklePrice + tripleChocoPrice + pumpkinSpicePrice + peanutButterCupPrice + funfettiExplosionPrice;

                    if(seniorBox.isPressed() || studentBox.isPressed()) {
                        totalPrice = totalPrice * .90;
                        totalDiscount = totalPrice * .10;
                    }

                    discountText.setText("$" + totalDiscount);
                    totalText.setText("$" + totalPrice);
                } catch (NumberFormatException e) {
                    funfettiExplosionQuantity = 0; // your default value
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }
        };

        rainbowSprinkleTextEdit.addTextChangedListener(rainbow);
        tripleChocoTextEdit.addTextChangedListener(choco);
        pumpkinSpiceTextEdit.addTextChangedListener(pumpkin);
        peanutButterCupTextEdit.addTextChangedListener(peanut);
        funfettiExplosionTextEdit.addTextChangedListener(funfetti);

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

}
