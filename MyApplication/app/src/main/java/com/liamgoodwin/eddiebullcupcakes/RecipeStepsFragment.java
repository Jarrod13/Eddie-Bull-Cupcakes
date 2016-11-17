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
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecipeStepsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecipeStepsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeStepsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SectionPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private OnFragmentInteractionListener mListener;

    public RecipeStepsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecipeStepsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipeStepsFragment newInstance(String param1, String param2) {
        RecipeStepsFragment fragment = new RecipeStepsFragment();
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
        View view = inflater.inflate(R.layout.fragment_triple_choco_recipe, container, false);
        mSectionsPagerAdapter = new SectionPagerAdapter(getChildFragmentManager());
        mViewPager = (ViewPager) view.findViewById(R.id.recipecontent);
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public class SectionPagerAdapter extends FragmentPagerAdapter {
        public SectionPagerAdapter(FragmentManager fm) { super(fm); }

        public Fragment getItem(int position) {
            switch(position) {
                case 0: return TripleChocoRecipeFragment.newInstance("Step #1", "Preheat oven to 350.");
                case 1: return TripleChocoRecipeFragment.newInstance("Step #2", "Whip butter until fluffy. Add sugars and continue to beat for about 2 minutes.");
                case 2: return TripleChocoRecipeFragment.newInstance("Step #3", "Add eggs one at a time and beat until well-combined.");
                case 3: return TripleChocoRecipeFragment.newInstance("Step #4", "Add in vanilla, buttermilk, sour cream, and coffee and stir slightly.");
                case 4: return TripleChocoRecipeFragment.newInstance("Step #5", "Sift in flour, cocoa, baking soda, and salt a little at a time and stir just until combined. Don’t overmix.");
                case 5: return TripleChocoRecipeFragment.newInstance("Step #6", "Scoop batter into prepared cupcake tin.");
                case 6: return TripleChocoRecipeFragment.newInstance("Step #7", "Bake at 350 for 20 minutes or until toothpick comes out clean.");
                default: return TripleChocoRecipeFragment.newInstance("No Step Available", "Please try again.");
            }
        }

        public int getCount() { return 7; }
    }
}
