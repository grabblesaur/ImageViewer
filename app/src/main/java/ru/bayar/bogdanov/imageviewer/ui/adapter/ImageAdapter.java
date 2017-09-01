package ru.bayar.bogdanov.imageviewer.ui.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.bayar.bogdanov.imageviewer.R;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private static final String TAG = ImageAdapter.class.getName();

    private List<String> mLinkList;
    private Context mContext;

    public ImageAdapter(Context context) {
        mLinkList = new ArrayList<>();
        mContext = context;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        holder.onBind(mLinkList.get(position));
    }

    @Override
    public int getItemCount() {
        return mLinkList.size();
    }

    public void onLinksAdded(List<String> links) {
        mLinkList.addAll(links);
        notifyItemRangeInserted(0, mLinkList.size());
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_iv)
        ImageView mImageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onBind(String link) {
            Picasso.with(mContext)
                    .load(link)
                    .into(mImageView);
        }
    }
}
