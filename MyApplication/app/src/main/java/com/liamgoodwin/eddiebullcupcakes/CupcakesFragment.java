package com.liamgoodwin.eddiebullcupcakes;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CupcakesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CupcakesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CupcakesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView CupcakeDescription;
    private ListView list;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CupcakesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CupcakesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CupcakesFragment newInstance(String param1, String param2) {
        CupcakesFragment fragment = new CupcakesFragment();
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cupcakes, container, false);
        String[] cupcakes = {"Rainbow Sprinkle", "Triple Choco", "Pumpkin Spice", "Peanut Butter Cup", "Funfetti Explosion"};

        CupcakeDescription = (TextView) view.findViewById(R.id.CupcakeDescription);
        list = (ListView) view.findViewById(R.id.cupcakelist);

        ArrayList<CupcakeItem> cupcakelist = new ArrayList<CupcakeItem>();

        cupcakelist.add(new CupcakeItem("Rainbow Sprinkle", "Try one of our signature Rainbow Sprinkle cupcakes loaded inside and out! Available in chocolate and vanilla cake with vanilla icing"));
        cupcakelist.add(new CupcakeItem("Triple Choco", "Try one of our signature Rainbow Sprinkle cupcakes loaded inside and out! Available in chocolate and vanilla cake with vanilla icing"));
        cupcakelist.add(new CupcakeItem("Pumpkin Spice", "Try one of our signature Rainbow Sprinkle cupcakes loaded inside and out! Available in chocolate and vanilla cake with vanilla icing"));
        cupcakelist.add(new CupcakeItem("Peanut Butter Cup", "Try one of our signature Rainbow Sprinkle cupcakes loaded inside and out! Available in chocolate and vanilla cake with vanilla icing"));
        cupcakelist.add(new CupcakeItem("Funfetti Explosion", "Try one of our signature Rainbow Sprinkle cupcakes loaded inside and out! Available in chocolate and vanilla cake with vanilla icing"));

        CupcakeAdapter adapter1 = new CupcakeAdapter(getContext(), cupcakelist);
        list.setAdapter(adapter1);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Hello World");
            }
        });

//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                System.out.println("Button clicked");
//                CupcakeDescription.setText(((CupcakeItem) list.getItemAtPosition(position)).getDescription());
//
//            }
//        });

        return view;
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

    public class CupcakeItem {
        private String name;
        private String description;

        public CupcakeItem(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() { return name; }

        public void setName(String name) { this.name = name; }

        public String getDescription() { return description; }

        public void setDescription(String description) { this.description = description; }

        public String toString() {
            return getName();
        }
    }
}
