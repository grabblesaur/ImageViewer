package ru.bayar.bogdanov.imageviewer.ui.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import ru.bayar.bogdanov.imageviewer.R;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<String> mLinkList;

    public ImageAdapter() {
        mLinkList = new ArrayList<>();
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
        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onBind(String link) {
            // TODO: 31.08.2017 USE GLIDE MTHFOSKCKER
        }
    }
}
