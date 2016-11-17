package com.liamgoodwin.eddiebullcupcakes;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BakingTipsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BakingTipsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BakingTipsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SectionPagerAdapter mSectionsPagerAdapter;
    private OnFragmentInteractionListener mListener;
    private ViewPager mViewPager;

    public BakingTipsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BakingTipsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BakingTipsFragment newInstance(String param1, String param2) {
        BakingTipsFragment fragment = new BakingTipsFragment();
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
        View view =  inflater.inflate(R.layout.fragment_baking_tips, container, false);
        mSectionsPagerAdapter = new SectionPagerAdapter(getChildFragmentManager());
        mViewPager = (ViewPager) view.findViewById(R.id.bakingTips);
        mViewPager.setAdapter(mSectionsPagerAdapter);
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public class SectionPagerAdapter extends FragmentPagerAdapter {
        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return BakingTipsDisplayFragment.newInstance("Use room temperature ingredients");
                case 1:
                    return BakingTipsDisplayFragment.newInstance("Invest in quality bakeware");
                case 2:
                    return BakingTipsDisplayFragment.newInstance("Butter and flour your pan generously");
                case 3:
                    return BakingTipsDisplayFragment.newInstance("Weigh ingredients");
                case 4:
                    return BakingTipsDisplayFragment.newInstance("Take your time to fully complete each step");
                case 5:
                    return BakingTipsDisplayFragment.newInstance("Always use salt");
                case 6:
                    return BakingTipsDisplayFragment.newInstance("Rotate halfway through");
                case 7:
                    return BakingTipsDisplayFragment.newInstance("Don't mess with the oven temperature and cooking time");
                case 8:
                    return BakingTipsDisplayFragment.newInstance("Let it cool completely");
                case 9:
                    return BakingTipsDisplayFragment.newInstance("Get an oven thermometer");
                case 10:
                    return BakingTipsDisplayFragment.newInstance("Chill your cookie dough");
                case 11:
                    return BakingTipsDisplayFragment.newInstance("Avoid using cold eggs");
                default:
                    return BakingTipsDisplayFragment.newInstance("Whoops");
            }
        }

        public int getCount() {
            return 12;
        }
    }
}

