package com.example.bitsandpizzas2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;

public class PizzaFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pizzaRecycle = (RecyclerView)inflater.inflate(R.layout.fragment_pizza, container, false);
        String[] pizzaName = new String[Pizza.pizzas.length];
        for(int i = 0; i < pizzaName.length; i++)
            pizzaName[i] = Pizza.pizzas[i].getName();
        int[] pizzaImages = new int[Pizza.pizzas.length];
        for(int i = 0; i < pizzaImages.length; i++)
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaName, pizzaImages);
        pizzaRecycle.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycle.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int postion) {
                Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID, postion);
                getActivity().startActivity(intent);
            }
        });
        return pizzaRecycle;
    }

}
