package wook.song.s301047817.ui.home;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import wook.song.s301047817.R;

/* Wook Song, 301047817, Section 2 */
public class WookFragment extends Fragment {

    private WookViewModel homeViewModel;
    ArrayAdapter spinnerColorAdapter;
    ArrayAdapter spinnerThinknessAdapter;
    private int selectedColor;
    private int selectedThickness;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(WookViewModel.class);
        View root = inflater.inflate(R.layout.fragment_wook, container, false);
        final TextView textView = root.findViewById(R.id.wookTextHome);
        textView.setText(String.format("%s\n%s", getString(R.string.myname), getString(R.string.studentid)));
       /*
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        */
        Spinner penColor = root.findViewById(R.id.wookPenColor);
        spinnerColorAdapter = ArrayAdapter.createFromResource(getContext(), R.array.wookPenColor, android.R.layout.simple_spinner_dropdown_item);
        penColor.setAdapter(spinnerColorAdapter);
        penColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String color = (String)spinnerColorAdapter.getItem(i);
                switch (color) {
                    case "Red":
                        selectedColor = Color.RED;
                        break;
                    case "Green":
                        selectedColor = Color.GREEN;
                        break;
                    case "Blue":
                        selectedColor = Color.BLUE;
                        break;
                    default:
                        selectedColor = Color.RED;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedColor = Color.RED;
            }
        });

        Spinner penThickness = root.findViewById(R.id.wookPenThickness);
        spinnerThinknessAdapter = ArrayAdapter.createFromResource(getContext(), R.array.wookPenThickness, android.R.layout.simple_spinner_dropdown_item);
        penThickness.setAdapter(spinnerThinknessAdapter);
        penThickness.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = (String)spinnerThinknessAdapter.getItem(i);
                selectedThickness = Integer.parseInt(value);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedThickness = 5;
            }
        });

        Button clearButton = (Button)root.findViewById(R.id.wookButtonClearDrawing);
        final wookCanvasView canvas = (wookCanvasView)root.findViewById(R.id.wookCanvasView);
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                canvas.clear();
            }
        });
        Button setPenAttributeButton = root.findViewById(R.id.wookSetPenAttribute);
        setPenAttributeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                canvas.setPenAttribute(selectedColor,selectedThickness);
            }
        });

        return root;
    }
}