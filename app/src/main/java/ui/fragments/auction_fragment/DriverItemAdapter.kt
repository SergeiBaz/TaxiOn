package ui.fragments.auction_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.taxion.databinding.FragmentDriverItemBinding

class DriverItemAdapter : RecyclerView.Adapter<DriverItemAdapter.DriverViewHolder>() {
    private var drivers: List<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val binding = FragmentDriverItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return DriverViewHolder(binding)
    }

    override fun getItemCount(): Int = drivers.size

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        val driver = drivers[position]
        with(holder.binding) {
            textViewDriverName.text = driver
        }
    }

    fun setDrivers(driverList: List<String>) {
        this.drivers = driverList
        notifyDataSetChanged()
    }

    class DriverViewHolder(val binding: FragmentDriverItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}