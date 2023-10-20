package presentation.fragments.passenger_auction_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.DriversOffer
import com.example.taxion.databinding.FragmentItemOfferDriverBinding

class DriverOfferItemAdapter :
    RecyclerView.Adapter<DriverOfferItemAdapter.DriverOfferViewHolder>() {

    private var driversOfferList: List<DriversOffer> = ArrayList()

    class DriverOfferViewHolder(val binding: FragmentItemOfferDriverBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverOfferViewHolder {
        val binding = FragmentItemOfferDriverBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return DriverOfferViewHolder(binding)
    }

    override fun getItemCount(): Int = driversOfferList.size

    override fun onBindViewHolder(holder: DriverOfferViewHolder, position: Int) {
        val driverOffer = driversOfferList[position]
        with(holder.binding) {
            brandCarTextView.text = driverOffer.auto.toString()
            nameDrivertextView.text = driverOffer.user.name
            ratingNumberTextView.text = driverOffer.user.rating
            numberVotesTextView.text = driverOffer.user.numberVotes
            priceTripTextView.text = TODO("Цена поездки нужна тут")
        }
    }

    fun setDriversOffer(driversOfferList: List<DriversOffer>) {
        this.driversOfferList = driversOfferList
        notifyDataSetChanged()
    }
}