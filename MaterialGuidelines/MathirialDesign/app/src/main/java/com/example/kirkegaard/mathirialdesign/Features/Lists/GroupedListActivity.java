package com.example.kirkegaard.mathirialdesign.Features.Features.Lists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kirkegaard.mathirialdesign.R;

import java.util.ArrayList;
import java.util.List;

public class GroupedListActivity extends AppCompatActivity {

    private List<CountriesData> countriesData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grouped_list);

        countriesData = new ArrayList<CountriesData>();

        MakeDummyData();

        SetupRecyclerView();
    }

    private void SetupRecyclerView()
    {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.grouped_reyclerview);

        GroupedAdapter adapter = new GroupedAdapter(countriesData);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
    }

    private void MakeDummyData()
    {
        MakeDummyDataSection("A", 10);
        MakeDummyDataSection("C", 4);
        MakeDummyDataSection("G", 13);
        MakeDummyDataSection("H", 12);
        MakeDummyDataSection("Z", 3);
    }

    private void MakeDummyDataSection(String letter, int itemsCount)
    {
        List<String> cities = new ArrayList<String>();
        for (int i = 0; i < itemsCount; i++)
        {
            cities.add(letter + (i+1));
        }

        countriesData.add(new CountriesData(letter, cities));
    }

    private class CountriesData
    {
        public CountriesData(String letter, List<String> countries)
        {
            Letter = letter;
            Countries = countries;
        }

        public String Letter;

        public List<String> Countries;
    }

    private class GroupedAdapter extends RecyclerView.Adapter
    {
        private final int HEADER_TYPE = 0;
        private final int ITEM_TYPE = 1;

        private List<CountriesData> _data;
        private List<ItemInformation> _itemTypes;

        public GroupedAdapter(List<CountriesData> data)
        {
            _data = data;
            SetItemInformation();
        }

        private void SetItemInformation()
        {
            _itemTypes = new ArrayList<ItemInformation>();
            int categorySize = _data.size();
            for (int i = 0; i < categorySize; i++)
            {
                _itemTypes.add(new ItemInformation(HEADER_TYPE, i, 0));

                for (int j = 0; j < _data.get(i).Countries.size(); j++)
                {
                    _itemTypes.add(new ItemInformation(ITEM_TYPE, i, j));
                }
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            if (viewType == HEADER_TYPE)
            {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group_header, parent, false);
                return new HeaderViewHolder(itemView);
            }
            else
            {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group_country, parent, false);
                return new CountryViewHolder(itemView);
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
        {
            ItemInformation info = _itemTypes.get(position);
            if (holder instanceof HeaderViewHolder)
            {
                // Populate header data;
                String headerText = _data.get(info.GroupIndex).Letter;
                ((HeaderViewHolder)holder).PopulateWithData(headerText);
            }
            else
            {
                // Populate item data;
                String itemText = _data.get(info.GroupIndex).Countries.get(info.InnerIndex);
                ((CountryViewHolder)holder).PopulateWithData(itemText);
            }
        }

        @Override
        public int getItemViewType(int position)
        {
            ItemInformation info = _itemTypes.get(position);
            return info.ItemType;
        }

        @Override
        public int getItemCount()
        {

            int itemCount = 0;

            for (CountriesData countryWithSameLetter: _data)
            {
                // For header
                itemCount ++;

                // For content
                itemCount += countryWithSameLetter.Countries.size();
            }

            return itemCount;
        }

        private class ItemInformation
        {
            public ItemInformation(int itemType, int groupIndex, int innerIndex)
            {
                ItemType = itemType;
                GroupIndex = groupIndex;
                InnerIndex = innerIndex;
            }

            public int ItemType;

            public int GroupIndex;

            public int InnerIndex;
        }
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder
    {
        private TextView headerTextView;

        public HeaderViewHolder(View itemView)
        {
            super(itemView);

            headerTextView = (TextView)itemView.findViewById(R.id.group_header_textview);
        }

        public void PopulateWithData(String text)
        {
            headerTextView.setText(text);
        }
    }

    private class CountryViewHolder extends  RecyclerView.ViewHolder
    {
        private TextView itemTextView;

        public CountryViewHolder(View itemView)
        {
            super(itemView);

            itemTextView = (TextView)itemView.findViewById(R.id.group_country_textview);
        }


        public void PopulateWithData(String text)
        {
            itemTextView.setText(text);
        }
    }
}