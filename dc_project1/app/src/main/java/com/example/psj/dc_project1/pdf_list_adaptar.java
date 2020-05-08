package com.example.psj.dc_project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class pdf_list_adaptar extends BaseAdapter {
    private TextView client_name_text; // 고객 이름을 저장하기 위한 텍스트
    private TextView saved_date_text; // pdf파일 저장 일자를 저장하기 위한 텍스트

    private ArrayList<SavedPdfList> splist = new ArrayList<SavedPdfList>();
    public pdf_list_adaptar(){

    }

    @Override
    public int getCount() {
        return splist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }


}
