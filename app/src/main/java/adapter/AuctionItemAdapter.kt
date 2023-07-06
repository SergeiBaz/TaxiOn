package adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Auction
import com.example.taxion.databinding.FragmentAuctionItemBinding
import com.google.gson.Gson


class AuctionItemAdapter : RecyclerView.Adapter<AuctionItemAdapter.AuctionViewHolder>() {
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
            candidateIdCollection.text = auction.candidateIdCollection.joinToString()
        }
    }

    fun setAuctions(auctionList: List<Auction>) {
        this.auctionList = auctionList
        notifyDataSetChanged()
    }

    class AuctionViewHolder(val binding: FragmentAuctionItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}