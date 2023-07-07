package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Driver

import com.example.taxion.databinding.FragmentDriverItemBinding

class DriverItemAdapter : RecyclerView.Adapter<DriverItemAdapter.DriverViewHolder>() {
    private var drivers: List<Driver> = ArrayList()


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
            textViewDriverName.text = driver.user.name
            textViewDriverAvto.text = driver.user.id.toString()
        }
    }

    fun setDrivers(driverList: List<Driver>) {
        this.drivers = driverList
        notifyDataSetChanged()
    }

    class DriverViewHolder(val binding: FragmentDriverItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
