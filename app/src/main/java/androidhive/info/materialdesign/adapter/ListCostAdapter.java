package androidhive.info.materialdesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidhive.info.materialdesign.R;
import androidhive.info.materialdesign.activity.Cost;
import androidhive.info.materialdesign.activity.FriendsFragment;

/**
 * Created by Android1 on 7/9/2015.
 */

public class ListCostAdapter extends BaseAdapter {

    Context context;

    protected List<Cost> listCosts;
    LayoutInflater inflater;

    public ListCostAdapter(Context context, List<Cost> listCosts) {
        this.listCosts = listCosts;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public int getCount() {
        return listCosts.size();
    }

    public Cost getItem(int position) {
        return listCosts.get(position);
    }

    public long getItemId(int position) {
        return listCosts.get(position).getDrawableId();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.layout_list_item,
                    parent, false);

            holder.txtModel = (TextView) convertView
                    .findViewById(R.id.txt_car_model);
            holder.txtColor = (TextView) convertView
                    .findViewById(R.id.txt_car_color);
            holder.txtPrice = (TextView) convertView
                    .findViewById(R.id.txt_car_price);
            holder.imgCost = (ImageView) convertView.findViewById(R.id.img_car);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Cost Cost = listCosts.get(position);
        holder.txtModel.setText(Cost.getModel());
        holder.txtColor.setText(Cost.getColor());
        holder.txtPrice.setText(Cost.getPrice() + " $ ");
        holder.imgCost.setImageResource(Cost.getDrawableId());

        return convertView;
    }

    private class ViewHolder {
        TextView txtModel;
        TextView txtColor;
        TextView txtPrice;
        ImageView imgCost;
    }

}
