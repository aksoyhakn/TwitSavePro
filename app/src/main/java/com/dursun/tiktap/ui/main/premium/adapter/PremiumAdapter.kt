package com.dursun.tiktap.ui.main.premium.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dursun.tiktap.R
import com.dursun.tiktap.databinding.ItemPremiumBinding
import com.dursun.tiktap.extensions.isNotNull
import com.dursun.tiktap.extensions.setSafeOnClickListener
import com.dursun.tiktap.ui.main.premium.model.Premium


class PremiumAdapter(
    val premiumList: ArrayList<Premium>,
    val listener: ListenerPremium
) : RecyclerView.Adapter<PremiumAdapter.PremiumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PremiumViewHolder {
        return PremiumViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_premium,
                parent,
                false
            )
        ) { eventItem ->
            listener.clickPremium(eventItem)
        }
    }

    override fun getItemCount(): Int = premiumList.size

    override fun onBindViewHolder(holder: PremiumViewHolder, position: Int) {
        holder.bindData(premiumList[position], position)
    }

    class PremiumViewHolder(
        var binding: ItemPremiumBinding,
        val onClick: (Premium) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(premium: Premium, position: Int) {
            binding.item = premium
            binding.clLayout.setSafeOnClickListener {
                onClick(premium)
            }
            binding.executePendingBindings()
        }
    }

    companion object {

        @JvmStatic
        @BindingAdapter(value = ["bind:setPremiumData", "bind:setPremiumListener"])
        fun setPremiumData(
            view: RecyclerView,
            data: ArrayList<Premium>?,
            listener: ListenerPremium
        ) {
            if (data.isNotNull()) {
                view.adapter =
                    PremiumAdapter(
                        (data as ArrayList<Premium>),
                        listener
                    )
            }
        }

    }

    interface ListenerPremium {
        fun clickPremium(item: Premium)
    }

}