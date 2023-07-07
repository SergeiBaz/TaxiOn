package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Auction
import com.example.taxion.R
import com.example.taxion.databinding.FragmentAuctionItemBinding

class AuctionItemAdapter(val listener: Listener) :
    RecyclerView.Adapter<AuctionItemAdapter.AuctionViewHolder>() {
    private var auctionList: List<Auction> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuctionViewHolder {
        val binding = FragmentAuctionItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return AuctionViewHolder(binding)
    }

    override fun getItemCount(): Int = auctionList.size

    override fun onBindViewHolder(holder: AuctionViewHolder, position: Int) {
        val auction = auctionList[position]
        with(holder.binding) {
            idAuction.text = auction.id.toString()
            passengerId.text = auction.passengerId
            fromStreet.text = auction.from.street
            toStreet.text = auction.to.street
        }
        holder.itemView.setOnClickListener(View.OnClickListener() {
            listener.onClick(auction)
        })
    }

    fun setAuctions(auctionList: List<Auction>) {
        this.auctionList = auctionList
        notifyDataSetChanged()
    }

    interface Listener {
        fun onClick(auction: Auction)
    }

    class AuctionViewHolder(val binding: FragmentAuctionItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}