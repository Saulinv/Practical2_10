package com.mirea.kt.practical2_10;





import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.PlantViewHolder> {

    private List<Plant> plantList;

    public PlantAdapter(List<Plant> plantList) {
        this.plantList = plantList;
    }

    @NonNull
    @Override
    public PlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_plant_adapter, parent, false);
        return new PlantViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantViewHolder holder, int position) {
        Plant plant = plantList.get(position);
        holder.textViewName.setText(plant.getName());
        holder.textViewSpecies.setText(plant.getSpecies());
        holder.textViewGreenhouse.setText(plant.isGreenhouse() ? "Yes" : "No");
    }

    @Override
    public int getItemCount() {
        return plantList.size();
    }

    public static class PlantViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewSpecies, textViewGreenhouse;

        public PlantViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewSpecies = itemView.findViewById(R.id.textViewSpecies);
            textViewGreenhouse = itemView.findViewById(R.id.textViewGreenhouse);
        }
    }
}
