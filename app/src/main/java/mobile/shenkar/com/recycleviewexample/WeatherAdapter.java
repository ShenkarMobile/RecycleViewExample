package mobile.shenkar.com.recycleviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cadan on 23/10/2015.
 */
public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder>  {

    private List<WeatherItem> weatherItems;
    public  WeatherAdapter(List<WeatherItem> weatherItems){
        this.weatherItems = weatherItems;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_card, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        WeatherItem item = weatherItems.get(position);
        holder.mTvDescription.setText(item.getDescription());
        holder.mTvDegree.setText(String.format("%s", item.getDegree()));
        holder.mTvDay.setText(String.format("%s",item.getDay()));
        holder.mImgItemImage.setImageResource(item.getImageResource());
    }

    @Override
    public int getItemCount() {
        return weatherItems.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Each item is a view in the card.
        private TextView mTvDescription;
        private TextView mTvDegree;
        private TextView mTvDay;
        private ImageView mImgItemImage;
        public ViewHolder(View parentView) {
            super(parentView);
            mTvDescription = (TextView) parentView.findViewById(R.id.textView_description);
            mTvDay = (TextView) parentView.findViewById(R.id.textView_day);
            mTvDegree= (TextView) parentView.findViewById(R.id.textView_degree);
            mImgItemImage = (ImageView) parentView.findViewById(R.id.imageView1);
        }
    }
}
