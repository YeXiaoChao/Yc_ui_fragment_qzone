package com.yanis.yc_ui_qzone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentAuth extends Fragment {
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	return inflater.inflate(R.layout.fragment_auth, container, false);
}
}
