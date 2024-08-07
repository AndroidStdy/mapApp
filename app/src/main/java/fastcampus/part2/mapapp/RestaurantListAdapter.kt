package fastcampus.part2.mapapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naver.maps.geometry.LatLng
import fastcampus.part2.mapapp.databinding.ItemRestaurantBinding

class RestaurantListAdapter(private val onClick:(LatLng) -> Unit): RecyclerView.Adapter<RestaurantListAdapter.ViewHolder>() {

    private var dataSet = emptyList<SearchItem>()

    inner class ViewHolder(private val binding: ItemRestaurantBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: SearchItem){
            binding.tvTitle.text = item.title
            binding.tvCategory.text = item.category
            binding.tvLocation.text = item.roadAddress

            binding.root.setOnClickListener {
                onClick(LatLng(item.mapx.toDouble() / 10000000, item.mapy.toDouble() / 10000000))

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])

    }
    @SuppressLint("NotifyDataSetChanged")
    fun setData(dataSet: List<SearchItem>){
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

}