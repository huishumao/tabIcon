package yzj.badu.com.tablaouticon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/12/17.
 *
 * @projectName ${}
 */
public class OneFragment extends Fragment {
    public static final String TYPE = "type";
    private View parentView;
    private TextView txt_content;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        parentView = inflater.inflate(R.layout.fragment_my, container, false);
        initView();
        return parentView;
    }

    private void initView() {

        txt_content = (TextView) parentView.findViewById(R.id.textview);
        txt_content.setText(getArguments().getString(TYPE, "Default"));
    }

    public static OneFragment newInstance(String text) {
        OneFragment fragment = new OneFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TYPE, text);
        fragment.setArguments(bundle);
        return fragment;
    }
}
