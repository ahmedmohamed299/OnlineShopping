package com.example.hp.onlineshopping.UI.Fragmant;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hp.onlineshopping.Model.APIs;
import com.example.hp.onlineshopping.Model.DataModel.GetHome;
import com.example.hp.onlineshopping.Model.RetrofitAPI;
import com.example.hp.onlineshopping.R;
import com.example.hp.onlineshopping.UI.Adapters.HomeAdapter;
import com.example.hp.onlineshopping.UI.Base.BaseFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment {
    APIs apIs;
    RetrofitAPI retrofitAPI;
    GetHome.Product product;
    GetHome.HomeData homeData;

    RecyclerView recyclerHome;
    ImageView image1,image2,image3;
    HomeAdapter adapter;
    GridLayoutManager manager;
    List<GetHome.Product> products;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        apIs=RetrofitAPI.getApiService();


//        recyclerHome.setAdapter(adapter);






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        recyclerHome=view.findViewById(R.id.recyclerHome);
        image1=view.findViewById(R.id.image1);
        image2=view.findViewById(R.id.image2);
        image3=view.findViewById(R.id.image3);

        apIs.getHome("en").enqueue(new Callback<GetHome>() {
            @Override
            public void onResponse(Call<GetHome> call, Response<GetHome> response) {
                homeData = response.body().getHomeData();
                products = homeData.getHot();
                GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
                recyclerHome.setLayoutManager(manager);
                adapter = new HomeAdapter(getContext(), products);
                recyclerHome.setAdapter(adapter);
                Log.e("test",response.body().getHomeData().getUpBanner().size()+"");
                Glide.with(getContext())
                        .load(homeData.getUpBanner().get(0).getImage())
                        .into(image1);
                Glide.with(getContext())
                        .load(homeData.getUpBanner().get(1).getImage())
                        .into(image2);
                Glide.with(getContext())
                        .load(homeData.getDownBanner().getImage())
                        .into(image3);

            }

            @Override
            public void onFailure(Call<GetHome> call, Throwable t) {

            }
        });

        return view;
    }

}
